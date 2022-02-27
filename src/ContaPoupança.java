
public class ContaPoupança extends DadosBanco {

	public ContaPoupança(DadosClientes cliente) {
		super(cliente);
	}
	public void dadosConta() {
		System.out.println("Conta Poupança");
		dadosCliente();
	}
}
