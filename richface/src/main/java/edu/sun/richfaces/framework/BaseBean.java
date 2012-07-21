package edu.sun.richfaces.framework;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * User: sunqipeng
 * Date: 12-7-21
 */
public class BaseBean {

    /**
     * @return
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();

    }

    /**
     * @return
     */
    public Map<String, String> getParameterMap() {
        return getFacesContext().getExternalContext().getRequestParameterMap();
    }

    /**
     * @return
     */
    public Map<String, Object> getSessionMap() {
        return getFacesContext().getExternalContext().getSessionMap();
    }
}
