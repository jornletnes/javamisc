package program;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class MyPanel extends JPanel implements ActionListener {

    private ArrayList<Geometry> _geometries;
    private int _numColors = 256;
    private int _colorStep = 1;
    private int _gridCellSize = 5;
    private int _gridSize = _gridCellSize * _numColors;
    private Timer _timer = new Timer(0, this);
    private int _b = 0;

    public MyPanel() {

        setPreferredSize(new Dimension(_gridSize, _gridSize));
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();

        _timer.start();

        buildGeometries();
    }

    private void buildGeometries() {

        _geometries = new ArrayList<Geometry>();
        GeometryGenerator generator = new GeometryGenerator();

        for (int i = 0; i < _gridSize; i += _gridCellSize) {
            for (int j = 0; j < _gridSize; j += _gridCellSize) {

                Geometry geometry = generator.generate();
                geometry.setX(i);
                geometry.setY(j);
                geometry.setRadius(_gridCellSize);
                int r = i / _gridCellSize;
                int g = j / _gridCellSize;
                geometry.setColor(r, g, _b);

                _geometries.add(geometry);
            }
        }
    }

    private void adjustColors(Geometry geometry) {
        Color color = geometry.getColor();
        geometry.setColor(color.getRed(), color.getGreen(), _b);
    }

    private void incrementColors() {
        if (_b + _colorStep >= _numColors || _b + _colorStep <= 0)
            _colorStep = -_colorStep;
        _b += _colorStep;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == _timer) {
            repaint();
            incrementColors();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        int numGeometries = _geometries.size();
        for (int i = 0; i < numGeometries; ++i) {
            Geometry geometry = _geometries.get(i);
            adjustColors(geometry);
            geometry.draw(g);
        }
    }
}