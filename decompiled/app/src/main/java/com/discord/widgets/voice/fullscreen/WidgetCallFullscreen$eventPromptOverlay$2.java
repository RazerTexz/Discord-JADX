package com.discord.widgets.voice.fullscreen;

import android.view.ViewStub;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$eventPromptOverlay$2 extends Lambda implements Function0<ViewStub> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$eventPromptOverlay$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(0);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewStub invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewStub invoke() {
        ViewStub viewStub = WidgetCallFullscreen.access$getBinding$p(this.this$0).r;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.eventPromptOverlayStub");
        return viewStub;
    }
}
