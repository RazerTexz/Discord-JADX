package com.discord.widgets.chat.pins;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloads2;
import com.discord.widgets.chat.list.entries.DividerEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function10;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: WidgetChannelPinnedMessages.kt */
/* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages2<T, R> implements Func1<List<? extends Message>, Observable<? extends WidgetChannelPinnedMessages.Model>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;

    /* compiled from: WidgetChannelPinnedMessages.kt */
    /* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$Model$Companion$get$1$1 */
    public static final class C82011 extends Lambda implements Function10<Long, WidgetChatListModelMessages.MessagesWithMetadata, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, Boolean, Boolean, Guild, InviteEmbedModel, Boolean, WidgetChannelPinnedMessages.Model> {
        public final /* synthetic */ List $pinnedMessages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C82011(List list) {
            super(10);
            this.$pinnedMessages = list;
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetChannelPinnedMessages.Model invoke(Long l, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends String> map3, Boolean bool, Boolean bool2, Guild guild, InviteEmbedModel inviteEmbedModel, Boolean bool3) {
            return invoke(l.longValue(), messagesWithMetadata, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, String>) map3, bool.booleanValue(), bool2.booleanValue(), guild, inviteEmbedModel, bool3.booleanValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0141  */
        /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.util.List] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetChannelPinnedMessages.Model invoke(long j, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, String> map3, boolean z2, boolean z3, Guild guild, InviteEmbedModel inviteEmbedModel, boolean z4) {
            ArrayList arrayList;
            GuildMember guildMember;
            Set setEmptySet;
            List<Long> roles;
            ArrayList arrayListListOf;
            Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            Intrinsics3.checkNotNullParameter(map, "guildRoles");
            Intrinsics3.checkNotNullParameter(map2, "guildMembers");
            Intrinsics3.checkNotNullParameter(map3, "channelNames");
            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            List list = this.$pinnedMessages;
            if (list == null) {
                arrayListListOf = CollectionsJVM.listOf(new LoadingEntry());
            } else {
                if (!list.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    int size = this.$pinnedMessages.size();
                    int i = 0;
                    while (i < size) {
                        Message message = (Message) this.$pinnedMessages.get(i);
                        int i2 = i;
                        int i3 = size;
                        ArrayList arrayList3 = arrayList2;
                        arrayList3.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, WidgetChannelPinnedMessages2.this.$channel, map2, map, new HashMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, z4, 524288, null));
                        if (i2 < this.$pinnedMessages.size() - 1) {
                            arrayList3.add(new DividerEntry());
                        }
                        i = i2 + 1;
                        arrayList2 = arrayList3;
                        size = i3;
                    }
                    arrayList = arrayList2;
                    guildMember = map2.get(Long.valueOf(j));
                    if (guildMember != null || (roles = guildMember.getRoles()) == null || (setEmptySet = _Collections.toHashSet(roles)) == null) {
                        setEmptySet = Sets5.emptySet();
                    }
                    return new WidgetChannelPinnedMessages.Model(WidgetChannelPinnedMessages2.this.$channel, guild, j, map3, arrayList, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
                }
                WidgetChannelPinnedMessages2 widgetChannelPinnedMessages2 = WidgetChannelPinnedMessages2.this;
                String string = widgetChannelPinnedMessages2.$context.getString(ChannelUtils.m7667B(widgetChannelPinnedMessages2.$channel) ? C5419R.string.no_pins_in_dm : C5419R.string.no_pins_in_channel);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(\n     …                        )");
                arrayListListOf = CollectionsJVM.listOf(new EmptyPinsEntry(string));
            }
            arrayList = arrayListListOf;
            guildMember = map2.get(Long.valueOf(j));
            if (guildMember != null) {
                setEmptySet = Sets5.emptySet();
            }
            return new WidgetChannelPinnedMessages.Model(WidgetChannelPinnedMessages2.this.$channel, guild, j, map3, arrayList, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
        }
    }

    public WidgetChannelPinnedMessages2(Channel channel, Context context) {
        this.$channel = channel;
        this.$context = context;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelPinnedMessages.Model> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelPinnedMessages.Model> call2(List<Message> list) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Long> observableObserveMeId = companion.getUsers().observeMeId();
        WidgetChatListModelMessages.MessagesWithMetadata.Companion companion2 = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(list, "pinnedMessages");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMeId, companion2.get(list), companion.getGuilds().observeRoles(this.$channel.getGuildId()), companion.getGuilds().observeComputed(this.$channel.getGuildId()), companion.getChannels().observeNames(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), companion.getGuilds().observeGuild(this.$channel.getGuildId()), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(this.$channel.getGuildId())), new C82011(list));
    }
}
