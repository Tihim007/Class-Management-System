package Interfaces;

public interface IStudent {

    public void setDepartment(String department);
    public void setCgpa(float cgpa);
    public void setAttendence(short attendence);
    public void setAttendenceMark(float attendenceMark);
    
    public String getDepartment();
    public float getCgpa();
    public short getAttendence();
    public float getAttendenceMark();

    public void showInfo();
}
