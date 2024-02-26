package model;

public class User {
    // User attributes
    private String name;
    private String email;
    private String password;
    private String phone;

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getPhone(){
        return phone;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    // Constructor
    public User(String fullName, String email, String password, String phone){
        this.name = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    // Methods
    public void afficherDetails(){
        System.out.println("name: "+ name +"\n"+ "email: " + email +"\n"+ "password: "+ password+"\n"+"phone: "+ phone);
    }

}
