package model;

public class Investor extends User {
    // Attributes
    private String bankName;
    private String bankAccount;

    // Getters
    public String getBankName(){
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }
    // Setters
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }

    // Constructor
    public Investor(String name, String email, String password, String phone, String bankName, String bankAccount){
        super(name,email,password,phone);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    // Methods
    @Override
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("Nom_Banque: "+bankName+"\n"+"Compte bancaire: "+ bankAccount);
    }
}
