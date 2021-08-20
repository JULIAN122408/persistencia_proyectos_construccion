package Vista;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;


import java.awt.event.*;

import java.awt.BorderLayout;


import Controlador.ElControladorDeRequerimientos;
//import Modelo.dao.*;
import Modelo.vo.Requerimiento_3;
import Vista.Requerimiento3;


public class Requerimiento3 extends JFrame implements ActionListener {

    JButton boton;
    
    public Requerimiento3() throws SQLException {
        initUI();
    }


    public void initUI () throws SQLException {

        setLayout(new BorderLayout());
        String[]nombres={"Proveedor","Pagado","Constructora"};
        JTable tabla = new JTable(mostrar(), nombres ); 
        JScrollPane panel = new JScrollPane(tabla);
        
        add(panel, BorderLayout.CENTER);

        this.boton = new JButton("Fin de informe");
        this.boton.setBounds(10, 50,100, 30);
        add(this.boton, BorderLayout.PAGE_END);  
        this.boton.addActionListener(this);
        this.boton.setEnabled(true);

        setSize(1000, 450);
        setLocationRelativeTo(null);
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

    }


    //metodo

    public String[][] mostrar() throws SQLException{
        ArrayList<Requerimiento_3> lista = new ArrayList<Requerimiento_3>();
        //Requerimiento_1Dao requerimiento_1 =new Requerimiento_1Dao();
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        lista = controlador.consultarRequerimiento3();
        String matris[][]= new String [lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            
            matris[i][0]=lista.get(i).getProveedor();
            matris[i][1]=lista.get(i).getPagado();
            matris[i][2]=lista.get(i).getConstructora();
            
        }
        return matris;  
    }


   @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == this.boton ){
    
            System.exit(0);
            
    } 
    
    }

}