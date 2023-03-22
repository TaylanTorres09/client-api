package br.com.project.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.client.models.Client;
import br.com.project.client.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client findByIdClient(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(null);
    }
}
