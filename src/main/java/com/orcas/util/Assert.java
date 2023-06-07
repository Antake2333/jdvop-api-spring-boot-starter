package com.orcas.util;

import com.orcas.exception.JdVopApi4jException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * @author Orcas
 * @date 2022-05-12 15:36
 **/
public class Assert {

    private Assert() {
    }

    public static void isTrue(boolean condition, String fieldName) {
        if (!condition) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]错误");
        }
    }


    public static void isAddress(String address) {
        isNotBlank(address, "address");
        if (!address.startsWith("0x")) {
            throw JdVopApi4jException.paramError("address格式错误,address必须以0x开头");
        }
    }

    /**
     * in 枚举
     *
     * @param c
     * @param fieldName
     * @param value
     */
    public static void inEnum(Class c, String fieldName, Object value) {
        if (c == null || fieldName == null) {
            throw JdVopApi4jException.paramError("Assert.inEnum[class,fieldName]不能为空");
        }
        if (value == null) {
            throw JdVopApi4jException.paramError("enum[" + fieldName + "]不能为空");
        }
        try {
            Object[] objects = c.getEnumConstants();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = c.getMethod(methodName);
            for (Object obj : objects) {
                // 3.调用对应方法，得到枚举常量中字段的值
                Object fieldValue = method.invoke(obj);
                if (value.equals(fieldValue)) {
                    return;
                }
            }
        } catch (Exception ignored) {
        }
        throw JdVopApi4jException.paramError("[" + value + "]不在枚举" + c + "." + fieldName + "内");
    }

    public static void inEnumIfPresent(Class c, String fieldName, Object value) {
        if (value == null) {
            return;
        }
        inEnum(c, fieldName, value);
    }

    /**
     * 对象不为空校验
     *
     * @param o
     * @param fieldName
     */
    public static void isNotNull(Object o, String fieldName) {
        if (o == null || "".equals(o)) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]不能为空");
        }
        if (o instanceof Collection) {
            Collection collection = (Collection) o;
            if (collection.isEmpty()) {
                throw JdVopApi4jException.paramError("[" + fieldName + "]不能为空");
            }
        }
    }

    /**
     * 字符串不为空
     *
     * @param fieldName
     * @param text
     */
    public static void isNotBlank(String text, String fieldName) {
        if (StringUtils.isBlank(text)) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]不能为空");
        }
    }


    /**
     * 字符串长度校验
     *
     * @param fieldName
     * @param text
     * @param minLen
     * @param maxLen
     */
    public static void hasTxt(String text, String fieldName, int minLen, int maxLen) {
        if (StringUtils.isBlank(text) || text.length() < minLen || text.length() > maxLen) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]长度为" + minLen + "-" + maxLen);
        }
    }

    /**
     * 如果字符串不为空，则校验字符串长度
     *
     * @param fieldName
     * @param text
     * @param minLen
     * @param maxLen
     */
    public static void hasTxtIfPresent(String text, String fieldName, int minLen, int maxLen) {
        if (StringUtils.isNotBlank(text)) {
            hasTxt(text, fieldName, minLen, maxLen);
        }
    }

    public static void hasTxtMaxIfPresent(String text, String fieldName, int maxLen) {
        if (StringUtils.isNotBlank(text)) {
            hasTxt(text, fieldName, 1, maxLen);
        }
    }

    public static void maxByte(String text, String fieldName, int maxLen) {
        if (StringUtils.isBlank(text)) {
            return;
        }
        if (text.getBytes(StandardCharsets.UTF_8).length > maxLen) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]最大字节长度为" + maxLen + ",使用 UTF-8 编码，1个汉字占3个字节");
        }
    }


    public static void isNull(Object object, Integer code, String msg) {
        if (object != null) {
            throw new JdVopApi4jException(code, msg);
        }
    }


    public static void isNumberIfPresent(Object object, String fieldName) {
        if (object == null) {
            return;
        }
        if (!NumberUtils.isCreatable(String.valueOf(object))) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]不是数字");
        }
    }

    /**
     * 校验参数是否在值之间
     *
     * @param obj
     * @param fieldName
     * @param minVal
     * @param maxVal
     */
    public static void validateIntegerNumBetweenIfPresent(Object obj, String fieldName, BigInteger minVal, BigInteger maxVal) {
        if (obj == null) {
            return;
        }
        if (minVal == null || maxVal == null) {
            throw JdVopApi4jException.paramError("minVal,maxVal不能为空");
        }
        isNumberIfPresent(obj, fieldName);
        BigInteger bigInteger = new BigInteger(obj.toString());
        if (bigInteger.compareTo(minVal) < 0 || bigInteger.compareTo(maxVal) > 0) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]必须在" + minVal + "-" + maxVal + "之间");
        }
    }

    public static void validateIntegerMaxIfPresent(Object obj, String fieldName, BigInteger maxVal) {
        validateIntegerNumBetweenIfPresent(obj, fieldName, BigInteger.valueOf(0), maxVal);
    }

    /**
     * 判断数字>=于0
     *
     * @param obj
     * @param fieldName
     */
    public static void validateIntegerGeZero(Object obj, String fieldName) {
        if (obj == null || fieldName == null) {
            throw JdVopApi4jException.paramError("validateIntegerGeZero[obj,fieldName]不能为空");
        }
        isNumberIfPresent(obj, fieldName);
        BigInteger num = new BigInteger(obj.toString());
        if (num.compareTo(BigInteger.valueOf(0)) < 0) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]必须大于等于0");
        }
    }

    public static void validateIntegerGtZero(Object obj, String fieldName) {
        if (obj == null || fieldName == null) {
            throw JdVopApi4jException.paramError("validateIntegerGtZero[obj,fieldName]不能为空");
        }
        isNumberIfPresent(obj, fieldName);
        BigInteger num = new BigInteger(obj.toString());
        if (num.compareTo(BigInteger.valueOf(0)) <= 0) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]必须大于0");
        }
    }


    /**
     * 校验参数是否在值之间
     *
     * @param obj
     * @param fieldName
     * @param minVal
     * @param maxVal
     */
    public static void validateDecimalNumBetweenIfPresent(Object obj, String fieldName, BigDecimal minVal, BigDecimal maxVal) {
        if (obj == null) {
            return;
        }
        if (minVal == null || maxVal == null) {
            throw JdVopApi4jException.paramError("minVal,maxVal不能为空");
        }
        isNumberIfPresent(obj, fieldName);
        BigDecimal decimal = new BigDecimal(obj.toString());
        if (decimal.compareTo(minVal) < 0 || decimal.compareTo(maxVal) > 0) {
            throw JdVopApi4jException.paramError("[" + fieldName + "]必须在" + minVal + "-" + maxVal + "之间");
        }
    }

    public static void validateDecimalMaxIfPresent(Object obj, String fieldName, BigDecimal maxVal) {
        validateDecimalNumBetweenIfPresent(obj, fieldName, BigDecimal.valueOf(0), maxVal);
    }

    public static void provinceCodeVerify(String code) {
        lengthVerify(code, "省");
        if (!code.endsWith("0000")) {
            throw JdVopApi4jException.paramError("省编码尾数错误");
        }
    }

    public static void cityCodeVerify(String code) {
        lengthVerify(code, "市");
        if (!code.endsWith("00")) {
            throw JdVopApi4jException.paramError("市编码尾数错误");
        }
    }

    public static void areaCodeCodeVerify(String code) {
        lengthVerify(code, "区县");
    }

    private static void lengthVerify(String element, String head) {
        if (element.length() != 6) {
            throw JdVopApi4jException.paramError(head + "编码长度错误");
        }
    }

}
