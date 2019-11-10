
package business;
/**
 *
 * @author n.riley
 */
public class Dec2Hex extends Dec2Num {
    public static final String VALUEDESC = "Decimal";
    public static final String RESULTDESC = "Hexadecimal";
    private static final String HEXDIGITS = "0123456789ABCDEF";
    public static final int BASE = 16;
    private String result;

    public Dec2Hex(String value) {
        super(value, BASE);
    }
    @Override
    public String getResult() {
       this.result = "";
        if(!super.isValid()) {
            this.result = "???";
        } else {
            for(int r : super.getRemainders()) {
                 this.result += HEXDIGITS.substring(r,r+1);
//                    this.result += Integer.toHexString(r).toUpperCase();
            }
        }
        return this.result;
    }
    
}
