package lombok.eclipse.agent;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX WARN: Classes with same name are omitted:
  discord-126021.apk:Class50/lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok
 */
/* loaded from: discord-126021.apk:lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok */
public class EclipseLoaderPatcherTransplants {
    static Class class$0;

    public static boolean overrideLoadDecide(ClassLoader original, String name, boolean resolve) {
        return name.startsWith("lombok.");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x014c A[Catch: all -> 0x01df, Exception -> 0x025c, FINALLY_INSNS, TryCatch #0 {Exception -> 0x025c, blocks: (B:2:0x0000, B:4:0x0019, B:5:0x0021, B:6:0x0022, B:8:0x0031, B:10:0x0061, B:11:0x006f, B:12:0x008a, B:19:0x00bd, B:65:0x014c, B:66:0x0151, B:15:0x00a4, B:17:0x00b3, B:18:0x00bc, B:26:0x014c, B:27:0x0151, B:23:0x0144, B:30:0x015c, B:32:0x01db, B:35:0x01e1, B:36:0x01e2, B:39:0x01e7, B:41:0x0212, B:42:0x0218, B:45:0x022a, B:43:0x021e, B:44:0x0229, B:47:0x0255), top: B:67:0x0000, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Class, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.lang.String, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class overrideLoadResult(ClassLoader original, String name, boolean resolve) throws ClassNotFoundException {
        byte[] bytes;
        int len;
        try {
            Field shadowLoaderField = original.getClass().getField("lombok$shadowLoader");
            ClassLoader shadowLoader = (ClassLoader) shadowLoaderField.get(original);
            if (shadowLoader == null) {
                synchronized ("lombok$shadowLoader$globalLock".intern()) {
                    shadowLoader = (ClassLoader) shadowLoaderField.get(original);
                    if (shadowLoader == null) {
                        Class shadowClassLoaderClass = (Class) original.getClass().getField("lombok$shadowLoaderClass").get(null);
                        Class<?> cls = Class.forName("java.lang.ClassLoader");
                        String jarLoc = (String) original.getClass().getField("lombok$location").get(null);
                        if (shadowClassLoaderClass == null) {
                            JarFile jf = new JarFile(jarLoc);
                            InputStream in = null;
                            try {
                                ZipEntry entry = jf.getEntry("lombok/launch/ShadowClassLoader.class");
                                in = jf.getInputStream(entry);
                                bytes = new byte[65536];
                                len = 0;
                            } finally {
                                if (in != null) {
                                }
                                jf.close();
                            }
                            do {
                                int r = in.read(bytes, len, bytes.length - len);
                                if (r != -1) {
                                    len += r;
                                } else {
                                    in.close();
                                    Class<?>[] clsArr = new Class[4];
                                    clsArr[0] = "".getClass();
                                    clsArr[1] = new byte[0].getClass();
                                    clsArr[2] = Integer.TYPE;
                                    clsArr[3] = clsArr[2];
                                    Method defineClassMethod = cls.getDeclaredMethod("defineClass", clsArr);
                                    defineClassMethod.setAccessible(true);
                                    shadowClassLoaderClass = (Class) defineClassMethod.invoke(original, "lombok.launch.ShadowClassLoader", bytes, new Integer(0), new Integer(len));
                                    original.getClass().getField("lombok$shadowLoaderClass").set(null, shadowClassLoaderClass);
                                    if (in != null) {
                                        in.close();
                                    }
                                    jf.close();
                                }
                            } while (len != bytes.length);
                            throw new IllegalStateException("lombok.launch.ShadowClassLoader too large.");
                        }
                        Class<?>[] clsArr2 = new Class[5];
                        clsArr2[0] = cls;
                        clsArr2[1] = "".getClass();
                        clsArr2[2] = clsArr2[1];
                        clsArr2[3] = Class.forName("java.util.List");
                        clsArr2[4] = clsArr2[3];
                        Constructor constructor = shadowClassLoaderClass.getDeclaredConstructor(clsArr2);
                        constructor.setAccessible(true);
                        shadowLoader = (ClassLoader) constructor.newInstance(original, "lombok", jarLoc, Arrays.asList("lombok."), Arrays.asList("lombok.patcher.Symbols"));
                        shadowLoaderField.set(original, shadowLoader);
                    }
                }
            }
            if (resolve) {
                Class[] paramTypes = {"".getClass(), Boolean.TYPE};
                ?? r0 = shadowLoader.getClass();
                Class[] clsArr3 = new Class[2];
                Class<?> cls2 = class$0;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName("java.lang.String");
                        class$0 = cls2;
                    } catch (ClassNotFoundException unused) {
                        throw new NoClassDefFoundError(r0.getMessage());
                    }
                }
                clsArr3[0] = cls2;
                clsArr3[1] = Boolean.TYPE;
                Method m = r0.getDeclaredMethod("loadClass", clsArr3);
                m.setAccessible(true);
                return (Class) m.invoke(shadowLoader, name, Boolean.TRUE);
            }
            return shadowLoader.loadClass(name);
        } catch (Exception ex) {
            Throwable t = ex;
            if (t instanceof InvocationTargetException) {
                t = t.getCause();
            }
            if (t instanceof RuntimeException) {
                throw ((RuntimeException) t);
            }
            if (t instanceof Error) {
                throw ((Error) t);
            }
            throw new RuntimeException(t);
        }
    }
}
