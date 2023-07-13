package Utils;

import org.aeonbits.owner.Config;

@Config.Sources(value ="file:${user.dir}/src/main/java/GLobalVariables/config.properties")
public interface config extends Config {
    String browser();
    Long timeout();
}
