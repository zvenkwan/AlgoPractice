package oopdesign.callcenter;

import java.util.Date;

public class Call {

	private Caller caller;
	
	private Date callInTime;
	
	private Rank rank;
	
	private Employee handler;
	
	public Call(Caller caller) {
		this.caller = caller;
		this.rank = Rank.Respondent;
	}
	
	public Caller getCaller() {
		return caller;
	}

	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	public Date getCallInTime() {
		return callInTime;
	}

	public void setCallInTime(Date callInTime) {
		this.callInTime = callInTime;
	}

	public Employee getHandler() {
		return handler;
	}

	public void setHandler(Employee handler) {
		this.handler = handler;
	}

	public void reply(String message) {
		
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public void incrementRank() throws Exception {
		setRank(Rank.getRankByValue(rank.getValue() + 1));
	}
	
	public void disconnect() {
		
	}
	
}
