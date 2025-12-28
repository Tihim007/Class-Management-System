package Classes.sub;

public class AdminManager {
   
    Admin[] Admins;

    public AdminManager(Admin[] arr){
        Admins = arr;
    }

    public void addAdmin(Admin admin){
        boolean flag = false;
        for (int i=0; i<Admins.length; i++){
            if(Admins[i] == null){
                Admins[i] = admin;
                flag = true;
                break;
            }
        }
        if (flag)
        System.out.println("New Admin Added..");
        else
        System.out.println("Failed to add Admin..");
    }
    public void deleteAdmin(Admin admin){
        boolean flag = false;
        for (int i=0; i<Admins.length; i++){
            if(Admins[i] != null){
                if(Admins[i] == admin){
                    Admins[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Admin deleted..");
        else
        System.out.println("Failed to delete Admin..");
    }
    public Admin getAdmin(int id){
        boolean flag = false;
        Admin admin = null;
        for (int i=0; i<Admins.length; i++){
            if(Admins[i] != null){
                if(Admins[i].getID() == id){
                    admin = Admins[i];
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
        System.out.println("Admin found..");
        else
        System.out.println("Admin not found..");

        return admin;
    }

    public Admin[] getAdmins() {
        return Admins;
    }

    public void setAdmins(Admin[] admins) {
        Admins = admins;
    }
}
