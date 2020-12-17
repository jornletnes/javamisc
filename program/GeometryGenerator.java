package program;

class GeometryGenerator {

    public Geometry generate() {
        int randomNumber = (int)(Math.random() * 100);
        if (randomNumber < 50)
            return new Circle();
        return new Square();
    }
}