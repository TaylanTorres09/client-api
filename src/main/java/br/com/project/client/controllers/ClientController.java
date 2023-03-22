package br.com.project.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.client.models.Client;
import br.com.project.client.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Client findByIdClient(@PathVariable Long clientId) {
        return clientService.findByIdClient(clientId);
    }

}
