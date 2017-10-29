package com.boa.common.util;

import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Copyright (C), 2012-2020 上海好屋网信息技术有限公司
 * @Author: DengBenbo 20160289
 * @Date: 2017/4/17
 * @Version: 1.0.0
 * @Description:
 * @History: 变更记录
 * <author>           <time>             <version>        <desc>
 * Duenboa            2017/4/17            00000001         创建文件
 */
public class IOUtil {

    /**
     * 文件下载工具
     *
     * @param request
     * @param response
     * @param fis
     * @param fileName
     * @throws java.io.IOException
     */
    final public static void downloadFile(HttpServletRequest request, HttpServletResponse response, InputStream inputStream, String fileName) throws IOException {

        //String finalFileName = URLEncoder.encode(fileName,"UTF-8");
        try {
            String userAgent = request.getHeader("user-Agent");
            String charset = "UTF-8";
            if (null != userAgent && userAgent.toUpperCase().contains("MSIE")) { //IE 浏览器使用 GBK 编码
                charset = "GBK";
            }
            String finalFileName = new String(fileName.getBytes(charset), "ISO-8859-1");
            response.setContentType("application/force-download");
            response.addHeader("Content-Type", "application/force-download");
            response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", finalFileName));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
