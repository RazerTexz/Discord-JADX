package p007b.p109f.p161j.p170e;

import com.facebook.cache.disk.DiskCacheConfig;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p007b.p109f.p111b.p113b.DiskStorageCache;
import p007b.p109f.p111b.p113b.DynamicDefaultDiskStorage;
import p007b.p109f.p111b.p113b.FileCache;

/* compiled from: DiskStorageCacheFactory.java */
/* renamed from: b.f.j.e.c, reason: use source file name */
/* loaded from: classes.dex */
public class DiskStorageCacheFactory implements FileCacheFactory {

    /* renamed from: a */
    public DynamicDefaultDiskStorageFactory f3732a;

    public DiskStorageCacheFactory(DynamicDefaultDiskStorageFactory dynamicDefaultDiskStorageFactory) {
        this.f3732a = dynamicDefaultDiskStorageFactory;
    }

    /* renamed from: a */
    public FileCache m1261a(DiskCacheConfig diskCacheConfig) {
        Objects.requireNonNull(this.f3732a);
        DynamicDefaultDiskStorage dynamicDefaultDiskStorage = new DynamicDefaultDiskStorage(diskCacheConfig.f19421a, diskCacheConfig.f19423c, diskCacheConfig.f19422b, diskCacheConfig.f19428h);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        return new DiskStorageCache(dynamicDefaultDiskStorage, diskCacheConfig.f19427g, new DiskStorageCache.c(diskCacheConfig.f19426f, diskCacheConfig.f19425e, diskCacheConfig.f19424d), diskCacheConfig.f19429i, diskCacheConfig.f19428h, diskCacheConfig.f19430j, executorServiceNewSingleThreadExecutor, false);
    }
}
