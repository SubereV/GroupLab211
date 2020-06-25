
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Student implements Comparable<Student>{
    private String ID,stdName,courseName;
    private int semester;

    public Student() {
    }

    public Student(String ID, String stdName, String courseName, int semester) {
        this.ID = ID;
        this.stdName = stdName;
        this.courseName = courseName;
        this.semester = semester;
    }

    public String getID() {
        return ID;
    }

    public String getStdName() {
        return stdName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public int compareTo(Student std) {
        //Sort by name
        StringTokenizer stdTokenizer = new StringTokenizer(std.getStdName());
        String stdToken="";
        StringTokenizer thisTokenizer = new StringTokenizer(this.getStdName());
        String thisToken="";
        while (stdTokenizer.hasMoreTokens()) {
            stdToken = stdTokenizer.nextToken();
        }
        while (thisTokenizer.hasMoreTokens()) {
            thisToken = thisTokenizer.nextToken();
        }
        return thisToken.compareTo(stdToken);
    }
    
}
