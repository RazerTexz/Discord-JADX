package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class UserAutocompletable extends Autocompletable {
    private final List<String> autoTextMatchers;
    private final boolean canUserReadChannel;
    private final GuildMember guildMember;
    private final String nickname;
    private final Presence presence;
    private final List<String> textMatchers;
    private final User user;

    public /* synthetic */ UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : presence, (i & 16) != 0 ? true : z2);
    }

    public static /* synthetic */ UserAutocompletable copy$default(UserAutocompletable userAutocompletable, User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userAutocompletable.user;
        }
        if ((i & 2) != 0) {
            guildMember = userAutocompletable.guildMember;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 4) != 0) {
            str = userAutocompletable.nickname;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            presence = userAutocompletable.presence;
        }
        Presence presence2 = presence;
        if ((i & 16) != 0) {
            z2 = userAutocompletable.canUserReadChannel;
        }
        return userAutocompletable.copy(user, guildMember2, str2, presence2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final UserAutocompletable copy(User user, GuildMember guildMember, String nickname, Presence presence, boolean canUserReadChannel) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new UserAutocompletable(user, guildMember, nickname, presence, canUserReadChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAutocompletable)) {
            return false;
        }
        UserAutocompletable userAutocompletable = (UserAutocompletable) other;
        return Intrinsics3.areEqual(this.user, userAutocompletable.user) && Intrinsics3.areEqual(this.guildMember, userAutocompletable.guildMember) && Intrinsics3.areEqual(this.nickname, userAutocompletable.nickname) && Intrinsics3.areEqual(this.presence, userAutocompletable.presence) && this.canUserReadChannel == userAutocompletable.canUserReadChannel;
    }

    public final List<String> getAutoTextMatchers() {
        return this.autoTextMatchers;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getAutocompleteTextMatchers() {
        return this.autoTextMatchers;
    }

    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbQ = outline.Q('<');
        sbQ.append(leadingIdentifier().getIdentifier());
        sbQ.append(this.user.getId());
        sbQ.append('>');
        return sbQ.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str = this.nickname;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        int iHashCode4 = (iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.canUserReadChannel;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserAutocompletable(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", nickname=");
        sbU.append(this.nickname);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", canUserReadChannel=");
        return outline.O(sbU, this.canUserReadChannel, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(user, "user");
        List<String> listListOf = null;
        this.user = user;
        this.guildMember = guildMember;
        this.nickname = str;
        this.presence = presence;
        this.canUserReadChannel = z2;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + user.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
        if (str != null) {
            listListOf = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + str);
        }
        this.autoTextMatchers = listListOf;
    }
}
