package com.flyonsky.ali.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记参数中的必填字段
 * @author Administrator
 *
 */
@Target(value={ElementType.FIELD,ElementType.METHOD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Required {

}
