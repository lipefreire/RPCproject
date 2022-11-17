import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class RpcServer {
	public static void main(String[] args) throws XmlRpcException, IOException {
		int port = 4650;
		
		WebServer webServer = new WebServer(port);
		XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
		
		PropertyHandlerMapping phm = new PropertyHandlerMapping();
		phm.addHandler("XmlRpcService", RpcService.class);
		
		xmlRpcServer.setHandlerMapping(phm);
		XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
		
		serverConfig.setEnabledForExceptions(true);
		serverConfig.setContentLengthOptional(false);
		webServer.start();
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Servidor iniciado no endereço: 127.0.0.1:" + port + "/xmlrpc");
		System.out.println("Para encerrar, pressione CTRL + C");
		System.out.println("----------------------------------------------------------------");
	}
}
