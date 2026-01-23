package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p110a.FileBinaryResource;
import p007b.p109f.p111b.p112a.NoOpCacheEventListener;
import p007b.p109f.p111b.p112a.SimpleCacheKey;
import p007b.p109f.p111b.p113b.DiskStorageCache;
import p007b.p109f.p111b.p113b.FileCache;
import p007b.p109f.p111b.p113b.SettableCacheEvent;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteStreams;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p183r.FrescoSystrace;
import p686z.Task6;

/* JADX INFO: renamed from: b.f.j.c.f, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache2 {

    /* JADX INFO: renamed from: a */
    public final FileCache f3661a;

    /* JADX INFO: renamed from: b */
    public final PooledByteBufferFactory f3662b;

    /* JADX INFO: renamed from: c */
    public final PooledByteStreams f3663c;

    /* JADX INFO: renamed from: d */
    public final Executor f3664d;

    /* JADX INFO: renamed from: e */
    public final Executor f3665e;

    /* JADX INFO: renamed from: f */
    public final StagingArea f3666f = new StagingArea();

    /* JADX INFO: renamed from: g */
    public final ImageCacheStatsTracker f3667g;

    /* JADX INFO: renamed from: b.f.j.c.f$a */
    /* JADX INFO: compiled from: BufferedDiskCache.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ CacheKey f3668j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ EncodedImage2 f3669k;

        public a(Object obj, CacheKey cacheKey, EncodedImage2 encodedImage2) {
            this.f3668j = cacheKey;
            this.f3669k = encodedImage2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BufferedDiskCache2.m1216b(BufferedDiskCache2.this, this.f3668j, this.f3669k);
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                    BufferedDiskCache2.this.f3666f.m1211d(this.f3668j, this.f3669k);
                    EncodedImage2 encodedImage2 = this.f3669k;
                    if (encodedImage2 != null) {
                        encodedImage2.close();
                    }
                }
            }
        }
    }

    public BufferedDiskCache2(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f3661a = fileCache;
        this.f3662b = pooledByteBufferFactory;
        this.f3663c = pooledByteStreams;
        this.f3664d = executor;
        this.f3665e = executor2;
        this.f3667g = imageCacheStatsTracker;
    }

    /* JADX INFO: renamed from: a */
    public static PooledByteBuffer m1215a(BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey) throws IOException {
        Objects.requireNonNull(bufferedDiskCache2);
        try {
            cacheKey.mo930b();
            int i = FLog.f3102a;
            FileBinaryResource fileBinaryResourceM950b = ((DiskStorageCache) bufferedDiskCache2.f3661a).m950b(cacheKey);
            if (fileBinaryResourceM950b == null) {
                cacheKey.mo930b();
                Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.f3667g);
                return null;
            }
            cacheKey.mo930b();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.f3667g);
            FileInputStream fileInputStream = new FileInputStream(fileBinaryResourceM950b.f3016a);
            try {
                PooledByteBuffer pooledByteBufferMo996d = bufferedDiskCache2.f3662b.mo996d(fileInputStream, (int) fileBinaryResourceM950b.m928a());
                fileInputStream.close();
                cacheKey.mo930b();
                return pooledByteBufferMo996d;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.m986n(BufferedDiskCache2.class, e, "Exception reading from cache for %s", cacheKey.mo930b());
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.f3667g);
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1216b(BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey, EncodedImage2 encodedImage2) {
        Objects.requireNonNull(bufferedDiskCache2);
        cacheKey.mo930b();
        int i = FLog.f3102a;
        try {
            ((DiskStorageCache) bufferedDiskCache2.f3661a).m952d(cacheKey, new BufferedDiskCache4(bufferedDiskCache2, encodedImage2));
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.f3667g);
            cacheKey.mo930b();
        } catch (IOException e) {
            FLog.m986n(BufferedDiskCache2.class, e, "Failed to write to disk-cache for key %s", cacheKey.mo930b());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1217c(CacheKey cacheKey) {
        DiskStorageCache diskStorageCache = (DiskStorageCache) this.f3661a;
        Objects.requireNonNull(diskStorageCache);
        try {
            synchronized (diskStorageCache.f3057q) {
                List<String> listM596z0 = AnimatableValueParser.m596z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listM596z0;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    String str = (String) arrayList.get(i);
                    if (diskStorageCache.f3051k.mo934c(str, cacheKey)) {
                        diskStorageCache.f3048h.add(str);
                        return;
                    }
                    i++;
                }
            }
        } catch (IOException unused) {
            SettableCacheEvent settableCacheEventM961a = SettableCacheEvent.m961a();
            settableCacheEventM961a.f3075d = cacheKey;
            Objects.requireNonNull((NoOpCacheEventListener) diskStorageCache.f3047g);
            settableCacheEventM961a.m962b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: d */
    public final Task6<EncodedImage2> m1218d(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        cacheKey.mo930b();
        int i = FLog.f3102a;
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.f3667g);
        ExecutorService executorService = Task6.f27977a;
        if (encodedImage2 instanceof Boolean) {
            return ((Boolean) encodedImage2).booleanValue() ? Task6.f27981e : Task6.f27982f;
        }
        Task6<EncodedImage2> task6 = new Task6<>();
        if (task6.m11373h(encodedImage2)) {
            return task6;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    /* JADX INFO: renamed from: e */
    public Task6<EncodedImage2> m1219e(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        Task6<EncodedImage2> task6M11367c;
        try {
            FrescoSystrace.m1527b();
            EncodedImage2 encodedImage2M1208a = this.f3666f.m1208a(cacheKey);
            if (encodedImage2M1208a != null) {
                return m1218d(cacheKey, encodedImage2M1208a);
            }
            try {
                task6M11367c = Task6.m11366a(new BufferedDiskCache(this, null, atomicBoolean, cacheKey), this.f3664d);
            } catch (Exception e) {
                FLog.m986n(BufferedDiskCache2.class, e, "Failed to schedule disk-cache read for %s", ((SimpleCacheKey) cacheKey).f3019a);
                task6M11367c = Task6.m11367c(e);
            }
            return task6M11367c;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1220f(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        try {
            FrescoSystrace.m1527b();
            Objects.requireNonNull(cacheKey);
            AnimatableValueParser.m527i(Boolean.valueOf(EncodedImage2.m1338u(encodedImage2)));
            this.f3666f.m1209b(cacheKey, encodedImage2);
            EncodedImage2 encodedImage2M1336a = EncodedImage2.m1336a(encodedImage2);
            try {
                this.f3665e.execute(new a(null, cacheKey, encodedImage2M1336a));
            } catch (Exception e) {
                FLog.m986n(BufferedDiskCache2.class, e, "Failed to schedule disk-cache write for %s", cacheKey.mo930b());
                this.f3666f.m1211d(cacheKey, encodedImage2);
                if (encodedImage2M1336a != null) {
                    encodedImage2M1336a.close();
                }
            }
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
