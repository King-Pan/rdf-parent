package club.javalearn.rdf;

import club.javalearn.rdf.model.User;
import club.javalearn.rdf.repository.UserRepository;
import club.javalearn.rdf.utils.PasswordHelper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 下午2:38
 * Description: No Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RdfSecurityApplication.class)
public class PasswordTest {

    @Autowired
    PasswordHelper passwordHelper;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        User user = userRepository.findByUserName("admin123");
        passwordHelper.encryptPassword(user);
        userRepository.save(user);
    }
}
