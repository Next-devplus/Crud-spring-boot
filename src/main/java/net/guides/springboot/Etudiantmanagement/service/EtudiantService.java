package net.guides.springboot.Etudiantmanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot.Etudiantmanagement.model.Etudiant;
import net.guides.springboot.Etudiantmanagement.repository.EtudiantRepository;

@Service
public class EtudiantService implements IEtudiantService {

	@Autowired
	private EtudiantRepository EtudiantRepository;

	@Override
	public List<Etudiant> getEtudiantsByUser(String user) {
		return EtudiantRepository.findByUserName(user);
	}

	@Override
	public Optional<Etudiant> getEtudiantById(long id) {
		return EtudiantRepository.findById(id);
	}

	@Override
	public void updateEtudiant(Etudiant Etudiant) {
		EtudiantRepository.save(Etudiant);
	}

	@Override
	public void addEtudiant(String name, String desc, Date targetDate, boolean isDone) {
		EtudiantRepository.save(new Etudiant(name, desc, targetDate, isDone));
	}

	@Override
	public void deleteEtudiant(long id) {
		Optional<Etudiant> Etudiant = EtudiantRepository.findById(id);
		if (Etudiant.isPresent()) {
			EtudiantRepository.delete(Etudiant.get());
		}
	}

	@Override
	public void saveEtudiant(Etudiant Etudiant) {
		EtudiantRepository.save(Etudiant);
	}
}