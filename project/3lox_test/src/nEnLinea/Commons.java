package nEnLinea;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Commons {
	public static DataSource getDS() throws Exception{
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/3lox");
		return ds;
	}
}
