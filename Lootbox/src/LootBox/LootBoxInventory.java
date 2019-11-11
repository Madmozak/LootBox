package LootBox;
import java.util.ArrayList;
import java.util.List;

public class LootBoxInventory {
	int currency;
	int premiumCurrency;
	ArrayList<LootBox> lootboxes;
	
	
	
	public LootBoxInventory() {
		currency = 0;
		premiumCurrency = 0;
		lootboxes = new ArrayList<LootBox>();
		
	}
	
	public void buyLootbox() {
		lootboxes.add(new LootBox());
		setCurrency(-30);
	}
	
	public void openLootbox(int boxIndex) {
		
		 lootboxes.get(boxIndex).openLootBox();
		 lootboxes.remove(boxIndex);
		 
	}
	
	public ArrayList<LootBox> getInventory() {
		return lootboxes;
	}
	
	public int getCurrency() {
		return currency;
	}
	
	public int getPremiumCurrency() {
		return premiumCurrency;
	}
	
	public void setCurrency(int amount) {
		currency = currency + amount;
	}
	
	public void setPremiumCurrency(int amount) {
		premiumCurrency = premiumCurrency + amount;
	}
}
