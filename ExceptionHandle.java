package Classes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExceptionHandle extends Exception {
    
    private JFrame frame;

    public ExceptionHandle(JFrame j){
        frame = j;
    }

    public void selectMissMatch(){
        JOptionPane.showMessageDialog(frame,  "Please Select correct option from dropdown", "Warining",
						JOptionPane.WARNING_MESSAGE);
    }
    public void inputMissMatch(){
        JOptionPane.showMessageDialog(frame, "Input value Missmatch !", "Error..!!",JOptionPane.WARNING_MESSAGE);
    }
    public void nullPointer(){
        JOptionPane.showMessageDialog(frame,  "An error occured, try again", "Error..!",
						JOptionPane.ERROR_MESSAGE);
    }
    public void fileNotFound(){
        JOptionPane.showMessageDialog(frame,  "Failed to read data from from file", "Error..!",
						JOptionPane.ERROR_MESSAGE);
    }
    public void outOfMemory(){
        JOptionPane.showMessageDialog(frame,  "Not enough memory..", "Error..!",
						JOptionPane.ERROR_MESSAGE);
    }
    public void numberFormat(){
        JOptionPane.showMessageDialog(frame,  "The field requires integer value", "Error..!",
						JOptionPane.ERROR_MESSAGE);
    }
}
