package ch06.Ex6_03;

public class Description implements Verbose{

	private Level verbosity = Level.NORMAL;
	
	public static void main(String[] args){
		Description ds = new Description();
		ds.setVerbosity(Level.TERSE);
		System.out.println(ds.getVerbosity());
	}
	@Override
	public void setVerbosity(Level level) {
		// TODO Auto-generated method stub
		verbosity = level;
	}

	@Override
	public Level getVerbosity() {
		// TODO Auto-generated method stub
		return verbosity;
	}

}
