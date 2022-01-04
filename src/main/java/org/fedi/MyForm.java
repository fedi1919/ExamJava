package org.fedi;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MyForm extends JFrame {
    // les libelles
    JLabel NomL = new JLabel("Nom");
    JLabel GenreL = new JLabel("Genre");
    JLabel ExamenL = new JLabel("Examen");

    //les TextFields
    JTextField NomT = new JTextField();

    // les Buttons
    JRadioButton Homme = new JRadioButton("Homme");
    JRadioButton Femme = new JRadioButton("Femme");
    ButtonGroup Bg = new ButtonGroup();
    JButton Ajouter = new JButton("ajouter");
    JButton Liste = new JButton("Liste");

    public MyForm() {
        super("Examen"); //titre de la fenetre

        ExamenL.setHorizontalAlignment(SwingConstants.CENTER);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel Pbtn = new JPanel();
        Pbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Pbtn.add(Liste);
        Pbtn.add(Ajouter);
        Homme.setSelected(true);
        Femme.setActionCommand("Femme");
        Homme.setActionCommand("Homme");
        Bg.add(Femme);
        Bg.add(Homme);
        JPanel Pradio = new JPanel(new GridLayout(1, 2));
        Pradio.add(Homme);
        Pradio.add(Femme);

        JPanel Pinfo = new JPanel(new GridLayout(2, 2));
        var pinfoBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        var b = BorderFactory.createTitledBorder(pinfoBorder, "informations");
        Pinfo.setBorder(b);
        Pinfo.add(NomL);
        Pinfo.add(NomT);
        Pinfo.add(GenreL);
        Pinfo.add(Pradio);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("North", ExamenL);
        c.add("Center", Pinfo);
        c.add("South", Pbtn);
        setVisible(true);

        //Les ecouteurs-------------------
        Ajouter.addActionListener(new MyEvents(this));

        Liste.addActionListener((e) -> {
            new MyList();
        });
    }

    //Methode Principale
    public static void main(String[] args) {
        new MyForm();
    }
}

