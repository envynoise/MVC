package model;

import structs.TEvent;

public class ModelPublisher extends Publisher implements IModel{
	private boolean enabled, isRunned;
	
	public ModelPublisher() {
		enabled = false;
		isRunned = false;
	}
	
	public void enable() {
		if (isRunned) {
			error("You cant change smth while is runned!");
		}
		else {
			enabled = true;
			changed(true);
		}
	}
	
	public void disable() {
		if (isRunned) {
			error("You cant change smth while is runned!");
		}
		else {
			enabled = false;
			changed(false);
		}
	}
	
	public void run() {
		if (!enabled) {
			error("You cant run while not enabled!");
		}
		else {
			isRunned = true;
			runned();
		}
	}
	
	public boolean getState() {
		return enabled;
	}
	
	void error(String errMsg) {
		TEvent err = new TEvent();
		err.type=0;
		err.error=errMsg;
		notify(err);
	}
	
	void changed(boolean b) {
		TEvent evnt = new TEvent();
		if (b) 
			evnt.type=1;
		else evnt.type=2;
		evnt.error="";
		notify(evnt);
	}
	
	void runned() {
		TEvent evnt = new TEvent();
		evnt.type=3;
		evnt.error="";
		notify(evnt);
	}
}
