package com.example.bu_test_backend.bl;

import com.example.bu_test_backend.dao.ClientDao;
import com.example.bu_test_backend.dto.ClientDto;
import com.example.bu_test_backend.model.Client;
import com.example.bu_test_backend.model.Doc;
import com.example.bu_test_backend.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientBl {

    private ClientDao clientDao;

    @Autowired
    public ClientBl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientDto createClient(ClientDto clientDto) {
        Client client = mapToClient(clientDto);
        client = clientDao.save(client);
        return mapToClientDto(client);
    }

    public List<ClientDto> findAllClients() {
        List<Client> clients = clientDao.findAll();
        return clients.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }

    public ClientDto findClientById(String clientId) {
        Optional<Client> clientOpt = clientDao.findById(clientId);
        return clientOpt.map(this::mapToClientDto).orElse(null);
    }

    public ClientDto updateClient(ClientDto clientDto) {
        Client client = mapToClient(clientDto);
        clientDao.save(client);
        return clientDto;
    }

    public void deleteClient(String clientId) {
        clientDao.deleteById(clientId);
    }

    private Client mapToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setClientId(clientDto.getClientId());
        client.setClientName(clientDto.getClientName());
        client.setClientFirstLastname(clientDto.getClientFirstLastname());
        client.setClientSecondLastname(clientDto.getClientSecondLastname());

        Doc doc = new Doc();
        doc.setDocId(clientDto.getDocId());
        doc.setDoc_name(clientDto.getDocName());
        client.setDoc(doc);

        client.setBirthDate(clientDto.getBirthDate());

        Gender gender = new Gender();
        gender.setGenderId(clientDto.getGenderId());
        gender.setGenderName(clientDto.getGenderName());
        client.setGender(gender);

        return client;
    }

    private ClientDto mapToClientDto(Client client) {
        // Method 1 to create clientDto Object
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setClientName(client.getClientName());
        clientDto.setClientFirstLastname(client.getClientFirstLastname());
        clientDto.setClientSecondLastname(client.getClientSecondLastname());
        clientDto.setDocId(client.getDoc().getDocId());
        clientDto.setDocName(client.getDoc().getDoc_name());
        clientDto.setBirthDate(client.getBirthDate());
        clientDto.setGenderId(client.getGender().getGenderId());
        clientDto.setGenderName(client.getGender().getGenderName());
        return clientDto;
    }
}
