package Classes.sub;

import Classes.Section;
import java.io.*;

public class ReadWriteSection {
    
    private File file;
    private FileWriter fileWriter;
    private ReadWriteStudent writeSecStudents;
    private FileReader fileReader;
    private BufferedReader bfr;

    public ReadWriteSection(){}
    public ReadWriteSection(String filepath){
        try{
            file = new File(filepath);
                if(!(file.exists())){
                    file.createNewFile();
                 }
        }
    
        catch(IOException e){
		    e.printStackTrace();
        }
    }


    //_________________________Save Array to file___________________________
    public void arrayToFile(Section[] arr){
        

        try {
            fileWriter = new FileWriter(file, false);
            for(int i=0; i<arr.length; i++){
                if(arr[i] != null){
                    writeSectionToString(arr[i]);
                }
            }
            for(int i=0; i<arr.length; i++){
                if(arr[i] != null){
                    writeSecStudents = new ReadWriteStudent("Files/Section"+arr[i].getSectionName()+".bin");
                    writeSecStudents.arrayToFile(arr[i].getStudents());
                    
                }
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSectionToString(Section a){
        String ob = new String();
        ob = (a.getCourseName() + "|" + a.getSectionName() + "|" + a.getTeacher().getID() + "|" +  a.getNumberOfStudents());

        try {
            fileWriter.write( ob + "\r\n");
            fileWriter.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //__________________________Load data to array from file________________________
    public Section[] fileToArray(int size, Teacher[] t){
        Section[] ob  = new Section[size];
        String data;
        Teacher tt = null;
        String []arr;
        int j=0;
        try {
            fileReader = new FileReader(file);
            bfr = new BufferedReader(fileReader);
            while((data=bfr.readLine()) != null){
                arr = data.split("\\|");
                for(int i=0; i<t.length; i++){
                    if(t[i] != null){
                        if(t[i].getID() == Integer.parseInt(arr[2])){
                            tt = t[i];
                            break;
                        }
                    }
                }
                ob[j++] = new Section(arr[0], arr[1].charAt(0) , tt , Integer.parseInt(arr[3]));
            }
            fileReader.close();
         }     
        catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<ob.length; i++){
            if(ob[i] != null){
            ReadWriteStudent rws = new ReadWriteStudent("Files/Section"+ob[i].getSectionName()+".bin");
            ob[i].setStudents(rws.fileToArray(ob[i].getNumberOfStudents()));
            }
        }         
        return ob;
    }
}
