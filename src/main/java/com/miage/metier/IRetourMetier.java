package com.miage.metier;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miage.entities.Client;
import com.miage.entities.Media;
import com.miage.entities.Retour;

/**
 * @author HRezgui
 *
 */

public interface IRetourMetier {
	
	public Page<Media >consulterMediaRet(Client client, Pageable pageable);
	public Page<Retour> consulterRetByClient(Client client,Pageable pageable);
	public Page<Retour> consulterRetByDateOp(Date dateOp, Pageable pageable);
	
	public Retour consulterRet(Long codeRet);
	public Page<Retour>listRet(Pageable pageable);
	public void supprimerRet(Long codeRet);
	public void modifierRet (Long codeRet, Retour ret);

}
