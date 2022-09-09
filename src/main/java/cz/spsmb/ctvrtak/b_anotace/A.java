package cz.spsmb.ctvrtak.b_anotace;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;

@Target({PARAMETER, TYPE_PARAMETER})
public @interface A {
}
