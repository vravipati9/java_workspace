package amplex;

import java.math.BigInteger;
import java.util.Arrays;

public class GetBCC {

	public static void main(String[] args) {
		String sTemp = ".W2.C003(141223112123).";
		byte b = getBCC(sTemp);
		
		final BigInteger bi = BigInteger.valueOf(126);
		final byte[] bytes = bi.toByteArray();

		System.out.println(Arrays.toString(bytes));
	}
	static  private byte getBCC(String sTemp)
	{
		byte BCC = 0x00;
		byte[] bytes = sTemp.getBytes();
		boolean SOHorSTX = true;
		for (int i = 0; i < bytes.length; i++)
		{
			if (SOHorSTX)
			{
				if (bytes[i] == (byte)SEGMENT_PART.SOH.value || bytes[i] == (byte)SEGMENT_PART.STX.value)
				{
					SOHorSTX = false;
					continue;
				}
			}
			BCC = (byte)((int)BCC ^ (int)bytes[i]);
			System.out.println(BCC);
		}
		return BCC;
	}
	
	enum SEGMENT_PART
    {
		ACK(0x06),
		NAK(0x15),
		CR(0x0d),
		LF(0x0a),
		ETX(0x03),
        SOH(0x01),
        STX(0x02),
        NULL(00);
		
		private int value;

		SEGMENT_PART(int value) {
			this.value = value;
		}
    }

	private void constructByteArray()
    {
        byte[] BCC = new byte[1];
        byte[] bytes = new byte[34];

        bytes[0] = 0x01;
        bytes[1] = 0x57;
        bytes[2] = 0x32;
        bytes[3] = 0x02;
        bytes[4] = 0x43;
        bytes[5] = 0x30;
        bytes[6] = 0x30;
        bytes[7] = 0x33;
        bytes[8] = 0x28;
        bytes[9] = 0x31;
        bytes[10] = 0x34;
        bytes[11] = 0x31;
        bytes[12] = 0x32;
        bytes[13] = 0x32;
        bytes[14] = 0x33;
        bytes[15] = 0x31;
        bytes[16] = 0x31;
        bytes[17] = 0x32;
        bytes[18] = 0x31;
        bytes[19] = 0x32;
        bytes[20] = 0x33;
        bytes[21] = 0x29;
        bytes[22] = 0x03;


    }


}
