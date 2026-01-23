package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import p007b.p109f.p115d.p117b.DefaultSerialExecutorService;
import p007b.p109f.p115d.p117b.SerialExecutorService;
import p007b.p109f.p115d.p117b.UiThreadImmediateExecutorService;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p119d.Suppliers2;
import p007b.p109f.p148h.p149a.p156d.AnimatedFactoryV2Impl2;
import p007b.p109f.p148h.p149a.p156d.AnimatedFactoryV2Impl3;
import p007b.p109f.p148h.p149a.p156d.AnimatedFactoryV2Impl4;
import p007b.p109f.p148h.p149a.p156d.AnimatedFactoryV2Impl5;
import p007b.p109f.p148h.p149a.p156d.ExperimentalBitmapAnimationDrawableFactory;
import p007b.p109f.p161j.p162a.p164b.AnimatedFactory;
import p007b.p109f.p161j.p162a.p164b.AnimatedImageFactory;
import p007b.p109f.p161j.p162a.p164b.AnimatedImageFactoryImpl;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendProvider;
import p007b.p109f.p161j.p162a.p166d.AnimatedDrawableUtil;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p170e.ExecutorSupplier;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p175j.QualityInfo;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class AnimatedFactoryV2Impl implements AnimatedFactory {

    /* JADX INFO: renamed from: a */
    public final PlatformBitmapFactory f19531a;

    /* JADX INFO: renamed from: b */
    public final ExecutorSupplier f19532b;

    /* JADX INFO: renamed from: c */
    public final CountingMemoryCache<CacheKey, CloseableImage> f19533c;

    /* JADX INFO: renamed from: d */
    public final boolean f19534d;

    /* JADX INFO: renamed from: e */
    public AnimatedImageFactory f19535e;

    /* JADX INFO: renamed from: f */
    public AnimatedDrawableBackendProvider f19536f;

    /* JADX INFO: renamed from: g */
    public AnimatedDrawableUtil f19537g;

    /* JADX INFO: renamed from: h */
    public DrawableFactory f19538h;

    /* JADX INFO: renamed from: i */
    public SerialExecutorService f19539i;

    /* JADX INFO: renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$a */
    public class C10650a implements ImageDecoder2 {
        public C10650a() {
        }

        @Override // p007b.p109f.p161j.p173h.ImageDecoder2
        /* JADX INFO: renamed from: a */
        public CloseableImage mo1322a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.f19535e == null) {
                animatedFactoryV2Impl.f19535e = new AnimatedImageFactoryImpl(new AnimatedFactoryV2Impl5(animatedFactoryV2Impl), animatedFactoryV2Impl.f19531a);
            }
            AnimatedImageFactory animatedImageFactory = animatedFactoryV2Impl.f19535e;
            Bitmap.Config config = imageDecodeOptions.f3710e;
            AnimatedImageFactoryImpl animatedImageFactoryImpl = (AnimatedImageFactoryImpl) animatedImageFactory;
            Objects.requireNonNull(animatedImageFactoryImpl);
            if (AnimatedImageFactoryImpl.f3620a == null) {
                throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage2.m1340c();
            Objects.requireNonNull(closeableReferenceM1340c);
            try {
                PooledByteBuffer pooledByteBufferM8642u = closeableReferenceM1340c.m8642u();
                return animatedImageFactoryImpl.m1194a(imageDecodeOptions, pooledByteBufferM8642u.getByteBuffer() != null ? AnimatedImageFactoryImpl.f3620a.mo1192c(pooledByteBufferM8642u.getByteBuffer(), imageDecodeOptions) : AnimatedImageFactoryImpl.f3620a.mo1193h(pooledByteBufferM8642u.mo1397k(), pooledByteBufferM8642u.size(), imageDecodeOptions), config);
            } finally {
                closeableReferenceM1340c.close();
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$b */
    public class C10651b implements ImageDecoder2 {
        public C10651b() {
        }

        @Override // p007b.p109f.p161j.p173h.ImageDecoder2
        /* JADX INFO: renamed from: a */
        public CloseableImage mo1322a(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.f19535e == null) {
                animatedFactoryV2Impl.f19535e = new AnimatedImageFactoryImpl(new AnimatedFactoryV2Impl5(animatedFactoryV2Impl), animatedFactoryV2Impl.f19531a);
            }
            AnimatedImageFactory animatedImageFactory = animatedFactoryV2Impl.f19535e;
            Bitmap.Config config = imageDecodeOptions.f3710e;
            AnimatedImageFactoryImpl animatedImageFactoryImpl = (AnimatedImageFactoryImpl) animatedImageFactory;
            Objects.requireNonNull(animatedImageFactoryImpl);
            if (AnimatedImageFactoryImpl.f3621b == null) {
                throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
            }
            CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage2.m1340c();
            Objects.requireNonNull(closeableReferenceM1340c);
            try {
                PooledByteBuffer pooledByteBufferM8642u = closeableReferenceM1340c.m8642u();
                return animatedImageFactoryImpl.m1194a(imageDecodeOptions, pooledByteBufferM8642u.getByteBuffer() != null ? AnimatedImageFactoryImpl.f3621b.mo1192c(pooledByteBufferM8642u.getByteBuffer(), imageDecodeOptions) : AnimatedImageFactoryImpl.f3621b.mo1193h(pooledByteBufferM8642u.mo1397k(), pooledByteBufferM8642u.size(), imageDecodeOptions), config);
            } finally {
                closeableReferenceM1340c.close();
            }
        }
    }

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z2, SerialExecutorService serialExecutorService) {
        this.f19531a = platformBitmapFactory;
        this.f19532b = executorSupplier;
        this.f19533c = countingMemoryCache;
        this.f19534d = z2;
        this.f19539i = serialExecutorService;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedFactory
    /* JADX INFO: renamed from: a */
    public DrawableFactory mo1189a(Context context) {
        if (this.f19538h == null) {
            AnimatedFactoryV2Impl2 animatedFactoryV2Impl2 = new AnimatedFactoryV2Impl2(this);
            ExecutorService defaultSerialExecutorService = this.f19539i;
            if (defaultSerialExecutorService == null) {
                defaultSerialExecutorService = new DefaultSerialExecutorService(this.f19532b.mo1254a());
            }
            ExecutorService executorService = defaultSerialExecutorService;
            AnimatedFactoryV2Impl3 animatedFactoryV2Impl3 = new AnimatedFactoryV2Impl3(this);
            Supplier<Boolean> supplier = Suppliers2.f3101a;
            if (this.f19536f == null) {
                this.f19536f = new AnimatedFactoryV2Impl4(this);
            }
            AnimatedDrawableBackendProvider animatedDrawableBackendProvider = this.f19536f;
            if (UiThreadImmediateExecutorService.f3090k == null) {
                UiThreadImmediateExecutorService.f3090k = new UiThreadImmediateExecutorService();
            }
            this.f19538h = new ExperimentalBitmapAnimationDrawableFactory(animatedDrawableBackendProvider, UiThreadImmediateExecutorService.f3090k, executorService, RealtimeSinceBootClock.get(), this.f19531a, this.f19533c, animatedFactoryV2Impl2, animatedFactoryV2Impl3, supplier);
        }
        return this.f19538h;
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedFactory
    /* JADX INFO: renamed from: b */
    public ImageDecoder2 mo1190b() {
        return new C10650a();
    }

    @Override // p007b.p109f.p161j.p162a.p164b.AnimatedFactory
    /* JADX INFO: renamed from: c */
    public ImageDecoder2 mo1191c() {
        return new C10651b();
    }
}
