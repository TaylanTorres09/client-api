package br.com.project.client.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.client.dtos.ClientDTO;
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

    public Client createClient(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Long clientId, ClientDTO clientDTO) {
        Client client = this.findByIdClient(clientId);
        BeanUtils.copyProperties(clientDTO, client);

        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        this.findByIdClient(clientId);

        clientRepository.deleteById(clientId);
    }


}
