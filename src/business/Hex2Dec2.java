
package business;

import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Hex2Dec2 extends Base2Dec {
    public static final String VALUEDESC = "Hexadecimal";
    public static final String RESULTDESC = "Decimal";
    private static final String HEXDIGITS = "0123456789ABCDEF";
    private ArrayList<String> resultsteps;
    private String result;
    private static final int BASE = 16;

    public Hex2Dec2(String value) {
        super(value, BASE);
        convert(super.getRemainder());
    }   
    private void convert(ArrayList<Integer> p) {
       this.result = "";
       this.resultsteps = new ArrayList<>();
       long r = 0;
        for (int i=0; i < super.getValue().length(); i++) {
                long b = p.get(i) * HEXDIGITS.indexOf(super.getValue().charAt(i));
                r += b;
                this.result = String.valueOf(r);

                this.resultsteps.add("There is a " + b + " in the number (" +
                    HEXDIGITS.indexOf(super.getValue().charAt(i)) + "*" +
                    BASE  + "^" + i + ")" );
        }
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
