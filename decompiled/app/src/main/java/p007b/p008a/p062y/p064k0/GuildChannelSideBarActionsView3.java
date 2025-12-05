package p007b.p008a.p062y.p064k0;

import android.view.View;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildChannelSideBarActionsView.kt */
/* renamed from: b.a.y.k0.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView3 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ Function1 f2041j;

    public GuildChannelSideBarActionsView3(Function1 function1) {
        this.f2041j = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(this.f2041j.invoke(view), "invoke(...)");
    }
}
