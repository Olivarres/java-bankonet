package metier;

import lib.Client;
import lib.Compte;


public interface CompteService {

	public void displayComptes(Class<? extends Compte> type, Client client);
	public Compte getCompte(Class<? extends Compte> type, Client client, String id);
	public Compte getCompteVire(String type, Client client);
	public Compte getCompteByNum(Class<? extends Compte> type, Client client, String num);
	//public Compte getCompteByIntitule(Class<? extends Compte> type, String intitule, Client client);
	public void ajoutCompte(Class<? extends Compte> type, Client client);
	public void displayAll(Client client);
	public void faireDepot(Client client);
	public void updateCompte(Compte compte);
	public void modifDecouvert(Compte compte, int decouvert, Client client);
}
