package BBB;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean(name = "dfRootView")
public class DFRootView {
     

   @PostConstruct
    public void init() {       
        // Remember already saved result from view scoped bean
        System.out.println(" supongo sera como un constructor....");
    }
	
	public void openLevel1() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("level1", options, null);
    }
     

    
    public void onReturnFromLevel1(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }




}