package p630i0;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* renamed from: i0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class Invocation {

    /* renamed from: a */
    public final Method f26547a;

    /* renamed from: b */
    public final List<?> f26548b;

    public Invocation(Method method, List<?> list) {
        this.f26547a = method;
        this.f26548b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f26547a.getDeclaringClass().getName(), this.f26547a.getName(), this.f26548b);
    }
}
