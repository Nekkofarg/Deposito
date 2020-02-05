/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dam_ed04_actividad;

import com.csvreader.CsvWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        CCuenta cuenta1;
        
        
        cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        operativa_cuenta(cuenta1);
        WriteCSV();

    }
    public static void operativa_cuenta(CCuenta cuenta1){
        
        float cantidad;
        double saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es"+ saldoActual );

        try {
            cuenta1.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
    
    public static void WriteCSV() throws IOException{
        ArrayList<CCuenta>  lista =  new ArrayList();
        
        try{
            lista.add(new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0));
            lista.add(new CCuenta("Antonio","1020-2355-15-1230456789",500,0));
            lista.add(new CCuenta("Tania Fariña González", "1020-2355-15-1230456729", 3000, 0));
         
        }catch(Exception e){
            System.out.println("No se ha podido cargar la listas");
        }
        
        CsvWriter csvwriter = new CsvWriter("Depositos.csv");
        
        for(CCuenta cuenta : lista){
            String [] datos = cuenta.getArray();
            csvwriter.writeRecord(datos);
        }
        
        csvwriter.close();
    }
}
