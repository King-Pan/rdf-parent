package club.javalearn.rdf.service;


import club.javalearn.rdf.model.Log;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/7
 * Time: 上午10:21
 * Description: No Description
 */
@Transactional(rollbackFor = RuntimeException.class)
public interface LogService {
    /**
     * 保存日志
     * @param log 日志信息
     */
    void saveLog(Log log);
}
