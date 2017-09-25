/*
 * Bueno Rosas Brayan Omar 
   5IM8
    Version 1.0
 */
package clavesdes;
/**
 *
 * @author 1047330056
 */
public class Clavesk {
    Clavescd obj = new Clavescd(); //Instancia de clases 
    Clave obj1= new Clave();// Estas clases tienen los datos obtenidos anteriormente para generar las claves
    String cd0=obj.obtencd() ; // Traemos a c0d0 ya calculadas despues de lapermutacion
    String []llave= new String [16];// Arerglo provicional para guardar lasllaves
     
        String c0 = cd0.substring(0,(cd0.length()/2));     //Obtiene a c0 
        String d0 = cd0.substring((cd0.length()/2),cd0.length()); //Obtiene a d0
      //Se divide la clave en c0 y d0
       
//     public void   muestra(){
//         System.out.println(c0);
//         System.out.println(d0);
//     }   
     
    public void calculak(){
        for(int i=0; i<16; i++)
        {
            String permutacionc ="";//VARIABLES PARA PERMUTACION DE D Y C
            String permutaciond = "";
            c0=c0.substring(obj1.vueltas[i],c0.length())+c0.substring(0, obj1.vueltas[i]); //REORDENAMIENTO
            d0 =d0.substring(obj1.vueltas[i],d0.length())+ d0.substring(0, obj1.vueltas[i]);//REORDENAMIENTO
            
            System.out.println("c"+(i+1)+" "+c0);
            System.out.println("d"+(i+1)+" "+d0);                 
            //posiciona las cs respecto a la segunda caja de permutacion
            
            for(int e=0;e<(obj1.cajadepermutacion2.length);e++)
            {
                permutacionc += c0.charAt(obj1.cajadepermutacion2[e]-1);
            }
            //posiciona las d respecto a la segunda caja de permutacion
            for(int z=0 ; z<(obj1.cajadepermutacion2d.length);z++)
            {
                permutaciond += d0.charAt(obj1.cajadepermutacion2d[z]-29);
            }     
            llave[i] = permutacionc+permutaciond;
            String opta = llave[i];
            obj1.setK(llave);
            System.out.println("Clave"+(i+1)+" "+opta);
        }
    }
     
}
