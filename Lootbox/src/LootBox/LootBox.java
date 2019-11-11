package LootBox;

public class LootBox extends Item {
	
	Item[] items;
	int cost;
	
	
	public LootBox() {
		name = "TestBox " + (int)(Math.random()*10);
		cost = -30;
	}

	
	public Item openLootBox() {
		return new Item();
	}
	
	public String toString() {
		return name;
	}
	
}
