class Shape implements Cloneable {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public final class Rect extends Shape {
	private int width;
	private int height;

	public Rect(int w, int h) {
		width = w;
		height = h;
		System.out.println("parameterized constructor called()");
	}
	
	public Rect() {
		System.out.println("default constructor called()");
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int area() {
		return width * height;
	}

	@Override
	public String toString() {
		return String.format("Rectangle [width: %d, height: %d, area: %d]",
				width, height, area());
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
