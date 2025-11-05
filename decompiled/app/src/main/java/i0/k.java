package i0;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* loaded from: classes3.dex */
public final class k {
    public final Method a;

    /* renamed from: b, reason: collision with root package name */
    public final List<?> f3743b;

    public k(Method method, List<?> list) {
        this.a = method;
        this.f3743b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.a.getDeclaringClass().getName(), this.a.getName(), this.f3743b);
    }
}
