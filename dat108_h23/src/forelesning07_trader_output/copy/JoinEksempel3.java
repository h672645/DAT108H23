package forelesning07_trader_output.copy;

/* Kjedet trådutførelse
 * 
 * I dette eksemplet venter tråd2 på at tråd1 skal fullføre 
 * før den starter sitt eget arbeid. Dette oppnås ved å 
 * kalle tråd1.join() inne i run()-metoden til tråd2.
 */

public class JoinEksempel3 {
    public static void main(String[] args) throws InterruptedException {
        Thread tråd1 = new Thread(() -> {
            System.out.println("Tråd 1 jobber...");
        });

        Thread tråd2 = new Thread(() -> {
            try {
                tråd1.join(); // Vent på at tråd1 skal fullføre
                System.out.println("Tråd 2 jobber...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tråd1.start();
        tråd2.start();

        tråd2.join(); // Vent på at tråd2 skal fullføre

        System.out.println("Hovedtråden er ferdig.");
    }
}
