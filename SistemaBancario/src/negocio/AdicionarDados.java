package negocio;

import java.util.ArrayList;
import java.util.List;

public class AdicionarDados {
    
    static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;

    private static void inicializaSistemaBancario() {
		// criando lista vazia de contas e clientes
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();
		
		// criando e inserindo três contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		ContaCorrente conta03 = new ContaCorrente(3, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		contasDoBanco.add(conta03);
		
		// criando três clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Pedro Silva", "111111-11", 18, "pedro@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Maria Lusardo", "222222-22", 25, "maria@gmail.com", conta02.getId(), true);
		Cliente cliente03 = new Cliente(3, "Carlos Cardoso","333333-33", 25, "carlos@gmail.com", conta03.getId(), true);

		// inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
}
