package club.javalearn.rdf.utils;

import club.javalearn.rdf.model.User;
import club.javalearn.rdf.properties.ShiroProperties;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 上午10:16
 * Description: No Description
 */
@Service
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Autowired
    private ShiroProperties shiroProperties;

    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                //加密算法
                shiroProperties.getPassword().getAlgorithmName(),
                //密码
                user.getPassword(),
                //salt盐   username + salt
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                //迭代次数
                shiroProperties.getPassword().getHashIterations()
        ).toHex();

        user.setPassword(newPassword);
    }
}
