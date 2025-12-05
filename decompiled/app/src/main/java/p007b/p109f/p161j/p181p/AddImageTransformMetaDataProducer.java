package p007b.p109f.p161j.p181p;

import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: AddImageTransformMetaDataProducer.java */
/* renamed from: b.f.j.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AddImageTransformMetaDataProducer implements Producer2<EncodedImage2> {

    /* renamed from: a */
    public final Producer2<EncodedImage2> f3986a;

    /* compiled from: AddImageTransformMetaDataProducer.java */
    /* renamed from: b.f.j.p.a$b */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* renamed from: i */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            if (encodedImage2 == null) {
                this.f4179b.mo1424b(null, i);
                return;
            }
            if (!EncodedImage2.m1337s(encodedImage2)) {
                encodedImage2.m1345q();
            }
            this.f4179b.mo1424b(encodedImage2, i);
        }
    }

    public AddImageTransformMetaDataProducer(Producer2<EncodedImage2> producer2) {
        this.f3986a = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.f3986a.mo1417b(new b(consumer2, null), producerContext);
    }
}
