public class Polynomial{
	private double[] coeff;
	
	public Polynomial() {
		coeff = new double[1];
		coeff[0] = 0;
	}
	
	public Polynomial(double[] coefficients) {
		coeff = coefficients;
	}
	public Polynomial add(Polynomial other) {
		int maxLength = Math.max(this.coeff.length, other.coeff.length);
		double[] result = new double[maxLength];
		
		for(int i = 0; i < this.coeff.length; i++) {
			result[i] += this.coeff[i];
		}
		for(int i = 0; i < other.coeff.length; i++) {
			result[i] += other.coeff[i];
		}
		return new Polynomial(result);
	}
	public double evaluate(double x) {
		double result = 0;
		
		for(int i = 0; i < coeff.length; i++) {
			result += coeff[i] * Math.pow(x, i);
		}
		return result;
	}
	
	public boolean hasRoot(double x) {
		return evaluate(x) == 0;
	}
}
   