package club.javalearn.rdf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: king-pan
 * Date: 2018/6/5
 * Time: 上午10:18
 * Description: Druid数据源测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RdfSecurityApplication.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testSource(){
        System.out.println(dataSource.getClass().getName());
    }
}
