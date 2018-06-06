package club.javalearn.rdf.config;

import club.javalearn.rdf.properties.ShiroProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/6/6
 * Time: 上午11:52
 * Description: No Description
 */
@Configuration
@EnableConfigurationProperties(ShiroProperties.class)
@Order(-1)
public class ShiroCoreConfig {
}
