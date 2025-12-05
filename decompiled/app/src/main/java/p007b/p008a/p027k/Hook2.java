package p007b.p008a.p027k;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: Hook.kt */
/* renamed from: b.a.k.c, reason: use source file name */
/* loaded from: classes.dex */
public final class Hook2 extends Lambda implements Function2<String, View, Unit> {

    /* renamed from: j */
    public static final Hook2 f1497j = new Hook2();

    public Hook2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 1>");
        return Unit.f27425a;
    }
}
