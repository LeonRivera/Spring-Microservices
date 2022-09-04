package com.formacionbdi.springboot.app.gateway.filters.factory;

public class Configuracion {

        private String mensaje;
        private String cookieValor;
        private String cookieNombre;
        public String getMensaje() {
            return mensaje;
        }
        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
        public String getCookieValor() {
            return cookieValor;
        }
        public void setCookieValor(String cookieValor) {
            this.cookieValor = cookieValor;
        }
        public String getCookieNombre() {
            return cookieNombre;
        }
        public void setCookieNombre(String cookieNombre) {
            this.cookieNombre = cookieNombre;
        }

       
}
