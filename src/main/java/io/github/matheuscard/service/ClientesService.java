package io.github.matheuscard.service;

import io.github.matheuscard.model.Cliente;
import io.github.matheuscard.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    ClientesRepository repository;

    @Autowired //(Em versoes atuais do SpringBoot), neste caso onde
    //classe contem a anotacao @Service, essa anotacao e desnecessaria,
    //pois o IOC ja entende que esta classse precisa ser injetada.
    public void ClientesRepository(ClientesRepository repository){
        this.repository = repository;
    }
    //    Segunda forma de injetar uma dependencia de acesso a dados
//    @Autowired
//    public void setRepository(ClientesRepository repository){
//        this.repository=repository;
//    }
    public void salvarCliente(Cliente cliente){

        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
