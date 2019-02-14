public class CustomClass {
    @MyAnnotation
    private int field1;
    private int field2;

    @MyAnnotation
    public String field3;

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
}
