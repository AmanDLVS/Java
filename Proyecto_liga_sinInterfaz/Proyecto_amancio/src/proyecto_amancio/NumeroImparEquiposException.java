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
public class NumeroImparEquiposException extends Throwable{
    
    private int codigoError;
    
    NumeroImparEquiposException(){
        this.codigoError = (int) (Math.random() * (10 - 1 + 1) + 1);
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }
  
    @Override
    public String toString() {
        return "NumeroImparEquiposException{" + "codigoError=" + codigoError + '}'+"valor introducido: ";
    }
    
}
