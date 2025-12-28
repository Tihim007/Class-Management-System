package Classes.sub;

import Classes.Section;

public class StudentManager {
    
    private Student[] Students;
    private Section[] Sections;

    public StudentManager(Student[] arr, Section[] sec){
        Students = arr;
        Sections = sec;
    }
    //_________________Add__________________
    public void addStudent(Student student){
        boolean flag = false;
        for (int i=0; i<Students.length; i++){
            if(Students[i] == null){
                Students[i] = student;
                flag = true;
                break;
            }
        }
        if (flag)
        System.out.println("New Student Added..");
        else
        System.out.println("Failed to add Student..");
    }
    public void addStudent(Student[] arr, Student stu){
        boolean flag = false;
        for (int i=0; i<arr.length; i++){
            if(arr[i] == null){
                arr[i] = stu;
                flag = true;
                break;
            }
        }
        if (flag)
        System.out.println("New Student Added..");
        else
        System.out.println("Failed to add Student..");
    }
    //__________________delete_______________________
    public void deleteStudent(Student s){
        boolean flag = false;
        for(int j=0; j<Sections.length; j++){
            if(Sections[j] != null){
                for (int i=0; i<Sections[j].getStudents().length; i++){
                    if(Sections[j].getStudents()[i] != null){
                        if(Sections[j].getStudents()[i].getID() == s.getID()){
                            Sections[j].getStudents()[i] = null;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        if (flag)
        System.out.println("Student deleted..");
        else
        System.out.println("Failed to delete Student..");
    }
    public void deleteStudent(Student[] arr, Student stu){
        boolean flag = false;
        for (int i=0; i<arr.length; i++){
            if(arr[i] != null){
                if(arr[i] == stu){
                    arr[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Student deleted..");
        else
        System.out.println("Failed to delete Student..");
    }
    //____________________get________________________
    public Student getStudent(int id){
        boolean flag = false;
        Student student = null;
        for(int j=0; j<Sections.length; j++){
            if(Sections[j] != null){
                Student[] arr = Sections[j].getStudents();
                for (int i=0; i<arr.length; i++){
                    if(arr[i] != null){
                        if(arr[i].getID() == id){
                            student = arr[i];
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        
        if (flag)
        System.out.println("Student found..");
        else
        System.out.println("Student not found..");

        return student;
    }
    
    public Student getStudent(Student[] arr,int id){
        boolean flag = false;
        Student student = null;
        for (int i=0; i<arr.length; i++){
            if(arr[i] != null){
                if(arr[i].getID() == id){
                    student = arr[i];
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Student found..");
        else
        System.out.println("Student not found..");

        return student;
    }

    
    public Student[] getStudents() {
        return Students;
    }
    public void setStudents(Student[] students) {
        Students = students;
    }
    public Section[] getSections() {
        return Sections;
    }
    public void setSections(Section[] sections) {
        Sections = sections;
    }
}
