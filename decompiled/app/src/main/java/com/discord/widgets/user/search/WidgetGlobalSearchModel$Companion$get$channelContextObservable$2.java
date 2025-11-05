package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.t.Maps6;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$channelContextObservable$2<T, R> implements Func1<WidgetGlobalSearchModel.ChannelContext, WidgetGlobalSearchModel.ChannelContext> {
    public final /* synthetic */ Function2 $permissionsPredicate;

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$2(Function2 function2) {
        this.$permissionsPredicate = function2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ChannelContext call(WidgetGlobalSearchModel.ChannelContext channelContext) {
        return call2(channelContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ChannelContext call2(WidgetGlobalSearchModel.ChannelContext channelContext) {
        Map mapPlus = Maps6.plus(channelContext.getChannels(), channelContext.getActiveJoinedThreads());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapPlus.entrySet()) {
            if (((Boolean) this.$permissionsPredicate.invoke((Channel) entry.getValue(), channelContext.getChannelPerms())).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return WidgetGlobalSearchModel.ChannelContext.copy$default(channelContext, null, linkedHashMap, null, null, null, null, null, null, 253, null);
    }
}
