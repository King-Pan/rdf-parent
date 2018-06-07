package club.javalearn.rdf.service.impl;

import club.javalearn.rdf.model.Log;
import club.javalearn.rdf.repository.LogRepository;
import club.javalearn.rdf.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/7
 * Time: 上午10:27
 * Description: No Description
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }
}
