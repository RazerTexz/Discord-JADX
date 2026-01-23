package p007b.p109f.p161j.p167b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p170e.CloseableReferenceFactory;
import p007b.p109f.p161j.p177l.BitmapPool;
import p007b.p109f.p186k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.b.a, reason: use source file name */
/* JADX INFO: compiled from: ArtBitmapFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a */
    public final BitmapPool f3644a;

    /* JADX INFO: renamed from: b */
    public final CloseableReferenceFactory f3645b;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.f3644a = bitmapPool;
        this.f3645b = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> mo1206b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.f3644a.get(BitmapUtil.m1540c(i, i2, config));
        AnimatableValueParser.m527i(Boolean.valueOf(bitmap.getAllocationByteCount() >= BitmapUtil.m1539b(config) * (i * i2)));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.m8634H(bitmap, this.f3644a, this.f3645b.f3725a);
    }
}
