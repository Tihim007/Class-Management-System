package Classes.sub;

public class TeacherManager {
    
    private Teacher[] Teachers;

    public TeacherManager(Teacher[] arr){
        Teachers =  arr;
    }

    public void addTeacher(Teacher teacher){
        boolean flag = false;
        for (int i=0; i<Teachers.length; i++){
            if(Teachers[i] == null){
                Teachers[i] = teacher;
                flag = true;
                break;
            }
        }
        if (flag)
        System.out.println("New Teacher Added..");
        else
        System.out.println("Failed to add Teacher..");
    }
    public void deleteTeacher(Teacher teacher){
        boolean flag = false;
        for (int i=0; i<Teachers.length; i++){
            if(Teachers[i] != null){
                if(Teachers[i] == teacher){
                    Teachers[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Teacher deleted..");
        else
        System.out.println("Failed to delete Teacher..");
    }
    public Teacher getTeacher(int id){
        boolean flag = false;
        Teacher teacher = null;
        for (int i=0; i<Teachers.length; i++){
            if(Teachers[i] != null){
                if(Teachers[i].getID() == id){
                    teacher = Teachers[i];
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Teacher found..");
        else
        System.out.println("Teacher not found..");

        return teacher;
    }

    public Teacher[] getTeachers() {
        return Teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        Teachers = teachers;
    }
}
