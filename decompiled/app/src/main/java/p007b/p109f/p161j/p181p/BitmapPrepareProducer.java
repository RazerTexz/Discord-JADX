package p007b.p109f.p161j.p181p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;

/* compiled from: BitmapPrepareProducer.java */
/* renamed from: b.f.j.p.i, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapPrepareProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* renamed from: a */
    public final Producer2<CloseableReference<CloseableImage>> f4075a;

    /* renamed from: b */
    public final int f4076b;

    /* renamed from: c */
    public final int f4077c;

    /* renamed from: d */
    public final boolean f4078d;

    /* compiled from: BitmapPrepareProducer.java */
    /* renamed from: b.f.j.p.i$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c */
        public final int f4079c;

        /* renamed from: d */
        public final int f4080d;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, int i, int i2) {
            super(consumer2);
            this.f4079c = i;
            this.f4080d = i2;
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* renamed from: i */
        public void mo1320i(Object obj, int i) {
            Bitmap bitmap;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.m8643x()) {
                CloseableImage closeableImage = (CloseableImage) closeableReference.m8642u();
                if (!closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (bitmap = ((CloseableStaticBitmap) closeableImage).f3887m) != null) {
                    int height = bitmap.getHeight() * bitmap.getRowBytes();
                    if (height >= this.f4079c && height <= this.f4080d) {
                        bitmap.prepareToDraw();
                    }
                }
            }
            this.f4179b.mo1424b(closeableReference, i);
        }
    }

    public BitmapPrepareProducer(Producer2<CloseableReference<CloseableImage>> producer2, int i, int i2, boolean z2) {
        AnimatableValueParser.m527i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(producer2);
        this.f4075a = producer2;
        this.f4076b = i;
        this.f4077c = i2;
        this.f4078d = z2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        if (!producerContext.mo1453k() || this.f4078d) {
            this.f4075a.mo1417b(new a(consumer2, this.f4076b, this.f4077c), producerContext);
        } else {
            this.f4075a.mo1417b(consumer2, producerContext);
        }
    }
}
