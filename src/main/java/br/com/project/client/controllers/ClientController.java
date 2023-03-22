package br.com.project.client.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.project.client.dtos.ClientDTO;
import br.com.project.client.models.Client;
import br.com.project.client.services.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Client findByIdClient(@PathVariable Long clientId) {
        return clientService.findByIdClient(clientId);
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = clientService.createClient(clientDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(String.format("/client/%d", client.getId())).buildAndExpand(client.getId()).toUri();
        
        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

}
