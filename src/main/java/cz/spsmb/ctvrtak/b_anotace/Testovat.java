package cz.spsmb.ctvrtak.b_anotace;

public @interface Testovat {
    public String druh() default "";
    public Den[] frekvence() default {Den.PO, Den.ÚT, Den.ST, Den.ČT, Den.PÁ};
}
