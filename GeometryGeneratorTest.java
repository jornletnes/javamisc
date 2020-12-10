import static org.junit.Assert.*;

import org.junit.Test;
    
public class GeometryGeneratorTest {

    @Test
    public void generateReturnsGeometry() {
        // Arrange
        var underTest = new GeometryGenerator();

        // Act
        var actual = underTest.generate();

        // Assert
        assertTrue(actual instanceof Geometry);
    }
}