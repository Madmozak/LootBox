package LootBox;
import java.util.ArrayList;
import java.util.Random;

public class Item {
	
	String name;
	
	equipType type;
	rare rarity;
	//ItemEnchant enchant;
	//ArrayList<ItemEnchant> enchants;
	
	
	
	public Item() {
		this.name = "TestItem " + (int)(Math.random()*11);
		this.type = setType();
		this.rarity = setRarity();
		
	}
	public Item(String name) {
		this.name = name;
		this.type = setType();
		this.rarity = setRarity();
		//this.enchant = setRandomEnchant(enchant.getArrayEnchants());
	}
	
	public Item(String name, rare rarity) {
		this.name = name;
		this.type = setType();
		this.rarity = rarity;
	}
	
	public Item(String name, ItemEnchant enchant) {
		this.name = name;
		this.type = setType();
		this.rarity = setRarity();
		//this.enchant = enchant;
	}
	
	public ItemEnchant setRandomEnchant(ArrayList<ItemEnchant> enchant) {
		 return enchant.get(new Random().nextInt(enchant.size()));
	}
	public equipType setType() {
		return equipType.values()[(int)(Math.random()*equipType.values().length)];
	}
	
	public rare setRarity() {
		int r = (int)(Math.random()*100);
		
		if(r<rare.Common.getValue())
			return rare.Common;
		else if(r<rare.Uncommon.getValue())
			return rare.Uncommon;
		else if(r<rare.Rare.getValue())
			return rare.Rare;
		else if(r<rare.Epic.getValue())
			return rare.Epic;
		else
			return rare.Legendary;
		
	}
	
	public String getName() {
		return this.name;
	}
	public String setName() {
		return name;
	}
	
	enum equipType{
		
		Helmet,
		Armor, 
		Gloves, 
		Necklace, 
		Ring, 
		Boots, 
		Legwear;

	}
	
	enum rare {
		Common(50),
		Uncommon(70),
		Rare(85),
		Epic(95),
		Legendary(100);
		private int value;
		
		rare(int value){
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
	
	public String toString() {
		return name + ",\n " + type + ",\n " + rarity;
	}
}
