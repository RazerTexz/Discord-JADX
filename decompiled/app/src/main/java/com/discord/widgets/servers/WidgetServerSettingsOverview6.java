package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsOverview.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureRadios$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview6<T> implements Action1<Boolean> {
    public final /* synthetic */ int $activeRadioIndex$inlined;
    public final /* synthetic */ int $index;
    public final /* synthetic */ boolean $isAboveNotifyAllSize$inlined;
    public final /* synthetic */ int $stateId$inlined;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview6(int i, WidgetServerSettingsOverview widgetServerSettingsOverview, int i2, boolean z2, int i3) {
        this.$index = i;
        this.this$0 = widgetServerSettingsOverview;
        this.$activeRadioIndex$inlined = i2;
        this.$isAboveNotifyAllSize$inlined = z2;
        this.$stateId$inlined = i3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetServerSettingsOverview.access$configureRadios(this.this$0, this.$stateId$inlined, this.$index, this.$isAboveNotifyAllSize$inlined, true);
    }
}
