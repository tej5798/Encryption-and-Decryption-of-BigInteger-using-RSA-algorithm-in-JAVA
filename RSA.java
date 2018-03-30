package rsa;
import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;


public class RSA 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Random r = new Random();
	       BigInteger p,q,n,phi,e,d;
	       int bitlength=10;
	       p = BigInteger.probablePrime(bitlength,r);
	       q = BigInteger.probablePrime(bitlength, r);
	       n = p.multiply(q);
	       phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	       e = BigInteger.probablePrime(bitlength / 2, r);
	       while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
	       {
	           e.add(BigInteger.ONE);
	       }
	       d = e.modInverse(phi);
	       System.out.println("Enter plain text: ");
	       Scanner sc = new Scanner(System.in);
	       BigInteger pt = sc.nextBigInteger();
	       System.out.println("Public Key: "+p);
	       System.out.println("Private Key: "+q);
	       BigInteger encrypted = pt.modPow(e,n);
	       System.out.println("Encrypted String: "+encrypted);
	       BigInteger decrypted = encrypted.modPow(d,n);
	       System.out.println("Decrypted String: "+decrypted);
	 }
}
