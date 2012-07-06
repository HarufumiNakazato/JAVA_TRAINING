package ch05.Ex5_02;

public class BankAccount {
	private long number;
	private long balance;
	//private Action lastAct;
	private History historyList;
	
	public BankAccount(long num){
		number = num;
		historyList = new History();
	}
	
	public static void main(String[] args){
		BankAccount ba = new BankAccount(123);
		BankAccount tba = new BankAccount(456);
		ba.deposit(20000);
		ba.withdraw(5000);
		ba.transfer(tba, 2000);
		ba.deposit(50000);
		ba.historyList.show();
		
		System.out.println("");
		ba.deposit(10000);
		ba.withdraw(30000);
		ba.transfer(tba, 6000);
		ba.transfer(tba, 15000);
		ba.deposit(5000);
			
		ba.historyList.show();
	}
	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + ": " + act + " " + amount;
		}
	}
	
	public class History{
		private int nextActionIndex = 0;
		
		private Action[] actions = new Action[10];
		
		public Action next(){
			if(nextActionIndex <= actions.length-1)
				return actions[nextActionIndex];
			else
				return null;
		}
		
		public void add(Action value){
			if(nextActionIndex <= actions.length-1){
				actions[nextActionIndex] = value;
				nextActionIndex++;
			}else{
				//æ“ª‚ðˆê‚ÂÁ‚µ‚ÄA––”ö‚É’Ç‰Á
				Action[] newActions = new Action[10];
				for(int i = 0;i < newActions.length; i++){
					if(i == newActions.length-1)
						newActions[i] = value;
					else
						newActions[i] = actions[i+1];
				}
				actions = newActions;
			}
		}
		
		public void show(){
			for(int i = 0; i < actions.length; i++)
			{
				if(actions[i] != null)
					System.out.println("action[" + i + "] >> " + actions[i].toString());
			}
			
		}
	}
	
	public History history(){
		return historyList;
	}
	public void deposit(long amount){
		balance += amount;
		this.historyList.add(new Action("deposit", amount));
	}
	public void withdraw(long amount){
		balance -= amount;
		this.historyList.add(new Action("withdraw",amount));
	}
	
	public void transfer(BankAccount other, long amount){
		other.withdraw(amount);
		deposit(amount);
		this.historyList.add(new Action("transfer",amount));
		other.historyList.add(other.new Action("transfer",amount));
	}
	
	public long getBalance(){
		return balance;
	}
}
