
package business;

import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Hex2Dec2 extends Base2Dec {
    public static final String VALUEDESC = "Hexadecimal";
    public static final String RESULTDESC = "Decimal";
    private static final int BASE = 16;

    public Hex2Dec2(String value) {
        super(value, BASE, VALUEDESC);
    }   
}
