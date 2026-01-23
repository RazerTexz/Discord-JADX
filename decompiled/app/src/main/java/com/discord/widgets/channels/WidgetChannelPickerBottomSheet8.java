package com.discord.widgets.channels;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet8 extends Lambda implements Function0<WidgetChannelPickerBottomSheetViewModel> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet8(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(0);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelPickerBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel invoke() {
        return new WidgetChannelPickerBottomSheetViewModel(WidgetChannelPickerBottomSheet.access$getGuildId$p(this.this$0), WidgetChannelPickerBottomSheet.access$getSelectedChannelId$p(this.this$0), WidgetChannelPickerBottomSheet.access$getHideAnnouncementChannels$p(this.this$0), null, null, null, 56, null);
    }
}
