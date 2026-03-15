package gavaconnectsdks.com.github.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomPattern {
        String pattern() default "";
        String message() default "Unfulfilled Pattern";
}
