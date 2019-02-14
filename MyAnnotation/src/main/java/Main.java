import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;

public class Main {
    public static void main(String[] args)  {

        //1 task
        CustomClass customClass = new CustomClass();
        Class nazar = customClass.getClass();

        for (Field field: nazar.getFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println(field.getName());
                System.out.println(field.getAnnotation(MyAnnotation.class).toString());
            }
        }


        //4 task
        Method method = null;
        try {
            method = nazar.getDeclaredMethod("method3");
            method.setAccessible(true);
            try {
                System.out.println(method.invoke(customClass));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        try {
            method = nazar.getDeclaredMethod("method2");

            try {
                method.invoke(customClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            method = nazar.getDeclaredMethod("method1", int.class);
            method.setAccessible(true);
            try {
                System.out.println(method.invoke(customClass,1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }









    }

}
