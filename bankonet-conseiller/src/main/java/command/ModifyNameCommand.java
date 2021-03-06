package command;

import command.IHMCommand;
import lib.Client;
import lib.ConsoleReader;
import metier.ClientService;
import metier.CompteService;

public class ModifyNameCommand implements IHMCommand {
	
	private int id = 8;
	private String lib = ". Modifier le nom d'un client";
	private ClientService cs;
	private ConsoleReader scan;
	
	public ModifyNameCommand(ClientService cs, ConsoleReader scan, CompteService compteService) {
		this.cs = cs;
		this.scan = scan;
	}
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getLib() {
		
		return lib;
	}

	@Override
	public void execute() {
		Client client = cs.getClient(scan.readLine("Entrer un login"));
		client.setNom(scan.readLine("Entrer le nouveau nom"));
		if ("V".equals(scan.readLine("Valider en saisissant V ou annuler en saisissant A"))) {
			cs.updateClient(client);
		}
	}

}
