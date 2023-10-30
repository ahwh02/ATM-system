package ATM;


public class UserInterface {

	public static void main(String[] args) {
	    Menu menu = new Menu();
            introduction();
            menu.mainMenu();
	}
        
        public static void introduction() {
            System.out.println("Welcome, please follow the instructions below.");
        }
}
