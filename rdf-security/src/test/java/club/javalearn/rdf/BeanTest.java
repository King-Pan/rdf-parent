package club.javalearn.rdf;

import club.javalearn.rdf.security.shiro.LoginLimitHashedCredentialsMatcher;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 下午4:03
 * Description: No Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RdfSecurityApplication.class)
public class BeanTest {

    @Autowired
    private ApplicationContext act;

    @Test
    public void test() {
        LoginLimitHashedCredentialsMatcher loginLimitHashedCredentialsMatcher = act.getBean(LoginLimitHashedCredentialsMatcher.class);
        Ehcache passwordRetryCache = loginLimitHashedCredentialsMatcher.getCacheManager().getCache("passwordRetryCache");
        Element element = new Element("king", new AtomicInteger(0));
        passwordRetryCache.put(element);
        System.out.println(">>>>>>>>>." + passwordRetryCache.get("king"));
    }
}
