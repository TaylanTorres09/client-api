package br.com.project.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.client.models.Client;
import br.com.project.client.repositories.ClientRepository;
import br.com.project.client.services.exceptions.ObjectNotFound;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client findByIdClient(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ObjectNotFound("Client not found"));
    }
}
