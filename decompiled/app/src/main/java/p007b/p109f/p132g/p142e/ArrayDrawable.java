package p007b.p109f.p132g.p142e;

import android.graphics.drawable.Drawable;

/* compiled from: ArrayDrawable.java */
/* renamed from: b.f.g.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class ArrayDrawable implements DrawableParent {

    /* renamed from: j */
    public final /* synthetic */ int f3323j;

    /* renamed from: k */
    public final /* synthetic */ ArrayDrawable2 f3324k;

    public ArrayDrawable(ArrayDrawable2 arrayDrawable2, int i) {
        this.f3324k = arrayDrawable2;
        this.f3323j = i;
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* renamed from: g */
    public Drawable mo1090g(Drawable drawable) {
        return this.f3324k.m1095c(this.f3323j, drawable);
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* renamed from: l */
    public Drawable mo1091l() {
        return this.f3324k.m1093a(this.f3323j);
    }
}
