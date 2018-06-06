package club.javalearn.rdf.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 上午10:11
 * Description: No Description
 */
@Getter
@Setter
@ToString
public class PasswordProperties {
    /**
     * 加密次数
     */
    private int hashIterations;
    /**
     * 加密算法
     */
    private String algorithmName;

}
