import java.util.Locale;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static Integer lerOpcao() {
		Integer opcao = null;
		do {
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (Exception exc) {
				System.out.println("Opção inválida!!!");
			}
		} while (opcao == null);
		return opcao;
	}

	public static Double lerValor() {
		Double valor = null;
		do {
			try {
				valor = Double.parseDouble(sc.nextLine());
			} catch (Exception exc) {
				System.out.println("Opção inválida!!!");
			}
		} while (valor == null);
		return valor;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DadosClientes cliente = new DadosClientes();
		Integer opcao = 0;
		System.out.println("Seja bem vindo(a) ao *Start BANK*!");
		System.out.println("Informe seu nome: ");
		cliente.setNome(sc.nextLine());
		System.out.println("Informe seu CPF: ");
		cliente.setCpf(sc.nextLine());
		ContaCorrente cc = new ContaCorrente(cliente);
		ContaPoupança cp = new ContaPoupança(cliente);
		System.out.printf("\nConta criada com sucesso!\n\n");
		cc.dadosConta();
		cc.consultarSaldo();
		System.out.println();
		cp.dadosConta();
		cp.consultarSaldo();
		System.out.println();

		do {
			System.out.printf("O que deseja fazer?\n\n");
			System.out.printf("1-Depositar\n2-Transferir\n3-Sacar\n4-Consultar Saldo\n5-Fechar\n");
			opcao = lerOpcao();
			switch (opcao) {
			case 1:
				System.out.printf("Em qual conta deseja depositar?\n\n");
				System.out.printf("1-Corrente\n2-Poupança\n");
				int opcaoConta = lerOpcao();
				System.out.printf("Qual o valor?\n\n");
				if (opcaoConta == 1) {
					if(cc.depositar(lerValor()))System.out.println("\nDepósito realizado com sucesso!\n");
					else System.out.println("\nOperação não concluída!\n");;
				} else if (opcaoConta == 2) {
					
					if(cp.depositar(lerValor()))System.out.println("\nDepósito realizado com sucesso!\n");
					else System.out.println("\nOperação não concluída!\n");;
				}
				break;
			case 2:
				System.out.printf("De qual conta deseja transferir?\n\n");
				System.out.printf("1-Corrente\n2-Poupança\n");
				opcaoConta = lerOpcao();
				System.out.printf("Qual o valor?\n\n");
				if (opcaoConta == 1) {
					cc.transferir(lerValor(), cp);
					System.out.println("\nTransferência realizada com sucesso!\n");
				} else if (opcaoConta == 2) {
					cp.transferir(lerValor(), cc);
					System.out.println("\nTransferência realizado com sucesso!\n");
				}
				break;
			case 3:
				System.out.printf("De qual conta deseja sacar?\n\n");
				System.out.printf("1-Corrente\n2-Poupança\n");
				opcaoConta = lerOpcao();
				System.out.printf("Qual o valor?\n\n");
				if (opcaoConta == 1) {
					if(cc.sacar(lerValor()))System.out.println("\nSaque realizado com sucesso!\n");
					else System.out.println("\nOperação não concluída!\n");;
				} else if (opcaoConta == 2) {
					if(cp.sacar(lerValor()))System.out.println("\nSaque realizado com sucesso!\n");
					else System.out.println("\nOperação não concluída!\n");;
				}

				break;
			case 4:
				System.out.printf("De qual conta deseja consultar o saldo?\n\n");
				System.out.printf("1-Corrente\n2-Poupança\n");
				opcaoConta = lerOpcao();
				System.out.printf("Qual o valor?\n\n");
				if (opcaoConta == 1){
					cc.consultarSaldo();
				} else if (opcaoConta == 2) {
					cp.consultarSaldo();
				}

				break;
			case 5:
				break;
			default:
				System.out.printf("Opção inválida!!!\n\n");
				break;
			}
		} while (opcao != 5);

		sc.close();
	}

}
