package ma.enset.model;

public class BankAccount implements Cloneable {
    private Long accountId;
    private double balance;
    private String currency;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Customer customer;

    public BankAccount() {
        // Private constructor for the Builder pattern
    }

    // Builder
    public static class AccountBuilder {
        private BankAccount account = new BankAccount();

        public AccountBuilder accountId(Long id) {
            account.accountId = id;
            return this;
        }

        public static AccountBuilder builder() {
            return new AccountBuilder();
        }

        public AccountBuilder balance(double balance) {
            account.balance = balance;
            return this;
        }

        public AccountBuilder currency(String currency) {
            account.currency = currency;
            return this;
        }

        public AccountBuilder accountType(AccountType accountType) {
            account.accountType = accountType;
            return this;
        }

        public AccountBuilder accountStatus(AccountStatus accountStatus) {
            account.accountStatus = accountStatus;
            return this;
        }

        public BankAccount build() {
            // Prototype
            BankAccount newAccount = new BankAccount();
            newAccount.accountId = account.accountId;
            newAccount.balance = account.balance;
            newAccount.currency = account.currency;
            newAccount.accountType = account.accountType;
            newAccount.accountStatus = account.accountStatus;
            return newAccount;
        }
    }

    //Singleton
    private static final BankAccount instance = new BankAccount();


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                ", customer=" + customer +
                '}';
    }

    public Long getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public BankAccount clone() throws CloneNotSupportedException {
        BankAccount bankAccount = (BankAccount) super.clone();
        bankAccount.setCustomer(this.customer.clone());
        return bankAccount;
    }
}
