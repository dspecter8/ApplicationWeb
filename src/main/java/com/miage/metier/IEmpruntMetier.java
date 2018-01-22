package com.miage.metier;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miage.entities.Client;
import com.miage.entities.Emprunt;
import com.miage.entities.Media;

/**
 * @author HRezgui
 *
 */
public interface IEmpruntMetier {

	public Page<Media >consulterMediaEmp(Client client, Pageable pageable);
	public Page<Emprunt> consulterEmpByClient(Client client,Pageable pageable);
	public Page<Emprunt> consulterEmpByDateOp(Date dateOp, Pageable pageable);
	
	public Emprunt consulterEmp(Long codeEmp);
	public Page<Emprunt>listEmp(Pageable pageable);
	public void supprimerEmp(Long codeEmp);
	public void modifierEmp (Long codeEmp, Emprunt emp);
	
	
	
	
}
