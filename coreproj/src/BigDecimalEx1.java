import java.math.BigDecimal;

public class BigDecimalEx1 {
	public static void main(String[] args) {
		BigDecimalEx1 obj = new BigDecimalEx1();
		obj.isValidRebillAmount(new BigDecimal(-10.00), 10.00);
	}
	/**
     * Fail if: 
     * (a) values are different signs,
     * (b) values are positive and the allocated amount is greater than line,
     * (c) values are negative and allocated amount is less than line.
     * @param amountToVerify Allocated amount total
     * @param lineAmount  Line amount to verify
     * @param message  Fail message is added to buffer on failure
     * @param amountType Description of type being verified for the message
     * @return  True if the amount is valid, False otherwise
     */
    private static boolean isValidRebillAmount ( BigDecimal  amountToVerify, Double lineAmount)
    {
        boolean isValid = true;
        BigDecimal zeroBD = new BigDecimal("0.0");

        BigDecimal lineAmountBD = new BigDecimal(lineAmount.toString());
        int verifyAmountZeroCompare = amountToVerify.compareTo(zeroBD) ;
        int lineAmountZeroCompare = lineAmountBD.compareTo(zeroBD) ;
        System.out.println("verifyAmountZeroCompare   :"+verifyAmountZeroCompare);
        System.out.println("lineAmountZeroCompare   :"+lineAmountZeroCompare);
        String newMessage = null;

        // First we see if the values are different
        int diff =  amountToVerify.compareTo(lineAmountBD);
        System.out.println("amounts are different or not   :"+diff);
        if (diff != 0)
        {
             // We know they are different value, if they are different signs, for example, one negative and one positive, then
             // that is a bad case.
            if  ( (verifyAmountZeroCompare < 0)  && (lineAmountZeroCompare > 0))     // sum is pos, line is neg
            {
                isValid = false;
                newMessage = "amountToVerify is negative and line item value is positive";
                System.out.println(newMessage);
            }
            else if ( (verifyAmountZeroCompare > 0)  && (lineAmountZeroCompare < 0))     // sum is pos, line is neg
            {
                isValid = false;
                newMessage = "amountToVerify is positive and line item value is negative";
            }
            else
            {
                 // We know the values are the both the same sign, so compare them appropriately.
                if (lineAmountZeroCompare > 0)    // Values are positive...fail if allocated amount exceeds
                {
                    if (amountToVerify.compareTo(lineAmountBD) > 0)
                    {
                        isValid = false;
                        newMessage = "allocated amounts exceed line item value";
                    }
                }
                else if (amountToVerify.compareTo(lineAmountBD) < 0)     // Values are negative, fail if allocatd is less
                {
                    isValid = false;
                    newMessage = "allocated amounts exceed line item value";

                }
            }

            // If it is not valid, add to the message with problem.
//            if (!isValid)
//            {
//                if (!firstError)
//                {
//                    message.append("; ");
//                }
//                firstError = false;
//                message.append("For ");
//                message.append(amountType);
//                message.append(", ");
//                message.append(newMessage);
//            }
        }
        return isValid;
    }
}

