package forelesning04_streams_input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HovedIn {
	
	/* Dette er oppgavene vi gikk gjennom i forelesning. Noen 
	 * av spørsmålene endret vi litt på underveis. Løsningsforslag
	 * finner dere i pakken forelesning04_output_streams.
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

        List<StudentIn> studenter = StudentIn.genererStudenter();



		// --------------- 4 ØVELSER MED FILTER--------------- //
        
        /* Øvelse 1: Filtrer partall
		 * 
		 * Gitt en liste med heltall, bruk 
		 * en strøm (stream) til å filtrere ut og opprette en ny liste 
		 * som kun inneholder partall.
		 * 
		 */
		

        
        List<Integer> tallUt = tall.stream()
        		//TODO: Filtrer
        		.toList();
        		
        
        //System.out.println(tallUt);

		
		/* Øvelse 2: Filtrer strenger etter lengde
		 * Bruk en strøm til å filtrere og opprette en ny liste som kun 
		 * inneholder strenger som har en lengde større enn en angitt verdi 
		 * (for eksempel 5 tegn).
		 * 
		 */

       

        List<String> strengerUt = strenger.stream()
        		//TODO: Filtrer
        		.toList();
        

        
        // System.out.println(strengerUt);
		
        
        /* Øvelse 3: Filtrer studenter etter karakter
		 * 
		 * Gitt en liste med studentobjekter, bruk en strøm til å 
		 * filtrere og opprette en ny liste som kun inneholder 
		 * studenter som har oppnådd karakteren "A".
		 * 
		 */
        
        

        List<StudentIn> studenterUt = studenter.stream()
        		//TODO: Filtrer
        		.toList();

        // System.out.println(studenterUt);
        
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
        	//TODO: Filtrer
        	.forEach(s -> {});// System.out.println(s));
		
				
	
		
	
		// ---------------ØVELSER MED MAP--------------- //
		
		/* Oppgave 5: Dobling av tall
		 * Bruk streams til å ta inn en liste med heltall og returnerer
		 * en ny liste der hvert tall er doblet.
		 * 
		 */
		
	    List<Integer> tallUt2 = tall.stream()
	    		//TODO: Map
	    		.toList();

        // System.out.println(tallUt2);
	    
	    /* Oppgave 6: Omregning av temperatur
	     * 
	     * Bruk streams til å ta inn en liste med temperaturer 
	     * i Celsius og returnerer en ny liste der hver temperatur er 
	     * omregnet til Fahrenheit ved hjelp av formelen: F = C * 9/5 + 32.
	     */
	    
	    List<Integer> fahrenheit = tall.stream()
	    		//TODO: Map
	    		.toList();

        // System.out.println(fahrenheit);

	    /* Oppgave 7: Liste over lengder
	     * 
	     * Bruk streams til å ta inn en liste med strenger 
	     * og returnerer en ny liste med lengden av hver streng.
	     */
	    
	    List<String> strenglengder = strenger.stream()
	    		//TODO: Map
	    		.toList();
	    		

        // System.out.println(strenglengder);
	    
	    /*Oppgave 8: Oppdater alder
	     * 
	     * Bruk streams til å lage en ny liste med studenter hvor alle studentene
	     * er et år eldre
	     * 
	     */
	    
	    List<StudentIn> studenterUt2 = studenter.stream()
	    		//TODO: Map
	    		.toList();
	    
	    // System.out.println(studenterUt2);
	    
	    //---------------- sort() og limit() ----------------//

	    /*Oppgave 9: Yngst til eldst
	     * 
	     * Bruk streams til å skrive ut det fulle navnet
	     * til studentene fra yngst til eldst
	     * 
	     * 
	     */
	    
	    studenter.stream()
	    		//TODO: 
	    		.forEach(s->{});
	    
	    /* Oppgave 10: Finn den yngste studenten med karakteren 
	     * 'A' i en liste med studentobjekter.
	     * 
	     */

	    studenter.stream()
	    		//TODO: 
	    		.forEach(s->{});
	    
	    /* Oppgave 11. Skriv ut alderen og karakteren til de 
	     * 10 beste Informatikk studentene under 22.
	     * 
	     */

	    studenter.stream()
	    		//TODO: 
	    		.forEach(s->{});
	    
	    
	    
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
	    
	    
	    
	    // -------------- YMSE OPPGAVER ---------------//

	    /*Oppgave 13: Navneforkortelser
	     * 
	     * Bruk streams til å lage en liste med studenter hvor 
	     * fornavnene og etternavnene til studentene er erstattet
	     * med initialene til studentene. Skriv ut denne listen.
	     * 
	     */
	    
	    
	    
	    studenter.stream()
	    		//TODO: Map og filtrer
	    		.forEach(s ->{});//System.out.print(s));
	    

	    /*Oppgave 14: 
	     * 
	     * Finn gjennomsnittsalderen til de av de 25 eldste.
	     * 
	     */
	    
	    studenter.stream()
	    		//TODO: Map og filtrer
	    		.forEach(s ->{});//Fjern
	    
	    
	    
	    /*Oppgave 15: 
	     * 
	     * Finn ut om det er noen studenter på informatikk under 20 år som fikk A
	     * 
	     */
	    
	    
	    
	    /*Oppgave 16: 
	     * 
	     * Finn ut om det er flere enn 10 studenter som studerer datavitenskap
	     *  
	     */
	    
	    
	    
	    /* Oppgave 17: Lag en stream som returnerer en Map<String, List<Student>>
	     * hvor inputstrengene er navn på fag og outputstrengene er en liste med studenter
	     * som tar det gitte faget.
	     */
	    

	}
}


