package Framework;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Classes.ExceptionHandle;
import Classes.Menu;
import Classes.ReadWrite;
import Classes.sub.Admin;

public class AdminForm extends JFrame implements ActionListener {
    private JLabel name,id,number,designation,password,msg,typeOfAdmin;
    private JTextField nameField,idField,numberField,designationField,passwordField;
    private JButton okbtn,cancelbtn,resetbtn;
    private JPanel panel;
    private JComboBox adminType;
    private Menu menu;
    private JFrame f;
    private ReadWrite rw;
    private Admin a = null;

    private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
    private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);

    //______________________________constructor_________________________
    public AdminForm(Menu menu,ReadWrite rw, AdminMainFrame f ){
            
        super("Admin Form");
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
    public AdminForm(Menu menu,ReadWrite rw, AdminInfoFrame f ){
            
        super("Admin Form");
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
    public AdminForm(Menu menu,ReadWrite rw, AdminInfoFrame f, Admin ad ){
            
        super("Admin Form");
		this.menu = menu;
        this.f = f;
        this.rw = rw;
        this.a = ad;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(200, 100, 600, 600);
		this.setResizable(false);

        constructStudentForm();
        modifyFields(ad);
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
        msg = new JLabel("Enter Admin Information :");
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

        typeOfAdmin = new JLabel("Section :");
        typeOfAdmin.setFont(font);
        typeOfAdmin.setForeground(btnFwColor);
        typeOfAdmin.setBounds(300, 270, 100, 20);
        panel.add(typeOfAdmin);

        //__________________________________ComboBox________________________
        adminType = new JComboBox(new String[]{"Administration", "Academic"});
		adminType.setFont(font.deriveFont(14.0f));
		adminType.setBounds(300,300, 200, 20);
		panel.add(adminType);
        

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
    }
    public void modifyFields(Admin a){
        //__________________________Modify Text Fields__________________________
        nameField = new JTextField(a.getName());
        nameField.setFont(font);
        nameField.setBounds(25, 105, 200, 20);
        panel.add(nameField);

        designationField = new JTextField(a.getDesignation());
        designationField.setFont(font);
        designationField.setBounds(300, 105, 200, 20);
        panel.add(designationField);

        idField = new JTextField(""+a.getID());
        idField.setFont(font);
        idField.setBounds(25, 200, 200, 20);
        panel.add(idField);

        passwordField = new JTextField(a.getPassword());
        passwordField.setFont(font);
        passwordField.setBounds(300, 200, 200, 20);
        panel.add(passwordField);

        numberField = new JTextField(a.getNumber());
        numberField.setFont(font);
        numberField.setBounds(25, 300, 200, 20);
        panel.add(numberField);
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == okbtn){
            if( (nameField.getText().equals("")) ||
                (idField.getText().equals("")) ||
                (numberField.getText().equals("")) || 
                (designationField.getText().equals("")) ||
                (passwordField.getText().equals("")) ){
                    JOptionPane.showMessageDialog(this, "Please enter all informations !", "Error..!!",JOptionPane.WARNING_MESSAGE);
                }
            else
                try{
                    menu.addAdmin( new Admin(nameField.getText(), Integer.parseInt(idField.getText())+500000, numberField.getText(), designationField.getText(), ("" + adminType.getItemAt(adminType.getSelectedIndex())),passwordField.getText()) );
                    if(a!=null) {menu.deleteAdmin(a);}
                    this.dispose();
                    f.dispose();
                    new AdminInfoFrame(menu, rw, "Admin");
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
        }
        else if(e.getSource() == cancelbtn){
            this.dispose();
        }
        
    }
}
