package p007b.p008a.p026j;

import android.view.View;
import com.discord.floating_view_manager.FloatingViewGravity;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* renamed from: b.a.j.c */
/* loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC1102c implements View.OnLayoutChangeListener {

    /* renamed from: j */
    public final /* synthetic */ FloatingViewManager f1468j;

    /* renamed from: k */
    public final /* synthetic */ View f1469k;

    /* renamed from: l */
    public final /* synthetic */ View f1470l;

    /* renamed from: m */
    public final /* synthetic */ FloatingViewGravity f1471m;

    /* renamed from: n */
    public final /* synthetic */ int f1472n;

    /* renamed from: o */
    public final /* synthetic */ int f1473o;

    public ViewOnLayoutChangeListenerC1102c(FloatingViewManager floatingViewManager, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        this.f1468j = floatingViewManager;
        this.f1469k = view;
        this.f1470l = view2;
        this.f1471m = floatingViewGravity;
        this.f1472n = i;
        this.f1473o = i2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        FloatingViewManager.m207a(this.f1468j, this.f1470l, this.f1469k, this.f1471m, this.f1472n, this.f1473o);
        this.f1470l.setVisibility(0);
    }
}
