package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.servers.WidgetServerNotifications;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildProfileSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildHubActions$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildHubActions$$inlined$apply$lambda$2(TextView textView, WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetServerNotifications.Companion companion = WidgetServerNotifications.INSTANCE;
        long j = this.$guildId$inlined;
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        companion.launch(j, context);
    }
}
