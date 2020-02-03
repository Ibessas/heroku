package br.com.technovaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.technovaca.model.bovideo.Bovideo;

@Repository
public interface BovideoRepository extends JpaRepository<Bovideo, String>{
	Bovideo getBovideoById(int id);
}
