package org.codingkata;

import java.awt.Component;
import javax.swing.JDialog;

public class KataUILoader extends JDialog {

    public KataUILoader (Component c) {

        setModal(true);
        add(c);
    }
    
}
