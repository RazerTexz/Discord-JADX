package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;

/* compiled from: WidgetServerNotifications.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Companion$getNotificationOverrides$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications2<T, R> implements Func1<ModelNotificationSettings, List<ModelNotificationSettings.ChannelOverride>> {
    public static final WidgetServerNotifications2 INSTANCE = new WidgetServerNotifications2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<ModelNotificationSettings.ChannelOverride> call(ModelNotificationSettings modelNotificationSettings) {
        return call2(modelNotificationSettings);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelNotificationSettings.ChannelOverride> call2(ModelNotificationSettings modelNotificationSettings) {
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "it");
        return modelNotificationSettings.getChannelOverrides();
    }
}
