package chapter6;

public enum PayrollWithStrategyEnum {

	MONDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND);

	PayType payType;


/*    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }*/

	private enum PayType {
		WEEKDAY {
			double overtimePay(double hours, double payRate) {
				return hours <= HOURS_PER_SHIFT ? 0 :
					(hours - HOURS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			double overtimePay(double hours, double payRate) {
				return hours * payRate / 2;
			}
		};
		private static final int HOURS_PER_SHIFT = 8;
		abstract double overtimePay(double hrs, double payRate);

		double pay(double hoursWorked, double payRate) {
			double basePay = hoursWorked * payRate;
			return basePay + overtimePay(hoursWorked, payRate);
		}
	}

	PayrollWithStrategyEnum(PayType payType) {
		this.payType = payType;
	}


	public static void main(String a[]) {
		System.out.println(PayrollWithStrategyEnum.MONDAY.payType.pay(10, 20));
	}
}

