import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

class MyPanel extends JPanel {

    private ArrayList<Geometry> _geometries;
    private int _gridCellSize = 5;
    private int _gridSize = _gridCellSize * 256;

    
    private Geometry generateGeometry() {
        int randomNumber = (int)(Math.random() * 100);
        if (randomNumber < 50)
            return new Circle();
        return new Square();
    }

    public MyPanel() {

        _geometries = new ArrayList<Geometry>();

        for (int i=0; i<_gridSize; i+=_gridCellSize) {
            for (int j=0; j<_gridSize; j+=_gridCellSize) {

                Geometry geometry = generateGeometry();
                geometry.setX(i);
                geometry.setY(j);
                geometry.setRadius(_gridCellSize);
                int r = i/_gridCellSize;
                int g = j/_gridCellSize;
                int b = 128;
                geometry.setColor(r, g, b);
                _geometries.add(geometry);
            }
        }
    }

    public void paintComponent(Graphics g) {
        int numGeometries = _geometries.size();
        for (int i=0; i<numGeometries; ++i) {
            Geometry geometry = _geometries.get(i);
            geometry.draw(g);
        }
    }
}