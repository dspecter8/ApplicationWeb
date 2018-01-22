package com.miage.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miage.entities.Audio;

public interface IAudioMetier {
	
	public Page<Audio> chercherAudioParNom(String nom, Pageable page);
	public Page<Audio> listAudioDisop(Pageable page);
	public Page<Audio> listAudioInDisop(Pageable page);
	
	public Audio consulterAudio(Long code);
	public Page<Audio> listAudio(Pageable page);
	public void effacerAudio(Long code);
	public void modifierAudio (Long code, Audio audio);
	
	
	
	

}
