package zip.server;

import zip.service.ZipSearchService;
import zip.service.ZipSearchServiceInf;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ZipSearchServerMain {
    public static void main(String[] args) {
        try {
            ZipSearchServiceInf zipService = new ZipSearchService();
            Registry reg = LocateRegistry.createRegistry(9239);
            reg.rebind("zipSearch",zipService);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
