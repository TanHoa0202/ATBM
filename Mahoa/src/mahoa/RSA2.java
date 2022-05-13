/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahoa;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RSA2 {
    static List<Double> dd = new ArrayList<>();
    public static void main(String[] args){
        
        String k = "HELLO";
        String[] ds= k.split("");
        for(int i =0 ;i< ds.length;i++){
            int ks = ds[i].charAt(0)%26;
            dd.add(encrypt(11, 13, ks));
        }
        for(Double ddd: dd){
            int kss = decrypt(11,13,ddd).intValue()%26 + 65;
            char a = (char)kss;
            System.out.println(a);
        }
    }
    public static double  encrypt(int p,int q,int messages){
        int e, i;
        int n = p * q;
        int z = (p - 1) * (q - 1);
         for (e= 2; e < z; e++) {
 
            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        return (Math.pow(messages, e)) % n;
    }
    public static BigInteger  decrypt(int p,int q,double messages){
         // The number to be encrypted and decrypted
        int  n, z, d = 0, e, i;
 
        // 1st prime number p
        n = p * q;
        z = (p - 1) * (q - 1);
        for (e = 2; e < z; e++) {
 
            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
 
            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        
 
        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(messages).toBigInteger();
        BigInteger N = BigInteger.valueOf(n);
        return (C.pow(d)).mod(N);

    }
    
 
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
    
    public static double gcd(double a,double b){
        double temp;
    while(true)
    {
        temp = a%b;
        if(temp==0)
        return b;
        a =b;
        b = temp;
    }
    }
    
}
