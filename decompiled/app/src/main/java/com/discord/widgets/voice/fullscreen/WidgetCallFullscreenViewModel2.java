package com.discord.widgets.voice.fullscreen;

import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$ViewState$Valid$analyticsVideoLayout$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel2 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel2(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        super(0);
        this.this$0 = valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        if (this.this$0.getDisplayMode() == WidgetCallFullscreenViewModel.DisplayMode.GRID) {
            return this.this$0.getFocusedParticipantKey() != null ? "focus" : "grid";
        }
        return null;
    }
}
