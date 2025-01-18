package com.example.client.services;

import com.example.client.entities.Client;
import com.example.client.entities.Voiture;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(
                () -> new Exception("Invalid Client ID")
        );
    }

    public Mono<Voiture> getVoitureForClient(Long clientId) {
        String url = "http://SERVICE-VOITURE/api/voitures/client?clientId=" + clientId;
        return webClientBuilder.build().get().uri(url).retrieve().bodyToMono(Voiture.class);
    }

    public void addClient(String name ,Float age) {

        clientRepository.save(new Client(name,age));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
