package com.miage.metier.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.AudioRepository;
import com.miage.entities.Audio;
import com.miage.metier.IAudioMetier;

/**
 * @author HRezgui
 *
 */

@Service
@Transactional
public class AudioMetierImp  implements IAudioMetier{
	
	@Autowired
	private AudioRepository audioRep;

	@Override
	public Page<Audio> chercherAudioParNom(String nom, Pageable page) {
		return audioRep.findByName(nom, page);
	}

	@Override
	public Page<Audio> listAudioDisop(Pageable page) {
		return audioRep.lstMediaByEtat(1, page);
	}

	@Override
	public Page<Audio> listAudioInDisop(Pageable page) {
		return audioRep.lstMediaByEtat(0, page);
	}

	@Override
	public Audio consulterAudio(Long code) {
		return audioRep.findOne(code);
	}

	@Override
	public Page<Audio> listAudio(Pageable page) {
		return audioRep.findAll(page);
	}

	@Override
	public void effacerAudio(Long code) {
		audioRep.delete(code);		
	}

	@Override
	public void modifierAudio(Long code, Audio v) {
		
		Audio v2 = audioRep.getOne(code);
		v2.setChateur(v.getChateur());
		v2.setAnneeDeSortie(v.getAnneeDeSortie());
		v2.setDateCreation(v.getDateCreation());
		v2.setEmploye(v.getEmploye());
		v2.setEtat(v.getEtat());
		v2.setNom(v.getNom());
		v2.setDescription(v.getDescription());
		v2.setPhoto(v.getPhoto());
		
		audioRep.saveAndFlush(v2);

		 
	}

}
