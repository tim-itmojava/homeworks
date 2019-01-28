package assignment_bank;

public class BankTest {

    public static void main(String[] args) {

        Account source = new Account(34567765, 1000);
        Account target = new Account(98567456, 2000);

        new MoneyTransfer(source, target, 500).run();

    }
}
