/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clients;

import Servers.Cards;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import static Clients.Cards_elements.Cards;
import static Clients.Cards_elements.balance;

public class ClientMain {

   public static final String UNIQUE_BINDING_NAME = "server.cash_desk";

   public static void main(String[] args) throws RemoteException, NotBoundException {

       final Registry registry = LocateRegistry.getRegistry(2732);

       Cards cards = (Cards) registry.lookup(UNIQUE_BINDING_NAME);

       boolean for_while = true;
       Scanner in = new Scanner(System.in);
       while (for_while == true) {
           System.out.println("Выберите пункт меню:\n1. Добавить карту\n2. Проверить баланс карты\n3. Добавить деньги на карту\n4. Снять деньги с карты\n5. Закрыть клиент\n> ");
           int num = in.nextInt();
           in.nextLine();
           switch (num) {
               case 1: {
               System.out.println("Введите номер карты:\n> ");
               String txt = in.nextLine();
               Cards = cards.add_card(Cards, txt);
               balance = cards.add_card_balance(Cards, txt, balance);
               System.out.println("Карта добавлена.");
               break;
           }
               case 2: {
               System.out.println("Введите номер карты:\n> ");
               String txt = in.nextLine();
               int number = cards.card_view(Cards, txt);
               float getted = balance.get(number);
               String txt2 = Float.toString(getted);
               System.out.println("Номер карты: " + txt + "; Баланс: " + txt2);
               break;
               }
               case 3: {
               System.out.println("Введите номер карты:\n> ");
               String txt = in.nextLine();
               System.out.println("Введите количество денег для зачисления:\n> ");
               float number = in.nextFloat();
               balance = cards.card_balance_add(Cards, txt, balance, number);
               System.out.println("Баланс изменён.");
               in.nextLine();
               break;
               }
               case 4: {
               System.out.println("Введите номер карты:\n> ");
               String txt = in.nextLine();
               System.out.println("Введите количество денег для снятия:\n> ");
               float number = in.nextFloat();
               balance = cards.card_balance_add(Cards, txt, balance, number);
               System.out.println("Баланс изменён.");
               break;
               }
               case 5: for_while = false;
               break;
           }
       }
   }
}
