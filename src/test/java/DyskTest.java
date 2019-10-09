import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class DyskTest {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void dyskTest() throws IOException, ParseException {

        //given
        Dysk dysk = new Dysk();
        Skrzynka skrzynka = new Skrzynka("Nazwa");
        Folder odebrane = new Folder("Odebrane");
        Folder wyslane = new Folder("Wyslane");
        Folder kosz = new Folder("Kosz");
        skrzynka.dodaj(odebrane);
        skrzynka.dodaj(wyslane);
        skrzynka.dodaj(kosz);
        Wiadomosc wiadomosc1 = new Wiadomosc(1, "Temat1", "opis1",
                "emailOD1@op.pl", "emailDO1@op.pl",
                simpleDateFormat.parse("2019-09-02 19:54:09"));
        Wiadomosc wiadomosc2 = new Wiadomosc(2, "Temat2", "opis2",
                "emailOD2@op.pl", "emailDO2@op.pl",
                simpleDateFormat.parse("2019-010-03 20:04:09"));
        Wiadomosc wiadomosc3 = new Wiadomosc(3, "Temat3", "opis3",
                "emailOD3@op.pl", "emailDO3@op.pl",
                simpleDateFormat.parse("2019-09-02 08:14:03"));
        odebrane.dodajWiadomosc(wiadomosc1);
        wyslane.dodajWiadomosc(wiadomosc2);
        wyslane.dodajWiadomosc(wiadomosc3);

        //when
        dysk.zapisz(skrzynka);

        List<Skrzynka> listaSkrzynek = dysk.odczyt();
        assertEquals(2, listaSkrzynek.size());
        assertEquals("Nazwa",listaSkrzynek.get(0).getNazwa());
        assertEquals("stara",listaSkrzynek.get(1).getNazwa());
        assertEquals(3,listaSkrzynek.get(0).getFoldery().size());
        assertEquals(2,listaSkrzynek.get(1).getFoldery().size());

    }


}