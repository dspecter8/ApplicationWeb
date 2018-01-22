package com.miage.metier.implement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.RetourRepository;
import com.miage.entities.Client;
import com.miage.entities.Media;
import com.miage.entities.Retour;
import com.miage.metier.IRetourMetier;

/**
 * @author HRezgui
 *
 */

@Service
@Transactional
public class RetourMetierImp implements IRetourMetier {

	@Autowired
	private RetourRepository retourRep;
	
	@Override
	public Page<Media> consulterMediaRet(Client client, Pageable pageable) {
		return retourRep.consulterMediaRet(client, pageable);
	}

	@Override
	public Page<Retour> consulterRetByClient(Client client, Pageable pageable) {
		return retourRep.consulterRetByClient(client, pageable);
	}

	@Override
	public Page<Retour> consulterRetByDateOp(Date dateOp, Pageable pageable) {
		return retourRep.consulterRetByDateOp(dateOp, pageable);
	}

	@Override
	public Retour consulterRet(Long codeRet) {
		return retourRep.findOne(codeRet);
	}

	@Override
	public Page<Retour> listRet(Pageable pageable) {
		return retourRep.findAll(pageable);
	}

	@Override
	public void supprimerRet(Long codeRet) {
		retourRep.delete(codeRet);		
	}

	@Override
	public void modifierRet(Long codeRet, Retour ret) {
		

		 Retour ret2 = retourRep.findOne(codeRet);
		 ret2.setClient(ret.getClient());
		 ret2.setMedia(ret.getMedia());
		 
		 retourRep.saveAndFlush(ret2);
		
	}

}
