package LootBox;
import java.util.ArrayList;

public class ItemEnchant {
	
	String name;
	String tooltip;
	ArrayList<ItemEnchant> enchants = new ArrayList<ItemEnchant>();
	
	
	public ItemEnchant(String name, String tooltip) {
		this.name = name;
		this.tooltip = tooltip;
		
	}
	
	public void addEnchant(Item item, ArrayList<ItemEnchant> enchant) {
		enchant.add(new ItemEnchant("testEnchant", "Test if enchant is added and works"));
	}
	
	public ArrayList<ItemEnchant> getArrayEnchants() {
		return enchants;
	}
	
	public String toString() {
		return name;
	}
}
