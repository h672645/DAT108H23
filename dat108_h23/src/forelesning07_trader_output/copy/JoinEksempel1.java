package forelesning07_trader_output.copy;

/* Vent på at én tråd skal fullføre:
 * 
 * I dette eksemplet starter hovedtråden tråd1 og deretter bruker 
 * den join() på tråd1, noe som betyr at den venter på at tråd1 
 * skal fullføre før den går videre. Dette sikrer at "Hovedtråden 
 * er ferdig." blir skrevet ut bare etter "Tråd 1 er ferdig."
 */

public class JoinEksempel1 {
    
	public static void main(String[] args) throws InterruptedException {
    	
        Thread tråd1 = new Thread(() -> {
            System.out.println("Tråd 1 jobber...");
            
            try {
                Thread.sleep(2000); // Simulerer arbeid
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Tråd 1 er ferdig.");
        });

        tråd1.start();
        tråd1.join(); // Vent på at tråd1 skal fullføre

        System.out.println("Hovedtråden er ferdig.");
    }
}