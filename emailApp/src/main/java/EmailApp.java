
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class EmailApp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scan.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scan.nextLine();
        
        
        Email email1 = new Email(firstName, lastName);
        System.out.println(email1.getPassword());
    }
    
}
