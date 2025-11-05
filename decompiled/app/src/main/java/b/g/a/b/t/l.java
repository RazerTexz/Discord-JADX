package b.g.a.b.t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ThreadLocalBufferManager.java */
/* loaded from: classes3.dex */
public class l {
    public final Map<SoftReference<b.g.a.b.t.a>, Boolean> a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<b.g.a.b.t.a> f679b = new ReferenceQueue<>();

    /* compiled from: ThreadLocalBufferManager.java */
    public static final class a {
        public static final l a = new l();
    }
}
