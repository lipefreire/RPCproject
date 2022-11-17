import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class RpcClient {
	public static void main(String[] args) throws MalformedURLException, XmlRpcException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://10.105.2.48:5000/xmlrpc"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		
		Object[] msg = new Object[]{"Felipe"};
		String message = (String) client.execute("XmlRpcService.getMensagem", msg);
		System.out.println("Mensagem: " + message);
		
		Object[] sum = new Object[] {2, 3};
		int result = (int) client.execute("XmlRpcService.getSoma", sum);
		System.out.println("Resultado da soma: " + result);
	}
}
