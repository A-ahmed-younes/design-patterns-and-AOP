package ma.enset;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.model.BankDirector;
import ma.enset.model.Customer;
import ma.enset.repository.AccountRepository;
import ma.enset.repository.AccountRepositoryImpl;
import ma.enset.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        //Singleton
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(accountRepository::populateData).start();
        }
        System.out.println("Please type a character");
        System.in.read();
        List<BankAccount> bankAccounts = accountRepository.findAll();
        System.out.println("Showing all accounts");
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);


        System.out.println("Looking for an account by the id 10");
        accountRepository.findById(10L)
                .map(bankAccountJsonSerializer::toJson)
                .ifPresentOrElse(System.out::println, () -> System.out.println("Account not found"));


        System.out.println("Looking for all savings accounts that are blocked");
        List<BankAccount> searchAccounts = accountRepository.searchAccounts(bankAccount -> bankAccount.getAccountStatus().equals(AccountStatus.BLOCKED) && bankAccount.getAccountType().equals(AccountType.SAVINGS_ACCOUNT));

        searchAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);


        System.out.println("Creating a new account using the prototype pattern");
        BankAccount newAccount = accountRepository.findById(1L).get();
        newAccount.setCustomer(new Customer(1L, "Tarik"));
        BankAccount newAccount2 = newAccount.clone();
        System.out.println("newAccount: " + bankAccountJsonSerializer.toJson(newAccount));
        System.out.println("newAccount2: " + bankAccountJsonSerializer.toJson(newAccount2));

        BankAccount account = BankDirector.accountBuilder()
                .accountId(1L)
                .balance(460)
                .currency("EUR")
                .accountType(AccountType.CURRENT_ACCOUNT)
                .accountStatus(AccountStatus.CREATED)
                .build();

        account.setCustomer(new Customer(1L, "Ahmed"));

        BankAccount cloned = account.clone();
        System.out.println("account: " + account);
        System.out.println("cloned: " + cloned);

        account.getCustomer().setName("Oussama");
        System.out.println("account: " + account);
        System.out.println("cloned: " + cloned);


    }
}
