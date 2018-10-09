import main.by.bstu.testing.service.TriangleService;
import main.by.bstu.testing.service.impl.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleServiceImplTest {
    private TriangleService triangleService = new TriangleServiceImpl();

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    //1
    @Test
    public void sidesNegativeTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be positive.");
        triangleService.isTriangle(5, -4, 8);
    }

    //2
    @Test
    public void sidesPositiveTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be positive.");
        triangleService.isTriangle(5, 4, 8);

    }

    //3
    @Test
    public void sidesMaxIntValueTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be less than max int value.");
        triangleService.isTriangle(Integer.MAX_VALUE, 4, 8);
    }

    //4
    @Test
    public void sidesNotMaxIntValueTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be less than max int value.");
        triangleService.isTriangle(5, 4, 8);
    }

    //5
    @Test
    public void triangleCorrectTest() {
        Assert.assertEquals(triangleService.isTriangle(5, 4, 8), true);
    }

    //6
    @Test
    public void triangleInCorrectTest() {
        Assert.assertEquals(triangleService.isTriangle(13, 4, 8), false);
    }

    //7
    @Test
    public void lineNotTriangleTest() {
        Assert.assertEquals(triangleService.isTriangle(12, 7, 5), false);
    }

    //8
    @Test
    public void sidesNotNullTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be positive.");
        triangleService.isTriangle(0, 7, 5);
    }

    //9
    @Test
    public void negativeAndNullSidesTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be positive.");
        triangleService.isTriangle(0, -7, 5);
    }

    //10
    @Test
    public void negativeAndMaxIntSidesTest() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Triangle's sides must be positive.");
        thrown.expectMessage("Triangle's sides must be less than max int value.");
        triangleService.isTriangle(0, -7, 5);
    }





}
