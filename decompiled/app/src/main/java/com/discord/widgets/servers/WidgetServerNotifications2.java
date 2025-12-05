package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetServerNotifications.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications2<T, R> implements Func1<ModelNotificationSettings, List<ModelNotificationSettings.ChannelOverride>> {
    public static final WidgetServerNotifications2 INSTANCE = new WidgetServerNotifications2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ List<ModelNotificationSettings.ChannelOverride> call(ModelNotificationSettings modelNotificationSettings) {
        return call2(modelNotificationSettings);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelNotificationSettings.ChannelOverride> call2(ModelNotificationSettings modelNotificationSettings) {
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "it");
        return modelNotificationSettings.getChannelOverrides();
    }
}
