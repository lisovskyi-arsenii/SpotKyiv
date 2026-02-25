package org.lisovskyi.backend.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityConfig {
    boolean includeId() default true;
    boolean includeCreatedAt() default true;
    boolean includeUpdatedAt() default true;
}
