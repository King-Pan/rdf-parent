package club.javalearn.rdf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/5
 * Time: 上午10:33
 * Description: No Description
 */
@Table(name = "sys_permission")
@Entity
@Setter
@Getter
@ToString(exclude = {"roles"})
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    /**
     * 权限编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    /**
     * 权限名称
     */
    @Column(length = 100)
    private String name;

    /**
     * 权限描述
     */
    @Column(length = 2000)
    private String description;

    /**
     * 权限链接
     */
    @Column(length = 256)
    private String url;

    /**
     * 权限类型: 0: 目录 1：链接 2:按钮
     */
    @Column(length = 1)
    private String type;

    @Column(length = 10)
    private String method;

    /**
     * 权限父节点编码
     */
    private Long parentId;


    @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Permission){
            Permission resource = (Permission)obj;
            return  resource.getPermissionId().equals(this.getPermissionId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getPermissionId().hashCode();
    }
}
