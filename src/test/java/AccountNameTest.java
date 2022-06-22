import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class AccountNameTest {

    private final String name;
    private final boolean expectedCheckResult;

    public AccountNameTest(String name, boolean expectedCheckResult){
        this.name = name;
        this.expectedCheckResult = expectedCheckResult;
    }

    @Parameterized.Parameters
    public static Object[][] getColorsData() {
        return new Object[][]{
                { "", false },
                { ".", false },
                { "-", false },
                { "        ", false },
                { "123456789012345678901234567890", false },
                { " ", false },
                { "  ", false },
                { "A ", false },
                { " b", false },
                { "3 3", false },
                { "b 3", false },
                { "3 b", false },
                { "- -", false },
                { "a -", false },
                { "- a", false },
                { "11111 22222", false },
                { "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb a", false },
                { "a bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", false },
                { "Zh. Shynybayeva", false },
                { "ТимотейШевроле", false },
                { "A A", true },
                { "Alal Alal", true },
                { "Alalllllll L", true },
                { "L Lalalala", true },
                { "Zhadyra Shynybayeva", true },
                { "Тимоти Шаламе", true },
                { "AAA BBB", true },
        };
    }

    @Test
    public void shouldMakeOrderTest() {
        Assert.assertEquals(
                "Имя должно содержать один пробел, не в начале и не вконце имени.",
                expectedCheckResult,
                new Account(name).checkNameToEmboss()
        );
    }

}
