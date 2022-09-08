package org.goodgoodgood.webredirector.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.goodgoodgood.webredirector.config.EnvironmentConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MainController {

    private final EnvironmentConfig environmentConfig;

    @GetMapping("{*path}")
    public ResponseEntity<Void> handleAllRequest(
            @PathVariable("path") String path,
            HttpServletRequest request
    ) {
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        log.info("Requested path is {}, client ip is {}", path, ip);

        return ResponseEntity
                .status(302)
                .header("Location", environmentConfig.getRedirectUrl())
                .build();
    }
}
