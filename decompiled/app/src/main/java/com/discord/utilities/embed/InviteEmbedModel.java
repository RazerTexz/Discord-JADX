package com.discord.utilities.embed;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func4;

/* compiled from: InviteEmbedModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class InviteEmbedModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Channel> channels;
    private final Map<String, StoreInstantInvites.InviteState> invites;
    private final Map<Long, StoreRequestedStageChannels.StageInstanceState> requestedInstances;
    private final Map<Long, StageInstance> stageInstances;

    /* compiled from: InviteEmbedModel.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable observe$default(Companion companion, Observable observable, Observable observable2, Observable observable3, Observable observable4, int i, Object obj) {
            if ((i & 1) != 0) {
                observable = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels();
            }
            if ((i & 2) != 0) {
                observable2 = StoreStream.INSTANCE.getInstantInvites().observeKnownInvites();
            }
            if ((i & 4) != 0) {
                observable3 = StoreStream.INSTANCE.getStageInstances().observeStageInstances();
            }
            if ((i & 8) != 0) {
                observable4 = StoreStream.INSTANCE.getRequestedStageChannels().observeRequestedStageChannels();
            }
            return companion.observe(observable, observable2, observable3, observable4);
        }

        public final Observable<InviteEmbedModel> observe(Observable<Map<Long, Channel>> channelsObservable, Observable<Map<String, StoreInstantInvites.InviteState>> knownInvitesObservable, Observable<Map<Long, StageInstance>> stageInstancesObservable, Observable<Map<Long, StoreRequestedStageChannels.StageInstanceState>> requestedStageInstances) {
            Intrinsics3.checkNotNullParameter(channelsObservable, "channelsObservable");
            Intrinsics3.checkNotNullParameter(knownInvitesObservable, "knownInvitesObservable");
            Intrinsics3.checkNotNullParameter(stageInstancesObservable, "stageInstancesObservable");
            Intrinsics3.checkNotNullParameter(requestedStageInstances, "requestedStageInstances");
            InviteEmbedModel2 inviteEmbedModel2 = InviteEmbedModel2.INSTANCE;
            Object inviteEmbedModel3 = inviteEmbedModel2;
            if (inviteEmbedModel2 != null) {
                inviteEmbedModel3 = new InviteEmbedModel3(inviteEmbedModel2);
            }
            Observable<InviteEmbedModel> observableM11073h = Observable.m11073h(channelsObservable, knownInvitesObservable, stageInstancesObservable, requestedStageInstances, (Func4) inviteEmbedModel3);
            Intrinsics3.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest… ::InviteEmbedModel\n    )");
            return observableM11073h;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteEmbedModel(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels.StageInstanceState> map4) {
        Intrinsics3.checkNotNullParameter(map, "channels");
        Intrinsics3.checkNotNullParameter(map2, "invites");
        Intrinsics3.checkNotNullParameter(map3, "stageInstances");
        Intrinsics3.checkNotNullParameter(map4, "requestedInstances");
        this.channels = map;
        this.invites = map2;
        this.stageInstances = map3;
        this.requestedInstances = map4;
    }

    private final Map<Long, Channel> component1() {
        return this.channels;
    }

    private final Map<String, StoreInstantInvites.InviteState> component2() {
        return this.invites;
    }

    private final Map<Long, StageInstance> component3() {
        return this.stageInstances;
    }

    private final Map<Long, StoreRequestedStageChannels.StageInstanceState> component4() {
        return this.requestedInstances;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InviteEmbedModel copy$default(InviteEmbedModel inviteEmbedModel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = inviteEmbedModel.channels;
        }
        if ((i & 2) != 0) {
            map2 = inviteEmbedModel.invites;
        }
        if ((i & 4) != 0) {
            map3 = inviteEmbedModel.stageInstances;
        }
        if ((i & 8) != 0) {
            map4 = inviteEmbedModel.requestedInstances;
        }
        return inviteEmbedModel.copy(map, map2, map3, map4);
    }

    public final InviteEmbedModel copy(Map<Long, Channel> channels, Map<String, ? extends StoreInstantInvites.InviteState> invites, Map<Long, StageInstance> stageInstances, Map<Long, StoreRequestedStageChannels.StageInstanceState> requestedInstances) {
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(invites, "invites");
        Intrinsics3.checkNotNullParameter(stageInstances, "stageInstances");
        Intrinsics3.checkNotNullParameter(requestedInstances, "requestedInstances");
        return new InviteEmbedModel(channels, invites, stageInstances, requestedInstances);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEmbedModel)) {
            return false;
        }
        InviteEmbedModel inviteEmbedModel = (InviteEmbedModel) other;
        return Intrinsics3.areEqual(this.channels, inviteEmbedModel.channels) && Intrinsics3.areEqual(this.invites, inviteEmbedModel.invites) && Intrinsics3.areEqual(this.stageInstances, inviteEmbedModel.stageInstances) && Intrinsics3.areEqual(this.requestedInstances, inviteEmbedModel.requestedInstances);
    }

    public final ModelInvite getResolvedInvite(String inviteKey) {
        Intrinsics3.checkNotNullParameter(inviteKey, "inviteKey");
        StoreInstantInvites.InviteState inviteState = this.invites.get(inviteKey);
        if (!(inviteState instanceof StoreInstantInvites.InviteState.Resolved)) {
            inviteState = null;
        }
        StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState;
        if (resolved != null) {
            return resolved.getInvite();
        }
        return null;
    }

    public int hashCode() {
        Map<Long, Channel> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, StoreInstantInvites.InviteState> map2 = this.invites;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, StageInstance> map3 = this.stageInstances;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, StoreRequestedStageChannels.StageInstanceState> map4 = this.requestedInstances;
        return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
    }

    public final ModelInvite resolveInviteCodeForPublicStage(String inviteCode) {
        RecommendedStageInstance stageInstance;
        StageInstance recommendedStageInstance;
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        ModelInvite resolvedInvite = getResolvedInvite(inviteCode);
        if (resolvedInvite != null) {
            Channel channel = resolvedInvite.getChannel();
            if (!(channel != null && ChannelUtils.m7669D(channel))) {
                channel = null;
            }
            if (channel != null) {
                Intrinsics3.checkNotNullExpressionValue(channel, "invite.channel.takeIf { … == true } ?: return null");
                StageInstance stageInstance2 = (StageInstance) outline.m845d(channel, this.stageInstances);
                if (stageInstance2 != null && AnimatableValueParser.m484W0(stageInstance2)) {
                    return resolvedInvite;
                }
                if (((Channel) outline.m845d(channel, this.channels)) != null) {
                    return null;
                }
                StoreRequestedStageChannels.StageInstanceState stageInstanceState = (StoreRequestedStageChannels.StageInstanceState) outline.m845d(channel, this.requestedInstances);
                if (stageInstanceState != null && (stageInstance = stageInstanceState.getStageInstance()) != null && (recommendedStageInstance = stageInstance.getInstance()) != null && AnimatableValueParser.m484W0(recommendedStageInstance)) {
                    return resolvedInvite;
                }
                if (stageInstanceState == null || stageInstanceState.isError()) {
                    StoreStream.INSTANCE.getRequestedStageChannels().enqueueStageChannelFetch(channel.getId());
                }
            }
        }
        return null;
    }

    public final ModelInvite resolveInviteForGuildScheduledEvent(String inviteCode, String eventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(eventId, "eventId");
        String inviteStoreKey = ModelInvite.getInviteStoreKey(inviteCode, SnowflakeUtils.INSTANCE.toSnowflake(eventId));
        Intrinsics3.checkNotNullExpressionValue(inviteStoreKey, "ModelInvite.getInviteSto…d.toSnowflake()\n        )");
        ModelInvite resolvedInvite = getResolvedInvite(inviteStoreKey);
        if ((resolvedInvite != null ? resolvedInvite.getGuildScheduledEvent() : null) != null) {
            return resolvedInvite;
        }
        return null;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("InviteEmbedModel(channels=");
        sbM833U.append(this.channels);
        sbM833U.append(", invites=");
        sbM833U.append(this.invites);
        sbM833U.append(", stageInstances=");
        sbM833U.append(this.stageInstances);
        sbM833U.append(", requestedInstances=");
        return outline.m825M(sbM833U, this.requestedInstances, ")");
    }
}
