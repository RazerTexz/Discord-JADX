package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import b.c.a.a0.d;
import b.f.d.d.k;
import b.f.d.e.a;
import b.f.g.a.a.e;
import b.f.j.e.g;
import b.f.j.e.h;
import b.f.j.e.j;
import b.f.j.e.l;
import b.f.j.e.n;
import b.f.j.r.b;
import b.f.m.n.c;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: MGImagesConfig.kt */
/* loaded from: classes2.dex */
public final class MGImagesConfig {
    private static final String CACHE_DIR = "app_images_cache";
    private static final String CACHE_DIR_SMALL = "app_images_cache_small";
    public static final MGImagesConfig INSTANCE = new MGImagesConfig();
    private static final int MAX_BITMAP_MEM_CACHE_SIZE_RATIO = 3;
    private static final long MAX_DISK_CACHE_SIZE = 41943040;

    /* compiled from: MGImagesConfig.kt */
    /* renamed from: com.discord.utilities.images.MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DefaultBitmapMemoryCacheParamsSupplier {
        public final /* synthetic */ ActivityManager $activityManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ActivityManager activityManager, ActivityManager activityManager2) {
            super(activityManager2);
            this.$activityManager = activityManager;
        }

        @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
        public /* bridge */ /* synthetic */ MemoryCacheParams get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
        public MemoryCacheParams get() {
            MemoryCacheParams memoryCacheParams = super.get();
            int i = memoryCacheParams.a;
            return new MemoryCacheParams(i, memoryCacheParams.f2895b, memoryCacheParams.c, memoryCacheParams.d, i / 3, TimeUnit.MINUTES.toMillis(5L));
        }
    }

    private MGImagesConfig() {
    }

    private final DefaultBitmapMemoryCacheParamsSupplier getAppBitmapMemoryCacheParamsSupplier(Context context) {
        Object systemService = context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return new AnonymousClass1(activityManager, activityManager);
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig.b bVar = new DiskCacheConfig.b(context, null);
        bVar.f2883b = new k(context.getCacheDir());
        bVar.a = str;
        bVar.c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(bVar);
        m.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        m.checkNotNullParameter(context, "context");
        j.a aVar = new j.a(context, null);
        aVar.c = true;
        aVar.d = newDiskCacheConfig(context, CACHE_DIR);
        aVar.e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        aVar.a = appBitmapMemoryCacheParamsSupplier;
        l.b bVar = aVar.f;
        bVar.f576b = true;
        j.a aVar2 = bVar.a;
        Objects.requireNonNull(aVar2);
        j jVar = new j(aVar2, null);
        b.b();
        if (b.f.g.a.a.b.f477b) {
            a.k(b.f.g.a.a.b.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            b.f.g.a.a.b.f477b = true;
        }
        n.a = true;
        if (!b.f.m.n.a.b()) {
            b.b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        b.f.m.n.a.a(new c());
                    } catch (IllegalAccessException unused2) {
                        b.f.m.n.a.a(new c());
                    }
                } catch (NoSuchMethodException unused3) {
                    b.f.m.n.a.a(new c());
                } catch (InvocationTargetException unused4) {
                    b.f.m.n.a.a(new c());
                }
                b.b();
            } finally {
                b.b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        b.f.j.e.m.j(jVar);
        b.b();
        e eVar = new e(applicationContext);
        b.f.g.a.a.b.a = eVar;
        SimpleDraweeView.initialize(eVar);
        b.b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            b.f.j.e.m mVar = b.f.j.e.m.a;
            d.y(mVar, "ImagePipelineFactory was not initialized!");
            if (mVar.l == null) {
                mVar.l = mVar.a();
            }
            h hVar = mVar.l;
            g gVar = new g(hVar);
            hVar.e.d(gVar);
            hVar.f.d(gVar);
        }
    }
}
