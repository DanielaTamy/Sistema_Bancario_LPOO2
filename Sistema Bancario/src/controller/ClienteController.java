package controller;

import java.util.List;
import model.Cliente;
import model.dao.ClienteDao;

public class ClienteController {
    private ClienteDao clienteDao;

    public ClienteController(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public void salvarCliente(Cliente cliente) throws Exception {
        clienteDao.add(cliente);
    }

    public List<Cliente> listarClientes() throws Exception {
        return clienteDao.getAll();
    }

    public void atualizarCliente(Cliente cliente) throws Exception {
        clienteDao.update(cliente);
    }

    public void excluirCliente(Cliente cliente) throws Exception {
        clienteDao.delete(cliente);
    }

    public List<Cliente> buscarPorNome(String nome) throws Exception {
        return clienteDao.getByNome(nome);
    }

    public List<Cliente> buscarPorSobrenome(String sobrenome) throws Exception {
        return clienteDao.getBySobrenome(sobrenome);
    }

    public Cliente buscarPorCpf(String cpf) throws Exception {
        return clienteDao.getByCpf(cpf);
    }

    public Cliente buscarPorRg(String rg) throws Exception {
        return clienteDao.getByRg(rg);
    }

    public Cliente buscarClientePorCpf(String cpf) throws Exception {
        return buscarPorCpf(cpf);
    }

    public Cliente buscarClientePorRg(String rg) throws Exception {
        return buscarPorRg(rg);
    }
}
