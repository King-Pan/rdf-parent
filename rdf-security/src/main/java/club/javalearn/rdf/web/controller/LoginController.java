package club.javalearn.rdf.web.controller;

import club.javalearn.rdf.model.User;
import club.javalearn.rdf.properties.ShiroProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 下午4:15
 * Description: No Description
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private ShiroProperties shiroProperties;


    @GetMapping("/loginPage")
    public ModelAndView loginPage() {
        System.out.println(shiroProperties.getPassword().getHashIterations());
        System.out.println(shiroProperties.getPassword().getAlgorithmName());
        return new ModelAndView("login");
    }

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @param rememberMe
     * @return
     */
    @PostMapping("/login")
    public String submitLogin(@RequestParam("username") String userName, @RequestParam("password") String password, @RequestParam(name = "remember-me", required = false, defaultValue = "false") boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);

            User user = (User) SecurityUtils.getSubject().getPrincipal();

            if (log.isDebugEnabled()) {
                log.debug("登录用户为{}", user.getUserName());
            }
            return "redirect:/indexPage";
        } catch (Exception e) {
            log.error("登录失败，用户名[{}]", userName, e);
            token.clear();
            return "redirect:/loginPage";
        }
    }

    @GetMapping("/indexPage")
    public ModelAndView indexPage() {
        return new ModelAndView("/index");
    }
}
