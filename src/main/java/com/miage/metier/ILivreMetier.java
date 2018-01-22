package com.miage.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miage.entities.Livre;


/**
 * @author HRezgui
 *
 */
public interface ILivreMetier {
	
	public Page<Livre> chercherLivreParNom(String nom, Pageable page);
	public Page<Livre> listLivreDisop(Pageable page);
	public Page<Livre> listLivreInDisop(Pageable page);
	
	public Livre consulterLivre(Long code);
	public Page<Livre> listLivre(Pageable page);
	public void effacerLivre(Long code);
	public void modifierLivre (Long code, Livre video);

}
