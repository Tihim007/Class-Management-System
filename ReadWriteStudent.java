package Classes.sub;

import java.io.*;

public class ReadWriteStudent {
    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bfr;

    public ReadWriteStudent(){}
    public ReadWriteStudent(String filepath){
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
    public void arrayToFile(Student[] arr){
        try {
            fileWriter = new FileWriter(file, false);
            for(int i=0; i<arr.length; i++){
                if(arr[i] != null){
                    writeStudentToString(arr[i]);
                }  
            }
            fileWriter.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeStudentToString(Student a){
        String ob = new String();
        ob = (a.getName() + "|" + a.getID() + "|" + a.getNumber() + "|" +  a.getDepartment() + "|" 
        + a.getCgpa());

        try {
            fileWriter.write( ob + "\r\n");
            fileWriter.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }


     //__________________________Load data to array from file________________________
    public Student[] fileToArray(int size){
        Student[] ob  = new Student[size];
        String data;
        String []arr;
        int i=0;
        try {
            fileReader = new FileReader(file);
            bfr = new BufferedReader(fileReader);
            while((data=bfr.readLine()) != null){
                arr =data.split("\\|");
                ob[i++] = new Student( arr[0], (Integer.parseInt(arr[1])) , arr[2], arr[3],(Float.parseFloat(arr[4])) );
            }
            fileReader.close();
        }     
        catch (IOException e) {
            e.printStackTrace();
        }         
        return ob;
    }
    
}