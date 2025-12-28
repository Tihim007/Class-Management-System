package Classes;

import Classes.sub.Admin;
import Classes.sub.ReadWriteAdmin;
import Classes.sub.ReadWriteSection;
import Classes.sub.ReadWriteTeacher;
import Classes.sub.Teacher;

public class ReadWrite {

    private ReadWriteAdmin admin;
    private ReadWriteTeacher teacher;
    private ReadWriteSection section;

    public ReadWrite(){
        admin = new ReadWriteAdmin("Files/admins.bin");
        teacher = new ReadWriteTeacher("Files/teachers.bin");
        section = new ReadWriteSection("Files/sections.bin");
    }
    //__________________________________Write________________________________
    public void writeAdmins(Admin[] arr){
        admin.arrayToFile(arr);
    }
    public void writeTeachers(Teacher[] arr){
        teacher.arrayToFile(arr);
    }
    public void writeSections(Section[] arr){
        section.arrayToFile(arr);
    }

    //__________________________________Read_________________________________
    public Admin[] readAdmins(int size){
        return ( admin.fileToArray(size) );
    }
    public Teacher[] readTeachers(int size){
        return ( teacher.fileToArray(size) ) ;
    }
    public Section[] readSections(int size, Teacher[] arr){
        return ( section.fileToArray(size, arr) );
    }
}
