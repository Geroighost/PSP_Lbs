/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Cards extends Remote {

   ArrayList<String> add_card(ArrayList<String> Cards, String name) throws RemoteException;
   ArrayList<Float> add_card_balance(ArrayList<String> Cards, String name, ArrayList<Float> Balance) throws RemoteException;
   ArrayList<Float> card_balance_add(ArrayList<String> Cards, String name, ArrayList<Float> Balance, float to_add) throws RemoteException;
   ArrayList<Float> card_balance_minus(ArrayList<String> Cards, String name, ArrayList<Float> Balance, float to_minus) throws RemoteException;
   int card_view(ArrayList<String> Cards, String name) throws RemoteException;
}