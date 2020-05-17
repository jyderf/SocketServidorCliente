import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		
                MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
}

class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(100,25,680,720);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
	}	
}

class LaminaMarcoCliente extends JPanel {
    
        private	JTextArea areatextocliente;	
	private JTextField campo1,campo2;
	private JButton miboton;
        String ipServidor = "192.168.1.9"; 
        int puerto = 9999;
        
        public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("NOMBRE ARCHIVO");
		add(texto);
	
		campo1=new JTextField(10);
                add(campo1);
                
                JLabel texto2=new JLabel("                                                 NUEVO NOMBRE");
		add(texto2);
	
		campo2=new JTextField(10);
                add(campo2);
                
                miboton=new JButton("Listar Archivos");
                Listar mievento=new Listar();
                miboton.addActionListener(mievento);
                add(miboton);
                            
                miboton=new JButton("            Borrar             ");
                BuscarBorrar mievento3=new BuscarBorrar();
                miboton.addActionListener(mievento3);
		add(miboton);
                
                 miboton=new JButton("     Renombrar      ");
                BuscarRenombrar mievento2=new BuscarRenombrar();
                miboton.addActionListener(mievento2);
		add(miboton);
                
                 miboton=new JButton("     Limpiar Pantalla      ");
                LimpiarPantalla mievento5=new LimpiarPantalla();
                miboton.addActionListener(mievento5);
		add(miboton);
               
                areatextocliente=new JTextArea(50,50);
                add(areatextocliente);
                setVisible(true);
                
               // Thread mihilo = new Thread (this);
               // mihilo.start();
        }
        
        /*
        public void run(){////////////HILO PARA ESTAR SIEMPRE A LA ESCUCHA
            
             try{   ServerSocket cliente = new ServerSocket(puerto); //escucha en el puerto 9999 CREADO
                                            
                    while(true){
                        
                        Socket socketcliente = cliente.accept();//le digo q me acepte lo del servidor
                        DataInputStream respuesta = new DataInputStream (socketcliente.getInputStream());
                        String mensaje_texto = respuesta.readUTF();
                        areatextocliente.append(mensaje_texto);
                    }
                            
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    }
        }/////////////////////////////HILO PARA ESTAR SIEMPRE A LA ESCUCHA
	*/
        
        private class LimpiarPantalla implements ActionListener {
            
                @Override
                public void actionPerformed(ActionEvent e) {
            
                    areatextocliente.setText("");  
                }
        }
        
        
	private class Listar implements ActionListener {
            
                @Override
                public void actionPerformed(ActionEvent e) {
            
                    try {   areatextocliente.setText("");  
                            Socket misocket = new Socket(ipServidor,puerto); //CREO EL SOCKET
                            DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                            flujo_salida.writeUTF("11111-"+"Machete+"+campo1.getText());
                            
                            DataInputStream respuesta = new DataInputStream(misocket.getInputStream());
                            String mensaje_texto = respuesta.readUTF();
                            areatextocliente.append(mensaje_texto);
                        } 
                        catch (IOException e1) {
                            System.out.println(e1.getMessage());
                        }
                }
        }
        

        
         private class BuscarBorrar implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
            
                    try {    if(campo1.getText().length()==0){
                                JOptionPane.showMessageDialog(null, "El campo texto vacío");
                                return;
                            }
                            areatextocliente.setText("");
                            Socket misocket = new Socket(ipServidor,puerto); //CREO EL SOCKET
                            DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                            flujo_salida.writeUTF("22222-"+campo1.getText());
                            
                            DataInputStream respuesta = new DataInputStream(misocket.getInputStream());
                            String mensaje_texto = respuesta.readUTF();
                            areatextocliente.append(mensaje_texto);
                    } 
                    catch (IOException e1) {
                            System.out.println(e1.getMessage());
                        }
                }
        }
         
        
        private class BuscarRenombrar implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                try {    
                        if((campo1.getText().length()==0)&&(campo2.getText().length()==0)||((campo1.getText().length()==0)||(campo2.getText().length()==0)))
                            {
                                JOptionPane.showMessageDialog(null, "Digita los dos campos");
                                return;
                            }
                            areatextocliente.setText("");
                            Socket misocket = new Socket(ipServidor,puerto); //CREO EL SOCKET
                            DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                            flujo_salida.writeUTF("33333-"+campo1.getText()+","+campo2.getText());
                            
                            DataInputStream respuesta = new DataInputStream(misocket.getInputStream());
                            String mensaje_texto = respuesta.readUTF();
                            areatextocliente.append(mensaje_texto);
                          
                    }
                    catch (IOException e1) {
                                System.out.println(e1.getMessage());
                            }
            }
        }
        
}

