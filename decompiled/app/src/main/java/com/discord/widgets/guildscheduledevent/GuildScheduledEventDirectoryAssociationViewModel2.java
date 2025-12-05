package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDirectoryAssociationViewModel2 {
    private final RestCallState<GuildScheduledEventBroadcast> enabledAsync;

    public GuildScheduledEventDirectoryAssociationViewModel2() {
        this(null, 1, null);
    }

    public GuildScheduledEventDirectoryAssociationViewModel2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "enabledAsync");
        this.enabledAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2 copy$default(GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = guildScheduledEventDirectoryAssociationViewModel2.enabledAsync;
        }
        return guildScheduledEventDirectoryAssociationViewModel2.copy(restCallState);
    }

    public final RestCallState<GuildScheduledEventBroadcast> component1() {
        return this.enabledAsync;
    }

    public final GuildScheduledEventDirectoryAssociationViewModel2 copy(RestCallState<GuildScheduledEventBroadcast> enabledAsync) {
        Intrinsics3.checkNotNullParameter(enabledAsync, "enabledAsync");
        return new GuildScheduledEventDirectoryAssociationViewModel2(enabledAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventDirectoryAssociationViewModel2) && Intrinsics3.areEqual(this.enabledAsync, ((GuildScheduledEventDirectoryAssociationViewModel2) other).enabledAsync);
        }
        return true;
    }

    public final RestCallState<GuildScheduledEventBroadcast> getEnabledAsync() {
        return this.enabledAsync;
    }

    public int hashCode() {
        RestCallState<GuildScheduledEventBroadcast> restCallState = this.enabledAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildScheduledEventDirectoryAssociationState(enabledAsync=");
        sbM833U.append(this.enabledAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
