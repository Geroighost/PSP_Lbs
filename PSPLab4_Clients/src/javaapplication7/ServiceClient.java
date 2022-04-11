/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package javaapplication7;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
public class ServiceClient implements Runnable {

    private Socket clientSocket;
    private BufferedReader in = null;

    public ServiceClient(Socket client) {
        this.clientSocket = client;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            String clientSelection;
            while ((clientSelection = in.readLine()) != null) {
                switch (clientSelection) {
                    case "1":
                        receiveFile();
                        continue;
                    case "2":
                        String outGoingFileName;
                        while ((outGoingFileName = in.readLine()) != null) {
                            sendFile(outGoingFileName);
                        }
			continue;
		    case "3":
			System.exit(1);	

                       break;
                    default:
                        System.out.println("Incorrect command received.");
                        break;
                }
               
            }

        } catch (IOException ex) {
          
        }
    }

    public void receiveFile() {
        String[] pathnames;
        File f = new File("C:/Users/Swan/Documents/NetBeansProjects/PSPLab4_Server");
            FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".jpg");
        }
    };
            pathnames = f.list(filter);
            for (String pathname : pathnames) {
            System.out.println(pathname);
        }
            FilenameFilter filter2 = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".png");
        }
    };
            pathnames = f.list(filter2);
            for (String pathname : pathnames) {
            System.out.println(pathname); 
            }
        try {
            int bytesRead;

            DataInputStream clientData = new DataInputStream(clientSocket.getInputStream());

            String fileName = clientData.readUTF();
            OutputStream output = new FileOutputStream(fileName);
            long size = clientData.readLong();
            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            clientData.close();

            System.out.println("File "+fileName+" received from client.");
        } catch (IOException ex) {
            System.err.println("Client error. Connection closed.");
        }
    }

    public void sendFile(String fileName) {
        String[] pathnames;
        File f = new File("C:/Users/Swan/Documents/NetBeansProjects/PSPLab4_Clients");
            FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".jpg");
        }
    };
            pathnames = f.list(filter);
            for (String pathname : pathnames) {
            System.out.println(pathname);
        }
            FilenameFilter filter2 = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".png");
        }
    };
            pathnames = f.list(filter2);
            for (String pathname : pathnames) {
            System.out.println(pathname); 
            }
        try {
           
            File myFile = new File(fileName);  //handle file reading
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);

           
            OutputStream os = clientSocket.getOutputStream();  //handle file send over socket

            DataOutputStream dos = new DataOutputStream(os); //Sending file name and file size to the server
            dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            System.out.println("File "+fileName+" sent to client.");
        } catch (Exception e) {
            System.err.println("File does not exist!");
        } 
    }
}