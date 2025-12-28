package Framework;

import Classes.Menu;
import Classes.ReadWrite;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    private JLabel uidLable, passLabel;
    private JTextField uid;
    private JPasswordField password;
    private JButton btnLogin;
    private JPanel panel;
    public Menu menu;
    public ReadWrite rw;
    private Font font = new Font("Comic Sans MS", Font.PLAIN, 14);

    public Login(Menu menu, ReadWrite rw){
        //Main Frame
        super("Welcome");
        constructLogin();
        this.menu = menu;
        this.rw = rw;
        
    }


    public void constructLogin(){
        this.setBounds(400,200,400,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusableWindowState(true);
        this.setResizable(false);

        //Jpanel for adding components
        panel = new JPanel();
        panel.setBounds(0, 0, 400, 500);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        //JLabe to add image to frame
		JLabel imageLabel = new JLabel(new ImageIcon("Resources/logo.png"));
		imageLabel.setBounds(115,30,150,150);
		panel.add(imageLabel);

        //JLabel for uid
        uidLable = new JLabel("User ID  :");
        uidLable.setBounds(40,200 , 100, 30);
        uidLable.setFont(font);
        uidLable.setForeground(Color.white);
        panel.add(uidLable);
        //JLabel for Password
        uidLable = new JLabel("Password :");
        uidLable.setBounds(40,240 , 100, 30);
        uidLable.setFont(font);
        uidLable.setForeground(Color.white);
        panel.add(uidLable);

        //Jtextfield for uid
        uid = new JTextField("505678");
        uid.setBounds(130, 200, 200, 30);
        uid.setFont(font);
        panel.add(uid);
        //JPasswordfield for uid
        password = new JPasswordField("221B");
        password.setBounds(130, 240, 200, 30);
        panel.add(password);

        //JButton for login
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(150, 290, 100, 30);
        btnLogin.setFont(font);
        btnLogin.setBackground(new Color(50, 130, 246));
        btnLogin.setForeground(Color.white);
        btnLogin.addActionListener(this);
        panel.add(btnLogin);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (btnLogin == e.getSource()) {
            int id = Integer.parseInt(uid.getText());
            String pass = String.valueOf(password.getPassword());

            if (id == menu.getAdmin(id).getID() && pass.equals(menu.getAdmin(id).getPassword())) {
             
                uid.setText("");
                password.setText("");

                this.setVisible(false);
                System.out.println("Logging in");
                new AdminMainFrame(menu, rw);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
