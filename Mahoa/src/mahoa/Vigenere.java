/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahoa;

/**
 *
 * @author LENOVO
 */
public class Vigenere {
    public String p;
    public String k;
    public Vigenere(){}
    public String encrypt(String p, String key){
        int flag =0;
	String generateKey="";
	String cipher="";
        p = p.toUpperCase();
        p = p.replaceAll("\\s", "");
        key = key.toUpperCase();
        String[] tmp = p.split("");
        String[] ktmp = key.split("");
	//loop with plantext length to create cipher text with the same lengh
	for(int i=0;i< tmp.length;i++){
		if(flag== ktmp.length){
			flag=0;
		}
		generateKey+=ktmp[flag];
		flag++;
	}
	for(int i=0;i< tmp.length;i++){
		//with Key cipher {2,8, 15,7,4,17}
		//each planttext will replace with modulo 26 by key
		//encrypt with (currenkey + sameposition in generatekey) and modulo 26
		cipher += Character.toString((char) ((tmp[i].charAt(0) + generateKey.charAt(i)) % 26 + 'A'));
	}
	return cipher;
    }
    public String decrypt(String cipher,String key){
        int flag =0;
	String generateKey="";
	String p="";
        key = key.toUpperCase();
        String[] tmp = cipher.split("");
        String[] ktmp = key.split("");
	//loop with plantext length to create cipher text with the same lengh
	for(int i=0;i< tmp.length;i++){
		if(flag== ktmp.length){
			flag=0;
		}
		generateKey+=ktmp[flag];
		flag++;
	}
	for(int i=0;i< tmp.length;i++){
		//with Key cipher {2,8, 15,7,4,17}
		//each planttext will replace with modulo 26 by key
		//encrypt with (currenkey + sameposition in generatekey) and modulo 26
		p += Character.toString((char) (((tmp[i].charAt(0) - generateKey.charAt(i))+26) % 26 + 'A'));
	}
	return p;
    }
}
