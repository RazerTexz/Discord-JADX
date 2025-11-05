package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChatListActionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.ManageMessageContext;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.MessageUnparser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.mobile_reports.ReportsFeatureFlag;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolation;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.g0.t;
import d0.t.g0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetChatListActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatListActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_MESSAGE_CHANNEL_ID = "INTENT_EXTRA_MESSAGE_CHANNEL_ID";
    private static final String INTENT_EXTRA_MESSAGE_CONTENT = "INTENT_EXTRA_MESSAGE_CONTENT";
    private static final String INTENT_EXTRA_MESSAGE_ID = "INTENT_EXTRA_MESSAGE_ID";
    private static final String INTENT_EXTRA_TYPE = "INTENT_EXTRA_TYPE";
    private static final int TYPE_CHAT = 0;
    private static final int TYPE_PINS = 1;
    private WidgetChatListActionsEmojisAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long channelId;
    private PaddedItemDecorator itemDecorator;
    private long messageId;

    /* compiled from: WidgetChatListActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showForChat(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(messageContent, "messageContent");
            WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
            Bundle bundleT = a.T(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CHANNEL_ID, channelId);
            bundleT.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_ID, messageId);
            bundleT.putCharSequence(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CONTENT, messageContent);
            bundleT.putInt(WidgetChatListActions.INTENT_EXTRA_TYPE, 0);
            widgetChatListActions.setArguments(bundleT);
            widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
        }

        public final void showForPin(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(messageContent, "messageContent");
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CHANNEL_ID, channelId);
            bundle.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_ID, messageId);
            bundle.putCharSequence(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CONTENT, messageContent);
            bundle.putInt(WidgetChatListActions.INTENT_EXTRA_TYPE, 1);
            WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
            widgetChatListActions.setArguments(bundle);
            widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final ManageMessageContext manageMessageContext;
        private final MeUser me;
        private final Message message;
        private final String messageAuthorName;
        private final CharSequence messageContent;
        private final Long permissions;
        private final List<Emoji> recentEmojis;
        private final int type;

        /* compiled from: WidgetChatListActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ Model access$create(Companion companion, Message message, Guild guild, Long l, MeUser meUser, GuildMember guildMember, Channel channel, CharSequence charSequence, int i, EmojiSet emojiSet) {
                return companion.create(message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
            }

            private final Model create(Message message, Guild guild, Long permissions, MeUser meUser, GuildMember member, Channel channel, CharSequence messageContent, int type, EmojiSet emojis) {
                String nick;
                ThreadMetadata threadMetadata;
                String username = null;
                if (message == null) {
                    return null;
                }
                ManageMessageContext manageMessageContextFrom = ManageMessageContext.INSTANCE.from(message, permissions, meUser, guild != null ? Integer.valueOf(guild.getMfaLevel()) : null, channel != null && ChannelUtils.B(channel), channel != null && ChannelUtils.E(channel), (channel == null || (threadMetadata = channel.getThreadMetadata()) == null || !threadMetadata.getArchived()) ? false : true);
                if (member == null || (nick = member.getNick()) == null) {
                    User author = message.getAuthor();
                    if (author != null) {
                        username = author.getUsername();
                    }
                } else {
                    username = nick;
                }
                if (username == null) {
                    username = "";
                }
                String str = username;
                boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
                List<Emoji> list = emojis.recentEmojis;
                m.checkNotNullExpressionValue(list, "emojis.recentEmojis");
                return new Model(message, guild, str, messageContent, manageMessageContextFrom, type, isDeveloperMode, list, channel, permissions, meUser);
            }

            public final Observable<Model> get(long channelId, long messageId, CharSequence messageContent, int type) {
                Observable<Model> observableY = Observable.j(type != 0 ? type != 1 ? new k<>(null) : StoreStream.INSTANCE.getPinnedMessages().observePinnedMessage(channelId, messageId) : StoreStream.INSTANCE.getMessages().observeMessagesForChannel(channelId, messageId), StoreStream.INSTANCE.getChannels().observeChannel(channelId), WidgetChatListActions$Model$Companion$get$1.INSTANCE).Y(new WidgetChatListActions$Model$Companion$get$2(channelId, messageContent, type));
                m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Message message, Guild guild, String str, CharSequence charSequence, ManageMessageContext manageMessageContext, int i, boolean z2, List<? extends Emoji> list, Channel channel, Long l, MeUser meUser) {
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(str, "messageAuthorName");
            m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
            m.checkNotNullParameter(list, "recentEmojis");
            m.checkNotNullParameter(meUser, "me");
            this.message = message;
            this.guild = guild;
            this.messageAuthorName = str;
            this.messageContent = charSequence;
            this.manageMessageContext = manageMessageContext;
            this.type = i;
            this.isDeveloper = z2;
            this.recentEmojis = list;
            this.channel = channel;
            this.permissions = l;
            this.me = meUser;
        }

        public static /* synthetic */ Model copy$default(Model model, Message message, Guild guild, String str, CharSequence charSequence, ManageMessageContext manageMessageContext, int i, boolean z2, List list, Channel channel, Long l, MeUser meUser, int i2, Object obj) {
            return model.copy((i2 & 1) != 0 ? model.message : message, (i2 & 2) != 0 ? model.guild : guild, (i2 & 4) != 0 ? model.messageAuthorName : str, (i2 & 8) != 0 ? model.messageContent : charSequence, (i2 & 16) != 0 ? model.manageMessageContext : manageMessageContext, (i2 & 32) != 0 ? model.type : i, (i2 & 64) != 0 ? model.isDeveloper : z2, (i2 & 128) != 0 ? model.recentEmojis : list, (i2 & 256) != 0 ? model.channel : channel, (i2 & 512) != 0 ? model.permissions : l, (i2 & 1024) != 0 ? model.me : meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component10, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* renamed from: component11, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessageAuthorName() {
            return this.messageAuthorName;
        }

        /* renamed from: component4, reason: from getter */
        public final CharSequence getMessageContent() {
            return this.messageContent;
        }

        /* renamed from: component5, reason: from getter */
        public final ManageMessageContext getManageMessageContext() {
            return this.manageMessageContext;
        }

        /* renamed from: component6, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final List<Emoji> component8() {
            return this.recentEmojis;
        }

        /* renamed from: component9, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Model copy(Message message, Guild guild, String messageAuthorName, CharSequence messageContent, ManageMessageContext manageMessageContext, int type, boolean isDeveloper, List<? extends Emoji> recentEmojis, Channel channel, Long permissions, MeUser me2) {
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(messageAuthorName, "messageAuthorName");
            m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
            m.checkNotNullParameter(recentEmojis, "recentEmojis");
            m.checkNotNullParameter(me2, "me");
            return new Model(message, guild, messageAuthorName, messageContent, manageMessageContext, type, isDeveloper, recentEmojis, channel, permissions, me2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.message, model.message) && m.areEqual(this.guild, model.guild) && m.areEqual(this.messageAuthorName, model.messageAuthorName) && m.areEqual(this.messageContent, model.messageContent) && m.areEqual(this.manageMessageContext, model.manageMessageContext) && this.type == model.type && this.isDeveloper == model.isDeveloper && m.areEqual(this.recentEmojis, model.recentEmojis) && m.areEqual(this.channel, model.channel) && m.areEqual(this.permissions, model.permissions) && m.areEqual(this.me, model.me);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ManageMessageContext getManageMessageContext() {
            return this.manageMessageContext;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getMessageAuthorName() {
            return this.messageAuthorName;
        }

        public final CharSequence getMessageContent() {
            return this.messageContent;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final List<Emoji> getRecentEmojis() {
            return this.recentEmojis;
        }

        public final int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            String str = this.messageAuthorName;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            CharSequence charSequence = this.messageContent;
            int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            ManageMessageContext manageMessageContext = this.manageMessageContext;
            int iHashCode5 = (((iHashCode4 + (manageMessageContext != null ? manageMessageContext.hashCode() : 0)) * 31) + this.type) * 31;
            boolean z2 = this.isDeveloper;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            List<Emoji> list = this.recentEmojis;
            int iHashCode6 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            return iHashCode8 + (meUser != null ? meUser.hashCode() : 0);
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(message=");
            sbU.append(this.message);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", messageAuthorName=");
            sbU.append(this.messageAuthorName);
            sbU.append(", messageContent=");
            sbU.append(this.messageContent);
            sbU.append(", manageMessageContext=");
            sbU.append(this.manageMessageContext);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", isDeveloper=");
            sbU.append(this.isDeveloper);
            sbU.append(", recentEmojis=");
            sbU.append(this.recentEmojis);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$addReaction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ Emoji $emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Emoji emoji) {
            super(1);
            this.$emoji = emoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getEmojis().onEmojiUsed(this.$emoji);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$editMessage(WidgetChatListActions.this, this.$data.getMessage());
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $guildId;

        public AnonymousClass10(Model model, long j) {
            this.$data = model;
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.this.requireContext().startActivity(Intent.createChooser(IntentUtils.INSTANCE.toExternalizedSend(IntentUtils.RouteBuilders.selectChannel(this.$data.getMessage().getChannelId(), this.$guildId, Long.valueOf(this.$data.getMessage().getId()))), WidgetChatListActions.this.getString(R.string.share_to)));
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass11(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$toggleMessagePin(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass12(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$deleteMessage(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$13, reason: invalid class name */
    public static final class AnonymousClass13 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass13(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.this.dismiss();
            User author = this.$data.getMessage().getAuthor();
            if (author != null) {
                long id2 = author.getId();
                WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChatListActions.this.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
            }
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$14, reason: invalid class name */
    public static final class AnonymousClass14 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass14(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.this.dismiss();
            if (this.$data.getChannel() != null) {
                WidgetChatListActions.access$replyMessage(WidgetChatListActions.this, this.$data.getMessage(), this.$data.getChannel());
            }
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$15, reason: invalid class name */
    public static final class AnonymousClass15 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $guildId;

        public AnonymousClass15(long j, Model model) {
            this.$guildId = j;
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.this.dismiss();
            ChannelSelector.INSTANCE.getInstance().openCreateThread(this.$guildId, this.$data.getMessage().getChannelId(), Long.valueOf(this.$data.getMessage().getId()), "Message");
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass2(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$confirmPublishMessage(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetManageReactions.Companion companion = WidgetManageReactions.INSTANCE;
            long jAccess$getChannelId$p = WidgetChatListActions.access$getChannelId$p(WidgetChatListActions.this);
            long jAccess$getMessageId$p = WidgetChatListActions.access$getMessageId$p(WidgetChatListActions.this);
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetManageReactions.Companion.create$default(companion, jAccess$getChannelId$p, jAccess$getMessageId$p, contextRequireContext, null, 8, null);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass4(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$removeAllReactions(WidgetChatListActions.this, this.$data);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<MessageResult, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
                invoke2(messageResult);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageResult messageResult) {
                m.checkNotNullParameter(messageResult, "messageResult");
                if (messageResult instanceof MessageResult.CaptchaRequired) {
                    SendUtils.INSTANCE.handleCaptchaRequired((MessageResult.CaptchaRequired) messageResult);
                }
            }
        }

        public AnonymousClass5(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer type = this.$data.getMessage().getType();
            if (type != null && type.intValue() == -4) {
                StoreStream.INSTANCE.getInteractions().resendApplicationCommand(this.$data.getMessage());
            } else {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(StoreMessages.resendMessage$default(StoreStream.INSTANCE.getMessages(), this.$data.getMessage(), false, null, 6, null)), WidgetChatListActions.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
            }
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass6(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessageAck().markUnread(this.$data.getMessage().getChannelId(), this.$data.getMessage().getId());
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass7(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String string = this.$data.getMessageContent().toString();
            EditedMessageNode.Companion companion = EditedMessageNode.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            b.a.d.m.c(contextRequireContext, t.replace$default(string, companion.getEditedString(context), "", false, 4, (Object) null), 0, 4);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass8(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            b.a.d.m.c(contextRequireContext, String.valueOf(this.$data.getMessage().getId()), 0, 4);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass9(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ReportsFeatureFlag.INSTANCE.isEnabled()) {
                WidgetMobileReports.INSTANCE.launchMessageReport(a.x(view, "view", "view.context"), this.$data.getMessage().getId(), WidgetChatListActions.access$getChannelId$p(WidgetChatListActions.this));
            } else {
                WidgetTosReportViolation.INSTANCE.show(a.x(view, "view", "view.context"), this.$data.getMessageAuthorName(), Long.valueOf(this.$data.getMessage().getChannelId()), Long.valueOf(this.$data.getMessage().getId()));
            }
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$confirmPublishMessage$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends d0.z.d.k implements Function0<Unit> {
        public AnonymousClass1(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$deleteMessage$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends d0.z.d.k implements Function0<Unit> {
        public AnonymousClass1(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Channel>, Observable<? extends CharSequence>> {
        public final /* synthetic */ Message $message;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03821<T1, T2, T3, R> implements Func3<Map<Long, ? extends com.discord.models.user.User>, Map<Long, ? extends Guild>, EmojiSet, CharSequence> {
            public final /* synthetic */ Map $channels;
            public final /* synthetic */ long $guildId;

            public C03821(long j, Map map) {
                this.$guildId = j;
                this.$channels = map;
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ CharSequence call(Map<Long, ? extends com.discord.models.user.User> map, Map<Long, ? extends Guild> map2, EmojiSet emojiSet) {
                return call2(map, (Map<Long, Guild>) map2, emojiSet);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final CharSequence call2(Map<Long, ? extends com.discord.models.user.User> map, Map<Long, Guild> map2, EmojiSet emojiSet) {
                String content = AnonymousClass1.this.$message.getContent();
                if (content == null) {
                    content = "";
                }
                Guild guild = map2.get(Long.valueOf(this.$guildId));
                Map map3 = this.$channels;
                m.checkNotNullExpressionValue(map3, "channels");
                m.checkNotNullExpressionValue(map, "users");
                m.checkNotNullExpressionValue(emojiSet, "emojiSet");
                return MessageUnparser.unparse(content, guild, map3, map, emojiSet);
            }
        }

        public AnonymousClass1(Message message) {
            this.$message = message;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends CharSequence> call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends CharSequence> call2(Map<Long, Channel> map) {
            Channel channel = map.get(Long.valueOf(this.$message.getChannelId()));
            long guildId = channel != null ? channel.getGuildId() : 0L;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getUsers().observeAllUsers(), companion.getGuilds().observeGuilds(), StoreEmoji.getEmojiSet$default(companion.getEmojis(), guildId, this.$message.getChannelId(), false, false, 12, null), new C03821(guildId, map));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<CharSequence, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            StoreChat chat = StoreStream.INSTANCE.getChat();
            Message message = this.$message;
            m.checkNotNullExpressionValue(charSequence, "unparsedMessageContent");
            chat.setEditingMessage(new StoreChat.EditingMessage(message, charSequence));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetChatListActions.access$configureUI(WidgetChatListActions.this, model);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Emoji, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
            invoke2(emoji);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Emoji emoji) {
            m.checkNotNullParameter(emoji, "emoji");
            WidgetChatListActions.access$addReaction(WidgetChatListActions.this, emoji);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements EmojiPickerListener {
            public AnonymousClass1() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                m.checkNotNullParameter(emoji, "emoji");
                WidgetChatListActions.access$addReaction(WidgetChatListActions.this, emoji);
            }
        }

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03832 extends o implements Function0<Unit> {
            public C03832() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChatListActions.this.dismiss();
            }
        }

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetChatListActions.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new AnonymousClass1(), EmojiPickerContextType.Chat.INSTANCE, new C03832());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03841 extends o implements Function1<Void, Unit> {
            public C03841() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetChatListActions.this.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "view");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeAllReactions(this.$model.getMessage().getChannelId(), this.$model.getMessage().getId()), false, 1, null), WidgetChatListActions.this, null, 2, null), view.getContext(), "REST: removeAllReactions", (Function1) null, new C03841(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$toggleMessagePin$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends d0.z.d.k implements Function0<Unit> {
        public AnonymousClass1(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    public WidgetChatListActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatListActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$addReaction(WidgetChatListActions widgetChatListActions, Emoji emoji) {
        widgetChatListActions.addReaction(emoji);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListActions widgetChatListActions, Model model) throws Resources.NotFoundException {
        widgetChatListActions.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmPublishMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.confirmPublishMessage(message);
    }

    public static final /* synthetic */ void access$deleteMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.deleteMessage(message);
    }

    public static final /* synthetic */ void access$editMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.editMessage(message);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetChatListActions widgetChatListActions) {
        return widgetChatListActions.channelId;
    }

    public static final /* synthetic */ long access$getMessageId$p(WidgetChatListActions widgetChatListActions) {
        return widgetChatListActions.messageId;
    }

    public static final /* synthetic */ void access$removeAllReactions(WidgetChatListActions widgetChatListActions, Model model) {
        widgetChatListActions.removeAllReactions(model);
    }

    public static final /* synthetic */ void access$replyMessage(WidgetChatListActions widgetChatListActions, Message message, Channel channel) {
        widgetChatListActions.replyMessage(message, channel);
    }

    public static final /* synthetic */ void access$setChannelId$p(WidgetChatListActions widgetChatListActions, long j) {
        widgetChatListActions.channelId = j;
    }

    public static final /* synthetic */ void access$setMessageId$p(WidgetChatListActions widgetChatListActions, long j) {
        widgetChatListActions.messageId = j;
    }

    public static final /* synthetic */ void access$toggleMessagePin(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.toggleMessagePin(message);
    }

    private final void addReaction(Emoji emoji) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long j = this.channelId;
        long j2 = this.messageId;
        String reactionKey = emoji.getReactionKey();
        m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(j, j2, reactionKey), false, 1, null), this, null, 2, null), getContext(), "REST: addReaction", (Function1) null, new AnonymousClass1(emoji), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureAddReactionEmojisList(List<? extends Emoji> recentEmojis, boolean isLocalMessage, boolean canAddReactions) throws Resources.NotFoundException {
        if (recentEmojis.isEmpty() || isLocalMessage || !canAddReactions) {
            RecyclerView recyclerView = getBinding().f2307b;
            m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        recyclerView2.setVisibility(0);
        RecyclerView recyclerView3 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.dialogChatActionsAddReactionEmojisList");
        int width = recyclerView3.getWidth();
        RecyclerView recyclerView4 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView4, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingStart = recyclerView4.getPaddingStart();
        RecyclerView recyclerView5 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView5, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingEnd = recyclerView5.getPaddingEnd() + paddingStart;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.chat_input_emoji_size);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = width - paddingEnd;
        int iMin = Math.min(recentEmojis.size() + 1, (i + iDpToPixels) / (dimensionPixelSize + iDpToPixels));
        int i2 = iMin - 1;
        int iMax = Math.max(i - ((i2 * iDpToPixels) + (dimensionPixelSize * iMin)), 0);
        PaddedItemDecorator paddedItemDecorator = this.itemDecorator;
        if (paddedItemDecorator != null) {
            getBinding().f2307b.removeItemDecoration(paddedItemDecorator);
        }
        PaddedItemDecorator paddedItemDecorator2 = new PaddedItemDecorator(0, (iMax / i2) + iDpToPixels, 0, true);
        getBinding().f2307b.addItemDecoration(paddedItemDecorator2);
        this.itemDecorator = paddedItemDecorator2;
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = this.adapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setData(recentEmojis, iMin);
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(Model data) throws Resources.NotFoundException {
        Channel channel;
        Integer type;
        if (data == null) {
            dismiss();
            return;
        }
        Guild guild = data.getGuild();
        long id2 = guild != null ? guild.getId() : 0L;
        boolean zIsLocal = data.getMessage().isLocal();
        boolean zIsCrossposted = data.getMessage().isCrossposted();
        boolean z2 = true;
        boolean z3 = data.getManageMessageContext().getCanEdit() || data.getManageMessageContext().getCanManageMessages();
        configureAddReactionEmojisList(data.getRecentEmojis(), zIsLocal, data.getManageMessageContext().getCanAddReactions());
        int type2 = data.getType();
        if (type2 == 0) {
            TextView textView = getBinding().f;
            m.checkNotNullExpressionValue(textView, "binding.dialogChatActionsEdit");
            textView.setVisibility(data.getManageMessageContext().getCanEdit() ? 0 : 8);
            getBinding().f.setOnClickListener(new AnonymousClass1(data));
        } else if (type2 == 1) {
            TextView textView2 = getBinding().f;
            m.checkNotNullExpressionValue(textView2, "binding.dialogChatActionsEdit");
            textView2.setVisibility(8);
        }
        TextView textView3 = getBinding().k;
        m.checkNotNullExpressionValue(textView3, "binding.dialogChatActionsPublish");
        textView3.setVisibility(z3 && (channel = data.getChannel()) != null && channel.getType() == 5 && (type = data.getMessage().getType()) != null && type.intValue() == 0 && !zIsCrossposted ? 0 : 8);
        getBinding().k.setOnClickListener(new AnonymousClass2(data));
        TextView textView4 = getBinding().g;
        m.checkNotNullExpressionValue(textView4, "binding.dialogChatActionsManageReactions");
        textView4.setVisibility(data.getMessage().getReactionsMap().isEmpty() ^ true ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass3());
        TextView textView5 = getBinding().l;
        m.checkNotNullExpressionValue(textView5, "binding.dialogChatActionsRemoveAllReactions");
        textView5.setVisibility((data.getMessage().getReactionsMap().isEmpty() ^ true) && data.getManageMessageContext().getCanManageMessages() ? 0 : 8);
        getBinding().l.setOnClickListener(new AnonymousClass4(data));
        TextView textView6 = getBinding().o;
        m.checkNotNullExpressionValue(textView6, "binding.dialogChatActionsResend");
        textView6.setVisibility(data.getMessage().canResend() ? 0 : 8);
        getBinding().o.setOnClickListener(new AnonymousClass5(data));
        TextView textView7 = getBinding().h;
        m.checkNotNullExpressionValue(textView7, "binding.dialogChatActionsMarkUnread");
        textView7.setVisibility(!data.getMessage().isFailed() && data.getManageMessageContext().getCanMarkUnread() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass6(data));
        if (data.getMessageContent() == null) {
            TextView textView8 = getBinding().c;
            m.checkNotNullExpressionValue(textView8, "binding.dialogChatActionsCopy");
            textView8.setVisibility(8);
        } else {
            if ((data.getMessageContent().length() > 0) && !data.getMessage().isLocalApplicationCommand()) {
                TextView textView9 = getBinding().c;
                m.checkNotNullExpressionValue(textView9, "binding.dialogChatActionsCopy");
                textView9.setVisibility(0);
                getBinding().c.setOnClickListener(new AnonymousClass7(data));
            }
        }
        TextView textView10 = getBinding().d;
        m.checkNotNullExpressionValue(textView10, "binding.dialogChatActionsCopyId");
        textView10.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().d.setOnClickListener(new AnonymousClass8(data));
        TextView textView11 = getBinding().n;
        m.checkNotNullExpressionValue(textView11, "binding.dialogChatActionsReport");
        User author = data.getMessage().getAuthor();
        textView11.setVisibility(author == null || (author.getId() > data.getMe().getId() ? 1 : (author.getId() == data.getMe().getId() ? 0 : -1)) != 0 ? 0 : 8);
        getBinding().n.setOnClickListener(new AnonymousClass9(data));
        TextView textView12 = getBinding().p;
        m.checkNotNullExpressionValue(textView12, "binding.dialogChatActionsShare");
        textView12.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().p.setOnClickListener(new AnonymousClass10(data, id2));
        TextView textView13 = getBinding().i;
        m.checkNotNullExpressionValue(textView13, "binding.dialogChatActionsPin");
        textView13.setVisibility(data.getManageMessageContext().getCanTogglePinned() ? 0 : 8);
        getBinding().i.setText(m.areEqual(data.getMessage().getPinned(), Boolean.TRUE) ? R.string.unpin : R.string.pin);
        getBinding().i.setOnClickListener(new AnonymousClass11(data));
        TextView textView14 = getBinding().e;
        m.checkNotNullExpressionValue(textView14, "binding.dialogChatActionsDelete");
        textView14.setVisibility(data.getManageMessageContext().getCanDelete() ? 0 : 8);
        getBinding().e.setOnClickListener(new AnonymousClass12(data));
        getBinding().j.setOnClickListener(new AnonymousClass13(data));
        boolean z4 = (data.getChannel() == null || !ChannelUtils.B(data.getChannel()) || ChannelUtils.E(data.getChannel())) ? false : true;
        boolean z5 = data.getMessage().isUserMessage() || data.getMessage().isApplicationMessage();
        if (zIsLocal || data.getType() != 0 || !z5 || (!z4 && !PermissionUtils.can(67584L, data.getPermissions()))) {
            z2 = false;
        }
        TextView textView15 = getBinding().m;
        m.checkNotNullExpressionValue(textView15, "binding.dialogChatActionsReply");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().m.setOnClickListener(new AnonymousClass14(data));
        TextView textView16 = getBinding().q;
        m.checkNotNullExpressionValue(textView16, "binding.dialogChatActionsStartThread");
        textView16.setVisibility(ThreadUtils.INSTANCE.canCreatePublicThread(data.getPermissions(), data.getChannel(), data.getMessage(), data.getGuild()) ? 0 : 8);
        getBinding().q.setOnClickListener(new AnonymousClass15(id2, data));
    }

    @MainThread
    private final void confirmPublishMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        messageActionDialogs.showPublishMessageConfirmation(parentFragmentManager, message, new AnonymousClass1(this));
    }

    @MainThread
    private final void deleteMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showDeleteMessageConfirmation(parentFragmentManager, contextRequireContext, message, new AnonymousClass1(this));
    }

    private final void editMessage(Message message) {
        Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().Y(new AnonymousClass1(message));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationBuffered(observableY), 0L, false, 3, null), (Context) null, "editMessage", (Function1) null, new AnonymousClass2(message), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final WidgetChatListActionsBinding getBinding() {
        return (WidgetChatListActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void removeAllReactions(Model model) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(R.string.remove_all_reactions_confirm_title);
        String string2 = getString(R.string.remove_all_reactions_confirm_body);
        m.checkNotNullExpressionValue(string2, "getString(R.string.remov…l_reactions_confirm_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, getString(R.string.yes_text), getString(R.string.no_text), g0.mapOf(d0.o.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(model))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    private final void replyMessage(Message message, Channel channel) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        boolean zB = ChannelUtils.B(channel);
        boolean zIsWebhook = message.isWebhook();
        User author = message.getAuthor();
        boolean z2 = author != null && author.getId() == id2;
        companion.getPendingReplies().onCreatePendingReply(channel, message, (zIsWebhook || z2) ? false : true, (zB || zIsWebhook || z2) ? false : true);
    }

    public static final void showForChat(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        INSTANCE.showForChat(fragmentManager, j, j2, charSequence);
    }

    public static final void showForPin(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        INSTANCE.showForPin(fragmentManager, j, j2, charSequence);
    }

    @MainThread
    private final void toggleMessagePin(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showPinMessageConfirmation(parentFragmentManager, contextRequireContext, message, this, new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_chat_list_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Observable observableR = ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.channelId, this.messageId, getArgumentsOrDefault().getCharSequence(INTENT_EXTRA_MESSAGE_CONTENT), getArgumentsOrDefault().getInt(INTENT_EXTRA_TYPE))).r();
        m.checkNotNullExpressionValue(observableR, "Model.get(channelId, mes…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetChatListActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_CHANNEL_ID);
        this.messageId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_ID);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = (WidgetChatListActionsEmojisAdapter) companion.configure(new WidgetChatListActionsEmojisAdapter(recyclerView));
        this.adapter = widgetChatListActionsEmojisAdapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setOnClickEmoji(new AnonymousClass1());
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter2 = this.adapter;
        if (widgetChatListActionsEmojisAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter2.setOnClickMoreEmojis(new AnonymousClass2());
        RecyclerView recyclerView2 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter3 = this.adapter;
        if (widgetChatListActionsEmojisAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(widgetChatListActionsEmojisAdapter3);
        getBinding().f2307b.setHasFixedSize(true);
    }
}
