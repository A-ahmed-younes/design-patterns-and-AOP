package ma.enset.repository;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.model.BankDirector;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    private static final AccountRepositoryImpl accountReposiroty;

    static {
        System.out.println("Singleton instantiation");
        accountReposiroty = new AccountRepositoryImpl();
    }

    private AccountRepositoryImpl() {}
    private Map<Long, BankAccount> bankAccountMap= new HashMap<>();
    private long accountCount = 0;
    @Override
    public synchronized BankAccount save(BankAccount bankaccount) {
        Long accountId = ++accountCount;
        bankaccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankaccount);
        return bankaccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return new ArrayList<>(bankAccountMap.values());
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
        if (account == null)
            return Optional.empty();
        else
            return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount bankaccount) {
        bankAccountMap.put(bankaccount.getAccountId(), bankaccount);
        return bankaccount;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);

    }

    public void populateData() {
        for (int i = 0; i < 10; i++) {
            BankAccount account = BankDirector.accountBuilder()
                    .balance(1000+Math.random()*100)
                    .accountType(Math.random()>0.5? AccountType.SAVINGS_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .accountStatus(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5? "USD":"EUR")
                    .build();
            save(account);

        }
        System.out.println("==========================================");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count : " + accountCount);
        System.out.println("Size : " + bankAccountMap.values().size());
        System.out.println("==========================================");
    }

    public static AccountRepositoryImpl getInstance() {
        return accountReposiroty;
    }
}
