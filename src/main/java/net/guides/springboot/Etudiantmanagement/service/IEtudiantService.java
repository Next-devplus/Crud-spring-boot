package net.guides.springboot.Etudiantmanagement.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import net.guides.springboot.Etudiantmanagement.model.Etudiant;

public interface IEtudiantService {

	List<Etudiant> getEtudiantsByUser(String user);

	Optional<Etudiant> getEtudiantById(long id);

	void updateEtudiant(Etudiant Etudiant);

	void addEtudiant(String name, String desc, Date targetDate, boolean isDone);

	void deleteEtudiant(long id);
	
	void saveEtudiant(Etudiant Etudiant);

}