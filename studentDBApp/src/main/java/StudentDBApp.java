
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
public class StudentDBApp {
    public static void main(String args[]){
        //ask how many new students we want to add
        System.out.print("How many students d you want to add? ");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Student[] std = new Student[N];
        
        //create n numbers of students
        for (int i=0; i<N; i++){
            std[i] = new Student();
            std[i].inrollInCourse();
            std[i].payTuition();
        }
        
        
        //get status of student
    }
    
}
