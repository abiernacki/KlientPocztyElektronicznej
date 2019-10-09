public class Kontakt {

    private String imie;
    private String nazwisko;
    private String email;

    public Kontakt(String imie, String nazwisko, String email){
        this.email = email;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getEmail() {
        return email;
    }
}
