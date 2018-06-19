package club.javalearn.rdf.repository;

import club.javalearn.rdf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.QueryHint;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 上午10:37
 * Description: No Description
 */
@Transactional(rollbackFor = RuntimeException.class)
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 通过用户名查找用户
     * @param userName 用户名
     * @return 用户信息
     */
    @QueryHints({@QueryHint(name= org.hibernate.jpa.QueryHints.HINT_CACHEABLE,value = "true")})
    User findByUserName(String userName);
}

