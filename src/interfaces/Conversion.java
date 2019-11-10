
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author n.riley
 */
public interface Conversion {
    public String getValue();
    public String getResult();
    public String getErrorMsg();
    public ArrayList<String> getProcessLog();
    public boolean isValid();
}
