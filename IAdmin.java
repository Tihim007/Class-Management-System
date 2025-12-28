package Interfaces;

public interface IAdmin {
    public void setDesignation(String designation);
    public void setAdminType(String adminType);
    public void setPassword(String password);
    
    public String getDesignation();
    public String getAdminType();
    public String getPassword();
    
    public void showInfo();
}
