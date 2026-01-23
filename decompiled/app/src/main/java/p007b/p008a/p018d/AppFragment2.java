package p007b.p008a.p018d;

import com.discord.C5419R;
import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.d.e, reason: use source file name */
/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment2 extends Lambda implements Function1<Exception, Unit> {
    public final /* synthetic */ AppFragment.C5450d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFragment2(AppFragment.C5450d c5450d) {
        super(1);
        this.this$0 = c5450d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        Intrinsics3.checkNotNullParameter(exc2, "e");
        AppFragment appFragment = AppFragment.this;
        AppToast.m172j(appFragment, FormatUtils.m219k(appFragment, C5419R.string.unable_to_open_media_chooser, new Object[]{exc2.getMessage()}, null, 4), 0, 4);
        return Unit.f27425a;
    }
}
