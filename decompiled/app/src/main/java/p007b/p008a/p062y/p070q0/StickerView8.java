package p007b.p008a.p062y.p070q0;

import android.view.View;
import com.discord.rlottie.RLottieDrawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.y.q0.g, reason: use source file name */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerView8 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ StickerView9 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView8(StickerView9 stickerView9) {
        super(1);
        this.this$0 = stickerView9;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.this$0.this$0.binding.f1178c.setPlaybackMode(RLottieDrawable.PlaybackMode.LOOP);
        this.this$0.this$0.binding.f1178c.m8449b();
        return Unit.f27425a;
    }
}
