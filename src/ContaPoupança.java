
public class ContaPoupan�a extends DadosBanco {

	public ContaPoupan�a(DadosClientes cliente) {
		super(cliente);
	}
	public void dadosConta() {
		System.out.println("Conta Poupan�a");
		dadosCliente();
	}
}
