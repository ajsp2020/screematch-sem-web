package br.com.example.screenmatch;

import br.com.example.screenmatch.model.DadosSerie;
import br.com.example.screenmatch.service.ConsumoApi;
import br.com.example.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverteDados converson = new ConverteDados();
		DadosSerie dados = converson.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
