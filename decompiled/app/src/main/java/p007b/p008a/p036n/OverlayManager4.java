package p007b.p008a.p036n;

import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p036n.p038h.OverlayTrashWrap;
import p507d0.p592z.p594d.Lambda;

/* compiled from: OverlayManager.kt */
/* renamed from: b.a.n.c, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayManager4 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ OverlayBubbleWrap $bubble;
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayManager4(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        super(1);
        this.this$0 = overlayManager;
        this.$bubble = overlayBubbleWrap;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        if (bool.booleanValue()) {
            OverlayTrashWrap overlayTrashWrap = this.this$0.trashWrap;
            if (overlayTrashWrap != null) {
                overlayTrashWrap.f1563l.start();
            }
        } else {
            OverlayTrashWrap overlayTrashWrap2 = this.this$0.trashWrap;
            if (overlayTrashWrap2 != null) {
                overlayTrashWrap2.f1564m.start();
            }
            this.this$0.m8431b(this.$bubble);
        }
        return Unit.f27425a;
    }
}
