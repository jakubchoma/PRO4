package cz.spsmb.ctvrtak.b_anotace;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface SampleAnnotation {
    String name();
}
