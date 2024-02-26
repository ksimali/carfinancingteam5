package model;

public class Investor extends User {

    private String bankName;
    private char bankAccount;

    // Getters
    public String getBankName(){
        return bankName;
    }

    public char getBankAccount() {
        return bankAccount;
    }
    // Setters
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void setBankAccount(char bankAccount){
        this.bankAccount = bankAccount;
    }

    // Constructor
    public Investor(String name, String email, String password, String phone, String bankName, char bankAccount){
        super(name,email,password,phone);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    // Methods
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("Nom_Banque: "+bankName+"\n"+"Compte bancaire: "+ bankAccount);
    }
}
