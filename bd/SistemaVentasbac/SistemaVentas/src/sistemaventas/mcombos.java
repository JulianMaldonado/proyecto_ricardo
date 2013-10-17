/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaventas;

/**
 *
 * @author JULIAN
 */
public class mcombos {
      private String detalle;
    private String id;
    
    public mcombos (String detalle, String id){
        this.detalle=detalle;
        this.id=id;
        
    }

  
     
    public String getID (){
       return id;
              
    }
    public String toString (){
       return detalle;
              
    }
    
    
}
