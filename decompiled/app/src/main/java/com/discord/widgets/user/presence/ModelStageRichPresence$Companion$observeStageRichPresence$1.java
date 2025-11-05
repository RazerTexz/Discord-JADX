package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.StageCallRichPresencePartyData;
import d0.f0.q;
import d0.t.m0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.o;
import j0.k.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: ModelStageRichPresence.kt */
/* loaded from: classes.dex */
public final class ModelStageRichPresence$Companion$observeStageRichPresence$1<T, R> implements b<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>> {
    public static final ModelStageRichPresence$Companion$observeStageRichPresence$1 INSTANCE = new ModelStageRichPresence$Companion$observeStageRichPresence$1();

    /* compiled from: ModelStageRichPresence.kt */
    /* renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, ModelStageRichPresence> {
        public final /* synthetic */ Map $userPresences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$userPresences = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ModelStageRichPresence invoke(Long l) {
            return invoke(l.longValue());
        }

        public final ModelStageRichPresence invoke(long j) {
            List<Activity> activities;
            T next;
            StageCallRichPresencePartyData stageChannelRichPresencePartyData;
            String smallText;
            Presence presence = (Presence) this.$userPresences.get(Long.valueOf(j));
            if (presence != null && (activities = presence.getActivities()) != null) {
                Iterator<T> it = activities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                    if (ActivityUtilsKt.isStageChannelActivity((Activity) next)) {
                        break;
                    }
                }
                Activity activity = next;
                if (activity != null && (stageChannelRichPresencePartyData = ActivityUtilsKt.getStageChannelRichPresencePartyData(activity)) != null) {
                    long channelId = stageChannelRichPresencePartyData.getChannelId();
                    long stageInstanceId = stageChannelRichPresencePartyData.getStageInstanceId();
                    boolean userIsSpeaker = stageChannelRichPresencePartyData.getUserIsSpeaker();
                    long guildId = stageChannelRichPresencePartyData.getGuildId();
                    boolean guildIsPartnered = stageChannelRichPresencePartyData.getGuildIsPartnered();
                    boolean guildIsVerified = stageChannelRichPresencePartyData.getGuildIsVerified();
                    ActivityAssets assets = activity.getAssets();
                    String smallImage = assets != null ? assets.getSmallImage() : null;
                    ActivityAssets assets2 = activity.getAssets();
                    if (assets2 == null || (smallText = assets2.getSmallText()) == null) {
                        smallText = "";
                    }
                    return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), m0.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? m0.setOf(Long.valueOf(j)) : n0.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
                }
            }
            return null;
        }
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
        return q.toList(q.mapNotNull(u.asSequence(map.keySet()), new AnonymousClass1(map)));
    }
}
