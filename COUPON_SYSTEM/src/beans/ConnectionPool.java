package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionPool {

	static ConnectionPool pool;
	ArrayList<Connection> connection = new ArrayList<Connection>(5);
	Connection element;
	
	private ConnectionPool() {
		for (int i = 0; i < connection.size(); i++) {
			connection.add(i, element);
			
		}
	}

	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	// TODO need to throw exception
	public Connection getConnection() {
		if (connection.isEmpty() == false) {
			for (int i = 0; i < connection.size(); i++) {
				if (connection.get(i) != null) {
					Connection connect=connection.get(i);
					connection.remove(i);
					return connection.get(i);
				}
			}
		}
		return null;

	}

	public void returnConnection(Connection connection) throws SQLException {
		connection.close();
		this.connection.add(connection);
	}
	
	public void closeAllConnections(){
		this.connection.clear();
	}

}
