/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoa;

/**
 *
 * @author MY ASUS
 */
public class NewClass {
    public static void main(String[] args) {
        Elgamal el = new Elgamal();
        String msg = "encryption";
        long max = (long) Math.pow(10, 14);
        long min = (long) Math.pow(10, 10);
        long q = (long) (min+ Math.random()* (max-min));
        long g = (long) (2+ Math.random()* (q-2));
        long key = el.gen_key(q);
        long h = el.modPow(g, key, q);
        System.out.println(key + "\n");
        System.out.println(g + "\n");
        System.out.println(h + "\n");
        Elgamal.output out = el.encrypt(msg, q, h, g);
        System.out.println(out.getP() + "\n");
        String plain = el.decrypt(out.getMessage(), out.getP(), key, q);
        System.out.println(plain);
        
    }
}
