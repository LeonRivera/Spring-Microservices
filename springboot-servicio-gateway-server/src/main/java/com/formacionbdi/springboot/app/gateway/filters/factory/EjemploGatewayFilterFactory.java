package com.formacionbdi.springboot.app.gateway.filters.factory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseCookie;

import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class EjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<Configuracion>{


    

    public EjemploGatewayFilterFactory() {
        super(Configuracion.class);
    }


    private final Logger logger = LoggerFactory.getLogger(EjemploGatewayFilterFactory.class);

    
    

    @Override
    public List<String> shortcutFieldOrder() {
        
        return Arrays.asList("mensaje", "cookieNombre", "cookieValor");
    }


    



    @Override
    public String name() {
        return "EjemploCookie";
    }






    @Override
    public GatewayFilter apply(Configuracion config) {
        return (exchange, chain) -> {

            logger.info("Ejecutando pre gateway filter factory" + config.getMensaje());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {

                Optional.ofNullable(config.getCookieValor()).ifPresent(cookie -> {
                    exchange.getResponse().addCookie(ResponseCookie.from(config.getCookieNombre(), cookie).build());
                });

                logger.info("Ejecutando post gateway filter factory" + config.getMensaje());
            }));
        };
    }
    
}
