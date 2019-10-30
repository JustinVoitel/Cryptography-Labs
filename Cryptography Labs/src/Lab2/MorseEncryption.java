package Lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class MorseEncryption {
	private HashMap<Character, String> morseAlphabet;

	public MorseEncryption() {
		morseAlphabet = new HashMap<>();
		initAlphabet();
	}

	public void initAlphabet() {
		morseAlphabet.put('a', ".-");
		morseAlphabet.put('b', "-...");
		morseAlphabet.put('c', "-.-.");
		morseAlphabet.put('d', "-..");
		morseAlphabet.put('e', ".");
		morseAlphabet.put('f', "..-.");
		morseAlphabet.put('g', "--.");
		morseAlphabet.put('h', "....");
		morseAlphabet.put('i', "..");
		morseAlphabet.put('j', ".---");
		morseAlphabet.put('k', "-.-.");
		morseAlphabet.put('l', ".-..");
		morseAlphabet.put('m', "--");
		morseAlphabet.put('n', "-.");
		morseAlphabet.put('o', "---");
		morseAlphabet.put('p', ".--.");
		morseAlphabet.put('q', "--.-");
		morseAlphabet.put('r', ".-.");
		morseAlphabet.put('s', "...");
		morseAlphabet.put('t', "-");
		morseAlphabet.put('u', "..-");
		morseAlphabet.put('v', "...-");
		morseAlphabet.put('w', ".--");
		morseAlphabet.put('x', "-..-");
		morseAlphabet.put('y', "-.--");
		morseAlphabet.put('z', "--..");
	}

	public static void main(String args[]) {
		MorseEncryption morse = new MorseEncryption();
		String morseCode = morse.encodeMorse("Thats a sample text to decode");
		System.out.println(morseCode);
		String decoded = morse.decodeMorse("\r\n" + 
				"..-. ..- . .-.  ..- -. ... . .-.  . .. --. . -. . ...  . -. -.-. --- -.. .. -. --.  ... -.-. .... . .. -. -  .--- . - --.. -  .---- ---.. --...  .-. .- ... ... . .-.. -... .- -. -.. .  .- .-.. .-.. . ...  --. ..- -  --.. ..-  -.- .-.. .- .--. .--. . -.  .-- .. .-.  .... .- -... . -.  -. ..- .-.  -.- . .. -. .  --.. .- .... .-.. . -.  -... .. ... .... . .-.  ..--- ..... -....");
		System.out.println(decoded);
	}

	public String encodeMorse(String plaintext) {

		String[] words = plaintext.toLowerCase().trim().split(" ");
		StringBuilder encoded = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			for (int ii = 0; ii < words[i].length(); ii++) {
				String morseSub = this.morseAlphabet.get(words[i].charAt(ii));
				encoded.append(morseSub);
				encoded.append(" ");
			}
			if(i != words.length-1) {
				encoded.append("  ");
			}
		}
		return encoded.toString().trim();
	}

	public String decodeMorse(String cipher) {
		String[] cipherWords = cipher.split("  ");
		StringBuilder decoded = new StringBuilder();

		for (int i = 0; i < cipherWords.length; i++) {
			String[] morseSub = cipherWords[i].split(" ");
			for (int ii = 0; ii < morseSub.length; ii++) {
				final int index = ii;
				Optional<Character> ch = this.morseAlphabet.entrySet().stream()
						.filter(e -> morseSub[index].equals(e.getValue())).map(Map.Entry::getKey).findFirst();
				ch.ifPresent(s -> decoded.append(s));

			}
			if(i != cipherWords.length-1) {				
				decoded.append(" ");
			}

		}

		return decoded.toString();

	}

}
