package club.javalearn.rdf.aspect;

import club.javalearn.rdf.model.Log;
import club.javalearn.rdf.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 下午4:30
 * Description: No Description
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切面
     */
    @Pointcut("@annotation(club.javalearn.rdf.aspect.LogService)")
    public void serviceAspect() { }

    @Before("serviceAspect()")
    public  void doBefore(JoinPoint joinPoint) {
        //前置通知
        if(log.isDebugEnabled()){
            log.debug("-->: 前置通知");
        }
    }


    @AfterReturning(pointcut = "serviceAspect()",returning = "rvt")
    public Object  doAfterReturning(JoinPoint joinPoint,Object rvt){
        if(log.isDebugEnabled()){
            log.debug("-->: AfterReturning");
        }
        try {
            //记录日志
        }catch (Exception e){
            log.error("记录日志出错",e);
        }
        return rvt;
    }

    @Around(value = "serviceAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object rvt;
        if(log.isDebugEnabled()){
            log.debug("-->: 开始记录日志");
        }
        try {
            rvt = pjp.proceed();
            Log log = new Log();
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            log.setUserName(user.getUserName());
            log.setTime(new Date());
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String,String[]> parapMap = request.getParameterMap();
            log.setMethod(request.getMethod());
            log.setUrl(request.getRequestURI());


            //记录成功
        } catch (Throwable throwable) {
            //记录失败
            throw throwable;
        }
        if(log.isDebugEnabled()){
            log.debug("-->: 开始记录日志");
        }

        return rvt;
    }

    @After("serviceAspect()")
    public  void doAfter(JoinPoint joinPoint) {
        if(log.isDebugEnabled()){
            log.debug("After...");
        }
    }
}
