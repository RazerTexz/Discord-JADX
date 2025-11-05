package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.e;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.s;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MessageUnparser.kt */
/* loaded from: classes2.dex */
public final class MessageUnparser {
    public static final MessageUnparser INSTANCE = new MessageUnparser();
    private static final Pattern PATTERN_USER_MENTION = Pattern.compile("^<@!?(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&?(\\d+)>");
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#?(\\d+)>");
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:(\\w+):(\\d+)>");

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getChannelMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $channels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, Pattern pattern) {
            super(pattern);
            this.$channels = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            Channel channel = (Channel) this.$channels.get(Long.valueOf((strGroup2 == null || (longOrNull = s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (channel != null) {
                StringBuilder sbQ = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                sbQ.append(ChannelUtils.c(channel));
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            m.checkNotNullExpressionValue(strGroup, "content");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getCustomEmojiRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ EmojiSet $emojiSet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmojiSet emojiSet, Pattern pattern) {
            super(pattern);
            this.$emojiSet = emojiSet;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            Emoji emoji = this.$emojiSet.emojiIndex.get(matcher.group(3));
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getRoleMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ List $guildRoles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Pattern pattern) {
            super(pattern);
            this.$guildRoles = list;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            T next;
            String strGroup;
            Long longOrNull;
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            long jLongValue = (strGroup2 == null || (longOrNull = s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
            Iterator<T> it = this.$guildRoles.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (((GuildRole) next).getId() == jLongValue) {
                    break;
                }
            }
            GuildRole guildRole = next;
            if (guildRole != null) {
                StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                sbQ.append(guildRole.getName());
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            m.checkNotNullExpressionValue(strGroup, "content");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* compiled from: MessageUnparser.kt */
    /* renamed from: com.discord.utilities.textprocessing.MessageUnparser$getUserMentionRule$1, reason: invalid class name */
    public static final class AnonymousClass1<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, Pattern pattern) {
            super(pattern);
            this.$users = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            m.checkNotNullParameter(matcher, "matcher");
            m.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            User user = (User) this.$users.get(Long.valueOf((strGroup2 == null || (longOrNull = s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (user != null) {
                StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                sbQ.append(user.getUsername());
                sbQ.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
                strGroup = sbQ.toString();
            } else {
                strGroup = matcher.group();
            }
            m.checkNotNullExpressionValue(strGroup, "content");
            b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
            m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, state);
        }
    }

    private MessageUnparser() {
    }

    private final <T, S> Rule<T, Node<T>, S> getChannelMentionRule(Map<Long, Channel> channels) {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new AnonymousClass1(channels, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        m.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new AnonymousClass1(emojiSet, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new AnonymousClass1(guildRoles, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        m.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new AnonymousClass1(users, pattern);
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        m.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = n.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(e.h.d()), rawMessageContent, null, null, 4, null), null);
    }
}
