package net.guides.springboot.Etudiantmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot.Etudiantmanagement.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	List<Etudiant> findByUserName(String user);
}
