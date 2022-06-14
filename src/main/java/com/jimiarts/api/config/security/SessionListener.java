/*
 *
 * Copyright ⓒ 2020 PUBPLE Co., Ltd. All rights reserved.
 *
 * This software is the confidential and proprietary information of PUBPLE, Co Ltd.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement.
 *
 */
package com.jimiarts.api.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class SessionListener implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //logger.debug("[SessionListener] :: sessionCreated .... 15*600 ");
        se.getSession().setMaxInactiveInterval(15*600);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //logger.debug("[SessionListener] :: sessionDestroyed .... ");
    }
}
