package chapter6;

public enum BasicOperation implements Operation {
	ADD("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
		
	}, 
	SUBTRACT("-") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	};
	
	private String symbol;

	private BasicOperation(String symbol) {
		this.symbol = symbol;
	}
	
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test(BasicOperation.class, x, y);
	}
	private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}


	
}
