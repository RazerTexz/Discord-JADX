package p007b.p106e.p108b;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: b.e.b.a, reason: use source file name */
/* JADX INFO: compiled from: AccessClassLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class AccessClassLoader extends ClassLoader {

    /* JADX INFO: renamed from: a */
    public static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> f3009a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b */
    public static final ClassLoader f3010b;

    /* JADX INFO: renamed from: c */
    public static volatile AccessClassLoader f3011c;

    /* JADX INFO: renamed from: d */
    public static volatile Method f3012d;

    static {
        ClassLoader classLoader = AccessClassLoader.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        f3010b = classLoader;
        f3011c = new AccessClassLoader(classLoader);
    }

    public AccessClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    /* JADX INFO: renamed from: b */
    public static AccessClassLoader m889b(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        ClassLoader classLoader2 = f3010b;
        if (classLoader2.equals(classLoader)) {
            if (f3011c == null) {
                synchronized (f3009a) {
                    if (f3011c == null) {
                        f3011c = new AccessClassLoader(classLoader2);
                    }
                }
            }
            return f3011c;
        }
        WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = f3009a;
        synchronized (weakHashMap) {
            WeakReference<AccessClassLoader> weakReference = weakHashMap.get(classLoader);
            if (weakReference != null) {
                AccessClassLoader accessClassLoader = weakReference.get();
                if (accessClassLoader != null) {
                    return accessClassLoader;
                }
                weakHashMap.remove(classLoader);
            }
            AccessClassLoader accessClassLoader2 = new AccessClassLoader(classLoader);
            weakHashMap.put(classLoader, new WeakReference<>(accessClassLoader2));
            return accessClassLoader2;
        }
    }

    /* JADX INFO: renamed from: c */
    public static Method m890c() throws Exception {
        if (f3012d == null) {
            synchronized (f3009a) {
                Class cls = Integer.TYPE;
                f3012d = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, cls, cls, ProtectionDomain.class);
                try {
                    f3012d.setAccessible(true);
                } catch (Exception unused) {
                }
            }
        }
        return f3012d;
    }

    /* JADX INFO: renamed from: a */
    public Class<?> m891a(String str, byte[] bArr) throws ClassFormatError {
        try {
            return (Class) m890c().invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length), getClass().getProtectionDomain());
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length, AccessClassLoader.class.getProtectionDomain());
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        return str.equals(FieldAccess2.class.getName()) ? FieldAccess2.class : str.equals(MethodAccess.class.getName()) ? MethodAccess.class : str.equals(ConstructorAccess.class.getName()) ? ConstructorAccess.class : str.equals(PublicConstructorAccess.class.getName()) ? PublicConstructorAccess.class : super.loadClass(str, z2);
    }
}
