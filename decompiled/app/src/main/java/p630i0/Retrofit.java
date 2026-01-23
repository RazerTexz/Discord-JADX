package p630i0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: i0.x, reason: use source file name */
/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public class Retrofit implements InvocationHandler {

    /* JADX INFO: renamed from: a */
    public final Platform3 f26669a = Platform3.f26614a;

    /* JADX INFO: renamed from: b */
    public final Object[] f26670b = new Object[0];

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Class f26671c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Retrofit2 f26672d;

    public Retrofit(Retrofit2 retrofit22, Class cls) {
        this.f26672d = retrofit22;
        this.f26671c = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f26670b;
        }
        return this.f26669a.f26615b && method.isDefault() ? this.f26669a.mo10717b(method, this.f26671c, obj, objArr) : this.f26672d.m10726b(method).mo10710a(objArr);
    }
}
