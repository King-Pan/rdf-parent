package club.javalearn.rdf.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
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
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 记录时间
     */
    private Date time;

    /**
     * 用户ID
     */
    private String userName;

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
     * 返回值
     */
    private String result;
}
