package model;

import java.util.*;
import structs.TEvent;
import view.IRecipient;

public class Publisher {
	private List<IRecipient> recipients;
	
	public Publisher() {
		recipients = new ArrayList<IRecipient>();
	}
	
	protected void notify(TEvent event) {
		for (IRecipient r: recipients)
			r.notification(event);
	}
	
	public void subscribe(IRecipient recipient) {
		recipients.add(recipient);
	}
	
	public void unsubscribe(IRecipient recipient) {
		recipients.remove(recipient);
	}
}
