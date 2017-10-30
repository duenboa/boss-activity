package com.boa.common.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.annotation.WebFilter;

/**
 * @author DuenBoa
 * @date 2017/10/30
 */

@WebFilter(filterName = "myEncodingFilter", urlPatterns = "/*")
public class MyEncodingFilter extends CharacterEncodingFilter {
}
