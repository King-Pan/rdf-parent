package club.javalearn.rdf.repository;

import club.javalearn.rdf.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/7
 * Time: 上午10:21
 * Description: 日志持久化对象
 */
public interface LogRepository extends JpaRepository<Log,Long> {

}
