import java.util.Scanner;

public class ATM {
    private String username;
    private char loop = 'y';
    private int flag;
    private float cash;

    public ATM(String username) {
        this.username = username;
        Acccount acccount = new Acccount(username);
        // while loop for repeating transactions
        while (loop == 'y') {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose..1.for Cashwithdraw /n 2.for cashdeposit");

            flag = scanner.nextInt();
            // flag is used for option choosing
            if (flag == 1) {
                System.out.println("enter the cashwithdraw amount");
                cash = scanner.nextFloat();
                //calling withdrawcash method
                acccount.withdrawCash(cash);
            } else if (flag == 2) {
                System.out.println("enter the deposit amount");
                cash = scanner.nextFloat();
                //calling depositcash method
                acccount.depositCash(cash);

            } else {
                System.out.println("enter valid entry");

            }
            scanner.nextLine();
            System.out.println("Do you want to Repeat:");
            loop=scanner.nextLine().charAt(0);

        }


    }
}
