package Lab3;

import java.io.IOException;
import java.math.BigInteger;

public class GCDx {
	int a;
	int b;
	int k; //gratest common divisor
	int u; //Integers such that ua+vb = k
	int v;
	int operations;
	
	public GCDx(int a, int b) {
		this.a = a;
		this.b = b;
		this.k = this.calculate(a, b);
		//this.k = this.calculate(this.a,this.b,this.u,this.v);
	}
	
	public static void main(String[] args) {
	
		GCDx gcd = new GCDx(56356564,15);
		gcd.print();
		System.out.println(gcd.operations);
	}
	
	// mit BigInt
	public void calculate(BigInteger a, BigInteger b) {
		if(a.compareTo(new BigInteger("0")) == 1 && b.compareTo(new BigInteger("0"))== 1 ) {
			
		}
		
	}
	
	public int calculate(int a, int b) {
		int x = 0, y=1, u = 1, v = 0;
		int q,r,m,n;
		int sum = 0;
		while(a != 0) {
			sum++;
			q = (int) Math.floor(b/a);
			r = b%a;
			m = x-u*q;
			n = y-v*q;
			b = a;
			a = r;
			x=u;
			y = v;
			u = m;
			v = n;
			
		}
		this.u = x;
		this.v = y;
		this.operations = sum;
		return b;
	}
	
	public void print() {
		System.out.println(this.u+"*"+this.a+" + "+this.v+"*"+this.b+" = "+this.k);
	}
}
