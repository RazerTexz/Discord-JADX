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
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetChatListActions.kt */
/* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActions3<T, R> implements Func1<Tuples2<? extends Message, ? extends Channel>, Observable<? extends WidgetChatListActions.Model>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ CharSequence $messageContent;
    public final /* synthetic */ int $type;

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ long $authorId;

        public AnonymousClass1(long j) {
            this.$authorId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$authorId));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, T5, R> implements Func5<Long, MeUser, GuildMember, Guild, EmojiSet, WidgetChatListActions.Model> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        public AnonymousClass2(Message message, Channel channel) {
            this.$message = message;
            this.$channel = channel;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetChatListActions.Model call(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
            return call2(l, meUser, guildMember, guild, emojiSet);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
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

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListActions.Model> call(Tuples2<? extends Message, ? extends Channel> tuples2) {
        return call2((Tuples2<Message, Channel>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListActions.Model> call2(Tuples2<Message, Channel> tuples2) {
        User author;
        Message messageComponent1 = tuples2.component1();
        Channel channelComponent2 = tuples2.component2();
        long id2 = (messageComponent1 == null || (author = messageComponent1.getAuthor()) == null) ? 0L : author.getId();
        if (channelComponent2 == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.g(companion.getPermissions().observePermissionsForChannel(this.$channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeComputed(channelComponent2.getGuildId(), CollectionsJVM.listOf(Long.valueOf(id2))).G(new AnonymousClass1(id2)), companion.getGuilds().observeGuild(channelComponent2.getGuildId()).r(), StoreEmoji.getEmojiSet$default(companion.getEmojis(), channelComponent2.getGuildId(), channelComponent2.getId(), false, false, 12, null), new AnonymousClass2(messageComponent1, channelComponent2));
    }
}
