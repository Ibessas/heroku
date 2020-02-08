package br.com.technovaca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.technovaca.model.bovideo.Bovideo;

@Repository
public interface BovideoRepository extends JpaRepository<Bovideo, String>{
	Bovideo getBovideoById(int id);

	List<Bovideo> getByRebanhoId(int id);
}
