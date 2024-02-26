package model;

public class Investor extends User {
    // Attributes
    private String bankName;
    private String bankAccount;
    private String riskLevel;
    private String financialEducation;

    // Getters
    public String getBankName(){
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }
    public String getRiskLevel(){
        return riskLevel;
    }
    public String getFinancialEducation(){
        return financialEducation;
    }
    // Setters
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }
    public void setRiskLevel(String riskLevel){
        this.riskLevel = riskLevel;
    }
    public void setInvestmentLiteracy(String financialEducation){
        this.financialEducation = financialEducation;
    }
    // Constructor
    public Investor(String name, String email, String password, String phone, String bankName, String bankAccount, String riskLevel,String financialEducation){
        super(name,email,password,phone);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.riskLevel = riskLevel;
        this.financialEducation = financialEducation;
    }

    // Methods
    @Override
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("Nom_Banque: "+bankName+"\n"+"Compte bancaire: "+ bankAccount+"\n"+"Niveau_risque: "+riskLevel+"\n"+"Education financière: "+ financialEducation);
    }
}
