package threeLox;

import java.sql.SQLException;

import javax.sql.DataSource;

import nEnLinea.Commons;

import org.apache.commons.dbutils.QueryRunner;

import Model.GameModel;



public class GameDao {
	
	private DataSource ds;
	private QueryRunner qr;
	private static GameDao dao;
	private final String sqlInsert = "INSERT INTO 3lox.games\n"+
			"(player_1_name, player_2_name, winner)\n"+
			"VALUES(?,?,?,?,?)";
	
	public GameDao() throws Exception{
		ds = Commons.getDS();
		qr = new QueryRunner(ds);
	}
	
	public static GameDao getInstance() throws Exception{
		if(dao == null){
			dao = new GameDao();
		}
		return dao;
	}
	public int insertDB(GameModel gameModel) throws SQLException{
		int result = 0;
		Object[] params = {gameModel.getPlayer1Name(), gameModel.getPlayer2Name()};
		qr.update(sqlInsert,params);
		return result;
	}

	

}
