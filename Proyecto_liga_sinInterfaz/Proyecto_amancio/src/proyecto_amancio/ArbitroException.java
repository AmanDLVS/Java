/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

/**
 *
 * @author amanc
 */
public class ArbitroException extends Throwable{
    private int codigoError;
    ArbitroException(){
        this.codigoError = (int) (Math.random() * (20 - 1 + 11) + 11);
        
    }
    @Override
    public String toString(){
        return "Codigo de error: "+this.codigoError+",la nacionalidad del equipo y la del arbitro coinciden. Se cambiará el arbitro.";

    }
}
