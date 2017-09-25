/*
 * Bueno Rosas Brayan Omar 
   5IM8
    Version 1.0
 */
package clavesdes;


public class Clavescd {
    Clave ob= new Clave();
    
    public String obtencd()
    {
        String claveb = ob.binclav();
        String cd0 = "";
        //Se posicionan los dígitos de la clave en binario
        for(int i=0;i<ob.Primeracajadepermutacion.length;i++)
        {
            cd0 += claveb.charAt(ob.Primeracajadepermutacion[i]-1);
        }
        return cd0;
    }
}
