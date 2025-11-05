package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InviteSuggestionItem.kt */
/* loaded from: classes2.dex */
public abstract class InviteSuggestionItem implements MGRecyclerDataPayload {

    /* renamed from: SearchNoResultsItem, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String key = "SEARCH_NO_RESULTS";
    private final int type;

    /* compiled from: InviteSuggestionItem.kt */
    public static final /* data */ class ChannelItem extends InviteSuggestionItem {
        private final Channel channel;
        private final boolean hasSent;
        private final String key;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.hasSent = z2;
            this.type = 1;
            StringBuilder sbU = a.U("c");
            sbU.append(String.valueOf(channel.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.hasSent;
            }
            return channelItem.copy(channel, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final ChannelItem copy(Channel channel, boolean hasSent) {
            m.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return m.areEqual(this.channel, channelItem.channel) && this.hasSent == channelItem.hasSent;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", hasSent=");
            return a.O(sbU, this.hasSent, ")");
        }
    }

    /* compiled from: InviteSuggestionItem.kt */
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionItem$SearchNoResultsItem, reason: from kotlin metadata */
    public static final class Companion extends InviteSuggestionItem {
        private Companion() {
            super(null);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return InviteSuggestionItem.access$getKey$cp();
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: InviteSuggestionItem.kt */
    public static final /* data */ class UserItem extends InviteSuggestionItem {
        private final boolean hasSent;
        private final String key;
        private final int type;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserItem(User user, boolean z2) {
            super(null);
            m.checkNotNullParameter(user, "user");
            this.user = user;
            this.hasSent = z2;
            StringBuilder sbU = a.U("u");
            sbU.append(String.valueOf(user.getId()));
            this.key = sbU.toString();
        }

        public static /* synthetic */ UserItem copy$default(UserItem userItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = userItem.user;
            }
            if ((i & 2) != 0) {
                z2 = userItem.hasSent;
            }
            return userItem.copy(user, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasSent() {
            return this.hasSent;
        }

        public final UserItem copy(User user, boolean hasSent) {
            m.checkNotNullParameter(user, "user");
            return new UserItem(user, hasSent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserItem)) {
                return false;
            }
            UserItem userItem = (UserItem) other;
            return m.areEqual(this.user, userItem.user) && this.hasSent == userItem.hasSent;
        }

        public final boolean getHasSent() {
            return this.hasSent;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        @Override // com.discord.widgets.guilds.invite.InviteSuggestionItem
        public boolean hasSentInvite() {
            return this.hasSent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.hasSent;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("UserItem(user=");
            sbU.append(this.user);
            sbU.append(", hasSent=");
            return a.O(sbU, this.hasSent, ")");
        }
    }

    private InviteSuggestionItem() {
        this.type = -1;
    }

    public static final /* synthetic */ String access$getKey$cp() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public abstract boolean hasSentInvite();

    public /* synthetic */ InviteSuggestionItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
