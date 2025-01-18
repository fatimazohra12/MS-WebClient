package com.example.carprojet;

import com.example.carprojet.entities.Voiture;
import com.example.carprojet.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;

@EnableDiscoveryClient
@SpringBootApplication
public class VoitureProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureProjetApplication.class, args);
	}
	@Bean
	CommandLineRunner initializeBaseH2(VoitureRepository voitureRepository){
		return args -> {
			String[] marques = {
					"Citroën", "Alfa Romeo", "Dacia", "Seat", "Skoda",
					"Lexus", "Porsche", "Jaguar", "Mitsubishi", "Opel",
					"Suzuki", "Mini", "Infiniti", "Cadillac", "Chrysler",
					"Dodge", "Buick", "Acura", "Ram", "Genesis", "Mercedes", "Hyundai",
					"Nissan", "Jeep", "Volvo",  "Tesla", "Range Rover"
			};


			IntStream.rangeClosed(1, 50).forEach(i -> {
				String voitureMarque = marques[(i - 1) % marques.length];
				String voitureModel = voitureMarque + " Model " + ((i % 10) + 1);
				int voitureYear = 2000 + (i % 24); // Année entre 2000 et 2023
				String voiturePlate = String.format("FR-%03d-%02d", i, (i % 99) + 1); // Plaque unique
				voitureRepository.save(new Voiture(voitureModel, voitureYear, voiturePlate, Long.valueOf(i)));
			});
		};
	}
}
