package br.com.technovaca.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

@Component
public class Disk {
	
	@Value("${bovideo.disco}")
	private String raiz;
	
	@Value("${bovideo.disco.diretorio}")
	private String diretorio;
	
	public void salvarFoto(MultipartFile foto, String id) {
		this.salvar(this.diretorio,foto, id);
	}

	public void salvar(String diterotio, MultipartFile foto, String id) {
		Path diretorioPath = Paths.get(raiz, diretorio);
		Path aqruivoPath = diretorioPath.resolve(id+".png");
		
		try {
			Files.createDirectories(diretorioPath);
			
			foto.transferTo(aqruivoPath.toFile());
		}catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	public File pegarArquivo(String nome) throws IOException{
		Resource res = null;
		Path diretorioPath = Paths.get(raiz, diretorio).resolve(nome).normalize();
		try {
			res = new UrlResource(diretorioPath.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return res.getFile();
	}
	
}
