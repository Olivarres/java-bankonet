package metier;

import java.util.Scanner;

import dao.compte.CompteDAO;
import lib.Client;
import lib.Compte;
import lib.CompteCourant;
import lib.CompteException;

public class CompteServiceImpl implements CompteService {

	private CompteDAO cpm;
	
	public CompteServiceImpl(CompteDAO cp) {
		this.cpm = cp;
	}
	
	@Override
	public void displayComptes(Class<? extends Compte> type, Client client) {
		StringBuilder builder = new StringBuilder();
		for (Compte c : cpm.findAll()) {
			builder.append(c.toString() + "\n");
		}
		System.out.println(builder);
	}

	public void ajoutCompte(Class<? extends Compte> type, Client client) {
		String str;
		
		str = client.synthese(type);
		try {
			cpm.save(type, cpm.create(client, str, type), client);
		} catch (CompteException e) {
			e.printStackTrace();
		}
		System.out.println(cpm.findByIntitule(type, str, client));
	}
	
	@Override
	public Compte getCompte(Class<? extends Compte> type, Client client, String id) {
		return cpm.findById(id, client);
	}
	
	public Compte getCompteByNum(Class<? extends Compte> type, Client client, String num) {
		return cpm.findByNum(type, client, num);
	}
	
	public Compte getCompteByType(Class<? extends Compte> type, Client client) {
		return cpm.findByType(type, client);
	}
	
	public void updateCompte(Compte compte) {
		cpm.mergeCompte(compte);
	}
	
	public void displayAll(Client client) {
		StringBuilder builder = new StringBuilder();
		//Iterator<Compte> it = client.getComptesList().values().iterator();
		Compte compte = null;
		
//		while (it.hasNext()) {
//			compte = it.next();
//			builder.append(compte.toString() + "\n");
//			
//		}
		System.out.println(builder.toString());
	}
	
	public Compte getCompteVire(String type, Client client) {
//		boolean ok = false;
//		Compte compte = null;
//		
//		this.displayAll(client);
//		while(!ok) {
//			System.out.println("Choisir un compte � " + type);
//			if ((compte = client.getComptesList().get(this.Scandat(0))) != null) {
//				ok = true;
//			}
//		}
		return null;
	}
	

	public void faireDepot(Client client) {
		boolean ok = false;
		Compte compte = null;
		
		compte = this.getCompteVire("cr�diter", client);
		while(!ok) {
			System.out.println("Saisir un montant:");
				try {
					compte.crediter(Double.valueOf("20"));
					//fm.writeData(clientsList);
					ok = true;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CompteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	
	public void modifDecouvert(Compte compte, int decouvert, Client client) {
			
		((CompteCourant)compte).setMontantDecouvertAutorise(decouvert);
//		cpm.save(CompteCourant.class, compte, client);
		cpm.mergeCompte(compte);
		System.out.println(compte);
		}
	
	
	public CompteDAO getCpm() {
		return cpm;
	}

	public void setCpm(CompteDAO cpm) {
		this.cpm = cpm;
	}

}
