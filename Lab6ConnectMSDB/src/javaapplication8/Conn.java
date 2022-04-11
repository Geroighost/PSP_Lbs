package javaapplication8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conn {
        public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

            Connection conn=null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:sqlserver://KIRDIM\\MSSQLSERVER13:1433;databaseName=Mebelmagaz", "sa", "Freddy");

                if(conn!=null)
                    System.out.println("Database Successfully connected");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

//Если возникает ошибка The server selected protocol version TLS10 is not accepted by client preferences [TLS12], то нужно редачить файл java.security по пути JAVA_HOME