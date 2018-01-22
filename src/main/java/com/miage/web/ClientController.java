/**
 * 
 */
package com.miage.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;


import com.miage.entities.Audio;
import com.miage.entities.Client;
import com.miage.entities.Livre;
import com.miage.entities.Media;
import com.miage.entities.Video;
import com.miage.metier.implement.AudioMetierImp;
import com.miage.metier.implement.ClientMetierImpl;
import com.miage.metier.implement.EmpruntMetierImp;
import com.miage.metier.implement.LivreMetierImp;
import com.miage.metier.implement.RetourMetierImp;
import com.miage.metier.implement.VideoMetierImp;


/**
 * @author HRezgui
 *
 */
@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientMetierImpl clientService;
	@Autowired
	private VideoMetierImp videoService;

	@Autowired
	private AudioMetierImp audioService;
	@Autowired
	private LivreMetierImp livreService;
	
	@Autowired
	private EmpruntMetierImp empruntService;
	
	@Autowired
	private RetourMetierImp retourService;

	
	@RequestMapping(value = "/client")
	public String client() {
		return "client/clientTemplate";
	}

	@RequestMapping(value = "/accueil")
	public String accueil() {
		return "client/accueilClient";
	}
	
	//TODO 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String save(@Valid Client cl, BindingResult b) {
		if (b.hasErrors()) {
			return "client/editClient";
		}
		
		//TODO changer le codeClient par celle de session ouverte
		Long myCodeClient= (long)1;
		clientService.modifierClient(myCodeClient, cl);
		return "client/editClient";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Long code, Model model) {
		Client cl = clientService.consulterClient(code);
		model.addAttribute("clientedi", cl);
		return "client/editClient";
	}
	

	@RequestMapping("/consultm")
	public String consultMedia(Model model) {
		return "client/consultMedia";
	}

	
	@RequestMapping("/consultv")
	public String consultVideo(Model model) {
		List<Video> vi = videoService.listVideo(new PageRequest(0,8)).getContent();
		model.addAttribute("listmediav", vi);
		return "client/consultvideo";
	}
	
	@RequestMapping("/consulta")
	public String consultAudio(Model model) {
		List<Audio> vi = audioService.listAudio(new PageRequest(0,8)).getContent();
		model.addAttribute("listmediav", vi);
		return "client/consultaudio";
	}
	
	@RequestMapping("/consultl")
	public String consultLivre(Model model) {
		List<Livre> vi = livreService.listLivre(new PageRequest(0,8)).getContent();
		model.addAttribute("listmediav", vi);
		return "client/consultlivre";
	}
	
	
	@RequestMapping("/consultme")
	public String consultMediaEmp(Model model) {
		return "client/consultMediaEmp";
	}
	
	@RequestMapping("/consultvEmp")
	public String consultVideoEmp(Client client, Model model) {
		
		List<Media> empv = empruntService.consulterMediaEmp(client,new PageRequest(0,8)).getContent();
		
		//TODO selecter que les videos dans la liste 
		model.addAttribute("listmediaempv", empv);
		return "client/consultvideoEmp";
	}
	
	@RequestMapping("/consultaEmp")
	public String consultAudioEmp(Client client, Model model) {
		List<Media> empa = empruntService.consulterMediaEmp(client,new PageRequest(0,8)).getContent();
		model.addAttribute("listmediaempa", empa);
		return "client/consultaudioEmp";
	}
	
	@RequestMapping("/consultlEmp")
	public String consultLivreEmp(Client client, Model model) {
		List<Media> empl = empruntService.consulterMediaEmp(client,new PageRequest(0,8)).getContent();
		model.addAttribute("listmediaempl", empl);
		return "client/consultlivreEmp";
	}
	
	
	@RequestMapping("/consultmr")
	public String consultMediaRet(Model model) {
		return "client/consultMediaRet";
	}
	
	@RequestMapping("/consultvRet")
	public String consultVideoRet(Client client, Model model) {
		List<Media> Retv= retourService.consulterMediaRet(client,new PageRequest(0,8)).getContent();
		

        model.addAttribute("listmediaRetv", Retv);
		return "client/consultvideoRet";
	}
	
	@RequestMapping("/consultaRet")
	public String consultAudioRet(Client client, Model model) {
		List<Media> Reta = retourService.consulterMediaRet(client,new PageRequest(0,8)).getContent();
		
		model.addAttribute("listmediaReta", Reta);
		return "client/consultaudioRet";
	}
	
	
	@RequestMapping("/consultlRet")
	public String consultLivreRet(Client client, Model model) {
		List<Media> Retl = retourService.consulterMediaRet(client,new PageRequest(0,8)).getContent();
		
		
		model.addAttribute("listmediaRetl", Retl);
		return "client/consultlivreRet";
	}
	
	
	@RequestMapping("/parametre")
	public String parametre() {
	return "client/parametre";
	}
	
	
}
