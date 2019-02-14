import java.lang.annotation.*;

@Documented

@Target({ElementType.FIELD, ElementType.METHOD})

@Inherited

@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {
    int studentAge() default 18;
    String stuStream() default "CSE";
}
