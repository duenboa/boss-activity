package com.boa.common.util;

import com.google.common.base.Strings;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

    private static ValidatorFactory factory;

    private static ValidatorFactory fastFactory ;

    public static Validator getValidator(){

        if( null == factory ){
            factory = Validation.buildDefaultValidatorFactory();
        }

        return factory.getValidator();
    }

    public static Validator getFastValidator(){

        if( null == fastFactory ){
            fastFactory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
        }
        return fastFactory.getValidator();
    }


    /**
     * 快速验证,只要有一个字段不符合验证规则,终止验证
     * @param bean          要验证的实体
     * @param isThrow      是否抛出参数错误异常
     * @param <T>           实体
     * @return              是否验证成功
     * @throws IllegalArgumentException
     */
    public static <T> boolean beanValidate(T bean,boolean isThrow) throws IllegalArgumentException{
        Set<ConstraintViolation<T>> constraintViolations=getFastValidator().validate(bean);
        if( !constraintViolations.isEmpty() ){
            if( isThrow )
                throw new IllegalArgumentException(constraintViolations.iterator().next().getMessage());
            return false;
        }
        return true;
    }

    /**

     * 验证
     * @param bean    要验证的实体
     * @param isFast  是否快速验证
     * @param <T>
     * @return         具体验证结果
     */
    public static <T> Set<ConstraintViolation<T>> beanConstraintViolation(T bean, boolean isFast) {
        return ( isFast  ? getFastValidator() : getValidator() ).validate(bean);
    }

    /**
     * 是否是数字(整数)
     * @param digitString
     * @return
     */
    public static boolean isDigit(String digitString){
        try{
            Long.valueOf(digitString);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    /**
     * 判断 objects 是否有对象 equals obj
     * @param obj1
     * @param objects
     * @return
     */
    public static boolean isIn(Object obj1,Object obj2 ,Object ... objects){

        if( equals(obj1,obj2) )
            return true;

        for(Object _obj : objects){
            if( equals(obj1, _obj) )
                return true;
        }
        return false;
    }

    /**
     * 判断 objects 是否有对象 equals obj
     * @param obj
     * @param objects
     * @return
     */
    public static boolean isIn(Object obj,Object [] objects){

        if( null == objects || objects.length==0 )
            return false;
        for(Object _obj : objects){
            if( equals(obj, _obj) )
                return true;
        }
        return false;
    }

    /**
     * 判断 objects 是否有对象 equals obj
     * @param obj
     * @param objects
     * @return
     */
    public static boolean isIn(Object obj,Collection objects){
        if( null == objects || objects.isEmpty() )
            return false;
        for(Object _obj : objects){
            if( equals(obj, _obj) )
                return true;
        }
        return false;
    }

    /**
     * 判断 objects 是否有对象 equals obj
     * @param obj
     * @param objects
     * @return
     */
    public static boolean isIn(Object obj,Iterator objects){
        if( null == objects || !objects.hasNext() )
            return false;
        while ( objects.hasNext()){
            Object _obj = objects.next();
            if( equals(obj, _obj) )
                return true;
        }
        return false;
    }

    /**
     * 判断两个对象是否 equals
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(Object a,Object b){
        return (a == b) || (a != null && a.equals(b));
    }

    /**
     * 是否是数字(包含小数)
     * @param numberString
     * @return
     */
    public static boolean isNumber(String numberString){
        try{
            Double.valueOf( numberString );
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isEmptyOrNull(String contentTemplate) {
        return Strings.isNullOrEmpty(contentTemplate);
    }

    public static boolean isChinese(String name) {
        Pattern pattern = Pattern.compile("^([\\u4e00-\\u9fa5])+$");
        Matcher matcher = pattern.matcher(name);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}
