package one.digital.lab_padroes_projeto_spring.service.impl;

import one.digital.lab_padroes_projeto_spring.model.Cliente;
import one.digital.lab_padroes_projeto_spring.model.ClienteRepository;
import one.digital.lab_padroes_projeto_spring.model.Endereco;
import one.digital.lab_padroes_projeto_spring.model.EnderecoRepository;
import one.digital.lab_padroes_projeto_spring.service.ClienteService;
import one.digital.lab_padroes_projeto_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}. Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>
 *
 */

@Service
public class ClienteServiceImpl implements ClienteService {
    // TODO Singleton: Injetar os componentes do Srping com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // TODO Strategy: Imnplementar os métodos definidos na interface.
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isEmpty()) {
            // Você também pode criar uma classe de exceção própria como 'ResourceNotFoundException'
            throw new RuntimeException("Cliente com ID " + id + " não encontrado.");
        }
        return cliente.get();
    }


    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        //FIXME Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }


    @Override
    public void deletar(Long id) {
        //FIXME Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }


    private void salvarClienteComCep(Cliente cliente) {
        // FIXME Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // FIXME Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }
}
