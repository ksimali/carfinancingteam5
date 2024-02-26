package model;

import java.math.BigDecimal;

public class Client extends User {
    // Attributes
    private String job;
    private BigDecimal income;

    // Getters
    public String getJob() {
        return job;
    }
    public BigDecimal getIncome(){
        return income;
    }
    // Setters
    public void setJob(String job) {
        this.job = job;
    }
    public void setIncome(BigDecimal income){
        this.income = income;
    }

    // Constructor
    public Client(String name, String email, String password, String phone, String job, BigDecimal income){
        super(name, email, password, phone);
        this.job = job;
        this.income = income;
    }
    // Methods
    @Override
    public void afficherDetails(){
        super.afficherDetails();
        System.out.println("job: " + job +"\n"+ "income: "+income);
    }
}
