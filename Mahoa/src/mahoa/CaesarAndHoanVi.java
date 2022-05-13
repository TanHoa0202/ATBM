package mahoa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CaesarAndHoanVi {
	// mã hoán vị
	private int nRails;
    public void RailFenceCipher(int rails) {
        nRails = rails;
    }
    // mã hoá hoán vị
    public static String getEncryptedData(String text, int nRails) {
        if (nRails < 2) return text;
        
        StringBuilder rails[] = new StringBuilder[nRails];
        for (int i = 0; i < nRails; i++) {
            rails[i] = new StringBuilder();
        }
        int cap = 2 * nRails - 2;
        for (int i = 0; i < text.length(); i++) {
            int index = i % cap;
            if (index >= nRails)
                index = 2 * nRails - index - 2;
            rails[index].append(text.charAt(i));
        }
        return Arrays.stream(rails)
            .map(sb -> sb.toString())
            .collect(Collectors.joining());
    }
    // giải mã hoán vị
    public static String getDecryptedData(String encrypted, int nRails) {
        if (nRails < 2) return encrypted;
        int railCounts[] = new int[nRails];
        int cap = 2 * nRails - 2;
        for (int i = 0; i < encrypted.length(); i++) {
            int index = i % cap;
            if (index >= nRails)
                index = 2 * nRails - index - 2;
            railCounts[index] += 1;
        }
        Queue<Character> rails[] = new Queue[nRails];
        int start = 0;
        for (int r = 0; r < nRails; r++) {
            rails[r] = new LinkedList<>();
            int stop = start + railCounts[r];
            for (;start < stop; start++)
                rails[r].offer(encrypted.charAt(start));
        }
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            int index = i % cap;
            if (index >= nRails)
                index = 2 * nRails - index - 2;
            decoded.append(rails[index].poll());
        }
        return decoded.toString();
    }

// Ceasar
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
// Mã hoá ceasar
	public static String encrypt(String plainText, int shiftKey) {
		plainText = plainText.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < plainText.length(); i++) {
			int charPosition = ALPHABET.indexOf(plainText.charAt(i));
			int keyVal = (shiftKey + charPosition) % 26;
			char replaceVal = ALPHABET.charAt(keyVal);
			cipherText += replaceVal;
		}
		return cipherText;
	}
// giải mã ceasar
	public static String decrypt(String cipherText, int shiftKey) {
		cipherText = cipherText.toLowerCase();
		String plainText = "";
		for (int i = 0; i < cipherText.length(); i++) {
			int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
			int keyVal = (charPosition - shiftKey) % 26;
			if (keyVal < 0) {
				keyVal = ALPHABET.length() + keyVal;
			}
			char replaceVal = ALPHABET.charAt(keyVal);
			plainText += replaceVal;
		}
		return plainText;
	}
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the String for Encryption: ");
//        String message = new String();
//        message = sc.next();
//        System.out.println(encrypt(message, 3));
//        System.out.println(decrypt(encrypt(message, 3), 3));
//        sc.close();
//    }
}