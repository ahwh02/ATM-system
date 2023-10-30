package ATM;


import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;


public class UserAccount {
    
    private int customerNumber;
    private int pin;
    private double currentAccountBalance = 0;
    private double savingsAccountBalance = 0;
    
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00");
    
    public UserAccount() {
    
    }
    
    public UserAccount(int customerNumber, int pin) {
        this.customerNumber = customerNumber;
        this.pin = pin;
    }
    
    public UserAccount(int customerNumber, int pin, double currentAccount, double savingsAccount) {
        this.customerNumber = customerNumber;
        this.pin = pin;
        this.currentAccountBalance = currentAccount;
        this.savingsAccountBalance = savingsAccount;
    }
    
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return this.customerNumber;
    }
    
    public int getCustomerNumber() {
        return this.customerNumber;
    }
    
    public int setPin(int pin) {
        this.pin = pin;
        return this.pin;
    }
    
    public int getPin() {
        return this.pin;
    }
    
    public double getCurrentAccountBalance() {
        return this.currentAccountBalance;
    }
    
    public double getSavingsAccountBalance() {
        return this.savingsAccountBalance;
    }
    
    public void currentAccountWithdrawal(double amount) {
        this.currentAccountBalance = this.currentAccountBalance - amount;
    }
    
    public void savingsAccountWithdrawal(double amount) {
        this.savingsAccountBalance = this.savingsAccountBalance - amount;
    }
    
    public void currentAccountDeposit(double amount) {
        this.currentAccountBalance = this.currentAccountBalance + amount;
    }
    
    public void savingsAccountDeposit(double amount) {
        this.savingsAccountBalance = this.savingsAccountBalance + amount;
    }
    
    public void transferCurrentToSavings(double amount) {
        this.currentAccountBalance = this.currentAccountBalance - amount;
        this.savingsAccountBalance = this.savingsAccountBalance + amount;
    }
    
    public void transferSavingsToCurrent(double amount) {
        this.savingsAccountBalance = this.savingsAccountBalance - amount;
        this.currentAccountBalance = this.currentAccountBalance + amount;
    }
    
    public void getCurrentAccountWithdrawalInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Account Balance: " + moneyFormat.format(currentAccountBalance));
                System.out.println("\nAmount to withdraw: ");
                double amount = input.nextDouble();
                
                if ((currentAccountBalance - amount) >= 0 && amount >= 0) {
                    currentAccountWithdrawal(amount);
                    System.out.println("\nCurrent Account Balance: " + moneyFormat.format(currentAccountBalance));
                    end = true;
                    
                } else if (amount < 0) {
                    System.out.println("\nWithdrawal amount cannot be negative.");
                    
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            } 
        } 
    }
    
    public void getSavingsAccountWithdrawalInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account Balance: " + moneyFormat.format(savingsAccountBalance));
                System.out.println("\nAmount to withdraw: ");
                double amount = input.nextDouble();
                
                if ((savingsAccountBalance - amount) >= 0 && amount >= 0) {
                    savingsAccountWithdrawal(amount);
                    System.out.println("\nCurrent Account Balance: " + moneyFormat.format(savingsAccountBalance));
                    end = true;
                    
                } else if (amount < 0) {
                    System.out.println("\nWithdrawal amount cannot be negative.");
                    
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            } 
        }   
    }
    
    public void getCurrentAccountDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Account Balance: " + moneyFormat.format(currentAccountBalance));
                System.out.println("\nAmount to deposit: ");
                double amount = input.nextDouble();
                
                if ((currentAccountBalance + amount) >= 0 && amount >= 0) {
                    currentAccountDeposit(amount);
                    System.out.println("\nCurrent Account Balance: " + moneyFormat.format(currentAccountBalance));
                    end = true;
                    
                } else if (amount < 0) {
                    System.out.println("\nAmount to deposit cannot be negative.");
                    
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            } 
        }
    }
    
    public void getSavingsAccountDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account Balance: " + moneyFormat.format(savingsAccountBalance));
                System.out.println("\nAmount to deposit: ");
                double amount = input.nextDouble();
                
                if ((savingsAccountBalance + amount) >= 0 && amount >= 0) {
                    savingsAccountDeposit(amount);
                    System.out.println("\nSavings Account Balance: " + moneyFormat.format(savingsAccountBalance));
                    end = true;
                    
                } else if (amount < 0) {
                    System.out.println("\nAmount to deposit cannot be negative.");
                    
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            } 
        }
    }
    
    public void getCurrentToSavingsTransferInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSelect an account to transfer funds to:");
                System.out.println("1. Savings");
                System.out.println("2. Exit");
                System.out.println("\nChoice (Enter 1 for Savings or 2 to Exit): ");
                int choice = input.nextInt();
                
                switch (choice) {
                case 1:
                    System.out.println("\nCurrent Account Balance: " + moneyFormat.format(currentAccountBalance));
                    System.out.println("Amount you want to transfer to Savings Account: ");
                    double amount = input.nextInt();
                    if ((currentAccountBalance - amount >= 0)&&(amount>= 0)) {
                        transferCurrentToSavings(amount);
                    } else if (amount < 0) {
                        System.out.println("Amount to transfer cannot be negative.");
                        break;
                    } else {
                        System.out.println("\nBalance cannot be negative.");
                    }
                    break;

                case 2:
                    return;

                default:
                    System.out.println("\nInvalid choice.");
                    break;
                
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            }
        }
    }
    
    public void getSavingsToCurrentTransferInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSelect an account to transfer funds to:");
                System.out.println("1. Current");
                System.out.println("2. Exit");
                System.out.println("\nChoice (Enter 1 for Current or 2 to Exit): ");
                int choice = input.nextInt();
                
                switch (choice) {
                case 1:
                    System.out.println("\nSavings Account Balance: " + moneyFormat.format(savingsAccountBalance));
                    System.out.println("Amount you want to transfer to Current Account: ");
                    double amount = input.nextInt();
                    if ((savingsAccountBalance - amount >= 0)&&(amount>= 0)) {
                        transferSavingsToCurrent(amount);
                    } else if (amount < 0) {
                        System.out.println("Amount to transfer cannot be negative.");
                        break;
                    } else {
                        System.out.println("\nBalance cannot be negative.");
                    }
                    break;

                case 2:
                    end = true;
                    break;

                default:
                    System.out.println("\nInvalid choice.");
                    break;
                
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                input.next();
            }
        }
    }       
}