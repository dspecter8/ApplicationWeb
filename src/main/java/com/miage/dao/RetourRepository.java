package com.miage.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Client;
import com.miage.entities.Media;
import com.miage.entities.Retour;
/**
 * @author HRezgui
 *
 */

public interface RetourRepository extends JpaRepository<Retour, Long> {

	@Query("select e.media  from Retour e   where e.client=:x ")
	Page<Media> consulterMediaRet(@Param("x")Client client, Pageable pageable);

	@Query("select e  from Retour e   where e.client=:x ")
	Page<Retour> consulterRetByClient(Client client,Pageable pageable);
	
	@Query("select e  from Retour e   where e.dateOperation=:x ")
	Page<Retour> consulterRetByDateOp(Date dateOp, Pageable pageable);


}
