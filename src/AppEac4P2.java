import java.util.Scanner;

public class AppEac4P2 {

    // CONSTANTES //
    
    //Mínimos y Máximos
    private static final int MAX_ALMACENAJE = 25000;
    private static final int MIN_VARIEDAD = 0;
    private static final int ENTRADA_MAX_ALMA = 1000;
    private static final int ENTRADA_MIN_ALMA = 0;    
    
    //Opciones Menú Principal
    private static final int OP_ENTRADA_RAIM = 1;
    private static final int OP_SORTIDA_RAIM = 2;
    private static final int OP_ESTADO_ALMACEN = 3;
    private static final int OP_SALIR = 4;
    
    private static final int SALIR = -1;
    
    
    private static final int OP_ALMACEN = 3;
    
    
    
    // FIN CONSTANTES //
    
    // CODIFICACIÓN FACILITADA POR EL INSTITUTO //
    String mVarietat[] = {"Ull de llebre","Garnatxa","Xarel·lo","Macabeu","Parellada"};
    int mQuantitat[]={0,0,0,0,0};
    int quantitatTotalRaim = 0;
    int compruebaQuantitat = quantitatTotalRaim;
    
    
    
    
    public static void main(String[] args) {
        
        AppEac4P2 prg = new AppEac4P2();
        prg.inici(); 
        
    }
    
    private void inici()
    {  
        int salir = 0;
        
        while(salir != SALIR)
        {
            int opMenu = menuPrincipal();
            salir = tratarOpMPrincipal(opMenu);            
        }
        
        
        
    }
    
    // PRIMER NIVEL //    
    private int menuPrincipal()
    {
        int opcion;
        System.out.printf("\n\n%25s\n%25s\n%25s\n\n",
                           "********************",
                           "*  MENÚ PRINCIPAL  *",
                           "********************");
        System.out.println("SELECIONA UNA OPCIÓN\n" +
                           "-------------------\n" + 
                           "1 - Entrada Raïm\n" +
                           "2 - Sortida Raïm\n" +
                           "3 - Mostrar Estado Almacén");
        if(quantitatTotalRaim != compruebaQuantitat)
        {
            System.out.println("4 - Salir");
        }
                        
        opcion = enteroRango(1,4);
        return opcion;
    }
    
    private int tratarOpMPrincipal(int opcion)
    {
        if(opcion == OP_ENTRADA_RAIM)
        {
            menuRaim(opcion);
        }else if(opcion == OP_SORTIDA_RAIM)
        {
            menuRaim(opcion);
        }else if(opcion == OP_ESTADO_ALMACEN)
        {
            estadoAlmacen();
        }else if(opcion == OP_SALIR)
        {
            opcion = SALIR;
        }
        
        return opcion;
    }    
    // FIN PRIMER NIVEL //
    
    
    // SEGUNDO NIVEL //    
    private void menuRaim(int entradaSalida)
    {
        compruebaQuantitat = quantitatTotalRaim;
        int cantidad = -1;
        
        if(entradaSalida == OP_ENTRADA_RAIM)
        {
            System.out.printf("\n\n%29s\n%29s\n%29s\n\n",
                               "************************",
                               "*  MENÚ RAÏM (Entrada) *",
                               "************************");
        }else if(entradaSalida == OP_SORTIDA_RAIM)
        {
            System.out.printf("\n\n%28s\n%28s\n%28s\n\n",
                               "***********************",
                               "*  MENÚ RAÏM (Salida) *",
                               "***********************");
        }
        
        System.out.println("VARIETAT\n" + 
                           "--------"); 
        imprimirAlmacen(entradaSalida);
        
        String variedad = variedad();
        if(!variedad.equalsIgnoreCase("volver"))
        {
            while(compruebaQuantitat == quantitatTotalRaim && cantidad != 0)
            {
                cantidad = enteroRango(ENTRADA_MIN_ALMA, ENTRADA_MAX_ALMA);
                if(entradaSalida == 1)
                {                
                    entradaRaim(variedad, cantidad);
                }else if(entradaSalida == 2)
                {
                    sortidaRaim(variedad, cantidad);
                }
            }
        }else
        {
            int volver = menuPrincipal();
            tratarOpMPrincipal(volver);
        }
        System.out.println("Entrado correcta.");
    }
    
    private void estadoAlmacen()
    {
        System.out.printf("\n\n%25s\n%25s\n%25s\n\n",
                           "********************",
                           "*  ESTADO ALMACÉN  *",
                           "********************");
        
        System.out.printf("%-20s%-20s\n%-20s%-20s\n",                                
                          "VARIETAT", "QUANTITAT",
                          "-------------", "---------"); 
        
        imprimirAlmacen(3);
    }
    // FIN SEGUNDO NIVEL //
    
    // TERCER NIVEL //
    private void imprimirAlmacen(int opcion)
    {               
        if(opcion == OP_ENTRADA_RAIM || opcion == OP_SORTIDA_RAIM)
        {
            
        }else if(opcion == OP_ESTADO_ALMACEN)
        {
            
        }
        for(int i = 0; i < mVarietat.length; i++)
        {
            if(opcion == OP_ENTRADA_RAIM || opcion == OP_SORTIDA_RAIM)
            {
                System.out.printf("- %-20s\n", mVarietat[i]);
            }else if(opcion == OP_ESTADO_ALMACEN)
            {
                System.out.printf("%-20S%-20d\n", mVarietat[i], mQuantitat[i]);
            }
        }
    }
    
    private String variedad()
    {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1");
        
        int posicion = 0;
        String varietat = "";
        boolean correcto = false; 
        
        while(!correcto)
        {
            System.out.print("\nIntroduce variedad: ");
            varietat = entrada.nextLine();
            if(varietat.equalsIgnoreCase("Volver"))
            {         
                correcto = true;              
                
            }else
            {
                posicion = posicioVarietat(varietat); 
                System.out.println(posicion);
                if(posicion == -1)
                {                
                    System.out.println("No se encuentra la variedad. ");                
                }else
                {
                    correcto = true;
                }
            }
        }
        
        return varietat;
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
            if(mVarietat[i].equalsIgnoreCase(varietat))
            {
               return i;
            }
        }
        return -1; //Si no hay coincidencia retornamos '-1'
        
    }   
    
    private int enteroRango(int rangInicial, int rangFinal)
    {
        Scanner entrada = new Scanner(System.in);
        boolean entero = false;
        boolean rango = false;
        int num = 0;
        
        while(!entero || !rango)
        {
            System.out.print("\nIntroduce Dato: ");
            entero = entrada.hasNextInt();
            if(entero)
            {
                num = entrada.nextInt();
                rango = rango(rangInicial,rangFinal, num);                
            }else
            {
                System.out.println("El dato no es un entero.");
                entrada.nextLine();
            }
        }
        return num;
    }
    
    private boolean rango(int rangInicial, int rangFinal, int num)
    {
        if((num >= rangInicial) && (num <= rangFinal))
        {
            return true;
        }else
        {
            System.out.println("Rango incorrecto, debe estar entre " + 
                                rangInicial + " y " + rangFinal + ".");
        }
        return false;
    }
    // FIN CUARTO NIVEL //
    
   
}
