import sun.nio.cs.KOI8_R;

import java.util.ArrayList;
import java.util.List;

public class KsiazkaKontaktowa {

    private List<Kontakt> listaKontaktow = new ArrayList<>();

    public void dodajKontakt(Kontakt kontakt){

        listaKontaktow.add(kontakt);
    }

    public void usunKontakt(Kontakt kontakt){

        listaKontaktow.remove(kontakt);
    }

    public Kontakt wyszukaj(String kryteria){

        for (Kontakt kontakt1 : listaKontaktow){
            if (kontakt1.getImie().contains(kryteria)){
                return kontakt1;
            }
            if (kontakt1.getNazwisko().contains(kryteria)){
                return kontakt1;
            }
            if (kontakt1.getEmail().contains(kryteria)){
                return kontakt1;
            }
        }

        return null;
    }

    public List<Kontakt> getListaKontaktow() {
        return listaKontaktow;
    }
}
