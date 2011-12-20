package org.codingkata.unit.impl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

/**
 * @author stephanos
 */
public class KataUI extends JDialog {

    public boolean closed = false;
    private GridsCanvas canvas;
    private int max_row, max_col;

    KataUI(String title, int w, int h, int rows, int cols) {

        max_row = rows;
        max_col = cols;

        // setup dialog
        setResizable(false);
        setTitle(title);

        // Now create a Canvas and add it to the Frame.
        canvas = new GridsCanvas(w, h, rows, cols);
        add(canvas);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
            }
        });

        // Normal end ... pack it up!
        pack();
    }

    public void refresh(AnimalWrap[] animals, Plant[] plants) {
        if (isVisible()) {
            canvas.refresh(animals, plants);
        }
    }

    public void pause(int time) {
        if (isVisible()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
