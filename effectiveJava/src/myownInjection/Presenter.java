package myownInjection;
public class Presenter {
	
	@PleaseInject
	private Boundary boundary;

	@Override
	public String toString() {
		return "Presenter [boundary=" + boundary + "]";
	}
	
}
