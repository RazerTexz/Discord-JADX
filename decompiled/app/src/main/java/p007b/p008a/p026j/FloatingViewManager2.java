package p007b.p008a.p026j;

import android.view.View;
import kotlin.Unit;
import p658rx.functions.Action1;

/* compiled from: FloatingViewManager.kt */
/* renamed from: b.a.j.d, reason: use source file name */
/* loaded from: classes.dex */
public final class FloatingViewManager2<T> implements Action1<Unit> {

    /* renamed from: j */
    public final /* synthetic */ FloatingViewManager f1474j;

    /* renamed from: k */
    public final /* synthetic */ View f1475k;

    public FloatingViewManager2(FloatingViewManager floatingViewManager, View view) {
        this.f1474j = floatingViewManager;
        this.f1475k = view;
    }

    @Override // p658rx.functions.Action1
    public void call(Unit unit) {
        this.f1474j.m208b(this.f1475k.getId());
    }
}
