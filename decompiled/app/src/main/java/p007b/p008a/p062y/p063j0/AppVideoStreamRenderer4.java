package p007b.p008a.p062y.p063j0;

import com.discord.views.calls.AppVideoStreamRenderer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Subscription;

/* compiled from: AppVideoStreamRenderer.kt */
/* renamed from: b.a.y.j0.c, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppVideoStreamRenderer4 extends Lambda implements Function1<Subscription, Unit> {
    public final /* synthetic */ AppVideoStreamRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoStreamRenderer4(AppVideoStreamRenderer appVideoStreamRenderer) {
        super(1);
        this.this$0 = appVideoStreamRenderer;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        Intrinsics3.checkNotNullParameter(subscription2, "it");
        this.this$0.updateRendererSizeSubscription = subscription2;
        return Unit.f27425a;
    }
}
