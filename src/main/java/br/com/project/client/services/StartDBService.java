package br.com.project.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.client.models.Client;
import br.com.project.client.repositories.ClientRepository;

@Service
public class StartDBService {

    @Autowired
    private ClientRepository clientRepository;

    public void instatiateDataBase() {
        Client client = new Client(null, "Durotan", 35, "Vale Alterac");

        clientRepository.save(client);
    }
    
}
