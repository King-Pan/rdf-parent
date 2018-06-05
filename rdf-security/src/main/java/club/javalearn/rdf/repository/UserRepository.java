package club.javalearn.rdf.repository;

import club.javalearn.rdf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 上午10:37
 * Description: No Description
 */
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 通过用户名查找用户
     * @param userName 用户名
     * @return 用户信息
     */
    User findByUserName(String userName);
}
