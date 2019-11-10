
package business;

import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author n.riley
 */

public class Bin2Dec implements Conversion {
    public static final String VALUEDESC = "Binary";
    public static final String RESULTDESC = "Decimal";
    public static final int BASE = 2;
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;
    private boolean valid;
    private String origVal;
    
    public Bin2Dec(String value) {
        this.emsg = "";
        this.origVal = value;
        this.valid = validCheck();
        if (this.valid) {
            convert(value);
        } else {
            this.emsg = "Illegal value binary value (must be only zeros and ones)";
        }
    }
    private boolean validCheck() {
        for (int i=0; i< this.origVal.length(); i++) {
            if (this.origVal.charAt(i) != '1' && this.origVal.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    private void convert(String v) {
        long r = 0;
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
        for (int i=0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == '1') {
                long p = (long) Math.pow(BASE,i);
                r += p;
                this.resultsteps.add("There is a(n) " + p + 
                        " in the number (" + BASE + "^" + i + ")" );
            }
        }
        this.result = String.valueOf(r);
    }
    @Override
    public String getResult() {
        return this.result;
    }
    
//    /
    @Override
    public String getValue() {
        return this.origVal;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
}