package com.discord.widgets.servers;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetServerSettingsChannels.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels.Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels5(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels.Model model) {
        super(0);
        this.this$0 = widgetServerSettingsChannels;
        this.$model = model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$model.isSorting()) {
            WidgetServerSettingsChannels.access$getBinding$p(this.this$0).f17567c.hide();
        } else {
            WidgetServerSettingsChannels.access$getBinding$p(this.this$0).f17567c.show();
        }
    }
}
