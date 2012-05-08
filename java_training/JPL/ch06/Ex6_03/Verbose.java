package ch06.Ex6_03;

public interface Verbose {
	public enum Level{
		SILENT, TERSE, NORMAL, VERBOSE
	}
	
	void setVerbosity(Level level);
	Level getVerbosity();
}
