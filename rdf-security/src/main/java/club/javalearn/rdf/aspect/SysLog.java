package club.javalearn.rdf.aspect;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 下午4:29
 * Description: 自定义注解,拦截log操作
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    //模块
    String module()  default "";
    //说明
    String operation()  default "";
}
