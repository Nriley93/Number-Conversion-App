
package business;

import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author: n.riley
 */
public class Dec2Bin implements Conversion {
    public static final String VALUEDESC = "Decimal";
    public static final String RESULTDESC = "Binary";
    private String binaryresult;
    private ArrayList<String> resultsteps;
    private ArrayList<Integer> remainders;
    private String emsg;
    private boolean valid;
    private String origVal;
    
    public Dec2Bin(String value) {
        this.emsg = "";
        try {
            this.origVal = value;
           long n = Long.parseLong(value);
           if (n < 0 ) {
               this.valid = false;
               this.emsg = "Bad decimal value: must be positive.";
           } else {
               this.valid = true;
              this.resultsteps = new ArrayList<>();
              this.remainders = new ArrayList<>();
              this.binaryresult = "";
              convertByRecur(n);
           }
        } catch (NumberFormatException e) {
            this.valid = false;
           emsg = "Illegal value: not a decimal integer";
        }
    }
    private void convertByRecur(long n) {
        int r = 0;
        
        r = (int)(n % 2);
        long newval = n / 2;
        resultsteps.add(n + " divided by 2 = " +
                newval + " w/remainder of: "  +r);
        
        if (newval > 0) {
            convertByRecur(newval);
        } 
        remainders.add(r);
    }
    @Override
    public String getResult() {
        for(Integer i : remainders) {
            this.binaryresult += String.valueOf(i);
        }
        return this.binaryresult;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    @Override
    public String getValue() {
        return this.origVal;
    }
    @Override
    public boolean isValid() {
        return this.valid;
    }
}
