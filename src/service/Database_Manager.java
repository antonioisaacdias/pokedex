package service;

import com.sun.jdi.connect.spi.Connection;

public class Database_Manager {
    public Connection connection;
    private String url;
    private String user;
    private String password;

    public Database_Manager(Connection connection, String url, String user, String password) {
        this.connection = connection;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void connect(){}
    public void disconnect(){}
}
