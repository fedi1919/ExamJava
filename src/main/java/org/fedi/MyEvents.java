package org.fedi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvents implements ActionListener {

    MyForm mf;
    MyDataBase mdb;

    public MyEvents(MyForm mf) {
        this.mf = mf;
        mdb = new MyDataBase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Boutton ajouter
        if (e.getSource() == mf.Ajouter) {
            var genre = mf.Bg.getSelection().getActionCommand();
            mdb.ajouter(new Personne(mf.NomT.getText(), genre));
            mf.NomT.setText("");
        }
    }
}
