package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Suppliers;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p132g.p133a.p134a.Fresco;
import p007b.p109f.p132g.p133a.p134a.PipelineDraweeControllerBuilderSupplier;
import p007b.p109f.p161j.p170e.ImagePipeline;
import p007b.p109f.p161j.p170e.ImagePipeline2;
import p007b.p109f.p161j.p170e.ImagePipelineConfig2;
import p007b.p109f.p161j.p170e.ImagePipelineExperiments;
import p007b.p109f.p161j.p170e.ImagePipelineFactory;
import p007b.p109f.p161j.p170e.NativeCodeSetup;
import p007b.p109f.p161j.p183r.FrescoSystrace;
import p007b.p109f.p190m.p191n.NativeLoader;
import p007b.p109f.p190m.p191n.SystemDelegate;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: MGImagesConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesConfig {
    private static final String CACHE_DIR = "app_images_cache";
    private static final String CACHE_DIR_SMALL = "app_images_cache_small";
    public static final MGImagesConfig INSTANCE = new MGImagesConfig();
    private static final int MAX_BITMAP_MEM_CACHE_SIZE_RATIO = 3;
    private static final long MAX_DISK_CACHE_SIZE = 41943040;

    /* JADX INFO: renamed from: com.discord.utilities.images.MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1 */
    /* JADX INFO: compiled from: MGImagesConfig.kt */
    public static final class C67801 extends DefaultBitmapMemoryCacheParamsSupplier {
        public final /* synthetic */ ActivityManager $activityManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67801(ActivityManager activityManager, ActivityManager activityManager2) {
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
            int i = memoryCacheParams.f19542a;
            return new MemoryCacheParams(i, memoryCacheParams.f19543b, memoryCacheParams.f19544c, memoryCacheParams.f19545d, i / 3, TimeUnit.MINUTES.toMillis(5L));
        }
    }

    private MGImagesConfig() {
    }

    private final DefaultBitmapMemoryCacheParamsSupplier getAppBitmapMemoryCacheParamsSupplier(Context context) {
        Object systemService = context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return new C67801(activityManager, activityManager);
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig.C10634b c10634b = new DiskCacheConfig.C10634b(context, null);
        c10634b.f19434b = new Suppliers(context.getCacheDir());
        c10634b.f19433a = str;
        c10634b.f19435c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(c10634b);
        Intrinsics3.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ImagePipelineConfig2.a aVar = new ImagePipelineConfig2.a(context, null);
        aVar.f3772c = true;
        aVar.f3773d = newDiskCacheConfig(context, CACHE_DIR);
        aVar.f3774e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        aVar.f3770a = appBitmapMemoryCacheParamsSupplier;
        ImagePipelineExperiments.b bVar = aVar.f3775f;
        bVar.f3786b = true;
        ImagePipelineConfig2.a aVar2 = bVar.f3785a;
        Objects.requireNonNull(aVar2);
        ImagePipelineConfig2 imagePipelineConfig2 = new ImagePipelineConfig2(aVar2, null);
        FrescoSystrace.m1527b();
        if (Fresco.f3169b) {
            FLog.m983k(Fresco.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            Fresco.f3169b = true;
        }
        NativeCodeSetup.f3808a = true;
        if (!NativeLoader.m1588b()) {
            FrescoSystrace.m1527b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        NativeLoader.m1587a(new SystemDelegate());
                    } catch (IllegalAccessException unused2) {
                        NativeLoader.m1587a(new SystemDelegate());
                    }
                } catch (NoSuchMethodException unused3) {
                    NativeLoader.m1587a(new SystemDelegate());
                } catch (InvocationTargetException unused4) {
                    NativeLoader.m1587a(new SystemDelegate());
                }
                FrescoSystrace.m1527b();
            } finally {
                FrescoSystrace.m1527b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        ImagePipelineFactory.m1294j(imagePipelineConfig2);
        FrescoSystrace.m1527b();
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(applicationContext);
        Fresco.f3168a = pipelineDraweeControllerBuilderSupplier;
        SimpleDraweeView.initialize(pipelineDraweeControllerBuilderSupplier);
        FrescoSystrace.m1527b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.f3788a;
            AnimatableValueParser.m591y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
            if (imagePipelineFactory.f3799l == null) {
                imagePipelineFactory.f3799l = imagePipelineFactory.m1295a();
            }
            ImagePipeline2 imagePipeline2 = imagePipelineFactory.f3799l;
            ImagePipeline imagePipeline = new ImagePipeline(imagePipeline2);
            imagePipeline2.f3737e.mo1236d(imagePipeline);
            imagePipeline2.f3738f.mo1236d(imagePipeline);
        }
    }
}
