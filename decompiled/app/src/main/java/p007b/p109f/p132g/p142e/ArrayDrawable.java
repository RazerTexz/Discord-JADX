package p007b.p109f.p132g.p142e;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.f.g.e.a, reason: use source file name */
/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ArrayDrawable implements DrawableParent {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f3323j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ArrayDrawable2 f3324k;

    public ArrayDrawable(ArrayDrawable2 arrayDrawable2, int i) {
        this.f3324k = arrayDrawable2;
        this.f3323j = i;
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* JADX INFO: renamed from: g */
    public Drawable mo1090g(Drawable drawable) {
        return this.f3324k.m1095c(this.f3323j, drawable);
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* JADX INFO: renamed from: l */
    public Drawable mo1091l() {
        return this.f3324k.m1093a(this.f3323j);
    }
}
