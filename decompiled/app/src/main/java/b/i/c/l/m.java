package b.i.c.l;

import java.util.HashSet;
import java.util.Set;

/* compiled from: CycleDetector.java */
/* loaded from: classes3.dex */
public class m {
    public final d<?> a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<m> f1666b = new HashSet();
    public final Set<m> c = new HashSet();

    public m(d<?> dVar) {
        this.a = dVar;
    }

    public boolean a() {
        return this.c.isEmpty();
    }
}
