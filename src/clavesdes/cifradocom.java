/*
 * Bueno Rosas Brayan Omar 
   5IM8
    Version 1.0
 */

package clavesdes;

import java.math.BigInteger;

/**
 *
 * @author Bueno Rosas Brayan Omar
 */
public class cifradocom {
    Cifradodes obj =new  Cifradodes();   //Instancia de las clases que anteceden 
    Clave obj1= new Clave(); //clase con todas las permutaciones
    public String permut=obj.permuta();
    public String L0=permut.substring(0, (permut.length()/2));    //se obtiene lo
    public String R0=permut.substring((permut.length()/2),permut.length()); //se obtiene ro
    String L[] = new String[18];                 //Variables que se utilizan
    String R[] = new String[18];
    Clavesk clvk =new Clavesk();
   
    
    void cifra(){
        clvk.calculak();   //se obtienen las llaves 
        
        L[0] =L0;
        R[0]=R0;
         
        // System.out.println("RO"+R0);
         
        for (int i = 0; i < clvk.k.length; i++) {
            
            String Ri=""; 
         //   System.out.println("tamaño"+L[i].length()+"R:"+R[i].length());
            
           L[i+1]=R[i];//se Li+1 toma el valor de R 
            for (int j = 0; j <(obj1.permutacionr0).length ; j++) { // Permutacion de ri
                Ri+=R[i].charAt(obj1.permutacionr0[j]-1);
                
            }
           // System.out.println("Ri"+Ri);
            
            BigInteger  bin  = new BigInteger(Ri,2);//ri en decimal
           // System.out.println("bin: "+bin);
            
            BigInteger  bon  = new BigInteger(clvk.k[i],2); //clave en decimal
           // System.out.println("Aqui"+bon);
            
            String  XOR=""+(bin.xor(bon)).toString(2); //se realiza el xor de ri y la clave
            //System.out.println("XOR"+XOR);
            
            while(XOR.length()<48){  //se valida el tamaño de la cadena
                String aux="0"+XOR;
                XOR=aux;
            }
            
            String permutRi=""+sBlock(XOR); //Se obtiene la sustitucion de la SBOX
            
            BigInteger  ban  = new BigInteger(permutRi,2);//Decimal de la permutacion de la sustitucion
          
            
            BigInteger  ben  = new BigInteger(L[i],2); //L en decimal
            
            String RI =""+(ban.xor(ben)).toString(2); //XOR que sera el Rí
            
             while(RI.length()<32){  //Validacion del 
                String aux="0"+RI;
                RI=aux;
            }
           // System.out.println("RI"+RI);
          
            R[i+1]=RI;
           // System.out.println("numero"+i);
            System.out.println("Cadenas: L"+(i+1)+":"+L[i+1]+"R"+(i+1)+":"+R[i+1]);
        }
          //System.out.println("Cadenas: L"+16+":"+L[16]+"R"+16+":"+R[16]);
          String cadena=R[16]+L[16];   //se obtiene el ultimo cambio
          String cifrado="";
          for (int i = 0; i < obj1.permutacionfin.length; i++) {// se realiza la permutacion final
            cifrado+=cadena.charAt(obj1.permutacionfin[i]-1);
        }
          System.out.println("Cifrado: "+cifrado);  
          
           BigInteger  cla  = new BigInteger(cifrado,2);  //se obtiene el binario
           String hexacla=""+cla.toString(16);// se obtiene el hez¿xadecimal
           while(hexacla.length()<16){
               String aux="0"+hexacla;    //se valida la longitud
                hexacla=aux;
           }
           System.out.println("Cifrado hexa"+hexacla);
           
    }
    public static final int[][][] S ={  //Cajas S de donde se obtendra la sustitución
            {
                {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            },
            {
                {15, 1,  8,  14, 6,  11, 3,  4,  9,  7,  2,  13, 12, 0,  5,  10},
                {3,  13, 4,  7,  15, 2,  8,  14, 12, 0,  1,  10, 6,  9,  11, 5},
                {0,  14, 7,  11, 10, 4,  13, 1,  5,  8,  12, 6,  9,  3,  2,  15},
                {13, 8,  10, 1,  3,  15, 4,  2,  11, 6,  7,  12, 0,  5,  14, 9}
            },
            {
                {10, 0,  9,  14, 6,  3,  15, 5,  1,  13, 12, 7,  11, 4,  2,  8},
                {13, 7,  0,  9,  3,  4,  6,  10, 2,  8,  5,  14, 12, 11, 15, 1},
                {13, 6,  4,  9,  8,  15, 3,  0,  11, 1,  2,  12, 5,  10, 14, 7},
                {1,  10, 13, 0,  6,  9,  8,  7,  4,  15, 14, 3,  11, 5,  2,  12}
            },
            {
                {7,  13, 14, 3,  0,  6,  9,  10, 1,  2,  8,  5,  11, 12, 4,  15},
                {13, 8,  11, 5,  6,  15, 0,  3,  4,  7,  2,  12, 1,  10, 14, 9},
                {10, 6,  9,  0,  12, 11, 7,  13, 15, 1,  3,  14, 5,  2,  8,  4},
                {3,  15, 0,  6,  10, 1,  13, 8,  9,  4,  5,  11, 12, 7,  2,  14}
            },
            {
                    {2,  12, 4,  1,  7,  10, 11, 6,  8,  5,  3,  15, 13, 0,  14, 9},
                    {14, 11, 2,  12, 4,  7,  13, 1,  5,  0,  15, 10, 3,  9,  8,  6},
                    {4,  2,  1,  11, 10, 13, 7,  8,  15, 9,  12, 5,  6,  3,  0,  14},
                    {11, 8,  12, 7,  1,  14, 2,  13, 6,  15, 0,  9,  10, 4,  5,  3}
            },
            {
                    {12, 1,  10, 15, 9,  2,  6,  8,  0,  13, 3,  4,  14, 7,  5,  11},
                    {10, 15, 4,  2,  7,  12, 9,  5,  6,  1,  13, 14, 0,  11, 3,  8},
                    {9,  14, 15, 5,  2,  8,  12, 3,  7,  0,  4,  10, 1,  13, 11, 6},
                    {4,  3,  2,  12, 9,  5,  15, 10, 11, 14, 1,  7,  6,  0,  8,  13}
            },
            {
                    {4,  11, 2,  14, 15, 0,  8,  13, 3,  12, 9,  7,  5,  10, 6,  1},
                    {13, 0,  11, 7,  4,  9,  1,  10, 14, 3,  5,  12, 2,  15, 8,  6},
                    {1,  4,  11, 13, 12, 3,  7,  14, 10, 15, 6,  8,  0,  5,  9,  2},
                    {6,  11, 13, 8,  1,  4,  10, 7,  9,  5,  0,  15, 14, 2,  3,  12}
            },
            {
                    {13, 2,  8,  4,  6,  15, 11, 1,  10, 9,  3,  14, 5,  0,  12, 7},
                    {1,  15, 13, 8,  10, 3,  7,  4,  12, 5,  6,  11, 0,  14, 9,  2},
                    {7,  11, 4,  1,  9,  12, 14, 2,  0,  6,  10, 13, 15, 3,  5,  8},
                    {2,  1,  14, 7,  4,  10, 8,  13, 15, 12, 9,  0,  3,  5,  6,  11}
            }

    };
    
    public String sBlock(String b){//Calculodevalores para sustituir
        int loli=0;
        String output="";
        for(int i=0;i<S.length;i++){
            String sixString = b.substring(i*6,(i+1)*6); //se parte la cadena
            String ab= ""+sixString.charAt(0)+sixString.charAt(sixString.length()-1);
            String med= sixString.substring(1,sixString.length()-1);   //se obtienen los valores de los extremos y el medio

           
            int[] col= S[i][Integer.parseInt(ab,2)];   // se obtiene las columnas
           

            String row =""+ (col[Integer.parseInt(med,2)]);  // se obtienen las filas
            
             loli= Integer.parseInt(row); // se transforma a decimal
             row="";
             row=Integer.toString(loli,2);  //se regresan a binario
             while(row.length()<4){
                String aux="0"+row;
                row=aux;
            }
            
            output+=row;  // se contruye la sustitucion
        }
        String tmp="";
      // tmp=output;
       
        
        for(int i=0;i<obj1.permutacionp.length;i++){ // se realiza la permutacion de la sustitucion
            tmp+=output.substring(obj1.permutacionp[i]-1,obj1.permutacionp[i]);
       }
      

        return tmp; //regresa la permutacion de r 

    }
    
   
    
}
