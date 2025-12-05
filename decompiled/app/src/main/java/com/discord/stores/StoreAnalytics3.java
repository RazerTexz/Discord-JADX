package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreAnalytics.kt */
/* renamed from: com.discord.stores.StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAnalytics3 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics3(Channel channel, StoreAnalytics storeAnalytics, long j, StoreChannelsSelected3 storeChannelsSelected3) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$analyticsLocation$inlined = storeChannelsSelected3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        Map<String, ? extends Object> mapAccess$getChannelSnapshotAnalyticsProperties = StoreAnalytics.access$getChannelSnapshotAnalyticsProperties(this.this$0, this.$channel, true);
        StoreChannelsSelected3 storeChannelsSelected3 = this.$analyticsLocation$inlined;
        return storeChannelsSelected3 != null ? Maps6.plus(mapAccess$getChannelSnapshotAnalyticsProperties, MapsJVM.mapOf(Tuples.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, storeChannelsSelected3.getAnalyticsValue()))) : mapAccess$getChannelSnapshotAnalyticsProperties;
    }
}
