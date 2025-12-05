package p007b.p008a.p062y.p063j0;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.calls.StageCallSpeakerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StageCallSpeakerView.kt */
/* renamed from: b.a.y.j0.i, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageCallSpeakerView4 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ StageCallSpeakerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallSpeakerView4(StageCallSpeakerView stageCallSpeakerView) {
        super(1);
        this.this$0 = stageCallSpeakerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        Integer num2 = num;
        StageCallSpeakerView stageCallSpeakerView = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(num2, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        stageCallSpeakerView.setCardBackgroundColor(num2.intValue());
        return Unit.f27425a;
    }
}
