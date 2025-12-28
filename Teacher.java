package Classes.sub;
import Classes.Person;
import Interfaces.ITeacher;

public class Teacher  extends Person implements ITeacher{
    
    private String Designation;
    private String FacultyOf;
    private double Salery;
    private String Password;

    public Teacher(){}
    public Teacher(String Name, int ID, String Number, String Designation, String FacultyOf, double Salery, String Password) {
        super(Name, ID, Number);      //, Age, Address);
        this.Designation = Designation;
        this.FacultyOf = FacultyOf;
        this.Salery = Salery;
        this.Password = Password;
    }
    public void setDesignation(String designation) {
        Designation = designation;
    }
    public void setFacultyOf(String facultyOf) {
        FacultyOf = facultyOf;
    }
    public void setSalery(double salery) {
        Salery = salery;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
    public String getDesignation() {
        return Designation;
    }
    public String getFacultyOf() {
        return FacultyOf;
    }
    public double getSalery() {
        return Salery;
    }
    public String getPassword() {
        return Password;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Designation\t: " + Designation);
        System.out.println("Faculty of\t: " + FacultyOf);
        System.out.println("Salery\t\t: " + Salery);
    }

    public void setStudentData(Student student){
        
    }
}
