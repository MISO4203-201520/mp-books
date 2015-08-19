/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.providers;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 *
 * @author Jhonatan
 */
public class FilterShiro extends FormAuthenticationFilter {

    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return SecurityUtils.getSubject().isAuthenticated();
    }

}
