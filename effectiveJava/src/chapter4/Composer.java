package chapter4;

interface Singer {
	void sing(String s);
}

interface Songwriter {
	String compose(boolean hit);
}

public interface Composer extends Singer,Songwriter {

	
	
}