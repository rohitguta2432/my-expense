package com.delte.api.config;

import com.delte.api.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
@Component("accessDeniedHandler")
class ExpenseAccessDeniedHandler implements AccessDeniedHandler {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e)
            throws IOException, ServletException {

        Response<String> response = new Response<String>(HttpStatus.FORBIDDEN.value(), "Access denied for resources :" +
                httpServletRequest.getRequestURI(), null);
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(OBJECT_MAPPER.writeValueAsString(response));
            writer.flush();
        }
    }
}
