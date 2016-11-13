package chapter6;

public enum ConstantSpecMethodImplEnum {
	
	PLUS("+") {
		@Override
		double apply(double x, double y) {
			return x + y;
		}
	},
	
	MINUS("-") {
		@Override
		double apply(double x, double y) {
			return x - y;
		}
	},
	
	TIMES("*") {
		@Override
		double apply(double x, double y) {
			return x * y;
		}
	};
	
	private String symbol;
	private ConstantSpecMethodImplEnum(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return symbol;
	}
	
	abstract double apply(double x, double y);
	
	public static void main(String[] args) {
		//double addition = ConstantSpecMethodImplEnum.PLUS.apply(4, 5);
		double x = 4;
		double y = 5;
		for (ConstantSpecMethodImplEnum operation : ConstantSpecMethodImplEnum.values()) {
			 System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
                     
		}
		test(BasicOperation.class, x, y);
	}
	
	private static void test(Class<BasicOperation> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
	}
}
