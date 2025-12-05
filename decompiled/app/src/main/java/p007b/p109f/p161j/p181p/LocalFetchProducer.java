package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.Closeables;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: LocalFetchProducer.java */
/* renamed from: b.f.j.p.g0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LocalFetchProducer implements Producer2<EncodedImage2> {

    /* renamed from: a */
    public final Executor f4060a;

    /* renamed from: b */
    public final PooledByteBufferFactory f4061b;

    /* compiled from: LocalFetchProducer.java */
    /* renamed from: b.f.j.p.g0$a */
    public class a extends StatefulProducerRunnable<EncodedImage2> {

        /* renamed from: o */
        public final /* synthetic */ ImageRequest f4062o;

        /* renamed from: p */
        public final /* synthetic */ ProducerListener2 f4063p;

        /* renamed from: q */
        public final /* synthetic */ ProducerContext f4064q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest, ProducerListener2 producerListener22, ProducerContext producerContext2) {
            super(consumer2, producerListener2, producerContext, str);
            this.f4062o = imageRequest;
            this.f4063p = producerListener22;
            this.f4064q = producerContext2;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: b */
        public void mo1465b(EncodedImage2 encodedImage2) {
            EncodedImage2 encodedImage22 = encodedImage2;
            if (encodedImage22 != null) {
                encodedImage22.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: d */
        public EncodedImage2 mo1467d() throws Exception {
            EncodedImage2 encodedImage2Mo1428d = LocalFetchProducer.this.mo1428d(this.f4062o);
            if (encodedImage2Mo1428d == null) {
                this.f4063p.mo1356c(this.f4064q, LocalFetchProducer.this.mo1429e(), false);
                this.f4064q.mo1456n("local");
                return null;
            }
            encodedImage2Mo1428d.m1345q();
            this.f4063p.mo1356c(this.f4064q, LocalFetchProducer.this.mo1429e(), true);
            this.f4064q.mo1456n("local");
            return encodedImage2Mo1428d;
        }
    }

    /* compiled from: LocalFetchProducer.java */
    /* renamed from: b.f.j.p.g0$b */
    public class b extends BaseProducerContextCallbacks {

        /* renamed from: a */
        public final /* synthetic */ StatefulProducerRunnable f4066a;

        public b(LocalFetchProducer localFetchProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.f4066a = statefulProducerRunnable;
        }

        @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
        /* renamed from: a */
        public void mo1438a() {
            this.f4066a.m1464a();
        }
    }

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.f4060a = executor;
        this.f4061b = pooledByteBufferFactory;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        producerContext.mo1451i("local", "fetch");
        a aVar = new a(consumer2, producerListener2Mo1457o, producerContext, mo1429e(), imageRequestMo1447e, producerListener2Mo1457o, producerContext);
        producerContext.mo1448f(new b(this, aVar));
        this.f4060a.execute(aVar);
    }

    /* renamed from: c */
    public EncodedImage2 m1478c(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReferenceM8632A = null;
        try {
            closeableReferenceM8632A = i <= 0 ? CloseableReference.m8632A(this.f4061b.mo995c(inputStream)) : CloseableReference.m8632A(this.f4061b.mo996d(inputStream, i));
            EncodedImage2 encodedImage2 = new EncodedImage2(closeableReferenceM8632A);
            Closeables.m966b(inputStream);
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            return encodedImage2;
        } catch (Throwable th) {
            Closeables.m966b(inputStream);
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    public abstract EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException;

    /* renamed from: e */
    public abstract String mo1429e();
}
