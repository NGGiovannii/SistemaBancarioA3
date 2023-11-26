package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		
		inicializaSistemaBancario(); // criando algumas contas e clientes fictícios
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua){
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			// Consultar por um cliente
			case 1:
				System.out.print("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);
				
				if(cliente != null)
					System.out.println(cliente.toString());
				else
					System.out.println("Cliente não encontrado!");
				
				pulalinha();
				break;

			// Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta não encontrado!");
				
				pulalinha();
				break;

			// Ativar um cliente
			case 3:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
				
				if(cliente2 != null){
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				}
				else
					System.out.println("Cliente não encontrado!");
			
				pulalinha();
				break;
				
			// Desativar um cliente
			case 4:
				
				System.out.print("Digite o ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
				
				if(cliente3 != null){
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				}
				else
					System.out.println("Cliente não encontrado!");
				
				pulalinha();
				break;
			
			// (Teste) Transferir valor de uma conta para outra
			case 5:

				System.out.println("Insira o ID do cliente que terá saldo transferido");
				int idCliente4 = sc.nextInt();
				ContaCorrente contatrans = gerContas.pesquisaConta(idCliente4);
				if(contatrans != null){
					System.out.println("Dados da conta selecionada: \n");
					System.out.println(contatrans.toString());
					System.out.println("Insira o Valor que será transferido");
					double valorTransf = sc.nextDouble();
					System.out.println("Insira o ID do cliente que irá receber a transferência");
					int idCliente5 = sc.nextInt();
					pulalinha();
					Boolean cliente4 = gerContas.transfereValor(idCliente4, valorTransf, idCliente5);
					//(Teste) checagem se a transferência foi bem sucedida
					if(cliente4 = true & cliente4 != false){
						System.out.println("Valor transferido!");
					}else 
					System.out.println("Houve um erro na transação");
					pulalinha();
					
				}
				else{
					System.out.println("Conta não encontrada!");
				}
				
				break;
			// Sair
			case 6:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
				
			} 
			
		}
		sc.close();
		
	}

	private static void pulalinha() {
		System.out.println("\n");
	}

	/**
	 * Imprime menu de opções do nosso sistema bancário
	 */
	private static void printMenu() {
		
		System.out.println("O que você deseja fazer? \n");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("3) Ativar um cliente");
		System.out.println("4) Desativar um cliente");
		System.out.println("5) Transferir valor de uma conta");
		System.out.println("6) Sair");
		System.out.println();
		
	}

	/**
	 * Método que cria e insere algumas contas e clientes no sistema do banco,
	 * apenas para realização de testes manuais através do método main acima.
	 */
	private static void inicializaSistemaBancario() {
		// criando lista vazia de contas e clientes
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();
		
		// criando e inserindo três contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		ContaCorrente conta03 = new ContaCorrente(3, 0, true);
		// (Teste) nova conta corrente sendo cadastrada com sucesso
		ContaCorrente conta04 = new ContaCorrente(4, 0, true);
		// (Teste) nova conta corrente com saldo de '100' sendo cadastrada com sucesso
		ContaCorrente conta05 = new ContaCorrente(5, 100, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		contasDoBanco.add(conta03);
		// (Teste) nova conta corrente sendo adiciona no sistema com sucesso
		contasDoBanco.add(conta04);
		// (Teste) nova conta corrente com saldo de '100' sendo adicionada no sistema com sucesso
		contasDoBanco.add(conta05);
		// criando três clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Pedro Silva", "111111-11", 18, "pedro@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(2, "Maria Lusardo", "222222-22", 25, "maria@gmail.com", conta02.getId(), true);
		Cliente cliente03 = new Cliente(3, "Carlos Cardoso","333333-33", 25, "carlos@gmail.com", conta03.getId(), true);
		// (Teste) novo cliente sendo cadastrado com sucesso
		Cliente cliente04 = new Cliente(4, "Lucas Gabriel", "444444-44", 19, "lucas@gmail.com", conta04.getId(), true);
		// (Teste) novo cliente com saldo '100' sendo cadastrado com sucesso
		Cliente cliente05 = new Cliente(5, "Marco Antonio", "555555-55", 19, "marco@gmail.com", conta05.getId(), true);
		// inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		// (Teste) novo cliente sendo adicionado no sistema com sucesso
		clientesDoBanco.add(cliente04);
		// (Teste) novo cliente com saldo de '100' sendo adicionado no sistema com sucesso
		clientesDoBanco.add(cliente05);
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
	
}

