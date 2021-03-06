package br.com.unialfa.ecomerce.cliente.service;

import br.com.unialfa.ecomerce.cliente.domain.Cliente;

import br.com.unialfa.ecomerce.cliente.repository.ClienteRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepositry clienteRepositry;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cliente> listCliente(){
        return clienteRepositry.findAll();
    }

    @GetMapping(path= "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Cliente> showCliente(@PathVariable long id){
        return clienteRepositry.findById(id);
    }
    @PostMapping(path = "/")
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteRepositry.save(cliente);
    }
    @PutMapping(path = "/edit")
    public void editCliente(@RequestBody Cliente cliente){
        clienteRepositry.save(cliente);
    }
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody void deleteCliente(@PathVariable(name= "id")long id){
        clienteRepositry.deleteById(id);
    }

}
