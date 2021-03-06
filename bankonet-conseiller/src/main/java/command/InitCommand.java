package command;

import java.sql.SQLException;
import java.sql.Statement;

import command.IHMCommand;
import lib.ConsoleReader;
import lib.DBManager;
import metier.ClientService;
import metier.CompteService;

public class InitCommand implements IHMCommand {
	private int id = 10;
	private String lib = ". Initialiser la BDD";
	ClientService cs;
	
	public InitCommand(ClientService cs, ConsoleReader scan, CompteService compteService) {
		this.cs = cs;
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
		DBManager dbm = new DBManager();
		
		dbm.connectMySQL();
		try {
			Statement state = dbm.connection.createStatement();
			state.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,IDENTIFIANT,PWD) VALUES('Winchester','Dean','WinD', 'pwd')");
			state.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,IDENTIFIANT,PWD) VALUES('Winchester','Sammy','WinS', 'pwd')");
			state.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,IDENTIFIANT,PWD) VALUES('Dunno','Ellen','DunnE', 'pwd')");
			state.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,IDENTIFIANT,PWD) VALUES('Dunno','Bobby','DunnB', 'pwd')");
			state.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,IDENTIFIANT,PWD) VALUES('Dunno','Jo','DunnJ', 'pwd')");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
