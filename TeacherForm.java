package Framework;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Classes.ExceptionHandle;
import Classes.Menu;
import Classes.ReadWrite;
import Classes.sub.Teacher;

public class TeacherForm extends JFrame implements ActionListener{
    private JLabel msg,name,id,number,designation,password,salery,facultyOf;
    private JTextField nameField,idField,numberField,designationField,passwordField,saleryField,facultyField;
    private JButton okbtn,cancelbtn,resetbtn;
    private JPanel panel;
    private Menu menu;
    private JFrame f;
    private ReadWrite rw;
    private Teacher t = null;

    private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
    private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);

    //______________________________constructor_________________________
    public TeacherForm(Menu menu,ReadWrite rw, AdminMainFrame f ){
            
        super("Teacher Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        textFields();
        this.setVisible(true);
    }
    public TeacherForm(Menu menu,ReadWrite rw, AdminInfoFrame f ){
            
        super("Teacher Form");
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
    public TeacherForm(Menu menu,ReadWrite rw, AdminInfoFrame f ,Teacher t){
            
        super("Teacher Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
        this.t = t;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        modifyFields(t);
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
        msg = new JLabel("Enter Teacher Information :");
        msg.setFont(font.deriveFont(18.0f));
        msg.setForeground(btnBgColor);
        msg.setBounds(25, 25, 500, 20);
        panel.add(msg);

        name = new JLabel("Name :");
        name.setFont(font);
        name.setForeground(btnFwColor);
        name.setBounds(25, 75, 100, 20);
        panel.add(name);

        designation = new JLabel("Designation :");
        designation.setFont(font);
        designation.setForeground(btnFwColor);
        designation.setBounds(300, 75, 100, 20);
        panel.add(designation);

        id = new JLabel("ID :");
        id.setFont(font);
        id.setForeground(btnFwColor);
        id.setBounds(25, 170, 100, 20);
        panel.add(id);

        password = new JLabel("Password :");
        password.setFont(font);
        password.setForeground(btnFwColor);
        password.setBounds(300, 170, 100, 20);
        panel.add(password);

        number = new JLabel("Number :");
        number.setFont(font);
        number.setForeground(btnFwColor);
        number.setBounds(25, 270, 100, 20);
        panel.add(number);

        salery = new JLabel("Salery :");
        salery.setFont(font);
        salery.setForeground(btnFwColor);
        salery.setBounds(300, 270, 100, 20);
        panel.add(salery);

        facultyOf = new JLabel("Faculty of :");
        facultyOf.setFont(font);
        facultyOf.setForeground(btnFwColor);
        facultyOf.setBounds(25, 370, 100, 20);
        panel.add(facultyOf);

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
        nameField = new JTextField();
        nameField.setFont(font);
        nameField.setBounds(25, 105, 200, 20);
        panel.add(nameField);

        designationField = new JTextField();
        designationField.setFont(font);
        designationField.setBounds(300, 105, 200, 20);
        panel.add(designationField);

        idField = new JTextField();
        idField.setFont(font);
        idField.setBounds(25, 200, 200, 20);
        panel.add(idField);

        passwordField = new JTextField();
        passwordField.setFont(font);
        passwordField.setBounds(300, 200, 200, 20);
        panel.add(passwordField);

        numberField = new JTextField();
        numberField.setFont(font);
        numberField.setBounds(25, 300, 200, 20);
        panel.add(numberField);

        saleryField = new JTextField();
        saleryField.setFont(font);
        saleryField.setBounds(300, 300, 200, 20);
        panel.add(saleryField);

        facultyField = new JTextField();
        facultyField.setFont(font);
        facultyField.setBounds(25, 400, 200, 20);
        panel.add(facultyField);
    }

    public void modifyFields(Teacher t){
        //__________________________Modify Text Fields__________________________
        nameField = new JTextField(t.getName());
        nameField.setFont(font);
        nameField.setBounds(25, 105, 200, 20);
        panel.add(nameField);

        designationField = new JTextField(t.getDesignation());
        designationField.setFont(font);
        designationField.setBounds(300, 105, 200, 20);
        panel.add(designationField);

        idField = new JTextField(""+t.getID());
        idField.setFont(font);
        idField.setBounds(25, 200, 200, 20);
        panel.add(idField);

        passwordField = new JTextField(t.getPassword());
        passwordField.setFont(font);
        passwordField.setBounds(300, 200, 200, 20);
        panel.add(passwordField);

        numberField = new JTextField(t.getNumber());
        numberField.setFont(font);
        numberField.setBounds(25, 300, 200, 20);
        panel.add(numberField);

        saleryField = new JTextField(""+t.getSalery());
        saleryField.setFont(font);
        saleryField.setBounds(300, 300, 200, 20);
        panel.add(saleryField);

        facultyField = new JTextField(t.getFacultyOf());
        facultyField.setFont(font);
        facultyField.setBounds(25, 400, 200, 20);
        panel.add(facultyField);
    }

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == okbtn){
            if( (nameField.getText().equals("")) ||
                (idField.getText().equals("")) ||
                (numberField.getText().equals("")) || 
                (designationField.getText().equals("")) ||
                (passwordField.getText().equals("")) ||
                 saleryField.getText().equals("") ||
                 facultyField.getText().equals("") ){
                    JOptionPane.showMessageDialog(this, "Please enter all informations !", "Error..!!",JOptionPane.WARNING_MESSAGE);
                }
            else
                try{
                    menu.addTeacher( new Teacher(nameField.getText(), Integer.parseInt(idField.getText())+300000, numberField.getText(), designationField.getText(), facultyField.getText() ,Double.parseDouble(saleryField.getText()), passwordField.getText()) );
                    if(t !=null) {menu.deleteTeacher(t);}
                    this.dispose();
                    f.dispose();
                    new AdminInfoFrame(menu, rw, "Teacher");
                    }
                catch(Exception ex){
                    new ExceptionHandle(this).inputMissMatch();
                }    
        }
        else if(e.getSource() == resetbtn){
            nameField.setText("");
            idField.setText("");
            numberField.setText("");
            designationField.setText("");
            passwordField.setText("");
            saleryField.setText("");
            facultyField.setText("");
        }
        else if(e.getSource() == cancelbtn){
            this.dispose();
        }
        
    }
}
