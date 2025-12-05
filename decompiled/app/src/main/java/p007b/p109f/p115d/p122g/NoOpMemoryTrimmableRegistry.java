package p007b.p109f.p115d.p122g;

/* compiled from: NoOpMemoryTrimmableRegistry.java */
/* renamed from: b.f.d.g.d, reason: use source file name */
/* loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {

    /* renamed from: a */
    public static NoOpMemoryTrimmableRegistry f3107a;

    /* renamed from: b */
    public static synchronized NoOpMemoryTrimmableRegistry m990b() {
        if (f3107a == null) {
            f3107a = new NoOpMemoryTrimmableRegistry();
        }
        return f3107a;
    }

    @Override // p007b.p109f.p115d.p122g.MemoryTrimmableRegistry
    /* renamed from: a */
    public void mo989a(MemoryTrimmable memoryTrimmable) {
    }
}
