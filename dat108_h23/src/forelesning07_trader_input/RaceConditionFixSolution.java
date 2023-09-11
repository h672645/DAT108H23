package forelesning07_trader_input;

public class RaceConditionFixSolution {
	
	
	public static void main(String[] args) {
		
		// 1 Bruk join
		// 2 Implementer runnable
		// 3 Fjern static Integer
		Integer total = 0;
		
		MyRunnable r = new MyRunnable (total);

		for(int i = 0; i < 1000; i++) {

			Thread t = new Thread(r);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(r.getTotal());
			
		
	}
}

class MyRunnable implements Runnable {
	Integer total;
	
	MyRunnable(Integer total){
		this.total = total;
	}
	
	@Override
	public void run() {
		for(int j = 0; j < 1000; j++) {
			total += 1;
		}
	}
	
	public Integer getTotal() {
		return this.total;
	}
	
};
