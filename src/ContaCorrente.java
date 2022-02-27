
public class ContaCorrente extends DadosBanco{

	public ContaCorrente(DadosClientes cliente) {
		super(cliente);
	}
	public void dadosConta() {
		System.out.println("Conta Corrente");
		dadosCliente();
	}

}
