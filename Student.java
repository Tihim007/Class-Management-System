package Classes.sub;
import Classes.Person;
import Interfaces.IStudent;

public class Student extends Person implements IStudent{

    private String Department;
    private float Cgpa;
    private short Attendence;
    private float AttendenceMark;

    public Student(){}
    public Student(String Name, int ID, String Number, String Department, float Cgpa) {
        super(Name, ID, Number);        //, Age, Address);
        this.Department = Department;
        this.Cgpa = Cgpa;
        Attendence = 0;
        AttendenceMark = 0.0f;
    }

    public void setDepartment(String department) {
        Department = department;}

    public void setCgpa(float cgpa) {
        Cgpa = cgpa;}

    public void setAttendence(short attendence) {
        Attendence = attendence;}

    public void setAttendenceMark(float attendenceMark) {
        AttendenceMark = attendenceMark;}

    public String getDepartment() {
        return Department;}

    public float getCgpa() {
        return Cgpa;}

    public short getAttendence() {
        return Attendence;}

    public float getAttendenceMark() {
        return AttendenceMark;}
        
    public void showInfo(){
        super.showInfo();
        System.out.println("Department\t: " + Department);
        System.out.println("CGPA\t\t: " + Cgpa);
        System.out.println("Present in class: " + Attendence + " Days");
        System.out.println("Attendence Mark\t: " + AttendenceMark);
    }
    
}
