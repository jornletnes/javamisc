import java.awt.Graphics;

class Square extends Geometry{

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getRadius(), getRadius());
    }
}