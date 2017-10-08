/*
 * Bueno Rosas Brayan Omar 
   5IM8
    Version 1.0
 */

package clavesdes;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Bueno Rosas Brayan Omar
 */
public class Cifradodes {
    Scanner leer = new Scanner(System.in); // Declaracion del scaneer para poder ingresar datos
    
    private String clavetextbin;
    private String clavetextpermut = "";
    String clvhx="";
    Clave obj1= new Clave(); //Instancia de la clase principal
    String permuta(){   //Permutacion de la IP
        System.out.println("¿Que tipo de dato desea ingresar decimal o hexadecimal?");
        String resp=leer.next();
      
        if (resp.equals("decimal")) {    // Se piden datos y se valida 
            System.out.println("Ingresa el texto a cifrar");
            clvhx=leer.next();
            clavetextbin=decimal(clvhx);  //Se llama al metodo decimal que permite ingresar decimales
           
        }else if(resp.equals("hexadecimal")){  //hexadecimal
        System.out.println("Ingresa el texto a cifrar");
        clvhx=leer.next();
        
       
        while(clvhx.length()!=16){
            System.out.println("Ingresa una clave hexadecimal valida");
             clvhx=leer.next();
        }
        
         Clave obj = new Clave(clvhx);//Construye la clave en binario
        
        clavetextbin=obj.getClaveenbinariotext();   //Obtiene la clave en binario 
        }
            
        
       System.out.println("Texto en binario: "+clavetextbin);
       
        for (int i = 0; i < (obj1.cajadepermutacionip.length); i++) {    //Se recorre un arreglo para hacer la permutacion 
                                                
            clavetextpermut+=clavetextbin.charAt(obj1.cajadepermutacionip[i]-1);
        }
        
        //System.out.println("Permutacion: "+clavetextpermut);
        return clavetextpermut;
    }
    public String decimal(String a){ //metodo para transformar decimales
        String clavebinary="";
        BigInteger  bin  = new BigInteger(a);   //se instancia la clase biginteger
       String NumeroPrueba = bin.toString(2);  //se transforma a un binario
        Boolean mensaje = false;  //booleano que indicara el sigo del numero
        String aux="";
        
        for(int i = 0; i < NumeroPrueba.length(); i++)
        {
            if(NumeroPrueba.charAt(i) == '-')
            {                                       //metodo para revisar el signo
                mensaje = true; 
            }
        }
        
        if(mensaje == true)      
        {                           //Instrucciones si es un numero negativo
           /// System.out.println("Existe un signo");
            String cadena = NumeroPrueba.substring(1,NumeroPrueba.length()); //se toma un pedazo del numero como positivo
            NumeroPrueba=cadena;
            while((NumeroPrueba.length())<64){   //se garantiza la longitud
                String aux1="0"+NumeroPrueba;
                NumeroPrueba=aux1;
            }
        //    System.out.println("penultimarecta"+NumeroPrueba);
            for (int i = 0; i < NumeroPrueba.length(); i++) {   //se realiza el not 
                if(NumeroPrueba.charAt(i) == '1')
                {
                aux+="0";
                }else if(NumeroPrueba.charAt(i) == '0'){
                    aux+="1";
                }
                
            }
           //  NumeroPrueba=aux;
           NumeroPrueba=aux.substring(0,aux.length()-1);  //se agrega uno para obtener el negativo
            if ((aux.charAt(aux.length()-1))=='1') {
              NumeroPrueba=NumeroPrueba+"0";
            }else{
             NumeroPrueba=NumeroPrueba+"1";
            }
            
          clavebinary=NumeroPrueba;// se iguala al string que se devolvera 
         //   System.out.println("Aqui"+clavebinary);
        }else{
        
        if(NumeroPrueba.length() > 64)
        {
            //System.out.println("Nel, mayor no");
        }else{
          System.out.println(NumeroPrueba);
           while(NumeroPrueba.length()<64){   // se valida el tamaño de la cadena
                String aux1="0"+NumeroPrueba;
                NumeroPrueba=aux1;
            }
          clavebinary=NumeroPrueba;   // se iguala al string que devolvera
       }
        }
        
        
        
        return clavebinary;
    }
}
