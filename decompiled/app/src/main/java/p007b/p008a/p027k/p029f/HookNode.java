package p007b.p008a.p027k.p029f;

import android.view.View;
import com.discord.i18n.Hook;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.k.f.b, reason: use source file name */
/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HookNode extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Hook.C5524a $clickHandler;
    public final /* synthetic */ HookNode2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HookNode(HookNode2 hookNode2, Hook.C5524a c5524a) {
        super(1);
        this.this$0 = hookNode2;
        this.$clickHandler = c5524a;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View view2 = view;
        Intrinsics3.checkNotNullParameter(view2, "view");
        this.$clickHandler.f18547b.invoke(this.this$0.f1500a, view2);
        return Unit.f27425a;
    }
}
