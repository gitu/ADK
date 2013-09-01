package algs.chapter3.table2;

public class Main {

	/**
	 * Note: if you create an Excel spreadsheet with these exact same
	 * computations, the proper answer of ZERO is computed.
	 */
	public static void main(String[] args) {
		float af = 1.0f/3.0f;
		float bf = 5/3.0f;
		float mf = 33.0f;
		float nf = 165.0f;
		float ef = 19;
		float ff = 95;
		
		float fval = (mf-af)*(ff-bf)-(nf-bf)*(ef-af);
		System.out.println(af+","+bf+","+mf+","+nf+","+ef+","+ff);
		System.out.println("Float computation:" + fval + "(0x" + Integer.toHexString(Float.floatToIntBits(fval)) + ")");

		int bitvalue2 = Float.floatToIntBits(fval);
		System.out.println (fval + " is " + Integer.toHexString(bitvalue2));
		
		double ad = 1.0/3.0;
		double bd = 5/3.0;
		double md = 33;
		double nd = 165;
		double ed = 19;
		double fd = 95;
		
		double dval = (md-ad)*(fd-bd)-(nd-bd)*(ed-ad);
		System.out.println(ad+","+bd+","+md+","+nd+","+ed+","+fd);
		System.out.println("Double computation:" + dval + "(0x" + Long.toHexString(Double.doubleToLongBits(dval)) + ")");
	}
}
