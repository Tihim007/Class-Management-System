package Classes;
import Classes.sub.*;
public class Section {

    private String CourseName;
    private char SectionName;
    private Teacher teacher;
    private int NumberOfStudents;
    private Student[] students;

    public Section(){}
    public Section(String courseName, char sectionName, Teacher teacher, int size){
        CourseName = courseName;
        SectionName = sectionName;
        this.teacher = teacher;
        NumberOfStudents = size;
        students = new Student[NumberOfStudents];
    }

    
    public void setCourseName(String courseName){
        CourseName = courseName;
    }
    public void setSectionName(char sectionName){
        SectionName = sectionName;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void setNumberOfStudents(int x){
        NumberOfStudents = x;
    }
    public void setStudents(Student[] arr){
        students = arr;
    }
    public String getCourseName(){
        return CourseName;
    }
    public char getSectionName(){
        return SectionName;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public int getNumberOfStudents(){
        return NumberOfStudents;
    }
    public Student[] getStudents(){
        return students;
    }

    public void showInfo(){
        System.out.println("Section name\t: " + SectionName);
        System.out.println("Course name\t: " + CourseName);
        System.out.println("Teacher name\t: " + this.teacher.getName());
        System.out.println("Total Students\t: " + students.length);
    }
}
