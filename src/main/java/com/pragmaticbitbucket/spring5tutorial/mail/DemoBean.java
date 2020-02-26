package com.pragmaticbitbucket.spring5tutorial.mail;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class DemoBean {
    private static Log log = LogFactory.getLog(DemoBean.class);

    public DemoBean() {
        log.info("DemoBean created * * * ");
    }
}
