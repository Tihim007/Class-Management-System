package Framework;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Classes.ExceptionHandle;
import Classes.Menu;
import Classes.ReadWrite;
import Classes.Section;

public class SectionForm extends JFrame implements ActionListener {

    private JLabel msg,courseName,sectionName,studentNumber,teacherId;
    private JTextField courseNameField,sectionNameField,studentNumberField,teacherIdField;
    private JButton okbtn,cancelbtn,resetbtn;
    private JPanel panel;
    private Menu menu;
    private JFrame f;
    private ReadWrite rw;
    private Section s = null;

    private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
    private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);

    //______________________________constructor_________________________
    public SectionForm(Menu menu, ReadWrite rw, AdminMainFrame f ){
            
        super("Section Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        textFields();
        this.setVisible(true);
    }
    public SectionForm(Menu menu, ReadWrite rw, AdminInfoFrame f ){
            
        super("Section Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        textFields();
        this.setVisible(true);
    }
    public SectionForm(Menu menu, ReadWrite rw, AdminInfoFrame f, Section s ){
            
        super("Section Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
        this.s = s;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        modifyFields(s);
        this.setVisible(true);
    }
    //________________________________________________________________

    //_____________________________Methods_____________________________
    private void constructStudentForm(){
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        panel.setBackground(panelBgColor);
        panel.setLayout(null);


        //______________________________labels________________________
        msg = new JLabel("Enter Section Information :");
        msg.setFont(font.deriveFont(18.0f));
        msg.setForeground(btnBgColor);
        msg.setBounds(25, 25, 500, 20);
        panel.add(msg);

        courseName = new JLabel("Course Name :");
        courseName.setFont(font);
        courseName.setForeground(btnFwColor);
        courseName.setBounds(25, 75, 100, 20);
        panel.add(courseName);

        teacherId = new JLabel("Teacher ID :");
        teacherId.setFont(font);
        teacherId.setForeground(btnFwColor);
        teacherId.setBounds(300, 75, 100, 20);
        panel.add(teacherId);

        sectionName = new JLabel("Section Name :");
        sectionName.setFont(font);
        sectionName.setForeground(btnFwColor);
        sectionName.setBounds(25, 170, 100, 20);
        panel.add(sectionName);

        studentNumber = new JLabel("Number of Students :");
        studentNumber.setFont(font);
        studentNumber.setForeground(btnFwColor);
        studentNumber.setBounds(300, 170, 300, 20);
        panel.add(studentNumber);
        

        //___________________________buttons____________________________
        okbtn = new JButton("OK");
        okbtn.setFont(font);
        okbtn.setForeground(btnFwColor);
        okbtn.setBackground(btnBgColor);
        okbtn.setBounds(470 , 500, 80, 30);
        okbtn.addActionListener(this);
        panel.add(okbtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setFont(font);
        cancelbtn.setForeground(btnFwColor);
        cancelbtn.setBackground(btnBgColor);
        cancelbtn.setBounds(370, 500, 80, 30);
        cancelbtn.addActionListener(this);
        panel.add(cancelbtn);

        resetbtn = new JButton("Reset All");
        resetbtn.setFont(font);
        resetbtn.setForeground(btnFwColor);
        resetbtn.setBackground(btnBgColor);
        resetbtn.setBounds(25, 500, 110, 30);
        resetbtn.addActionListener(this);
        panel.add(resetbtn);


        this.add(panel);
    }

    public void textFields(){
        //__________________________Text Fields__________________________
        courseNameField = new JTextField();
        courseNameField.setFont(font);
        courseNameField.setBounds(25, 105, 200, 20);
        panel.add(courseNameField);

        teacherIdField = new JTextField();
        teacherIdField.setFont(font);
        teacherIdField.setBounds(300, 105, 200, 20);
        panel.add(teacherIdField);

        sectionNameField = new JTextField();
        sectionNameField.setFont(font);
        sectionNameField.setBounds(25, 200, 200, 20);
        panel.add(sectionNameField);

        studentNumberField = new JTextField();
        studentNumberField.setFont(font);
        studentNumberField.setBounds(300, 200, 200, 20);
        panel.add(studentNumberField);
    }
    public void modifyFields(Section s){
        //__________________________Modify Text Fields__________________________
        courseNameField = new JTextField(s.getCourseName());
        courseNameField.setFont(font);
        courseNameField.setBounds(25, 105, 200, 20);
        panel.add(courseNameField);

        teacherIdField = new JTextField(""+s.getTeacher().getID());
        teacherIdField.setFont(font);
        teacherIdField.setBounds(300, 105, 200, 20);
        panel.add(teacherIdField);

        sectionNameField = new JTextField(""+s.getSectionName());
        sectionNameField.setFont(font);
        sectionNameField.setBounds(25, 200, 200, 20);
        panel.add(sectionNameField);

        studentNumberField = new JTextField(""+s.getNumberOfStudents());
        studentNumberField.setFont(font);
        studentNumberField.setBounds(300, 200, 200, 20);
        panel.add(studentNumberField);
    }

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == okbtn){
            if( (courseNameField.getText().equals("")) ||
                (sectionNameField.getText().equals("")) ||
                (studentNumberField.getText().equals("")) || 
                (teacherIdField.getText().equals("")) ){
                    JOptionPane.showMessageDialog(this, "Please enter all informations !", "Error..!!",JOptionPane.WARNING_MESSAGE);
                }
            else
                try{
                    menu.addSection( new Section(courseNameField.getText(), sectionNameField.getText().toUpperCase().charAt(0), menu.getTeacher(Integer.parseInt(teacherIdField.getText())), Integer.parseInt(studentNumberField.getText()) ));
                    if(s!=null){
                        menu.getSection(sectionNameField.getText().charAt(0)).setStudents(menu.getSection(s.getSectionName()).getStudents());
                        menu.deleteSection(s);
                    }
                    this.dispose();
                    f.dispose();
                    new AdminInfoFrame(menu, rw, "Section");
                    }
                catch(Exception ex){
                    new ExceptionHandle(this).inputMissMatch();
                }    
        }
        else if(e.getSource() == resetbtn){
            courseNameField.setText("");
            sectionNameField.setText("");
            studentNumberField.setText("");
            teacherIdField.setText("");
        }
        else if(e.getSource() == cancelbtn){
            this.dispose();
        }
        
    }
    
}
