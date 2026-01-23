package p007b.p195g.p196a.p198b.p204t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.b.t.l, reason: use source file name */
/* JADX INFO: compiled from: ThreadLocalBufferManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadLocalBufferManager {

    /* JADX INFO: renamed from: a */
    public final Map<SoftReference<BufferRecycler>, Boolean> f4614a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public final ReferenceQueue<BufferRecycler> f4615b = new ReferenceQueue<>();

    /* JADX INFO: renamed from: b.g.a.b.t.l$a */
    /* JADX INFO: compiled from: ThreadLocalBufferManager.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final ThreadLocalBufferManager f4616a = new ThreadLocalBufferManager();
    }
}
