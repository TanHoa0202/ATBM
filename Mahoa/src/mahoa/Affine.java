/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahoa;

/**
 *
 * @author LENOVO
 */
public class Affine {
    private String plaintext;
    private int a;
    private int b;
    public Affine(){}
    public Affine(String plaintext, int a, int b) {
        this.plaintext = plaintext;
        this.a = a;
        this.b = b;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public String encrypt(String p,int a,int b){
        String cipher= "";
        String[] split = p.split("");
        for(int i=0;i< split.length; i++){
		split[i] = split[i].toUpperCase();
		if(!split[i].equals(" ")){
			cipher +=Character.toString((char) ((a*(split[i].charAt(0) - 'A' )+ b) % 26 + 'A'));
		}else{
			cipher +=split[i];
		}
			
	
	}
	return cipher;
    }
    public String decrypt(String cipher,int a,int b){
	String plantext="";
        String[] ciphers = cipher.split("");
	int a_reverse =0;
	int flag=0;
		//loop to decrypt each char
	for(int i=0;i<=25;i++){
		flag=(a* i) %26;
		if(flag==1){
			a_reverse=i;
		}
		}

	for(int i=0;i< ciphers.length;i++){
		if(!ciphers[i].equals(" ")){
         char m = (char)(((a_reverse * ((ciphers[i].charAt(0)+'A' - b)) % 26)) + 'A');
         plantext +=  Character.toString(m);
     }
      else
		{
         plantext += ciphers[i];
	}
	}	
	return plantext;
    }
}
