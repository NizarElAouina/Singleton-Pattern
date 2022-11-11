package Banque;

public class CompteBancaire {
	private int numero;
	private double solde;
	public CompteBancaire(int numero) {
		this.numero=numero;
		solde = 0.0;
	}
	public void deposerArgent(double depot) {
		if (depot<=0.0) {
			Journalisation.getInstance().ajouterLog("Depot négatif impossible");
		}
		else {
			solde += depot;
			Journalisation.getInstance().ajouterLog("Depot de "+depot+" sur le compte n: "+numero);
		}
	}
	public void retirerArgent(double retrait) {
		if (retrait<=0.0) {
			Journalisation.getInstance().ajouterLog("Retrait négatif impossible");
		}
		else {
			if (retrait>= solde) {
				Journalisation.getInstance().ajouterLog("Solde"+solde+"insuffisant sur le compte n:"+ numero);
			}
			else {
				solde -= retrait;
				Journalisation.getInstance().ajouterLog("Retrait de "+retrait+" sur le compte n: "+numero);
			}
			
		}
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public static void main(String []args){
		CompteBancaire cb1 = new CompteBancaire(100234);
		cb1.deposerArgent(200.00);
		cb1.deposerArgent(-200.00);
		cb1.retirerArgent(-100.00);
		cb1.retirerArgent(50.00);
		String s = Journalisation.getInstance().afficherLog();
		System.out.println(s);
    }


}
