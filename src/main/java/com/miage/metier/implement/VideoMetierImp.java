package com.miage.metier.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.VideoRepository;
import com.miage.entities.Video;
import com.miage.metier.IVideoMetier;

/**
 * @author HRezgui
 *
 */

@Service
@Transactional
public class VideoMetierImp implements IVideoMetier {
	
	@Autowired
	private VideoRepository videoRep;

	@Override
	public Page<Video> chercherVideoParNom(String nom, Pageable page) {
		return videoRep.findByName(nom, page);
	}

	@Override
	public Page<Video> listVideoDisop(Pageable page) {
		return videoRep.lstMediaByEtat(1, page);
	}

	@Override
	public Page<Video> listVideoInDisop(Pageable page) {
		return videoRep.lstMediaByEtat(0, page);
	}

	@Override
	public Video consulterVideo(Long code) {
		return videoRep.findOne(code);
	}

	@Override
	public Page<Video> listVideo(Pageable page) {
		return videoRep.findAll(page);
	}

	@Override
	public void effacerVideo(Long code) {
		videoRep.delete(code);		
	}

	@Override
	public void modifierVideo(Long code, Video v) {
		Video v2 = videoRep.getOne(code);
		v2.setActeur(v.getActeur());
		v2.setAnneeDeSortie(v.getAnneeDeSortie());
		v2.setDateCreation(v.getDateCreation());
		v2.setEmploye(v.getEmploye());
		v2.setEtat(v.getEtat());
		v2.setNom(v.getNom());
		v2.setDescription(v.getDescription());
		v2.setRealisateur(v.getRealisateur());
		v2.setPhoto(v.getPhoto());
		
		videoRep.saveAndFlush(v2);		
	}

}
