package club.javalearn.rdf.web.controller;

import club.javalearn.rdf.aspect.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/7
 * Time: 上午10:55
 * Description: No Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    @SysLog(module = "用户模块",operation = "进入用户页面")
    public ModelAndView userPage(){
        return new ModelAndView("system/user");
    }
}
