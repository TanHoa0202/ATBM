/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mahoa;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class RSA2 {
        public int p, q, n ,z, d, e;

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
    	public static void main(String args[])
	{
            
		int p=11,q=13,n,z,d=0,e,i;
		int msg=107;
		double c;
		BigInteger msgback; 		
		n=p*q;
		z=(p-1)*(q-1);
		System.out.println("the value of z = "+z);		

		for(e=2;e<z;e++)
		{
			if(gcd(e,z)==1)            // e is for public key exponent
			{				
				break;
			}
		}
		System.out.println("the value of e = "+e);				
		for(i=0;i<=9;i++)
		{
			int x=1+(i*z);
			if(x%e==0)      //d is for private key exponent
			{
				d=x/e;
				break;
			}
		}
		System.out.println("the value of d = "+d);		
		c=(Math.pow(msg,e))%n;
		System.out.println("Encrypted message is : -");
		System.out.println(c);
                //converting int value of n to BigInteger
		BigInteger N = BigInteger.valueOf(n);
		//converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback = (C.pow(d)).mod(N);
		System.out.println("Derypted message is : -");
		System.out.println(msgback);
                

	}

	static int gcd(int e, int z)
	{
		if(e==0)
			return z;	
		else
			return gcd(z%e,e);
	}
        
        public String encrypt(int p, int q, String plaintext) {
            int num = Integer.parseInt(plaintext);
            String cipher = "";
            double c;
            setN(p*q);
		setZ((p-1)*(q-1));	
                int ele;
		for(ele=2;ele<getZ();ele++)
		{
			if(gcd(ele,getZ())==1)            // e is for public key exponent
			{	
                            setE(ele);
                            break;
			}
		}				
		for(int j=0;j<=9;j++)
		{
			int x=1+(j*getZ());
			if(x%getE()==0)      //d is for private key exponent
			{
				setD(x/getE());
				break;
			}
		}
		c=(Math.pow((num),getE()))%getN();
                cipher+= c;
            return cipher;
        }
        public String decrypt(int p, int q, String cipher){
            String plaintext = "";
            BigInteger msgback; 
            double c;
            setN(p*q);
		setZ((p-1)*(q-1));	
                int ele;
		for(ele=2;ele<getZ();ele++)
		{
			if(gcd(ele,getZ())==1)            // e is for public key exponent
			{	
                            setE(ele);
                            break;
			}
		}				
		for(int j=0;j<=9;j++)
		{
			int x=1+(j*getZ());
			if(x%getE()==0)      //d is for private key exponent
			{
				setD(x/getE());
				break;
			}
		}
                BigInteger N = BigInteger.valueOf(getN());
		//converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(Integer.parseInt(cipher)).toBigInteger();
		msgback = (C.pow(getD())).mod(N);

		plaintext +=msgback;
         return plaintext;   
        }

        
}
