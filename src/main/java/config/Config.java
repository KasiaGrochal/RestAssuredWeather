package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Config {

    private static Config instance;
    private EnvironmentConfig environmentConfig;

    public Config() {
        environmentConfig = readConfig();
    }

    public static EnvironmentConfig getEnvironmentConfig() {
        return getInstance().environmentConfig;
    }

    private static Config getInstance() {
        if (instance == null) {
            log.info("Config is null, loading instance of config.");
            instance = new Config();
        }
        return instance;
    }

    private EnvironmentConfig readConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.environmentConfig = mapper.readValue(new File("src/main/resources/config.yml"), EnvironmentConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Environment Config loaded from yaml");
        return environmentConfig;
    }
}
