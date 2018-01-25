package ir.ac.bonabu.khoonehbedoosh;


import ir.ac.bonabu.khoonehbedoosh.Server_Connection.SendUser;

/**
 * Created by Abolfazl 7x on 1/25/2018.
 */

public class User {
    String name="";
    String lastname="";
    String username="";
    String email="";
    String password="";
    String phone="";
    String nacode="";
    String city="";

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getNacode() {
        return nacode;
    }

    public String getCity() {
        return city;
    }

    public User(String name, String lastname, String username, String email, String password, String phone, String nacode){
this.name=name;
this.lastname=lastname;
this.username=username;
this.email=email;
this.password=password;
this.phone=phone;
this.nacode=nacode;
    }
    public void userSingUp(){

    }
}