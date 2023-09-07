package forelesning05_streams_ouput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//		System.out.println(stringToInteger.apply("123"));

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		Function<String, Integer> stringToIntegerMet = Integer::parseInt;
//		System.out.println(stringToIntegerMet.apply("123"));

		
		
		
		

		//-------------------//
		// --- EKSEMPEL 2 ---//
		//-------------------//
				
		// Lambda-uttrykk for å konvertere en streng til store bokstaver
		Function<String, String> toUpperCase = s -> s.toUpperCase();

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		Function<String, String> toUpperCaseMet = String::toUpperCase;
		
//		System.out.println(toUpperCaseMet.apply("aasdlkfj"));
		
		
		

		//-------------------//
		// --- EKSEMPEL 3 ---//
		//-------------------//
		
		// Lambda-uttrykk for å finne det største av to tall
		BinaryOperator<Integer> max = (a, b) -> Math.max(a, b);

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		BinaryOperator<Integer> maxMet = Math::max;
//		System.out.println(maxMet.apply(4, 5));

		//-------------------//
		// --- EKSEMPEL 4 ---//
		//-------------------//
		
		

		// Lambda-uttrykk for å beregne kvadratet av et tall
		Function<Double, Double> square = x -> Math.pow(x, 2);

		// Oppgave: Skriv lambda uttrykket som en metodereferanse
		BiFunction<Double, Double, Double> squareMet = Math::pow;
		
		Double x = 5.0;
//		System.out.println( squareMet.apply(x, 2.0));
		
		

		//-------------------//
		// --- EKSEMPEL 5 ---//
		//-------------------//
		
		
		// Lambda-uttrykk for å sortere en liste av heltall
		Integer[] numbers = {5, 2, 8, 1, 4};
		Arrays.sort(numbers, (a, b) -> Integer.compare(a, b));

		// Oppgave: Gjør dette med en metodereferanse

		Integer[] numbers3 = {5, 2, 8, 1, 4};
		Arrays.sort(numbers3, Integer::compare);
//		System.out.println(numbers[0]);


		
		//-------------------//
		// --- EKSEMPEL 6 ---//
		//-------------------//
		

		// Lambda-uttrykk
		String greeting = "Hello, World!";
		Consumer<String> printLambda = s -> System.out.println(s);

		// Oppgave: Gjør dette med en metodereferanse
		Consumer<String> printLambdaMet = System.out::println;
		printLambdaMet.accept(greeting);


		//-------------------//
		// --- EKSEMPEL 7 ---//
		//-------------------//
		
		
		List<String> words = Arrays.asList("apple", "banana", "cherry");

		// Lambda utrykk
		words.forEach(word -> word.length());

		List<String> words2 = Arrays.asList("apple", "banana", "cherry");
		
		// Oppgave: Gjør dette med en metodereferanse
		words2.forEach(String::length);
		
		

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

        System.out.println("Sum of numbers: " + sum);
        
        

		//-------------------//
		// ---  OPPGAVER  ---//
		//-------------------//
        
        // Oppgave 1: Finn produktet av tallene i en liste av heltall.

		List<Integer> numbers4 = Arrays.asList();

        
        Integer prod = numbers4.stream()
        		.reduce((a,b) -> a*b)
        		.orElse(1);
        System.out.println(prod);

        // Oppgave 2: Finn den største verdien i en liste: Tips: Integer.MIN_VALUE
        int storst = numbers2.stream()
        		.reduce(Integer.MIN_VALUE, Math::max);
        
//        System.out.println(storst);
        
        // Oppgave 3: Finn den minste verdien i en liste av heltall.
        int minst = numbers2.stream()
        		.reduce(Integer.MAX_VALUE, Math::min);
        
//        System.out.println(minst);
        
        
        
        // Oppgave 4: Konkatener alle strengene i en liste til én stor streng.
        

		
		List<String> words3 = Arrays.asList("apple", "banana", "cherry");
		
		String str = words3.stream()
				.reduce("", (a,b) -> a + b);
		
		//System.out.println(str);

        
        // Oppgave 5: Slå sammen strengene i en liste med mellomrom mellom dem.
        

		String str2 = words3.stream()
				.reduce("", (a,b) -> b + " " + a);
		
		System.out.println(str2);
        
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

        String targetName = "Daniel";
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
         * flatMap er en funksjon som ofte brukes i 
         * funksjonell programmering og er spesielt 
         * nyttig når du arbeider med lister eller 
         * andre samlinger av elementer.
         * 
         * Hovedformålet med flatMap er å transformere 
         * hvert element i en strøm til en annen strøm 
         * og deretter kombinere (flate ut) resultatene 
         * fra alle de transformerte strømmene til en 
         * enkelt strøm.
         * 
         * Enkelt forklart fungerer flatMap slik:
         * 
         * Steg 1: Transformasjon
         * 
         * Først blir hver enkelt element i den opprinnelige 
         * strømmen transformert ved hjelp av en funksjon. 
         * Denne transformasjonen resulterer i en ny strøm 
         * for hvert element.
         * 
         * Steg 2: Utflating (Flating)
         * 
         * eretter blir resultatstrømmene fra steg 1 "flatet" 
         * ut til en enkelt strøm ved å kombinere (konkatenere)
         * resultatene fra alle strømmene.
         * 
         */
        
        
		//-------------------//
		// --- EKSEMPEL 1 ---//
		//-------------------//
        
        // Strømmer av strømmer
        
        Stream<Stream<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry").stream(),
                Arrays.asList("date", "fig", "grape").stream(),
                Arrays.asList("lemon", "orange", "pear").stream()
            ).stream();

            List<String> flatList = listOfLists
                .flatMap(stream -> stream) // Flatt ut samlingene
                .collect(Collectors.toList());
            
            
            // flatList.forEach(System.out::println);
            

    		//-------------------//
    		// --- EKSEMPEL 2 ---//
    		//-------------------//
            
            // Oppretter en liste med ord
            List<String> words4 = Arrays.asList("Hello", "World");

            // Bruk flatMap til å splitte hvert ord i bokstaver og lage en strøm av bokstaver
            List<String> letters = words4.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());

            // Skriv ut resultatet
            // System.out.println(letters);
            


    		//-------------------//
    		// --- EKSEMPEL 3 ---//
    		//-------------------//
            
            
            /*
             * Eksempel 3: Liste av lister til liste av elementer
             * 
             * I dette eksemplet har vi en liste av lister med tall,
             * og vi bruker flatMap til å konvertere den til en 
             * enkelt liste med tall:
             * 
             */
            
            List<List<Integer>> numbers5 = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(4, 5),
                    Arrays.asList(6, 7, 8)
            );

            List<Integer> flattenedNumbers = numbers5.stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            //System.out.println(flattenedNumbers); 
                
            

    		//-------------------//
    		// --- EKSEMPEL 4 ---//
    		//-------------------//
            
            /*
             * Eksempel 4: Mapper og filtrerer elementer
             * 
             * I dette eksemplet har vi en liste av ord, 
             * og vi bruker flatMap til å mappe hvert ord 
             * til en strøm av bokstaver, filtrere ut 
             * visse bokstaver og kombinere resultatene 
             * til en enkelt liste:
             */
                
            List<String> words5 = Arrays.asList("apple", "banana", "cherry");

                List<String> filteredLetters = words5.stream()
                    .flatMap(word -> word.chars()
                        .mapToObj(ch -> (char) ch)
                        .filter(ch -> ch != 'a'))
                    .map(Object::toString)
                    .collect(Collectors.toList());
                
                
            

     		//-------------------//
       		// --- EKSEMPEL 5 ---//
       		//-------------------//
                
            /*
             * Eksempel 5: Liste av strenger til unike ord
             * 
             * I dette eksemplet har vi en liste av strenger 
             * som representerer setninger, og vi bruker flatMap
             * til å splitte setningene opp i ord og deretter 
             * lage en liste av unike ord:
             */
                
                List<String> sentences = Arrays.asList(
                        "Dette er en setning.",
                        "Dette er en annen setning.",
                        "En tredje setning."
                    );

                    List<String> uniqueWords = sentences.stream()
                        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                        .distinct()
                        .collect(Collectors.toList());

            //        System.out.println(uniqueWords);
                
            // Oppgave 1: Gitt en liste med lister av bokstaver, 
            // bruk flatMap til å lage en strøm med individuelle bokstaver.
            
            // Oppgave 2: Gitt en liste med setninger, bruk flatMap til å 
            // finne alle unike ord som starter med en bestemt bokstav.
            
            // Oppgave 3: Gitt en liste med lister av heltall, bruk flatMap
            // til å lage en strøm med individuelle tall og finn summen av 
            // alle tallene.
            
            
        
        
	}

}
