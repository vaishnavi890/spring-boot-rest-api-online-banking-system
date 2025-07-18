package com.vaishnavi.spring.boot.online.banking.filters;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BankingRequestFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(BankingRequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("BankingRequestFilter initialized...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("[BankingRequestFilter] Remote Host: {}", request.getRemoteHost());
        logger.info("[BankingRequestFilter] Remote Address: {}", request.getRemoteAddr());

        // You can add more logic here for auditing, authentication checks, etc.

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("BankingRequestFilter destroyed...");
    }
}


