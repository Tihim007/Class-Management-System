package Classes;

import Interfaces.IMenu;
import Classes.sub.*;

public class Menu implements IMenu{

    private AdminManager adminManager;
    private TeacherManager teacherManager;
    private StudentManager studentManager;
    private SectionManager sectionManager;

    //public Menu(){}
    public Menu(int x, int y, int z, int s){
        Admin[] Admins = new Admin[x];
        Teacher[] Teachers = new Teacher[y];
        Section[] Sections = new Section[z];
        Student[] Students = new Student[s];

        adminManager = new AdminManager(Admins);
        teacherManager = new TeacherManager(Teachers);
        studentManager = new StudentManager(Students, Sections);
        sectionManager = new SectionManager(Sections);
    }

    //______________________________________Admin_____________________________________
    public void addAdmin(Admin admin){
        adminManager.addAdmin(admin);
    }
    public void deleteAdmin(Admin admin){
        adminManager.deleteAdmin(admin);
    }
    public Admin getAdmin(int id){
        return ( adminManager.getAdmin(id) );
    }
    //__________________________________________Teacher_________________________________
    public void addTeacher(Teacher teacher){
        teacherManager.addTeacher(teacher);
    }
    public void deleteTeacher(Teacher teacher){
        teacherManager.deleteTeacher(teacher);
    }
    public Teacher getTeacher(int id){
        return teacherManager.getTeacher(id);
    }
    //__________________________________________Students____________________________
    public void addStudent(Student student){
        studentManager.addStudent(student);
    }
    public void addStudent(Student[] arr, Student stu){
        studentManager.addStudent(arr, stu);
    }

    public void deleteStudent(Student stu){
        studentManager.setSections(sectionManager.getSections());
        studentManager.deleteStudent(stu);
        sectionManager.setSections(studentManager.getSections());
    }
    public void deleteStudent(Student[] arr, Student stu){
        studentManager.deleteStudent(arr, stu);
    }

    public Student getStudent(int id){
        studentManager.setSections(sectionManager.getSections());
        return studentManager.getStudent(id);
    }
    public Student getStudent(Student[] arr, int id){
        return studentManager.getStudent(arr, id);
    }
    
    //__________________________________________Sections____________________________
    public void addSection(Section sec){
        sectionManager.addSection(sec);
    }
    public void deleteSection(Section sec){
        sectionManager.deleteSection(sec);
    }
    public Section getSection(char SecName){
        return sectionManager.getSection(SecName);
    }


    //_______________Setter & getters___________________
    public Admin[] getAdmins(){
        return adminManager.getAdmins();
    }
    public void setAdmins(Admin[] arr){
        adminManager.setAdmins(arr);;
    }
    public Teacher[] getTeachers(){
        return teacherManager.getTeachers();
    }
    public void setTeacher(Teacher[] arr){
        teacherManager.setTeachers(arr);;
    }
    public void setSection(Section[] arr){
        sectionManager.setSections(arr);;
    }
    public Section[]  getSections(){
        return sectionManager.getSections();
    }
    public Student[] getStudents(){
        return studentManager.getStudents();
    }
    public void setStudents(Student[] arr){
        studentManager.setStudents(arr);
    }
}
