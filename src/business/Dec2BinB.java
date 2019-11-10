
package business;

/**
 *
 * @author n.riley
 */
public class Dec2BinB extends Dec2Num {
    public static final String VALUEDESC = "Decimal";
    public static final String RESULTDESC = "Binary";
    public static final int BASE = 2;
    private String result;
    
    public Dec2BinB(String value) {
        super(value,BASE);
    }

    @Override
    public String getResult() {
        this.result = "";
        if(!super.isValid()) {
            this.result = "???";
        } else {
            for(int r : super.getRemainders()) {
                this.result += String.valueOf(r);
            }
        }
        return this.result;
    }
}
