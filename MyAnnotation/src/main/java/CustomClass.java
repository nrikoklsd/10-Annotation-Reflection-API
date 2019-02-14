import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomClass {
    @MyAnnotation
    private int field1;
    private int field2;

    @MyAnnotation
    public String field3;

    public void myMethod(String... args){
        System.out.println("args="+ Arrays.toString(args));

    }

    public void myMethod(String a, int... args){
        System.out.println("a="+ a + "; arg="+ Arrays.toString(args));

    }
    public CustomClass() {

    }
    private int method1(int a){
        return a;
    }

    @MyAnnotation
    public void method2(){

        System.out.println("method2");
    }
    private String method3(){
        return "method3";

    }

    public int getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
