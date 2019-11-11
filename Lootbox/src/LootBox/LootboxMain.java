package LootBox;
import java.awt.EventQueue;

public class LootboxMain {
	
	
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GUI gui = new GUI();
			}
		});
		
		
		
		for(int i = 0; i<=100; i++) {
			Item testItem = new Item();
			System.out.println(testItem);
		}
	}
}
