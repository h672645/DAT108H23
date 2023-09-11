package forelesning06_trader_output;

public class OppretteTrader {
	public static void main(String[] args) {
		
		
        // Opprett tråder ved å instansiere MyThread-klassen
        MyThread thread1a = new MyThread();
        MyThread thread2a = new MyThread();

        // Start trådene
//        thread1a.start();
//        thread2a.start();
		
        // Opprett en instans av MyRunnable-klassen
        MyRunnable myRunnable = new MyRunnable();

        // Opprett tråder ved å passere MyRunnable-objektet til Thread-konstruktøren
        Thread thread1b = new Thread(myRunnable);
        Thread thread2b = new Thread(myRunnable);

        // Start trådene
        //thread1b.start();
        //thread2b.start();
        
        // Opprette en instans av Runnable med lambda
        
        Runnable program = () -> {
        	     // Koden som skal utføres av tråden
        	     for (int i = 0; i < 5; i++) {
        	         System.out.println("Tråd " + Thread.currentThread().getId() + ": Tell " + i);
        	     }
        	 };
        

             Thread thread1c = new Thread(program);
             Thread thread2c = new Thread(program);


             // Start trådene
             thread1c.start();
             thread2c.start();
             

             
		
	}

}


//Definer en egendefinert klasse som utvider Thread-klassen
class MyThread extends Thread {
	
	@Override
	public void run() {
		// Koden som skal utføres av tråden
		for (int i = 0; i < 5; i++) {
			System.out.println("Tråd " + Thread.currentThread().getId() + ": Tell " + i);
		}
	}
}


//Definer en egendefinert klasse som implementerer Runnable-grensesnittet
class MyRunnable implements Runnable {
 public void run() {
     // Koden som skal utføres av tråden
     for (int i = 0; i < 5; i++) {
         System.out.println("Tråd " + Thread.currentThread().getId() + ": Tell " + i);
     }
 }
}


