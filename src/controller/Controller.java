package controller;

import structs.TCommand;
import model.IModel;

public class Controller implements IController{

	private IModel model;
	
	public Controller(IModel model) {
		this.model = model;
	}
	
	public void execute(TCommand command){
		switch (command) {
			case CommandEnable: model.enable(); break;
			case CommandDisable: model.disable(); break;
			case CommandRun: model.run(); break;
	}		
	}
}
