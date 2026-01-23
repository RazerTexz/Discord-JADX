package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteBufferOutputStream;
import p007b.p109f.p115d.p127l.TriState;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p181p.JobScheduler;
import p007b.p109f.p161j.p184s.ImageTranscodeResult;
import p007b.p109f.p161j.p184s.ImageTranscoder;
import p007b.p109f.p161j.p184s.ImageTranscoderFactory;
import p007b.p109f.p161j.p184s.JpegTranscoderUtils;

/* JADX INFO: renamed from: b.f.j.p.c1, reason: use source file name */
/* JADX INFO: compiled from: ResizeAndRotateProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResizeAndRotateProducer implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final Executor f4011a;

    /* JADX INFO: renamed from: b */
    public final PooledByteBufferFactory f4012b;

    /* JADX INFO: renamed from: c */
    public final Producer2<EncodedImage2> f4013c;

    /* JADX INFO: renamed from: d */
    public final boolean f4014d;

    /* JADX INFO: renamed from: e */
    public final ImageTranscoderFactory f4015e;

    /* JADX INFO: renamed from: b.f.j.p.c1$a */
    /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
    public class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public final boolean f4016c;

        /* JADX INFO: renamed from: d */
        public final ImageTranscoderFactory f4017d;

        /* JADX INFO: renamed from: e */
        public final ProducerContext f4018e;

        /* JADX INFO: renamed from: f */
        public boolean f4019f;

        /* JADX INFO: renamed from: g */
        public final JobScheduler f4020g;

        /* JADX INFO: renamed from: b.f.j.p.c1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class C13220a implements JobScheduler.c {
            public C13220a(ResizeAndRotateProducer resizeAndRotateProducer) {
            }

            @Override // p007b.p109f.p161j.p181p.JobScheduler.c
            /* JADX INFO: renamed from: a */
            public void mo1436a(EncodedImage2 encodedImage2, int i) throws Throwable {
                ImageTranscodeResult imageTranscodeResultMo1530c;
                a aVar = a.this;
                ImageTranscoderFactory imageTranscoderFactory = aVar.f4017d;
                encodedImage2.m1347x();
                ImageTranscoder imageTranscoderCreateImageTranscoder = imageTranscoderFactory.createImageTranscoder(encodedImage2.f3893l, a.this.f4016c);
                Objects.requireNonNull(imageTranscoderCreateImageTranscoder);
                aVar.f4018e.mo1457o().mo1358e(aVar.f4018e, "ResizeAndRotateProducer");
                ImageRequest imageRequestMo1447e = aVar.f4018e.mo1447e();
                PooledByteBufferOutputStream pooledByteBufferOutputStreamMo993a = ResizeAndRotateProducer.this.f4012b.mo993a();
                try {
                    try {
                        imageTranscodeResultMo1530c = imageTranscoderCreateImageTranscoder.mo1530c(encodedImage2, pooledByteBufferOutputStreamMo993a, imageRequestMo1447e.f19593k, imageRequestMo1447e.f19592j, null, 85);
                    } catch (Exception e) {
                        aVar.f4018e.mo1457o().mo1364k(aVar.f4018e, "ResizeAndRotateProducer", e, null);
                        if (BaseConsumer.m1419e(i)) {
                            aVar.f4179b.mo1425c(e);
                        }
                    }
                    if (imageTranscodeResultMo1530c.f4267a == 2) {
                        throw new RuntimeException("Error while transcoding the image");
                    }
                    Map<String, String> mapM1437n = aVar.m1437n(encodedImage2, imageRequestMo1447e.f19592j, imageTranscodeResultMo1530c, imageTranscoderCreateImageTranscoder.mo1528a());
                    CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamMo993a).m8707b());
                    try {
                        EncodedImage2 encodedImage22 = new EncodedImage2(closeableReferenceM8632A);
                        encodedImage22.f3893l = DefaultImageFormats.f3585a;
                        try {
                            encodedImage22.m1345q();
                            aVar.f4018e.mo1457o().mo1363j(aVar.f4018e, "ResizeAndRotateProducer", mapM1437n);
                            if (imageTranscodeResultMo1530c.f4267a != 1) {
                                i |= 16;
                            }
                            aVar.f4179b.mo1424b(encodedImage22, i);
                        } finally {
                            encodedImage22.close();
                        }
                    } finally {
                        if (closeableReferenceM8632A != null) {
                            closeableReferenceM8632A.close();
                        }
                    }
                } finally {
                    pooledByteBufferOutputStreamMo993a.close();
                }
            }
        }

        /* JADX INFO: renamed from: b.f.j.p.c1$a$b */
        /* JADX INFO: compiled from: ResizeAndRotateProducer.java */
        public class b extends BaseProducerContextCallbacks {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ Consumer2 f4023a;

            public b(ResizeAndRotateProducer resizeAndRotateProducer, Consumer2 consumer2) {
                this.f4023a = consumer2;
            }

            @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                a.this.f4020g.m1431a();
                a.this.f4019f = true;
                this.f4023a.mo1426d();
            }

            @Override // p007b.p109f.p161j.p181p.BaseProducerContextCallbacks, p007b.p109f.p161j.p181p.ProducerContextCallbacks
            /* JADX INFO: renamed from: b */
            public void mo1439b() {
                if (a.this.f4018e.mo1458p()) {
                    a.this.f4020g.m1434d();
                }
            }
        }

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer2);
            this.f4019f = false;
            this.f4018e = producerContext;
            Objects.requireNonNull(producerContext.mo1447e());
            this.f4016c = z2;
            this.f4017d = imageTranscoderFactory;
            this.f4020g = new JobScheduler(ResizeAndRotateProducer.this.f4011a, new C13220a(ResizeAndRotateProducer.this), 100);
            producerContext.mo1448f(new b(ResizeAndRotateProducer.this, consumer2));
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo1320i(Object obj, int i) {
            boolean z2;
            TriState triStateM1004f;
            boolean zContains;
            EncodedImage2 encodedImage2M1336a = (EncodedImage2) obj;
            TriState triState = TriState.UNSET;
            if (this.f4019f) {
                return;
            }
            boolean zM1419e = BaseConsumer.m1419e(i);
            boolean z3 = true;
            if (encodedImage2M1336a == null) {
                if (zM1419e) {
                    this.f4179b.mo1424b(null, 1);
                    return;
                }
                return;
            }
            encodedImage2M1336a.m1347x();
            ImageFormat imageFormat = encodedImage2M1336a.f3893l;
            ImageRequest imageRequestMo1447e = this.f4018e.mo1447e();
            ImageTranscoder imageTranscoderCreateImageTranscoder = this.f4017d.createImageTranscoder(imageFormat, this.f4016c);
            Objects.requireNonNull(imageTranscoderCreateImageTranscoder);
            encodedImage2M1336a.m1347x();
            if (encodedImage2M1336a.f3893l == ImageFormat.f3597a) {
                triStateM1004f = triState;
            } else {
                encodedImage2M1336a.m1347x();
                if (imageTranscoderCreateImageTranscoder.mo1531d(encodedImage2M1336a.f3893l)) {
                    RotationOptions rotationOptions = imageRequestMo1447e.f19593k;
                    if (rotationOptions.f3724d) {
                        z2 = false;
                        if (!z2 && !imageTranscoderCreateImageTranscoder.mo1529b(encodedImage2M1336a, imageRequestMo1447e.f19593k, imageRequestMo1447e.f19592j)) {
                            z3 = false;
                        }
                        triStateM1004f = TriState.m1004f(z3);
                    } else {
                        if (JpegTranscoderUtils.m1533b(rotationOptions, encodedImage2M1336a) == 0) {
                            if (!rotationOptions.m1250b() || rotationOptions.f3724d) {
                                encodedImage2M1336a.f3895n = 0;
                                zContains = false;
                            } else {
                                ImmutableList<Integer> immutableList = JpegTranscoderUtils.f4268a;
                                encodedImage2M1336a.m1347x();
                                zContains = immutableList.contains(Integer.valueOf(encodedImage2M1336a.f3895n));
                            }
                            if (zContains) {
                            }
                            if (!z2) {
                                z3 = false;
                            }
                            triStateM1004f = TriState.m1004f(z3);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        triStateM1004f = TriState.m1004f(z3);
                    }
                } else {
                    triStateM1004f = TriState.NO;
                }
            }
            if (zM1419e || triStateM1004f != triState) {
                if (triStateM1004f == TriState.YES) {
                    if (this.f4020g.m1435f(encodedImage2M1336a, i)) {
                        if (zM1419e || this.f4018e.mo1458p()) {
                            this.f4020g.m1434d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (imageFormat != DefaultImageFormats.f3585a && imageFormat != DefaultImageFormats.f3595k) {
                    RotationOptions rotationOptions2 = this.f4018e.mo1447e().f19593k;
                    if (!rotationOptions2.m1251c() && rotationOptions2.m1250b()) {
                        int iM1249a = rotationOptions2.m1249a();
                        encodedImage2M1336a = EncodedImage2.m1336a(encodedImage2M1336a);
                        if (encodedImage2M1336a != null) {
                            encodedImage2M1336a.f3894m = iM1249a;
                        }
                    }
                } else if (!this.f4018e.mo1447e().f19593k.f3724d) {
                    encodedImage2M1336a.m1347x();
                    if (encodedImage2M1336a.f3894m != 0) {
                        encodedImage2M1336a.m1347x();
                        if (encodedImage2M1336a.f3894m != -1 && (encodedImage2M1336a = EncodedImage2.m1336a(encodedImage2M1336a)) != null) {
                            encodedImage2M1336a.f3894m = 0;
                        }
                    }
                }
                this.f4179b.mo1424b(encodedImage2M1336a, i);
            }
        }

        /* JADX INFO: renamed from: n */
        public final Map<String, String> m1437n(EncodedImage2 encodedImage2, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            long j;
            if (!this.f4018e.mo1457o().mo1360g(this.f4018e, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            encodedImage2.m1347x();
            sb.append(encodedImage2.f3896o);
            sb.append("x");
            encodedImage2.m1347x();
            sb.append(encodedImage2.f3897p);
            String string = sb.toString();
            if (resizeOptions != null) {
                str2 = resizeOptions.f3717a + "x" + resizeOptions.f3718b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            encodedImage2.m1347x();
            map.put("Image format", String.valueOf(encodedImage2.f3893l));
            map.put("Original size", string);
            map.put("Requested size", str2);
            JobScheduler jobScheduler = this.f4020g;
            synchronized (jobScheduler) {
                j = jobScheduler.f4008j - jobScheduler.f4007i;
            }
            map.put("queueTime", String.valueOf(j));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return new ImmutableMap(map);
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer2<EncodedImage2> producer2, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
        Objects.requireNonNull(executor);
        this.f4011a = executor;
        Objects.requireNonNull(pooledByteBufferFactory);
        this.f4012b = pooledByteBufferFactory;
        Objects.requireNonNull(producer2);
        this.f4013c = producer2;
        Objects.requireNonNull(imageTranscoderFactory);
        this.f4015e = imageTranscoderFactory;
        this.f4014d = z2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.f4013c.mo1417b(new a(consumer2, producerContext, this.f4014d, this.f4015e), producerContext);
    }
}
