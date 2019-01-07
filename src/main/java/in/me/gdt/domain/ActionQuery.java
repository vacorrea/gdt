package in.me.gdt.domain;

import java.util.HashMap;
import java.util.Map;

public class ActionQuery {
    private Map<Object, Object> map = new HashMap<Object, Object>();
    
    private ActionQuery() {  }
    public Map<Object, Object> buildQueryMap(){ return this.map;}
    public static ActionQuery newInstance(Map<Object, Object> map) { 
        map.entrySet();
        return new ActionQuery(); 
    }

    
}