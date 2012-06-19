package de.codingmonk.hackady.core;

import java.awt.event.KeyEvent;

import de.codingmonk.hackady.gui.ShowItem;

public class KeyEventDispatcher implements java.awt.KeyEventDispatcher {

	 protected boolean locked = false;
	 private ShowItem showItem;
	 public KeyEventDispatcher(ShowItem showItem) {
		// TODO Auto-generated constructor stub
		 this.showItem = showItem;
	}
	public void setLocked(boolean lock) {
		 this.locked = lock;
	 }
	 public boolean getLocked() {
		 return this.locked;
	 }
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	public ShowItem getShowItem() {
		return showItem;
	}
	public void setShowItem(ShowItem showItem) {
		this.showItem = showItem;
	}

	
}
