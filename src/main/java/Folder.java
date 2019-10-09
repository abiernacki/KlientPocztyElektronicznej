import java.util.ArrayList;
import java.util.List;

public class Folder {

    private String nazwa;
    private List<Wiadomosc> wiadomosci = new ArrayList<Wiadomosc>();

    public Folder(String nazwa){
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void dodajWiadomosc(Wiadomosc wiadomosc){

        wiadomosci.add(wiadomosc);
    }

    public List<Wiadomosc> getWiadomosci() {
        return wiadomosci;
    }
}
