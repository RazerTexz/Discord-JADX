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
import com.discord.C5419R;
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
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts2;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.textprocessing.MessageUnparser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.mobile_reports.ReportsFeatureFlag;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolation;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: WidgetChatListActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChatListActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListActionsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(messageContent, "messageContent");
            WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
            Bundle bundleM832T = outline.m832T(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CHANNEL_ID, channelId);
            bundleM832T.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_ID, messageId);
            bundleM832T.putCharSequence(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CONTENT, messageContent);
            bundleM832T.putInt(WidgetChatListActions.INTENT_EXTRA_TYPE, 0);
            widgetChatListActions.setArguments(bundleM832T);
            widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
        }

        public final void showForPin(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(messageContent, "messageContent");
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
        private final PermissionsContexts2 manageMessageContext;
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
                PermissionsContexts2 permissionsContexts2From = PermissionsContexts2.INSTANCE.from(message, permissions, meUser, guild != null ? Integer.valueOf(guild.getMfaLevel()) : null, channel != null && ChannelUtils.m7667B(channel), channel != null && ChannelUtils.m7670E(channel), (channel == null || (threadMetadata = channel.getThreadMetadata()) == null || !threadMetadata.getArchived()) ? false : true);
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
                Intrinsics3.checkNotNullExpressionValue(list, "emojis.recentEmojis");
                return new Model(message, guild, str, messageContent, permissionsContexts2From, type, isDeveloperMode, list, channel, permissions, meUser);
            }

            public final Observable<Model> get(long channelId, long messageId, CharSequence messageContent, int type) {
                Observable<Model> observableM11099Y = Observable.m11076j(type != 0 ? type != 1 ? new ScalarSynchronousObservable<>(null) : StoreStream.INSTANCE.getPinnedMessages().observePinnedMessage(channelId, messageId) : StoreStream.INSTANCE.getMessages().observeMessagesForChannel(channelId, messageId), StoreStream.INSTANCE.getChannels().observeChannel(channelId), WidgetChatListActions2.INSTANCE).m11099Y(new WidgetChatListActions3(channelId, messageContent, type));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "Observable\n            .…          }\n            }");
                return observableM11099Y;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Message message, Guild guild, String str, CharSequence charSequence, PermissionsContexts2 permissionsContexts2, int i, boolean z2, List<? extends Emoji> list, Channel channel, Long l, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(str, "messageAuthorName");
            Intrinsics3.checkNotNullParameter(permissionsContexts2, "manageMessageContext");
            Intrinsics3.checkNotNullParameter(list, "recentEmojis");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.message = message;
            this.guild = guild;
            this.messageAuthorName = str;
            this.messageContent = charSequence;
            this.manageMessageContext = permissionsContexts2;
            this.type = i;
            this.isDeveloper = z2;
            this.recentEmojis = list;
            this.channel = channel;
            this.permissions = l;
            this.me = meUser;
        }

        public static /* synthetic */ Model copy$default(Model model, Message message, Guild guild, String str, CharSequence charSequence, PermissionsContexts2 permissionsContexts2, int i, boolean z2, List list, Channel channel, Long l, MeUser meUser, int i2, Object obj) {
            return model.copy((i2 & 1) != 0 ? model.message : message, (i2 & 2) != 0 ? model.guild : guild, (i2 & 4) != 0 ? model.messageAuthorName : str, (i2 & 8) != 0 ? model.messageContent : charSequence, (i2 & 16) != 0 ? model.manageMessageContext : permissionsContexts2, (i2 & 32) != 0 ? model.type : i, (i2 & 64) != 0 ? model.isDeveloper : z2, (i2 & 128) != 0 ? model.recentEmojis : list, (i2 & 256) != 0 ? model.channel : channel, (i2 & 512) != 0 ? model.permissions : l, (i2 & 1024) != 0 ? model.me : meUser);
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
        public final PermissionsContexts2 getManageMessageContext() {
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

        public final Model copy(Message message, Guild guild, String messageAuthorName, CharSequence messageContent, PermissionsContexts2 manageMessageContext, int type, boolean isDeveloper, List<? extends Emoji> recentEmojis, Channel channel, Long permissions, MeUser me2) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(messageAuthorName, "messageAuthorName");
            Intrinsics3.checkNotNullParameter(manageMessageContext, "manageMessageContext");
            Intrinsics3.checkNotNullParameter(recentEmojis, "recentEmojis");
            Intrinsics3.checkNotNullParameter(me2, "me");
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
            return Intrinsics3.areEqual(this.message, model.message) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.messageAuthorName, model.messageAuthorName) && Intrinsics3.areEqual(this.messageContent, model.messageContent) && Intrinsics3.areEqual(this.manageMessageContext, model.manageMessageContext) && this.type == model.type && this.isDeveloper == model.isDeveloper && Intrinsics3.areEqual(this.recentEmojis, model.recentEmojis) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.permissions, model.permissions) && Intrinsics3.areEqual(this.me, model.me);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final PermissionsContexts2 getManageMessageContext() {
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
            PermissionsContexts2 permissionsContexts2 = this.manageMessageContext;
            int iHashCode5 = (((iHashCode4 + (permissionsContexts2 != null ? permissionsContexts2.hashCode() : 0)) * 31) + this.type) * 31;
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
            StringBuilder sbM833U = outline.m833U("Model(message=");
            sbM833U.append(this.message);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", messageAuthorName=");
            sbM833U.append(this.messageAuthorName);
            sbM833U.append(", messageContent=");
            sbM833U.append(this.messageContent);
            sbM833U.append(", manageMessageContext=");
            sbM833U.append(this.manageMessageContext);
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(", isDeveloper=");
            sbM833U.append(this.isDeveloper);
            sbM833U.append(", recentEmojis=");
            sbM833U.append(this.recentEmojis);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$addReaction$1 */
    public static final class C79631 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Emoji $emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79631(Emoji emoji) {
            super(1);
            this.$emoji = emoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getEmojis().onEmojiUsed(this.$emoji);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$1 */
    public static final class ViewOnClickListenerC79641 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79641(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$editMessage(WidgetChatListActions.this, this.$data.getMessage());
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$10 */
    public static final class ViewOnClickListenerC796510 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC796510(Model model, long j) {
            this.$data = model;
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.this.requireContext().startActivity(Intent.createChooser(IntentUtils.INSTANCE.toExternalizedSend(IntentUtils.RouteBuilders.selectChannel(this.$data.getMessage().getChannelId(), this.$guildId, Long.valueOf(this.$data.getMessage().getId()))), WidgetChatListActions.this.getString(C5419R.string.share_to)));
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$11 */
    public static final class ViewOnClickListenerC796611 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC796611(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$toggleMessagePin(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$12 */
    public static final class ViewOnClickListenerC796712 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC796712(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$deleteMessage(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$13 */
    public static final class ViewOnClickListenerC796813 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC796813(Model model) {
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
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
            }
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$14 */
    public static final class ViewOnClickListenerC796914 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC796914(Model model) {
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
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$15 */
    public static final class ViewOnClickListenerC797015 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC797015(long j, Model model) {
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
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$2 */
    public static final class ViewOnClickListenerC79712 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79712(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$confirmPublishMessage(WidgetChatListActions.this, this.$data.getMessage());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$3 */
    public static final class ViewOnClickListenerC79723 implements View.OnClickListener {
        public ViewOnClickListenerC79723() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetManageReactions.Companion companion = WidgetManageReactions.INSTANCE;
            long jAccess$getChannelId$p = WidgetChatListActions.access$getChannelId$p(WidgetChatListActions.this);
            long jAccess$getMessageId$p = WidgetChatListActions.access$getMessageId$p(WidgetChatListActions.this);
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetManageReactions.Companion.create$default(companion, jAccess$getChannelId$p, jAccess$getMessageId$p, contextRequireContext, null, 8, null);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$4 */
    public static final class ViewOnClickListenerC79734 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79734(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActions.access$removeAllReactions(WidgetChatListActions.this, this.$data);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$5 */
    public static final class ViewOnClickListenerC79745 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<MessageQueue4, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
                invoke2(messageQueue4);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageQueue4 messageQueue4) {
                Intrinsics3.checkNotNullParameter(messageQueue4, "messageResult");
                if (messageQueue4 instanceof MessageQueue4.CaptchaRequired) {
                    SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageQueue4);
                }
            }
        }

        public ViewOnClickListenerC79745(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer type = this.$data.getMessage().getType();
            if (type != null && type.intValue() == -4) {
                StoreStream.INSTANCE.getInteractions().resendApplicationCommand(this.$data.getMessage());
            } else {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(StoreMessages.resendMessage$default(StoreStream.INSTANCE.getMessages(), this.$data.getMessage(), false, null, 6, null)), WidgetChatListActions.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
            }
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$6 */
    public static final class ViewOnClickListenerC79756 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79756(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessageAck().markUnread(this.$data.getMessage().getChannelId(), this.$data.getMessage().getId());
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$7 */
    public static final class ViewOnClickListenerC79767 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79767(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String string = this.$data.getMessageContent().toString();
            EditedMessageNode.Companion companion = EditedMessageNode.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            AppToast.m165c(contextRequireContext, StringsJVM.replace$default(string, companion.getEditedString(context), "", false, 4, (Object) null), 0, 4);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$8 */
    public static final class ViewOnClickListenerC79778 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79778(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetChatListActions.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            AppToast.m165c(contextRequireContext, String.valueOf(this.$data.getMessage().getId()), 0, 4);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$9 */
    public static final class ViewOnClickListenerC79789 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC79789(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ReportsFeatureFlag.INSTANCE.isEnabled()) {
                WidgetMobileReports.INSTANCE.launchMessageReport(outline.m885x(view, "view", "view.context"), this.$data.getMessage().getId(), WidgetChatListActions.access$getChannelId$p(WidgetChatListActions.this));
            } else {
                WidgetTosReportViolation.INSTANCE.show(outline.m885x(view, "view", "view.context"), this.$data.getMessageAuthorName(), Long.valueOf(this.$data.getMessage().getChannelId()), Long.valueOf(this.$data.getMessage().getId()));
            }
            WidgetChatListActions.this.dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$confirmPublishMessage$1 */
    public static final /* synthetic */ class C79791 extends FunctionReferenceImpl implements Function0<Unit> {
        public C79791(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$deleteMessage$1 */
    public static final /* synthetic */ class C79801 extends FunctionReferenceImpl implements Function0<Unit> {
        public C79801(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$1 */
    public static final class C79811<T, R> implements Func1<Map<Long, ? extends Channel>, Observable<? extends CharSequence>> {
        public final /* synthetic */ Message $message;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends com.discord.models.user.User>, Map<Long, ? extends Guild>, EmojiSet, CharSequence> {
            public final /* synthetic */ Map $channels;
            public final /* synthetic */ long $guildId;

            public AnonymousClass1(long j, Map map) {
                this.$guildId = j;
                this.$channels = map;
            }

            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ CharSequence call(Map<Long, ? extends com.discord.models.user.User> map, Map<Long, ? extends Guild> map2, EmojiSet emojiSet) {
                return call2(map, (Map<Long, Guild>) map2, emojiSet);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final CharSequence call2(Map<Long, ? extends com.discord.models.user.User> map, Map<Long, Guild> map2, EmojiSet emojiSet) {
                String content = C79811.this.$message.getContent();
                if (content == null) {
                    content = "";
                }
                Guild guild = map2.get(Long.valueOf(this.$guildId));
                Map map3 = this.$channels;
                Intrinsics3.checkNotNullExpressionValue(map3, "channels");
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
                return MessageUnparser.unparse(content, guild, map3, map, emojiSet);
            }
        }

        public C79811(Message message) {
            this.$message = message;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends CharSequence> call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends CharSequence> call2(Map<Long, Channel> map) {
            Channel channel = map.get(Long.valueOf(this.$message.getChannelId()));
            long guildId = channel != null ? channel.getGuildId() : 0L;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.m11075i(companion.getUsers().observeAllUsers(), companion.getGuilds().observeGuilds(), StoreEmoji.getEmojiSet$default(companion.getEmojis(), guildId, this.$message.getChannelId(), false, false, 12, null), new AnonymousClass1(guildId, map));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$2 */
    public static final class C79822 extends Lambda implements Function1<CharSequence, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79822(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            StoreChat chat = StoreStream.INSTANCE.getChat();
            Message message = this.$message;
            Intrinsics3.checkNotNullExpressionValue(charSequence, "unparsedMessageContent");
            chat.setEditingMessage(new StoreChat.EditingMessage(message, charSequence));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onResume$1 */
    public static final class C79831 extends Lambda implements Function1<Model, Unit> {
        public C79831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetChatListActions.access$configureUI(WidgetChatListActions.this, model);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$1 */
    public static final class C79841 extends Lambda implements Function1<Emoji, Unit> {
        public C79841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
            invoke2(emoji);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Emoji emoji) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            WidgetChatListActions.access$addReaction(WidgetChatListActions.this, emoji);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2 */
    public static final class C79852 extends Lambda implements Function0<Unit> {

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements EmojiPickerListener {
            public AnonymousClass1() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                WidgetChatListActions.access$addReaction(WidgetChatListActions.this, emoji);
            }
        }

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChatListActions.this.dismiss();
            }
        }

        public C79852() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetChatListActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new AnonymousClass1(), EmojiPickerContextType.Chat.INSTANCE, new AnonymousClass2());
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1 */
    public static final class C79861 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetChatListActions.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetChatListActions.this.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79861(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeAllReactions(this.$model.getMessage().getChannelId(), this.$model.getMessage().getId()), false, 1, null), WidgetChatListActions.this, null, 2, null), view.getContext(), "REST: removeAllReactions", (Function1) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$toggleMessagePin$1 */
    public static final /* synthetic */ class C79871 extends FunctionReferenceImpl implements Function0<Unit> {
        public C79871(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    public WidgetChatListActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChatListActions4.INSTANCE, null, 2, null);
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
        Intrinsics3.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(j, j2, reactionKey), false, 1, null), this, null, 2, null), getContext(), "REST: addReaction", (Function1) null, new C79631(emoji), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureAddReactionEmojisList(List<? extends Emoji> recentEmojis, boolean isLocalMessage, boolean canAddReactions) throws Resources.NotFoundException {
        if (recentEmojis.isEmpty() || isLocalMessage || !canAddReactions) {
            RecyclerView recyclerView = getBinding().f16122b;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        recyclerView2.setVisibility(0);
        RecyclerView recyclerView3 = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.dialogChatActionsAddReactionEmojisList");
        int width = recyclerView3.getWidth();
        RecyclerView recyclerView4 = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingStart = recyclerView4.getPaddingStart();
        RecyclerView recyclerView5 = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView5, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingEnd = recyclerView5.getPaddingEnd() + paddingStart;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C5419R.dimen.chat_input_emoji_size);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = width - paddingEnd;
        int iMin = Math.min(recentEmojis.size() + 1, (i + iDpToPixels) / (dimensionPixelSize + iDpToPixels));
        int i2 = iMin - 1;
        int iMax = Math.max(i - ((i2 * iDpToPixels) + (dimensionPixelSize * iMin)), 0);
        PaddedItemDecorator paddedItemDecorator = this.itemDecorator;
        if (paddedItemDecorator != null) {
            getBinding().f16122b.removeItemDecoration(paddedItemDecorator);
        }
        PaddedItemDecorator paddedItemDecorator2 = new PaddedItemDecorator(0, (iMax / i2) + iDpToPixels, 0, true);
        getBinding().f16122b.addItemDecoration(paddedItemDecorator2);
        this.itemDecorator = paddedItemDecorator2;
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = this.adapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
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
            TextView textView = getBinding().f16126f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogChatActionsEdit");
            textView.setVisibility(data.getManageMessageContext().getCanEdit() ? 0 : 8);
            getBinding().f16126f.setOnClickListener(new ViewOnClickListenerC79641(data));
        } else if (type2 == 1) {
            TextView textView2 = getBinding().f16126f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.dialogChatActionsEdit");
            textView2.setVisibility(8);
        }
        TextView textView3 = getBinding().f16131k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.dialogChatActionsPublish");
        textView3.setVisibility(z3 && (channel = data.getChannel()) != null && channel.getType() == 5 && (type = data.getMessage().getType()) != null && type.intValue() == 0 && !zIsCrossposted ? 0 : 8);
        getBinding().f16131k.setOnClickListener(new ViewOnClickListenerC79712(data));
        TextView textView4 = getBinding().f16127g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.dialogChatActionsManageReactions");
        textView4.setVisibility(data.getMessage().getReactionsMap().isEmpty() ^ true ? 0 : 8);
        getBinding().f16127g.setOnClickListener(new ViewOnClickListenerC79723());
        TextView textView5 = getBinding().f16132l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.dialogChatActionsRemoveAllReactions");
        textView5.setVisibility((data.getMessage().getReactionsMap().isEmpty() ^ true) && data.getManageMessageContext().getCanManageMessages() ? 0 : 8);
        getBinding().f16132l.setOnClickListener(new ViewOnClickListenerC79734(data));
        TextView textView6 = getBinding().f16135o;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.dialogChatActionsResend");
        textView6.setVisibility(data.getMessage().canResend() ? 0 : 8);
        getBinding().f16135o.setOnClickListener(new ViewOnClickListenerC79745(data));
        TextView textView7 = getBinding().f16128h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.dialogChatActionsMarkUnread");
        textView7.setVisibility(!data.getMessage().isFailed() && data.getManageMessageContext().getCanMarkUnread() ? 0 : 8);
        getBinding().f16128h.setOnClickListener(new ViewOnClickListenerC79756(data));
        if (data.getMessageContent() == null) {
            TextView textView8 = getBinding().f16123c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.dialogChatActionsCopy");
            textView8.setVisibility(8);
        } else {
            if ((data.getMessageContent().length() > 0) && !data.getMessage().isLocalApplicationCommand()) {
                TextView textView9 = getBinding().f16123c;
                Intrinsics3.checkNotNullExpressionValue(textView9, "binding.dialogChatActionsCopy");
                textView9.setVisibility(0);
                getBinding().f16123c.setOnClickListener(new ViewOnClickListenerC79767(data));
            }
        }
        TextView textView10 = getBinding().f16124d;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.dialogChatActionsCopyId");
        textView10.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().f16124d.setOnClickListener(new ViewOnClickListenerC79778(data));
        TextView textView11 = getBinding().f16134n;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.dialogChatActionsReport");
        User author = data.getMessage().getAuthor();
        textView11.setVisibility(author == null || (author.getId() > data.getMe().getId() ? 1 : (author.getId() == data.getMe().getId() ? 0 : -1)) != 0 ? 0 : 8);
        getBinding().f16134n.setOnClickListener(new ViewOnClickListenerC79789(data));
        TextView textView12 = getBinding().f16136p;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.dialogChatActionsShare");
        textView12.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().f16136p.setOnClickListener(new ViewOnClickListenerC796510(data, id2));
        TextView textView13 = getBinding().f16129i;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.dialogChatActionsPin");
        textView13.setVisibility(data.getManageMessageContext().getCanTogglePinned() ? 0 : 8);
        getBinding().f16129i.setText(Intrinsics3.areEqual(data.getMessage().getPinned(), Boolean.TRUE) ? C5419R.string.unpin : C5419R.string.pin);
        getBinding().f16129i.setOnClickListener(new ViewOnClickListenerC796611(data));
        TextView textView14 = getBinding().f16125e;
        Intrinsics3.checkNotNullExpressionValue(textView14, "binding.dialogChatActionsDelete");
        textView14.setVisibility(data.getManageMessageContext().getCanDelete() ? 0 : 8);
        getBinding().f16125e.setOnClickListener(new ViewOnClickListenerC796712(data));
        getBinding().f16130j.setOnClickListener(new ViewOnClickListenerC796813(data));
        boolean z4 = (data.getChannel() == null || !ChannelUtils.m7667B(data.getChannel()) || ChannelUtils.m7670E(data.getChannel())) ? false : true;
        boolean z5 = data.getMessage().isUserMessage() || data.getMessage().isApplicationMessage();
        if (zIsLocal || data.getType() != 0 || !z5 || (!z4 && !PermissionUtils.can(67584L, data.getPermissions()))) {
            z2 = false;
        }
        TextView textView15 = getBinding().f16133m;
        Intrinsics3.checkNotNullExpressionValue(textView15, "binding.dialogChatActionsReply");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f16133m.setOnClickListener(new ViewOnClickListenerC796914(data));
        TextView textView16 = getBinding().f16137q;
        Intrinsics3.checkNotNullExpressionValue(textView16, "binding.dialogChatActionsStartThread");
        textView16.setVisibility(ThreadUtils.INSTANCE.canCreatePublicThread(data.getPermissions(), data.getChannel(), data.getMessage(), data.getGuild()) ? 0 : 8);
        getBinding().f16137q.setOnClickListener(new ViewOnClickListenerC797015(id2, data));
    }

    @MainThread
    private final void confirmPublishMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        messageActionDialogs.showPublishMessageConfirmation(parentFragmentManager, message, new C79791(this));
    }

    @MainThread
    private final void deleteMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showDeleteMessageConfirmation(parentFragmentManager, contextRequireContext, message, new C79801(this));
    }

    private final void editMessage(Message message) {
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().m11099Y(new C79811(message));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationBuffered(observableM11099Y), 0L, false, 3, null), (Context) null, "editMessage", (Function1) null, new C79822(message), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final WidgetChatListActionsBinding getBinding() {
        return (WidgetChatListActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void removeAllReactions(Model model) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(C5419R.string.remove_all_reactions_confirm_title);
        String string2 = getString(C5419R.string.remove_all_reactions_confirm_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.remov…l_reactions_confirm_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, getString(C5419R.string.yes_text), getString(C5419R.string.no_text), MapsJVM.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C79861(model))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    private final void replyMessage(Message message, Channel channel) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        boolean zM7667B = ChannelUtils.m7667B(channel);
        boolean zIsWebhook = message.isWebhook();
        User author = message.getAuthor();
        boolean z2 = author != null && author.getId() == id2;
        companion.getPendingReplies().onCreatePendingReply(channel, message, (zIsWebhook || z2) ? false : true, (zM7667B || zIsWebhook || z2) ? false : true);
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
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showPinMessageConfirmation(parentFragmentManager, contextRequireContext, message, this, new C79871(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_chat_list_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.channelId, this.messageId, getArgumentsOrDefault().getCharSequence(INTENT_EXTRA_MESSAGE_CONTENT), getArgumentsOrDefault().getInt(INTENT_EXTRA_TYPE))).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Model.get(channelId, mes…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), WidgetChatListActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C79831(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_CHANNEL_ID);
        this.messageId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_ID);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = (WidgetChatListActionsEmojisAdapter) companion.configure(new WidgetChatListActionsEmojisAdapter(recyclerView));
        this.adapter = widgetChatListActionsEmojisAdapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setOnClickEmoji(new C79841());
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter2 = this.adapter;
        if (widgetChatListActionsEmojisAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter2.setOnClickMoreEmojis(new C79852());
        RecyclerView recyclerView2 = getBinding().f16122b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter3 = this.adapter;
        if (widgetChatListActionsEmojisAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(widgetChatListActionsEmojisAdapter3);
        getBinding().f16122b.setHasFixedSize(true);
    }
}
