public class Bank_Account {
    public final long acct_num;
    private double balance;
    private String type;
    private float interest_rate;

    Bank_Account(long acct, double bal, String ty, float interest) {
        acct_num = acct;
        balance = bal;
        type = ty;
        interest_rate = interest;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public boolean withdrawal(double amt) {
        if (balance - amt < 0)
            return false;
        balance -= amt;
        return true;
    }

    public void applyInterest() {
        withdrawal(getBalance() * interest_rate);
    }
} //Evaluation.Bank_Account class
