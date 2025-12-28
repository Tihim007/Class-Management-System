package Classes.sub;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class ReadWriteTeacher {
    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader bfr;

    public ReadWriteTeacher(){}
    public ReadWriteTeacher(String filepath){
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
    public void arrayToFile(Teacher[] arr){
        
        try {
            fileWriter = new FileWriter(file, false);
            for(int i=0; i<arr.length; i++){
                if(arr[i] != null){
                    writeTeacherToString(arr[i]);
                }
            }
            fileWriter.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTeacherToString(Teacher a){
        String ob = new String();
        ob = (a.getName() + "|" + a.getID() + "|" + a.getNumber() + "|" +  a.getDesignation() + "|" 
        + a.getFacultyOf() + "|" + a.getSalery() + "|" + a.getPassword());

        try {
            fileWriter.write( ob + "\r\n");
            fileWriter.flush();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //__________________________Load data to array from file________________________

    public Teacher[] fileToArray(int x){
        Teacher[] ob  = new Teacher[x];
        String data;
        String[] arr;
        int i=0;
        try {
            fileReader = new FileReader(file);
            bfr = new BufferedReader(fileReader);
            while((data=bfr.readLine()) != null){
                arr =data.split("\\|");
                ob[i++] = new Teacher(arr[0], Integer.parseInt(arr[1]), arr[2], arr[3], arr[4], (Double.parseDouble(arr[5])), arr[6]);
            } 
        }     
        catch (IOException e) {
            e.printStackTrace();
        }         
        return ob;
    }


}
