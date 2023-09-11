package forelesning07_trader_input;

public class RaceConditionFix {
	
	static Integer total = 0;
	
	public static void main(String[] args) {
		
		// 1 Bruk join
		// 2 Flytt runnable til utenfor for løkken
		// 3 Fjern static Integer

		for(int i = 0; i < 1000; i++) {
			Runnable r = () -> {
				for(int j = 0; j < 1000; j++) {
					total = total + 1;
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		
		
		Runnable r = () -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(total);
			
		};
		
		Thread t = new Thread(r);
		t.start();
		
	}
}
