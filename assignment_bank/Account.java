package assignment_bank;

public class Account {

    private int accountId;
    private int accountBalance;

    public Account(int accountId, int accountBalance) {
        this.accountId = accountId;
        this.accountBalance = accountBalance;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
