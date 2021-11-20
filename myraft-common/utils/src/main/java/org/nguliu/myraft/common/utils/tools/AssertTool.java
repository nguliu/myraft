package org.nguliu.myraft.common.utils.tools;

import org.nguliu.myraft.common.utils.enums.ErrorCodeEnum;
import org.nguliu.myraft.common.utils.exception.MyraftException;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class AssertTool {

    public static void assertTrue(boolean condition, ErrorCodeEnum errorCode,
                                  String msgFormat, Object...params) {
        handleAssert(condition, errorCode, msgFormat, params);
    }

    public static void assertFalse(boolean condition, ErrorCodeEnum errorCode,
                                   String msgFormat, Object...params) {
        handleAssert(!condition, errorCode, msgFormat, params);
    }

    public static void assertNotNull(Object obj, ErrorCodeEnum errorCode,
                                     String msgFormat, Object...params) {
        handleAssert(obj != null, errorCode, msgFormat, params);
    }

    public static void assertNull(Object obj, ErrorCodeEnum errorCode,
                                  String msgFormat, Object...params) {
        handleAssert(obj == null, errorCode, msgFormat, params);
    }

    public static void assertNotBlank(String s, ErrorCodeEnum errorCodeEnum,
                                      String msgFormat, Object...params) {
        handleAssert(s != null && !s.isEmpty(), errorCodeEnum, msgFormat, params);
    }

    public static <T> void assertNotEmpty(Collection<T> c, ErrorCodeEnum errorCode,
                                          String msgFormat, Object...params) {
        handleAssert(c != null && !c.isEmpty(), errorCode, msgFormat, params);
    }

    public static void assertNotEmpty(Map<?, ?> map, ErrorCodeEnum errorCode,
                                      String msgFormat, Object...params) {
        handleAssert(map != null && !map.isEmpty(), errorCode, msgFormat, params);
    }

    public static void assertEquals(Object left, Object right, ErrorCodeEnum errorCode,
                                   String msgFormat, Object...params) {
        handleAssert(Objects.equals(left, right), errorCode, msgFormat, params);
    }


    private static void handleAssert(boolean condition, ErrorCodeEnum errorCode,
                               String msgFormat, Object...params) {
        if (!condition) {
            throw new MyraftException(errorCode, String.format(msgFormat, params));
        }
    }

}
