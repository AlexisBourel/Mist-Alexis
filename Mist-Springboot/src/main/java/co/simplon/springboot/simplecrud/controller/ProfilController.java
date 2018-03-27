package co.simplon.springboot.simplecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.springboot.simplecrud.model.Profil;
import co.simplon.springboot.simplecrud.repository.profilRepository;

@RestController
@RequestMapping("/api")
public class ProfilController {
	
	@Autowired
	profilRepository profilRepo;
	
	@CrossOrigin
	@GetMapping("/profil")
	List<Profil> getAllProfils(){
		return profilRepo.findAll();
	}
	
}
