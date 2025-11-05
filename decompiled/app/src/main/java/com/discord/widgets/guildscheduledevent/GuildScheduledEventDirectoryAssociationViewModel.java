package com.discord.widgets.guildscheduledevent;

import b.a.d.d0;
import com.discord.api.directory.DirectoryEntryType;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDirectoryAssociationViewModel extends d0<GuildScheduledEventDirectoryAssociationState> {

    /* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RestCallState<? extends GuildScheduledEventBroadcast>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends GuildScheduledEventBroadcast> restCallState) {
            invoke2((RestCallState<GuildScheduledEventBroadcast>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
            m.checkNotNullParameter(restCallState, "async");
            GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationStateAccess$getViewState$p = GuildScheduledEventDirectoryAssociationViewModel.access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel.this);
            if (guildScheduledEventDirectoryAssociationStateAccess$getViewState$p != null) {
                GuildScheduledEventDirectoryAssociationViewModel.access$updateViewState(GuildScheduledEventDirectoryAssociationViewModel.this, guildScheduledEventDirectoryAssociationStateAccess$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ GuildScheduledEventDirectoryAssociationState access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel) {
        return guildScheduledEventDirectoryAssociationViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel, GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState) {
        guildScheduledEventDirectoryAssociationViewModel.updateViewState(guildScheduledEventDirectoryAssociationState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI) {
        super(new GuildScheduledEventDirectoryAssociationState(null, 1, null));
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(restAPI, "restAPI");
        Guild guild = storeGuilds.getGuild(j);
        if (guild != null ? guild.hasFeature(GuildFeature.HAS_DIRECTORY_ENTRY) : true) {
            RestCallStateKt.executeRequest(restAPI.getDirectoryEntryBroadcastInfo(j, l, DirectoryEntryType.GuildScheduledEvent.getKey()), new AnonymousClass1());
        }
    }
}
