/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Servers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class RemoteCashing implements Cards {
    
   @Override
   public ArrayList<String> add_card(ArrayList<String> Cards, String name) throws RemoteException {
    Cards.add(name);
   //Balance.add((float) 0.0);
   return Cards;
    }

   @Override
   public ArrayList<Float> add_card_balance(ArrayList<String> Cards, String name, ArrayList<Float> Balance) throws RemoteException {
    int numb = Cards.indexOf(name);
    Balance.add(numb, (float) 0.0);
   return Balance;
    }

   
   @Override
   public ArrayList<Float> card_balance_add(ArrayList<String> Cards, String name, ArrayList<Float> Balance, float to_add) throws RemoteException {
    int numb = Cards.indexOf(name);
    float getted = Balance.get(numb);
    float result = getted + to_add;
    Balance.add(numb, result);
    return Balance;
  }
   
   @Override
   public ArrayList<Float> card_balance_minus(ArrayList<String> Cards, String name, ArrayList<Float> Balance, float to_minus) throws RemoteException {
    int numb = Cards.indexOf(name);
    float getted = Balance.get(numb);
    float result = getted - to_minus;
    Balance.add(numb, result);
    return Balance;
  }
   
   @Override
    public int card_view(ArrayList<String> Cards, String name) throws RemoteException {
    int numb = Cards.indexOf(name);
    return numb;
  }
}