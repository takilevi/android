package hu.homework.login;

/**
 * Created by TAKI on 2016.12.06..
 */

public class Contact {
    int id;
    String name, email, address,pass;
    int isadmin;

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public void setAdmin(boolean isadmin){
        if(isadmin){this.isadmin=1;}
        else{this.isadmin=0;}
    }
    public int getAdmin(){return isadmin;}
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setEmail(String email){this.email=email;}
    public String getEmail(){return email;}
    public void setAddress(String addr){this.address=addr;}
    public String getAddress(){return address;}
    public void setPass(String pass){this.pass=pass;}
    public String getPass(){return pass;}


}
