package com.if1007.kscore.interceptor;

import com.if1007.kscore.context.impl.RequestContext;
import com.if1007.kscore.storage.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final Storage storage;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var token = request.getHeader("Authorization");

        if (!request.getMethod().equalsIgnoreCase("options") && isBlank(token)) {
            log.info("Token não enviado");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        var correlationId = UUID.randomUUID().toString();
        var context = RequestContext.builder().correlationId(correlationId).build();
        request.setAttribute("context", context);
        storage.insert(correlationId, token);
        return true;
    }
}
