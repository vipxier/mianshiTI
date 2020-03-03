package BinaryManpulate;

public class HexacamicalToBinary {
	public static String convertHexToBinary(String hexString) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < hexString.length(); i++) {
			if (hexString.charAt(i) >= 'A' && hexString.charAt(i) <= 'Z') {
				strBuilder.append(DecimalToBinary.decimalToBinary(hexString.charAt(i) - 'A'));
			} else if (hexString.charAt(i) >= '1' && hexString.charAt(i) <= '9') {
				strBuilder
						.append(DecimalToBinary.decimalToBinary(Integer.parseInt(String.valueOf(hexString.charAt(i)))));
			}

		}
		return strBuilder.toString();
	}
	
	public static void main(String[] args)
	{
		String hexString = "10";
		
		System.out.println(convertHexToBinary(hexString));
	}
}
