package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {
	public static void addInfoMessage(String summary, String detail){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}
	
	public static void addErrorMessage(String summary, String detail){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
	}
	
	//add uma de que a altera��o na base de dados foi  um sucesso
		
}
