package org.fedi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyList extends JFrame {

    private MyDataBase database;
    private Graphics2D graph;
    private DefaultTableModel model;

    public MyDataBase getDatabase() {
        return database;
    }

    public Graphics2D getGraph() {
        return graph;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public MyList() {
        String data[][] = {};
        String column[] = {"Id", "Nom", "Genre"};

        model = new DefaultTableModel(data, column);
        // remplir la table
        database = new MyDataBase();
        database.remplirTab(model);

        // cree un tableau
        JTable table = new JTable(model);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);

        // ajouter le tableau a la fenetre
        JScrollPane pane = new JScrollPane(table);
        JFrame f = new JFrame("Examen");
        JPanel panel = new JPanel(new GridLayout(2, 1));
        // cree un panel pour le graph
        JPanel graphP = new JPanel(new FlowLayout());
        graphP.setBackground(Color.BLACK);
        panel.add(pane);
        f.add(panel);
        panel.add(graphP);
        pane.setBorder(BorderFactory.createTitledBorder("Liste des utilisateurs"));
        f.setSize(800, 700);
        f.setLocation(0,0);
        f.setVisible(true);

        graph = (Graphics2D) graphP.getGraphics();
        var thread = new MyThread(this);
        thread.start();
    }
}
