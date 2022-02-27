
public class DadosBanco {
	private static final int AGENCIA = 350;
	private static int SEQUENCIAL = 000501;
	private String nome = " *Start BANK* ";
	private int agencia;
	private int conta;
	protected double saldo = 0.00;
	private DadosClientes cliente;
	protected double saldoAnterior = 0.00;
	
	public DadosBanco(DadosClientes cliente) {
		this.agencia = AGENCIA;
		this.conta = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAgencia() {
		return agencia;
	}
	public int getConta() {
		return conta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void consultarSaldo() {
		System.out.println("Saldo atual: " + this.saldo);
	}
	public boolean depositar(double valor){
		saldoAnterior = saldo;
		saldo += valor;
		if(saldo == saldoAnterior + valor) return true;
		return false;
	}
	public boolean sacar(double valor) {
		saldoAnterior = saldo;
		saldo -= valor;
		if(saldo == saldoAnterior - valor) return true;
		return false;
	}
	public void transferir(double valor, DadosBanco contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	public void dadosCliente() {
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println(nome);
		System.out.println("Agência: " + agencia);
		System.out.println("Conta: " + conta);
	}
}
