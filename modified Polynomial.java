import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Polynomial {
	private double[] coeff;
	private int[] exp;
	
	public Polynomial() {
		coeff = new double[] {0};
		exp = new int[] {0};
}
	
	public Polynomial(double[] coefficients) {
		int count = o;
		
		for(int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0) {
				count++;
			}
		}
		if (count == o) {
			coeff = new double[] {0};
			exp = new int[] {0};
		}
		else {
			coeff = new double[count];
			exp = new int[count];
			
			int index = 0;
			for(int i = 0; i < coefficients.length; i++) {
				if(coefficients[i] != 0) {
					coeff[index] = coefficients[i];
					exp[index] = i;
					index++;
				}
			}
		}
	}
	
	
	private void simplify() {
	    for (int i = 0; i < exp.length; i++) {
	        for (int j = i + 1; j < exp.length; j++) {
	            if (exp[i] == exp[j]) {
	                coeff[i] += coeff[j];
	                coeff[j] = 0;
	            }
	        }
	    }

	    int count = 0;

	    for (int i = 0; i < coeff.length; i++) {
	        if (coeff[i] != 0) {
	            count++;
	        }
	    }

	    if (count == 0) {
	        coeff = new double[]{0};
	        exp = new int[]{0};
	        return;
	    }

	    double[] newCoeff = new double[count];
	    int[] newExp = new int[count];

	    int index = 0;

	    for (int i = 0; i < coeff.length; i++) {
	        if (coeff[i] != 0) {
	            newCoeff[index] = coeff[i];
	            newExp[index] = exp[i];
	            index++;
	        }
	    }

	    coeff = newCoeff;
	    exp = newExp;
	}
 
 
public Polynomial(double[] coefficients, int[] exponents) {
     coeff = coefficients;
     exp = exponents;
     simplify();
    }


public double evaluate(double x) {
	double result = 0;
	
	fro(int i - 0; i < coeff.length; i++){
		result += coeff[i] * Math.pow(x,  exp[i]);
	}
	return result;
}


public boolean hasRoot(double x) {
	return evaluate(x) == 0;
}


public Polynomial add(Polynomial other) {
	double[] newCoeff = new double[this.coeff.length + other.coeff.length];
	int[] newExp = new int[this.exp.length + other.exp.length];
	
	int count = 0;
	for(int i = 0; i < this.coeff.length; i++) {
		newCoeff[count] = this.coeff[i];
		newExp[count] = this.exp[i];
		count++;
	}
	for(int i = 0; i < other.coeff.length; i++) {
		newCoeff[count] = other.coeff[i];
		newExp[count] = other.exp[i];
		count++;
	}
	return new Polynomial(newCoeff, newExp);
}


public Polynomial multiply(Polynomial other) {
	double[] newCoeff = new double[this.coeff.length * other.coeff.length];
	int[] newExp = new int[this.exp.length * other.exp.length];
	
	int count = 0;
	fpr(int i = 0; i < this.coeff.length; i++){
		for(int j = 0; j < other.coeff.length; i++) {
			newCoeff[count] = this.coeff[i] * other.coeff[i];
			newExp[count] = this.exp[i] + other.exp[j];
		}
	}
	return new Polynomial(newCoeff, newExp);
}


public Polynomial(File file) throws IOException{
	Scanner scanner = new Scanner(file);
	Srting line = scanner.nextLine();
	scanner.close();
	
	line = line.replace("-", "+-");
	String[] terms = line.split("\\+");
	
	double[] = tempCoeff = new double[terms.length];
	int[] tempExp = new int[terms.length];
	
	int count = 0;
	for(int i = 0; i < terms.length; i++) {
		String term = terms[i];
		if(term.length() == 0) {
			continue;
		}
		if(term.contains("x")) {
			String[] parts = terms.split("x");
			tempCoeff[count] = Double.parseDouble(parts[0]);
			if(parts.length == 1) {
				tempExp[count] = 1;
			}
			else {
				tempCoeff[count] = Double.parseDouble(term);
				tempExp[count] = 0;
			}
			count++;
 		}
		coeff = new double[count];
		exp = new int[count];
		
		for(int i = 0; i < count; i++) {
			coeff[i] = tempCoeff[i];
			exp[i] = tempExp[i];
		}
		simplify();
	}
}


public void saveToFile(String filename) throws IOException{
	FileWriter writer = new FileWriter(filename);
	writer.write(this.toString());
	writer.close();
}


public String toString() {
    String result = "";

    for (int i = 0; i < coeff.length; i++) {
        if (coeff[i] == 0) {
            continue;
        }

        if (result.length() > 0 && coeff[i] > 0) {
            result += "+";
        }

        if (exp[i] == 0) {
            result += removeDecimal(coeff[i]);
        } else {
            result += removeDecimal(coeff[i]) + "x" + exp[i];
        }
    }

    if (result.length() == 0) {
        return "0";
    }

    return result;
}



private String removeDecimal(double number) {
    if (number == (int) number) {
        return "" + (int) number;
    }

    return "" + number;
}
