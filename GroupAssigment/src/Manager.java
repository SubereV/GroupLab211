
import java.util.ArrayList;
import java.util.Collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Manager {
    public int Menu() {
        int choice;
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^MENU^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("> 1-Create");
        System.out.println("> 2-Find/Sort");
        System.out.println("> 3-Update/Delete");
        System.out.println("> 4-Report");
        System.out.println("> 0-Exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Please enter your choice: ");
        choice = Validation.checkInputRange(0,4);
        return choice;
    }
     
    //check id exist
    private int isExist(ArrayList<Student> stdList, String ID){
        for(int i=0; i<stdList.size(); i++)
            if(stdList.get(i).getID().equalsIgnoreCase(ID)) return i;
        return -1;
    }
    
    //display student information in format
    private void display(ArrayList<Student> stdList,int index){
        System.out.printf("%4s %30s %5s %8d\n", stdList.get(index).getID()
                , stdList.get(index).getStdName(), stdList.get(index).getCourseName(), stdList.get(index).getSemester());
    }
    
    public ArrayList<Student> create(ArrayList<Student> stdList){
        String id;
        System.out.print("Enter student ID: ");
        id = Validation.checkInputID();
        int index = isExist(stdList,id);
        String stdName;
        //if id exists, auto take student name
        if(index!=-1){
            stdName = stdList.get(index).getStdName();
            System.out.println("This ID is found with student name: "+stdName);
        } else{
            System.out.print("Enter student name: ");
            stdName = Validation.checkInputString();     
        }       
        System.out.print("Enter course name: ");
        String courseName = Validation.checkInputCourseName();
        System.out.print("Enter semester: ");
        int semester = Validation.checkInputInt();
        Student std = new Student(id, stdName, courseName, semester);
        stdList.add(std);
        return stdList;
    }
    
    public ArrayList<Student> findSort(ArrayList<Student> stdList, String name){
        //Create a list to contain number of student found
        ArrayList index = new ArrayList<>();
        Collections.sort(stdList);
        for(int i=0; i<stdList.size(); i++)
            if (stdList.get(i).getStdName().contains(name)){
                index.add(i);
            }
        System.out.println("Found "+index.size()+" {"+name+"} in the list");
        if(!index.isEmpty()){
            System.out.printf("%4s %30s %5s %8s\n","ID","Student Name","Course Name","Semester");
            for(int i=0; i<index.size(); i++){
                display(stdList,(int)index.get(i));
            }
        }
        Collections.sort(stdList);
        System.out.println("After sorting: ");
        System.out.printf("%4s %30s %5s %8s\n","ID","Student Name","Course Name","Semester");
        for(int i=0; i<stdList.size(); i++){
                display(stdList,i);
            }
        return stdList;
    }
    
    public ArrayList<Student> updateDelete(ArrayList<Student> stdList, String ID){
        //check id exist
        int index = isExist(stdList, ID);
        if(index==-1) System.err.println("This ID does not exist");
        //check multi id and execute in turn
        for(int i=0; i<stdList.size(); i++){
            if(stdList.get(i).getID().equalsIgnoreCase(ID)){
                System.out.printf("%4s %30s %5s %8s\n","ID","Student Name","Course Name","Semester");
                display(stdList,i);
                System.out.println("Do you want to update or delete?");
                System.out.print("Input u/U to update or d/D to delete: ");
                boolean check = Validation.checkInputUD();
                if(check){
                    System.out.print("Enter course name: ");
                    String courseName = Validation.checkInputCourseName();
                    stdList.get(i).setCourseName(courseName);
                    System.out.print("Enter semester: ");
                    int semester = Validation.checkInputInt();
                    stdList.get(i).setSemester(semester);
                    System.err.println("Update successfully");
                } else{
                    stdList.remove(i);
                    System.err.println("Delete successfully");
                    i--;
                }                
            }

        }
        return stdList;
    }
    
    public void report(ArrayList<Student> stdList){
        //clone new list base on student list
        ArrayList<Student> stdReport = (ArrayList<Student>)stdList.clone();
        //create a list to contain number of courses
        ArrayList totalCourse = new ArrayList();
        for(int i=0; i<stdReport.size(); i++){
            int count=1;
            if(i==stdReport.size()) continue;
            for(int j=i+1; j<stdReport.size(); j++){
                //check duplicate ID and Courname
                if(stdReport.get(j).getID().equalsIgnoreCase(stdReport.get(i).getID()) 
                    && stdReport.get(j).getCourseName().equalsIgnoreCase(stdReport.get(i).getCourseName())) {
                    stdReport.remove(j);
                    count++;
                }
            }
            totalCourse.add(count);
        }
        System.out.printf("%30s %20s %20s\n","Student Name","Course Name","Total Course");
        for(int i=0; i<totalCourse.size(); i++){
            System.out.printf("%30s %20s %20d\n", stdReport.get(i).getStdName(),stdReport.get(i).getCourseName(), totalCourse.get(i));
        }
    }
    
}
