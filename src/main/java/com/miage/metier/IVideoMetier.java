package com.miage.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miage.entities.Video;
/**
 * @author HRezgui
 *
 */
public interface IVideoMetier {
	
	public Page<Video> chercherVideoParNom(String nom, Pageable page);
	public Page<Video> listVideoDisop(Pageable page);
	public Page<Video> listVideoInDisop(Pageable page);
	
	public Video consulterVideo(Long code);
	public Page<Video> listVideo(Pageable page);
	public void effacerVideo(Long code);
	public void modifierVideo (Long code, Video video);

}
