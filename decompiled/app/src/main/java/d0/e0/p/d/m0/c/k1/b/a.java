package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static C0517a f3289b;

    /* compiled from: ReflectJavaMember.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.a$a, reason: collision with other inner class name */
    public static final class C0517a {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f3290b;

        public C0517a(Method method, Method method2) {
            this.a = method;
            this.f3290b = method2;
        }

        public final Method getGetName() {
            return this.f3290b;
        }

        public final Method getGetParameters() {
            return this.a;
        }
    }

    public final C0517a buildCache(Member member) throws SecurityException {
        d0.z.d.m.checkNotNullParameter(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new C0517a(cls.getMethod("getParameters", new Class[0]), b.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C0517a(null, null);
        }
    }

    public final List<String> loadParameterNames(Member member) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method getName;
        d0.z.d.m.checkNotNullParameter(member, "member");
        C0517a c0517aBuildCache = f3289b;
        if (c0517aBuildCache == null) {
            c0517aBuildCache = buildCache(member);
            f3289b = c0517aBuildCache;
        }
        Method getParameters = c0517aBuildCache.getGetParameters();
        if (getParameters == null || (getName = c0517aBuildCache.getGetName()) == null) {
            return null;
        }
        Object objInvoke = getParameters.invoke(member, new Object[0]);
        Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = getName.invoke(obj, new Object[0]);
            Objects.requireNonNull(objInvoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
