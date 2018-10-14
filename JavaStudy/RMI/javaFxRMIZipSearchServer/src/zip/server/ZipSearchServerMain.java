package zip.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import zip.service.ZipSearchService;
import zip.service.ZipSearchServiceInf;

public class ZipSearchServerMain {
	public static void main(String[] args) {
		try {
			ZipSearchServiceInf zipService = new ZipSearchService();
			
			Registry reg = LocateRegistry.createRegistry(9988);
			reg.rebind("zipSearch", zipService);
			
			
		} catch (RemoteException e) {
			// TODO: handle exception
		}
	}
}
