package forelesning04_streams_input;
import java.util.ArrayList;
import java.util.List;
public class StudentIn {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String fag;
    private char karakter;

    public StudentIn(String fornavn, String etternavn, int alder, String fag, char karakter) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
        this.fag = fag;
        this.karakter = karakter;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getAlder() {
        return alder;
    }

    public String getFag() {
        return fag;
    }

    public char getKarakter() {
        return karakter;
    }

    public void setFag(String fag) {
        this.fag = fag;
    }
    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setKarakter(char karakter) {
        this.karakter = karakter;
    }

    @Override
    public String toString() {
        return "Fornavn: " + fornavn + ", Etternavn: " + etternavn + ", Alder: " + alder + ", Fag: " + fag + ", Karakter: " + karakter;
    }
    
    static public List<StudentIn> genererStudenter(){
    	
    	// Opprett en ArrayList for å lagre studentene
        List<StudentIn> studentListe = new ArrayList<>();

        // Legg til 50 studentobjekter i listen
        studentListe.add(new StudentIn("Ola", "Nordmann", 20, "Informatikk", 'A'));
        studentListe.add(new StudentIn("Kari", "Hansen", 22, "Biologi", 'B'));
        studentListe.add(new StudentIn("Maria", "Gonzalez", 25, "Språk", 'B')); 
        studentListe.add(new StudentIn("Ahmed", "Ali", 26, "Informatikk", 'A')); 
        studentListe.add(new StudentIn("Per", "Olsen", 21, "Historie", 'C'));
        studentListe.add(new StudentIn("Maja", "Andersen", 23, "Psykologi", 'A'));
        studentListe.add(new StudentIn("Erik", "Svensson", 19, "Datavitenskap", 'B'));
        studentListe.add(new StudentIn("Jon", "Eide", 21, "Informatikk", 'A'));
        studentListe.add(new StudentIn("Lise", "Strand", 20, "Fysikk", 'B'));
        studentListe.add(new StudentIn("Andreas", "Svendsen", 24, "Kjemi", 'C'));
        studentListe.add(new StudentIn("Sara", "Bakke", 23, "Matematikk", 'A'));
        studentListe.add(new StudentIn("Per", "Kristiansen", 22, "Datavitenskap", 'B'));
        studentListe.add(new StudentIn("Maria", "Gundersen", 21, "Biologi", 'A'));
        studentListe.add(new StudentIn("Knut", "Pedersen", 20, "Informatikk", 'B'));
        studentListe.add(new StudentIn("Marte", "Andersen", 22, "Fysikk", 'C'));
        studentListe.add(new StudentIn("Geir", "Jensen", 23, "Kjemi", 'B'));
        studentListe.add(new StudentIn("Sofie", "Olsen", 19, "Matematikk", 'A'));
        studentListe.add(new StudentIn("Eva", "Larsen", 21, "Datavitenskap", 'B'));
        studentListe.add(new StudentIn("Hans", "Sørensen", 24, "Biologi", 'C'));
        studentListe.add(new StudentIn("Lisa", "Haugen", 23, "Informatikk", 'A'));
        studentListe.add(new StudentIn("Jan", "Andersen", 20, "Fysikk", 'B'));
        studentListe.add(new StudentIn("Camilla", "Olsen", 22, "Kjemi", 'A'));
        studentListe.add(new StudentIn("Anders", "Svendsen", 21, "Matematikk", 'B'));
        studentListe.add(new StudentIn("Mia", "Pedersen", 20, "Datavitenskap", 'C'));
        studentListe.add(new StudentIn("Thomas", "Johansen", 25, "Informatikk", 'A'));
        studentListe.add(new StudentIn("Sara", "Larsen", 23, "Biologi", 'B'));
        studentListe.add(new StudentIn("Erik", "Hansen", 21, "Fysikk", 'A'));
        studentListe.add(new StudentIn("Linda", "Andersen", 24, "Kjemi", 'B'));
        studentListe.add(new StudentIn("Magnus", "Olsen", 22, "Matematikk", 'C'));
        studentListe.add(new StudentIn("Anna", "Sørensen", 20, "Datavitenskap", 'A'));
        studentListe.add(new StudentIn("Oscar", "Haugen", 19, "Informatikk", 'B'));
        studentListe.add(new StudentIn("Per", "Olsen", 21, "Historie", 'C'));
        studentListe.add(new StudentIn("Maja", "Andersen", 23, "Psykologi", 'A'));
        studentListe.add(new StudentIn("Erik", "Svensson", 19, "Datavitenskap", 'B'));
        studentListe.add(new StudentIn("Luca", "Moretti", 22, "Musikk", 'B')); 
        studentListe.add(new StudentIn("Lars", "Johansen", 22, "Fysikk", 'C'));
        studentListe.add(new StudentIn("Hanne", "Mortensen", 21, "Matematikk", 'A'));
        studentListe.add(new StudentIn("Nina", "Eide", 24, "Sosiologi", 'B'));
        studentListe.add(new StudentIn("Andreas", "Lund", 19, "Økonomi", 'C'));
        studentListe.add(new StudentIn("Knut", "Bakke", 20, "Informatikk", 'A'));
        studentListe.add(new StudentIn("Silje", "Kristensen", 22, "Biologi", 'B'));
        studentListe.add(new StudentIn("Ida", "Haugen", 21, "Historie", 'C'));
        studentListe.add(new StudentIn("Jon", "Solberg", 23, "Psykologi", 'A'));
        studentListe.add(new StudentIn("Lise", "Thorsen", 19, "Datavitenskap", 'B'));
        studentListe.add(new StudentIn("Tom", "Andersson", 20, "Kjemi", 'A'));
        studentListe.add(new StudentIn("Tina", "Larsen", 22, "Fysikk", 'C'));
        studentListe.add(new StudentIn("Lisa", "Strand", 19, "Økonomi", 'C'));
        studentListe.add(new StudentIn("Mohammed", "Ibrahim", 25, "Informatikk", 'A')); 
        studentListe.add(new StudentIn("Sophia", "Schmidt", 23, "Språk", 'B')); 
        studentListe.add(new StudentIn("Diego", "Lopez", 22, "Kunst", 'A')); 

        return studentListe;


    }
}