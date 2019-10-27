package Lab1;

import java.util.Random;

public class OTPEncrypt {
	public static String generateRandomOTP(int length) {
		String otp = "";
		Random wuerfel = new Random();
		for(int i=0; i<length;i++) {
			int binary = wuerfel.nextInt(2);
			otp += binary;
		}
		return otp;
	}
	
	public static void main(String[] args) {
//		String otp = generateRandomOTP(80);
//		String plaintext = "shdgfskjsh";
//		System.out.println(plaintext);
//		System.out.println("otp: "+ otp);
//		System.out.println("encoded: "+encodeText(textToBinary(plaintext), otp));
		System.out.println(binaryToText(encodeText("1001010001110111101101111001000011110000011111000111100001101001100010010001110", "00101110101101010001010100100101001111010101001011010011101011000011101111000000")));
		
//		shdgfskjsh
//		otp: 01000100001101010001111100000100001111000101011110100001110111010110011110011000
//		textToBinary ouput: 01110011011010000110010001100111011001100111001101101011011010100111001101101000
//		encoded: 00110111010111010111101101100011010110100010010011001010101101110001010011110000
	}
	
	public static String textToBinary(String digits) {
		String binaryString = "";
		byte[] charArray = digits.getBytes();
		
		for(int i = 0;i < charArray.length;i++) {
			String binaryDigits = "0"+ Integer.toBinaryString(charArray[i]);
			binaryString += binaryDigits;
		}
		System.out.println("textToBinary ouput: "+binaryString);

		return binaryString;
	}
	
	public static String binaryToText(String binary) {
		String word ="";
		
		for (int i = 0;i<binary.length()/8;i++) {
			String sub = binary.substring(i*8, i*8+8);
			int digit = Integer.parseInt(sub, 2);
			
			word += String.valueOf((char)digit);
		}
		System.out.println("binaryToText ouput: "+word);
		return word;
	}
	
	
	public static String encodeText(String binaryText, String binaryKey) {
		char[] textChars = binaryText.toCharArray();
		char[] keyChars = binaryKey.toCharArray();
		String encodedText = "";
		for(int i = 0;i<textChars.length;i++) {
			int result = Integer.parseInt(String.valueOf(textChars[i]))^Integer.parseInt(String.valueOf(keyChars[i]));
			encodedText += result;
		}
		return encodedText;
	}
	
}
