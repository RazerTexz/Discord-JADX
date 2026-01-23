package com.discord.widgets.servers;

import com.discord.C5419R;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.servers.NotificationMuteSettingsView$updateView$rawMuteStatusText$1, reason: use source file name */
/* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationMuteSettingsView2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ NotificationMuteSettingsView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationMuteSettingsView2(NotificationMuteSettingsView notificationMuteSettingsView) {
        super(1);
        this.this$0 = notificationMuteSettingsView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(this.this$0.getContext(), C5419R.attr.colorControlBrandForeground));
    }
}
