package command;

import lib.ConsoleReader;
import metier.ClientService;

public interface IHMCommand {
	
	
	
	abstract public int getId();
	abstract public String getLib();
	abstract public void execute();
}
