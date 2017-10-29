package com.boa.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class WebUtil {


    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static List<MultipartFile> getFiles(HttpServletRequest request, String fileNme) throws Exception {
        if (request instanceof MultipartHttpServletRequest) {

            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            return multipartHttpServletRequest.getFiles(fileNme);

        } else {
            throw new Exception("不是上传模式，请检查form表头设置是否正确！");
        }

    }


    public static MultipartFile getFile(HttpServletRequest request, String fileName) throws Exception {
        if (request instanceof MultipartHttpServletRequest) {

            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            return multipartHttpServletRequest.getFile(fileName);

        } else {
            throw new Exception("不是上传模式，请检查form表头设置是否正确！");
        }
    }

}