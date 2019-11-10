
package business;

import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public class Bin2Dec2 extends Base2Dec {
        public static final String VALUEDESC = "Binary";
        public static final String RESULTDESC = "Decimal";
        private ArrayList<String> resultsteps;
        private String result;
        private static final int BASE = 2;

        public Bin2Dec2(String value) {
            super(value, BASE);
            convert(super.getRemainder());
        }
        private void convert(ArrayList<Integer> p) {
            int r = 0;
            this.resultsteps = new ArrayList<>();
            for(int i = 0; i < p.size(); i++) {
                if (super.getValue().charAt(i) != '1' && super.getValue().charAt(i) != '0'){
                    super.setErrorMsg("Illegal value binary value (must be only zeros and ones)");
                } else {
                    r += p.get(i);
                    this.result = String.valueOf(r); 
                    this.resultsteps.add("There is a(n) " + p.get(i) + 
                " in the number (" + BASE + "^" + i + ")" );
                }
            }
//            this.result = String.valueOf(r);             
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
