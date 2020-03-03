
public class ConvertHexToDecimal {
	public static int convert(String hexString) {
		int result = 0;

		for (int i = 0; i < hexString.length() - 1; i++) {
			result = (result + getNumberFromChar(hexString.charAt(i))) * 16;
		}

		result += getNumberFromChar(hexString.charAt(hexString.length() - 1));
		return result;
	}

	private static int getNumberFromChar(char hexChar) {
		if (hexChar - '0' < 10) {
			return Integer.parseInt(String.valueOf(hexChar));
		} else {
			return 10 + hexChar - 'a';
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(convert("1bbdd"));
		System.out.println(Integer.valueOf("1bbdd", 16));
	}
}
