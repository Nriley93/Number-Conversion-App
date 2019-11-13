
package business;

import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Bin2Dec2 extends Base2Dec {
        public static final String VALUEDESC = "Binary";
        public static final String RESULTDESC = "Decimal";
        private static final int BASE = 2;

        public Bin2Dec2(String value) {
            super(value, BASE, VALUEDESC);            
        }
    }
