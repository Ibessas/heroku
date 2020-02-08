package br.com.technovaca.controller.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.technovaca.model.Rebanho;
import br.com.technovaca.service.RebanhoService;

@Component
public class StringToRebanhoConverter implements Converter<String, Rebanho> {

	@Autowired
	private RebanhoService service;
	

	@Override
	public Rebanho convert(String source) {
		return service.getRebanhoById(Integer.valueOf(source));
	}
	
//	@Override
//	public Rebanho convert(String source) {
//		
//		return service.getRebanhoById(Integer.valueOf(source));
//	}

}
