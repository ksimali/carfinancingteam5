package model;

public class Financing {
    //attributes
    private String name;
    private String email;
    private String phone;
    private String vin;
    private int montant;
    private int duree;
    private int kilometre;

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getVin(){
        return vin;
    }
    public int getMontant(){
        return montant;
    }
    public int getDuree(){
        return duree;
    }
    public int getKilometre(){
        return kilometre;
    }
    // and Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setVin(String vin){
        this.vin = vin;
    }
    public void setMontant(){
        this.montant = montant;
    }
    public void setDuree(){
        this.duree = duree;
    }
    public void setKilometre(){
        this.kilometre = kilometre;
    }
    // Constructor
    public Financing(String name, String email, String phone, String vin, int montant, int duree, int kilometre){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.vin = vin;
        this.montant = montant;
        this.duree = duree;
        this.kilometre = kilometre;
    }

    // Methods
    public void afficherDetails(){
        System.out.println("Name: "+ name+ "\nEmail: " + email+"\nPhone:"
                + phone+"\nVIN: "+ vin + "\nMontant: "+ montant
                +"\nDurée: " + duree +"\nKm:" + kilometre);
    }
}
