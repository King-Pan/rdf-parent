package club.javalearn.rdf.service;

import club.javalearn.rdf.model.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 上午10:39
 * Description: No Description
 */
public interface UserService {
    /**
     * 通过用户名查找用户
     * @param userName 用户名
     * @return 用户信息
     */
    User findByUserName(String userName);
}
