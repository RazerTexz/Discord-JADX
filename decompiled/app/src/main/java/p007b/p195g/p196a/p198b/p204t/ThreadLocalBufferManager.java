package p007b.p195g.p196a.p198b.p204t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ThreadLocalBufferManager.java */
/* renamed from: b.g.a.b.t.l, reason: use source file name */
/* loaded from: classes3.dex */
public class ThreadLocalBufferManager {

    /* renamed from: a */
    public final Map<SoftReference<BufferRecycler>, Boolean> f4614a = new ConcurrentHashMap();

    /* renamed from: b */
    public final ReferenceQueue<BufferRecycler> f4615b = new ReferenceQueue<>();

    /* compiled from: ThreadLocalBufferManager.java */
    /* renamed from: b.g.a.b.t.l$a */
    public static final class a {

        /* renamed from: a */
        public static final ThreadLocalBufferManager f4616a = new ThreadLocalBufferManager();
    }
}
