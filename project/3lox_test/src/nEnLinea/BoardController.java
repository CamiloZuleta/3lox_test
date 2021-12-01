package nEnLinea;

import org.zkoss.zk.ui.Component;

public class BoardController extends BaseController{
	
	private String firstPlayer;
	private int n;
	private String secondPlayer;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
	}
	
	public String getFirstPlayer() {
		return firstPlayer;
	}
	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public String getSecondPlayer() {
		return secondPlayer;
	}
	public void setSecondPlayer(String secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
	
}
