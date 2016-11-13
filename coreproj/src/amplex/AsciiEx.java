package amplex;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class AsciiEx {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//oldImplementation();
		//newImplementation();
		getBcc();
	}

	public static void getBcc()
    {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String date = sdf.format(Calendar.getInstance().getTime());
		System.out.println("Date:::::::::::"+date);
		//String convertedDateString = convertAsciiToHex(date);
		String convertedDateString = convertAsciiToHex("141223112123");
		
//		StringBuffer sb = new StringBuffer("015732024330303328");
//		sb.append(convertedDateString);
//		sb.append("2903");
		
		//StringBuffer sb = new StringBuffer("01573102433235303031343030373828354434413030303030303035354434413046383630303036"); //363030303036303030303030303038312903
		//StringBuffer sb = new StringBuffer("3132333435363738");	//12345678
		StringBuffer sb = new StringBuffer("3030303636303030");	//12345678  
		System.out.println("convertedDateString:::"+sb.toString());
        byte[] inputStream = new BigInteger(sb.toString(), 16).toByteArray();
        System.out.println(Arrays.toString(inputStream));
/*        if (inputStream != null && inputStream.length > 0)
        {
            // Exclude SOH during BCC calculation
            for (int i = 0; i < inputStream.length; i++)
            {
            	if (inputStream[i] == (int)SEGMENT_PART.SOH.getValue() || inputStream[i] == (int)SEGMENT_PART.STX.getValue())
                {
                   continue;
                } else {
                	bcc ^= inputStream[i];
                }
            }
        }*/
        byte b = getBcc(inputStream);
        byte[] b1 = new byte[]{b};
        sb = printBytesAsHex(b1, sb);
        System.out.println("FinalOutputString:::::"+sb);
    }
	
	static byte getBcc(byte[] bytes)
    {
        byte bcc = 0x00;
        boolean SOHorSTX = true;
        for (int i = 0; i < bytes.length; i++)
        {
            if (SOHorSTX)
            {
                if (bytes[i] == (byte)SEGMENT_PART.SOH.getValue() || bytes[i] == (byte)SEGMENT_PART.STX.getValue())
                {
                    SOHorSTX = false;
                   continue;
                }
            }
            bcc = (byte)((int)bcc ^ (int)bytes[i]);
        }
        return bcc;
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
        private SEGMENT_PART(int x) {
        	this.value = x;
		}
        
        public int getValue() {
			return value;
		}
    }

	private static void oldImplementation() {
		StringBuilder sb = new StringBuilder();
		sb.append("0300000000000000000000000000000000220F06080C132600");
		byte[] messageData = new BigInteger(sb.toString(), 10).toByteArray();
		//printBytesAsHex(BigInteger.valueOf(year).toByteArray(), sb);
		System.out.println(sb);
		System.out.println(Arrays.toString(messageData));
	}

	public static StringBuffer printBytesAsHex(byte[] bytes, StringBuffer buffer)
	{
		for (int i=0; i<bytes.length; i++) {
			int j = 0xFF & bytes[i];
			if (j < 16)
				buffer.append("0");
			buffer.append(Integer.toHexString(j).toUpperCase());
		}

		return buffer;
	}


	private static void newImplementation() {
		StringBuilder sb = new StringBuilder("7ec1018120010101962020FF02200A18015732024330303328");
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String date = sdf.format(Calendar.getInstance().getTime());
		System.out.println("Date:::::::::::"+date);
		String convertedDateString = convertAsciiToHex(date);
		System.out.println(" date::::"+date+"      FormattedDate::::"+convertedDateString);
		sb.append(convertedDateString);	//dynamic value
		sb.append("29");	// closing bracket
		sb.append("03");	// End of text
		sb.append("10");	// Data Line Escape
		
		System.out.println(sb.toString());
		
		byte[] messageData = new BigInteger(sb.toString(), 16).toByteArray();
		//getBcc(messageData);
		System.out.println("ConvertByteArrayToString::::"+Arrays.toString(messageData));
		
		for (byte i : messageData) {
			System.out.print((char) i);
		}
		
	}

	private static String convertAsciiToHex(String asciiValue)
	{
		char[] chars = asciiValue.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
		{
			
			int j = 0xFF & chars[i];
			if (j < 16)
				hex.append("0");
			hex.append(Integer.toHexString((int) chars[i]));
			System.out.println(chars[i]+"  ---   "+Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}

	private static String constructData() {
		StringBuilder sb = new StringBuilder();
		sb.append("\u0001");	// start of header
		sb.append("W");			// Uppercase W
		sb.append("2");			
		sb.append("\u0002");	// start of text
		sb.append("C");	// constant		
		sb.append("0");	// constant
		sb.append("0");	// constant
		sb.append("3");	// constant
		sb.append("(");	// constant
		sb.append("1");	// year
		sb.append("4");
		sb.append("1");	// month
		sb.append("2");
		sb.append("2"); // date
		sb.append("3");	
		sb.append("1");	// hour
		sb.append("1");
		sb.append("2");	// minute
		sb.append("1");
		sb.append("2");	// second
		sb.append("3");
		sb.append(")");	// closing bracket
		sb.append("\u0003");	// End of text
		sb.append("\u0010");	// Data Line Escape
		System.out.println(sb.toString());
		return sb.toString();
	}
}
