
package business;

//import interfaces.Conversion;
import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Hex2Dec implements Conversion {
    
    
    
   public static final String VALUEDESC = "Hexadecimal";
    public static final String RESULTDESC = "Decimal";
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;
    private boolean valid;
    private String origVal;
    private static final String HEXDIGITS = "0123456789ABCDEF";
    public static final int BASE = 16;
    
    public Hex2Dec(String value) {
        this.emsg = "";
        this.origVal = value.toUpperCase();
        this.valid = validCheck();
        if (this.valid) {
            convert(value);
        } else {
            this.emsg = "Illegal hex value";
        }
    }
    private boolean validCheck() {
        for(int i = 0; i < this.origVal.length(); i++) {
            if(this.HEXDIGITS.indexOf(this.origVal.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
   private void convert(String v) {
        int r = 0;
        v = v.toUpperCase();
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
        for (int i=0; i < reverse.length(); i++) {
               long p = (long)Math.pow(BASE,i);
                r += p * HEXDIGITS.indexOf(reverse.charAt(i));
                
                this.resultsteps.add("There is a " + p + " in the number (" +
                        HEXDIGITS.indexOf(reverse.charAt(i)) + "*" +
                        BASE  + "^" + i + ")" );
        }
        this.result = String.valueOf(r);
    }
    @Override
    public String getResult() {
        return this.result;
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
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
     @Override
    public boolean isValid() {
        return this.valid;
    }
}
