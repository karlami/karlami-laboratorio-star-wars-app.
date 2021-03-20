import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame {
    private Object[][] data;

    public void setData(Object[][] data){
        this.data = data;
        System.out.println("m "+data[0][0]);
    }

    public void crearTable(){
        String[] columnNames = {"Nombre","Altura","Nacimiento"};
        DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public Table() {

        super("Tabla de usuarios");


    }}
