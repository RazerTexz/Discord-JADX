package p007b.p109f.p161j.p162a.p163a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import java.util.Objects;
import p007b.p109f.p161j.p185t.BitmapTransformation;

/* compiled from: AnimatedImageResult.java */
/* renamed from: b.f.j.a.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public class AnimatedImageResult {

    /* renamed from: a */
    public final AnimatedImage f3609a;

    /* renamed from: b */
    public CloseableReference<Bitmap> f3610b;

    /* renamed from: c */
    public List<CloseableReference<Bitmap>> f3611c;

    /* renamed from: d */
    public BitmapTransformation f3612d;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        AnimatedImage animatedImage = animatedImageResultBuilder.f3613a;
        Objects.requireNonNull(animatedImage);
        this.f3609a = animatedImage;
        this.f3610b = CloseableReference.m8636n(animatedImageResultBuilder.f3614b);
        this.f3611c = CloseableReference.m8637q(animatedImageResultBuilder.f3615c);
        this.f3612d = animatedImageResultBuilder.f3617e;
    }
}
