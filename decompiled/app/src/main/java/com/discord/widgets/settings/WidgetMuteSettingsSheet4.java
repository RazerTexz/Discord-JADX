package com.discord.widgets.settings;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetMuteSettingsSheet.kt */
/* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet4 extends Lambda implements Function0<MuteSettingsSheetViewModel> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet4(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(0);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MuteSettingsSheetViewModel invoke() {
        return new MuteSettingsSheetViewModel(WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID", 0L), WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
