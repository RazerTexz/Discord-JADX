package p007b.p076b.p077a.p078a;

import android.view.View;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: FlexInputFragment.kt */
/* renamed from: b.b.a.a.h */
/* loaded from: classes3.dex */
public final class C1420h extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1420h(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        FlexInputViewModel flexInputViewModel = this.this$0.viewModel;
        if (flexInputViewModel != null) {
            C3404f.m4232O0(flexInputViewModel, false, 1, null);
        }
        return Unit.f27425a;
    }
}
