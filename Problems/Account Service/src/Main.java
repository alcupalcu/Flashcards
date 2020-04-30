// Posted from EduTools plugin
interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {

    Account[] accounts;

    AccountServiceImpl(Account[] accounts) {
        this.accounts = new Account[accounts.length];
        for(int i = 0; i < accounts.length; i++) {
            this.accounts[i] = accounts[i];
        }
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        Account resultAccount = null;
        for (int i = 0; i < this.accounts.length; i++) {
            if(this.accounts[i].getOwner().getId() == id) {
                resultAccount = this.accounts[i];
                break;
            }
        }
        return resultAccount;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long counter = 0L;
        for(int i = 0; i < this.accounts.length; i++) {
            if(this.accounts[i].getBalance() > value) {
                counter++;
            }
        }
        return counter;
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() { 
        return id; 
    }

    public long getBalance() { 
        return balance; 
    }

    public User getOwner() { 
        return owner; 
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() { 
        return id; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
}