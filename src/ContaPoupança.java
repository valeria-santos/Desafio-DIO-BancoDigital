
public class ContaPoupanša extends DadosBanco {

	public ContaPoupanša(DadosClientes cliente) {
		super(cliente);
	}
	public void dadosConta() {
		System.out.println("Conta Poupanša");
		dadosCliente();
	}
}
