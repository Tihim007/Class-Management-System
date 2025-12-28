package Interfaces;

public interface ITeacher {
    
    public void setDesignation(String designation);
    public void setFacultyOf(String facultyOf);
    public void setSalery(double salery);
    public void setPassword(String password);
    public String getDesignation();
    public String getFacultyOf();
    public double getSalery();
    public String getPassword();

    public void showInfo();
}
