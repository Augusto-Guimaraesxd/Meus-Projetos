package one.DigitalInovation.gof.service.impl;

import one.DigitalInovation.gof.model.Cliente;
import one.DigitalInovation.gof.model.Endereco;
import one.DigitalInovation.gof.model.ClienteRepositorio;
import one.DigitalInovation.gof.model.EnderecoRepository;
import one.DigitalInovation.gof.service.ClienteService;
import one.DigitalInovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Cliente> buscarTodos(){
        return clienteRepositorio.findAll();
    }
    @Override
    public Cliente buscarPorId(Long id){
       Optional<Cliente> cliente =clienteRepositorio.findById(id);
       return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        SalvarClienteComCep(cliente);
    }

    private void SalvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;

        });

        clienteRepositorio.save(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd =clienteRepositorio.findById(id);
        if (clienteBd.isPresent()){
            SalvarClienteComCep(cliente);

        }


    }

    @Override
    public void deletar(Long id) {
        clienteRepositorio.deleteById(id);

    }
}

