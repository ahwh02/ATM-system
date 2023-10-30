package ATM;


import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;


public class Menu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'£'###,##0.00");
    HashMap<Integer, UserAccount> data = new HashMap<Integer, UserAccount>();
    
    public void getLogin() {
        boolean end = false;
        int customerNumber = 0;
        int pin = 0;
        
        while (!end) {
            try {
                System.out.println("\nEnter customer number: ");
                customerNumber = menuInput.nextInt();
                System.out.println("Enter PIN: ");
                pin = menuInput.nextInt();
                
                Iterator it = data.entrySet().iterator();
                
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    UserAccount acc = (UserAccount) pair.getValue();
                    if (data.containsKey(customerNumber) && pin == acc.getPin()) {
                        getAccountType(acc);
                        end = true;
                        break;
                    }
                }
                
                if (!end) {
                    System.out.println("\nIncorrect Customer Number or PIN entered.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter only numbers.");
            }
        }
        
    }
    
    public void createAccount() {
        int customerNumber = 0;
        boolean end = false;
	while (!end) {
            try {
		System.out.println("\nEnter customer number: ");
		customerNumber = menuInput.nextInt();
		Iterator it = data.entrySet().iterator();
		
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                }
                
                if (!data.containsKey(customerNumber)) {
			end = true;
		}
                
                if (!end) {
                    System.out.println("\nThis customer number is already registered.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
	}
        
	System.out.println("\nEnter PIN to be registered: ");
	int pin = menuInput.nextInt();
	data.put(customerNumber, new UserAccount(customerNumber, pin));
	System.out.println("\nYour new account has been successfuly registered.");
	System.out.println("\nRedirecting to login.............");
	getLogin();
    }
    
    public void getAccountType(UserAccount acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSelect the account you wish to access: ");
                System.out.println("1. Current Account");
                System.out.println("2. Savings Account");
                System.out.println("3. Exit");
                System.out.println("\nChoice (Type 1, 2 or 3): ");
                
                int choice = menuInput.nextInt();
                
                switch (choice) {
                case 1:
                   getCurrentAccount(acc);
                   break;
                
                case 2:
                    getSavingsAccount(acc);
                    break;
                
                case 3:
                    end = true;
                    break;
                    
                default:
                    System.out.println("\nInvalid Choice.");
                    break;
                }
                        
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                menuInput.next();
            }
        }
    }
    
    public void getCurrentAccount(UserAccount acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Account: ");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Exit");
                System.out.println("Choice (Type 1, 2, 3, 4 or 5): ");
                
                int choice = menuInput.nextInt();
                
                switch(choice) {
                case 1:
                    System.out.println("\nCurrent Account Balance: " + moneyFormat.format(acc.getCurrentAccountBalance()));
                    break;
                             
                case 2:
                    acc.getCurrentAccountWithdrawalInput();
                    break;
                     
                case 3:
                    acc.getCurrentAccountDepositInput();
                    break;
                    
                case 4:    
                    acc.getCurrentToSavingsTransferInput();
                    break;
                    
                case 5:
                    end = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
                    break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                menuInput.next();
            }
        }
    }
    
    public void getSavingsAccount(UserAccount acc) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Exit");
                System.out.println("Choice (Type 1, 2, 3, 4 or 5): ");
                
                int choice = menuInput.nextInt();
                
                switch(choice) {
                case 1:
                    System.out.println("\nSavings Account Balance: " + moneyFormat.format(acc.getSavingsAccountBalance()));
                    break;
                             
                case 2:
                    acc.getSavingsAccountWithdrawalInput();
                    break;
                     
                case 3:
                    acc.getSavingsAccountDepositInput();
                    break;
                    
                case 4:    
                    acc.getSavingsToCurrentTransferInput();
                    break;
                    
                case 5:
                    end = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
                    break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice.");
                menuInput.next();
            }
        }
    }
    
    public void mainMenu() {
        data.put(123, new UserAccount(123, 321, 10000, 15000));
	boolean end = false;
	
        while (!end) {
			try {
				System.out.println("\n Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.print("\nChoice: ");
				int choice = menuInput.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					end = true;
					break;
				case 2:
					createAccount();
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
                                
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}      
		}
		
        System.out.println("\nThank You for using this ATM.\n");
	menuInput.close();
	System.exit(0);  
    }
}