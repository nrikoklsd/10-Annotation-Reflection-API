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

                System.out.println("method" + method.invoke(customClass,1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        //5 task = Set value into field not knowing its type.


        try {
            Field field = nazar.getDeclaredField("field3");
            field.setAccessible(true);
            if (field.getType().equals(String.class))

            {
                try {
                    field.set(customClass, "task5");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(customClass.getField3());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        //task6
        try {
            method = nazar.getDeclaredMethod("myMethod", String[].class);


                String[] a= {"Hello", "world"};

            try {
                method.invoke(customClass,new Object[]{new String[]{"hello", "World!"}});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            method = nazar.getDeclaredMethod("myMethod", String.class, int[].class);


            String[] a= {"Hello", "world"};

            try {
                method.invoke(customClass,"task6, option2",new int[]{2,3,6,7});
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
