import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dysk {

    private static String skrzynki = "skrzynki";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void zapisz(Skrzynka skrzynka) throws IOException {

        String nazwaSkrzynki = skrzynka.getNazwa();
        new File(skrzynki + "/" + nazwaSkrzynki).mkdirs();

        for (Folder folder : skrzynka.getFoldery()) {
            String nazwaFolderu = folder.getNazwa();
            new File(skrzynki + "/" + nazwaSkrzynki + "/" + nazwaFolderu).mkdirs();

            for (Wiadomosc wiadomosc : folder.getWiadomosci()) {
                FileWriter fileWriter = new FileWriter(skrzynki + "/" + nazwaSkrzynki + "/" + nazwaFolderu + "/" + wiadomosc.getId() + ".txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(wiadomosc.getId());
                printWriter.println(wiadomosc.getTemat());
                printWriter.println(wiadomosc.getOpis());
                printWriter.println(wiadomosc.getOdKogo());
                printWriter.println(wiadomosc.getDoKogo());
                printWriter.println(simpleDateFormat.format(wiadomosc.getDataWyslania()));
                printWriter.close();
            }
        }
    }

    public List<Skrzynka> odczyt() throws FileNotFoundException, ParseException {

        File[] katalogiSkrzynek = new File(skrzynki).listFiles(File::isDirectory);
        List<Skrzynka> listaSkrzynek = new ArrayList<>();
        box(katalogiSkrzynek, listaSkrzynek);

        return listaSkrzynek;
    }

    private void box(File[] katalogiSkrzynek, List<Skrzynka> listaSkrzynek) throws FileNotFoundException, ParseException {
        for (File file : katalogiSkrzynek){
            Skrzynka skrzynka = new Skrzynka(file.getName());
            listaSkrzynek.add(skrzynka);
            File[] katalogiFolderow = new File(skrzynki+"/"+ skrzynka.getNazwa()).listFiles(File::isDirectory);
            folder(skrzynka, katalogiFolderow);
        }
    }

    private void folder(Skrzynka skrzynka, File[] katalogiFolderow) throws FileNotFoundException, ParseException {
        for (File file1 : katalogiFolderow){
            Folder folder = new Folder(file1.getName());
            skrzynka.dodaj(folder);
            File[] katalogPlikow = new File(skrzynki+"/"+ skrzynka.getNazwa() +"/"+
                    folder.getNazwa()).listFiles(File::isFile);
            message(folder, katalogPlikow);
        }
    }

    private void message(Folder folder, File[] katalogPlikow) throws FileNotFoundException, ParseException {
        for (File file2 : katalogPlikow){
            Scanner scanner = new Scanner(file2);
            String[] tablicaWiadomosci = new String[6];
            int licznik =0;
            while(scanner.hasNextLine()){
                tablicaWiadomosci[licznik] = scanner.nextLine();
                licznik++;
            }
            Wiadomosc wiadomosc = new Wiadomosc(Integer.parseInt(tablicaWiadomosci[0]),
                    tablicaWiadomosci[1],tablicaWiadomosci[2],tablicaWiadomosci[3],
                    tablicaWiadomosci[4],simpleDateFormat.parse(tablicaWiadomosci[5]));
            folder.dodajWiadomosc(wiadomosc);
        }
    }
}
