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
public class Clave {
    private String clvhx="133457799BBCDFF1";
    int[] Primeracajadepermutacion = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
    int vueltas[]={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1}; 
    int cajadepermutacion2 []={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2};
    int cajadepermutacion2d[]={41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
    String []k= new String [16];

    public String[] getK() {
        return k;
    }

    public void setK(String[] k) {
        this.k = k;
    }
     
     
    public int[] getVueltas() {
        return vueltas;
    }

    public void setVueltas(int[] vueltas) {
        this.vueltas = vueltas;
    }

    public int[] getCajadepermutacion2() {
        return cajadepermutacion2;
    }

    public void setCajadepermutacion2(int[] cajadepermutacion2) {
        this.cajadepermutacion2 = cajadepermutacion2;
    }

    public int[] getCajadepermutacion2d() {
        return cajadepermutacion2d;
    }

    public void setCajadepermutacion2d(int[] cajadepermutacion2d) {
        this.cajadepermutacion2d = cajadepermutacion2d;
    }
     
    public String getClvhx() {
        return clvhx;
    }

    public void setClvhx(String clvhx) {
        this.clvhx = clvhx;
    }

   

    public int[] getPrimeracajadepermutacion() {
        return Primeracajadepermutacion;
    }

    public void setPrimeracajadepermutacion(int[] Primeracajadepermutacion) {
        this.Primeracajadepermutacion = Primeracajadepermutacion;
    }
    
    public String binclav(){
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
        System.out.println("Clave secreta en binario"+claveenbinario);
        return claveenbinario;
    }
    
    
    
    
    
    
}
