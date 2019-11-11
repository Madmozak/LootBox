package LootBox;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame LootBoxFrame;
	JTextArea textArea;
	JButton buyBoxButton;
	JButton openBoxButton;
	JButton buyCurrencyButton;
	JButton buyPremiumCurrencyButton;
	JPanel buttonPanel;
	JPanel infoPanel;
	JPanel inventoryPanel;
	JLabel currencyLabel;
	JLabel premiumCurrencyLabel;
	JList<LootBox> lootboxList;
	int lootboxCost = 30;
	LootBoxInventory playerInventory = new LootBoxInventory();
	//ListModel<?> inventoryModel;
	DefaultListModel<LootBox> inventoryModel;
	
	public GUI() {
		LootBoxFrame = new JFrame("LootBoxFrame");
		inventoryModel = new DefaultListModel<LootBox>();
		buttonPanel = new JPanel();
		textArea = new JTextArea();
		inventoryPanel = new JPanel();
		buyBoxButton = new JButton("Buy Box");
		openBoxButton= new JButton("Open Box");
		buyCurrencyButton = new JButton("Buy Credits");
		buyPremiumCurrencyButton = new JButton("Buy Diamonds");
		infoPanel = new JPanel();
		
		currencyLabel = new JLabel("Credits: " + String.valueOf(playerInventory.getCurrency()));
		premiumCurrencyLabel = new JLabel("Diamonds: " + String.valueOf(playerInventory.getPremiumCurrency()));
		lootboxList = new JList(inventoryModel);
		lootboxList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane inventoryScroll = new JScrollPane(lootboxList);
		//this.add(textArea);
		
		LootBoxFrame.add(buttonPanel, BorderLayout.PAGE_END);
		LootBoxFrame.add(infoPanel, BorderLayout.PAGE_START);
		
		LootBoxFrame.add(inventoryPanel, BorderLayout.EAST);

		inventoryPanel.add(inventoryScroll);
		
		
		inventoryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		inventoryScroll.setPreferredSize(new Dimension(200,400));
		infoPanel.add(currencyLabel);
		infoPanel.add(premiumCurrencyLabel);
		
		buttonPanel.add(buyBoxButton);
		buttonPanel.add(openBoxButton);
		buttonPanel.add(buyCurrencyButton);
		buttonPanel.add(buyPremiumCurrencyButton);
		
		buyPremiumCurrencyButton.setToolTipText("Wydaj pieniazki i kup sobie cos ladnego");
		//lootboxList.setToolTipText("Test");
		
		lootboxList.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent event) {
				JList l = (JList) event.getSource();
				ListModel m = l.getModel();
				Point p = event.getPoint();
				int index = l.locationToIndex(event.getPoint());
				
				if(index >-1 ) {
					 l.setToolTipText(m.getElementAt(index).toString());
				}
			}
			
			
		});
		
		buyBoxButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(playerInventory.getCurrency() >= lootboxCost) {
					playerInventory.buyLootbox();
					updateList("Credits: " + String.valueOf(playerInventory.getCurrency()));
				}
			}
		
		});
		
		openBoxButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(lootboxList.getSelectedIndex() != -1) {
					playerInventory.openLootbox(lootboxList.getSelectedIndex());
					updateList();
				}
				
				System.out.println(playerInventory.getInventory().size());
				
			}
		
		});
		buyCurrencyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//updateCurrency(100, "Credits: " + String.valueOf(playerInventory.getCurrency()));
				
				playerInventory.setCurrency(100);
				currencyLabel.setText("Credits: " + String.valueOf(playerInventory.getCurrency()));
			}
		
		});
		
		buyPremiumCurrencyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//updatePremiumCurrency("Diamonds: " + String.valueOf(playerInventory.getPremiumCurrency()), 10);
				
				playerInventory.setPremiumCurrency(10);
				premiumCurrencyLabel.setText("Diamonds: " + String.valueOf(playerInventory.getPremiumCurrency()));

			}
		
		});
		
		LootBoxFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		LootBoxFrame.pack();
		LootBoxFrame.setSize(800, 600);
		LootBoxFrame.setVisible(true);
		
	
	}
	public void updateList(String s) {
		inventoryModel.removeAllElements();
		for(LootBox l : playerInventory.getInventory()) {
			inventoryModel.addElement(l);
		}
		currencyLabel.setText(s);
	}
	public void updateList() {
		inventoryModel.removeAllElements();
		for(LootBox l : playerInventory.getInventory()) {
			inventoryModel.addElement(l);
		}
		
	}
	
	public void updateCurrency(int amount, String s) {
		playerInventory.setCurrency(amount);
		currencyLabel.setText(s);
		
	}
	
	public void updatePremiumCurrency(String s, int amount) {
		playerInventory.setPremiumCurrency(amount);
		premiumCurrencyLabel.setText(s);
		
	}
}
