package ch01.Ex1_14;

public class Walkman {
	private Terminal terminal;
	public static void main(String[] args){
		Walkman wm = new Walkman();
		Terminal terminal = new Terminal();
		wm.setTerminal(terminal);
		wm.Play();
		System.out.println(wm.getTerminal());
	}
	public Terminal getTerminal(){
		return terminal;
	}
	public void setTerminal(Terminal a_terminal){
		terminal = a_terminal;
	}
	public void Play(){
		System.out.println("Playing music.");
	}
}
