package br.com.project.client.services;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.project.client.dtos.ClientDTO;
import br.com.project.client.models.Client;
import br.com.project.client.repositories.ClientRepository;

public class ClientServiceTest {

    private static final Long ID = Long.valueOf(1);
    
    private static final String name = "Donatello";
    
    private static final Integer age = 18;
    
    private static final String city = "New York";

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private Client client = new Client();
    private ClientDTO clientDTO = new ClientDTO();
    private Optional<Client> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        start();
    }

    public void start() {
        client = new Client(ID, name, age, city);
        clientDTO = new ClientDTO(name, age, city);
        optional = Optional.of(new Client(ID, name, age, city));
    }

}
