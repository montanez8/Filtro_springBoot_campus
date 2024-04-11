package org.montanez.filtro_springboot_campus.handler;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(jakarta.servlet.http.HttpServletRequest request,
            HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, jakarta.servlet.ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getOutputStream()
                .println("{ \"error\": \"Acceso denegado: " + accessDeniedException.getMessage() + "\" }");

    }

}
