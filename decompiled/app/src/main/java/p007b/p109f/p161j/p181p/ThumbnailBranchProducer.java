package p007b.p109f.p161j.p181p;

import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.j1, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailBranchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThumbnailBranchProducer implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final ThumbnailProducer<EncodedImage2>[] f4111a;

    /* JADX INFO: renamed from: b.f.j.p.j1$a */
    /* JADX INFO: compiled from: ThumbnailBranchProducer.java */
    public class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public final ProducerContext f4112c;

        /* JADX INFO: renamed from: d */
        public final int f4113d;

        /* JADX INFO: renamed from: e */
        public final ResizeOptions f4114e;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, int i) {
            super(consumer2);
            this.f4112c = producerContext;
            this.f4113d = i;
            this.f4114e = producerContext.mo1447e().f19592j;
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            if (ThumbnailBranchProducer.this.m1480c(this.f4113d + 1, this.f4179b, this.f4112c)) {
                return;
            }
            this.f4179b.mo1425c(th);
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            if (encodedImage2 != null && (BaseConsumer.m1420f(i) || AnimatableValueParser.m475T0(encodedImage2, this.f4114e))) {
                this.f4179b.mo1424b(encodedImage2, i);
                return;
            }
            if (BaseConsumer.m1419e(i)) {
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                if (ThumbnailBranchProducer.this.m1480c(this.f4113d + 1, this.f4179b, this.f4112c)) {
                    return;
                }
                this.f4179b.mo1424b(null, 1);
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage2>... thumbnailProducerArr) {
        Objects.requireNonNull(thumbnailProducerArr);
        this.f4111a = thumbnailProducerArr;
        int length = thumbnailProducerArr.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(outline.m871q("negative size: ", length));
            }
            throw new IndexOutOfBoundsException(AnimatableValueParser.m536k0("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        if (producerContext.mo1447e().f19592j == null) {
            consumer2.mo1424b(null, 1);
        } else {
            if (m1480c(0, consumer2, producerContext)) {
                return;
            }
            consumer2.mo1424b(null, 1);
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1480c(int i, Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ResizeOptions resizeOptions = producerContext.mo1447e().f19592j;
        while (true) {
            ThumbnailProducer<EncodedImage2>[] thumbnailProducerArr = this.f4111a;
            if (i >= thumbnailProducerArr.length) {
                i = -1;
                break;
            }
            if (thumbnailProducerArr[i].mo1474a(resizeOptions)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.f4111a[i].mo1417b(new a(consumer2, producerContext, i), producerContext);
        return true;
    }
}
