package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeBaseH2(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client("Paul MARTIN", 34f));
			clientRepository.save(new Client("Marie DUPONT", 32f));
			clientRepository.save(new Client("Jean DURAND", 36f));
			clientRepository.save(new Client("Sophie LAMBERT", 30f));
			clientRepository.save(new Client("Pierre MOREAU", 37f));
			clientRepository.save(new Client("Claire RENAUD", 33f));
			clientRepository.save(new Client("Julien FABRE", 38f));
			clientRepository.save(new Client("Camille BERNARD", 31f));
			clientRepository.save(new Client("Lucas ROUX", 39f));
			clientRepository.save(new Client("Emma GIRARD", 35f));
			clientRepository.save(new Client("Thomas LEGRAND", 34f));
			clientRepository.save(new Client("Chloé RICHARD", 30f));
			clientRepository.save(new Client("Nicolas SIMON", 37f));
			clientRepository.save(new Client("Élise PERRIN", 33f));
			clientRepository.save(new Client("Antoine BLANC", 36f));
			clientRepository.save(new Client("Alice BOURGEOIS", 32f));
			clientRepository.save(new Client("Victor BONNET", 35f));
			clientRepository.save(new Client("Amélie CHEVALIER", 34f));
			clientRepository.save(new Client("Maxime DUPUIS", 31f));
			clientRepository.save(new Client("Lucie BARBIER", 30f));
			clientRepository.save(new Client("Hugo GARNIER", 36f));
			clientRepository.save(new Client("Julie MICHEL", 33f));
			clientRepository.save(new Client("Florian MARTINEZ", 37f));
			clientRepository.save(new Client("Charlotte GAUTIER", 32f));
			clientRepository.save(new Client("Alexandre PASCAL", 34f));
			clientRepository.save(new Client("Aurore LUCAS", 35f));
			clientRepository.save(new Client("Bastien ROUSSEAU", 36f));
			clientRepository.save(new Client("Noémie GERARD", 31f));
			clientRepository.save(new Client("Jules LECLERC", 39f));
			clientRepository.save(new Client("Elena FERNANDEZ", 30f));
			clientRepository.save(new Client("Martin DUMONT", 38f));
			clientRepository.save(new Client("Clara MALLET", 32f));
			clientRepository.save(new Client("Théo LEROY", 35f));
			clientRepository.save(new Client("Anaïs DELACOUR", 33f));
			clientRepository.save(new Client("Benjamin MONET", 36f));
			clientRepository.save(new Client("Louise REGNIER", 31f));
			clientRepository.save(new Client("Cédric PETIT", 37f));
			clientRepository.save(new Client("Aurélie MARC", 34f));
			clientRepository.save(new Client("Romain LAFARGE", 32f));
			clientRepository.save(new Client("Laurence BRETON", 33f));
			clientRepository.save(new Client("Dylan GRIMAUD", 38f));
			clientRepository.save(new Client("Sabrina PELLETIER", 30f));
			clientRepository.save(new Client("Adrien COUTURIER", 36f));
			clientRepository.save(new Client("Manon LAPORTE", 34f));
			clientRepository.save(new Client("Vincent MARTEL", 37f));
			clientRepository.save(new Client("Émilie THEBAULT", 32f));
			clientRepository.save(new Client("Kevin VALLET", 31f));
			clientRepository.save(new Client("Camille DUPRE", 30f));
			clientRepository.save(new Client("Amandine LOPEZ", 33f));

		};
	}
	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
