package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.api.embeddedactivities.EmbeddedActivityInGuild;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: StoreEmbeddedActivities.kt */
/* loaded from: classes2.dex */
public final class StoreEmbeddedActivities extends StoreV2 {
    private final Map<Long, Map<Long, EmbeddedActivity>> embeddedActivitiesByChannel;
    private Map<Long, ? extends Map<Long, EmbeddedActivity>> embeddedActivitiesByChannelSnapshot;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreEmbeddedActivities.kt */
    /* renamed from: com.discord.stores.StoreEmbeddedActivities$observeEmbeddedActivities$1 */
    public static final class C58861 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>> {
        public C58861() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke2() {
            return StoreEmbeddedActivities.this.getEmbeddedActivities();
        }
    }

    /* compiled from: StoreEmbeddedActivities.kt */
    /* renamed from: com.discord.stores.StoreEmbeddedActivities$observeEmbeddedActivitiesForChannel$1 */
    public static final class C58871<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>, Map<Long, ? extends EmbeddedActivity>> {
        public final /* synthetic */ long $channelId;

        public C58871(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends EmbeddedActivity> call(Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> map) {
            return call2((Map<Long, ? extends Map<Long, EmbeddedActivity>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, EmbeddedActivity> call2(Map<Long, ? extends Map<Long, EmbeddedActivity>> map) {
            Map<Long, EmbeddedActivity> map2 = map.get(Long.valueOf(this.$channelId));
            return map2 != null ? map2 : Maps6.emptyMap();
        }
    }

    public StoreEmbeddedActivities() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreEmbeddedActivities(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final String getUrlForApplication(long applicationId) {
        if (BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST.length() == 0) {
            return null;
        }
        return "https://" + applicationId + '.' + BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST;
    }

    @Store3
    private final void handleEmbeddedActivitiesForGuild(Guild guild) {
        List<EmbeddedActivityInGuild> listM7863j = guild.m7863j();
        if (listM7863j == null) {
            listM7863j = Collections2.emptyList();
        }
        for (EmbeddedActivityInGuild embeddedActivityInGuild : listM7863j) {
            handleEmbeddedActivityForChannel(embeddedActivityInGuild.getChannelId(), embeddedActivityInGuild.m7804c(), embeddedActivityInGuild.getEmbeddedActivity(), guild.getId());
        }
    }

    @Store3
    private final void handleEmbeddedActivityForChannel(long channelId, List<Long> userIds, com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, long guildId) {
        String urlForApplication = getUrlForApplication(apiEmbeddedActivity.getApplicationId());
        if (urlForApplication != null) {
            EmbeddedActivity embeddedActivityFromApiEmbeddedActivity = EmbeddedActivity.INSTANCE.fromApiEmbeddedActivity(apiEmbeddedActivity, userIds, urlForApplication, guildId);
            Map<Long, EmbeddedActivity> linkedHashMap = this.embeddedActivitiesByChannel.get(Long.valueOf(channelId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            long applicationId = embeddedActivityFromApiEmbeddedActivity.getApplicationId();
            if (!userIds.isEmpty()) {
                linkedHashMap.put(Long.valueOf(applicationId), embeddedActivityFromApiEmbeddedActivity);
            } else {
                linkedHashMap.remove(Long.valueOf(applicationId));
            }
            this.embeddedActivitiesByChannel.put(Long.valueOf(channelId), linkedHashMap);
            markChanged();
        }
    }

    public final Map<Long, Map<Long, EmbeddedActivity>> getEmbeddedActivities() {
        return this.embeddedActivitiesByChannelSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.embeddedActivitiesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleEmbeddedActivitiesForGuild(guild);
        }
        markChanged();
    }

    @Store3
    public final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        Intrinsics3.checkNotNullParameter(embeddedActivityInboundUpdate, "embeddedActivityInboundUpdate");
        handleEmbeddedActivityForChannel(embeddedActivityInboundUpdate.getChannelId(), embeddedActivityInboundUpdate.m7808d(), embeddedActivityInboundUpdate.getEmbeddedActivity(), embeddedActivityInboundUpdate.getGuildId());
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleEmbeddedActivitiesForGuild(guild);
    }

    public final Observable<Map<Long, Map<Long, EmbeddedActivity>>> observeEmbeddedActivities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58861(), 14, null);
    }

    public final Observable<Map<Long, EmbeddedActivity>> observeEmbeddedActivitiesForChannel(long channelId) {
        Observable observableM11083G = observeEmbeddedActivities().m11083G(new C58871(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "observeEmbeddedActivitie…] ?: emptyMap()\n        }");
        return observableM11083G;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Map<Long, EmbeddedActivity>> entry : this.embeddedActivitiesByChannel.entrySet()) {
            map.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        this.embeddedActivitiesByChannelSnapshot = map;
    }

    public StoreEmbeddedActivities(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.embeddedActivitiesByChannelSnapshot = Maps6.emptyMap();
        this.embeddedActivitiesByChannel = new LinkedHashMap();
    }
}
