package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    double[] transactions = new double[1000];
    int freeIndex = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Invalid Deposit");
        }
        else{
            currentBalance += amount;
            transactions[freeIndex++] =  amount;
            System.out.println("Deposited " + amount + " from " + name +". New balance is " + currentBalance);
        }
    }

    public void withdraw(double amount){
        if(amount<=0 || amount>currentBalance){
            System.out.println("Invalid Withdraw");
        }
        else{
            currentBalance -= amount;
            transactions[freeIndex++] =  -amount;
            System.out.println("Withdrawn " + amount + " from " + name +". New balance is " + currentBalance);
        }
    }

    public void displayTransactions(){
        for(int i=0; i<freeIndex; i++){
            System.out.print(transactions[i] + ", ");
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
