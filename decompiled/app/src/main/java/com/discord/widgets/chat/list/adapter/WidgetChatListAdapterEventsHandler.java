package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageClicked;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageCtaClicked;
import com.discord.analytics.generated.events.TrackWelcomeCtaClicked;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.sticker.StickerType;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.user.CoreUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.stickers.WidgetGuildStickerSheet;
import com.discord.widgets.stickers.WidgetStickerSheet;
import com.discord.widgets.stickers.WidgetUnknownStickerSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetStartCallSheet;
import d0.t.h0;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.a.l2;
import j0.l.a.r;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: WidgetChatListAdapterEventsHandler.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler implements WidgetChatListAdapter.EventHandler {
    private final AnalyticsUtils.Tracker analyticsTracker;
    private final ChannelSelector channelSelector;
    private final StoreChannels channelStore;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment host;
    private final MessageManager messageManager;
    private final StoreChat storeChat;
    private final StoreEmoji storeEmoji;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreUser storeUser;
    private final UserReactionHandler userReactionHandler;

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    public static final class UserReactionHandler {
        private static final long REQUEST_RATE_LIMIT_MILLIS = 250;
        private final Function1<MessageReactionUpdate, Unit> commitReactionAdd;
        private final Function1<MessageReactionUpdate, Unit> commitReactionRemove;
        private final AppFragment host;
        private final Subject<UpdateRequest, UpdateRequest> requestStream;
        private final StoreEmoji storeEmoji;
        private final StoreMessages storeMessages;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<UpdateRequest, Unit> {
            public AnonymousClass1(UserReactionHandler userReactionHandler) {
                super(1, userReactionHandler, UserReactionHandler.class, "requestReactionUpdate", "requestReactionUpdate(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateRequest updateRequest) {
                invoke2(updateRequest);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateRequest updateRequest) {
                m.checkNotNullParameter(updateRequest, "p1");
                UserReactionHandler.access$requestReactionUpdate((UserReactionHandler) this.receiver, updateRequest);
            }
        }

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        public static final /* data */ class UpdateRequest {
            private final long channelId;
            private final long messageId;
            private final MessageReaction reaction;
            private final long userId;

            public UpdateRequest(long j, long j2, long j3, MessageReaction messageReaction) {
                m.checkNotNullParameter(messageReaction, "reaction");
                this.userId = j;
                this.channelId = j2;
                this.messageId = j3;
                this.reaction = messageReaction;
            }

            public static /* synthetic */ UpdateRequest copy$default(UpdateRequest updateRequest, long j, long j2, long j3, MessageReaction messageReaction, int i, Object obj) {
                return updateRequest.copy((i & 1) != 0 ? updateRequest.userId : j, (i & 2) != 0 ? updateRequest.channelId : j2, (i & 4) != 0 ? updateRequest.messageId : j3, (i & 8) != 0 ? updateRequest.reaction : messageReaction);
            }

            /* renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component4, reason: from getter */
            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final UpdateRequest copy(long userId, long channelId, long messageId, MessageReaction reaction) {
                m.checkNotNullParameter(reaction, "reaction");
                return new UpdateRequest(userId, channelId, messageId, reaction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateRequest)) {
                    return false;
                }
                UpdateRequest updateRequest = (UpdateRequest) other;
                return this.userId == updateRequest.userId && this.channelId == updateRequest.channelId && this.messageId == updateRequest.messageId && m.areEqual(this.reaction, updateRequest.reaction);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                int iA = (b.a(this.messageId) + ((b.a(this.channelId) + (b.a(this.userId) * 31)) * 31)) * 31;
                MessageReaction messageReaction = this.reaction;
                return iA + (messageReaction != null ? messageReaction.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("UpdateRequest(userId=");
                sbU.append(this.userId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", reaction=");
                sbU.append(this.reaction);
                sbU.append(")");
                return sbU.toString();
            }
        }

        public UserReactionHandler(AppFragment appFragment, StoreMessages storeMessages, StoreEmoji storeEmoji) {
            m.checkNotNullParameter(appFragment, "host");
            m.checkNotNullParameter(storeMessages, "storeMessages");
            m.checkNotNullParameter(storeEmoji, "storeEmoji");
            this.host = appFragment;
            this.storeMessages = storeMessages;
            this.storeEmoji = storeEmoji;
            PublishSubject publishSubjectK0 = PublishSubject.k0();
            m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
            this.requestStream = publishSubjectK0;
            this.commitReactionAdd = new WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1(this);
            this.commitReactionRemove = new WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionRemove$1(this);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(publishSubjectK0);
            Observable observableH0 = Observable.h0(new r(publishSubjectK0.j, new l2(REQUEST_RATE_LIMIT_MILLIS, timeUnit, j0.p.a.a())));
            m.checkNotNullExpressionValue(observableH0, "requestStream\n          …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableH0, appFragment.getClass(), appFragment.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 60, (Object) null);
        }

        public static final /* synthetic */ StoreEmoji access$getStoreEmoji$p(UserReactionHandler userReactionHandler) {
            return userReactionHandler.storeEmoji;
        }

        public static final /* synthetic */ StoreMessages access$getStoreMessages$p(UserReactionHandler userReactionHandler) {
            return userReactionHandler.storeMessages;
        }

        public static final /* synthetic */ void access$requestReactionUpdate(UserReactionHandler userReactionHandler, UpdateRequest updateRequest) {
            userReactionHandler.requestReactionUpdate(updateRequest);
        }

        private final void requestReactionUpdate(UpdateRequest updateRequest) {
            String name;
            long userId = updateRequest.getUserId();
            long channelId = updateRequest.getChannelId();
            long messageId = updateRequest.getMessageId();
            MessageReaction reaction = updateRequest.getReaction();
            MessageReactionUpdate messageReactionUpdate = new MessageReactionUpdate(userId, channelId, messageId, reaction.getEmoji());
            if (reaction.getEmoji().e()) {
                name = reaction.getEmoji().getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + reaction.getEmoji().getId();
            } else {
                name = reaction.getEmoji().getName();
                if (name == null) {
                    name = "";
                }
            }
            Observable<Void> observableRemoveSelfReaction = reaction.getMe() ? RestAPI.INSTANCE.getApi().removeSelfReaction(channelId, messageId, name) : RestAPI.INSTANCE.getApi().addReaction(channelId, messageId, name);
            Function1<MessageReactionUpdate, Unit> function1 = reaction.getMe() ? this.commitReactionRemove : this.commitReactionAdd;
            Function1<MessageReactionUpdate, Unit> function12 = reaction.getMe() ? this.commitReactionAdd : this.commitReactionRemove;
            function1.invoke(messageReactionUpdate);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableRemoveSelfReaction, false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, new WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$2(function12, messageReactionUpdate), (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1(this, reaction), 52, (Object) null);
        }

        public final void addNewReaction(Emoji emoji, long channelId, long messageId) {
            m.checkNotNullParameter(emoji, "emoji");
            RestAPI api = RestAPI.INSTANCE.getApi();
            String reactionKey = emoji.getReactionKey();
            m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(channelId, messageId, reactionKey), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChatListAdapterEventsHandler$UserReactionHandler$addNewReaction$1.INSTANCE, 60, (Object) null);
        }

        public final void toggleReaction(long userId, long channelId, long messageId, MessageReaction reaction) {
            m.checkNotNullParameter(reaction, "reaction");
            this.requestStream.onNext(new UpdateRequest(userId, channelId, messageId, reaction));
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetChatListAdapterItemCallMessage.CallStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_JOINED.ordinal()] = 1;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_UNJOINED.ordinal()] = 2;
            StickerType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StickerType.STANDARD.ordinal()] = 1;
            iArr2[StickerType.GUILD.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onCallMessageClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$voiceChannelId, true, null, null, 24, null);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03861 implements EmojiPickerListener {
            public C03861() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                m.checkNotNullParameter(emoji, "emoji");
                UserReactionHandler userReactionHandlerAccess$getUserReactionHandler$p = WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler.this);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                userReactionHandlerAccess$getUserReactionHandler$p.addNewReaction(emoji, anonymousClass1.$channelId, anonymousClass1.$messageId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmojiPickerNavigator.launchBottomSheet$default(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), new C03861(), EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $fileName;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ WeakReference $weakContext;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03871 extends o implements Function1<String, Unit> {
            public C03871() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Context context = (Context) AnonymousClass1.this.$weakContext.get();
                if (context != null) {
                    b.a.d.m.h(context, b.a.k.b.h(context, R.string.download_file_complete, new Object[]{str}, null, 4), 0, null, 12);
                }
            }
        }

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Throwable, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                m.checkNotNullParameter(th, "error");
                AppLog.i("Could not download attachment due to:  \n" + th);
                Context context = (Context) AnonymousClass1.this.$weakContext.get();
                if (context != null) {
                    b.a.d.m.h((Context) AnonymousClass1.this.$weakContext.get(), context.getString(R.string.download_failed), 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, String str, WeakReference weakReference) {
            super(0);
            this.$uri = uri;
            this.$fileName = str;
            this.$weakContext = weakReference;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NetworkUtils.downloadFile(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$uri, this.$fileName, null, new C03871(), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, long j3, MessageReaction messageReaction) {
            super(0);
            this.$myUserId = j;
            this.$channelId = j2;
            this.$messageId = j3;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler.this).toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionLongClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$reaction);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Message, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            m.checkNotNullParameter(message, "it");
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onShareButtonClick$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Channel, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ long $guildEventId;
        public final /* synthetic */ WeakReference $weakFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, Channel channel, long j) {
            super(1);
            this.$weakFragment = weakReference;
            this.$channel = channel;
            this.$guildEventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            AppFragment appFragment = (AppFragment) this.$weakFragment.get();
            if (appFragment != null) {
                ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
                m.checkNotNullExpressionValue(appFragment, "fragment");
                Channel channel2 = this.$channel;
                ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, appFragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<BaseSticker, Unit> {
        public final /* synthetic */ com.discord.models.message.Message $message;
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseSticker baseSticker, com.discord.models.message.Message message) {
            super(1);
            this.$sticker = baseSticker;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSticker baseSticker) {
            invoke2(baseSticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BaseSticker baseSticker) {
            if (baseSticker == null) {
                baseSticker = this.$sticker;
            }
            if (baseSticker instanceof StickerPartial) {
                return;
            }
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
            Sticker sticker = (Sticker) baseSticker;
            int iOrdinal = sticker.getType().ordinal();
            if (iOrdinal == 1) {
                WidgetStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), sticker, this.$message.getChannelId());
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                WidgetGuildStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), sticker);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BaseSticker baseSticker) {
            super(1);
            this.$sticker = baseSticker;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetUnknownStickerSheet.Companion companion = WidgetUnknownStickerSheet.INSTANCE;
            FragmentManager fragmentManagerAccess$getFragmentManager$p = WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this);
            BaseSticker baseSticker = this.$sticker;
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
            companion.show(fragmentManagerAccess$getFragmentManager$p, (StickerPartial) baseSticker);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Sticker, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFullStickerClicked$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$handleFullStickerClicked$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            this.$handleFullStickerClicked$1.invoke2((BaseSticker) sticker);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onUserActivityAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ActivityActionConfirmation, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityActionConfirmation activityActionConfirmation) {
            invoke2(activityActionConfirmation);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ActivityActionConfirmation activityActionConfirmation) {
            m.checkNotNullParameter(activityActionConfirmation, "<name for destructuring parameter 0>");
            try {
                Intent intentJoin = IntentUtils.RouteBuilders.SDK.join(this.$application.a(), this.$application.getId(), activityActionConfirmation.getSecret());
                intentJoin.addFlags(268435456);
                WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this).startActivity(intentJoin);
            } catch (ActivityNotFoundException unused) {
                b.a.d.m.h(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), b.a.k.b.h(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), R.string.user_activity_not_detected, new Object[]{this.$application.getName()}, null, 4), 0, null, 12);
                String str = (String) u.firstOrNull((List) this.$application.d());
                if (str != null) {
                    UriHandler.directToPlayStore$default(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), str, null, 4, null);
                }
            }
        }
    }

    public WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker) {
        m.checkNotNullParameter(appFragment, "host");
        m.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        m.checkNotNullParameter(storeChat, "storeChat");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(channelSelector, "channelSelector");
        m.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(tracker, "analyticsTracker");
        this.host = appFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeChat = storeChat;
        this.storeMessages = storeMessages;
        this.storePendingReplies = storePendingReplies;
        this.storeUser = storeUser;
        this.storeEmoji = storeEmoji;
        this.messageManager = messageManager;
        this.channelSelector = channelSelector;
        this.userReactionHandler = userReactionHandler;
        this.channelStore = storeChannels;
        this.analyticsTracker = tracker;
    }

    public static final /* synthetic */ Context access$getContext$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getContext();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getFragmentManager();
    }

    public static final /* synthetic */ UserReactionHandler access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.userReactionHandler;
    }

    private final Context getContext() {
        return this.host.requireContext();
    }

    private final FragmentManager getFragmentManager() {
        FragmentManager parentFragmentManager = this.host.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "host.parentFragmentManager");
        return parentFragmentManager;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
        m.checkNotNullParameter(componentSendData, "componentSendData");
        StoreStream.INSTANCE.getInteractions().sendComponentInteraction(applicationId, guildId, channelId, messageId, componentIndex, componentSendData, messageFlags);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
        m.checkNotNullParameter(callStatus, "callStatus");
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0) {
            d.S1(this.host, null, new AnonymousClass1(voiceChannelId), 1, null);
        } else if (iOrdinal != 1) {
            WidgetStartCallSheet.INSTANCE.show(voiceChannelId, getFragmentManager());
        } else {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, getContext(), voiceChannelId, false, null, null, 28, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        WidgetApplicationCommandBottomSheet.Companion companion = WidgetApplicationCommandBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = this.host.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "host.childFragmentManager");
        companion.show(childFragmentManager, interactionId, messageId, channelId, guildId, interactionUserId, applicationId, messageNonce);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissClicked(com.discord.models.message.Message message) {
        m.checkNotNullParameter(message, "message");
        this.storeMessages.deleteMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissLocalMessageClicked(com.discord.models.message.Message message) {
        m.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            this.storeMessages.deleteLocalMessage(message.getChannelId(), nonce);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
        m.checkNotNullParameter(interactionState, "interactionState");
        this.storeChat.setInteractionState(interactionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onListClicked() {
        AppFragment.hideKeyboard$default(this.host, null, 1, null);
        this.flexInputViewModel.hideExpressionTray();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorAvatarClicked(com.discord.models.message.Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message) || message.isCrosspost()) {
            onMessageAuthorNameClicked(message, guildId);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorLongClicked(com.discord.models.message.Message message, Long guildId) {
        m.checkNotNullParameter(message, "message");
        if (message.isWebhook()) {
            b.a.d.m.g(getContext(), R.string.user_profile_failure_to_open_message, 0, null, 8);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), guildId, null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorNameClicked(com.discord.models.message.Message message, long guildId) {
        m.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message)) {
            WidgetPublicAnnouncementProfileSheet.INSTANCE.show(getFragmentManager());
            return;
        }
        if (!message.isCrosspost() || message.getMessageReference() == null) {
            StoreChat storeChat = this.storeChat;
            User author = message.getAuthor();
            m.checkNotNull(author);
            storeChat.appendMention(new CoreUser(author), guildId);
            return;
        }
        MessageReference messageReference = message.getMessageReference();
        Long channelId = messageReference != null ? messageReference.getChannelId() : null;
        MessageReference messageReference2 = message.getMessageReference();
        Long guildId2 = messageReference2 != null ? messageReference2.getGuildId() : null;
        if (guildId2 == null || channelId == null) {
            return;
        }
        WidgetGuildProfileSheet.Companion.show$default(WidgetGuildProfileSheet.INSTANCE, getFragmentManager(), false, guildId2.longValue(), channelId.longValue(), false, 16, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageBlockedGroupClicked(com.discord.models.message.Message message) {
        m.checkNotNullParameter(message, "message");
        this.storeChat.toggleBlockedMessageGroup(message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageClicked(com.discord.models.message.Message message, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        if (isThreadStarterMessage) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageLongClicked(com.discord.models.message.Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(formattedMessage, "formattedMessage");
        if (isThreadStarterMessage) {
            return;
        }
        WidgetChatListActions.INSTANCE.showForChat(getFragmentManager(), message.getChannelId(), message.getId(), formattedMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOldestMessageId(long channelId, long oldestMessageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOpenPinsClicked(com.discord.models.message.Message message) {
        m.checkNotNullParameter(message, "message");
        WidgetChannelPinnedMessages.INSTANCE.show(getContext(), message.getChannelId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(channelId, messageId), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String fileName) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        m.checkNotNullParameter(fileName, "fileName");
        this.host.requestMediaDownload(new AnonymousClass1(uri, fileName, new WeakReference(getContext())));
        return true;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
        m.checkNotNullParameter(reaction, "reaction");
        if (canAddReactions) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(myUserId, channelId, messageId, reaction), 32, null);
        } else {
            b.a.d.m.g(getContext(), R.string.archived_thread_reactions_disabled_toast, 0, null, 8);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(channelId, messageId, reaction), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReportIssueWithAutoMod(Context context, com.discord.models.message.Message message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        WidgetReportIssueWithAutoMod.INSTANCE.launch(context, message.getChannelId(), message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId) {
        WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(getContext(), guildId, "Role Subscriptions Tab");
        AnalyticsUtils.Tracker tracker = this.analyticsTracker;
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = new TrackRoleSubscriptionPurchaseSystemMessageClicked(Long.valueOf(messageId), Long.valueOf(roleSubscriptionListingId));
        trackRoleSubscriptionPurchaseSystemMessageClicked.f(new TrackChannel(Long.valueOf(channelId), null, null, null, null, null, 62));
        trackRoleSubscriptionPurchaseSystemMessageClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        trackRoleSubscriptionPurchaseSystemMessageClicked.e(new TrackBase(null, null, null, null, null, Long.valueOf(userId), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, -1, 2047));
        tracker.track(trackRoleSubscriptionPurchaseSystemMessageClicked);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        AnalyticsTracker.INSTANCE.getTracker().track("dm_empty_action", h0.mutableMapOf(d0.o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId)), d0.o.to("channel_type", Integer.valueOf(channelType)), d0.o.to("source", "Wave"), d0.o.to("type", "Send wave")));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendGreetMessage(channelId, new RestAPIParams.GreetMessage(d0.t.m.listOf(Long.valueOf(sticker.getId())))), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 60, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        Channel channel;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(weakContext, "weakContext");
        m.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(GuildScheduledEventUtilities.INSTANCE, channelId, guildId, null, null, null, null, 60, null);
        if (channelId != null) {
            channel = this.channelStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent$default) {
            Observable<Channel> observableZ = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).z();
            m.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(weakFragment, channel, id2), 62, (Object) null);
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                m.checkNotNullExpressionValue(context, "context");
                b.a.d.m.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onStickerClicked(com.discord.models.message.Message message, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(sticker, "sticker");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(sticker, message);
        this.flexInputViewModel.hideKeyboard();
        if (sticker instanceof Sticker) {
            anonymousClass1.invoke2(sticker);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StickerUtils.INSTANCE.getGuildOrStandardSticker(sticker.getId(), true), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, new AnonymousClass2(sticker), (Function0) null, (Function0) null, new AnonymousClass3(anonymousClass1), 54, (Object) null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSystemMessageCtaClicked(com.discord.models.message.Message message, Channel channel, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(sticker, "sticker");
        this.storePendingReplies.onCreatePendingReply(channel, message, true, true);
        MessageManager.sendMessage$default(this.messageManager, null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
        Integer type = message.getType();
        if (type != null && type.intValue() == 7) {
            AnalyticsUtils.Tracker tracker = this.analyticsTracker;
            Boolean bool = Boolean.TRUE;
            String strValueOf = String.valueOf(sticker.getId());
            User author = message.getAuthor();
            tracker.track(new TrackWelcomeCtaClicked(bool, strValueOf, author != null ? Long.valueOf(author.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId())));
            return;
        }
        if (type != null && type.intValue() == 25) {
            AnalyticsUtils.Tracker tracker2 = this.analyticsTracker;
            String strValueOf2 = String.valueOf(sticker.getId());
            User author2 = message.getAuthor();
            TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = new TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long.valueOf(message.getId()), strValueOf2, author2 != null ? Long.valueOf(author2.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId()));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.c(new TrackGuild(Long.valueOf(channel.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.e(new TrackChannel(Long.valueOf(channel.getId()), null, null, null, null, null, 62));
            tracker2.track(trackRoleSubscriptionPurchaseSystemMessageCtaClicked);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channelSelector.selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.EMBED);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        WidgetChannelsListItemThreadActions.INSTANCE.show(getFragmentManager(), channel.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUrlLongClicked(String url) {
        m.checkNotNullParameter(url, "url");
        WidgetUrlActions.INSTANCE.launch(getFragmentManager(), url);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
        m.checkNotNullParameter(actionType, "actionType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
        Long applicationId = activity.getApplicationId();
        String sessionId = activity.getSessionId();
        if (applicationId == null || sessionId == null || actionType != MessageActivityType.JOIN) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userActivityActionJoin(authorId, applicationId.longValue(), sessionId, Long.valueOf(channelId), Long.valueOf(messageId)), false, 1, null), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(application), 62, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserMentionClicked(long userId, long channelId, long guildId) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channelId), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChat chat = (i & 4) != 0 ? StoreStream.INSTANCE.getChat() : storeChat;
        StoreMessages messages = (i & 8) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        StorePendingReplies pendingReplies = (i & 16) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        this(appFragment, appFlexInputViewModel, chat, messages, pendingReplies, users, emojis, (i & 128) != 0 ? new MessageManager(appFragment.requireContext(), null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 256) != 0 ? ChannelSelector.INSTANCE.getInstance() : channelSelector, (i & 512) != 0 ? new UserReactionHandler(appFragment, messages, emojis) : userReactionHandler, (i & 1024) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2048) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : tracker);
    }
}
