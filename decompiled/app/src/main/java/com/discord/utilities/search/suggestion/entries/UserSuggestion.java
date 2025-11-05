package com.discord.utilities.search.suggestion.entries;

import android.annotation.SuppressLint;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.AutocompleteTypes;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserSuggestion.kt */
/* loaded from: classes2.dex */
public final /* data */ class UserSuggestion implements SearchSuggestion, Comparable<UserSuggestion> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final int discriminator;
    private final GuildMember guildMember;
    private final String nickname;
    private final TargetType targetType;
    private final User user;
    private final long userId;
    private final String userName;
    private final String usernameWithDiscriminator;

    /* compiled from: UserSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getUsernameWithDiscriminator(Companion companion, String str, int i) {
            return companion.getUsernameWithDiscriminator(str, i);
        }

        private final String getUsernameWithDiscriminator(String userName, int discriminator) {
            StringBuilder sbU = a.U(userName);
            sbU.append(UserUtils.INSTANCE.padDiscriminator(discriminator));
            return sbU.toString();
        }

        @SuppressLint({"DefaultLocale"})
        public final boolean canComplete(String username, int discriminator, String nickname, CharSequence currentInput) {
            m.checkNotNullParameter(username, "username");
            m.checkNotNullParameter(currentInput, "currentInput");
            String usernameWithDiscriminator = getUsernameWithDiscriminator(username, discriminator);
            String string = currentInput.toString();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = string.toLowerCase();
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (w.contains((CharSequence) usernameWithDiscriminator, (CharSequence) lowerCase, true)) {
                return true;
            }
            return nickname != null ? w.contains((CharSequence) nickname, (CharSequence) lowerCase, true) : false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserSuggestion.kt */
    public enum TargetType {
        FROM,
        MENTIONS
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[TargetType.FROM.ordinal()] = 1;
            iArr[TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    public UserSuggestion(User user, TargetType targetType, GuildMember guildMember) {
        SearchSuggestion.Category category;
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(targetType, "targetType");
        this.user = user;
        this.targetType = targetType;
        this.guildMember = guildMember;
        String username = user.getUsername();
        this.userName = username;
        int discriminator = user.getDiscriminator();
        this.discriminator = discriminator;
        this.userId = user.getId();
        this.nickname = guildMember != null ? guildMember.getNick() : null;
        int iOrdinal = targetType.ordinal();
        if (iOrdinal == 0) {
            category = SearchSuggestion.Category.FROM_USER;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            category = SearchSuggestion.Category.MENTIONS_USER;
        }
        this.category = category;
        this.usernameWithDiscriminator = Companion.access$getUsernameWithDiscriminator(INSTANCE, username, discriminator);
    }

    public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, TargetType targetType, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userSuggestion.user;
        }
        if ((i & 2) != 0) {
            targetType = userSuggestion.targetType;
        }
        if ((i & 4) != 0) {
            guildMember = userSuggestion.guildMember;
        }
        return userSuggestion.copy(user, targetType, guildMember);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UserSuggestion userSuggestion) {
        return compareTo2(userSuggestion);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final TargetType getTargetType() {
        return this.targetType;
    }

    /* renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserSuggestion copy(User user, TargetType targetType, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(targetType, "targetType");
        return new UserSuggestion(user, targetType, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSuggestion)) {
            return false;
        }
        UserSuggestion userSuggestion = (UserSuggestion) other;
        return m.areEqual(this.user, userSuggestion.user) && m.areEqual(this.targetType, userSuggestion.targetType) && m.areEqual(this.guildMember, userSuggestion.guildMember);
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final int getDiscriminator() {
        return this.discriminator;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final TargetType getTargetType() {
        return this.targetType;
    }

    public final User getUser() {
        return this.user;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUsernameWithDiscriminator() {
        return this.usernameWithDiscriminator;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        TargetType targetType = this.targetType;
        int iHashCode2 = (iHashCode + (targetType != null ? targetType.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserSuggestion(user=");
        sbU.append(this.user);
        sbU.append(", targetType=");
        sbU.append(this.targetType);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UserSuggestion other) {
        m.checkNotNullParameter(other, "other");
        String str = this.nickname;
        if (str == null) {
            str = this.usernameWithDiscriminator;
        }
        String str2 = other.nickname;
        if (str2 == null) {
            str2 = other.usernameWithDiscriminator;
        }
        int iCompareTo = str.compareTo(str2);
        return iCompareTo != 0 ? iCompareTo : this.usernameWithDiscriminator.compareTo(other.usernameWithDiscriminator);
    }
}
