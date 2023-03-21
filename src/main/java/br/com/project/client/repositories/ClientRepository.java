package br.com.project.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.client.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
