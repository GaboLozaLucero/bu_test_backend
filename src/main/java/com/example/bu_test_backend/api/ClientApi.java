package com.example.bu_test_backend.api;

import com.example.bu_test_backend.bl.ClientBl;
import com.example.bu_test_backend.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/client")
public class ClientApi {
    private ClientBl clientBl;

    @Autowired
    public ClientApi(ClientBl clientBl){
        this.clientBl = clientBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDto> getAllClients(HttpServletRequest request) {
        return clientBl.findAllClients();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto, HttpServletRequest request) {
        ClientDto clientDtoResponse=clientBl.createClient(clientDto);
        return clientDtoResponse;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteClient(@PathVariable("id") String idClient, HttpServletRequest request){
        clientBl.deleteClient(idClient);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto updateClient(@Valid @RequestBody ClientDto clientDto, HttpServletRequest request) {
        ClientDto clientDtoResponse=clientBl.updateClient(clientDto);
        return clientDtoResponse;
    }
}
