package controller;

import model.Conta;

public class OperacaoController {

    public boolean depositar(Conta conta, double valor) {
        return conta.deposita(valor);
    }

    public boolean sacar(Conta conta, double valor) {
        return conta.saca(valor);
    }

    public void remunerar(Conta conta) {
        conta.remunera();
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        origem.saca(valor);
        destino.deposita(valor);
    }
}
