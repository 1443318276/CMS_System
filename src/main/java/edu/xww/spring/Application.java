package edu.xww.spring;

import edu.xww.db.model.SystemConfig;
import edu.xww.db.model.SystemTemplate;
import edu.xww.db.service.SystemConfigService;
import edu.xww.db.service.SystemTemplateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class);
    private static Application application;
    private Map<String, String> configMap;

    @Autowired
    private SystemConfigService configService;

    @Autowired
    private SystemTemplateService templateService;

    @Value("${system.freemarker.loaderPath}")
    private String freemarkerLoaderPath;
    private File freemarkerDirectory;


    private Application() {
        application = this;

    }

    public static Application getInstance() {
        return application;
    }
    @PostConstruct
    public void _init() {
        if (configMap == null) {
            configMap = new HashMap<>();
            List<SystemConfig> configList = configService.selectAllConfig();
            if (configList != null) {
                configList.forEach(record -> configMap.put(record.getConfigKey(), record.getConfigValue()));
            }
        }
        //初始化freemarker存储目录
        if (StringUtils.isEmpty(freemarkerLoaderPath)) throw new RuntimeException("freemarker模板引擎文件存放目录不能为空");
        if (freemarkerLoaderPath.startsWith("file:")) {
            freemarkerDirectory = new File(freemarkerLoaderPath.replace("file:", ""));
        } else {
            freemarkerDirectory = new File(Objects.requireNonNull(this.getClass().getResource("/")).getPath().replace("/WEB-INF/classes", "/"));
            freemarkerDirectory = new File(freemarkerDirectory, freemarkerLoaderPath);
        }
        //初始化模板文件
        List<SystemTemplate> templateList = templateService.selectAllTemplates();
        if (templateList != null) templateList.forEach(this::createTemplateFile);
    }

    public void createTemplateFile(SystemTemplate record) {
        LOG.debug(record);
        LOG.debug(freemarkerDirectory);
        if (freemarkerDirectory == null || record == null) {
            LOG.error("文件或路径不存在：" + freemarkerDirectory);
            return;
        }
        File saveFile = new File(freemarkerDirectory, record.getTemplateDir() + "/" + record.getTemplateFile());
        File parentFile = saveFile.getParentFile();
        if (!parentFile.exists()) parentFile.mkdirs();
        if (saveFile.exists()) saveFile.delete();
        try (FileWriter writer = new FileWriter(saveFile)) {
            writer.write(record.getTemplateContent());
            writer.flush();
        } catch (Exception e) {
            LOG.error("模板写入失败", e);
        }
    }

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public void updateConfig(SystemConfig config) {
        if (configMap != null) {
            configMap.put(config.getConfigKey(), config.getConfigValue());
        }
    }
}
