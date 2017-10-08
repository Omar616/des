/*
 * Bueno Rosas Brayan Omar 
   5IM8
    Version 1.0
 */

package clavesdes;
import java.util.Scanner;
//133457799BBCDFF1
/**
 *
 * @author Bueno Rosas Brayan Omar
 */
public class Clave {
    Scanner leer = new Scanner(System.in);
    private String clvhx="";
   
    int[] Primeracajadepermutacion = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
    int vueltas[]={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1}; 
    int cajadepermutacion2 []={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2};
    int cajadepermutacion2d[]={41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
   
    int cajadepermutacionip[]={58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
    String claveenbinariotext="";
    int permutacionr0[]={32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
    int permutacionp[]={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
    
    int permutacionfin[]={40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};
    public int[] getCajadepermutacionip() {
        return cajadepermutacionip;
    }

    public int[] getPermutacionr0() {
        return permutacionr0;
    }

     
    
   
    
    Clave(){
        
    }
    
    Clave(String texto){
        
        int valordecimal;
        String Valorbinario="";
        String valorreal="";
        String aux="";
        
        for(int i = 0;i<texto.length(); i++)
        {
            valordecimal=Integer.parseInt(String.valueOf(texto.charAt(i)),16);
            Valorbinario = Integer.toBinaryString(valordecimal);
            if (Valorbinario.length()==1) {
                 aux="000"+Valorbinario;
            }else if(Valorbinario.length()==2){
                aux="00"+Valorbinario;
            }else if (Valorbinario.length()==3){
                aux="0"+Valorbinario;
            }else if(Valorbinario.equals("0")){
                aux="0000"+Valorbinario;
            }else{
                aux=Valorbinario;
            }
            
            
            valorreal=valorreal+aux;
             
        }
        claveenbinariotext=valorreal;
        //System.out.println("Texto plano: "+claveenbinariotext);
    }

    public String getClaveenbinariotext() {
        return claveenbinariotext;
    }
      
    
    
    public int[] getVueltas() {
        return vueltas;
    }
    public int[] getCajadepermutacion2() {
        return cajadepermutacion2;
    }
    public int[] getCajadepermutacion2d() {
        return cajadepermutacion2d;
    }
    public int[] getPrimeracajadepermutacion() {
        return Primeracajadepermutacion;
    }

  

    
    public String binclav(){
        System.out.println("Bienvenido al cifrado");
        System.out.println("Ingresa la clave");
        clvhx=leer.next();
        
        while(clvhx.length()!=16){
            System.out.println("Ingresa una clave hexadecimal valida");
             clvhx=leer.next();
        }
        String claveenbinario="";
        int valordecimal;
        String Valorbinario="";
        String valorreal="";
        String aux="";
        
        for(int i = 0;i<clvhx.length(); i++)
        {
            valordecimal=Integer.parseInt(String.valueOf(clvhx.charAt(i)),16);
            Valorbinario = Integer.toBinaryString(valordecimal);
            if (Valorbinario.length()==1) {
                 aux="000"+Valorbinario;
            }else if(Valorbinario.length()==2){
                aux="00"+Valorbinario;
            }else if (Valorbinario.length()==3){
                aux="0"+Valorbinario;
            }else{
                aux=Valorbinario;
            }
            
            
            valorreal=valorreal +aux;
             
        }
        claveenbinario=valorreal;
        //System.out.println("Clave secreta en binario");
       // System.out.println(claveenbinario);
        return claveenbinario;
    }
    
    
    
    
    
    
    
    
}
