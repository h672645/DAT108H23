package forelesning04_output_streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;

public class Hoved {


	/* Dette er et løsningsforslag til oppgavene vi gikk gjennom i 
	 * forelesning. Noen av spørsmålene endret vi litt på underveis. 
	 * De orginale oppgavene finner dere i pakken 
	 * forelesning04_input_streams.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {

		// Liste med heltall
        Integer[] tallArray = {42, 17, 99, 33, 88, 5, 21, 77, 12, 63};
        List<Integer> tall = Arrays.asList(tallArray);
        
       
		// Liste med strenger
        String[] strengerArray = {"Eple", "Banan", "Appelsin", "Pære", "Kiwi", "Druer", "Jordbær", "Mango"};
        List<String> strenger = Arrays.asList(strengerArray);
        
        // Liste med studenter

        List<Student> studenter = Student.genererStudenter();



		// --------------- ØVELSER MED FILTER--------------- //
        
        /* Øvelse 1: Filtrer partall
		 * 
		 * Gitt en liste med heltall, bruk 
		 * en strøm (stream) til å filtrere ut og opprette en ny liste 
		 * som kun inneholder partall.
		 * 
		 */
		

        
        List<Integer> tallUt = tall.stream()
        		.filter(a -> a % 2 == 0)
        		.toList();
        		
        
       // System.out.println(tallUt);

		
		/* Øvelse 2: Filtrer strenger etter lengde
		 * Bruk en strøm til å filtrere og opprette en ny liste som kun 
		 * inneholder strenger som har en lengde større enn en angitt verdi 
		 * (for eksempel 5 tegn).
		 * 
		 */

       

        List<String> strengerUt = strenger.stream()
        		.filter(s -> s.length() > 5)
        		.toList();
        

        
//        System.out.println(strengerUt);
		
        
        /* Øvelse 3: Filtrer studenter etter karakter
		 * 
		 * Gitt en liste med studentobjekter, bruk en strøm til å 
		 * filtrere og opprette en ny liste som kun inneholder 
		 * studenter som har oppnådd karakteren "A".
		 * 
		 */
        
        

        studenter.stream()
        		.filter(stud -> stud.getKarakter() == 'A')
        		.forEach(stud -> {} );//System.out::println);

//        System.out.println(studenterUt);
        
        /* Øvelse 4: Filtrer studenter etter fag, karakter og alder
		 * 
		 * Gitt en liste med studentobjekter med navn og karakter, 
		 * bruk en strøm til å filtrere og som printer de studentene som
		 * har a) enten har studert Datavitenskap eller Informatikk og b)
		 * som har oppnådd karakteren "A", "B" eller "C" OG som har 
		 * etternavn som begynner på en bokstav i alfabetet som kommer 
		 * etter P.
		 * 
		 */
        
        
        
        studenter.stream()
        	.filter(s -> s.getFag() == "Datavitenskap" || s.getFag() == "Informatikk" )
        	.filter(s -> s.getKarakter() <= 'C')
        	.filter(s -> s.getEtternavn().toUpperCase().charAt(0) >= 'P')
        	.forEach(s -> {});
		
				
	
		
	
		// ---------------ØVELSER MED MAP--------------- //
		
		/* Oppgave 5: Dobling av tall
		 * Bruk streams til å ta inn en liste med heltall og returnerer
		 * en ny liste der hvert tall er doblet.
		 * 
		 */
		
	    List<Integer> tallUt2 = tall.stream()
	    		.map(h -> h*2)
	    		.toList();

//         System.out.println(tallUt2);
	    
	    /* Oppgave 6: Omregning av temperatur
	     * 
	     * Bruk streams til å ta inn en liste med temperaturer 
	     * i Celsius og returnerer en ny liste der hver temperatur er 
	     * omregnet til Fahrenheit ved hjelp av formelen: F = C * 9/5 + 32.
	     */
	    
	    List<Integer> fahrenheit = tall.stream()
	    		.map(c -> (int) (c*(9.0/5.0) +32.5))
	    		.toList();

       // System.out.println(fahrenheit);

	    /* Oppgave 7: Liste over lengder
	     * 
	     * Bruk streams til å ta inn en liste med strenger 
	     * og returnerer en ny liste med lengden av hver streng.
	     */
	    
	    List<Integer> strenglengder = strenger.stream()
	    		.map(s -> s.length())
	    		.toList();
	    		

        // System.out.println(strenglengder);
	    
	    /*Oppgave 8: Oppdater alder
	     * 
	     * Bruk streams til å lage en ny liste med studenter hvor alle studentene
	     * er et år eldre.
	     * 
	     * NB! ENDRING FRA TIMEN! 
	     * 
	     */
	    
	    Function<Student, Student> oppdaterAlder = (k -> new Student(
	    		k.getFornavn(),
	    		k.getEtternavn(),
	    		k.getAlder()+1, 
	    		k.getFag(),
	    		k.getKarakter()
	    		));
	    
	    studenter.stream()
	    		.map(oppdaterAlder::apply)
	    		.forEach(k -> {});
	    
	    
	    //---------------- sorted() og limit() ----------------//

	    /*Oppgave 9: Yngst til eldst
	     * 
	     * Bruk streams til å skrive ut det fulle navnet
	     * til studentene fra yngst til eldst
	     * 
	     * 
	     */
	    
//	    tall.stream()
	//    	.sorted()
	  //  	.forEach(System.out::println);
	    
	    studenter.stream()
	    		.sorted((s1, s2) -> s1.getAlder() - s2.getAlder()) 
	    		.forEach(s-> {});//System.out.println(s));
	    
	    /* Oppgave 10: Finn den yngste studenten med karakteren 
	     * 'A' i en liste med studentobjekter.
	     * 
	     */

	    Optional<Student> student = studenter.stream()
	    		.filter(s -> s.getKarakter() =='A')
	    		.min((s1,s2) -> s1.getAlder() - s2.getAlder());
	    
	    //System.out.println(student);
	    
	    /* Oppgave 11. Skriv ut alderen og karakteren til de 
	     * 3 beste Informatikk studentene under 22.
	     * 
	     */

	    studenter.stream()
	    		.filter(s -> s.getFag() == "Informatikk")
	    		.filter(a -> a.getAlder() < 22)
	    		.sorted((s1,s2) -> (s1.getKarakter() - s2.getKarakter()))
	    		.limit(3)
	    		.forEach(s-> {}); //System.out.println(s));
	    
	    
	    
	    /*Oppgave 12: 
	     * 
	     * Blandt de 40 yngste studentene finn de 30 elevene med best karakter. 
	     * Utav disse 30 studentene velg ut de øverste 20 studentene sortert 
	     * leksikografisk på etternavn. Utav disse 20 studentene finn de 10 
	     * studentene som har kortest fornavn. Utav disse 10 studentene finn
	     * ut om det er noen som studerer Informatikk.
	     * 
	     * 
	     */
	    
	    Optional<Student> asdf = studenter.stream()
	    	.sorted((s1,s2) -> s1.getAlder()-s2.getAlder())
	    	.limit(40)
	    	.sorted((s1,s2) -> s1.getKarakter()- s2.getKarakter())
	    	.limit(30)
	    	.sorted((s1,s2) -> s1.getEtternavn().compareTo(s2.getEtternavn()))
	    	.limit(20)
	    	.sorted((s1,s2) -> s1.getFornavn().length() - s2.getFornavn().length())
	    	.limit(10)
	    	.filter(s -> s.getFag() == "Informatikk")
	    	.findAny();
	    	
	    //System.out.println(asdf);
	    // -------------- YMSE OPPGAVER ---------------//

	    /*Oppgave 13: Navneforkortelser
	     * 
	     * Bruk streams til å lage en liste med studenter hvor 
	     * fornavnene og etternavnene til studentene er erstattet
	     * med initialene til studentene. Skriv ut denne listen.
	     * 
	     */
	    
	    
	    
	    studenter.stream()
	    		.map(s -> new Student(
	    				s.getFornavn().substring(0,1), 
	    				s.getEtternavn().substring(0,1), 
	    				s.getAlder(), 
	    				s.getFag(), 
	    				s.getKarakter()))
	    		.forEach(s -> {});// System.out.println(s));
	    
	    // System.out.print(studenter);
	    

	    /*Oppgave 14: 
	     * 
	     * Finn gjennomsnittsalderen til de 25 eldste studentene.
	     * 
	     */
	    
	    OptionalDouble avr = studenter.stream()
	    		.sorted((s1,s2)-> s2.getAlder()-s1.getAlder())
	    		.limit(25)
	    		.map(s -> s.getAlder())
	    		.mapToInt(Integer::intValue)
	    		.average();
	    
	    //System.out.print(avr);
	    
	    
	    /*Oppgave 15: 
	     * 
	     * Finn ut om det er noen studenter på informatikk under 20 år som fikk A
	     * 
	     */
	    
	    Boolean ans = studenter.stream()
	    		.filter(s -> s.getAlder() < 20)
	    		.anyMatch(s -> s.getKarakter() == 'A');

	    // System.out.print(ans);
	    
	    
	    /*Oppgave 16: 
	     * 
	     * Finn ut om det er flere enn 10 studenter som studerer datavitenskap
	     *  
	     */
	    

	    Boolean ans2 = studenter.stream()
	    		.filter(s -> s.getFag() == "Datavitenskap")
	    		.count() > 10;
	    		
	    // System.out.print(ans2);
	    
	    	    
	    	    
	    /* Oppgave 17: Lag en stream som returnerer en Map<String, List<Student>>
	     * hvor inputstrengene er navn på fag og outputstrengene er en liste med studenter
	     * som tar det gitte faget.
	     */
	    
	    Map<String,List<Student>> emneOversikt = new HashMap<String,List<Student>>();
	    
	    
	    Consumer<Student> oppdater = s -> {
	    	if(emneOversikt.containsKey(s.getFag())){
	    		emneOversikt.get(s.getFag()).add(s);
	    	} else {
	    		List<Student> studListe = new ArrayList<Student>();
	    		studListe.add(s);
	    		emneOversikt.put(s.getFag(), studListe);
	    	}
	    };
	    
	    
	    studenter.stream()
	    		.forEach(s-> oppdater.accept(s));
	    
	    //System.out.print(emneOversikt);



	}
}


