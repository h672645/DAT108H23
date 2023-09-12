package forelesning07_trader_output.copy;



/* Vent på at flere tråder skal fullføre
 * 
 * I dette eksemplet har vi to tråder, tråd1 og tråd2, 
 * og vi bruker join() for å vente på at begge trådene 
 * skal fullføre før hovedtråden går videre. Dette sikrer 
 * at "Hovedtråden er ferdig." blir skrevet ut bare etter 
 * at begge trådene er ferdige.
 */

public class JoinEksempel2 {
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

        Thread tråd2 = new Thread(() -> {
            System.out.println("Tråd 2 jobber...");
            try {
                Thread.sleep(3000); // Simulerer arbeid
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tråd 2 er ferdig.");
        });

        tråd1.start();
        tråd2.start();

        tråd1.join(); // Vent på at tråd1 skal fullføre
        tråd2.join(); // Vent på at tråd2 skal fullføre

        System.out.println("Hovedtråden er ferdig.");
    }
}