public class Acccount {
    private String username;
    private float balance=0;

    public String getUsername() {
        return username;
    }

    public float getBalance() {
        return balance;
    }

    public Acccount(String username)
    {
        this.username=username;

    }
    //method for cash depositing
    public void depositCash(float cash){
        this.balance=this.balance+cash;
    }
    //method for cash withdrawing
    public void withdrawCash(float cash){
        if (this.balance<=0){
            System.out.println("Insuffientfund");
        }
        else {
            this.balance = this.balance - cash;
        }
    }
}
