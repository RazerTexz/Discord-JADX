package p507d0.p588x;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p507d0.p510c0.PlatformRandom2;
import p507d0.p510c0.Random;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.x.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformImplementations {

    /* JADX INFO: renamed from: d0.x.a$a */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final Method f25251a;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics3.checkNotNullExpressionValue(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methods[i];
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                if (Intrinsics3.areEqual(method.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Intrinsics3.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    boolean z2 = Intrinsics3.areEqual((Class) _Arrays.singleOrNull(parameterTypes), Throwable.class);
                    if (z2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            f25251a = method;
            for (Method method2 : methods) {
                Intrinsics3.checkNotNullExpressionValue(method2, "it");
                if (Intrinsics3.areEqual(method2.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        Intrinsics3.checkNotNullParameter(th, "cause");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        Method method = a.f25251a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random defaultPlatformRandom() {
        return new PlatformRandom2();
    }
}
