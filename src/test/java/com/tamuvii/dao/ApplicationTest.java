package com.tamuvii.dao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class ApplicationTest extends AbstractTransactionalDataSourceSpringContextTests {
    protected final Log log = LogFactory.getLog(getClass());
    protected ResourceBundle rb;

    protected String[] getConfigLocations() {
        setAutowireMode(AUTOWIRE_BY_NAME);
        return new String[] {
                "classpath:/applicationContext-resources.xml",
                "classpath:/applicationContext-dao.xml",
                "classpath:/applicationContext-service.xml",
                "classpath*:/applicationContext.xml", // for modular projects
                "classpath:**/applicationContext*.xml" // for web projects
            };
    }

    public ApplicationTest() {
        String className = this.getClass().getName();

        try {
            rb = ResourceBundle.getBundle(className);
        } catch (MissingResourceException mre) {
            //log.warn("No resource bundle found for: " + className);
        }
    }

}