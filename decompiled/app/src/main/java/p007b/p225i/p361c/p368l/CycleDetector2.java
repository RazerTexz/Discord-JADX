package p007b.p225i.p361c.p368l;

import java.util.HashSet;
import java.util.Set;

/* compiled from: CycleDetector.java */
/* renamed from: b.i.c.l.m, reason: use source file name */
/* loaded from: classes3.dex */
public class CycleDetector2 {

    /* renamed from: a */
    public final Component4<?> f12196a;

    /* renamed from: b */
    public final Set<CycleDetector2> f12197b = new HashSet();

    /* renamed from: c */
    public final Set<CycleDetector2> f12198c = new HashSet();

    public CycleDetector2(Component4<?> component4) {
        this.f12196a = component4;
    }

    /* renamed from: a */
    public boolean m6357a() {
        return this.f12198c.isEmpty();
    }
}
