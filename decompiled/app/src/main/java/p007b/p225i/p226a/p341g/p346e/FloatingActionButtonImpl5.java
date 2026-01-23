package p007b.p225i.p226a.p341g.p346e;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: b.i.a.g.e.h, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButtonImpl5 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ FloatingActionButtonImpl3 f11699j;

    public FloatingActionButtonImpl5(FloatingActionButtonImpl3 floatingActionButtonImpl3) {
        this.f11699j = floatingActionButtonImpl3;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.f11699j;
        float rotation = floatingActionButtonImpl3.f11664F.getRotation();
        if (floatingActionButtonImpl3.f11688y == rotation) {
            return true;
        }
        floatingActionButtonImpl3.f11688y = rotation;
        floatingActionButtonImpl3.mo6105u();
        return true;
    }
}
