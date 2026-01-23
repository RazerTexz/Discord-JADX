package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import java.util.Map;
import kotlin.Tuples2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func5;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions3<T, R> implements Func1<Tuples2<? extends Message, ? extends Channel>, Observable<? extends WidgetChatListActions.Model>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ CharSequence $messageContent;
    public final /* synthetic */ int $type;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79611<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ long $authorId;

        public C79611(long j) {
            this.$authorId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$authorId));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$2 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79622<T1, T2, T3, T4, T5, R> implements Func5<Long, MeUser, GuildMember, Guild, EmojiSet, WidgetChatListActions.Model> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        public C79622(Message message, Channel channel) {
            this.$message = message;
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetChatListActions.Model call(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
            return call2(l, meUser, guildMember, guild, emojiSet);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListActions.Model call2(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
            WidgetChatListActions.Model.Companion companion = WidgetChatListActions.Model.INSTANCE;
            Message message = this.$message;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            Channel channel = this.$channel;
            WidgetChatListActions3 widgetChatListActions3 = WidgetChatListActions3.this;
            CharSequence charSequence = widgetChatListActions3.$messageContent;
            int i = widgetChatListActions3.$type;
            Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojis");
            return WidgetChatListActions.Model.Companion.access$create(companion, message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
        }
    }

    public WidgetChatListActions3(long j, CharSequence charSequence, int i) {
        this.$channelId = j;
        this.$messageContent = charSequence;
        this.$type = i;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListActions.Model> call(Tuples2<? extends Message, ? extends Channel> tuples2) {
        return call2((Tuples2<Message, Channel>) tuples2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListActions.Model> call2(Tuples2<Message, Channel> tuples2) {
        User author;
        Message messageComponent1 = tuples2.component1();
        Channel channelComponent2 = tuples2.component2();
        long id2 = (messageComponent1 == null || (author = messageComponent1.getAuthor()) == null) ? 0L : author.getId();
        if (channelComponent2 == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11072g(companion.getPermissions().observePermissionsForChannel(this.$channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeComputed(channelComponent2.getGuildId(), CollectionsJVM.listOf(Long.valueOf(id2))).m11083G(new C79611(id2)), companion.getGuilds().observeGuild(channelComponent2.getGuildId()).m11112r(), StoreEmoji.getEmojiSet$default(companion.getEmojis(), channelComponent2.getGuildId(), channelComponent2.getId(), false, false, 12, null), new C79622(messageComponent1, channelComponent2));
    }
}
