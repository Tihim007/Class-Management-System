package Classes;

import Interfaces.IPerson;

public abstract class Person implements IPerson{

    private String Name;
    private int ID;
    private String Number;
    //private int Age;
    //private String Address;

    public Person() {}
    public Person(String Name, int ID, String Number){      //, int Age, String Address) {
        this.Name = Name;
        this.ID = ID;
        this.Number = Number;
        //this.Age = Age;
        //this.Address = Address;
    }
    
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getID() {
        return ID;
    }
    public void setID(int id) {
        ID = id;
    }
    public String getNumber() {
        return Number;
    }
    public void setNumber(String number) {
        Number = number;
    }
    /*public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }*/

    public void showInfo(){
        System.out.println("Name\t\t: " + Name);
        System.out.println("ID\t\t: " + ID);
        System.out.println("Number\t\t: " + Number);
        //System.out.println("Age\t\t: " + Age);
        //System.out.println("Address\t\t: " + Address);
    }
    
}