package oopdesign.callcenter;

import java.util.List;

public class CallHandler {

	private static CallHandler instance;
	
	private final int LEVELS = 3;
	private final int NUM_RESPONDENT = 10;
	private final int NUM_MANAGER = 4;
	private final int NUM_DIRECTOR = 2;
	
	List<List<Employee>> employeeLevels;
	
	List<List<Call>> callQueues;
	
	protected CallHandler() {
		
	}
	
	public static CallHandler getInstance() {
		if(instance == null) instance = new CallHandler();
		return instance;
	}

	public Employee getHandlerForCall(Call call) {
		return null;
	}
	
	public void dispatch(Caller caller) {
		Call call = new Call(caller);
		dispatch(call);
	}
	
	public void dispatch(Call call) {
		Employee emp = getHandlerForCall(call);
		
		if(emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		}
		else {
			call.reply("wait");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	
	public boolean assignCall(Employee emp) {
		return false;
	}
}
