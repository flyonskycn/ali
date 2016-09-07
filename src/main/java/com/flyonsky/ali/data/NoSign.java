package com.flyonsky.ali.data;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * 标记支付宝不需要加入签名的字段
 * @author Administrator
 *
 */
@Target(value={ElementType.FIELD,ElementType.METHOD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface NoSign {

}
