package p007b.p109f.p161j.p181p;

import android.graphics.Bitmap;
import androidx.core.os.EnvironmentCompat;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p169d.ImageDecodeOptions;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p170e.CloseableReferenceFactory;
import p007b.p109f.p161j.p173h.ImageDecoder2;
import p007b.p109f.p161j.p173h.ProgressiveJpegConfig;
import p007b.p109f.p161j.p173h.ProgressiveJpegParser;
import p007b.p109f.p161j.p175j.CloseableBitmap;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;
import p007b.p109f.p161j.p175j.QualityInfo;
import p007b.p109f.p161j.p181p.JobScheduler;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.p.n, reason: use source file name */
/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DecodeProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a */
    public final ByteArrayPool f4143a;

    /* JADX INFO: renamed from: b */
    public final Executor f4144b;

    /* JADX INFO: renamed from: c */
    public final ImageDecoder2 f4145c;

    /* JADX INFO: renamed from: d */
    public final ProgressiveJpegConfig f4146d;

    /* JADX INFO: renamed from: e */
    public final Producer2<EncodedImage2> f4147e;

    /* JADX INFO: renamed from: f */
    public final boolean f4148f;

    /* JADX INFO: renamed from: g */
    public final boolean f4149g;

    /* JADX INFO: renamed from: h */
    public final boolean f4150h;

    /* JADX INFO: renamed from: i */
    public final int f4151i;

    /* JADX INFO: renamed from: j */
    public final CloseableReferenceFactory f4152j;

    /* JADX INFO: renamed from: k */
    public final Runnable f4153k;

    /* JADX INFO: renamed from: l */
    public final Supplier<Boolean> f4154l;

    /* JADX INFO: renamed from: b.f.j.p.n$a */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class a extends c {
        public a(DecodeProducer decodeProducer, Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, boolean z2, int i) {
            super(consumer2, producerContext, z2, i);
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: o */
        public int mo1495o(EncodedImage2 encodedImage2) {
            return encodedImage2.m1344n();
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: p */
        public QualityInfo mo1496p() {
            return new ImmutableQualityInfo(0, false, false);
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: w */
        public synchronized boolean mo1497w(EncodedImage2 encodedImage2, int i) {
            if (BaseConsumer.m1420f(i)) {
                return false;
            }
            return this.f4162g.m1435f(encodedImage2, i);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$b */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public class b extends c {

        /* JADX INFO: renamed from: i */
        public final ProgressiveJpegParser f4155i;

        /* JADX INFO: renamed from: j */
        public final ProgressiveJpegConfig f4156j;

        /* JADX INFO: renamed from: k */
        public int f4157k;

        public b(DecodeProducer decodeProducer, Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, int i) {
            super(consumer2, producerContext, z2, i);
            this.f4155i = progressiveJpegParser;
            Objects.requireNonNull(progressiveJpegConfig);
            this.f4156j = progressiveJpegConfig;
            this.f4157k = 0;
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: o */
        public int mo1495o(EncodedImage2 encodedImage2) {
            return this.f4155i.f3878f;
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: p */
        public QualityInfo mo1496p() {
            return this.f4156j.mo1324a(this.f4155i.f3877e);
        }

        @Override // p007b.p109f.p161j.p181p.DecodeProducer.c
        /* JADX INFO: renamed from: w */
        public synchronized boolean mo1497w(EncodedImage2 encodedImage2, int i) {
            boolean zM1435f = this.f4162g.m1435f(encodedImage2, i);
            if ((BaseConsumer.m1420f(i) || BaseConsumer.m1422m(i, 8)) && !BaseConsumer.m1422m(i, 4) && EncodedImage2.m1338u(encodedImage2)) {
                encodedImage2.m1347x();
                if (encodedImage2.f3893l == DefaultImageFormats.f3585a) {
                    if (!this.f4155i.m1327b(encodedImage2)) {
                        return false;
                    }
                    int i2 = this.f4155i.f3877e;
                    int i3 = this.f4157k;
                    if (i2 <= i3) {
                        return false;
                    }
                    if (i2 < this.f4156j.mo1325b(i3) && !this.f4155i.f3879g) {
                        return false;
                    }
                    this.f4157k = i2;
                }
            }
            return zM1435f;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.n$c */
    /* JADX INFO: compiled from: DecodeProducer.java */
    public abstract class c extends DelegatingConsumer<EncodedImage2, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c */
        public final ProducerContext f4158c;

        /* JADX INFO: renamed from: d */
        public final ProducerListener2 f4159d;

        /* JADX INFO: renamed from: e */
        public final ImageDecodeOptions f4160e;

        /* JADX INFO: renamed from: f */
        public boolean f4161f;

        /* JADX INFO: renamed from: g */
        public final JobScheduler f4162g;

        /* JADX INFO: renamed from: b.f.j.p.n$c$a */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class a implements JobScheduler.c {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ ProducerContext f4164a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ int f4165b;

            public a(DecodeProducer decodeProducer, ProducerContext producerContext, int i) {
                this.f4164a = producerContext;
                this.f4165b = i;
            }

            @Override // p007b.p109f.p161j.p181p.JobScheduler.c
            /* JADX INFO: renamed from: a */
            public void mo1436a(EncodedImage2 encodedImage2, int i) {
                boolean z2;
                String str;
                long j;
                CloseableImage closeableImageM1502t;
                int i2 = i;
                if (encodedImage2 != null) {
                    ProducerContext producerContext = c.this.f4158c;
                    encodedImage2.m1347x();
                    producerContext.mo1446d("image_format", encodedImage2.f3893l.f3598b);
                    if (DecodeProducer.this.f4148f || !BaseConsumer.m1422m(i2, 16)) {
                        ImageRequest imageRequestMo1447e = this.f4164a.mo1447e();
                        if (DecodeProducer.this.f4149g || !UriUtil.m1009e(imageRequestMo1447e.f19585c)) {
                            encodedImage2.f3898q = AnimatableValueParser.m496a0(imageRequestMo1447e.f19593k, imageRequestMo1447e.f19592j, encodedImage2, this.f4165b);
                        }
                    }
                    Objects.requireNonNull(this.f4164a.mo1449g().getExperiments());
                    c cVar = c.this;
                    Objects.requireNonNull(cVar);
                    encodedImage2.m1347x();
                    if (encodedImage2.f3893l == DefaultImageFormats.f3585a || !BaseConsumer.m1420f(i)) {
                        synchronized (cVar) {
                            z2 = cVar.f4161f;
                        }
                        if (z2 || !EncodedImage2.m1338u(encodedImage2)) {
                            return;
                        }
                        encodedImage2.m1347x();
                        ImageFormat imageFormat = encodedImage2.f3893l;
                        String str2 = imageFormat != null ? imageFormat.f3598b : EnvironmentCompat.MEDIA_UNKNOWN;
                        StringBuilder sb = new StringBuilder();
                        encodedImage2.m1347x();
                        sb.append(encodedImage2.f3896o);
                        sb.append("x");
                        encodedImage2.m1347x();
                        sb.append(encodedImage2.f3897p);
                        String string = sb.toString();
                        String strValueOf = String.valueOf(encodedImage2.f3898q);
                        boolean zM1419e = BaseConsumer.m1419e(i);
                        boolean z3 = zM1419e && !BaseConsumer.m1422m(i2, 8);
                        boolean zM1422m = BaseConsumer.m1422m(i2, 4);
                        ResizeOptions resizeOptions = cVar.f4158c.mo1447e().f19592j;
                        if (resizeOptions != null) {
                            str = resizeOptions.f3717a + "x" + resizeOptions.f3718b;
                        } else {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        }
                        String str3 = str;
                        try {
                            JobScheduler jobScheduler = cVar.f4162g;
                            synchronized (jobScheduler) {
                                j = jobScheduler.f4008j - jobScheduler.f4007i;
                            }
                            String strValueOf2 = String.valueOf(cVar.f4158c.mo1447e().f19585c);
                            int iM1344n = (z3 || zM1422m) ? encodedImage2.m1344n() : cVar.mo1495o(encodedImage2);
                            QualityInfo qualityInfoMo1496p = (z3 || zM1422m) ? ImmutableQualityInfo.f3908a : cVar.mo1496p();
                            cVar.f4159d.mo1358e(cVar.f4158c, "DecodeProducer");
                            try {
                                try {
                                    closeableImageM1502t = cVar.m1502t(encodedImage2, iM1344n, qualityInfoMo1496p);
                                } catch (DecodeException e) {
                                    EncodedImage2 encodedImage2M8696a = e.m8696a();
                                    FLog.m987o("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), strValueOf2, encodedImage2M8696a.m1341d(10), Integer.valueOf(encodedImage2M8696a.m1344n()));
                                    throw e;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                closeableImageM1502t = null;
                            }
                            try {
                                if (encodedImage2.f3898q != 1) {
                                    i2 |= 16;
                                }
                                cVar.f4159d.mo1363j(cVar.f4158c, "DecodeProducer", cVar.m1498n(closeableImageM1502t, j, qualityInfoMo1496p, zM1419e, str2, string, str3, strValueOf));
                                cVar.m1504v(encodedImage2, closeableImageM1502t);
                                cVar.m1501s(closeableImageM1502t, i2);
                            } catch (Exception e3) {
                                e = e3;
                                cVar.f4159d.mo1364k(cVar.f4158c, "DecodeProducer", e, cVar.m1498n(closeableImageM1502t, j, qualityInfoMo1496p, zM1419e, str2, string, str3, strValueOf));
                                cVar.m1503u(true);
                                cVar.f4179b.mo1425c(e);
                            }
                        } finally {
                            encodedImage2.close();
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.n$c$b */
        /* JADX INFO: compiled from: DecodeProducer.java */
        public class b extends BaseProducerContextCallbacks {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ boolean f4167a;

            public b(DecodeProducer decodeProducer, boolean z2) {
                this.f4167a = z2;
            }

            @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                if (this.f4167a) {
                    c cVar = c.this;
                    cVar.m1503u(true);
                    cVar.f4179b.mo1426d();
                }
            }

            @Override // p007b.p109f.p161j.p181p.BaseProducerContextCallbacks, p007b.p109f.p161j.p181p.ProducerContextCallbacks
            /* JADX INFO: renamed from: b */
            public void mo1439b() {
                if (c.this.f4158c.mo1458p()) {
                    c.this.f4162g.m1434d();
                }
            }
        }

        public c(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, boolean z2, int i) {
            super(consumer2);
            this.f4158c = producerContext;
            this.f4159d = producerContext.mo1457o();
            ImageDecodeOptions imageDecodeOptions = producerContext.mo1447e().f19591i;
            this.f4160e = imageDecodeOptions;
            this.f4161f = false;
            this.f4162g = new JobScheduler(DecodeProducer.this.f4144b, new a(DecodeProducer.this, producerContext, i), imageDecodeOptions.f3707b);
            producerContext.mo1448f(new b(DecodeProducer.this, z2));
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            m1499q();
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            m1500r(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            try {
                FrescoSystrace.m1527b();
                boolean zM1419e = BaseConsumer.m1419e(i);
                if (zM1419e) {
                    if (encodedImage2 == null) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                        m1503u(true);
                        this.f4179b.mo1425c(exceptionWithNoStacktrace);
                    } else if (!encodedImage2.m1346t()) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                        m1503u(true);
                        this.f4179b.mo1425c(exceptionWithNoStacktrace2);
                    }
                } else if (mo1497w(encodedImage2, i)) {
                    boolean zM1422m = BaseConsumer.m1422m(i, 4);
                    if (zM1419e || zM1422m || this.f4158c.mo1458p()) {
                        this.f4162g.m1434d();
                    }
                }
            } finally {
                FrescoSystrace.m1527b();
            }
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: j */
        public void mo1321j(float f) {
            this.f4179b.mo1423a(f * 0.99f);
        }

        /* JADX INFO: renamed from: n */
        public final Map<String, String> m1498n(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z2, String str, String str2, String str3, String str4) {
            if (!this.f4159d.mo1360g(this.f4158c, "DecodeProducer")) {
                return null;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(((ImmutableQualityInfo) qualityInfo).f3910c);
            String strValueOf3 = String.valueOf(z2);
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                HashMap map = new HashMap(7);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", str2);
                map.put("imageFormat", str);
                map.put("requestedImageSize", str3);
                map.put("sampleSize", str4);
                return new ImmutableMap(map);
            }
            Bitmap bitmap = ((CloseableStaticBitmap) closeableImage).f3887m;
            Objects.requireNonNull(bitmap);
            String str5 = bitmap.getWidth() + "x" + bitmap.getHeight();
            HashMap map2 = new HashMap(8);
            map2.put("bitmapSize", str5);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", str2);
            map2.put("imageFormat", str);
            map2.put("requestedImageSize", str3);
            map2.put("sampleSize", str4);
            map2.put("byteCount", bitmap.getByteCount() + "");
            return new ImmutableMap(map2);
        }

        /* JADX INFO: renamed from: o */
        public abstract int mo1495o(EncodedImage2 encodedImage2);

        /* JADX INFO: renamed from: p */
        public abstract QualityInfo mo1496p();

        /* JADX INFO: renamed from: q */
        public final void m1499q() {
            m1503u(true);
            this.f4179b.mo1426d();
        }

        /* JADX INFO: renamed from: r */
        public final void m1500r(Throwable th) {
            m1503u(true);
            this.f4179b.mo1425c(th);
        }

        /* JADX INFO: renamed from: s */
        public final void m1501s(CloseableImage closeableImage, int i) {
            CloseableReference.InterfaceC10637c interfaceC10637c = DecodeProducer.this.f4152j.f3725a;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            CloseableReference closeableReferenceM8635I = null;
            if (closeableImage != null) {
                closeableReferenceM8635I = CloseableReference.m8635I(closeableImage, CloseableReference.f19440l, interfaceC10637c, interfaceC10637c.mo1253b() ? new Throwable() : null);
            }
            try {
                m1503u(BaseConsumer.m1419e(i));
                this.f4179b.mo1424b(closeableReferenceM8635I, i);
            } finally {
                if (closeableReferenceM8635I != null) {
                    closeableReferenceM8635I.close();
                }
            }
        }

        /* JADX INFO: renamed from: t */
        public final CloseableImage m1502t(EncodedImage2 encodedImage2, int i, QualityInfo qualityInfo) {
            DecodeProducer decodeProducer = DecodeProducer.this;
            boolean z2 = decodeProducer.f4153k != null && decodeProducer.f4154l.get().booleanValue();
            try {
                return DecodeProducer.this.f4145c.mo1322a(encodedImage2, i, qualityInfo, this.f4160e);
            } catch (OutOfMemoryError e) {
                if (!z2) {
                    throw e;
                }
                DecodeProducer.this.f4153k.run();
                System.gc();
                return DecodeProducer.this.f4145c.mo1322a(encodedImage2, i, qualityInfo, this.f4160e);
            }
        }

        /* JADX INFO: renamed from: u */
        public final void m1503u(boolean z2) {
            synchronized (this) {
                if (z2) {
                    if (!this.f4161f) {
                        this.f4179b.mo1423a(1.0f);
                        this.f4161f = true;
                        this.f4162g.m1431a();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: v */
        public final void m1504v(EncodedImage2 encodedImage2, CloseableImage closeableImage) {
            ProducerContext producerContext = this.f4158c;
            encodedImage2.m1347x();
            producerContext.mo1446d("encoded_width", Integer.valueOf(encodedImage2.f3896o));
            ProducerContext producerContext2 = this.f4158c;
            encodedImage2.m1347x();
            producerContext2.mo1446d("encoded_height", Integer.valueOf(encodedImage2.f3897p));
            this.f4158c.mo1446d("encoded_size", Integer.valueOf(encodedImage2.m1344n()));
            if (closeableImage instanceof CloseableBitmap) {
                Bitmap bitmapMo1332f = ((CloseableBitmap) closeableImage).mo1332f();
                this.f4158c.mo1446d("bitmap_config", String.valueOf(bitmapMo1332f == null ? null : bitmapMo1332f.getConfig()));
            }
            if (closeableImage != null) {
                closeableImage.m1335e(this.f4158c.mo1443a());
            }
        }

        /* JADX INFO: renamed from: w */
        public abstract boolean mo1497w(EncodedImage2 encodedImage2, int i);
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder2 imageDecoder2, ProgressiveJpegConfig progressiveJpegConfig, boolean z2, boolean z3, boolean z4, Producer2<EncodedImage2> producer2, int i, CloseableReferenceFactory closeableReferenceFactory, Runnable runnable, Supplier<Boolean> supplier) {
        Objects.requireNonNull(byteArrayPool);
        this.f4143a = byteArrayPool;
        Objects.requireNonNull(executor);
        this.f4144b = executor;
        Objects.requireNonNull(imageDecoder2);
        this.f4145c = imageDecoder2;
        Objects.requireNonNull(progressiveJpegConfig);
        this.f4146d = progressiveJpegConfig;
        this.f4148f = z2;
        this.f4149g = z3;
        Objects.requireNonNull(producer2);
        this.f4147e = producer2;
        this.f4150h = z4;
        this.f4151i = i;
        this.f4152j = closeableReferenceFactory;
        this.f4153k = null;
        this.f4154l = supplier;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            this.f4147e.mo1417b(!UriUtil.m1009e(producerContext.mo1447e().f19585c) ? new a(this, consumer2, producerContext, this.f4150h, this.f4151i) : new b(this, consumer2, producerContext, new ProgressiveJpegParser(this.f4143a), this.f4146d, this.f4150h, this.f4151i), producerContext);
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
