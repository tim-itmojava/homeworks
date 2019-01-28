package assignment_bank;

public class MoneyTransfer extends Thread {

    private Account source;
    private Account target;

    private int transAmount;

    public MoneyTransfer(Account source, Account target, int transAmount) {
        this.source = source;
        this.target = target;
        this.transAmount = transAmount;
    }

    @Override
    public void run() {

        Account temp_source;
        Account temp_target;

        if (source.getAccountId() < target.getAccountId()) {
            temp_source = source;
            temp_target = target;
        }
        else {
            temp_source = target;
            temp_target = source;
        }

        synchronized (temp_source) {
            synchronized (temp_target) {
                double balanceSource = temp_source.getAccountBalance();

                if(balanceSource < transAmount) {
                    System.out.println("Insufficient funds on the source account: " + temp_source.getAccountBalance());
                }
                else {
                    temp_source.setAccountBalance(temp_source.getAccountBalance() - this.transAmount);
                    temp_target.setAccountBalance(temp_target.getAccountBalance() + this.transAmount);
                    System.out.println("Transfer details:");
                    System.out.println("===================================================");
                    System.out.println("Account ID: " + temp_source.getAccountId() + " ===> " +
                                        "Account ID: " + temp_target.getAccountId() + " transAmount: " + this.transAmount);
                    System.out.println("Final balances:");
                    System.out.println("===================================================");
                    System.out.println("Balance of Account ID: " + temp_source.getAccountId() + " = " + temp_source.getAccountBalance());
                    System.out.println("Balance of Account ID: " + temp_target.getAccountId() + " = " + temp_target.getAccountBalance());
                }

            }
        }


    }
}
