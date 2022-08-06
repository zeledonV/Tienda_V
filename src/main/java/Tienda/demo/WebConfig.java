/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author valer
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean 
    public SessionLocaleResolver localeResolver(){ 
        /**Tipo SessionLocaleResolver**/
        var slr = new SessionLocaleResolver(); 
        /**nueva variable  var slr**/
        slr.setDefaultLocale(new Locale("es"));
        /**es como un getter y setter**/ /**Locale, la va al almacenar en nuestro lenguaje y lo va a guardar en el SessionLocaleResolver**/
        return slr; 
        /**va a devolver**/
    }
    
     @Bean 
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();  
        /**Detectar cambios**/
        lci.setParamName("lang"); 
        /**Velar por el cambio, ver si hubo un cambio**/
        return lci; 
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){ 
        /**Agregar la variable que va a generar los cambios, cada cuanto un url cambia**/
        registro.addInterceptor(localeChangeInterceptor());
        /**Capte para poder ser traducidos**/
    }
    
}
