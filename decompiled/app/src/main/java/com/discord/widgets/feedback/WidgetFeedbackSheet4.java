package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetFeedbackSheet.kt */
/* renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$viewModelCallFeedbackSheet$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFeedbackSheet4 extends Lambda implements Function0<CallFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet4(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CallFeedbackSheetViewModel invoke() {
        CallFeedbackSheetViewModel.Config config = (CallFeedbackSheetViewModel.Config) WidgetFeedbackSheet.access$getArgumentsOrDefault$p(this.this$0).getParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG);
        Intrinsics3.checkNotNull(config);
        return new CallFeedbackSheetViewModel(config, null, null, null, 14, null);
    }
}
