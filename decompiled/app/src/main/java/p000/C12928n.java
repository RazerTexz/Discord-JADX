package p000;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: kotlin-style lambda group */
/* renamed from: n */
/* loaded from: classes2.dex */
public final class C12928n extends Lambda implements Function1<View, Unit> {

    /* renamed from: j */
    public static final C12928n f27501j = new C12928n(0);

    /* renamed from: k */
    public static final C12928n f27502k = new C12928n(1);

    /* renamed from: l */
    public final /* synthetic */ int f27503l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12928n(int i) {
        super(1);
        this.f27503l = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.f27503l;
        if (i == 0) {
            Intrinsics3.checkNotNullParameter(view, "it");
            return Unit.f27425a;
        }
        if (i != 1) {
            throw null;
        }
        Intrinsics3.checkNotNullParameter(view, "it");
        return Unit.f27425a;
    }
}
