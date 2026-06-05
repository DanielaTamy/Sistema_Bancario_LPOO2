package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaInvestimento;
import model.RepositorioDados;

// está usando o local
// quando for usar o banco de dados, tem que usar o Dao, e não o RepositorioDados
// aguardar task Laura

public class ContaController {
    private RepositorioDados repositorio;

    public ContaController() {
        this(RepositorioDados.getInstance());
    }

    public ContaController(RepositorioDados repositorio) {
        this.repositorio = repositorio;
    }

    public ContaCorrente criarContaCorrente(Cliente cliente, double depositoInicial, double limite) {
        int numero = repositorio.gerarProximoNumeroConta();
        ContaCorrente conta = new ContaCorrente(cliente, numero, depositoInicial, limite);
        cliente.setConta(conta);
        repositorio.adicionarContaCorrente(conta);
        return conta;
    }

    public ContaInvestimento criarContaInvestimento(Cliente cliente, double depositoInicial,
            double montanteMinimo, double depositoMinimo) {
        int numero = repositorio.gerarProximoNumeroConta();
        ContaInvestimento conta = new ContaInvestimento(
                cliente, numero, depositoInicial, montanteMinimo, depositoMinimo);
        cliente.setConta(conta);
        repositorio.adicionarContaInvestimento(conta);
        return conta;
    }

    public Conta buscarContaPorCpf(String cpf) {
        return repositorio.buscarContaPorCpf(cpf);
    }

    public List<Conta> listarContas() {
        List<Conta> contas = new ArrayList<>();
        contas.addAll(repositorio.getListaContasCorrente());
        contas.addAll(repositorio.getListaContasInvestimento());
        return contas;
    }
}
