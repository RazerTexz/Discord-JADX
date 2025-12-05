package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.ActivityUtils2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Sets5;
import p507d0.p580t.SetsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;

/* compiled from: ModelStageRichPresence.kt */
/* renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelStageRichPresence2<T, R> implements Func1<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>> {
    public static final ModelStageRichPresence2 INSTANCE = new ModelStageRichPresence2();

    /* compiled from: ModelStageRichPresence.kt */
    /* renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1$1 */
    public static final class C102731 extends Lambda implements Function1<Long, ModelStageRichPresence> {
        public final /* synthetic */ Map $userPresences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102731(Map map) {
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
            ActivityUtils2 stageChannelRichPresencePartyData;
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
                    if (ActivityUtils.isStageChannelActivity((Activity) next)) {
                        break;
                    }
                }
                Activity activity = next;
                if (activity != null && (stageChannelRichPresencePartyData = ActivityUtils.getStageChannelRichPresencePartyData(activity)) != null) {
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
                    return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), SetsJVM.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? SetsJVM.setOf(Long.valueOf(j)) : Sets5.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
                }
            }
            return null;
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
        return _Sequences2.toList(_Sequences2.mapNotNull(_Collections.asSequence(map.keySet()), new C102731(map)));
    }
}
