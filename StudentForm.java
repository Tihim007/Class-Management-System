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
import Classes.sub.Student;

public class StudentForm extends JFrame implements ActionListener {
    
    private JLabel name,id,number,department,cgpa,msg,section;
    private JTextField nameField,idField,numberField,departmentField,cgpaField;
    private JButton okbtn,cancelbtn,resetbtn;
    private JPanel panel;
    private JComboBox sections;
    private Menu menu;
    private JFrame f;
    private ReadWrite rw;
    private Student s = null;

    private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
    private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);

    //______________________________constructor_________________________
    public StudentForm(Menu menu,ReadWrite rw, AdminMainFrame f ){
            
        super("Student Form");
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
    public StudentForm(Menu menu,ReadWrite rw, AdminInfoFrame f ){
            
        super("Student Form");
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
    public StudentForm(Menu menu,ReadWrite rw, AdminInfoFrame f, Student s ){
            
        super("Student Form");
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
        msg = new JLabel("Enter Student Information :");
        msg.setFont(font.deriveFont(18.0f));
        msg.setForeground(btnBgColor);
        msg.setBounds(25, 25, 500, 20);
        panel.add(msg);

        name = new JLabel("Name :");
        name.setFont(font);
        name.setForeground(btnFwColor);
        name.setBounds(25, 75, 100, 20);
        panel.add(name);

        department = new JLabel("Departmnet :");
        department.setFont(font);
        department.setForeground(btnFwColor);
        department.setBounds(300, 75, 100, 20);
        panel.add(department);

        id = new JLabel("ID :");
        id.setFont(font);
        id.setForeground(btnFwColor);
        id.setBounds(25, 170, 100, 20);
        panel.add(id);

        cgpa = new JLabel("Cgpa :");
        cgpa.setFont(font);
        cgpa.setForeground(btnFwColor);
        cgpa.setBounds(300, 170, 100, 20);
        panel.add(cgpa);

        number = new JLabel("Number :");
        number.setFont(font);
        number.setForeground(btnFwColor);
        number.setBounds(25, 270, 100, 20);
        panel.add(number);

        section = new JLabel("Section :");
        section.setFont(font);
        section.setForeground(btnFwColor);
        section.setBounds(300, 270, 100, 20);
        panel.add(section);

        //__________________________________ComboBox________________________
        sections = new JComboBox(getSectionNames(menu.getSections()));
		sections.setFont(font.deriveFont(14.0f));
		sections.setBounds(300,300, 200, 20);
		panel.add(sections);
        

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

    public String[] getSectionNames(Section[] arr){
        String[] sections = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i] != null){
                sections[i] = ""+arr[i].getSectionName();
            }
        }
        return sections;
    }

    public void textFields(){
        //__________________________Text Fields__________________________
        nameField = new JTextField();
        nameField.setFont(font);
        nameField.setBounds(25, 105, 200, 20);
        panel.add(nameField);

        departmentField = new JTextField();
        departmentField.setFont(font);
        departmentField.setBounds(300, 105, 200, 20);
        panel.add(departmentField);

        idField = new JTextField();
        idField.setFont(font);
        idField.setBounds(25, 200, 200, 20);
        panel.add(idField);

        cgpaField = new JTextField();
        cgpaField.setFont(font);
        cgpaField.setBounds(300, 200, 200, 20);
        panel.add(cgpaField);

        numberField = new JTextField();
        numberField.setFont(font);
        numberField.setBounds(25, 300, 200, 20);
        panel.add(numberField);
    }
    public void modifyFields(Student s){
        //__________________________Modify Text Fields__________________________
        nameField = new JTextField(s.getName());
        nameField.setFont(font);
        nameField.setBounds(25, 105, 200, 20);
        panel.add(nameField);

        departmentField = new JTextField(s.getDepartment());
        departmentField.setFont(font);
        departmentField.setBounds(300, 105, 200, 20);
        panel.add(departmentField);

        idField = new JTextField(""+s.getID());
        idField.setFont(font);
        idField.setBounds(25, 200, 200, 20);
        panel.add(idField);

        cgpaField = new JTextField(""+s.getCgpa());
        cgpaField.setFont(font);
        cgpaField.setBounds(300, 200, 200, 20);
        panel.add(cgpaField);

        numberField = new JTextField(s.getNumber());
        numberField.setFont(font);
        numberField.setBounds(25, 300, 200, 20);
        panel.add(numberField);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == okbtn){
            if( (nameField.getText().equals("")) ||
                (idField.getText().equals("")) ||
                (numberField.getText().equals("")) || 
                (departmentField.getText().equals("")) ||
                (cgpaField.getText().equals("")) ){
                    JOptionPane.showMessageDialog(this, "Please enter all informations !", "Error..!!",JOptionPane.WARNING_MESSAGE);
                }
            else
                try{
                    char sectionName = ("" + sections.getItemAt(sections.getSelectedIndex())).charAt(0);
                    menu.addStudent(menu.getSection(sectionName).getStudents(), new Student(nameField.getText(), Integer.parseInt(idField.getText())+100000, numberField.getText(), departmentField.getText().toUpperCase(), Float.parseFloat(cgpaField.getText())));
                    if(s != null){menu.deleteStudent(s);}
                    this.dispose();
                    f.dispose();
                    new AdminInfoFrame(menu, rw, sectionName+"" );
                    }
                catch(Exception ex){
                    new ExceptionHandle(this).inputMissMatch();
                }    
        }
        else if(e.getSource() == resetbtn){
            nameField.setText("");
            idField.setText("");
            numberField.setText("");
            departmentField.setText("");
            cgpaField.setText("");
        }
        else if(e.getSource() == cancelbtn){
            this.dispose();
        }
        
    }
}
