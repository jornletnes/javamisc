import java.awt.Color;
import java.awt.Graphics;

abstract class Geometry {
    private int _radius;
    private int _x;
    private int _y;
    private Color _color;

    public void setRadius(int radius) {
        _radius = radius;
    }

    public int getRadius() {
        return _radius;
    }

    public void setX(int x) {
        _x = x;
    }

    public int getX() {
        return _x;
    }
    
    public void setY(int y) {
        _y = y;
    }

    public int getY() {
        return _y;
    }

    public void setColor(int r, int g, int b) {
        _color = new Color(r, g, b);
    }
    
    public Color getColor() {
        return _color;
    }

    abstract void draw(Graphics g);
}