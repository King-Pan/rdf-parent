package club.javalearn.rdf.repository;

import club.javalearn.rdf.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 上午10:38
 * Description: No Description
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
}
