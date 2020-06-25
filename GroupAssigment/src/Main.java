
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Main {
    
    private static ArrayList<Student> stdList = new ArrayList<>();
    private static Manager manager = new Manager();
    
    private static void initial(){
        Student std;
        std = new Student("S001","Nguyen Van An","C/C+",1);
        stdList.add(std);
        std = new Student("S002","Truong Viet Vu",".Net+",3);
        stdList.add(std);
        std = new Student("S003","Le Thi Phuc",".Net",3);
        stdList.add(std);
        std = new Student("S001","Nguyen Van An","C/C+",2);
        stdList.add(std);
        std = new Student("S005","Le Thi Be","Java",1);
        stdList.add(std);
        std = new Student("S006","Ho Huu Cuong","Java",3);
        stdList.add(std);
        std = new Student("S003","Le Thi Phuc",".Net",2);
        stdList.add(std);
        std = new Student("S002","Truong Viet Vu","Java",2);
        stdList.add(std);
    }
    
    public static void main(String[] args) {
        initial();
        int choice;      
        do{
            choice=manager.Menu();
            switch(choice){
                case 1: 
                    manager.create(stdList);
                    break;
                case 2: 
                    System.out.print("Enter student name: ");
                    String stdName = Validation.checkInputString();
                    manager.findSort(stdList,stdName);
                    break;
                case 3: 
                    System.out.print("Enter student ID: ");
                    String id = Validation.checkInputID();
                    manager.updateDelete(stdList, id);
                    break;
                case 4: 
                    manager.report(stdList);
                    break;
            }
        }while(choice!=0);
    }
}
