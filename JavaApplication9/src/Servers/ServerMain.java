/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Servers;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {

   public static final String UNIQUE_BINDING_NAME = "server.cash_desk";

   public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

       final RemoteCashing server = new RemoteCashing();
       final Registry registry = LocateRegistry.createRegistry(2732);
       Remote stub = UnicastRemoteObject.exportObject(server, 0);
       registry.bind(UNIQUE_BINDING_NAME, stub);
       System.out.println("Сервер запущен.");
       Thread.sleep(Integer.MAX_VALUE);

   }
}