
import java.util.HashMap;
import java.util.Random;
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
public class Student {
    private final String firstName;
    private final String lastName;
    private final String grade;
    private final String studentID;
    private HashMap<String,Boolean> courses=new HashMap<String,Boolean>();
    private float Balance=120000;
    private float costOfCourse = 600;
    private String status = "";
    
    
    // constructor prompts user to enter name and grade
    public Student(){
        Scanner scan = new Scanner(System.in);
        System.out.print("First Name : ");
        this.firstName=scan.nextLine();
        System.out.print("Last Name : ");
        this.lastName=scan.nextLine();
        System.out.print("Grade (1 : freshman, 2: sophomore, 3: Junior, 4: Senior) :");
        this.grade=scan.nextLine();
        this.studentID= this.generateStudentID();
        this.status="New student";
        
    }
    
    //generate studentID - 5digits first number their grade level
    private String generateStudentID(){
        Random idBody = new Random(); 
        return this.grade + Integer.toString(idBody.nextInt(10000));   
    }
    
    //enroll in course courses (can be History 101 Mathematics 101 English 101 Chemistry 101 CS 101
    public void inrollInCourse(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Courses availables : \n History 101 \n Mathematics 101 \n English 101 \n Chemistry 101 \nComputer Science 101.\n"
                + "Which course do you want to inroll in? (enter blank to finish)");
        while (scan.nextLine().isBlank()==false){
            String course = scan.nextLine();
            this.courses.put(course, false);
        }
        this.status="tuition not paid";
    }
    
    //pay tuitution
    public void payTuition(){
        System.out.println("tuition full cost : "+ Float.toString(this.courses.size()*this.costOfCourse));
        System.out.print("proceed to pay? (Yes/No): ");
        Scanner scan = new Scanner(System.in);
        if ( scan.nextLine().toLowerCase().contentEquals("yes")){
            for(HashMap.Entry<String,Boolean> entry : this.courses.entrySet()){
                if (entry.getValue()==false){
                    if (this.Balance >= this.costOfCourse ) {
                        this.Balance-=this.costOfCourse;
                        entry.setValue(Boolean.TRUE);
                        System.out.println("Pay succeeded.");
                    }
                    else {
                        System.out.println("Balance insufficient.");
                        break;
                    }
                }
        
            }
        this.status ="tuition fully paid.";
       
    }
        else { 
                    System.out.println("Aborted.");
                    }  
    }
    
    //get balance
    public float getBalance(){
        return this.Balance;
    } 
    
    //get courses unrolled in
    public String getCourseInrolledIn(){
        String strCoursesList="";
        for (HashMap.Entry <String,Boolean> entry : this.courses.entrySet()){
            strCoursesList += " "+entry.getKey();
        }
        
        return strCoursesList;
    }
    
    //get name
    public String getName(){
        return this.firstName+" "+this.lastName;
    }
    
    //get ID
    public String getID(){
        return this.studentID;
    }
    
    //getStatus 
    public String getStatus(){
        return this.status;
    }
    
    //getFullStatus (returns, name, id, curses and balance)
    public void getFullStatus(){
        System.out.println("Name: "+this.getName()+"\n StudentID: "+this.getID()
        +"\n Courses inrolled in : "+this.getCourseInrolledIn()+"\n Status: "+this.getStatus()
        +"\n Balance: "+this.getBalance());
    }
    
}
