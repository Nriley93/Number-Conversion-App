
package business;

import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Base2Dec implements Conversion {
  
    private String emsg;
    private boolean valid;
    private String origVal, result, type;
    private ArrayList<String> resultsteps;
    private static final String HEXDIGITS = "0123456789ABCDEF";
    
    Base2Dec(String v, int b, String type) {
        this.origVal = v.toUpperCase();
        this.type = type;
        this.emsg = "";
        this.valid = true;
        switch(this.type) {
            case Hex2Dec2.VALUEDESC:
                for(int i = 0; i < this.origVal.length(); i++) {
                    if(this.HEXDIGITS.indexOf(this.origVal.charAt(i)) == -1) {
                        this.emsg = "Illegal hex value";
                        this.valid = false;
                    }
                }
                break;
            case Bin2Dec2.VALUEDESC:
                for (int i=0; i< this.origVal.length(); i++) {
                    if (this.origVal.charAt(i) != '1' && this.origVal.charAt(i) != '0') {
                        this.emsg = "Illegal value binary value (must be only zeros and ones)";
                        this.valid = false;
                    }
                }
                break;
        }
        if (this.valid) {
            convert(v,b);
        }
    }
    private void convert(String v,int b) {        
        int r = 0;
        long p = 0;
        v = v.toUpperCase();
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
        for (int i=0; i < reverse.length(); i++) {
                p = (long)Math.pow(b,i)*HEXDIGITS.indexOf(reverse.charAt(i));;
                r += p;
                if(this.type.equals(Hex2Dec2.VALUEDESC)) {
                    this.resultsteps.add("There is a " + p + " in the number (" 
                            + HEXDIGITS.indexOf(reverse.charAt(i)) + "*" +
                        b  + "^" + i + ")" );
                } else {
                    this.resultsteps.add("There is a(n) " + p + 
                        " in the number (" + b + "^" + i + ")" ); 
                }                            
        }
        this.result = String.valueOf(r);
    }
    @Override
    public String getValue() {
       return this.origVal;
    }
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    @Override
    public boolean isValid() {
        return this.valid;
    }
    @Override
    public String getResult() {
        return this.result;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    
}
