package oopdesign.callcenter;

public abstract class Employee {

	private Call call;
	
	protected Rank rank;
	
	public Employee() {}
	
	public void receiveCall(Call call) {
		this.call = call;
	}
	
	public Call getCall() {
		return call;
	}

	public void setCall(Call call) {
		this.call = call;
	}

	public void callComplete() {
		if(this.call != null) {
			this.call = null;
			this.call.disconnect();
		}
	}
	
	public void escalateAndReassign() {
		
	}
	
//	public boolean assignNewCall() {
//		
//	}
	
	public boolean isFree() {
		return call == null;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public static void main(String[] args) {
		Employee e1 = new Respondent();
		Employee e2 = new Respondent();
		System.out.println(e1.rank == e2.rank);
	}
}
