package nEnLinea;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.zul.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import threeLox.GameDao;
import Model.GameModel;

public class IndexController extends BaseController{
	
	private Textbox namePlayer1;
	private Textbox namePlayer2;
	private Intbox numbSqrts;
	private Div board;
	private Div player1Info;
	private Div player2Info;
	private ArrayList<String> player1Moves = new ArrayList();
	private ArrayList<String> player2Moves = new ArrayList();
	private boolean playerOnePlay = true;
	
	
	private String colorPlayer1 = "blue";
	private String colorPlayer2 = "red";
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
	}

	public void onClick$formButton(){
		if(namePlayer1.getValue().length()>1 && namePlayer2.getValue().length()>1 && numbSqrts.getValue() >1 && numbSqrts.getValue()<100){
			String name1 = namePlayer1.getValue();
			String name2 = namePlayer2.getValue();
			int n = numbSqrts.getValue();

			saveGame();
			
			Label lbl;
			lbl = new Label();
			lbl.setValue(name1);
			lbl.setSclass("name-style ns1");
			lbl.setParent(player1Info);
			
			Label lbl2;
			lbl2 = new Label();
			lbl2.setValue(name2);
			lbl2.setSclass("name-style ns2");
			lbl2.setParent(player2Info);
			
			int j=1;
			int k =1;
			int percent = (int)(100/n);
			String styleBoard = "";
			for(int i=1; i<=n*n; i++){
				j = (int) Math.ceil((float)i/(float)n);
				k = i-n*(j-1);
				System.out.println("r"+k+"-"+"c"+j);
				if(i<=n){
					styleBoard += " "+percent+"%";
				}

				Div item;
				item = new Div();
				item.setClass("square-board");
				item.setId("r"+k+"-"+"c"+j);
				item.setParent(board);
				/*Button button;
				button = new Button();
				button.setClass("square-board-button");
				button.setId("r"+k+"-"+"c"+j);
				button.setParent(item);
				*/
				item.addEventListener("onClick", new EventListener(){
					@Override
					public void onEvent(Event arg0) throws Exception {
						if(playerOnePlay){
							player1Moves.add(item.getId());
							playerOnePlay =false;
							Textbox lbl = new Textbox();
							lbl.setText("x");
							lbl.setSclass("chooseBlue choose");
							lbl.setParent(item);
							if(testWinner(player1Moves)){
								Messagebox.show("The winner is "+namePlayer1.getValue());
							}
						}else{
							player2Moves.add(item.getId());
							playerOnePlay = true;
							Textbox lbl = new Textbox();
							lbl.setValue("o");
							lbl.setSclass("chooseRed choose");
							lbl.setParent(item);
							if(testWinner(player2Moves)){
								Messagebox.show("The winner is "+namePlayer2.getValue());
							}
						}
					}
							
				});
			}
			
			board.setStyle("grid-template-columns:"+styleBoard+"; "+"grid-template-rows:"+styleBoard+";");

			
		}else{
			alert("parametros invalidos,\n"
					+ "los nombre de los jugadores deben tener al menos 2 letras\n"
					+" El n?mero de casillas debe ser mayor a uno y menor a 100 ");
		}
		
	}
	public boolean testWinner(ArrayList<String> arr){
		int isWinnerByRows;
		int isWinnerByColumns;
		int isWinnerFirstDiagonal = 0;
		int isWinnerSecondDiagonal = 0;
		boolean isWinner=false;
		int n = numbSqrts.getValue();
		for(int j=1; j<=n; j++){
			isWinnerByRows = 0;
			isWinnerByColumns = 0;
			for(int i =1; i<=n; i++){
				if(arr.contains("r"+i+"-"+"c"+j)){ 
					isWinnerByRows +=1;
				}
				if(arr.contains("r"+j+"-"+"c"+i)){
					isWinnerByColumns +=1;
				}
				if(i==j && arr.contains("r"+j+"-"+"c"+i)){
					isWinnerFirstDiagonal +=1;
				}
				if(arr.contains("r"+j+"-"+"c"+i)&& i+j == n+1){
					isWinnerSecondDiagonal += 1;
				}
			}
			isWinner = isWinnerByRows == n || isWinnerByColumns == n || isWinnerFirstDiagonal == n || isWinnerSecondDiagonal == n;
			if(isWinner){
				break;
			}
		}
		return isWinner;
	}
	
	public void saveGame(){
		GameModel model  = new GameModel(namePlayer1.getValue(),namePlayer2.getValue());
		
		int result = 0;
		try {
			result = GameDao.getInstance().insertDB(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result == 0){
			System.out.println("Error");
		}else{
			System.out.println("Juego guardado");
		}
		
	}

}
	


