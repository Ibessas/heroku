package br.com.technovaca.controller.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.technovaca.model.bovideo.Bovideo;
import br.com.technovaca.service.BovideoService;

@Component
public class StringToBovideoConverter implements Converter<String, Bovideo> {

	@Autowired
	private BovideoService service;
	

	@Override
	public Bovideo convert(String source) {
		return service.getBovideoById(Integer.valueOf(source));
	}
	
//	@Override
//	public Rebanho convert(String source) {
//		
//		return service.getRebanhoById(Integer.valueOf(source));
//	}

}
