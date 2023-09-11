package forelesning06_trader_output;

public class KontrollereTrader {
	public static void main(String[] args) {
		
		
		// Definerer en Runnable ved hjelp av et lambda uttrykk
		Runnable r2 = () -> {

			// Gir denne tråden et navn
			Thread.currentThread().setName("Countdown");
			
			// En for-løkke som teller ned fra 10
			for(int i = 10; i >= 0; i--) {

				// Setter tråden til å "sove" i ett sekund
				try {
					Thread.sleep(1010);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Skriver ut tallet i:
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
			}
		};

		
		// Definerer en Runnable ved hjelp av et lambda uttrykk
		Runnable r1 = () -> {
			
		// Gir denne tråden et navn
		Thread.currentThread().setName("Countup");

		// En for-løkke som teller opp til 10
		for(int i = 0; i <= 10; i++) {
			
			
			// Setter tråden til å "sove" i ett sekund
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Skriver ut tallet i:
			System.out.print(Thread.currentThread().getName() + ": ");
			System.out.println(i);
		}
	};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
