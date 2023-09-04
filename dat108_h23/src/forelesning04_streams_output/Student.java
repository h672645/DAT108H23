package forelesning04_streams_output;
import java.util.ArrayList;
import java.util.List;
public class Student {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String fag;
    private char karakter;

    public Student(String fornavn, String etternavn, int alder, String fag, char karakter) {
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

    @Override
    public String toString() {
        return "Fornavn: " + fornavn + ", Etternavn: " + etternavn + ", Alder: " + alder + ", Fag: " + fag + ", Karakter: " + karakter;
    }
    
    static public List<Student> genererStudenter(){
    	
    	// Opprett en ArrayList for å lagre studentene
        List<Student> studentListe = new ArrayList<>();

        // Legg til 50 studentobjekter i listen
        studentListe.add(new Student("Ola", "Nordmann", 20, "Informatikk", 'A'));
        studentListe.add(new Student("Kari", "Hansen", 22, "Biologi", 'B'));
        studentListe.add(new Student("Maria", "Gonzalez", 25, "Språk", 'B')); 
        studentListe.add(new Student("Ahmed", "Ali", 26, "Informatikk", 'A')); 
        studentListe.add(new Student("Per", "Olsen", 21, "Historie", 'C'));
        studentListe.add(new Student("Maja", "Andersen", 23, "Psykologi", 'A'));
        studentListe.add(new Student("Erik", "Svensson", 19, "Datavitenskap", 'B'));
        studentListe.add(new Student("Jon", "Eide", 21, "Informatikk", 'A'));
        studentListe.add(new Student("Lise", "Strand", 20, "Fysikk", 'B'));
        studentListe.add(new Student("Andreas", "Svendsen", 24, "Kjemi", 'C'));
        studentListe.add(new Student("Sara", "Bakke", 23, "Matematikk", 'A'));
        studentListe.add(new Student("Per", "Kristiansen", 22, "Datavitenskap", 'B'));
        studentListe.add(new Student("Maria", "Gundersen", 21, "Biologi", 'A'));
        studentListe.add(new Student("Knut", "Pedersen", 20, "Informatikk", 'E'));
        studentListe.add(new Student("Marte", "Andersen", 22, "Fysikk", 'C'));
        studentListe.add(new Student("Geir", "Jensen", 23, "Kjemi", 'B'));
        studentListe.add(new Student("Sofie", "Olsen", 19, "Matematikk", 'A'));
        studentListe.add(new Student("Eva", "Larsen", 21, "Datavitenskap", 'B'));
        studentListe.add(new Student("Hans", "Sørensen", 24, "Biologi", 'C'));
        studentListe.add(new Student("Lisa", "Haugen", 23, "Informatikk", 'A'));
        studentListe.add(new Student("Jan", "Andersen", 20, "Fysikk", 'B'));
        studentListe.add(new Student("Camilla", "Olsen", 22, "Kjemi", 'A'));
        studentListe.add(new Student("Anders", "Svendsen", 21, "Matematikk", 'B'));
        studentListe.add(new Student("Mia", "Pedersen", 20, "Datavitenskap", 'C'));
        studentListe.add(new Student("Thomas", "Johansen", 25, "Informatikk", 'A'));
        studentListe.add(new Student("Sara", "Larsen", 23, "Biologi", 'B'));
        studentListe.add(new Student("Erik", "Hansen", 21, "Fysikk", 'A'));
        studentListe.add(new Student("Linda", "Andersen", 24, "Kjemi", 'B'));
        studentListe.add(new Student("Magnus", "Olsen", 22, "Matematikk", 'C'));
        studentListe.add(new Student("Anna", "Sørensen", 20, "Datavitenskap", 'A'));
        studentListe.add(new Student("Oscar", "Haugen", 19, "Informatikk", 'B'));
        studentListe.add(new Student("Per", "Olsen", 21, "Historie", 'C'));
        studentListe.add(new Student("Maja", "Andersen", 23, "Psykologi", 'A'));
        studentListe.add(new Student("Erik", "Svensson", 19, "Datavitenskap", 'B'));
        studentListe.add(new Student("Luca", "Moretti", 22, "Musikk", 'B')); 
        studentListe.add(new Student("Lars", "Johansen", 22, "Fysikk", 'C'));
        studentListe.add(new Student("Hanne", "Mortensen", 21, "Matematikk", 'A'));
        studentListe.add(new Student("Nina", "Eide", 24, "Sosiologi", 'B'));
        studentListe.add(new Student("Andreas", "Lund", 19, "Økonomi", 'C'));
        studentListe.add(new Student("Knut", "Bakke", 20, "Informatikk", 'A'));
        studentListe.add(new Student("Silje", "Kristensen", 22, "Biologi", 'B'));
        studentListe.add(new Student("Ida", "Haugen", 21, "Historie", 'C'));
        studentListe.add(new Student("Jon", "Solberg", 23, "Psykologi", 'A'));
        studentListe.add(new Student("Lise", "Thorsen", 19, "Datavitenskap", 'B'));
        studentListe.add(new Student("Tom", "Andersson", 20, "Kjemi", 'A'));
        studentListe.add(new Student("Tina", "Larsen", 22, "Fysikk", 'C'));
        studentListe.add(new Student("Lisa", "Strand", 19, "Økonomi", 'C'));
        studentListe.add(new Student("Mohammed", "Ibrahim", 25, "Informatikk", 'A')); 
        studentListe.add(new Student("Sophia", "Schmidt", 23, "Språk", 'B')); 
        studentListe.add(new Student("Diego", "Lopez", 22, "Kunst", 'A')); 

        return studentListe;


    }
}