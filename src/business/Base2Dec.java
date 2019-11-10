
package business;

import interfaces.Conversion;
import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
abstract public class Base2Dec implements Conversion {
  
    private String emsg;
    private boolean valid;
    private String origVal;
    private int base;
    private ArrayList<Integer> remainders;
    
    Base2Dec(String v, int b) {
        this.valid = true;
        this.origVal = v;
        this.emsg = "";
        this.base = b;
        convert(v);
    }
    private void convert(String v) {
        v = v.toUpperCase();
        String reverse = new StringBuilder(v).reverse().toString();
        this.remainders = new ArrayList<>();
        this.origVal = reverse;
        for (int i=0; i < v.length(); i++) {
                long p = (long) Math.pow(this.base,i);
                this.remainders.add((int)p);
        } 
    }
    protected ArrayList<Integer> getRemainder() {
        return this.remainders;
    }
    protected void setErrorMsg(String msg){
        this.emsg = msg;
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
    abstract public String getResult();
    @Override
    abstract public ArrayList<String> getProcessLog();
    
}
