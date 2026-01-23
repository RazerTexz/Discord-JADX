package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
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
import com.discord.widgets.chat.input.MentionUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.TextNode;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: MessageUnparser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUnparser {
    public static final MessageUnparser INSTANCE = new MessageUnparser();
    private static final Pattern PATTERN_USER_MENTION = Pattern.compile("^<@!?(\\d+)>");
    private static final Pattern PATTERN_ROLE_MENTION = Pattern.compile("^<@&?(\\d+)>");
    private static final Pattern PATTERN_CHANNEL_MENTION = Pattern.compile("^<#?(\\d+)>");
    private static final Pattern PATTERN_CUSTOM_EMOJI = Pattern.compile("^<(a)?:(\\w+):(\\d+)>");

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.MessageUnparser$getChannelMentionRule$1 */
    /* JADX INFO: compiled from: MessageUnparser.kt */
    public static final class C69481<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $channels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69481(Map map, Pattern pattern) {
            super(pattern);
            this.$channels = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            Channel channel = (Channel) this.$channels.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (channel != null) {
                StringBuilder sbM829Q = outline.m829Q(MentionUtils.CHANNELS_CHAR);
                sbM829Q.append(ChannelUtils.m7679c(channel));
                strGroup = sbM829Q.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.MessageUnparser$getCustomEmojiRule$1 */
    /* JADX INFO: compiled from: MessageUnparser.kt */
    public static final class C69491<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ EmojiSet $emojiSet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69491(EmojiSet emojiSet, Pattern pattern) {
            super(pattern);
            this.$emojiSet = emojiSet;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            Emoji emoji = this.$emojiSet.emojiIndex.get(matcher.group(3));
            TextNode textNode = new TextNode(MentionUtils.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.MessageUnparser$getRoleMentionRule$1 */
    /* JADX INFO: compiled from: MessageUnparser.kt */
    public static final class C69501<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ List $guildRoles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69501(List list, Pattern pattern) {
            super(pattern);
            this.$guildRoles = list;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            T next;
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            long jLongValue = (strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
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
                StringBuilder sbM829Q = outline.m829Q(MentionUtils.MENTIONS_CHAR);
                sbM829Q.append(guildRole.getName());
                strGroup = sbM829Q.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S, T] */
    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.MessageUnparser$getUserMentionRule$1 */
    /* JADX INFO: compiled from: MessageUnparser.kt */
    public static final class C69511<S, T> extends Rule<T, Node<T>, S> {
        public final /* synthetic */ Map $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69511(Map map, Pattern pattern) {
            super(pattern);
            this.$users = map;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
            String strGroup;
            Long longOrNull;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup2 = matcher.group(1);
            User user = (User) this.$users.get(Long.valueOf((strGroup2 == null || (longOrNull = StringNumberConversions.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
            if (user != null) {
                StringBuilder sbM829Q = outline.m829Q(MentionUtils.MENTIONS_CHAR);
                sbM829Q.append(user.getUsername());
                sbM829Q.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
                strGroup = sbM829Q.toString();
            } else {
                strGroup = matcher.group();
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup, "content");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, state);
        }
    }

    private MessageUnparser() {
    }

    private final <T, S> Rule<T, Node<T>, S> getChannelMentionRule(Map<Long, Channel> channels) {
        Pattern pattern = PATTERN_CHANNEL_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CHANNEL_MENTION");
        return new C69481(channels, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getCustomEmojiRule(EmojiSet emojiSet) {
        Pattern pattern = PATTERN_CUSTOM_EMOJI;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_CUSTOM_EMOJI");
        return new C69491(emojiSet, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getRoleMentionRule(List<GuildRole> guildRoles) {
        Pattern pattern = PATTERN_ROLE_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ROLE_MENTION");
        return new C69501(guildRoles, pattern);
    }

    private final <T, S> Rule<T, Node<T>, S> getUserMentionRule(Map<Long, ? extends User> users) {
        Pattern pattern = PATTERN_USER_MENTION;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_USER_MENTION");
        return new C69511(users, pattern);
    }

    public static final CharSequence unparse(String rawMessageContent, Guild guild, Map<Long, Channel> channels, Map<Long, ? extends User> users, EmojiSet emojiSet) {
        List<GuildRole> listEmptyList;
        Intrinsics3.checkNotNullParameter(rawMessageContent, "rawMessageContent");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
        Parser parser = new Parser(false, 1, null);
        MessageUnparser messageUnparser = INSTANCE;
        Parser parserAddRule = parser.addRule(messageUnparser.getUserMentionRule(users));
        if (guild == null || (listEmptyList = guild.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        return AstRenderer.render(Parser.parse$default(parserAddRule.addRule(messageUnparser.getRoleMentionRule(listEmptyList)).addRule(messageUnparser.getChannelMentionRule(channels)).addRule(messageUnparser.getCustomEmojiRule(emojiSet)).addRule(SimpleMarkdownRules5.f1988h.m374d()), rawMessageContent, null, null, 4, null), null);
    }
}
