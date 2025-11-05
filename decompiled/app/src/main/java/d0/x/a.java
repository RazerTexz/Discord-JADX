package d0.x;

import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: d0.x.a$a, reason: collision with other inner class name */
    public static final class C0602a {
        public static final Method a;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            m.checkNotNullExpressionValue(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methods[i];
                m.checkNotNullExpressionValue(method, "it");
                if (m.areEqual(method.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    m.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    boolean z2 = m.areEqual((Class) k.singleOrNull(parameterTypes), Throwable.class);
                    if (z2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            a = method;
            for (Method method2 : methods) {
                m.checkNotNullExpressionValue(method2, "it");
                if (m.areEqual(method2.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m.checkNotNullParameter(th, "cause");
        m.checkNotNullParameter(th2, "exception");
        Method method = C0602a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public d0.c0.c defaultPlatformRandom() {
        return new d0.c0.b();
    }
}
