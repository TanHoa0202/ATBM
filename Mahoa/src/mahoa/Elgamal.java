/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author MY ASUS
 */
public class Elgamal {
    private String plain;
    private String cipher;
    private long F,g,h,q;
    
    public class output {
        long[] message;
        long p;

        public long[] getMessage() {
            return message;
        }

        public void setMessage(long[] message) {
            this.message = message;
        }

        public long getP() {
            return p;
        }

        public void setP(long p) {
            this.p = p;
        }
        
    }
    
    public long gcd(long a, long b) {
       if (b==0) return a;
       return gcd(b,a%b);
    }
    
    public long gen_key(long q){
        long min = (long)Math.pow(10, 10);
        long key = (long) (min+ Math.random()*(q-min)); 
        System.out.println("key" + key +"\n");
        while(gcd(q,key)!=1){
            key = (long) (min+ Math.random()*(q-min)); 
            System.out.println("key" + key +"\n");
        }
        return key;
    }
    
    public long modPow(long a, long x, long n){
        long r=1;
        while(x>0){
            if(x%2==1) r=(r*a)%n;
            a=(a*a)%n;
            x/=2;
        }
        return r;
    }
    
    public output encrypt(String msg, long q, long h, long g){
        long[] en_msg = new long[msg.length()];
        long k = gen_key(q);
        long s = modPow(h, k, q);
        long p = modPow(g, k, q);
        
        for (int i = 0; i < msg.length(); i++) {
            en_msg[i]= (int) msg.charAt(i);
        }
        for (int i = 0; i < en_msg.length; i++) {
            en_msg[i] = en_msg[i] * s;
        }
        output out = new output();
        out.setMessage(en_msg);
        out.setP(p);
        return out;
    }
    
    public String decrypt(long[] en_msg,long p, long key, long q){
        String de_msg = "";
        long h = modPow(p, key, q);
        System.out.println(h);
        for (int i = 0; i < en_msg.length; i++) {
            de_msg = de_msg + " " +  Long.toString(en_msg[i]/h);
        }
        System.out.println(de_msg);
        return de_msg;
    }
    
}
