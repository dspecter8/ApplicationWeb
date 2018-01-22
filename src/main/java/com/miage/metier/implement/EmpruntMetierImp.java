package com.miage.metier.implement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.EmpruntRepository;
import com.miage.entities.Client;
import com.miage.entities.Emprunt;
import com.miage.entities.Media;
import com.miage.metier.IEmpruntMetier;

/**
 * @author HRezgui
 *
 */

@Service
@Transactional
public class EmpruntMetierImp implements IEmpruntMetier {

	@Autowired
	private EmpruntRepository empruntRep;
	
	@Override
	public Page<Media> consulterMediaEmp(Client client, Pageable pageable) {
		
		return empruntRep.consulterMediaEmp(client, pageable);
	}

	@Override
	public Page<Emprunt> consulterEmpByClient(Client client, Pageable pageable) {
		
		return empruntRep.consulterEmpByClient(client, pageable);
	}

	@Override
	public Page<Emprunt> consulterEmpByDateOp(Date dateOp, Pageable pageable) {
		 
		return empruntRep.consulterEmpByDateOp(dateOp, pageable);
	}

	@Override
	public Emprunt consulterEmp(Long codeEmp) {
		 
		return empruntRep.findOne(codeEmp);
	}

	@Override
	public Page<Emprunt> listEmp(Pageable pageable) {
		 
		return empruntRep.findAll(pageable);
	}

	@Override
	public void supprimerEmp(Long codeEmp) {
		empruntRep.delete(codeEmp);
		
	}

	@Override
	public void modifierEmp(Long codeEmp, Emprunt emp) {
		
		 Emprunt emp2 = empruntRep.findOne(codeEmp);
		 emp2.setClient(emp.getClient());
		 emp2.setDateLimRetour(emp.getDateLimRetour());
		 emp2.setMedia(emp.getMedia());
		 
		 empruntRep.saveAndFlush(emp2);
		
	}

}
