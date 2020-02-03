package br.com.technovaca.controler;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import br.com.technovaca.controller.UsuarioController;
import br.com.technovaca.model.Usuario;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestUsuarioTest {
	
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsuarioController controller;
    
	@Test
	public void testGetAllUsuario() {
		controller.postUsuario(new Usuario("Amarildo","amarildo@mail.com","88988888888","12346"));
		controller.postUsuario(new Usuario("Josicleber","josicleber@mail.com","88988888888","654321"));
		String json = this.restTemplate.getForObject("http://localhost:" + port + "/usuario/cadastrar",String.class);
		String[] expected = {"Amarildo","amarildo@mail.com","88988888888",
				"Josicleber","josicleber@mail.com","88988888888"};
		assertThat(json).contains(expected);
	}

	@Test
	public void testGetUsuarioById() {
		String json = this.restTemplate.getForObject("http://localhost:" + port + "/usuario/1",String.class);
		String[] expected = {"Israel Bessa Teste","silvaisraelb@gmail.com","88988860542"};
		assertThat(json).contains(expected);
	}

	@Test
	public void testPostUsuario() {
		Usuario mario = new Usuario("Mario", "mario@email.com", "88988888888","12346");
		String json = this.restTemplate.postForObject("http://localhost:" + port + "/usuario/",mario,String.class);
		assertThat(json).contains("Mario", "mario@email.com", "88988888888");
	}

	@Test
	public void testPutUsuario() throws RestClientException, URISyntaxException {
		Usuario mario = new Usuario("Mariana", "mario@email.com", "88988888888","12346");
		this.restTemplate.put(new URI("http://localhost:" + port + "/usuario/34"),mario);
		String json = this.restTemplate.getForObject("http://localhost:" + port + "/usuario/34",String.class);
		assertThat(json).contains("Mariana", "mario@email.com", "88988888888");
	}

	@Test
	public void testDeleteUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRebanho() {
		fail("Not yet implemented");
	}

}
