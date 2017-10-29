/**
 * @Copyright (C), 2012-2020 Duenboa
 * @Author: Duenboa
 * @Date: 2017/8/8 19:53
 * @Version: 1.0.0
 * <p>
 * $$$$$$$$$$$ 自定义的servlet级的组件, 必须要在启动应用入口com.boa.BoaSpringbootApplication添加注解:@ServletComponentScan //扫描Servlet级别的组件 $$$$$$$$$$
 * <p>
 * 一. 自定义拦截器配置参考:
 * @see com.boa.common.config.MySpringMVCConfig#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)  //添加自定义拦截器
 * <p>
 * 二. 自定义过滤器配置参考:
 * @see com.boa.common.filter.MyFilterFirst  //过滤器中,必须chain.doFilter(request,response)放行.
 * <p>
 * 三. 自定义servlet配置参考:
 * @see com.boa.common.servlet.MyServlet
 * <p>
 * 四. 自定义监听器配置参考:
 * @see com.boa.common.listener.MyServletContextListener
 * <p>
 * 五. 所有的原先XML中配置的Bean, 都可以通过@Configuration + @Bean注解 + public Bean类型 getBeanXXX(){} 方法来做.
 * <p>
 * <p>
 * 六. 拦截器和过滤器区别:
 * 只有经过DispatcherServlet 的请求，才会走拦截器链.
 * 我们自定义的Servlet 请求是不会被拦截的，比如我们自定义的Servlet地址http://localhost:8080/myServlet 是不会被拦截器拦截的。
 * 并且不管是属于哪个Servlet 只要符合过滤器的过滤规则，过滤器都会拦截
 * <p>
 * 七. 拦截器执行顺序:
 * MyInterceptor1.preHandle()在请求处理之前进行调用(Controller方法调用之前)
 * MyInterceptor2.preHandle()在请求处理之前进行调用（Controller方法调用之前）
 * MyInterceptor2.postHandle()请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
 * MyInterceptor1.postHandle()请求处理之后进行调用，但是在视图被渲染之前(Controller方法调用之后)
 * MyInterceptor2.afterCompletion()在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
 * MyInterceptor1.afterCompletion()在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行(主要是用于进行资源清理工作)
 *
 */
package com.boa.common;