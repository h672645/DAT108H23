package forelesning08_trader_input;

public class WaitOgNotify03 {
	
	
	/* Kjedereaksjon
	 * 
	 * Et program som simulerer en kjedereaksjon
	 */

    public static void main(String[] args) {
    	
    	// Oppretter 10 Uranatomer
        
    	Fisjon fisjonObjekt = new Fisjon();
    	
    	for(int i = 0; i < 10; i++) {
    		Thread atom = new Atom(i, fisjonObjekt);
    		atom.start();
        }
    }
}

class Atom extends Thread {
	private String navn;
	private Fisjon fisjonObjekt;
	
	
	Atom(int i, Fisjon fisjonObjekt){
		this.navn = "Atom " + i;
		this.fisjonObjekt = fisjonObjekt;
	}
	@Override
	public
	void run() {
		fisjonObjekt.boooooooom(this.navn);
	}
}

class Fisjon {
	
    public synchronized void boooooooom(String name) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(name + " har fisjonert, BOOOOOOOM!");
    	System.out.println("Åhnei, kjedereaksjon! Et nytt atom kommer til å fisjonere...");
    	notifyAll();
    }
}
