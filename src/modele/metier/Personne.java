package modele.metier;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String dateNaissance;
    private String securiteSociale;
    private int age;

    public Personne(int id, String nom, String prenom, String sexe, String dateNaissance, String securiteSociale, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.securiteSociale = securiteSociale;
        this.age = age;
    }

    public String toString() {
        return ("Personne{" + "id=" + this.getId() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", sexe=" + this.getSexe() + ", dateNaissance=" + this.getDateNaissance() + ", securiteSociale=" + this.getSecuriteSociale() + ", age=" + this.getAge() +'}');
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSecuriteSociale() {
        return securiteSociale;
    }

    public void setSecuriteSociale(String securiteSociale) {
        this.securiteSociale = securiteSociale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

}
