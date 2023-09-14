package forelesning08_trader_input;

public class WaitOgNotify01 {
	

	/* ENKEL WAIT-NOTIFY
	 * 
	 * Når varslingTråd setter betingelse til sann og kaller notify(), vil venterTråd våkne opp fra ventemodusen og fortsette. Dette illustrerer en enkel form for trådkommunikasjon ved bruk av wait() og notify() for å vente på og varsle om en betingelse.
	 */
	
	public static void main(String[] args) {
        DelteResurs ressurs = new DelteResurs();

           
        
        /* Oppretter tråden varslingTråd:
         * 
         * Denne simulerer noen beregninger ved å sove i noen 
         * sekunder og deretter setter betingelse til sann 
         * ved å kalle settBetingelse(). Etter dette varsler 
         * den venterTråd ved hjelp av notify().
         * 
         */

        Thread varslingTråd = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulerer noen beregninger
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            ressurs.settBetingelse();
            System.out.println("Varseltråd har satt betingelsen til sann.");
        });
        

        /* Oppretter en tråd, venterTråd: 
         * 
         * Denne venter på at betingelse skal bli sann ved å kalle 
         * ventPåBetingelse(). Hvis betingelsen ikke er oppfylt, 
         * går den inn i ventemodus ved hjelp av wait().
         * 
         */
        
        Thread venterTråd = new Thread(() -> {
            System.out.println("Ventertråd venter på betingelsen.");
            ressurs.ventPåBetingelse();
            System.out.println("Ventertråd har fullført.");
        });
        
        // Starter de to trådene
        venterTråd.start();
        varslingTråd.start();
    }
}


/* DeltResurs
 * 
 * DelteResurs-klassen har en feltvariabel, betingelse, og
 * to metoder: ventPåBetingelse() og settBetingelse(). 
 * 
 */
class DelteResurs {

	
	private boolean betingelse = false;
    	
	/* SYNCHRONIZED
	 * Nøkkelord for å oppnå trådsikkerhet ved å sørge for at bare 
	 * én tråd kan få tilgang til en kritisk seksjon av kode om 
	 * gangen. Dette er viktig for å unngå kappløpssituasjoner 
	 * når flere tråder deler felles ressurser eller utfører 
	 * samtidige oppgaver.
	 */
    

    // Venter på at betingelse skal bli sann ved hjelp av wait()
	synchronized void ventPåBetingelse() {
        while (!betingelse) {
            try {
                wait(); // Venter på at betingelsen skal bli sann
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Betingelsen er nå sann.");
    }
    
    /* settBetingelse()
     * 
     * Setter betingelse til sann og varsler ventertrådene ved 
     * hjelp av notify().
     */

    synchronized void settBetingelse() {
        this.betingelse = true;
        notify(); // Varsler ventertrådene om at betingelsen er oppfylt
    }
}
