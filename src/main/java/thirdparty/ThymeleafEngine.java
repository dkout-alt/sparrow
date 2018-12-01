package thirdparty;

import core.Sparrow;
import org.apache.log4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class ThymeleafEngine {
    private static TemplateEngine templateEngine = new TemplateEngine();
    private static final Logger logger = Logger.getLogger(Sparrow.class);

    static void initializeThymeleaf(ServletContextTemplateResolver templateResolver) {
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCacheable(true);
        templateEngine.setTemplateResolver(templateResolver);
        logger.debug("integrated Thymeleaf template engine into sparrow");
    }

    public static org.thymeleaf.TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}