package model;

import java.math.BigDecimal;
import java.util.Date;

public class Client extends User {
    // Attributes
    private String occupation;
    private BigDecimal income;
    private int creditScore;
    private Date birthday;
    private String maritalStatus;
    private int residencyPeriod;
    // Getters
    public String getOccupation() {
        return occupation;
    }
    public BigDecimal getIncome(){
        return income;
    }
    public int getCreditScore(){
        return creditScore;
    }
    public Date getBirthday(){
        return birthday;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public int getResidencyPeriod(){
        return residencyPeriod;
    }
    // Setters
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public void setIncome(BigDecimal income){
        this.income = income;
    }
    public void setCreditScore(int creditScore){
        this.creditScore = creditScore;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }
    public void setResidencyPeriod(int residencyPeriod){
        this.residencyPeriod = residencyPeriod;
    }
    // Constructor
    public Client(String name, String email, String password, String phone, String job, BigDecimal income){
        super(name, email, password, phone);
        this.occupation = job;
        this.income = income;
        this.creditScore = creditScore;
        this.birthday = birthday;
        this.maritalStatus = maritalStatus;
        this.residencyPeriod = residencyPeriod;
    }
    // Methods
    @Override
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("Occupation: " + occupation +"\n"+ "Revenue: "+ income +"\n"+ "Credit score: "+ creditScore+"\n");
        System.out.println( "Date de naissance: "+birthday+"\n"+"Status marital: "+ maritalStatus +"\n"+ "Etabli au canada depuis: "+residencyPeriod);
    }
}
