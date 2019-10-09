import java.util.ArrayList;
import java.util.List;

public class Skrzynka {

    private String nazwa;
    private List<Folder> foldery = new ArrayList<Folder>();

    public Skrzynka(String nazwa){
        this.nazwa = nazwa;
    }

    public void dodaj(Folder folder){

        foldery.add(folder);
    }

    public void usun(Folder folder){

        foldery.remove(folder);
    }

    public List<Folder> getFoldery() {
        return foldery;
    }

    public String getNazwa() {
        return nazwa;
    }
}
