package p007b.p109f.p161j.p181p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p182q.Postprocessor;
import p007b.p109f.p161j.p182q.RepeatedPostprocessor;
import p007b.p109f.p161j.p182q.RepeatedPostprocessorRunner;

/* JADX INFO: renamed from: b.f.j.p.t0, reason: use source file name */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PostprocessorProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a */
    public final Producer2<CloseableReference<CloseableImage>> f4221a;

    /* JADX INFO: renamed from: b */
    public final PlatformBitmapFactory f4222b;

    /* JADX INFO: renamed from: c */
    public final Executor f4223c;

    /* JADX INFO: renamed from: b.f.j.p.t0$b */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class b extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: c */
        public final ProducerListener2 f4224c;

        /* JADX INFO: renamed from: d */
        public final ProducerContext f4225d;

        /* JADX INFO: renamed from: e */
        public final Postprocessor f4226e;

        /* JADX INFO: renamed from: f */
        public boolean f4227f;

        /* JADX INFO: renamed from: g */
        public CloseableReference<CloseableImage> f4228g;

        /* JADX INFO: renamed from: h */
        public int f4229h;

        /* JADX INFO: renamed from: i */
        public boolean f4230i;

        /* JADX INFO: renamed from: j */
        public boolean f4231j;

        /* JADX INFO: renamed from: b.f.j.p.t0$b$a */
        /* JADX INFO: compiled from: PostprocessorProducer.java */
        public class a extends BaseProducerContextCallbacks {
            public a(PostprocessorProducer postprocessorProducer) {
            }

            @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
            /* JADX INFO: renamed from: a */
            public void mo1438a() {
                b bVar = b.this;
                if (bVar.m1518o()) {
                    bVar.f4179b.mo1426d();
                }
            }
        }

        public b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer2);
            this.f4228g = null;
            this.f4229h = 0;
            this.f4230i = false;
            this.f4231j = false;
            this.f4224c = producerListener2;
            this.f4226e = postprocessor;
            this.f4225d = producerContext;
            producerContext.mo1448f(new a(PostprocessorProducer.this));
        }

        /* JADX INFO: renamed from: n */
        public static void m1517n(b bVar, CloseableReference closeableReference, int i) {
            Objects.requireNonNull(bVar);
            AnimatableValueParser.m527i(Boolean.valueOf(CloseableReference.m8640y(closeableReference)));
            if (!(((CloseableImage) closeableReference.m8642u()) instanceof CloseableStaticBitmap)) {
                bVar.m1520q(closeableReference, i);
                return;
            }
            bVar.f4224c.mo1358e(bVar.f4225d, "PostprocessorProducer");
            CloseableReference<CloseableImage> closeableReferenceM1521r = null;
            try {
                try {
                    closeableReferenceM1521r = bVar.m1521r((CloseableImage) closeableReference.m8642u());
                    ProducerListener2 producerListener2 = bVar.f4224c;
                    ProducerContext producerContext = bVar.f4225d;
                    producerListener2.mo1363j(producerContext, "PostprocessorProducer", bVar.m1519p(producerListener2, producerContext, bVar.f4226e));
                    bVar.m1520q(closeableReferenceM1521r, i);
                } catch (Exception e) {
                    ProducerListener2 producerListener22 = bVar.f4224c;
                    ProducerContext producerContext2 = bVar.f4225d;
                    producerListener22.mo1364k(producerContext2, "PostprocessorProducer", e, bVar.m1519p(producerListener22, producerContext2, bVar.f4226e));
                    if (bVar.m1518o()) {
                        bVar.f4179b.mo1425c(e);
                    }
                }
            } finally {
                if (closeableReferenceM1521r != null) {
                    closeableReferenceM1521r.close();
                }
            }
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            if (m1518o()) {
                this.f4179b.mo1426d();
            }
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (m1518o()) {
                this.f4179b.mo1425c(th);
            }
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.m8640y(closeableReference)) {
                if (BaseConsumer.m1419e(i)) {
                    m1520q(null, i);
                    return;
                }
                return;
            }
            synchronized (this) {
                if (!this.f4227f) {
                    CloseableReference<CloseableImage> closeableReference2 = this.f4228g;
                    this.f4228g = CloseableReference.m8636n(closeableReference);
                    this.f4229h = i;
                    this.f4230i = true;
                    boolean zM1522s = m1522s();
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                    if (zM1522s) {
                        PostprocessorProducer.this.f4223c.execute(new PostprocessorProducer2(this));
                    }
                }
            }
        }

        /* JADX INFO: renamed from: o */
        public final boolean m1518o() {
            synchronized (this) {
                if (this.f4227f) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.f4228g;
                this.f4228g = null;
                this.f4227f = true;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }

        /* JADX INFO: renamed from: p */
        public final Map<String, String> m1519p(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (producerListener2.mo1360g(producerContext, "PostprocessorProducer")) {
                return ImmutableMap.m967of("Postprocessor", postprocessor.getName());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
        /* JADX INFO: renamed from: q */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m1520q(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean z2;
            boolean zM1419e = BaseConsumer.m1419e(i);
            if (!zM1419e) {
                synchronized (this) {
                    z2 = this.f4227f;
                }
                if (z2) {
                    if (!zM1419e || !m1518o()) {
                        return;
                    }
                }
            }
            this.f4179b.mo1424b(closeableReference, i);
        }

        /* JADX INFO: renamed from: r */
        public final CloseableReference<CloseableImage> m1521r(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> closeableReferenceProcess = this.f4226e.process(closeableStaticBitmap.f3887m, PostprocessorProducer.this.f4222b);
            try {
                CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(closeableReferenceProcess, closeableImage.mo1334b(), closeableStaticBitmap.f3889o, closeableStaticBitmap.f3890p);
                closeableStaticBitmap2.m1335e(closeableStaticBitmap.f3885k);
                CloseableReference<CloseableImage> closeableReferenceM8632A = CloseableReference.m8632A(closeableStaticBitmap2);
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                return closeableReferenceM8632A;
            } catch (Throwable th) {
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                throw th;
            }
        }

        /* JADX INFO: renamed from: s */
        public final synchronized boolean m1522s() {
            if (this.f4227f || !this.f4230i || this.f4231j || !CloseableReference.m8640y(this.f4228g)) {
                return false;
            }
            this.f4231j = true;
            return true;
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$c */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class c extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {

        /* JADX INFO: renamed from: c */
        public boolean f4234c;

        /* JADX INFO: renamed from: d */
        public CloseableReference<CloseableImage> f4235d;

        public c(PostprocessorProducer postprocessorProducer, b bVar, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, a aVar) {
            super(bVar);
            this.f4234c = false;
            this.f4235d = null;
            repeatedPostprocessor.m1525a(this);
            producerContext.mo1448f(new PostprocessorProducer3(this, postprocessorProducer));
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            if (m1523n()) {
                this.f4179b.mo1426d();
            }
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (m1523n()) {
                this.f4179b.mo1425c(th);
            }
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.m1420f(i)) {
                return;
            }
            synchronized (this) {
                if (!this.f4234c) {
                    CloseableReference<CloseableImage> closeableReference2 = this.f4235d;
                    this.f4235d = CloseableReference.m8636n(closeableReference);
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
            }
            synchronized (this) {
                if (!this.f4234c) {
                    CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(this.f4235d);
                    try {
                        this.f4179b.mo1424b(closeableReferenceM8636n, 0);
                    } finally {
                        if (closeableReferenceM8636n != null) {
                            closeableReferenceM8636n.close();
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: n */
        public final boolean m1523n() {
            synchronized (this) {
                if (this.f4234c) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.f4235d;
                this.f4235d = null;
                this.f4234c = true;
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.t0$d */
    /* JADX INFO: compiled from: PostprocessorProducer.java */
    public class d extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public d(PostprocessorProducer postprocessorProducer, b bVar, a aVar) {
            super(bVar);
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.m1420f(i)) {
                return;
            }
            this.f4179b.mo1424b(closeableReference, i);
        }
    }

    public PostprocessorProducer(Producer2<CloseableReference<CloseableImage>> producer2, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(producer2);
        this.f4221a = producer2;
        this.f4222b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.f4223c = executor;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        Postprocessor postprocessor = producerContext.mo1447e().f19601s;
        Objects.requireNonNull(postprocessor);
        b bVar = new b(consumer2, producerListener2Mo1457o, postprocessor, producerContext);
        this.f4221a.mo1417b(postprocessor instanceof RepeatedPostprocessor ? new c(this, bVar, (RepeatedPostprocessor) postprocessor, producerContext, null) : new d(this, bVar, null), producerContext);
    }
}
