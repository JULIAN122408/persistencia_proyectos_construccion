package Vista;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;


import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.color.*;


import Controlador.ElControladorDeRequerimientos;

//import Modelo.dao.*;
import Modelo.vo.Requerimiento_1;

public class Requerimiento1 extends JFrame implements ActionListener {

    JButton boton;
    JFrame marco;
    
    public Requerimiento1() throws SQLException {
        initUI();
    
    }

    


    public void initUI () throws SQLException {

        setLayout(new BorderLayout());
        String[]nombres={"Ciudad","Acabados","Clasificacion","Banco_Vinculado","Constructora"};
        JTable tabla = new JTable(mostrar(), nombres ); 
        JScrollPane panel = new JScrollPane(tabla);

        
        add(panel, BorderLayout.CENTER);

        this.boton = new JButton("Siguiente Informe");
        this.boton.setBounds(10, 50,100, 30);
        add(this.boton, BorderLayout.PAGE_END);  
        this.boton.addActionListener(this);
        this.boton.setEnabled(true);
        this.boton.setBackground(Color.GREEN);
        this.boton.setOpaque(false);

   
        setBackground(Color.yellow);
        setSize(1000, 450);
        setLocationRelativeTo(null);
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

    }




    //metodo

    public String[][] mostrar() throws SQLException{
        ArrayList<Requerimiento_1> lista = new ArrayList<Requerimiento_1>();
        //Requerimiento_1Dao requerimiento_1 =new Requerimiento_1Dao();
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        lista = controlador.consultarRequerimiento1();
        String matris[][]= new String [lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            
            matris[i][0]=lista.get(i).getCiudad();
            matris[i][1]=lista.get(i).getAcabados();
            matris[i][2]=lista.get(i).getClasificacion();
            matris[i][3]=lista.get(i).getBanco_Vinculado();
            matris[i][4]=lista.get(i).getConstructora();
        }
        return matris;  
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == this.boton ){
        
        try {
            Requerimiento2 reque2 = new Requerimiento2();
        } catch (SQLException e1) {
            
            e1.printStackTrace();
        }
            
    } 
    
    }

}