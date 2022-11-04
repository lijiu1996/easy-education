import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Li JiaWei
 * @ClassName: ServiceOssTest
 * @Description:
 * @Date: 2022/11/2 15:53
 * @Version: 1.0
 */
public class ServiceOssTest {

    @Test
    public void test1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd/");
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);
    }
}
