/*
 *
 * Copyright ⓒ 2020 PUBPLE Co., Ltd. All rights reserved.
 *
 * This software is the confidential and proprietary information of PUBPLE, Co Ltd.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement.
 *
 */
package com.jimiarts.api.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//    	registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000", "http://35.222.169.XX:9000")
//                .exposedHeaders("jwt-token")	//make client read header("jwt-token")
//                ;
//
//    }
//}

//@ComponentScan
@Configuration
public class SimpleCorsFilter implements Filter {
    static final Logger logger = LoggerFactory.getLogger(SimpleCorsFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        //logger.info("@doFilter .... ::: req.getMethod() : " + req.getMethod());

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        res.setHeader("Access-Control-Expose-Headers", "Authorization, X-Total-Count, Link");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept," +
                " Accept-Encoding, Accept-Language, " +
                " Host, Referer, Connection, User-Agent, " +
                " authorization, sw-useragent, sw-version, " +
                " Access-Control-Request-Method," +
                " Access-Control-Allow-Origin," +
                " Access-ealice-i18n," +
                " Access-ealice-store," +
                " Access-Control-Request-Headers, Authorization");

        if (req.getMethod().equals("OPTIONS")) {
            //logger.info("@doFilter .... ::: OPTIONS ::: SC_OK");
            res.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        logger.info("..");
    }

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("..");
    }
}
