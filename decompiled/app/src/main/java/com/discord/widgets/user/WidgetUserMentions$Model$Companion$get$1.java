package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.message.MessageReference;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MentionFooterEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.WidgetUserMentions;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function11;
import rx.Observable;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$Companion$get$1<T, R> implements b<WidgetUserMentions.Model.MessageLoader.LoadingState, Observable<? extends WidgetUserMentions.Model>> {
    public final /* synthetic */ NavigationTab $selectedTab;

    /* compiled from: WidgetUserMentions.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function11<WidgetChatListModelMessages.MessagesWithMetadata, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Long, Boolean, Boolean, InviteEmbedModel, WidgetUserMentions.Model> {
        public final /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState $loadedState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            super(11);
            this.$loadedState = loadingState;
        }

        @Override // kotlin.jvm.functions.Function11
        public /* bridge */ /* synthetic */ WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends String> map2, Map<Long, ? extends Guild> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Map<Long, ? extends GuildMember>> map5, Long l, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
            return invoke(messagesWithMetadata, guild, (Map<Long, Channel>) map, (Map<Long, String>) map2, (Map<Long, Guild>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, ? extends Map<Long, GuildMember>>) map5, l.longValue(), bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
        }

        public final WidgetUserMentions.Model invoke(WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Guild guild, Map<Long, Channel> map, Map<Long, String> map2, Map<Long, Guild> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, ? extends Map<Long, GuildMember>> map5, long j, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
            Map<Long, Channel> map6 = map;
            Map<Long, ? extends Map<Long, GuildRole>> map7 = map4;
            Map<Long, ? extends Map<Long, GuildMember>> map8 = map5;
            m.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            m.checkNotNullParameter(map6, "channels");
            m.checkNotNullParameter(map2, "names");
            m.checkNotNullParameter(map3, "guilds");
            m.checkNotNullParameter(map7, "roles");
            m.checkNotNullParameter(map8, "members");
            m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            long id2 = guild != null ? guild.getId() : 0L;
            String name = guild != null ? guild.getName() : null;
            ArrayList arrayList = new ArrayList(this.$loadedState.getMentions().size() * 2);
            Set setEmptySet = n0.emptySet();
            Map<Long, StoreMessageReplies.MessageState> allMessageReferences = StoreStream.INSTANCE.getRepliedMessages().getAllMessageReferences();
            for (Message message : this.$loadedState.getMentions()) {
                Channel channel = map6.get(Long.valueOf(message.getChannelId()));
                if (channel != null) {
                    Map<Long, GuildMember> mapEmptyMap = map8.get(Long.valueOf(message.getChannelId()));
                    if (mapEmptyMap == null) {
                        mapEmptyMap = h0.emptyMap();
                    }
                    Map<Long, GuildMember> map9 = mapEmptyMap;
                    Object objC = a.c(channel, map7);
                    if (objC == null) {
                        objC = h0.emptyMap();
                    }
                    Map map10 = (Map) objC;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    MessageReference messageReference = message.getMessageReference();
                    Long messageId = messageReference != null ? messageReference.getMessageId() : null;
                    if (messageId != null) {
                        Object obj = (StoreMessageReplies.MessageState) allMessageReferences.get(messageId);
                        if (obj == null) {
                            obj = StoreMessageReplies.MessageState.Unloaded.INSTANCE;
                        }
                        linkedHashMap.put(messageId, obj);
                    }
                    arrayList.add(new MessageHeaderEntry(message, channel, (Guild) a.c(channel, map3)));
                    arrayList.addAll(WidgetChatListModelMessages.Companion.getMessageItems$default(WidgetChatListModelMessages.INSTANCE, channel, map9, map10, h0.emptyMap(), messagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), messagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, messagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), linkedHashMap, false, false, null, z2, z3, StoreStream.INSTANCE.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                }
                map6 = map;
                map7 = map4;
                map8 = map5;
            }
            if (this.$loadedState.isLoading()) {
                arrayList.add(new LoadingEntry());
            } else if (this.$loadedState.isAllLoaded()) {
                arrayList.add(new MentionFooterEntry());
            }
            return new WidgetUserMentions.Model(j, -1L, map3.get(Long.valueOf(id2)), id2, map2, -1L, arrayList, setEmptySet, -1L, false, z2, name, WidgetUserMentions$Model$Companion$get$1.this.$selectedTab, 512, null);
        }
    }

    public WidgetUserMentions$Model$Companion$get$1(NavigationTab navigationTab) {
        this.$selectedTab = navigationTab;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMentions.Model> call(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        return call2(loadingState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMentions.Model> call2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        Observable<WidgetChatListModelMessages.MessagesWithMetadata> observable = WidgetChatListModelMessages.MessagesWithMetadata.INSTANCE.get(loadingState.getMentions());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, companion.getGuildSelected().observeSelectedGuild(), companion.getChannels().observeAllChannels(), companion.getChannels().observeNames(), companion.getGuilds().observeGuilds(), companion.getGuilds().observeRoles(), companion.getGuilds().observeComputed(), companion.getUsers().observeMeId(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), new AnonymousClass1(loadingState));
    }
}
