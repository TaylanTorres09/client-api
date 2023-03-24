package br.com.project.client.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.project.client.dtos.ClientDTO;
import br.com.project.client.models.Client;
import br.com.project.client.repositories.ClientRepository;
import br.com.project.client.services.exceptions.ObjectNotFound;

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

    @Test
    void whenFindByIDThenReturnAClient() {
        when(clientRepository.findById(anyLong())).thenReturn(optional);

        Client response = clientService.findByIdClient(ID);

        assertNotNull(response);
        assertEquals(Client.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(name, response.getName());
        assertEquals(age, response.getAge());
        assertEquals(city, response.getCity());
    }

    @Test
    void whenFindByIDThenReturnAnObjectNotFoundException() {
        when(clientRepository.findById(anyLong())).thenThrow(new ObjectNotFound("Client not found"));

        try {
            clientService.findByIdClient(ID);
        } catch (Exception e) {
            assertEquals(ObjectNotFound.class, e.getClass());
            assertEquals("Client not found", e.getMessage());
        }

    }

    @Test
    void whenCreateThenReturnClient() {
        when(clientRepository.save(any())).thenReturn(client);

        Client response = clientService.createClient(clientDTO);

        assertNotNull(response);
        assertEquals(Client.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(name, response.getName());
        assertEquals(age, response.getAge());
        assertEquals(city, response.getCity());
    }

    @Test
    void whenFindAllThenReturnAListOfClients() {
        when(clientRepository.findAll()).thenReturn(List.of(client));

        List<Client> response = clientService.findAllClients();

        assertNotNull(response);
        assertEquals(1, response.size());

        Client clientResponse = response.get(0);
        assertEquals(Client.class, clientResponse.getClass());
        assertEquals(ID, clientResponse.getId());
        assertEquals(name, clientResponse.getName());
        assertEquals(age, clientResponse.getAge());
        assertEquals(city, clientResponse.getCity());
    }

    @Test
    void whenUpdateThenReturnClient() {
        when(clientRepository.findById(anyLong())).thenReturn(optional);
        when(clientRepository.save(any())).thenReturn(client);

        Client response = clientService.updateClient(ID, clientDTO);

        assertNotNull(response);
        assertEquals(Client.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(name, response.getName());
        assertEquals(age, response.getAge());
        assertEquals(city, response.getCity());
    }

    public void start() {
        client = new Client(ID, name, age, city);
        clientDTO = new ClientDTO(name, age, city);
        optional = Optional.of(new Client(ID, name, age, city));
    }

}
