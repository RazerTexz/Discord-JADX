package p007b.p109f.p161j.p170e;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Suppliers2;
import p007b.p109f.p115d.p121f.MediaUtils;
import p007b.p109f.p115d.p128m.WebpBitmapFactory;
import p007b.p109f.p115d.p128m.WebpSupportStatus;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p181p.AddImageTransformMetaDataProducer;
import p007b.p109f.p161j.p181p.BitmapMemoryCacheGetProducer;
import p007b.p109f.p161j.p181p.BitmapMemoryCacheKeyMultiplexProducer;
import p007b.p109f.p161j.p181p.BitmapMemoryCacheProducer;
import p007b.p109f.p161j.p181p.BitmapPrepareProducer;
import p007b.p109f.p161j.p181p.BitmapProbeProducer;
import p007b.p109f.p161j.p181p.BranchOnSeparateImagesProducer;
import p007b.p109f.p161j.p181p.DataFetchProducer;
import p007b.p109f.p161j.p181p.DecodeProducer;
import p007b.p109f.p161j.p181p.DelayProducer;
import p007b.p109f.p161j.p181p.DiskCacheReadProducer3;
import p007b.p109f.p161j.p181p.DiskCacheWriteProducer;
import p007b.p109f.p161j.p181p.EncodedCacheKeyMultiplexProducer;
import p007b.p109f.p161j.p181p.EncodedMemoryCacheProducer;
import p007b.p109f.p161j.p181p.EncodedProbeProducer;
import p007b.p109f.p161j.p181p.LocalAssetFetchProducer;
import p007b.p109f.p161j.p181p.LocalContentUriFetchProducer;
import p007b.p109f.p161j.p181p.LocalContentUriThumbnailFetchProducer;
import p007b.p109f.p161j.p181p.LocalFileFetchProducer;
import p007b.p109f.p161j.p181p.LocalResourceFetchProducer;
import p007b.p109f.p161j.p181p.LocalThumbnailBitmapProducer;
import p007b.p109f.p161j.p181p.LocalVideoThumbnailProducer;
import p007b.p109f.p161j.p181p.NetworkFetchProducer;
import p007b.p109f.p161j.p181p.NetworkFetcher2;
import p007b.p109f.p161j.p181p.PartialDiskCacheProducer3;
import p007b.p109f.p161j.p181p.PostprocessedBitmapMemoryCacheProducer;
import p007b.p109f.p161j.p181p.PostprocessorProducer;
import p007b.p109f.p161j.p181p.Producer2;
import p007b.p109f.p161j.p181p.QualifiedResourceFetchProducer;
import p007b.p109f.p161j.p181p.ThreadHandoffProducer;
import p007b.p109f.p161j.p181p.ThreadHandoffProducerQueue;
import p007b.p109f.p161j.p181p.ThrottlingProducer;
import p007b.p109f.p161j.p181p.ThumbnailBranchProducer;
import p007b.p109f.p161j.p181p.ThumbnailProducer;
import p007b.p109f.p161j.p183r.FrescoSystrace;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;

/* compiled from: ProducerSequenceFactory.java */
/* renamed from: b.f.j.e.q, reason: use source file name */
/* loaded from: classes.dex */
public class ProducerSequenceFactory {

    /* renamed from: a */
    public final ContentResolver f3840a;

    /* renamed from: b */
    public final ProducerFactory f3841b;

    /* renamed from: c */
    public final NetworkFetcher2 f3842c;

    /* renamed from: d */
    public final boolean f3843d;

    /* renamed from: e */
    public final boolean f3844e;

    /* renamed from: f */
    public final ThreadHandoffProducerQueue f3845f;

    /* renamed from: g */
    public final boolean f3846g;

    /* renamed from: h */
    public final boolean f3847h;

    /* renamed from: i */
    public final boolean f3848i;

    /* renamed from: j */
    public final ImageTranscoderFactory f3849j;

    /* renamed from: k */
    public final boolean f3850k;

    /* renamed from: l */
    public final boolean f3851l;

    /* renamed from: m */
    public final boolean f3852m;

    /* renamed from: n */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3853n;

    /* renamed from: o */
    @Nullable
    public Producer2<EncodedImage2> f3854o;

    /* renamed from: p */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3855p;

    /* renamed from: q */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3856q;

    /* renamed from: r */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3857r;

    /* renamed from: s */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3858s;

    /* renamed from: t */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3859t;

    /* renamed from: u */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3860u;

    /* renamed from: v */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3861v;

    /* renamed from: w */
    @Nullable
    @VisibleForTesting
    public Producer2<CloseableReference<CloseableImage>> f3862w;

    /* renamed from: x */
    @VisibleForTesting
    public Map<Producer2<CloseableReference<CloseableImage>>, Producer2<CloseableReference<CloseableImage>>> f3863x = new HashMap();

    /* renamed from: y */
    @VisibleForTesting
    public Map<Producer2<CloseableReference<CloseableImage>>, Producer2<CloseableReference<CloseableImage>>> f3864y;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher2 networkFetcher2, boolean z2, boolean z3, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z4, boolean z5, boolean z6, boolean z7, ImageTranscoderFactory imageTranscoderFactory, boolean z8, boolean z9, boolean z10) {
        this.f3840a = contentResolver;
        this.f3841b = producerFactory;
        this.f3842c = networkFetcher2;
        this.f3843d = z2;
        new HashMap();
        this.f3864y = new HashMap();
        this.f3845f = threadHandoffProducerQueue;
        this.f3846g = z4;
        this.f3847h = z5;
        this.f3844e = z6;
        this.f3848i = z7;
        this.f3849j = imageTranscoderFactory;
        this.f3850k = z8;
        this.f3851l = z9;
        this.f3852m = z10;
    }

    /* renamed from: a */
    public final synchronized Producer2<EncodedImage2> m1305a() {
        FrescoSystrace.m1527b();
        if (this.f3854o == null) {
            FrescoSystrace.m1527b();
            ProducerFactory producerFactory = this.f3841b;
            AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = new AddImageTransformMetaDataProducer(m1317m(new NetworkFetchProducer(producerFactory.f3825k, producerFactory.f3818d, this.f3842c)));
            this.f3854o = addImageTransformMetaDataProducer;
            this.f3854o = this.f3841b.m1304a(addImageTransformMetaDataProducer, this.f3843d && !this.f3846g, this.f3849j);
            FrescoSystrace.m1527b();
        }
        FrescoSystrace.m1527b();
        return this.f3854o;
    }

    /* renamed from: b */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1306b() {
        if (this.f3860u == null) {
            DataFetchProducer dataFetchProducer = new DataFetchProducer(this.f3841b.f3825k);
            WebpBitmapFactory webpBitmapFactory = WebpSupportStatus.f3139a;
            this.f3860u = m1314j(this.f3841b.m1304a(new AddImageTransformMetaDataProducer(dataFetchProducer), true, this.f3849j));
        }
        return this.f3860u;
    }

    /* renamed from: c */
    public Producer2<CloseableReference<CloseableImage>> m1307c(ImageRequest imageRequest) {
        Producer2<CloseableReference<CloseableImage>> producer2M1311g;
        DelayProducer delayProducer;
        FrescoSystrace.m1527b();
        try {
            FrescoSystrace.m1527b();
            Objects.requireNonNull(imageRequest);
            Uri uri = imageRequest.f19585c;
            AnimatableValueParser.m591y(uri, "Uri is null.");
            int i = imageRequest.f19586d;
            if (i != 0) {
                boolean z2 = false;
                switch (i) {
                    case 2:
                        producer2M1311g = m1311g();
                        break;
                    case 3:
                        synchronized (this) {
                            if (this.f3855p == null) {
                                ProducerFactory producerFactory = this.f3841b;
                                this.f3855p = m1315k(new LocalFileFetchProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3825k));
                            }
                            producer2M1311g = this.f3855p;
                        }
                        break;
                    case 4:
                        if (imageRequest.f19590h && Build.VERSION.SDK_INT >= 29) {
                            synchronized (this) {
                                if (this.f3861v == null) {
                                    ProducerFactory producerFactory2 = this.f3841b;
                                    this.f3861v = m1313i(new LocalThumbnailBitmapProducer(producerFactory2.f3824j.mo1256c(), producerFactory2.f3815a));
                                }
                                producer2M1311g = this.f3861v;
                            }
                        } else {
                            String type = this.f3840a.getType(uri);
                            Map<String, String> map = MediaUtils.f3103a;
                            if (type != null && type.startsWith("video/")) {
                                z2 = true;
                            }
                            producer2M1311g = !z2 ? m1309e() : m1311g();
                        }
                        break;
                    case 5:
                        producer2M1311g = m1308d();
                        break;
                    case 6:
                        producer2M1311g = m1310f();
                        break;
                    case 7:
                        producer2M1311g = m1306b();
                        break;
                    case 8:
                        producer2M1311g = m1312h();
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported uri scheme! Uri is: ");
                        String strValueOf = String.valueOf(uri);
                        if (strValueOf.length() > 30) {
                            strValueOf = strValueOf.substring(0, 30) + "...";
                        }
                        sb.append(strValueOf);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                synchronized (this) {
                    FrescoSystrace.m1527b();
                    if (this.f3853n == null) {
                        FrescoSystrace.m1527b();
                        this.f3853n = m1314j(m1305a());
                        FrescoSystrace.m1527b();
                    }
                    FrescoSystrace.m1527b();
                    producer2M1311g = this.f3853n;
                }
            }
            if (imageRequest.f19601s != null) {
                synchronized (this) {
                    Producer2<CloseableReference<CloseableImage>> producer2 = this.f3863x.get(producer2M1311g);
                    if (producer2 == null) {
                        ProducerFactory producerFactory3 = this.f3841b;
                        PostprocessorProducer postprocessorProducer = new PostprocessorProducer(producer2M1311g, producerFactory3.f3833s, producerFactory3.f3824j.mo1256c());
                        ProducerFactory producerFactory4 = this.f3841b;
                        PostprocessedBitmapMemoryCacheProducer postprocessedBitmapMemoryCacheProducer = new PostprocessedBitmapMemoryCacheProducer(producerFactory4.f3829o, producerFactory4.f3830p, postprocessorProducer);
                        this.f3863x.put(producer2M1311g, postprocessedBitmapMemoryCacheProducer);
                        producer2M1311g = postprocessedBitmapMemoryCacheProducer;
                    } else {
                        producer2M1311g = producer2;
                    }
                }
            }
            if (this.f3847h) {
                synchronized (this) {
                    Producer2<CloseableReference<CloseableImage>> producer22 = this.f3864y.get(producer2M1311g);
                    if (producer22 == null) {
                        ProducerFactory producerFactory5 = this.f3841b;
                        BitmapPrepareProducer bitmapPrepareProducer = new BitmapPrepareProducer(producer2M1311g, producerFactory5.f3834t, producerFactory5.f3835u, producerFactory5.f3836v);
                        this.f3864y.put(producer2M1311g, bitmapPrepareProducer);
                        producer2M1311g = bitmapPrepareProducer;
                    } else {
                        producer2M1311g = producer22;
                    }
                }
            }
            if (this.f3852m && imageRequest.f19603u > 0) {
                synchronized (this) {
                    delayProducer = new DelayProducer(producer2M1311g, this.f3841b.f3824j.mo1260g());
                }
                producer2M1311g = delayProducer;
            }
            return producer2M1311g;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* renamed from: d */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1308d() {
        if (this.f3859t == null) {
            ProducerFactory producerFactory = this.f3841b;
            this.f3859t = m1315k(new LocalAssetFetchProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3825k, producerFactory.f3817c));
        }
        return this.f3859t;
    }

    /* renamed from: e */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1309e() {
        if (this.f3857r == null) {
            ProducerFactory producerFactory = this.f3841b;
            LocalContentUriFetchProducer localContentUriFetchProducer = new LocalContentUriFetchProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3825k, producerFactory.f3815a);
            ProducerFactory producerFactory2 = this.f3841b;
            Objects.requireNonNull(producerFactory2);
            ProducerFactory producerFactory3 = this.f3841b;
            this.f3857r = m1316l(localContentUriFetchProducer, new ThumbnailProducer[]{new LocalContentUriThumbnailFetchProducer(producerFactory2.f3824j.mo1258e(), producerFactory2.f3825k, producerFactory2.f3815a), new LocalExifThumbnailProducer(producerFactory3.f3824j.mo1259f(), producerFactory3.f3825k, producerFactory3.f3815a)});
        }
        return this.f3857r;
    }

    /* renamed from: f */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1310f() {
        if (this.f3858s == null) {
            ProducerFactory producerFactory = this.f3841b;
            this.f3858s = m1315k(new LocalResourceFetchProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3825k, producerFactory.f3816b));
        }
        return this.f3858s;
    }

    /* renamed from: g */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1311g() {
        if (this.f3856q == null) {
            ProducerFactory producerFactory = this.f3841b;
            this.f3856q = m1313i(new LocalVideoThumbnailProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3815a));
        }
        return this.f3856q;
    }

    /* renamed from: h */
    public final synchronized Producer2<CloseableReference<CloseableImage>> m1312h() {
        if (this.f3862w == null) {
            ProducerFactory producerFactory = this.f3841b;
            this.f3862w = m1315k(new QualifiedResourceFetchProducer(producerFactory.f3824j.mo1258e(), producerFactory.f3825k, producerFactory.f3815a));
        }
        return this.f3862w;
    }

    /* renamed from: i */
    public final Producer2<CloseableReference<CloseableImage>> m1313i(Producer2<CloseableReference<CloseableImage>> producer2) {
        ProducerFactory producerFactory = this.f3841b;
        MemoryCache<CacheKey, CloseableImage> memoryCache = producerFactory.f3829o;
        CacheKeyFactory cacheKeyFactory = producerFactory.f3830p;
        BitmapMemoryCacheKeyMultiplexProducer bitmapMemoryCacheKeyMultiplexProducer = new BitmapMemoryCacheKeyMultiplexProducer(cacheKeyFactory, new BitmapMemoryCacheProducer(memoryCache, cacheKeyFactory, producer2));
        ProducerFactory producerFactory2 = this.f3841b;
        ThreadHandoffProducerQueue threadHandoffProducerQueue = this.f3845f;
        Objects.requireNonNull(producerFactory2);
        ThreadHandoffProducer threadHandoffProducer = new ThreadHandoffProducer(bitmapMemoryCacheKeyMultiplexProducer, threadHandoffProducerQueue);
        if (!this.f3850k && !this.f3851l) {
            ProducerFactory producerFactory3 = this.f3841b;
            return new BitmapMemoryCacheGetProducer(producerFactory3.f3829o, producerFactory3.f3830p, threadHandoffProducer);
        }
        ProducerFactory producerFactory4 = this.f3841b;
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = producerFactory4.f3829o;
        CacheKeyFactory cacheKeyFactory2 = producerFactory4.f3830p;
        return new BitmapProbeProducer(producerFactory4.f3828n, producerFactory4.f3826l, producerFactory4.f3827m, cacheKeyFactory2, producerFactory4.f3831q, producerFactory4.f3832r, new BitmapMemoryCacheGetProducer(memoryCache2, cacheKeyFactory2, threadHandoffProducer));
    }

    /* renamed from: j */
    public final Producer2<CloseableReference<CloseableImage>> m1314j(Producer2<EncodedImage2> producer2) {
        FrescoSystrace.m1527b();
        ProducerFactory producerFactory = this.f3841b;
        Producer2<CloseableReference<CloseableImage>> producer2M1313i = m1313i(new DecodeProducer(producerFactory.f3818d, producerFactory.f3824j.mo1254a(), producerFactory.f3819e, producerFactory.f3820f, producerFactory.f3821g, producerFactory.f3822h, producerFactory.f3823i, producer2, producerFactory.f3838x, producerFactory.f3837w, null, Suppliers2.f3101a));
        FrescoSystrace.m1527b();
        return producer2M1313i;
    }

    /* renamed from: k */
    public final Producer2<CloseableReference<CloseableImage>> m1315k(Producer2<EncodedImage2> producer2) {
        ProducerFactory producerFactory = this.f3841b;
        return m1316l(producer2, new ThumbnailProducer[]{new LocalExifThumbnailProducer(producerFactory.f3824j.mo1259f(), producerFactory.f3825k, producerFactory.f3815a)});
    }

    /* renamed from: l */
    public final Producer2<CloseableReference<CloseableImage>> m1316l(Producer2<EncodedImage2> producer2, ThumbnailProducer<EncodedImage2>[] thumbnailProducerArr) {
        ThrottlingProducer throttlingProducer = new ThrottlingProducer(5, this.f3841b.f3824j.mo1255b(), this.f3841b.m1304a(new AddImageTransformMetaDataProducer(m1317m(producer2)), true, this.f3849j));
        Objects.requireNonNull(this.f3841b);
        return m1314j(new BranchOnSeparateImagesProducer(this.f3841b.m1304a(new ThumbnailBranchProducer(thumbnailProducerArr), true, this.f3849j), throttlingProducer));
    }

    /* renamed from: m */
    public final Producer2<EncodedImage2> m1317m(Producer2<EncodedImage2> producer2) {
        DiskCacheWriteProducer diskCacheWriteProducer;
        WebpBitmapFactory webpBitmapFactory = WebpSupportStatus.f3139a;
        if (this.f3848i) {
            FrescoSystrace.m1527b();
            if (this.f3844e) {
                ProducerFactory producerFactory = this.f3841b;
                BufferedDiskCache2 bufferedDiskCache2 = producerFactory.f3826l;
                CacheKeyFactory cacheKeyFactory = producerFactory.f3830p;
                diskCacheWriteProducer = new DiskCacheWriteProducer(bufferedDiskCache2, producerFactory.f3827m, cacheKeyFactory, new PartialDiskCacheProducer3(bufferedDiskCache2, cacheKeyFactory, producerFactory.f3825k, producerFactory.f3818d, producer2));
            } else {
                ProducerFactory producerFactory2 = this.f3841b;
                diskCacheWriteProducer = new DiskCacheWriteProducer(producerFactory2.f3826l, producerFactory2.f3827m, producerFactory2.f3830p, producer2);
            }
            ProducerFactory producerFactory3 = this.f3841b;
            DiskCacheReadProducer3 diskCacheReadProducer3 = new DiskCacheReadProducer3(producerFactory3.f3826l, producerFactory3.f3827m, producerFactory3.f3830p, diskCacheWriteProducer);
            FrescoSystrace.m1527b();
            producer2 = diskCacheReadProducer3;
        }
        ProducerFactory producerFactory4 = this.f3841b;
        MemoryCache<CacheKey, PooledByteBuffer> memoryCache = producerFactory4.f3828n;
        CacheKeyFactory cacheKeyFactory2 = producerFactory4.f3830p;
        EncodedMemoryCacheProducer encodedMemoryCacheProducer = new EncodedMemoryCacheProducer(memoryCache, cacheKeyFactory2, producer2);
        if (!this.f3851l) {
            return new EncodedCacheKeyMultiplexProducer(cacheKeyFactory2, producerFactory4.f3839y, encodedMemoryCacheProducer);
        }
        return new EncodedCacheKeyMultiplexProducer(cacheKeyFactory2, producerFactory4.f3839y, new EncodedProbeProducer(producerFactory4.f3826l, producerFactory4.f3827m, cacheKeyFactory2, producerFactory4.f3831q, producerFactory4.f3832r, encodedMemoryCacheProducer));
    }
}
