import java.util.Scanner;

public class AppEac4P2 {

    // CONSTANTES //
    private static final int MAX_ALMACENAJE = 25000;
    private static final int MIN_VARIEDAD = 0;
    private static final int ENTRADA_RAIM = 1;
    private static final int SORTIDA_RAIM = 2;
    private static final int ESTADO_ALMACEN = 3;
    // FIN CONSTANTES //
    
    // CODIFICACIÓN FACILITADA POR EL INSTITUTO //
    String mVarietat[] = {"Ull de llebre","Garnatxa","Xarel·lo","Macabeu","Parellada"};
    int mQuantitat[]={0,0,0,0,0};
    int quantitatTotalRaim = 0;
    int compruebaQuantitat = quantitatTotalRaim;
    private boolean salir = false;
    
    
    
    public static void main(String[] args) {
        
        AppEac4P2 prg = new AppEac4P2();
        prg.inici(); 
        
    }
    
    private void inici()
    {      
        while(!salir)
        {
            menuPrincipal();
        }
    }
    
    // PRIMER NIVEL //    
    private void menuPrincipal()
    {
        System.out.println("\nMENU PRINCIPAL\n" 
                          +"--------------");
        System.out.println("1 - Entrada Raïm\n" +
                           "2 - Sortida Raïm\n" +
                           "3 - Mostrar Estado Almacén");
        if(quantitatTotalRaim != compruebaQuantitat)
        {
            System.out.println("4 - Salir");
        }
    }
    
    private void tratarOpMPrincipal()
    {
        
    }    
    // FIN PRIMER NIVEL //
    
    
    // SEGUNDO NIVEL //    
    private void menuRaim(int entradaSalida)
    {
        
    }
    
    private void estadoAlmacen()
    {
        
    }
    // FIN SEGUNDO NIVEL //
    
    // TERCER NIVEL //
    private void imprimirAlmacen(int opcion)
    {
        
    }
    
    private String variedad()
    {
        String varietat = "";
        
        return varietat;
    }
    
    private void cantVariedad(int posVariedad)
    {
        
    }
    
    //Método -> Verifica si hay sufiente espacio y existe variedad(posicioVarietat()) 
    private void entradaRaim(String varietat, int quantitat){
                     
        //Si cantidad total es <= 25000 verificaremos si existe varidad seleccionada        
        if((quantitatTotalRaim + quantitat) <= MAX_ALMACENAJE)
        {
            int posicion = posicioVarietat(varietat); //almacena 'return posicioVarietat()'
            //Si exite varidad, aumentamos kg (quantitat) en la posición que devuelve 'posicion'
            if(posicion != -1)
            {
                mQuantitat[posicion] += quantitat;    
                quantitatTotalRaim += quantitat;                
            }else //Si no se encuentra variedad mostramos mensaje de error.
            {
                System.out.println("No se encuentra la variedad. ");                
            }
        }else //Si se supera la cantidad máxima (25000) mostramos mensaje error.
        {  
            System.out.println("\nSuperada cantidad máxima (" + MAX_ALMACENAJE + "kg):");
            System.out.printf("%s\n%-20s%-20s%-20s\n%s\n%-20d%-20d%-20d\n\n",
                              "----------------------------------------------",                              
                              "Cant ALMA","Cant Entrada","SUMA",       
                              "----------------------------------------------",
                              (quantitatTotalRaim),quantitat, quantitatTotalRaim + quantitat);
            
        }  
        
    }
    
    //Método -> Verifica si hay sufiente espacio y existe variedad(posicioVarietat()) 
    private void sortidaRaim(String varietat, int quantitat){
                     
        int posicion = posicioVarietat(varietat); //almacena 'return posicioVarietat()'

        //Si cantidad total es <= 25000 verificaremos si existe varidad seleccionada        
        if((mQuantitat[posicion] - quantitat) >= MIN_VARIEDAD)
        {            
            //Si exite varidad, aumentamos kg (quantitat) en la posición que devuelve 'posicion'
            if(posicion != -1)
            {
                mQuantitat[posicion] -= quantitat;    
                quantitatTotalRaim -= quantitat;                
            }
            
        }else //Si se supera la cantidad máxima (25000) mostramos mensaje error.
        {  
            System.out.println("\nSuperada cantidad mínima (" + mQuantitat[posicion] + "kg):");
            System.out.printf("%s\n%-20s%-20s%-20s\n%s\n%-20d%-20d%-20d\n\n",
                              "----------------------------------------------",                              
                              "Cant Variedad", "Cant Entrada", "RESTA",       
                              "----------------------------------------------",
                              (mQuantitat[posicion]),quantitat, mQuantitat[posicion] - quantitat);
            
        }  
        
    }
    // FIN TERCER NIVEL //
    
    
    // CUARTO NIVEL //
    //Método verificación varidad
    private int posicioVarietat(String varietat){      
                
        //Recorremos 'mVarietat' para ver si hay coincidencia
        for(int i = 0; i < mVarietat.length; i++)
        {
            //Si hay coincidencia, retornamos valor 'i' (posición)
            if(mVarietat[i].equals(varietat))
            {
               return i;
            }
        }
        return -1; //Si no hay coincidencia retornamos '-1'
        
    }   
    
    private int enteroRango(int rangoInicial, int rangoFinal)
    {
        int num = 0;
        
        return num;
    }
    // FIN CUARTO NIVEL //
    
}
