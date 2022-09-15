
public class Counter {
	private boolean status = true;
	private boolean serving = false;
	private String currNum;
	
	public boolean online() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean isServing() {
		return serving;
	}
	
	public void setServing(boolean mode) {
		this.serving = mode;
	}
	
	public String getCurrNum() {
		return currNum;
	}
	
	public void setCurrNum(String num) {
		this.currNum = num;
	}
}
