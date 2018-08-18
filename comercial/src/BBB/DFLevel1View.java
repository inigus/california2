package BBB;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean(name = "dfLevel1View")
public class DFLevel1View {
     
    public void openLevel2() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("level2", options, null);
    }
     
    public void onReturnFromLevel2(SelectEvent event) {
        //pass back to root
        RequestContext.getCurrentInstance().closeDialog(event.getObject());
    }
}
