package Classes.sub;

import Classes.Person;
import Interfaces.IAdmin;

public class Admin extends Person implements IAdmin{

    private String Designation;
    private String AdminType;
    private String Password;

    public Admin(){}
    public Admin(String Name, int ID, String Number, String Designation, String AdminType, String Password) {
        super(Name, ID, Number);        //, Age, Address);
        this.Designation = Designation;
        this.AdminType = AdminType;
        this.Password = Password;
    }

    public void setDesignation(String designation) {Designation = designation;}
    public void setAdminType(String adminType) {AdminType = adminType;}
    public void setPassword(String password) {Password = password;}
    
    public String getDesignation() {return Designation;}
    public String getAdminType() {return AdminType;}
    public String getPassword() {return Password;}
    
    public void showInfo(){
        super.showInfo();
        System.out.println("Designation\t: " + Designation);
        System.out.println("Admin Type\t: " + AdminType);
    }
    
}
