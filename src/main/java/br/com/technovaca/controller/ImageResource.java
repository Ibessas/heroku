package br.com.technovaca.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.technovaca.model.Disk;

@RestController
@RequestMapping("/image")
public class ImageResource {
	

	@Autowired
	private Disk disk;
	
	@PostMapping("")
	public String upload(@RequestParam MultipartFile image) {
		String id = UUID.randomUUID().toString();
		disk.salvarFoto(image, id);
		return id;
	}
	
	@GetMapping("")
	public void download(HttpServletResponse response, @RequestParam String nome) throws IOException {
		File file = disk.pegarArquivo(nome);
	    if(file.exists()) {
	        String contentType = "image/png";
	        response.setContentType(contentType);
	        OutputStream out = response.getOutputStream();
	        FileInputStream in = new FileInputStream(file);
	        // copy from in to out
	        IOUtils.copy(in, out);
	        out.close();
	        in.close();
	    }else {
	        throw new FileNotFoundException();
	    }
	}
}
