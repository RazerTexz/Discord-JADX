package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.k, reason: use source file name */
/* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class BranchOnSeparateImagesProducer implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final Producer2<EncodedImage2> f4116a;

    /* JADX INFO: renamed from: b */
    public final Producer2<EncodedImage2> f4117b;

    /* JADX INFO: renamed from: b.f.j.p.k$b */
    /* JADX INFO: compiled from: BranchOnSeparateImagesProducer.java */
    public class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public ProducerContext f4118c;

        public b(Consumer2 consumer2, ProducerContext producerContext, a aVar) {
            super(consumer2);
            this.f4118c = producerContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            BranchOnSeparateImagesProducer.this.f4117b.mo1417b(this.f4179b, this.f4118c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            ImageRequest imageRequestMo1447e = this.f4118c.mo1447e();
            boolean zM1419e = BaseConsumer.m1419e(i);
            boolean zM475T0 = AnimatableValueParser.m475T0(encodedImage2, imageRequestMo1447e.f19592j);
            if (encodedImage2 != null && (zM475T0 || imageRequestMo1447e.f19589g)) {
                if (zM1419e && zM475T0) {
                    this.f4179b.mo1424b(encodedImage2, i);
                } else {
                    this.f4179b.mo1424b(encodedImage2, i & (-2));
                }
            }
            if (!zM1419e || zM475T0 || imageRequestMo1447e.f19590h) {
                return;
            }
            if (encodedImage2 != null) {
                encodedImage2.close();
            }
            BranchOnSeparateImagesProducer.this.f4117b.mo1417b(this.f4179b, this.f4118c);
        }
    }

    public BranchOnSeparateImagesProducer(Producer2<EncodedImage2> producer2, Producer2<EncodedImage2> producer22) {
        this.f4116a = producer2;
        this.f4117b = producer22;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.f4116a.mo1417b(new b(consumer2, producerContext, null), producerContext);
    }
}
