import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KsiazkaKontaktowaTest {

    @Test
    public void ksiazkaTest(){

        //given
        Kontakt kontakt1 = new Kontakt("Adrian","Biernacki","adrianbie86@gmail.com");
        Kontakt kontakt2 = new Kontakt("Pamela","Biernacka","pamelaop@gmail.com");
        Kontakt kontakt3 = new Kontakt("Stefan","Podgrski","stefan@gmail.com");
        KsiazkaKontaktowa ksiazkaKontaktowa = new KsiazkaKontaktowa();

        //when
        ksiazkaKontaktowa.dodajKontakt(kontakt1);
        ksiazkaKontaktowa.dodajKontakt(kontakt2);
        ksiazkaKontaktowa.dodajKontakt(kontakt3);

        List<Kontakt> listaKontaktow = ksiazkaKontaktowa.getListaKontaktow();

        //then
        assertTrue(listaKontaktow.contains(kontakt2));
        assertEquals(kontakt2,ksiazkaKontaktowa.wyszukaj("Pamela"));
        assertNull(ksiazkaKontaktowa.wyszukaj("Zenon"));

    }

    @Test
    public void ksiazkaTestUsun(){

        //given
        Kontakt kontakt1 = new Kontakt("Adrian","Biernacki","adrianbie86@gmail.com");
        Kontakt kontakt2 = new Kontakt("Pamela","Biernacka","pamelaop@gmail.com");
        Kontakt kontakt3 = new Kontakt("Stefan","Podgrski","stefan@gmail.com");
        KsiazkaKontaktowa ksiazkaKontaktowa = new KsiazkaKontaktowa();

        //when
        ksiazkaKontaktowa.dodajKontakt(kontakt1);
        ksiazkaKontaktowa.dodajKontakt(kontakt2);
        ksiazkaKontaktowa.dodajKontakt(kontakt3);

        List<Kontakt> listaKontaktow = ksiazkaKontaktowa.getListaKontaktow();

        //then
        assertEquals(3,listaKontaktow.size());
        ksiazkaKontaktowa.usunKontakt(kontakt3);
        listaKontaktow = ksiazkaKontaktowa.getListaKontaktow();
        assertEquals(2,listaKontaktow.size());


    }


}