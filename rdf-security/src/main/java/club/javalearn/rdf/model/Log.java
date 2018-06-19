package club.javalearn.rdf.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 下午4:11
 * Description: No Description
 */
@Table(name = "sys_log")
@Entity
@Data
public class Log implements Serializable{

    public static Long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 访问时间
     */
    private Date createDate;

    /**
     * 时长
     */
    private Long time;

    /**
     * 用户ID
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 访问IP
     */
    private String ip;

    /**
     * 参数
     */
    private String params;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 方法类型
     */
    private String method;

    /**
     * 状态
     */
    private String status;

    /**
     * 返回值
     */
    @Column(length = 4000)
    private String result;

    /**
     * 错误消息
     */
    @Column(length = 4000)
    private String errorMessage;

    void a(){
        String a = "SELECT count(1) FROM FPF_USER_ROLE r WHERE EXISTS (SELECT 1 FROM FPF_USER_ROLE_MAP M,FPF_USER_USER U WHERE U.USERID=M.USERID and  u.USERID='admin') and r.ROLE_NAME like '%维护组%' or r.ROLE_NAME LIKE '%维护角色%';";
    }
}
