package Framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classes.ExceptionHandle;
import Classes.Menu;
import Classes.ReadWrite;
import Classes.Section;
import Classes.sub.Admin;
import Classes.sub.Student;
import Classes.sub.Teacher;

public class AdminInfoFrame extends JFrame implements ActionListener {
    
	private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);
	private JPanel upperPanel,lowerPanel,rightPanel;
	private JLabel searchLabel;
	private JTextField searchField;
	private JButton searchBtn,addBtn,modifyBtn,deleteBtn,showInfoBtn,logoutBtn,backBtn,saveBtn;
	private JRadioButton adminRadioBtn,teacherRadioBtn,studentRadioBtn,sectionRadioBtn;
	private JComboBox dropBox;
	private JTable table;
	private DefaultTableModel tableModel;
	private Menu menu;
	private ReadWrite rw;
	private ExceptionHandle exHandle;

	
	private Color panelBgColor= Color.DARK_GRAY;
	private Color btnBgColor= new Color(50, 130, 246);
	private Color btnFwColor= new Color(255, 255, 255);
	



	//______________________________Constructor__________________________
	public AdminInfoFrame(Menu menu, ReadWrite rw, String s) {
		super("Class Management System");
		this.menu = menu;
		this.rw = rw;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000,800);
		this.setResizable(false);
		exHandle = new ExceptionHandle(this);
			
		constructAdminInfoFrame();
		dataTable(s);
		
		this.add(upperPanel);
		this.add(lowerPanel);
		this.add(rightPanel);
		this.setVisible(true);
	
 	}
	 public AdminInfoFrame(Menu menu, ReadWrite rw, int s) {
		super("Class Management System");
		this.menu = menu;
		this.rw = rw;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000,800);
		this.setResizable(false);
		exHandle = new ExceptionHandle(this);
			
		constructAdminInfoFrame();
		searchResult(s);
		
		this.add(upperPanel);
		this.add(lowerPanel);
		this.add(rightPanel);
		this.setVisible(true);
	
 	}
	 public AdminInfoFrame(Menu menu, ReadWrite rw, char s) {
		super("Class Management System");
		this.menu = menu;
		this.rw = rw;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000,800);
		this.setResizable(false);
		exHandle = new ExceptionHandle(this);
			
		constructAdminInfoFrame();
		searchResult(s);
		
		this.add(upperPanel);
		this.add(lowerPanel);
		this.add(rightPanel);
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
			modifyAdmin();
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Modifying Teacher");
			modifyTeacher();
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Modifying Student");
			modifyStudent();
		}
		else if( (e.getSource() == modifyBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Modifying Section");
			modifySection();
		}
		//_______________________________Delete____________________________
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Admin") ) ){
			System.out.println("Deleting Admin");
			deleteAdmins();
			//JOptionPane.showMessageDialog(this, "Cannot Delete Admin", "Error..!!",JOptionPane.ERROR_MESSAGE);
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Teacher") ) ){
			System.out.println("Deleting Teacher");
			deleteTeachers();
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Student") ) ){
			System.out.println("Deleting Student");
			deleteStudents();
		}
		else if( (e.getSource() == deleteBtn) && (dropBox.getItemAt(dropBox.getSelectedIndex()).equals("Section") ) ){
			System.out.println("Deleting Section");
			deleteSections();
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
		//__________________________________Back______________________________________
		else if( e.getSource() == backBtn){
			this.dispose();
			new AdminMainFrame(menu, rw);
		}}
		catch(NullPointerException a){
			exHandle.nullPointer();
		}
		catch(NumberFormatException a){
			exHandle.numberFormat();
		}
	}


	public void dataTable(String s){
		tableModel = new DefaultTableModel();

		if(s.equals("Admin")){
			adminDataTable();
		}
		else if(s.equals("Teacher")){
			teacherDataTable();
		}
		else if(s.equals("Section")){
			sectionDataTable();
		}
		else 
			studentDataTable(s.charAt(0));

		table = new JTable(tableModel);
		table.setBounds(50, 50, 500, 650);
		table.setFont(font);
		table.setBackground(panelBgColor);
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(btnBgColor);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 500, 650);
		rightPanel.add(scrollPane);
		
	}


	public void searchResult(char s){
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Section Name");
		tableModel.addColumn("Course Name");
		tableModel.addColumn("Tacher Name");
		
		tableModel.addRow(new Object[]	{
			menu.getSection(s).getSectionName(),
			menu.getSection(s).getCourseName(),
			menu.getSection(s).getTeacher().getName()
		});

		table = new JTable(tableModel);
		table.setBounds(50, 50, 500, 650);
		table.setFont(font);
		table.setBackground(panelBgColor);
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(btnBgColor);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 500, 650);
		rightPanel.add(scrollPane);
	}

	public void searchResult(int id){
		tableModel = new DefaultTableModel();
		if(id>500000){
			tableModel.addColumn("Name");
			tableModel.addColumn("Id");
			tableModel.addColumn("Number");
			tableModel.addColumn("Designation");
			tableModel.addColumn("Admin Type");

			tableModel.addRow(new Object[]	{
				menu.getAdmin(id).getName(),
				menu.getAdmin(id).getID(),
				menu.getAdmin(id).getNumber(),
				menu.getAdmin(id).getDesignation(),
				menu.getAdmin(id).getAdminType()
			});
		}
		else if(300000 < id && id < 500000){
			tableModel.addColumn("Name");
			tableModel.addColumn("Id");
			tableModel.addColumn("Number");
			tableModel.addColumn("Designation");
			tableModel.addColumn("Faculty of");
			tableModel.addColumn("Salery");

			tableModel.addRow(new Object[]	{
				menu.getTeacher(id).getName(),
				menu.getTeacher(id).getID(),
				menu.getTeacher(id).getNumber(),
				menu.getTeacher(id).getDesignation(),
				menu.getTeacher(id).getFacultyOf(),
				menu.getTeacher(id).getSalery()
			});
		}
		else if(id<300000){
			tableModel.addColumn("Name");
			tableModel.addColumn("Id");
			tableModel.addColumn("Number");
			tableModel.addColumn("Department");
			tableModel.addColumn("CGPA");

			tableModel.addRow(new Object[]	{
				menu.getStudent(id).getName(),
				menu.getStudent(id).getID(),
				menu.getStudent(id).getNumber(),
				menu.getStudent(id).getDepartment(),
				menu.getStudent(id).getCgpa()
			});
		}


		table = new JTable(tableModel);
		table.setBounds(50, 50, 500, 650);
		table.setFont(font);
		table.setBackground(panelBgColor);
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(btnBgColor);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 500, 650);
		rightPanel.add(scrollPane);
	}
    
    public void constructAdminInfoFrame(){

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
		
		//........Search radio button group..........//
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
		
		backBtn = new JButton("Back");
		backBtn.setFont(font);
		backBtn.setBackground(btnBgColor);
		backBtn.setForeground(btnFwColor);
		backBtn.setBounds( 200, 400, 90, 30);
		backBtn.addActionListener(this);
		lowerPanel.add(backBtn);	
		
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
	
	}

	public void deleteAdmins(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >=1){
			Arrays.sort(selectedRows);
 			
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				
				int idNumber = Integer.parseInt( table.getModel().
						getValueAt(selectedRows[i], 1).toString()  );
											
					Admin a = menu.getAdmin(idNumber);
					if (a != null) {
						tableModel.removeRow(selectedRows[i]);
						menu.deleteAdmin(a);
					}

					if (i == 0) {
						// Popup Dialog
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
	}
	public void deleteTeachers(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >=1){
			Arrays.sort(selectedRows);
 			
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				
				int idNumber = Integer.parseInt( table.getModel().
						getValueAt(selectedRows[i], 1).toString()  );
											
					Teacher a = menu.getTeacher(idNumber);
					if (a != null) {
						tableModel.removeRow(selectedRows[i]);
						menu.deleteTeacher(a);
					}

					if (i == 0) {
						// Popup Dialog
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
	}
	public void deleteStudents(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >=1){
			Arrays.sort(selectedRows);
 			
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				
				int idNumber = Integer.parseInt( table.getModel().
						getValueAt(selectedRows[i], 1).toString()  );
											
					Student a = menu.getStudent(idNumber);
					if (a != null) {
						tableModel.removeRow(selectedRows[i]);
						menu.deleteStudent(a);
					}

					if (i == 0) {
						// Popup Dialog
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
	}
	public void deleteSections(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >=1){
			Arrays.sort(selectedRows);
 			
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				
				char sname = table.getModel().getValueAt(selectedRows[i], 0).toString().toUpperCase().charAt(0);
											
					Section a = menu.getSection(sname);
					if (a != null) {
						tableModel.removeRow(selectedRows[i]);
						menu.deleteSection(a);
					}

					if (i == 0) {
						// Popup Dialog
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	//_____________________________________Modify Data_______________________________
	public void modifyAdmin(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >1){
			JOptionPane.showMessageDialog(this, "Please Select one Row to Modify. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
		else
 			new AdminForm(menu,rw,this, menu.getAdmin(Integer.parseInt( table.getModel().
			 getValueAt(selectedRows[0], 1).toString()  )) );
	}
	public void modifyTeacher(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >1){
			JOptionPane.showMessageDialog(this, "Please Select one Row to Modify. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
		else
 			new TeacherForm(menu,rw,this, menu.getTeacher(Integer.parseInt( table.getModel().
			 getValueAt(selectedRows[0], 1).toString()  )) );
	}
	public void modifyStudent(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >1){
			JOptionPane.showMessageDialog(this, "Please Select one Row to Modify. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
		else
 			new StudentForm(menu,rw,this, menu.getStudent(Integer.parseInt( table.getModel().
			 getValueAt(selectedRows[0], 1).toString()  )) );
	}
	public void modifySection(){
		int selectedRows[] = table.getSelectedRows();
		if(selectedRows.length >1){
			JOptionPane.showMessageDialog(this, "Please Select one Row to Modify. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
		}
		else
 			new SectionForm(menu,rw,this, menu.getSection( table.getModel().getValueAt(selectedRows[0], 0).toString().toUpperCase().charAt(0)));
	}


	//_____________________________________DataTables_________________________________
	public void adminDataTable(){
		tableModel.addColumn("Name");
		tableModel.addColumn("Id");
		tableModel.addColumn("Number");
		tableModel.addColumn("Designation");
		tableModel.addColumn("Admin Type");

		for(int i=0; i<menu.getAdmins().length; i++){
			if(menu.getAdmins()[i] != null){
				tableModel.addRow(new Object[]	{
					menu.getAdmins()[i].getName(),
					menu.getAdmins()[i].getID(),
					menu.getAdmins()[i].getNumber(),
					menu.getAdmins()[i].getDesignation(),
					menu.getAdmins()[i].getAdminType()
				});
			}
		}
	}
	public void teacherDataTable(){
		tableModel.addColumn("Name");
		tableModel.addColumn("Id");
		tableModel.addColumn("Number");
		tableModel.addColumn("Designation");
		tableModel.addColumn("Faculty of");
		tableModel.addColumn("Salery");

		for(int i=0; i<menu.getTeachers().length; i++){
			if(menu.getTeachers()[i] != null){
				tableModel.addRow(new Object[]	{
					menu.getTeachers()[i].getName(),
					menu.getTeachers()[i].getID(),
					menu.getTeachers()[i].getNumber(),
					menu.getTeachers()[i].getDesignation(),
					menu.getTeachers()[i].getFacultyOf(),
					menu.getTeachers()[i].getSalery()
				});
			}
		}
	}
	public void sectionDataTable(){
		tableModel.addColumn("Section Name");
		tableModel.addColumn("Course Name");
		tableModel.addColumn("Tacher Name");

		for(int i=0; i<menu.getSections().length; i++){
			if(menu.getSections()[i] != null){
				tableModel.addRow(new Object[]	{
					menu.getSections()[i].getSectionName(),
					menu.getSections()[i].getCourseName(),
					menu.getSections()[i].getTeacher().getName()
				});
			}
		}
	}
	public void studentDataTable(char s){
		tableModel.addColumn("Name");
		tableModel.addColumn("Id");
		tableModel.addColumn("Number");
		tableModel.addColumn("Department");
		tableModel.addColumn("CGPA");
		//tableModel.addColumn("Attendence");

		for(int i=0; i<menu.getSection(s).getStudents().length; i++){
			if(menu.getSection(s).getStudents()[i] != null){
				tableModel.addRow(new Object[]	{
					menu.getSection(s).getStudents()[i].getName(),
					menu.getSection(s).getStudents()[i].getID(),
					menu.getSection(s).getStudents()[i].getNumber(),
					menu.getSection(s).getStudents()[i].getDepartment(),
					menu.getSection(s).getStudents()[i].getCgpa()
					//menu.getSection(s).getStudents()[i].getAttendence()
				});
			}
		}
	}

}
