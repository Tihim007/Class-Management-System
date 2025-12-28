package Interfaces;

import Classes.Section;
import Classes.sub.*;

public interface IMenu {
    
    public void addAdmin(Admin admin);
    public void deleteAdmin(Admin admin);
    public Admin getAdmin(int id);

    public void addTeacher(Teacher teacher);
    public void deleteTeacher(Teacher teacher);
    public Teacher getTeacher(int id);

    public void addStudent(Student student);
    public void deleteStudent(Student student);
    public Student getStudent(int id);
    public void addStudent(Student[] arr, Student stu);
    public void deleteStudent(Student[] arr, Student stu);
    public Student getStudent(Student[] arr,int id);

    public void addSection(Section sec);
    public void deleteSection(Section sec);
    public Section getSection(char SecName);
}
