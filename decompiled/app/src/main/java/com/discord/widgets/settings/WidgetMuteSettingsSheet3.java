package com.discord.widgets.settings;

import android.widget.TextView;
import com.discord.C5419R;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetMuteSettingsSheet.kt */
/* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet3 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        TextView textView = WidgetMuteSettingsSheet.access$getBinding$p(this.this$0).f17290q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(textView, C5419R.attr.colorHeaderPrimary));
    }
}
