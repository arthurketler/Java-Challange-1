import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = Menu.getMenu();
        
        int[] orderIndexes = new int[4];
        
        String optionString;
        char option, exitingChar = 'e', orderChar = 'o';
        int pattyIndex;
        int toppingsIndex;
        int drinkIndex;
        int sideIndex;
        
        // First menu system
        System.out.println("Order System");
        Utils.line();
        
        while (true) {
            // decide if it's going to make an orderChar
            System.out.printf("Type %c to orderChar or %c to exit%n", orderChar, exitingChar);
            
            // input from user
            optionString = sc.nextLine();
            option = optionString.charAt(0);
            
            // check if valid
            if (optionString.length() != 1 || (option != orderChar && option != exitingChar)) {
                System.out.println("Invalid entry, try again.");
                Utils.line();
                continue;
            }
            
            // check if exit
            if (option == exitingChar) {
                System.out.println("Shutting down...");
                break;
            }
            
            //---------------------------------------------//
            
            // prints the patties header
            Utils.line(30);
            System.out.println(Menu.printTitle('p'));
            {
                int ammount = menu.getP();
                for (int i = 0; i < ammount; i++) {
                    System.out.println(menu.getP(i).printItem(i));
                }
            }
            
            System.out.println("Enter the number of choice");
            while (true) {
                String option1String = sc.nextLine();
                int option1 = Integer.parseInt(option1String);
                
                if (option1String.length() != 1 || option1 < 1 || option1 > menu.getP()) {
                    System.out.println("Invalid Entry, try again.");
                    continue;
                }
                
                orderIndexes[0] = option1 - 1;
                
                break;
            }
            
            // print the toppings header
            Utils.line(30);
            System.out.println(Menu.printTitle('t'));
            {
                int ammount = menu.getT();
                for (int i = 0; i < ammount; i++) {
                    System.out.println(menu.getT(i).printItem(i));
                }
            }
            
            System.out.println("Enter the number of choice");
            while (true) {
                String option1String = sc.nextLine();
                int option1 = Integer.parseInt(option1String);
                
                if (option1String.length() != 1 || option1 < 1 || option1 > menu.getP()) {
                    System.out.println("Invalid Entry, try again.");
                    continue;
                }
                
                orderIndexes[1] = option1 - 1;
                
                break;
            }
            
            // print the drinks header
            Utils.line(30);
            System.out.println(Menu.printTitle('d'));
            {
                int ammount = menu.getD();
                for (int i = 0; i < ammount; i++) {
                    System.out.println(menu.getD(i).printItem(i));
                }
            }
            
            System.out.println("Enter the number of choice");
            while (true) {
                String option1String = sc.nextLine();
                int option1 = Integer.parseInt(option1String);
                
                if (option1String.length() != 1 || option1 < 1 || option1 > menu.getD()) {
                    System.out.println("Invalid Entry, try again.");
                    continue;
                }
                
                orderIndexes[2] = option1 - 1;
                
                break;
            }
            
            // print the sides header
            Utils.line(30);
            System.out.println(Menu.printTitle('s'));
            {
                int ammount = menu.getS();
                for (int i = 0; i < ammount; i++) {
                    System.out.println(menu.getS(i).printItem(i));
                }
            }
            
            System.out.println("Enter the number of choice");
            while (true) {
                String option1String = sc.nextLine();
                int option1 = Integer.parseInt(option1String);
                
                if (option1String.length() != 1 || option1 < 1 || option1 > menu.getS()) {
                    System.out.println("Invalid Entry, try again.");
                    continue;
                }
                
                orderIndexes[3] = option1 - 1;
                
                break;
            }
            
            // construct the order object
            Order order = new Order(menu.getP(orderIndexes[0]), menu.getT(orderIndexes[1]), menu.getD(orderIndexes[2]), menu.getS(orderIndexes[3]));
            
            // total
            Utils.line();
            
            order.calculateTotal();
            System.out.println(String.format("Your total is: %.2f", order.getTotal()));
            
            // wait for user entry
            System.out.println("When ready press enter to continue.");
            sc.nextLine();
            Utils.line();
        }
        
        
        
        
    }
}
