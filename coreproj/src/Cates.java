import java.io.Serializable;

class Cates implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3606813444592218054L;
	int height;
	int weight;
	Cates(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
}