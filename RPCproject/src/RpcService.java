
public class RpcService {
	public synchronized int getSoma(int num1, int num2) {
		return soma(num1, num2);
	}
	
	public synchronized String getMensagem(String msg) {
		return mensagem(msg);
	}
	
	private static synchronized int soma(int n1, int n2) {
		int resultado = n1 + n2;
		return resultado;
	}
	
	private static synchronized String mensagem(String msg) {
		return "Olá, " + msg + "! Fico feliz em vê-lo aqui!";
	}
}
