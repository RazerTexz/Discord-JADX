package com.discord.widgets.guilds.leave;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetLeaveGuildDialog.kt */
/* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog3 extends Lambda implements Function0<LeaveGuildDialogViewModel> {
    public final /* synthetic */ WidgetLeaveGuildDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetLeaveGuildDialog3(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        super(0);
        this.this$0 = widgetLeaveGuildDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LeaveGuildDialogViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LeaveGuildDialogViewModel invoke() {
        return new LeaveGuildDialogViewModel(WidgetLeaveGuildDialog.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, null, null, 14, null);
    }
}
