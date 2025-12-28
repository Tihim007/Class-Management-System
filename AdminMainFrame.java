package Framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Classes.ExceptionHandle;
import Classes.Menu;
import Classes.ReadWrite;


public class AdminMainFrame extends JFrame implements ActionListener{
	
	
	private JPanel upperPanel,lowerPanel,rightPanel;
	private JLabel searchLabel,welcome,cms,version;
	private JTextField searchField;
	private JButton searchBtn,addBtn,modifyBtn,deleteBtn,showInfoBtn,logoutBtn,saveBtn; //backBtn,
	private JRadioButton adminRadioBtn,teacherRadioBtn,studentRadioBtn,sectionRadioBtn;
	private JComboBox dropBox;
	private Menu menu;
	private ReadWrite rw;
	private ExceptionHandle exHandle;

	private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
	private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);
	
	
	public AdminMainFrame(Menu menu, ReadWrite rw) {
	super("Class Management System");
	this.menu = menu;
	this.rw = rw;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setSize(1000,800);
	this.setResizable(false);
	exHandle = new ExceptionHandle(this);
		
	constructMainFrame();
	this.setVisible(true);
	
 	}

	public void actionPerformed(ActionEvent e) {
		try{
		//________________________________Search__________________________________
		if((e.getSource() == searchBtn) && (adminRadioBtn.isSelected() == true)){
			if(menu.getAdmin(Integer.parseInt(searchField.getText())) != null){
			this.dispose();
			new AdminInfoFrame(menu, rw, Integer.parseInt(searchField.getText()));
			}
			else 
			JOptionPane.showMessageDialog(this, "Admin Not Found");
		}
		else if( (e.getSource() == searchBtn) && (teacherRadioBtn.isSelected() == true) ){
			if(menu.getTeacher(Integer.parseInt(searchField.getText())) != null){
			this.dispose();
			new AdminInfoFrame(menu, rw, Integer.parseInt(searchField.getText()));
			}
			else
				JOptionPane.showMessageDialog(this, "Teacher Not Found");
		}
		else if( (e.getSource() == searchBtn) && (studentRadioBtn.isSelected() == true) ){
			if(menu.getStudent(Integer.parseInt(searchField.getText())) != null){
			this.dispose();
			new AdminInfoFrame(menu, rw, Integer.parseInt(searchField.getText()));
			}
			else
				JOptionPane.showMessageDialog(this, "Student Not Found");
		}
		else if( (e.getSource() == searchBtn) && (sectionRadioBtn.isSelected() == true) ){
			if(menu.getSection(searchField.getText().toUpperCase().charAt(0)) != null){
				this.dispose();
				new AdminInfoFrame(menu, rw, searchField.getText().toUpperCase().charAt(0));
			}
			else
				JOptionPane.showMessageDialog(this, "Section Not Found");
		}
		//___________________________________Add_________________________________
		else if( (e.getSource() == addBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Admin") ) ){
			System.out.println("Adding Admin");
			new AdminForm(menu, rw, this);
		}
		else if( (e.getSource() == addBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Adding Teacher");
			new TeacherForm(menu, rw, this);
		}
		else if( (e.getSource() == addBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Adding Student");
			new StudentForm(menu, rw, this);
		}
		else if( (e.getSource() == addBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Adding Section");
			new SectionForm(menu, rw, this);
			
		}
		//_______________________________Modify_________________________________
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Admin") ) ){
			System.out.println("Modifying Admin");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Admin");
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Modifying Teacher");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Teacher");
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Modifying Student");
			new SectionPopup(this,menu, rw);
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Modifying Section");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Section");
		}
		//_______________________________Delete____________________________
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Admin") ) ){
			System.out.print("Deleting Admin");
			new AdminInfoFrame(menu, rw, "Admin");
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Deleting Teacher");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Teacher");
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Deleting Student");
			new SectionPopup(this,menu, rw);
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Deleting Section");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Section");
		}
		//_______________________________Show All info_________________________________
		else if( (e.getSource() == showInfoBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Admin") ) ){
			System.out.println("Showing Admin");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Admin");
		}
		else if( (e.getSource() == showInfoBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Showing Teacher");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Teacher");
		}
		else if( (e.getSource() == showInfoBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Showing Student");
			new SectionPopup(this,menu, rw);
		}
		else if( (e.getSource() == showInfoBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Showing Section");
			this.dispose();
			new AdminInfoFrame(menu, rw, "Section");
		}	
		//_______________________________Save_______________________________________
		else if( e.getSource() == saveBtn){
			rw.writeAdmins(menu.getAdmins());
			rw.writeTeachers(menu.getTeachers());
			rw.writeSections(menu.getSections());
			System.out.println("Saving data");
		}
		//_______________________________Delete____________________________________
		else if( e.getSource() == logoutBtn){
			this.dispose();
			System.out.println("Logging out");
			new Login(menu, rw);
		}
	}
	catch(NullPointerException a){
		exHandle.nullPointer();
	}
	catch(NumberFormatException a){
		exHandle.numberFormat();
	}
	}






	public void constructMainFrame(){

		//----------------upper panel----------------//
		upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBackground(panelBgColor);
		upperPanel.setBounds(0, 0, 400, 300);
			
			
		searchLabel = new JLabel("Search Here :");
		searchLabel.setFont(font);
		searchLabel.setForeground(btnFwColor);
		searchLabel.setBounds(20, 20, 150, 25);
		upperPanel.add(searchLabel);
		
		//------------search text field---------------//
		searchField = new JTextField("");
		searchField.setFont(font.deriveFont(10.0f));
		searchField.setBounds(20, 60, 250, 25);
		upperPanel.add(searchField);
		
		//...........search button..............//
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds( 290, 60, 90, 25);
		searchBtn.setFont(font);
		searchBtn.setBackground(btnBgColor);
		searchBtn.setForeground(btnFwColor);
		searchBtn.addActionListener(this);
		upperPanel.add(searchBtn);
		
		//..............search radio button..............//
		
		adminRadioBtn = new JRadioButton("Admin");
		adminRadioBtn.setFont(font);
		adminRadioBtn.setBackground(Color.DARK_GRAY);
		adminRadioBtn.setForeground(Color.white);
		adminRadioBtn.setBounds( 20, 100, 70, 40 );
		adminRadioBtn.addActionListener(this);
		upperPanel.add(adminRadioBtn);
		
		teacherRadioBtn = new JRadioButton("Teacher");
		teacherRadioBtn.setFont(font);
		teacherRadioBtn.setBackground(Color.DARK_GRAY);
		teacherRadioBtn.setForeground(Color.white);
		teacherRadioBtn.setBounds( 200, 100, 100, 40 );
		teacherRadioBtn.addActionListener(this);
		upperPanel.add(teacherRadioBtn);
		
		studentRadioBtn = new JRadioButton("Student");
		studentRadioBtn.setFont(font);
		studentRadioBtn.setBackground(Color.DARK_GRAY);
		studentRadioBtn.setForeground(Color.white);
		studentRadioBtn.setBounds( 20, 150, 100, 40 );
		studentRadioBtn.addActionListener(this);
		upperPanel.add(studentRadioBtn);
		
		sectionRadioBtn = new JRadioButton("Section");
		sectionRadioBtn.setFont(font);
		sectionRadioBtn.setBackground(Color.DARK_GRAY);
		sectionRadioBtn.setForeground(Color.white);
		sectionRadioBtn.setBounds( 200, 150, 100, 40 );
		sectionRadioBtn.addActionListener(this);
		upperPanel.add(sectionRadioBtn);
		
		//........button group..........//
		ButtonGroup group = new ButtonGroup();
		group.add(adminRadioBtn);
		group.add(teacherRadioBtn);
		group.add(studentRadioBtn);
		group.add(sectionRadioBtn);
				

		//------------lower panel-------------------//
		
		lowerPanel = new JPanel();
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(panelBgColor);
		lowerPanel.setBounds(0,301, 400, 500);
		
		
		//...........lower panel button.................//
		
		
		addBtn = new JButton("Add");
		addBtn.setFont(font.deriveFont(15.0f));
		addBtn.setBackground(btnBgColor);
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBounds( 20, 30, 90, 30);
		addBtn.addActionListener(this);
		lowerPanel.add(addBtn);	
			
		modifyBtn = new JButton("Modify");
		modifyBtn.setFont(font);
		modifyBtn.setBackground(btnBgColor);
		modifyBtn.setForeground(btnFwColor);
		modifyBtn.setBounds( 20, 80, 90, 30);
		modifyBtn.addActionListener(this);
		lowerPanel.add(modifyBtn);
			
		deleteBtn = new JButton("Delete");
		deleteBtn.setFont(font);
		deleteBtn.setBackground(btnBgColor);
		deleteBtn.setForeground(btnFwColor);
		deleteBtn.setBounds( 20, 130, 90, 30);
		deleteBtn.addActionListener(this);
		lowerPanel.add(deleteBtn);	

		showInfoBtn = new JButton("Show Info");
		showInfoBtn.setFont(font);
		showInfoBtn.setBackground(btnBgColor);
		showInfoBtn.setForeground(btnFwColor);
		showInfoBtn.setBounds( 20, 180, 110, 30);
		showInfoBtn.addActionListener(this);
		lowerPanel.add(showInfoBtn);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setFont(font);
		logoutBtn.setBackground(btnBgColor);
		logoutBtn.setForeground(btnFwColor);
		logoutBtn.setBounds( 20, 400, 90, 30);
		logoutBtn.addActionListener(this);
		lowerPanel.add(logoutBtn);
		
		
		/*backBtn = new JButton("Back");
		backBtn.setFont(font);
		backBtn.setBackground(btnBgColor);
		backBtn.setForeground(btnFwColor);
		backBtn.setBounds( 200, 400, 90, 30);
		backBtn.addActionListener(this);
		lowerPanel.add(backBtn);	*/
		
		
		saveBtn = new JButton("Save");
		saveBtn.setFont(font);
		saveBtn.setBackground(btnBgColor);
		saveBtn.setForeground(btnFwColor);
		saveBtn.setBounds( 300, 400, 90, 30);
		saveBtn.addActionListener(this);
		lowerPanel.add(saveBtn);
		
		//...............drop down .............//
		String [] management = {"Admin", "Teacher", "Student" , "Section"};
		dropBox = new JComboBox(management);
		dropBox.setFont(font);
		dropBox.setBounds(300,30, 90, 30);
		lowerPanel.add(dropBox);
		
		
		//-----------------right panel----------------//
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBackground(panelBgColor);
		rightPanel.setBounds(401,0 , 600, 800);

		welcome = new JLabel("WELCOME");
		welcome.setBounds(150,250,400,50);
		welcome.setFont(font.deriveFont(55.0f));
		welcome.setForeground(btnBgColor);
		rightPanel.add(welcome);

		cms = new JLabel("Class Management System");
		cms.setBounds(205,300,400,50);
		cms.setFont(font);
		cms.setForeground(btnFwColor);
		rightPanel.add(cms);

		version = new JLabel("Version - 1.0");
		version.setBounds(255,320,400,50);
		version.setFont(font);
		version.setForeground(btnFwColor);
		rightPanel.add(version);
			
			
		this.add(upperPanel);
		this.add(lowerPanel);
		this.add(rightPanel);
	
	}
}
