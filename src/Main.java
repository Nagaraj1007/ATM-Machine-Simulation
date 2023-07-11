// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String insufficientFundsException){
        super(insufficientFundsException);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String enteredAmountIsTooSmall) {
        super(enteredAmountIsTooSmall);
    }
}

class BalanceAmount {
    private int balance ;

    int getBalance(){
        return balance;
    }

    void setBalance(int balance){
        this.balance = balance;
    }


}

public class Main {
    public static int withdraw(int amount , int balance) throws InsufficientFundsException, InvalidAmountException {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Entered Amount is too small");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Entered Amount for withdrawal is higher than your balance...");
            } else {
                balance -= amount;
                System.out.println("Withdrawal is successful and your balance is " + balance);
            }
        }
        catch (InsufficientFundsException insufficientFundsException){
            System.out.println(insufficientFundsException);
        }
        return balance;
    }

    public static int deposit(int amount , int balance) throws InvalidAmountException {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Entered Amount is too small");
            } else {
                balance += amount;
                System.out.println("Deposited Successfully... Current Balance is " + balance);
            }
        }
        catch (InvalidAmountException invalidAmountException){
            System.out.println(invalidAmountException);
        }

        return balance;
    }

    public static void main(String[] args) throws InsufficientFundsException, InvalidAmountException {
        BalanceAmount balanceObject = new BalanceAmount();
        balanceObject.setBalance(50000);
        Scanner userRequest = new Scanner(System.in);
        int userInput;
        int amount = 0;
        do {
            System.out.println("Enter 1 for Withdrawal, 2 for Deposit, 3 for Checking balance and 4 to Exit ");
            userInput = userRequest.nextInt();
            switch(userInput) {

                case 1 :{
                    if ( balanceObject.getBalance() == 0 ){
                        System.out.println("No amount to withdraw... Try other options");
                    }else {
                        System.out.println("Enter amount for withdrawal :");
                        amount = userRequest.nextInt();
                        balanceObject.setBalance(withdraw(amount, balanceObject.getBalance()));
                    }
                    break;
                }
                case 2 :{
                    System.out.println("Enter amount for deposit :");
                    amount = userRequest.nextInt();
                    balanceObject.setBalance(deposit(amount, balanceObject.getBalance()));
                    break;
                }
                case 3 :{
                    System.out.println("Your Balance is : " + balanceObject.getBalance());
                    break;
                }
                case 4 :{
                    System.out.println("Thank you visit again :) ");
                    break;
                }
            }
        }
        while (userInput != 4);
    }
}