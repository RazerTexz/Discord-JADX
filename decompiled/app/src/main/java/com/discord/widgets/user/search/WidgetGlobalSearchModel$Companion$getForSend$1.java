package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForSend$1 extends Lambda implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$getForSend$1 INSTANCE = new WidgetGlobalSearchModel$Companion$getForSend$1();

    public WidgetGlobalSearchModel$Companion$getForSend$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel, Map<Long, ? extends Long> map) {
        return Boolean.valueOf(invoke2(channel, (Map<Long, Long>) map));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel, Map<Long, Long> map) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        if (ChannelUtils.m7672G(channel)) {
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Object objM845d = outline.m845d(channel, map);
            if (objM845d == null) {
                objM845d = 0L;
            }
            if (permissionUtils.hasAccessWrite(channel, (Long) objM845d)) {
                return true;
            }
        }
        return false;
    }
}
