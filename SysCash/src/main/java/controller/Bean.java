package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.event.ActionEvent;


@ManagedBean(name = "ct1")
@SessionScoped
public class Bean implements Serializable {

    public Bean() {
    }
    
    public String btTelaCad(ActionEvent a){
        return "novous";
    }
    
    public String btTelaIndex(ActionEvent a){
        return "index";
    }
    
    public String btTelaMain(ActionEvent a){
        return "main";
    }
    
    public String btTelaProduto(ActionEvent a){
        return "buscapro";       
    }
    
    public String btTelaConf(ActionEvent a){
        return "confirma";       
    }
    
}
