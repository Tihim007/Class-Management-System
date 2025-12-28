import Classes.Menu;
import Classes.ReadWrite;
import Framework.Login; 

public class Run {
    public static void main(String[] args) {

        Menu menu = new Menu(50,50,50,10);
        
        //________________________________load data from file______________________________//
        ReadWrite rw = new ReadWrite();
         
        menu.setAdmins( rw.readAdmins(menu.getAdmins().length) );
        menu.setTeacher(rw.readTeachers(menu.getTeachers().length));
        menu.setSection(rw.readSections(menu.getSections().length, menu.getTeachers()));
        

        new Login(menu, rw);  
        
    }
}  




    /* 
        //_____________________________show info from menu arrays__________________________//
        //Teacher
        for(int i=0; i<menu.getTeachers().length; i++){
            if(menu.getTeachers()[i] != null){
                menu.getTeachers()[i].showInfo();
            }
        }
        //Admin
        for(int i=0; i<menu.getAdmins().length; i++){
            if( (menu.getAdmins())[i] != null){
                (menu.getAdmins())[i].showInfo();
            }
        }
        //Section
        for(int i=0; i<menu.getSections().length; i++){
            if(menu.getSections()[i] != null){
                for(int j=0; j<menu.getSections()[i].getStudents().length; j++){
                    if(menu.getSections()[i].getStudents()[j] != null){
                    menu.getSections()[i].getStudents()[j].showInfo();}
                }
            }
        } 



        Teacher t1 = new Teacher("Berlin",1122,"0177889900","Senior lecturer","CSE",98000,"Hello");
        Teacher t2 = new Teacher("Berlin",1123,"0177889900","Senior lecturer","CSE",98000,"Hello");
        Teacher t3 = new Teacher("Berlin",1124,"0177889900","Senior lecturer","CSE",98000,"Hello");
        Teacher t4 = new Teacher("Berlin",1125,"0177889900","Senior lecturer","CSE",98000,"Hello");

        Student s1 = new Student("Tokyo",1111,"0177889900","CSE",4.0f);
        Student s2 = new Student("Tokyo",1112,"0177889900","CSE",4.0f);
        Student s3 = new Student("Tokyo",1113,"0177889900","CSE",4.0f);

        Admin a1 = new Admin("Denver", 5677, "0445566778","Admin", "Academic", "221B");
        Admin a2 = new Admin("Denver", 5678, "0445566778","Admin", "Academic", "221B");
        Admin a3 = new Admin("Denver", 5679, "0445566778","Admin", "Academic", "221B");
        Admin a4 = new Admin("Denver", 5670, "0445566778","Admin", "Academic", "221B");


        Section M = new Section("OOP1", 'M', t1, 40);
        Section K = new Section("OOP1", 'K', t2, 40);
        Section L = new Section("OOP1", 'L', t3, 40);
        Section P = new Section("OOP1", 'P', t4, 40);
        Section Q = new Section("OOP1", 'Q', t1, 40);


        menu.addAdmin(a1);
        menu.addAdmin(a2);
        menu.addAdmin(a3);
        menu.addAdmin(a4);

        menu.addTeacher(t1);
        menu.addTeacher(t2);
        menu.addTeacher(t3);
        menu.addTeacher(t4);

        menu.addSection(M);
        menu.addSection(K);
        menu.addSection(L);
        menu.addSection(P);
        menu.addSection(Q);


        menu.addStudent(M.getStudents(), s1);
        menu.addStudent(M.getStudents(), s2);
        menu.addStudent(M.getStudents(), s3);

        menu.addStudent(K.getStudents(), s1);
        menu.addStudent(K.getStudents(), s2);

        menu.addStudent(P.getStudents(), s1);
        menu.addStudent(P.getStudents(), s2);
        menu.addStudent(P.getStudents(), s3);

        menu.addStudent(Q.getStudents(), s1);
        menu.addStudent(Q.getStudents(), s2);
        menu.addStudent(Q.getStudents(), s3);
        
        menu.addStudent(L.getStudents(), s3);

        menu.addStudent(s1);
        menu.addStudent(s2);
        menu.addStudent(s3);

        
        ReadWriteAdmin writeAdmins = new ReadWriteAdmin("Files/admins.bin");
        ReadWriteTeacher writeTeachers = new ReadWriteTeacher("Files/teachers.bin");
        ReadWriteStudent writeAllStudents = new ReadWriteStudent("Files/students.bin");
        ReadWriteSection writeSections = new ReadWriteSection("Files/sections.bin");


        writeAdmins.arrayToFile(menu.getAdmins());
        writeTeachers.arrayToFile(menu.getTeachers());
        writeAllStudents.arrayToFile(menu.getStudents());
        writeSections.arrayToFile(menu.getSections());
    */