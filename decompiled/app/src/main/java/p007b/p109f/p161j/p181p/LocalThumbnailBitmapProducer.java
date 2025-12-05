package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p161j.p167b.SimpleBitmapReleaser;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;

/* compiled from: LocalThumbnailBitmapProducer.java */
@RequiresApi(29)
/* renamed from: b.f.j.p.j0, reason: use source file name */
/* loaded from: classes3.dex */
public class LocalThumbnailBitmapProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* renamed from: a */
    public final Executor f4103a;

    /* renamed from: b */
    public final ContentResolver f4104b;

    /* compiled from: LocalThumbnailBitmapProducer.java */
    /* renamed from: b.f.j.p.j0$a */
    public class a extends StatefulProducerRunnable<CloseableReference<CloseableImage>> {

        /* renamed from: o */
        public final /* synthetic */ ProducerListener2 f4105o;

        /* renamed from: p */
        public final /* synthetic */ ProducerContext f4106p;

        /* renamed from: q */
        public final /* synthetic */ ImageRequest f4107q;

        /* renamed from: r */
        public final /* synthetic */ CancellationSignal f4108r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener22, ProducerContext producerContext2, ImageRequest imageRequest, CancellationSignal cancellationSignal) {
            super(consumer2, producerListener2, producerContext, str);
            this.f4105o = producerListener22;
            this.f4106p = producerContext2;
            this.f4107q = imageRequest;
            this.f4108r = cancellationSignal;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: b */
        public void mo1465b(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: c */
        public Map mo1466c(CloseableReference<CloseableImage> closeableReference) {
            return ImmutableMap.m967of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: d */
        public CloseableReference<CloseableImage> mo1467d() throws Exception {
            ContentResolver contentResolver = LocalThumbnailBitmapProducer.this.f4104b;
            Uri uri = this.f4107q.f19585c;
            ResizeOptions resizeOptions = this.f4107q.f19592j;
            Bitmap bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(resizeOptions != null ? resizeOptions.f3717a : 2048, resizeOptions != null ? resizeOptions.f3718b : 2048), this.f4108r);
            if (bitmapLoadThumbnail == null) {
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(bitmapLoadThumbnail, SimpleBitmapReleaser.m1207a(), ImmutableQualityInfo.f3908a, 0);
            this.f4106p.mo1446d("image_format", "thumbnail");
            closeableStaticBitmap.m1335e(this.f4106p.mo1443a());
            return CloseableReference.m8632A(closeableStaticBitmap);
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: e */
        public void mo1468e() {
            super.mo1468e();
            this.f4108r.cancel();
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: f */
        public void mo1469f(Exception exc) {
            super.mo1469f(exc);
            this.f4105o.mo1356c(this.f4106p, "LocalThumbnailBitmapProducer", false);
            this.f4106p.mo1456n("local");
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: g */
        public void mo1470g(CloseableReference<CloseableImage> closeableReference) {
            CloseableReference<CloseableImage> closeableReference2 = closeableReference;
            super.mo1470g(closeableReference2);
            this.f4105o.mo1356c(this.f4106p, "LocalThumbnailBitmapProducer", closeableReference2 != null);
            this.f4106p.mo1456n("local");
        }
    }

    /* compiled from: LocalThumbnailBitmapProducer.java */
    /* renamed from: b.f.j.p.j0$b */
    public class b extends BaseProducerContextCallbacks {

        /* renamed from: a */
        public final /* synthetic */ StatefulProducerRunnable f4110a;

        public b(LocalThumbnailBitmapProducer localThumbnailBitmapProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.f4110a = statefulProducerRunnable;
        }

        @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
        /* renamed from: a */
        public void mo1438a() {
            this.f4110a.m1464a();
        }
    }

    public LocalThumbnailBitmapProducer(Executor executor, ContentResolver contentResolver) {
        this.f4103a = executor;
        this.f4104b = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        producerContext.mo1451i("local", "thumbnail_bitmap");
        a aVar = new a(consumer2, producerListener2Mo1457o, producerContext, "LocalThumbnailBitmapProducer", producerListener2Mo1457o, producerContext, imageRequestMo1447e, new CancellationSignal());
        producerContext.mo1448f(new b(this, aVar));
        this.f4103a.execute(aVar);
    }
}
