package p007b.p008a.p026j;

import android.view.View;
import android.view.ViewTreeObserver;
import com.discord.floating_view_manager.FloatingViewGravity;

/* compiled from: FloatingViewManager.kt */
/* renamed from: b.a.j.f, reason: use source file name */
/* loaded from: classes.dex */
public final class FloatingViewManager4 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: j */
    public final /* synthetic */ FloatingViewManager f1477j;

    /* renamed from: k */
    public final /* synthetic */ View f1478k;

    /* renamed from: l */
    public final /* synthetic */ View f1479l;

    /* renamed from: m */
    public final /* synthetic */ FloatingViewGravity f1480m;

    /* renamed from: n */
    public final /* synthetic */ int f1481n;

    /* renamed from: o */
    public final /* synthetic */ int f1482o;

    public FloatingViewManager4(FloatingViewManager floatingViewManager, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.f1477j = floatingViewManager;
        this.f1478k = view;
        this.f1479l = view2;
        this.f1480m = floatingViewGravity;
        this.f1481n = i;
        this.f1482o = i2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        FloatingViewManager.m207a(this.f1477j, this.f1478k, this.f1479l, this.f1480m, this.f1481n, this.f1482o);
        return true;
    }
}
