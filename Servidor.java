import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor  {

	public static void main(String[] args) {
		
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }	
}

class MarcoServidor extends JFrame implements Runnable{
    
    private JTextArea areatextoservidor;
	
	public MarcoServidor(){
		
		setBounds(900,5,280,600);				
                JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
           		
		areatextoservidor=new JTextArea();
		
		milamina.add(areatextoservidor,BorderLayout.CENTER);
		add(milamina);
                setVisible(true);
                Thread mihilo = new Thread(this);
                mihilo.start();
        }
	
//////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	

    @Override
    public void run() { 
                     
        try {   ServerSocket servidor = new ServerSocket(9999); //escucha en el puerto 9999 CREADO
                
                while(true){// No es necesario el bucle par que vuelva a escuchar, porq es lo hace el HILO
                    
                    Socket misocket = servidor.accept();//le digo q me acepte lo del servidor
                    DataInputStream flujo_entrada = new DataInputStream (misocket.getInputStream());
                    String mensaje_texto = flujo_entrada.readUTF();
                    
                    String sCadena = mensaje_texto;
                    String sCadenaInvertida="";
                    for (int x=sCadena.length()-1;x>=0;x--){
                            sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
                    }
                     
                    String[] parts = sCadenaInvertida.split("-");////////extrae los nùmeros a partir del caracter -
                    
                    String valor_nulo = parts[0];//este no se utilizarà
                    String codigo_seleccionado = parts[1];
            
     ///////////// INICIO 11111 INICIO INICIO 11111 INICIO INICIO 11111 INICIO INICIO 11111 INICIO INICIO 11111 INICIO INICIO 11111 INICIO INICIO 11111 INICIO 
                    if("11111".equals(codigo_seleccionado)){
                        
                            String[] partes = mensaje_texto.split("-");/////////EXTRAE LAS LETRAS A PARTIR DEL CARACTER
                    
                            String valor_vacio    = partes[0];
                            String nombre_ingresado = partes[1]; ////VALOR PARA OPCIÒN 2 SI TIENE UN NOMBRE SI TIENE DOS PASARÀ POR LA SIGUIENTE INVERSIÒN

                            areatextoservidor.setText("");
                            ///////////////////////////////////////////////inicio buscador archivos  
                            int contador1=0;
                            int contadorarchivos=1;
                            int contadorExistencia=0;
                            String ext = "";
                            File carpeta = new File("/../home/nombre1/Documentos");
                            File[] archivos;
                            if(carpeta.exists()) {
                        
                            if(carpeta.isDirectory()) {
                            
                                archivos = carpeta.listFiles();
                                for(int i=0; i<archivos.length; i++) {
                                    
                                        if(archivos[i].isFile()){
                                            
                                                if((archivos[i].getName().endsWith(ext))) {
                                            
                                                    if(contador1==0){
                                                
                                                        areatextoservidor.append("\n\n\n LISTA DE ARCHIVOS EN LA RUTA     /../home/nombre1/Documentos: \n");
                                                        contador1++;
                                                    }
                                                    
                                                    
                                            
                                                    areatextoservidor.append("\n"+contadorarchivos+".                " + archivos[i].getName()+"");
                                                    contadorarchivos++;
                                                    contadorExistencia++;
                                                }
                                          
                                        }
                                    }
                                if(contadorExistencia==0){areatextoservidor.append("\nERROR:  No hay existencia de archivos en  /../home/nombre1/Documentos/ ");}
                                }
                            }
                    
                    }
     //////////////  FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 111111 FIN   FIN 
                    
                    
     ///////2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 2222 INICIO 
                    if("22222".equals(codigo_seleccionado)){
                        
                            String[] partes = mensaje_texto.split("-");/////////EXTRAE LAS LETRAS A PARTIR DEL CARACTER
                    
                            String valor_vacio    = partes[0];
                            String nombre_ingresado = partes[1]; ////VALOR PARA OPCIÒN 2 SI TIENE UN NOMBRE SI TIENE DOS PASARÀ POR LA SIGUIENTE INVERSIÒN
                           
                            areatextoservidor.setText("");
                           
                            ///////////////////////////////////////////////inicio buscador archivos  
                            int contador1=0;
                            int contadorarchivos=1;
                            String ext = "";
                            File carpeta = new File("/../home/nombre1/Documentos/");
                            File[] archivos;
                            
                            if(carpeta.exists()) {
                                
                                File archivoBorrar = new File("/../home/nombre1/Documentos/"+nombre_ingresado+"");///////////ENSAYAR
                                
                                if(archivoBorrar.exists()){
                                
                                    archivoBorrar.delete();////////////////ENSAYAR 
                                    areatextoservidor.append("\n  =>   -----------"+nombre_ingresado+"----------- Se ha eliminado Documentos\n\n");
                                
                                }/////////ENSAYAR
                                else
                                {
                                   areatextoservidor.append("\n   =>   -----------"+nombre_ingresado+"----------- No existe en Documentos: \n"); 
                                }   
                                    if(carpeta.isDirectory()) {
                            
                                        archivos = carpeta.listFiles();
                                        
                                            for(int i=0; i<archivos.length; i++) {
                                    
                                                if(archivos[i].isFile()){
                                            
                                                    if((archivos[i].getName().endsWith(ext))) {
                                                
                                                        if((archivos[i].getName().endsWith(ext))) { //con punto.equals hacia adelante le pregunto si es igual a nombre_ingresado
                                                   
                                                    
                                                            if(contador1==0){
                                                
                                                                areatextoservidor.append("\n\n ARCHIVO DISPONIBLES: \n\n");
                                                                contador1++;
                                                            }
                                                    
                                                            areatextoservidor.append("\n"+contadorarchivos+".                " + archivos[i].getName()+"");
                                                            contadorarchivos++;
                                                    
                                            
                                                    
                                                        }   
                                                    }
                                                }
                                                
                                            }
                                            
                                    }
                            }
                    }
   //////////22222 FIN 22222 FIN 2222 2222 FIN 22222 FIN 2222 2222 FIN 22222 FIN 2222 2222 FIN 22222 FIN 2222 2222 FIN 22222 FIN 2222 2222 FIN 22222 FIN 2222                
                    
                    
   //////////////////3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 3333 INICIO 3333 
                    
                    if("33333".equals(codigo_seleccionado)){
                        
                            String[] partes = mensaje_texto.split("-");/////////EXTRAE LAS LETRAS A PARTIR DEL CARACTER
                    
                            String valor_vacio    = partes[0];
                            String nombre_ingresado = partes[1]; ////VALOR PARA OPCIÒN 2 SI TIENE UN NOMBRE SI TIENE DOS PASARÀ POR LA SIGUIENTE INVERSIÒN
                    
                    
                            String dos_nombres = nombre_ingresado;  ////ESTE ES PARA LA TERCERA OPCIÒN RENOMBRAR
                     
                            String[] nombre_nuevo = dos_nombres.split(",");
                    
                            String valornulo2=nombre_nuevo[0];
                            String nombre_poner = nombre_nuevo[1];
                     
                            String nombres_invertidos="";
                            for (int x=dos_nombres.length()-1;x>=0;x--){
                                    nombres_invertidos = nombres_invertidos + dos_nombres.charAt(x);
                            }
                    
                                        
                            String[] nombreuno_invertido = nombres_invertidos.split(",");
                    
                            String valornulo3=nombreuno_invertido[0];
                            String nombreuno_reves=nombreuno_invertido[1];
                            
                    
                            String nombreOriginal="";
                            for (int x=nombreuno_reves.length()-1;x>=0;x--){
                                    nombreOriginal = nombreOriginal + nombreuno_reves.charAt(x);
                            }
                    
                            areatextoservidor.setText("");
                   
                            ///////////////////////////////////////////////inicio buscador archivos  
                            int contador1=0;
                            int contadorarchivos=1;
                            String ext = "";
                            File carpeta = new File("/../home/nombre1/Documentos/");
                            File[] archivos;
                            if(carpeta.exists()) {
                                
                                int banderaExistecia = 0;
                                File archivoEditar = new File("/../home/nombre1/Documentos/"+nombreOriginal+"/");
                                if(archivoEditar.exists()){
                                      
                                    banderaExistecia = 1;                              
                                    if(archivoEditar.renameTo(new File ("/../home/nombre1/Documentos/"+nombre_poner+"/")));//////ENSAYANDO renombrar 33333333333333333
                                }
                                else {  areatextoservidor.append("\n\n      =>   -----"+nombreOriginal+"-----   No existe en Documentos \n"); 
                                    } 
                                                                            
                                if(carpeta.isDirectory()) {
                            
                                    archivos = carpeta.listFiles();
                                    for(int i=0; i<archivos.length; i++) {
                                    
                                        if(archivos[i].isFile()){
                                          
                                            if((archivos[i].getName().endsWith(ext))) {
                                            
                                                if((contador1==0)&&(banderaExistecia==1)){
                                                
                                                    areatextoservidor.append("\n\n El archivo:  =>  ----"+nombreOriginal+"------,  se ha renombrado por  =>  -----"+nombre_poner+"-----------   \n");
                                                    contador1++;
                                                }
                                                areatextoservidor.append("\n"+contadorarchivos+".               " + archivos[i].getName()+"");
                                                contadorarchivos++;
                                            }
                                        }
                                    }
                                }
                            }
                      }
 //////////////////////////////// FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 FIN 3333 
                    
                        
 // Extraemos los Streams de entrada y de salida
 
 
                   // Socket socketservidor = new Socket("192.168.1.5",9999); //CREO EL SOCKET
                   
                    DataOutputStream flujo_respuesta = new DataOutputStream(misocket.getOutputStream());
                    flujo_respuesta.writeUTF(areatextoservidor.getText());
                                     
                }//FIN WHILE
                     
            } catch (IOException ex) {
                    Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            
    }
//////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//////////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
}

