package com.discord.widgets.media;

import com.discord.player.AppMediaPlayer;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMedia.kt */
/* renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMedia6 extends Lambda implements Function1<AppMediaPlayer.Event, Unit> {
    public final /* synthetic */ WidgetMedia this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia6(WidgetMedia widgetMedia) {
        super(1);
        this.this$0 = widgetMedia;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
        invoke2(event);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppMediaPlayer.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        WidgetMedia.access$handlePlayerEvent(this.this$0, event);
    }
}
