package com.example.CRUDDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Entering through Logging filter");

        long start = System.currentTimeMillis();

        HttpServletRequest httpRequest =
                (HttpServletRequest) servletRequest;

        HttpServletResponse httpResponse =
                (HttpServletResponse)  servletResponse;

        // Request log
        System.out.println("Incoming Request : "
                + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());

        String requestId = UUID.randomUUID().toString();
        httpResponse.setHeader("X-Request-ID", requestId);

        System.out.println("Request ID: " + requestId);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long end = System.currentTimeMillis();

            // Response status log
            System.out.println("Response status: "
                    + httpResponse.getStatus());

            System.out.println("TAT: " + (end - start) + " ms");

            System.out.println("Exiting through Logging filter");
        }
    }
}
