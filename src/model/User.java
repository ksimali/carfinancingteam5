package model;

public class User {
    // User attributes
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String sel;

    // Getters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
    public String getSel() {
        return sel;
    }
    public void setSel(String sel) {
        this.sel = sel;
    }

    // Constructor
    public User() {}
    public User(String name, String email, String password, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    // Methods
    public void afficherDetails(){
        System.out.println("name: "+ name +"\n"+ "email: " + email +"\n"+ "password: "+ password+"\n"+"phone: "+ phone);
    }



}
