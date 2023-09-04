package forelesning05_streams_input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hoved {
	
	public static void main(String[] args) {
		
		/* Agenda:
		 * 
		 *  - METODEREFERANSER
		 *  - MER OM STREAMS
		 *  	- REDUCE
		 *  	- OPTIONAL
		 *  	- FLATMAP
		 *  - OBLIG?
		 */


		/************************
		 *                      *
		 *   METODEREFERANSER   *
		 *                      *
		 ************************/
		
		
		/* KORT OM METODEREFERANSER
		 * 
		 * Metodereferanser i Java er en måte å referere til 
		 * og gjenbruke metoder på en enklere måte. Du kan 
		 * tenke på dem som snarveier for å kalle metoder. 
		 * Dette er spesielt nyttig når du arbeider med funksjoner
		 * eller operasjoner som du ønsker å utføre på data.
		 * 
		 * Det er fire typer metodererfanser:
		 * 	1 Metodereferanse til en statisk metode
		 * 		- Du bruker dette når metoden du vil
		 * 		  kalle, er en statisk (dvs. ikke-avhengig
		 * 		  av objekter) metode i en klasse.
		 * 		- Typisk syntax -> ClassName::staticMethodName
		 * 
		 *  2 Metodereferanse til en instansmetode på et bestemt objekt
		 *  	- Dette brukes når du har et objekt, og du vil kalle en
		 *  	  metode på det objektet.
		 * 		- Typisk syntax -> object::instanceMethodName
		 * 
		 * 	- Metodereferanse til en instansmetode på en spesifikk type
		 * 		- Dette brukes når du vil kalle en metode på objekter 
		 * 		  av en bestemt type.
		 * 		- Typisk syntax -> ClassName::instanceMethodName
		 * 
		 * 	- Metodereferanse til en konstruktør
		 * 		- Dette brukes når du vil opprette nye objekter av en 
		 * 		  klasse.
		 * 		- Typisk syntax -> ClassName::new
		 */
		
		
		/* Metodereferanse til en statisk metode:
		 * 
		 * ClassName::staticMethodName
		 */
		
		//-------------------//
		// --- EKSEMPEL 1 ---//
		//-------------------//
		
		// Lambda-uttrykk for å konvertere en tekst til et heltall
		Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		
		
		

		//-------------------//
		// --- EKSEMPEL 2 ---//
		//-------------------//
				
		// Lambda-uttrykk for å konvertere en streng til store bokstaver
		Function<String, String> toUpperCase = s -> s.toUpperCase();

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		
		

		//-------------------//
		// --- EKSEMPEL 3 ---//
		//-------------------//
		
		// Lambda-uttrykk for å finne det største av to tall
		BinaryOperator<Integer> max = (a, b) -> Math.max(a, b);

		// Oppgave: Skriv lambda uttrykket som en metodereferanse


		//-------------------//
		// --- EKSEMPEL 4 ---//
		//-------------------//
		
		

		// Lambda-uttrykk for å beregne kvadratet av et tall
		Function<Double, Double> square = x -> Math.pow(x, 2);

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		
		
		

		//-------------------//
		// --- EKSEMPEL 5 ---//
		//-------------------//
		
		
		// Lambda-uttrykk for å sortere en liste av heltall
		Integer[] numbers = {5, 2, 8, 1, 4};
		Arrays.sort(numbers, (a, b) -> Integer.compare(a, b));

		// Oppgave: Gjør dette med en metodereferanse


		
		//-------------------//
		// --- EKSEMPEL 6 ---//
		//-------------------//
		

		// Lambda-uttrykk
		String greeting = "Hello, World!";
		Consumer<String> printLambda = s -> System.out.println(s);

		// Oppgave: Gjør dette med en metodereferanse


		//-------------------//
		// --- EKSEMPEL 7 ---//
		//-------------------//
		
		
		List<String> words = Arrays.asList("apple", "banana", "cherry");

		// Lambda utrykk
		words.forEach(word -> word.length());

		// Oppgave: Gjør dette med en metodereferanse
		
		

		/************************
		 *                      *
		 *   MER OM STRØMMER    *
		 *                      *
		 ************************/
		
		
		/**********************
		 * ----- REDUCE ----- *
		 **********************/
		
		
		/* Reduce er en funksjonell operasjon i mange 
		 * programmeringsspråk, inkludert Java, som 
		 * brukes til å kombinere alle elementene i 
		 * en samling (som en liste eller et array) til 
		 * ett enkelt resultat ved hjelp av en spesifisert 
		 * binær operasjon. Denne operasjonen reduserer 
		 * samlingen til en enkelt verdi.
		 * 
		 * I Java er reduce en metode tilgjengelig på 
		 * grensesnittet Stream. Den tar to argumenter:
		 *  - En identitetsverdi, som er verdien som 
		 *    funksjonen starter med. Dette kan betraktes 
		 *    som en slags "begynnelsesverdi" for reduksjonen.
		 *  - En binær operasjon, representert som en 
		 *    lambda-funksjon eller en metode referanse, som 
		 *    definerer hvordan elementene i samlingen skal 
		 *    kombineres for å produsere det endelige resultatet.
		 * 
		 */
		
		

		//-------------------//
		// --- EKSEMPEL   ---//
		//-------------------//
		
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        // Reduserer listen av tall til summen av tallene
        int sum = numbers2.stream()
                .reduce(0, (a, b) -> a + b);

        // System.out.println("Sum of numbers: " + sum);
        
        

		//-------------------//
		// ---  OPPGAVER  ---//
		//-------------------//
        
        // Oppgave 1: Finn produktet av tallene i en liste av heltall.
        

        // Oppgave 2: Finn den største verdien i en liste: Tips Integer.MIN_VALUE
        
        
        // Oppgave 3: Finn den minste verdien i en liste av heltall.
        
        
        // Oppgave 4: Konkatener alle strengene i en liste til én stor streng.

        
        // Oppgave 5: Slå sammen strengene i en liste med mellomrom mellom dem.
        
        
        // Oppgave 6: Finn lengden av den lengste strengen i en liste av strenger.
        
        
        // Oppgave 7: Finn antall forekomster av et bestemt ord i en liste av strenger.

        
        // Oppgave 8: Finn den lengste strengen i en liste av strenger.
        

		/**********************
		 * ---- OPTIONAL ---- *
		 **********************/
        
        
        /* KORT OM OPTIONAL:
         * 
         * Optional er en klasse i Java som ble introdusert i 
         * Java 8 for å håndtere situasjoner der en verdi kan 
         * være fraværende eller ikke-eksisterende. Den ble 
         * utviklet for å erstatte bruk av null for å representere 
         * mangel på en verdi, noe som kan føre til nullpekerunntak 
         * (NullPointerException) hvis ikke behandlet riktig. Optional 
         * gir en mer robust måte å håndtere slike scenarier på.
         * 
         * 
         * Optional kan være i en av to tilstander:
         *  - Ingen verdi: Optional kan representere tilstanden
         *    der det ikke finnes noen verdi. Dette er nyttig for å 
         *    unngå nullpekerunntak.
         *  - Tilstedeværende verdi: Optional kan også inneholde en 
         *  faktisk verdi. Dette kan være hvilken som helst objekttype.
         *
         * Oppretting av Optional: 
         *  - Du kan opprette en Optional-instans ved hjelp av 
         *    Optional.of(value) hvis verdien er til stede, eller 
         *    Optional.empty() hvis verdien mangler.
         *  - Strømmer returnerer ofte Optional...
         *  
         * Operasjoner på Optional:
         *  - get(): Henter verdien (kan kaste unntak)
         *  - orElse(defaultValue): Får verdien dersom den er der, returner
         *    ellers standardveriden.
         *  - isPresent(): Sjekker om det er en verdi lagret (true/false)
         *  - ifPresent(consumer): Utfører en handring om det er en verdi 
         *    lagret.
         */
        

		//-------------------//
		// --- EKSEMPEL   ---//
		//-------------------//
        
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        String targetName = "Bob";
        Optional<String> optionalName = names.stream()
                .filter(name -> name.equals(targetName))
                .findFirst();

        if (optionalName.isPresent()) {
            System.out.println("Name found: " + optionalName.get());
        } else {
            System.out.println("Name not found.");
        }
        


		//-------------------//
		// ---  OPPGAVER  ---//
		//-------------------//
        
        // Oppgave 1: Finn det første positive oddetallet i en liste
        
        // Oppgave 2: Finn den lengste strengen i en liste
        
        // Oppgave 3:  Finn det første elementet som starter med en
        // bestemt bokstav i en liste av ord:
        
        

		/************************
		 *                      *
		 *       FLATMAP        *
		 *                      *
		 ************************/
		
        
        /* KORT OM FLATMAP:
         * 
         * flatMap er en funksjonell operasjon i 
         * Java Streams som brukes til å transformere 
         * og "flate" ut elementer i en strøm av samlinger 
         * (for eksempel lister eller andre strømmer) til 
         * en enkelt strøm av elementer. Den er nyttig når 
         * du har en strøm av samlinger, og du vil behandle 
         * hvert element i hver samling som individuelle 
         * elementer i den resulterende strømmen.
         * 
         * 
         */
        

		//-------------------//
		// --- EKSEMPEL   ---//
		//-------------------//
        
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("date", "fig", "grape"),
                Arrays.asList("lemon", "orange", "pear")
            );

            List<String> flatList = listOfLists.stream()
                .flatMap(List::stream) // Flatt ut samlingene
                .collect(Collectors.toList());


    		//-------------------//
    		// ---  OPPGAVER  ---//
    		//-------------------//
            
            // Oppgave 1: Gitt en liste med lister av bokstaver, 
            // bruk flatMap til å lage en strøm med individuelle bokstaver.
            
            // Oppgave 2: Gitt en liste med setninger, bruk flatMap til å 
            // finne alle unike ord som starter med en bestemt bokstav.
            
            // Oppgave 3: Gitt en liste med lister av heltall, bruk flatMap
            // til å lage en strøm med individuelle tall og finn summen av 
            // alle tallene.
            
            
        
        
	}

}
