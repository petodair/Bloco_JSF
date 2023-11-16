package br.com.bloco.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.bloco.filter.DispositivoFilter;

@ViewScoped
@Named
public class MobileMB implements Serializable {

	private static final long serialVersionUID = 1L;

    public void mobileCheck() throws IOException{
    	DispositivoFilter filtro = new DispositivoFilter();
    	FacesContext context = null;
        String renderKitId = FacesContext.getCurrentInstance().getViewRoot().getRenderKitId();        
        if(renderKitId.equalsIgnoreCase("PRIMEFACES_MOBILE")){
        	if(filtro.calculateRenderKitId(context).equals("PRIMEFACES_MOBILE"))
        	FacesContext.getCurrentInstance().getExternalContext().redirect("homeMobile.xhtml");
        	
        }
    }
    
    public boolean checkAndroid() {
    	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	String userAgent = req.getHeader("user-agent");
    	if(userAgent.matches(".*Android.*")) {
    		return true; 		
    	} else {
    		return false;
    	}
    			
    }
	
}
