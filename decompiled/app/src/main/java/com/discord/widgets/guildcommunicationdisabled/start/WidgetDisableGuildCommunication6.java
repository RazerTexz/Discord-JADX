package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetDisableGuildCommunication.kt */
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication6 extends Lambda implements Function0<DisableGuildCommunicationViewModel> {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication6(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DisableGuildCommunicationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel invoke() {
        return new DisableGuildCommunicationViewModel(WidgetDisableGuildCommunication.access$getUserId$p(this.this$0), WidgetDisableGuildCommunication.access$getGuildId$p(this.this$0), null, null, null, null, 60, null);
    }
}
