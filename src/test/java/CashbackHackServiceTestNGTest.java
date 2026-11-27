import org.testng.Assert;
import org.testng.annotations.Test;
import ru.netology.service.CashbackHackService;

public class CashbackHackServiceTestNGTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturn100ForAmount900() {
        int amount = 900;
        int actual = service.remain(amount);
        int expected = 100;
        // В TestNG порядок: actual, expected
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn0ForAmount1000() {
        int amount = 1000;
        int actual = service.remain(amount);
        int expected = 0;
        // В TestNG порядок: actual, expected
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn500ForAmount1500() {
        int amount = 1500;
        int actual = service.remain(amount);
        int expected = 500;
        // В TestNG порядок: actual, expected
        Assert.assertEquals(actual, expected);
    }
}