package club.javalearn.rdf.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 下午2:31
 * Description: No Description
 */

public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        return super.doCredentialsMatch(token, info);
    }
}
