import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        //String[] newColumn= {"Flan","Pastel","Helado","Barquillo","Manzana" };
        //dtm.addColumn("Postre",newColumn);


        //Object[] newRow={"Pepe", "Grillo","Tenis", new Integer(5), new Boolean(false),       "Pera"};
        //dtm.addRow(newRow);

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
        //array bidimencional de objetos con los datos de la tabla
	      /*String[][] data = {{"Daniel", "Villar","Esquiar"},
	       {"Carlos", "Villar","Patinar"},
	       {"Karinna", "Villar","Escalar"},
	       {"Mario", "Diaz","Correr"},
	       {"Sylvia", "Uribe","Modelar"}};*/



        //https://swapi.dev/

    }}
