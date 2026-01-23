package p007b.p008a.p036n;

import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.n.b, reason: use source file name */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayManager3 extends Lambda implements Function1<OverlayBubbleWrap, Boolean> {
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayManager3(OverlayManager overlayManager) {
        super(1);
        this.this$0 = overlayManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(OverlayBubbleWrap overlayBubbleWrap) {
        boolean z2;
        OverlayBubbleWrap overlayBubbleWrap2 = overlayBubbleWrap;
        Intrinsics3.checkNotNullParameter(overlayBubbleWrap2, "bubbleWrap");
        try {
            this.this$0.windowManager.removeViewImmediate(overlayBubbleWrap2);
            this.this$0.onOverlayBubbleRemoved.invoke(overlayBubbleWrap2);
            z2 = true;
        } catch (IllegalArgumentException unused) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
