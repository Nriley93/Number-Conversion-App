
package business;

import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
abstract public class Dec2Num implements Conversion {
    private String binaryresult;
    private ArrayList<String> resultsteps;
    private ArrayList<Integer> remainders;
    private String emsg;
    private boolean valid;
    private String origVal;
    private int base;
    
    public Dec2Num(String value, int b) {
        this.emsg = "";
        this.origVal = value;
        this.base = b;
        try {
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
    } // End of constructor
    private void convertByRecur(long n) {
        int r = 0;
        
        r = (int)(n % this.base);
        long newval = n / this.base;
        resultsteps.add(n + " divided by " + this.base +
                " = " + newval + " w/remainder of: "  + r);
        
        if (newval > 0) {
            convertByRecur(newval);
        } 
        remainders.add(r);
    }
    
    @Override
    public String getValue() {
        return this.origVal;
    }
    protected ArrayList<Integer> getRemainders() {
        return this.remainders;
    }
    @Override
    abstract public String getResult();
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public boolean isValid() {
        return this.valid;
    }
}
