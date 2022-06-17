package factur;

public class Factur {
private int id, code_factur,code_compteur,index_nouveau,
index_precedent,CONSOMMATION;
private double Montant_total,Montant_nouveau,TVA;
private String mois,anne,date;
public int getCode_factur() {
	return code_factur;
}
public void setCode_factur(int code_factur) {
	this.code_factur = code_factur;
}
public int getCode_compteur() {
	return code_compteur;
}
public void setCode_compteur(int code_compteur) {
	this.code_compteur = code_compteur;
}
public int getIndex_nouveau() {
	return index_nouveau;
}
public void setIndex_nouveau(int index_nouveau) {
	this.index_nouveau = index_nouveau;
}
public int getIndex_precedent() {
	return index_precedent;
}
public void setIndex_precedent(int index_precedent) {
	this.index_precedent = index_precedent;
}
public int getCONSOMMATION() {
	return CONSOMMATION;
}
public void setCONSOMMATION(int cONSOMMATION) {
	CONSOMMATION = cONSOMMATION;
}
public double getMontant_total() {
	return Montant_total;
}
public void setMontant_total(double montant_total) {
	Montant_total = montant_total;
}
public double getMontant_nouveau() {
	return Montant_nouveau;
}
public void setMontant_nouveau(double montant_nouveau) {
	Montant_nouveau = montant_nouveau;
}
public double getTVA() {
	return TVA;
}
public void setTVA(double tVA) {
	TVA = tVA;
}
public String getMois() {
	return mois;
}
public void setMois(String mois) {
	this.mois = mois;
}
public String getAnne() {
	return anne;
}
public void setAnne(String anne) {
	this.anne = anne;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
} 



}
