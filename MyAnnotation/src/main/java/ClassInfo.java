import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {
    public static void show(Class aClass) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Class name: ").append(aClass.getName()).append('\n')
                .append("Simple name: ").append(aClass.getSimpleName()).append('\n')
                .append("Anonymous:d ").append(isTrue(aClass.isAnonymousClass())).append('\n')
                .append("Annotation: ").append(isTrue(aClass.isAnnotation())).append('\n')
                .append("Array: ").append(isTrue(aClass.isArray())).append('\n')
                .append("Enum: ").append(isTrue(aClass.isEnum())).append('\n')
                .append("Interface: ").append(isTrue(aClass.isInterface())).append('\n')
                .append("Member class: ").append(isTrue(aClass.isMemberClass())).append('\n')
                .append("Local class: ").append(isTrue(aClass.isLocalClass())).append('\n')
                .append("Primitive: ").append(isTrue(aClass.isPrimitive())).append('\n');


        Constructor[] constructors = aClass.getDeclaredConstructors();
        stringBuilder.append("\tConstructors:\n");
        for (Constructor constructor : constructors) {
            stringBuilder.append(constructor).append('\n');
        }
        Field[] fields = aClass.getDeclaredFields();
        stringBuilder.append("\tFields:\n");
        for (Field field : fields) {
            stringBuilder.append(field).append('\n');
        }
        stringBuilder.append("\tMethods:\n");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            stringBuilder.append(method).append('\n');
        }

        System.out.println(stringBuilder);
    }

    private static String isTrue(boolean b) {
        return b ? "Yes" : "No";
    }

    public static void main(String[] args) {
        ClassInfo.show(CustomClass.class);
    }
}