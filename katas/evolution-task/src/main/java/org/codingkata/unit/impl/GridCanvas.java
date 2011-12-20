package org.codingkata.unit.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class GridsCanvas extends Canvas {

    private AnimalWrap[] m_animals;
    private Plant[] m_plants;
    int width, height;
    int rows;
    int cols;

    GridsCanvas(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        cols = c;
    }

    public void refresh(AnimalWrap[] animals, Plant[] plants) {
        m_animals = animals;
        m_plants = plants;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        g.setColor(Color.GRAY);

        // draw the rows
        int rowHt = height / (rows);
        for (i = 0; i < rows; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }

        // draw the columns
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }

        if (m_animals != null) {
            for (AnimalWrap a : m_animals) {
                int size = rowWid;
                int arc = 270;
                g.setColor(Color.RED);
                g.fillArc(a.col * rowWid , a.row * rowHt, size, size,
                        calcAngle(a.orientation.angle, -arc / 2), arc);
            }
        }
        if (m_plants != null) {
            for (Plant p : m_plants) {
                if (p != null && p.daysSinceEaten == -1) {
                    int size = rowWid / 3;
                    g.setColor(Color.GREEN);
                    g.fillOval(p.col * rowWid + size, p.row * rowHt + size, size, size);
                }
            }
        }
    }

    private int calcAngle(int base, int diff) {
        int res = base + diff;
        if (res < 0) {
            res = 360 + res;
        }
        return res % 360;
    }
}
