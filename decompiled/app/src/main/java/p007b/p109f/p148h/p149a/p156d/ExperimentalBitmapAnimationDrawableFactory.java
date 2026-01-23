package p007b.p109f.p148h.p149a.p156d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p148h.p149a.p150a.AnimationBackendDelegateWithInactivityCheck;
import p007b.p109f.p148h.p149a.p151b.BitmapAnimationBackend;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameCache;
import p007b.p109f.p148h.p149a.p151b.p152d.AnimationFrameCacheKey;
import p007b.p109f.p148h.p149a.p151b.p152d.FrescoFrameCache;
import p007b.p109f.p148h.p149a.p151b.p152d.KeepLastFrameCache;
import p007b.p109f.p148h.p149a.p151b.p152d.NoOpCache;
import p007b.p109f.p148h.p149a.p151b.p153e.DefaultBitmapFramePreparer;
import p007b.p109f.p148h.p149a.p151b.p153e.FixedNumberBitmapFramePreparationStrategy;
import p007b.p109f.p148h.p149a.p151b.p154f.AnimatedDrawableBackendAnimationInformation;
import p007b.p109f.p148h.p149a.p151b.p154f.AnimatedDrawableBackendFrameRenderer;
import p007b.p109f.p148h.p149a.p155c.AnimatedDrawable2;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p163a.AnimatedImage;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResult;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendProvider;
import p007b.p109f.p161j.p162a.p165c.AnimatedFrameCache;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableAnimatedImage;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.h.a.d.e, reason: use source file name */
/* JADX INFO: compiled from: ExperimentalBitmapAnimationDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {

    /* JADX INFO: renamed from: a */
    public final AnimatedDrawableBackendProvider f3552a;

    /* JADX INFO: renamed from: b */
    public final ScheduledExecutorService f3553b;

    /* JADX INFO: renamed from: c */
    public final ExecutorService f3554c;

    /* JADX INFO: renamed from: d */
    public final MonotonicClock f3555d;

    /* JADX INFO: renamed from: e */
    public final PlatformBitmapFactory f3556e;

    /* JADX INFO: renamed from: f */
    public final CountingMemoryCache<CacheKey, CloseableImage> f3557f;

    /* JADX INFO: renamed from: g */
    public final Supplier<Integer> f3558g;

    /* JADX INFO: renamed from: h */
    public final Supplier<Integer> f3559h;

    /* JADX INFO: renamed from: i */
    public final Supplier<Boolean> f3560i;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2, Supplier<Boolean> supplier3) {
        this.f3552a = animatedDrawableBackendProvider;
        this.f3553b = scheduledExecutorService;
        this.f3554c = executorService;
        this.f3555d = monotonicClock;
        this.f3556e = platformBitmapFactory;
        this.f3557f = countingMemoryCache;
        this.f3558g = supplier;
        this.f3559h = supplier2;
        this.f3560i = supplier3;
    }

    @Override // p007b.p109f.p161j.p174i.DrawableFactory
    /* JADX INFO: renamed from: a */
    public boolean mo1035a(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    @Override // p007b.p109f.p161j.p174i.DrawableFactory
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable mo1036b(CloseableImage closeableImage) {
        AnimatedImage animatedImage;
        AnimatedImageResult animatedImageResult;
        FrescoFrameCache frescoFrameCache;
        BitmapFrameCache noOpCache;
        int iIntValue;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        DefaultBitmapFramePreparer defaultBitmapFramePreparer;
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        synchronized (closeableAnimatedImage) {
            AnimatedImageResult animatedImageResult2 = closeableAnimatedImage.f3882l;
            animatedImage = animatedImageResult2 == null ? null : animatedImageResult2.f3609a;
        }
        synchronized (closeableAnimatedImage) {
            animatedImageResult = closeableAnimatedImage.f3882l;
        }
        Objects.requireNonNull(animatedImageResult);
        Bitmap.Config configMo1179d = animatedImage != null ? animatedImage.mo1179d() : null;
        AnimatedImage animatedImage2 = animatedImageResult.f3609a;
        AnimatedDrawableBackend animatedDrawableBackendMo1164a = this.f3552a.mo1164a(animatedImageResult, new Rect(0, 0, animatedImage2.getWidth(), animatedImage2.getHeight()));
        int iIntValue2 = this.f3558g.get().intValue();
        if (iIntValue2 == 1) {
            frescoFrameCache = new FrescoFrameCache(m1165c(animatedImageResult), true);
        } else {
            if (iIntValue2 != 2) {
                noOpCache = iIntValue2 != 3 ? new NoOpCache() : new KeepLastFrameCache();
                BitmapFrameCache bitmapFrameCache = noOpCache;
                AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache, animatedDrawableBackendMo1164a);
                iIntValue = this.f3559h.get().intValue();
                if (iIntValue <= 0) {
                    FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(iIntValue);
                    PlatformBitmapFactory platformBitmapFactory = this.f3556e;
                    if (configMo1179d == null) {
                        configMo1179d = Bitmap.Config.ARGB_8888;
                    }
                    fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
                    defaultBitmapFramePreparer = new DefaultBitmapFramePreparer(platformBitmapFactory, animatedDrawableBackendFrameRenderer, configMo1179d, this.f3554c);
                } else {
                    fixedNumberBitmapFramePreparationStrategy = null;
                    defaultBitmapFramePreparer = null;
                }
                BitmapAnimationBackend bitmapAnimationBackend = new BitmapAnimationBackend(this.f3556e, bitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendMo1164a), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, defaultBitmapFramePreparer);
                return new AnimatedDrawable2(new AnimationBackendDelegateWithInactivityCheck(bitmapAnimationBackend, bitmapAnimationBackend, this.f3555d, this.f3553b));
            }
            frescoFrameCache = new FrescoFrameCache(m1165c(animatedImageResult), false);
        }
        noOpCache = frescoFrameCache;
        BitmapFrameCache bitmapFrameCache2 = noOpCache;
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer2 = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCache2, animatedDrawableBackendMo1164a);
        iIntValue = this.f3559h.get().intValue();
        if (iIntValue <= 0) {
        }
        BitmapAnimationBackend bitmapAnimationBackend2 = new BitmapAnimationBackend(this.f3556e, bitmapFrameCache2, new AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendMo1164a), animatedDrawableBackendFrameRenderer2, fixedNumberBitmapFramePreparationStrategy, defaultBitmapFramePreparer);
        return new AnimatedDrawable2(new AnimationBackendDelegateWithInactivityCheck(bitmapAnimationBackend2, bitmapAnimationBackend2, this.f3555d, this.f3553b));
    }

    /* JADX INFO: renamed from: c */
    public final AnimatedFrameCache m1165c(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode(), Boolean.FALSE.booleanValue()), this.f3557f);
    }
}
