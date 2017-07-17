package club.bestchu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by bestchu on 2017/7/17.
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(
                request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        String methodName = method.getName();
                        if(methodName.equals("getParameter")){
                            String value = request.getParameter(args[0].toString());
                            String methodSubmit = request.getMethod();
                            if("GET".equals(methodSubmit)) {
                                if (value != null && !"".equals(value.trim())) {
                                    value = new String(value.getBytes("ISO8859-1"),"UTF-8");
                                }
                            }
                            return value;
                        }else
                            result = method.invoke(request, args);
                        return result;
                    }
                }
        );
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
