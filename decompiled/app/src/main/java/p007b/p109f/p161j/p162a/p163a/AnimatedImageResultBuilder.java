package p007b.p109f.p161j.p162a.p163a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import p007b.p109f.p161j.p185t.BitmapTransformation;

/* JADX INFO: renamed from: b.f.j.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: AnimatedImageResultBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class AnimatedImageResultBuilder {

    /* JADX INFO: renamed from: a */
    public final AnimatedImage f3613a;

    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> f3614b;

    /* JADX INFO: renamed from: c */
    public List<CloseableReference<Bitmap>> f3615c;

    /* JADX INFO: renamed from: d */
    public int f3616d;

    /* JADX INFO: renamed from: e */
    public BitmapTransformation f3617e;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.f3613a = animatedImage;
    }

    /* JADX INFO: renamed from: a */
    public AnimatedImageResult m1188a() {
        try {
            AnimatedImageResult animatedImageResult = new AnimatedImageResult(this);
            CloseableReference<Bitmap> closeableReference = this.f3614b;
            if (closeableReference != null) {
                closeableReference.close();
            }
            this.f3614b = null;
            CloseableReference.m8639t(this.f3615c);
            this.f3615c = null;
            return animatedImageResult;
        } catch (Throwable th) {
            CloseableReference<Bitmap> closeableReference2 = this.f3614b;
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f3614b = null;
            CloseableReference.m8639t(this.f3615c);
            this.f3615c = null;
            throw th;
        }
    }
}
