import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A {

    @Test
    void ATest1() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        SysUser sysUser = new SysUser();
        //首先获取类的模板1
        Class<? extends SysUser> sysUserClass1 = sysUser.getClass();
        //类的模板2
        Class<SysUser> sysUserClass = SysUser.class;
        //System.out.println("true or false:"+(sysUserClass1 == sysUserClass));
        //能获得字段
        Field userId1 = sysUserClass.getDeclaredField("userName");
        Field userId = sysUserClass.getDeclaredField("userId");
        //能对字段进行setget，set可访问它的值
        userId.setAccessible(true);
        userId.set(sysUser,123L);
        //System.out.println("sysUser:\n"+sysUser);

        //能获取字段上的注解
        Excel annotation = userId.getAnnotation(Excel.class);
        System.out.println("annotation.name() = " + annotation.name());

        //反射获得构造器，构造器的使用
        Constructor<?>[] declaredConstructors = sysUserClass.getDeclaredConstructors();
//        for (Constructor<?> declaredConstructor : declaredConstructors) {
//            System.out.println("declaredConstructor = " + declaredConstructor);
//            System.out.println("declaredConstructor.getParameterCount() = " + declaredConstructor.getParameterCount());
//            if (declaredConstructor.getParameterCount()==0) {
//                Object o = declaredConstructor.newInstance();
//                SysUser ocl = ((SysUser) o);
//                System.out.println("ocl = " + ocl);
//            }else{
//                Object ocl2 = declaredConstructor.newInstance(2333L);
//                SysUser o = ((SysUser) ocl2);
//                System.out.println("o = " + o);
//
//            }
//        }
//        Method[] declaredMethods = sysUserClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println("declaredMethod = " + declaredMethod);
//        }
        Method getUserId = sysUserClass.getDeclaredMethod("getUserId");
        Object invoke = getUserId.invoke(sysUser);
        System.out.println("invoke = " + invoke);
    }


}
