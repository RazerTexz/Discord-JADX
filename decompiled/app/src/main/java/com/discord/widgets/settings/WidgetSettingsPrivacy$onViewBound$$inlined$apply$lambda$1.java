package com.discord.widgets.settings;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1<T> implements Action1<Boolean> {
    public final /* synthetic */ CheckedSetting $this_apply;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1(CheckedSetting checkedSetting, WidgetSettingsPrivacy widgetSettingsPrivacy) {
        this.$this_apply = checkedSetting;
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsPrivacy.access$getUserSettings$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(bool, "checked");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(storeUserSettingsAccess$getUserSettings$p.setIsAccessibilityDetectionAllowed(bool.booleanValue()), false, 1, null), this.$this_apply.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetSettingsPrivacy$onViewBound$1$1$1.INSTANCE, 62, (Object) null);
    }
}
