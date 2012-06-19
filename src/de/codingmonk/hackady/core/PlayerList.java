package de.codingmonk.hackady.core;

import java.util.ArrayList;

public class PlayerList extends ArrayList<Player>{
	private static PlayerList instance;
	
	
	public static PlayerList getInstance() {
		if(instance == null)
			instance = new PlayerList();
		return instance;
	}
	
	private PlayerList() {
		
	}
}
