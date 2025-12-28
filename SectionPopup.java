package Framework;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classes.Menu;
import Classes.ReadWrite;
import Classes.Section;

import java.awt.*;
import java.awt.event.*;

public class SectionPopup extends JFrame implements ActionListener{

    private Menu menu;
    private ReadWrite rw;
    private JLabel select;
    private JButton OkBtn;
    private JComboBox sections;
    private JFrame amf;
    Font font = new Font("Comic Sans MS", Font.PLAIN, 18);

    public SectionPopup(AdminMainFrame amf ,Menu menu, ReadWrite rw){
        super("Select Section");
        this.rw =  rw;
        this.menu = menu;
        this.amf = amf;

        constructFrame();
        this.setVisible(true);
    }
    public SectionPopup(AdminInfoFrame amf ,Menu menu, ReadWrite rw){
        super("Select Section");
        this.rw =  rw;
        this.menu = menu;
        this.amf = amf;

        constructFrame();
        this.setVisible(true);
    }

    public void constructFrame(){
        this.setBounds(400,200,400,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setFocusableWindowState(true);
        this.setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 500);
        panel.setBackground(Color.DARK_GRAY);

        select = new JLabel("Please select Section :");
        select.setBounds(40,50 , 400, 20);
        select.setFont(font);
        select.setForeground(new Color(50, 130, 246));
        panel.add(select);

        OkBtn = new JButton("OK");
		OkBtn.setFont(font);
		OkBtn.setBackground(new Color(50, 130, 246));
		OkBtn.setForeground(Color.WHITE);
		OkBtn.setBounds( 250, 265, 90, 30);
		OkBtn.addActionListener(this);
		panel.add(OkBtn);

        sections = new JComboBox(getSectionNames(menu.getSections()));
		sections.setFont(font.deriveFont(14.0f));
		sections.setBounds(40,90, 190, 20);
		panel.add(sections);

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


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == OkBtn){
            new AdminInfoFrame(menu, rw, ("" + sections.getItemAt(sections.getSelectedIndex())) );
            this.dispose();
            amf.dispose();
        }
    }
    
}
