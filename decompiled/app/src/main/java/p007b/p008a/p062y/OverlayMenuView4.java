package p007b.p008a.p062y;

import com.discord.C5419R;
import com.discord.utilities.error.Error;
import com.discord.views.OverlayMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: OverlayMenuView.kt */
/* renamed from: b.a.y.s, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayMenuView4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView4(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        AppToast.m169g(this.this$0.getContext(), C5419R.string.instant_invite_failed_to_generate, 0, null, 12);
        return Unit.f27425a;
    }
}
