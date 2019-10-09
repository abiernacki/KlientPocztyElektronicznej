import java.util.Date;

public class Wiadomosc {

    private int id;
    private String temat;
    private String opis;
    private String odKogo;
    private String doKogo;
    private Date dataWyslania;

    public Wiadomosc(int id, String temat, String opis, String odKogo, String doKogo, Date dataWyslania){
        this.dataWyslania = dataWyslania;
        this.doKogo = doKogo;
        this.odKogo = odKogo;
        this.opis = opis;
        this.temat = temat;
        this.id = id;
    }

    public String getTemat() {
        return temat;
    }

    public Date getDataWyslania() {
        return dataWyslania;
    }

    public String getDoKogo() {
        return doKogo;
    }

    public String getOdKogo() {
        return odKogo;
    }

    public String getOpis() {
        return opis;
    }

    public int getId() {
        return id;
    }
}
