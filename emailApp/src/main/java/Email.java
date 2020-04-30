
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
public class Email {
    private String firstName;
    private String lastName;
    private String departement;
    private String companyName="company";
    private char[] password;
    private int passwordLength=10;
    private int mailBoxCapacity;
    private String emailAdress;
    
    //constructor takes firstName and lastName -returns alternateEmailAdress
    public Email(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName = lastName;
        
        //set departement
        this.departement = setDepartement();
        System.out.println("name :"+this.firstName+" "+this.lastName);
        System.out.println("departement : "+this.departement);
        //create email adress
        this.emailAdress= setEmailAdress();
         //generate random password
        this.password= setRandomPassword(this.passwordLength);
        System.out.println(this.emailAdress);
        System.out.println(this.password);
        
    }
    
    private String setDepartement(){
        System.out.print("Enter departement code.\n1 for sales \n2 for development \n3 for accounting"
                + "\n0 for none.\n departement code: ");
        Scanner scan = new Scanner(System.in);
        int deptChoice = scan.nextInt();
        switch(deptChoice){
            
            case 1 : return "sales";
            case 2 : return "dev";
            case 3 : return "account";
            default : return "";
        }
        
    } 
    
    private char[] setRandomPassword(int passwordLength){
        String passwordDictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789#%&*-_";
        char[] password= new char[passwordLength];
        for (int i=0;i<passwordLength;i++){
            int rand = (int)(Math.random()*passwordDictionary.length());
            password[i]= passwordDictionary.charAt(rand);    
        }
        
        return password;
    }
    
    private String setEmailAdress(){
        String emailAdress = this.firstName.toLowerCase() + "."+this.lastName.toLowerCase()+"@"+this.departement+"."
+this.companyName+".com";
        return emailAdress;    }
    

//set passwordLength
    public void setpasswordLength(int length){
        this.passwordLength=length;
    }
    
//set companyName
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }
    
//set mailBoxCapacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity=capacity;
    }
    
//change password
    public void changePassword(char[] newPassword){
        this.password=newPassword;
    }

//get first name and last name
    public String getName(){
        return this.firstName + " "+ this.lastName;
    }
//getEmail
    public String getEmailAdress(){
        return this.emailAdress;
    }
 
//getPassword
    public char[] getPassword(){
        return this.password;
    }
}
