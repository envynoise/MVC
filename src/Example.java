import view.ViewRecipient;
import model.ModelPublisher;

public class Example {

	public static void main(String[] args) throws Exception {
		ModelPublisher m = new ModelPublisher();
		ViewRecipient v = new ViewRecipient(m);
		v.showMain();
	}

}
