package p007b.p008a.p062y.p070q0;

import com.discord.views.sticker.StickerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.y.q0.f, reason: use source file name */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView7 extends Lambda implements Function1<Subscription, Unit> {
    public final /* synthetic */ StickerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView7(StickerView stickerView) {
        super(1);
        this.this$0 = stickerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Subscription subscription) {
        Subscription subscription2 = subscription;
        Intrinsics3.checkNotNullParameter(subscription2, "it");
        this.this$0.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String = subscription2;
        return Unit.f27425a;
    }
}
