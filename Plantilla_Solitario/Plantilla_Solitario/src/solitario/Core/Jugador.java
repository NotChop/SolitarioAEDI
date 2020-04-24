/*
 * Representa al único jugador de la partida, identificado por el nombre 
 * Funcionalidad: le da la vuelta a una carta que está boca abajo, escoge una carta para moverla o al montón de descarte
 *                o la mueve encima de otra carta del interior
 */
package solitario.Core;

import java.util.Scanner;

/**
 *
 * @author AEDI
 */
public class Jugador {

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;              //Introducimos el nombre del tipiño
    }

    //En este método el jugador escoge la carta que quiere mover y la mueve a un moton interior o exterior.
    //Se usa un menú donde tiene las opciones
    public void CartaAMover(Mesa mesa, int filaO, int columnaO) /**throws Exception*/ {
        Scanner entrada = new Scanner (System.in);
        
        
        Carta actual = mesa.getCartaZonaInterior(filaO, columnaO);
        int opcion;
        int filaD;
        int columnaD;
        int pos;

        
        opcion = Integer.parseInt(entrada.nextLine());
        
            
        while ((opcion < 1) && (opcion > 2)) {
         System.out.println("solo hay 2 opciones?\n"
                + "1. Zona Interior\n"
                + "2. Monton Exterior\n");
            opcion = Integer.parseInt(entrada.nextLine());
        }
            
        
        

        switch (opcion) {
            case 1:
                System.out.println("\nEscoja la posición interior a donde debe mover la carta: ");
//                try {
//                System.out.println("\nLa fila de destino es: ");
//                    do {
//                        
//                        filaD = Integer.parseInt(entrada.nextLine());
//                        if ((filaD < 1) && (filaD > 4)) {
//                            throw new Exception( "Solo hay 4 filas, posición no valida\n "
//                            + "vuelve a introducir la posición: " );
//                        }
//                        
//                    }while ((filaD < 1) && (filaD > 4));
//                }catch(Exception exc)
//            {
//                System.err.println( "ERROR: " + exc.getMessage() );
//            }
                
                System.out.println("\nEscoja la posición interior a donde debe mover la carta: ");
                
                System.out.println("\nLa fila de destino es: ");

                filaD = Integer.parseInt(entrada.nextLine());

                while ((filaD < 1) && (filaD > 4)) {
                    System.out.println("Solo hay 4 filas, posición no valida\n "
                            + "vuelve a introducir la posición: ");
                    filaD = Integer.parseInt(entrada.nextLine());
                }
                
                
                
//                try {
//                System.out.println("\nLa columna de destino es: ");
//                    do {
//                        System.out.println("\nLa columna de destino es: ");
//                        columnaD = Integer.parseInt(entrada.nextLine());
//                        if ((columnaD < 1) && (columnaD > 4)) {
//                            throw new Exception( "Solo hay 4 columnas, posición no valida\n "
//                            + "vuelve a introducir la posición: " );
//                        }
//                        
//                    }while ((columnaD < 1) && (columnaD > 4));
//                }catch(Exception exc)
//            {
//                System.err.println( "ERROR: " + exc.getMessage() );
//            }

                columnaD = Integer.parseInt(entrada.nextLine());

                while (columnaD < 1 || columnaD > 4) {
                    System.out.println("Solo hay 4 columnas, posición no valida\n "
                            + "vuelve a introducir la posición: ");
                    columnaD = Integer.parseInt(entrada.nextLine());
                }

                mesa.ponerEnMontonInterior(actual, filaO, columnaO, filaD, columnaD);
                break;
                
                
            case 2:
//                System.out.println("\nEscoja la posicion del monton exterior a donde debe mover la carta:  ");
//                try {
//                    do {
//                        pos = Integer.parseInt(entrada.nextLine());
//                        if ((pos < 1) && (pos > 4)) {
//                            throw new Exception( "Posición incorrenta \nvuelve a introducir la posición");
//                        }
//                    } while ((pos < 1) && (pos > 4));
//                }catch(Exception exc){
//                System.err.println( "ERROR: " + exc.getMessage() );
//            }
                
                
                System.out.println("\nEscoja la posicion del monton exterior a donde debe mover la carta:  ");
                pos = Integer.parseInt(entrada.nextLine());
                while (pos < 1 && pos > 4) {
                    System.out.println("Posición incorrenta \nvuelve a introducir la posición");
                    pos = Integer.parseInt(entrada.nextLine());
                }
                mesa.ponerEnMontonExterior(actual, pos, filaOrigen, columnaOrigen);
                break;
            
        }
        
            

    }
    
    
    
    
    public Carta darlavuelta (Mesa mesa, int fila, int columna) {
        Carta actual = mesa.getCartaZonaInterior(fila, columna);
        return actual;
        
    }
    
    

}
