package program;

import java.awt.Graphics;

class Circle extends Geometry{

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getRadius(), getRadius());
    }
}