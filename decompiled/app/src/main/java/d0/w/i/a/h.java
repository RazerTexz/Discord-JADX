package d0.w.i.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.lang.reflect.Method;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static a f3586b;
    public static final h c = new h();
    public static final a a = new a(null, null, null);

    /* compiled from: DebugMetadata.kt */
    public static final class a {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f3587b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.f3587b = method2;
            this.c = method3;
        }
    }

    public final String getModuleName(d0.w.i.a.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        m.checkNotNullParameter(aVar, "continuation");
        a aVar2 = f3586b;
        if (aVar2 == null) {
            try {
                a aVar3 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ModelAuditLogEntry.CHANGE_KEY_NAME, new Class[0]));
                f3586b = aVar3;
                aVar2 = aVar3;
            } catch (Exception unused) {
                aVar2 = a;
                f3586b = aVar2;
            }
        }
        if (aVar2 == a || (method = aVar2.a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVar2.f3587b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar2.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
