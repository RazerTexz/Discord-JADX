package com.discord.widgets.chat.input;

import a0.a.a.b;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.message.MessageReference;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreApplicationCommandFrecency;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandDataKt;
import com.discord.widgets.forums.ForumPostCreateManager;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.lytefast.flexinput.model.Attachment;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final boolean isEmojiAutocompleteUpsellEnabled;
    private final StoreAnalytics storeAnalytics;
    private final StoreApplicationCommands storeApplicationCommands;
    private final StoreApplicationCommandFrecency storeApplicationCommandsFrecency;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannels storeChannels;
    private final StoreChat storeChat;
    private final StoreGuilds storeGuilds;
    private final StoreLurking storeLurking;
    private final StoreMessagesLoader storeMessagesLoader;
    private final StorePendingReplies storePendingReplies;
    private final StoreStickers storeStickers;
    private final StoreThreadDraft storeThreadDraft;
    private final StoreUserSettings storeUserSettings;
    private boolean useTimeoutUpdateInterval;

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass1(ChatInputViewModel chatInputViewModel) {
            super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            ChatInputViewModel.access$handleStoreState((ChatInputViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<StoreChat.Event, Unit> {
        public AnonymousClass2(ChatInputViewModel chatInputViewModel) {
            super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreChatEvent", "handleStoreChatEvent(Lcom/discord/stores/StoreChat$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.Event event) {
            m.checkNotNullParameter(event, "p1");
            ChatInputViewModel.access$handleStoreChatEvent((ChatInputViewModel) this.receiver, event);
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    public static final /* data */ class AttachmentContext {
        private final List<Float> attachmentSizes;
        private final ArrayList<Attachment<?>> attachments;
        private final float currentFileSizeMB;
        private final boolean hasGif;
        private final boolean hasImage;
        private final boolean hasVideo;
        private final float maxAttachmentSizeMB;

        public AttachmentContext(ArrayList<Attachment<?>> arrayList, boolean z2, boolean z3, boolean z4, List<Float> list, float f, float f2) {
            m.checkNotNullParameter(arrayList, "attachments");
            m.checkNotNullParameter(list, "attachmentSizes");
            this.attachments = arrayList;
            this.hasImage = z2;
            this.hasVideo = z3;
            this.hasGif = z4;
            this.attachmentSizes = list;
            this.currentFileSizeMB = f;
            this.maxAttachmentSizeMB = f2;
        }

        public static /* synthetic */ AttachmentContext copy$default(AttachmentContext attachmentContext, ArrayList arrayList, boolean z2, boolean z3, boolean z4, List list, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = attachmentContext.attachments;
            }
            if ((i & 2) != 0) {
                z2 = attachmentContext.hasImage;
            }
            boolean z5 = z2;
            if ((i & 4) != 0) {
                z3 = attachmentContext.hasVideo;
            }
            boolean z6 = z3;
            if ((i & 8) != 0) {
                z4 = attachmentContext.hasGif;
            }
            boolean z7 = z4;
            if ((i & 16) != 0) {
                list = attachmentContext.attachmentSizes;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                f = attachmentContext.currentFileSizeMB;
            }
            float f3 = f;
            if ((i & 64) != 0) {
                f2 = attachmentContext.maxAttachmentSizeMB;
            }
            return attachmentContext.copy(arrayList, z5, z6, z7, list2, f3, f2);
        }

        public final ArrayList<Attachment<?>> component1() {
            return this.attachments;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasImage() {
            return this.hasImage;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHasVideo() {
            return this.hasVideo;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasGif() {
            return this.hasGif;
        }

        public final List<Float> component5() {
            return this.attachmentSizes;
        }

        /* renamed from: component6, reason: from getter */
        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        /* renamed from: component7, reason: from getter */
        public final float getMaxAttachmentSizeMB() {
            return this.maxAttachmentSizeMB;
        }

        public final AttachmentContext copy(ArrayList<Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, List<Float> attachmentSizes, float currentFileSizeMB, float maxAttachmentSizeMB) {
            m.checkNotNullParameter(attachments, "attachments");
            m.checkNotNullParameter(attachmentSizes, "attachmentSizes");
            return new AttachmentContext(attachments, hasImage, hasVideo, hasGif, attachmentSizes, currentFileSizeMB, maxAttachmentSizeMB);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttachmentContext)) {
                return false;
            }
            AttachmentContext attachmentContext = (AttachmentContext) other;
            return m.areEqual(this.attachments, attachmentContext.attachments) && this.hasImage == attachmentContext.hasImage && this.hasVideo == attachmentContext.hasVideo && this.hasGif == attachmentContext.hasGif && m.areEqual(this.attachmentSizes, attachmentContext.attachmentSizes) && Float.compare(this.currentFileSizeMB, attachmentContext.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, attachmentContext.maxAttachmentSizeMB) == 0;
        }

        public final List<Float> getAttachmentSizes() {
            return this.attachmentSizes;
        }

        public final ArrayList<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        public final boolean getHasGif() {
            return this.hasGif;
        }

        public final boolean getHasImage() {
            return this.hasImage;
        }

        public final boolean getHasVideo() {
            return this.hasVideo;
        }

        public final float getMaxAttachmentSizeMB() {
            return this.maxAttachmentSizeMB;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ArrayList<Attachment<?>> arrayList = this.attachments;
            int iHashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
            boolean z2 = this.hasImage;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.hasVideo;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.hasGif;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            List<Float> list = this.attachmentSizes;
            return Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + ((i5 + (list != null ? list.hashCode() : 0)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = a.U("AttachmentContext(attachments=");
            sbU.append(this.attachments);
            sbU.append(", hasImage=");
            sbU.append(this.hasImage);
            sbU.append(", hasVideo=");
            sbU.append(this.hasVideo);
            sbU.append(", hasGif=");
            sbU.append(this.hasGif);
            sbU.append(", attachmentSizes=");
            sbU.append(this.attachmentSizes);
            sbU.append(", currentFileSizeMB=");
            sbU.append(this.currentFileSizeMB);
            sbU.append(", maxAttachmentSizeMB=");
            sbU.append(this.maxAttachmentSizeMB);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getIsOnCooldownObservable(Companion companion, long j, StoreSlowMode storeSlowMode) {
            return companion.getIsOnCooldownObservable(j, storeSlowMode);
        }

        public static final /* synthetic */ Observable access$getPendingReplyStateObservable(Companion companion, long j, StorePendingReplies storePendingReplies) {
            return companion.getPendingReplyStateObservable(j, storePendingReplies);
        }

        public static final /* synthetic */ Observable access$getVerificationLevelTriggeredObservable(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser) {
            return companion.getVerificationLevelTriggeredObservable(j, storeGuilds, storeUser);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
            return companion.observeStoreState(storeChannelsSelected, storeUser, storeChat, storeUserRelationships, storePermissions, storeLurking, storeSlowMode, storeGuilds, storePendingReplies, storeGuildJoinRequest, storeThreadDraft);
        }

        private final Observable<Boolean> getIsOnCooldownObservable(long channelId, StoreSlowMode storeSlowMode) {
            return storeSlowMode.observeCooldownSecs(Long.valueOf(channelId), StoreSlowMode.Type.MessageSend.INSTANCE).G(ChatInputViewModel$Companion$getIsOnCooldownObservable$1.INSTANCE).r();
        }

        private final Observable<StoreState.Loaded.PendingReply> getPendingReplyStateObservable(long channelId, StorePendingReplies storePendingReplies) {
            Observable<StoreState.Loaded.PendingReply> observableR = storePendingReplies.observePendingReply(channelId).Y(ChatInputViewModel$Companion$getPendingReplyStateObservable$1.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "storePendingReplies\n    …  .distinctUntilChanged()");
            return observableR;
        }

        private final Observable<GuildVerificationLevel> getVerificationLevelTriggeredObservable(long guildId, StoreGuilds storeGuilds, StoreUser storeUsers) {
            return GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, guildId, storeGuilds, storeUsers, null, 8, null);
        }

        private final Observable<StoreState> observeStoreState(StoreChannelsSelected storeChannelsSelected, StoreUser storeUsers, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
            Observable observableY = storeChannelsSelected.observeResolvedSelectedChannel().Y(new ChatInputViewModel$Companion$observeStoreState$1(storeUsers, storeChat, storeUserRelationships, storePermissions, storeGuilds, storeLurking, storeSlowMode, storePendingReplies, storeGuildJoinRequest, storeThreadDraft));
            m.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…      }\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    public static abstract class Event {

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class AppendChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppendChatText(String str) {
                super(null);
                m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ AppendChatText copy$default(AppendChatText appendChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = appendChatText.text;
                }
                return appendChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final AppendChatText copy(String text) {
                m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new AppendChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AppendChatText) && m.areEqual(this.text, ((AppendChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.J(a.U("AppendChatText(text="), this.text, ")");
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class CommandInputsInvalid extends Event {
            public static final CommandInputsInvalid INSTANCE = new CommandInputsInvalid();

            private CommandInputsInvalid() {
                super(null);
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class EmptyThreadName extends Event {
            public static final EmptyThreadName INSTANCE = new EmptyThreadName();

            private EmptyThreadName() {
                super(null);
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class FailedDeliveryToRecipient extends Event {
            public static final FailedDeliveryToRecipient INSTANCE = new FailedDeliveryToRecipient();

            private FailedDeliveryToRecipient() {
                super(null);
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class FilesTooLarge extends Event {
            private final List<Attachment<?>> attachments;
            private final float currentFileSizeMB;
            private final boolean hasGif;
            private final boolean hasImage;
            private final boolean hasVideo;
            private final boolean isUserPremium;
            private final float maxAttachmentSizeMB;
            private final int maxFileSizeMB;
            private final Function0<Unit> onResendCompressed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public FilesTooLarge(int i, float f, float f2, boolean z2, List<? extends Attachment<?>> list, boolean z3, boolean z4, boolean z5, Function0<Unit> function0) {
                super(null);
                m.checkNotNullParameter(list, "attachments");
                this.maxFileSizeMB = i;
                this.currentFileSizeMB = f;
                this.maxAttachmentSizeMB = f2;
                this.isUserPremium = z2;
                this.attachments = list;
                this.hasImage = z3;
                this.hasVideo = z4;
                this.hasGif = z5;
                this.onResendCompressed = function0;
            }

            public static /* synthetic */ FilesTooLarge copy$default(FilesTooLarge filesTooLarge, int i, float f, float f2, boolean z2, List list, boolean z3, boolean z4, boolean z5, Function0 function0, int i2, Object obj) {
                return filesTooLarge.copy((i2 & 1) != 0 ? filesTooLarge.maxFileSizeMB : i, (i2 & 2) != 0 ? filesTooLarge.currentFileSizeMB : f, (i2 & 4) != 0 ? filesTooLarge.maxAttachmentSizeMB : f2, (i2 & 8) != 0 ? filesTooLarge.isUserPremium : z2, (i2 & 16) != 0 ? filesTooLarge.attachments : list, (i2 & 32) != 0 ? filesTooLarge.hasImage : z3, (i2 & 64) != 0 ? filesTooLarge.hasVideo : z4, (i2 & 128) != 0 ? filesTooLarge.hasGif : z5, (i2 & 256) != 0 ? filesTooLarge.onResendCompressed : function0);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            /* renamed from: component2, reason: from getter */
            public final float getCurrentFileSizeMB() {
                return this.currentFileSizeMB;
            }

            /* renamed from: component3, reason: from getter */
            public final float getMaxAttachmentSizeMB() {
                return this.maxAttachmentSizeMB;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            public final List<Attachment<?>> component5() {
                return this.attachments;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getHasImage() {
                return this.hasImage;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getHasGif() {
                return this.hasGif;
            }

            public final Function0<Unit> component9() {
                return this.onResendCompressed;
            }

            public final FilesTooLarge copy(int maxFileSizeMB, float currentFileSizeMB, float maxAttachmentSizeMB, boolean isUserPremium, List<? extends Attachment<?>> attachments, boolean hasImage, boolean hasVideo, boolean hasGif, Function0<Unit> onResendCompressed) {
                m.checkNotNullParameter(attachments, "attachments");
                return new FilesTooLarge(maxFileSizeMB, currentFileSizeMB, maxAttachmentSizeMB, isUserPremium, attachments, hasImage, hasVideo, hasGif, onResendCompressed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilesTooLarge)) {
                    return false;
                }
                FilesTooLarge filesTooLarge = (FilesTooLarge) other;
                return this.maxFileSizeMB == filesTooLarge.maxFileSizeMB && Float.compare(this.currentFileSizeMB, filesTooLarge.currentFileSizeMB) == 0 && Float.compare(this.maxAttachmentSizeMB, filesTooLarge.maxAttachmentSizeMB) == 0 && this.isUserPremium == filesTooLarge.isUserPremium && m.areEqual(this.attachments, filesTooLarge.attachments) && this.hasImage == filesTooLarge.hasImage && this.hasVideo == filesTooLarge.hasVideo && this.hasGif == filesTooLarge.hasGif && m.areEqual(this.onResendCompressed, filesTooLarge.onResendCompressed);
            }

            public final List<Attachment<?>> getAttachments() {
                return this.attachments;
            }

            public final float getCurrentFileSizeMB() {
                return this.currentFileSizeMB;
            }

            public final boolean getHasGif() {
                return this.hasGif;
            }

            public final boolean getHasImage() {
                return this.hasImage;
            }

            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            public final float getMaxAttachmentSizeMB() {
                return this.maxAttachmentSizeMB;
            }

            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            public final Function0<Unit> getOnResendCompressed() {
                return this.onResendCompressed;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iFloatToIntBits = (Float.floatToIntBits(this.maxAttachmentSizeMB) + ((Float.floatToIntBits(this.currentFileSizeMB) + (this.maxFileSizeMB * 31)) * 31)) * 31;
                boolean z2 = this.isUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iFloatToIntBits + i) * 31;
                List<Attachment<?>> list = this.attachments;
                int iHashCode = (i2 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z3 = this.hasImage;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode + i3) * 31;
                boolean z4 = this.hasVideo;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.hasGif;
                int i7 = (i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31;
                Function0<Unit> function0 = this.onResendCompressed;
                return i7 + (function0 != null ? function0.hashCode() : 0);
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbU = a.U("FilesTooLarge(maxFileSizeMB=");
                sbU.append(this.maxFileSizeMB);
                sbU.append(", currentFileSizeMB=");
                sbU.append(this.currentFileSizeMB);
                sbU.append(", maxAttachmentSizeMB=");
                sbU.append(this.maxAttachmentSizeMB);
                sbU.append(", isUserPremium=");
                sbU.append(this.isUserPremium);
                sbU.append(", attachments=");
                sbU.append(this.attachments);
                sbU.append(", hasImage=");
                sbU.append(this.hasImage);
                sbU.append(", hasVideo=");
                sbU.append(this.hasVideo);
                sbU.append(", hasGif=");
                sbU.append(this.hasGif);
                sbU.append(", onResendCompressed=");
                sbU.append(this.onResendCompressed);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class MessageTooLong extends Event {
            private final int currentCharacterCount;
            private final int maxCharacterCount;

            public MessageTooLong(int i, int i2) {
                super(null);
                this.currentCharacterCount = i;
                this.maxCharacterCount = i2;
            }

            public static /* synthetic */ MessageTooLong copy$default(MessageTooLong messageTooLong, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = messageTooLong.currentCharacterCount;
                }
                if ((i3 & 2) != 0) {
                    i2 = messageTooLong.maxCharacterCount;
                }
                return messageTooLong.copy(i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCurrentCharacterCount() {
                return this.currentCharacterCount;
            }

            /* renamed from: component2, reason: from getter */
            public final int getMaxCharacterCount() {
                return this.maxCharacterCount;
            }

            public final MessageTooLong copy(int currentCharacterCount, int maxCharacterCount) {
                return new MessageTooLong(currentCharacterCount, maxCharacterCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MessageTooLong)) {
                    return false;
                }
                MessageTooLong messageTooLong = (MessageTooLong) other;
                return this.currentCharacterCount == messageTooLong.currentCharacterCount && this.maxCharacterCount == messageTooLong.maxCharacterCount;
            }

            public final int getCurrentCharacterCount() {
                return this.currentCharacterCount;
            }

            public final int getMaxCharacterCount() {
                return this.maxCharacterCount;
            }

            public int hashCode() {
                return (this.currentCharacterCount * 31) + this.maxCharacterCount;
            }

            public String toString() {
                StringBuilder sbU = a.U("MessageTooLong(currentCharacterCount=");
                sbU.append(this.currentCharacterCount);
                sbU.append(", maxCharacterCount=");
                return a.B(sbU, this.maxCharacterCount, ")");
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class SetChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetChatText(String str) {
                super(null);
                m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ SetChatText copy$default(SetChatText setChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setChatText.text;
                }
                return setChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final SetChatText copy(String text) {
                m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new SetChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetChatText) && m.areEqual(this.text, ((SetChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.J(a.U("SetChatText(text="), this.text, ")");
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class ShowPremiumUpsell extends Event {
            private final int bodyResId;
            private final int headerResId;
            private final int page;
            private final boolean showLearnMore;
            private final boolean showOtherPages;

            public /* synthetic */ ShowPremiumUpsell(int i, int i2, int i3, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, i3, (i4 & 8) != 0 ? false : z2, (i4 & 16) != 0 ? false : z3);
            }

            public static /* synthetic */ ShowPremiumUpsell copy$default(ShowPremiumUpsell showPremiumUpsell, int i, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = showPremiumUpsell.page;
                }
                if ((i4 & 2) != 0) {
                    i2 = showPremiumUpsell.headerResId;
                }
                int i5 = i2;
                if ((i4 & 4) != 0) {
                    i3 = showPremiumUpsell.bodyResId;
                }
                int i6 = i3;
                if ((i4 & 8) != 0) {
                    z2 = showPremiumUpsell.showOtherPages;
                }
                boolean z4 = z2;
                if ((i4 & 16) != 0) {
                    z3 = showPremiumUpsell.showLearnMore;
                }
                return showPremiumUpsell.copy(i, i5, i6, z4, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getPage() {
                return this.page;
            }

            /* renamed from: component2, reason: from getter */
            public final int getHeaderResId() {
                return this.headerResId;
            }

            /* renamed from: component3, reason: from getter */
            public final int getBodyResId() {
                return this.bodyResId;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final ShowPremiumUpsell copy(int page, @StringRes int headerResId, @StringRes int bodyResId, boolean showOtherPages, boolean showLearnMore) {
                return new ShowPremiumUpsell(page, headerResId, bodyResId, showOtherPages, showLearnMore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowPremiumUpsell)) {
                    return false;
                }
                ShowPremiumUpsell showPremiumUpsell = (ShowPremiumUpsell) other;
                return this.page == showPremiumUpsell.page && this.headerResId == showPremiumUpsell.headerResId && this.bodyResId == showPremiumUpsell.bodyResId && this.showOtherPages == showPremiumUpsell.showOtherPages && this.showLearnMore == showPremiumUpsell.showLearnMore;
            }

            public final int getBodyResId() {
                return this.bodyResId;
            }

            public final int getHeaderResId() {
                return this.headerResId;
            }

            public final int getPage() {
                return this.page;
            }

            public final boolean getShowLearnMore() {
                return this.showLearnMore;
            }

            public final boolean getShowOtherPages() {
                return this.showOtherPages;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = ((((this.page * 31) + this.headerResId) * 31) + this.bodyResId) * 31;
                boolean z2 = this.showOtherPages;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                boolean z3 = this.showLearnMore;
                return i3 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("ShowPremiumUpsell(page=");
                sbU.append(this.page);
                sbU.append(", headerResId=");
                sbU.append(this.headerResId);
                sbU.append(", bodyResId=");
                sbU.append(this.bodyResId);
                sbU.append(", showOtherPages=");
                sbU.append(this.showOtherPages);
                sbU.append(", showLearnMore=");
                return a.O(sbU, this.showLearnMore, ")");
            }

            public ShowPremiumUpsell(int i, @StringRes int i2, @StringRes int i3, boolean z2, boolean z3) {
                super(null);
                this.page = i;
                this.headerResId = i2;
                this.bodyResId = i3;
                this.showOtherPages = z2;
                this.showLearnMore = z3;
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class ThreadDraftClosed extends Event {
            public static final ThreadDraftClosed INSTANCE = new ThreadDraftClosed();

            private ThreadDraftClosed() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final Channel channel;
            private final Long channelPermissions;
            private final StoreChat.EditingMessage editingMessage;
            private final Guild guild;
            private final GuildJoinRequest guildJoinRequest;
            private final boolean isForumPostCreateInProgress;
            private final boolean isLurking;
            private final boolean isOnCooldown;
            private final MeUser me;
            private final GuildMember meGuildMember;
            private final PendingReply pendingReply;
            private final Integer relationshipType;
            private final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft;
            private final StoreThreadDraft.ThreadDraftState threadDraftState;
            private final GuildVerificationLevel verificationLevelTriggered;

            /* compiled from: ChatInputViewModel.kt */
            public static final /* data */ class PendingReply {
                private final StorePendingReplies.PendingReply pendingReply;
                private final User repliedAuthor;
                private final GuildMember repliedAuthorGuildMember;

                public PendingReply(StorePendingReplies.PendingReply pendingReply, User user, GuildMember guildMember) {
                    m.checkNotNullParameter(pendingReply, "pendingReply");
                    this.pendingReply = pendingReply;
                    this.repliedAuthor = user;
                    this.repliedAuthorGuildMember = guildMember;
                }

                public static /* synthetic */ PendingReply copy$default(PendingReply pendingReply, StorePendingReplies.PendingReply pendingReply2, User user, GuildMember guildMember, int i, Object obj) {
                    if ((i & 1) != 0) {
                        pendingReply2 = pendingReply.pendingReply;
                    }
                    if ((i & 2) != 0) {
                        user = pendingReply.repliedAuthor;
                    }
                    if ((i & 4) != 0) {
                        guildMember = pendingReply.repliedAuthorGuildMember;
                    }
                    return pendingReply.copy(pendingReply2, user, guildMember);
                }

                /* renamed from: component1, reason: from getter */
                public final StorePendingReplies.PendingReply getPendingReply() {
                    return this.pendingReply;
                }

                /* renamed from: component2, reason: from getter */
                public final User getRepliedAuthor() {
                    return this.repliedAuthor;
                }

                /* renamed from: component3, reason: from getter */
                public final GuildMember getRepliedAuthorGuildMember() {
                    return this.repliedAuthorGuildMember;
                }

                public final PendingReply copy(StorePendingReplies.PendingReply pendingReply, User repliedAuthor, GuildMember repliedAuthorGuildMember) {
                    m.checkNotNullParameter(pendingReply, "pendingReply");
                    return new PendingReply(pendingReply, repliedAuthor, repliedAuthorGuildMember);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof PendingReply)) {
                        return false;
                    }
                    PendingReply pendingReply = (PendingReply) other;
                    return m.areEqual(this.pendingReply, pendingReply.pendingReply) && m.areEqual(this.repliedAuthor, pendingReply.repliedAuthor) && m.areEqual(this.repliedAuthorGuildMember, pendingReply.repliedAuthorGuildMember);
                }

                public final StorePendingReplies.PendingReply getPendingReply() {
                    return this.pendingReply;
                }

                public final User getRepliedAuthor() {
                    return this.repliedAuthor;
                }

                public final GuildMember getRepliedAuthorGuildMember() {
                    return this.repliedAuthorGuildMember;
                }

                public int hashCode() {
                    StorePendingReplies.PendingReply pendingReply = this.pendingReply;
                    int iHashCode = (pendingReply != null ? pendingReply.hashCode() : 0) * 31;
                    User user = this.repliedAuthor;
                    int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
                    GuildMember guildMember = this.repliedAuthorGuildMember;
                    return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sbU = a.U("PendingReply(pendingReply=");
                    sbU.append(this.pendingReply);
                    sbU.append(", repliedAuthor=");
                    sbU.append(this.repliedAuthor);
                    sbU.append(", repliedAuthorGuildMember=");
                    sbU.append(this.repliedAuthorGuildMember);
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, boolean z3, Guild guild, PendingReply pendingReply, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z4) {
                super(null);
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(meUser, "me");
                m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
                m.checkNotNullParameter(threadDraftState, "threadDraftState");
                this.channel = channel;
                this.me = meUser;
                this.editingMessage = editingMessage;
                this.relationshipType = num;
                this.channelPermissions = l;
                this.verificationLevelTriggered = guildVerificationLevel;
                this.isLurking = z2;
                this.isOnCooldown = z3;
                this.guild = guild;
                this.pendingReply = pendingReply;
                this.selectedThreadDraft = threadDraft;
                this.meGuildMember = guildMember;
                this.guildJoinRequest = guildJoinRequest;
                this.threadDraftState = threadDraftState;
                this.isForumPostCreateInProgress = z4;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, MeUser meUser, StoreChat.EditingMessage editingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, boolean z3, Guild guild, PendingReply pendingReply, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z4, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.channel : channel, (i & 2) != 0 ? loaded.me : meUser, (i & 4) != 0 ? loaded.editingMessage : editingMessage, (i & 8) != 0 ? loaded.relationshipType : num, (i & 16) != 0 ? loaded.channelPermissions : l, (i & 32) != 0 ? loaded.verificationLevelTriggered : guildVerificationLevel, (i & 64) != 0 ? loaded.isLurking : z2, (i & 128) != 0 ? loaded.isOnCooldown : z3, (i & 256) != 0 ? loaded.guild : guild, (i & 512) != 0 ? loaded.pendingReply : pendingReply, (i & 1024) != 0 ? loaded.selectedThreadDraft : threadDraft, (i & 2048) != 0 ? loaded.meGuildMember : guildMember, (i & 4096) != 0 ? loaded.guildJoinRequest : guildJoinRequest, (i & 8192) != 0 ? loaded.threadDraftState : threadDraftState, (i & 16384) != 0 ? loaded.isForumPostCreateInProgress : z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component10, reason: from getter */
            public final PendingReply getPendingReply() {
                return this.pendingReply;
            }

            /* renamed from: component11, reason: from getter */
            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            /* renamed from: component12, reason: from getter */
            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            /* renamed from: component13, reason: from getter */
            public final GuildJoinRequest getGuildJoinRequest() {
                return this.guildJoinRequest;
            }

            /* renamed from: component14, reason: from getter */
            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            /* renamed from: component15, reason: from getter */
            public final boolean getIsForumPostCreateInProgress() {
                return this.isForumPostCreateInProgress;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* renamed from: component3, reason: from getter */
            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            /* renamed from: component4, reason: from getter */
            public final Integer getRelationshipType() {
                return this.relationshipType;
            }

            /* renamed from: component5, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            /* renamed from: component6, reason: from getter */
            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            /* renamed from: component9, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Loaded copy(Channel channel, MeUser me2, StoreChat.EditingMessage editingMessage, Integer relationshipType, Long channelPermissions, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isOnCooldown, Guild guild, PendingReply pendingReply, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft, GuildMember meGuildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft.ThreadDraftState threadDraftState, boolean isForumPostCreateInProgress) {
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(me2, "me");
                m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
                m.checkNotNullParameter(threadDraftState, "threadDraftState");
                return new Loaded(channel, me2, editingMessage, relationshipType, channelPermissions, verificationLevelTriggered, isLurking, isOnCooldown, guild, pendingReply, selectedThreadDraft, meGuildMember, guildJoinRequest, threadDraftState, isForumPostCreateInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.channel, loaded.channel) && m.areEqual(this.me, loaded.me) && m.areEqual(this.editingMessage, loaded.editingMessage) && m.areEqual(this.relationshipType, loaded.relationshipType) && m.areEqual(this.channelPermissions, loaded.channelPermissions) && m.areEqual(this.verificationLevelTriggered, loaded.verificationLevelTriggered) && this.isLurking == loaded.isLurking && this.isOnCooldown == loaded.isOnCooldown && m.areEqual(this.guild, loaded.guild) && m.areEqual(this.pendingReply, loaded.pendingReply) && m.areEqual(this.selectedThreadDraft, loaded.selectedThreadDraft) && m.areEqual(this.meGuildMember, loaded.meGuildMember) && m.areEqual(this.guildJoinRequest, loaded.guildJoinRequest) && m.areEqual(this.threadDraftState, loaded.threadDraftState) && this.isForumPostCreateInProgress == loaded.isForumPostCreateInProgress;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildJoinRequest getGuildJoinRequest() {
                return this.guildJoinRequest;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            public final PendingReply getPendingReply() {
                return this.pendingReply;
            }

            public final Integer getRelationshipType() {
                return this.relationshipType;
            }

            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                MeUser meUser = this.me;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                StoreChat.EditingMessage editingMessage = this.editingMessage;
                int iHashCode3 = (iHashCode2 + (editingMessage != null ? editingMessage.hashCode() : 0)) * 31;
                Integer num = this.relationshipType;
                int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
                GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
                int iHashCode6 = (iHashCode5 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
                boolean z2 = this.isLurking;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode6 + i) * 31;
                boolean z3 = this.isOnCooldown;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                Guild guild = this.guild;
                int iHashCode7 = (i4 + (guild != null ? guild.hashCode() : 0)) * 31;
                PendingReply pendingReply = this.pendingReply;
                int iHashCode8 = (iHashCode7 + (pendingReply != null ? pendingReply.hashCode() : 0)) * 31;
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = this.selectedThreadDraft;
                int iHashCode9 = (iHashCode8 + (threadDraft != null ? threadDraft.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meGuildMember;
                int iHashCode10 = (iHashCode9 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                GuildJoinRequest guildJoinRequest = this.guildJoinRequest;
                int iHashCode11 = (iHashCode10 + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0)) * 31;
                StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
                int iHashCode12 = (iHashCode11 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
                boolean z4 = this.isForumPostCreateInProgress;
                return iHashCode12 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isForumPostCreateInProgress() {
                return this.isForumPostCreateInProgress;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", editingMessage=");
                sbU.append(this.editingMessage);
                sbU.append(", relationshipType=");
                sbU.append(this.relationshipType);
                sbU.append(", channelPermissions=");
                sbU.append(this.channelPermissions);
                sbU.append(", verificationLevelTriggered=");
                sbU.append(this.verificationLevelTriggered);
                sbU.append(", isLurking=");
                sbU.append(this.isLurking);
                sbU.append(", isOnCooldown=");
                sbU.append(this.isOnCooldown);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", pendingReply=");
                sbU.append(this.pendingReply);
                sbU.append(", selectedThreadDraft=");
                sbU.append(this.selectedThreadDraft);
                sbU.append(", meGuildMember=");
                sbU.append(this.meGuildMember);
                sbU.append(", guildJoinRequest=");
                sbU.append(this.guildJoinRequest);
                sbU.append(", threadDraftState=");
                sbU.append(this.threadDraftState);
                sbU.append(", isForumPostCreateInProgress=");
                return a.O(sbU, this.isForumPostCreateInProgress, ")");
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class Loading extends StoreState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ChatInputViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean ableToSendMessage;
            private final Channel channel;
            private final long channelId;
            private final StoreChat.EditingMessage editingMessage;
            private final boolean isBlocked;
            private final boolean isCommunicationDisabled;
            private final boolean isEditing;
            private final boolean isInputShowing;
            private final boolean isLurking;
            private final boolean isOnCooldown;
            private final boolean isReplying;
            private final boolean isSystemDM;
            private final boolean isVerificationLevelTriggered;
            private final ApplicationStatus joinRequestStatus;
            private final int maxFileSizeMB;
            private final MeUser me;
            private final GuildMember meGuildMember;
            private final PendingReplyState pendingReplyState;
            private final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft;
            private final boolean shouldBadgeChatInput;
            private final boolean shouldShowFollow;
            private final boolean shouldShowVerificationGate;
            private final boolean showCreateThreadOption;
            private final StoreThreadDraft.ThreadDraftState threadDraftState;
            private final long timeoutLeftMs;
            private final GuildVerificationLevel verificationLevelTriggered;

            /* compiled from: ChatInputViewModel.kt */
            public static abstract class PendingReplyState {

                /* compiled from: ChatInputViewModel.kt */
                public static final class Hide extends PendingReplyState {
                    public static final Hide INSTANCE = new Hide();

                    private Hide() {
                        super(null);
                    }
                }

                /* compiled from: ChatInputViewModel.kt */
                public static final /* data */ class Replying extends PendingReplyState {
                    private final MessageReference messageReference;
                    private final User repliedAuthor;
                    private final GuildMember repliedAuthorGuildMember;
                    private final boolean shouldMention;
                    private final boolean showMentionToggle;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Replying(MessageReference messageReference, boolean z2, boolean z3, User user, GuildMember guildMember) {
                        super(null);
                        m.checkNotNullParameter(messageReference, "messageReference");
                        m.checkNotNullParameter(user, "repliedAuthor");
                        this.messageReference = messageReference;
                        this.shouldMention = z2;
                        this.showMentionToggle = z3;
                        this.repliedAuthor = user;
                        this.repliedAuthorGuildMember = guildMember;
                    }

                    public static /* synthetic */ Replying copy$default(Replying replying, MessageReference messageReference, boolean z2, boolean z3, User user, GuildMember guildMember, int i, Object obj) {
                        if ((i & 1) != 0) {
                            messageReference = replying.messageReference;
                        }
                        if ((i & 2) != 0) {
                            z2 = replying.shouldMention;
                        }
                        boolean z4 = z2;
                        if ((i & 4) != 0) {
                            z3 = replying.showMentionToggle;
                        }
                        boolean z5 = z3;
                        if ((i & 8) != 0) {
                            user = replying.repliedAuthor;
                        }
                        User user2 = user;
                        if ((i & 16) != 0) {
                            guildMember = replying.repliedAuthorGuildMember;
                        }
                        return replying.copy(messageReference, z4, z5, user2, guildMember);
                    }

                    /* renamed from: component1, reason: from getter */
                    public final MessageReference getMessageReference() {
                        return this.messageReference;
                    }

                    /* renamed from: component2, reason: from getter */
                    public final boolean getShouldMention() {
                        return this.shouldMention;
                    }

                    /* renamed from: component3, reason: from getter */
                    public final boolean getShowMentionToggle() {
                        return this.showMentionToggle;
                    }

                    /* renamed from: component4, reason: from getter */
                    public final User getRepliedAuthor() {
                        return this.repliedAuthor;
                    }

                    /* renamed from: component5, reason: from getter */
                    public final GuildMember getRepliedAuthorGuildMember() {
                        return this.repliedAuthorGuildMember;
                    }

                    public final Replying copy(MessageReference messageReference, boolean shouldMention, boolean showMentionToggle, User repliedAuthor, GuildMember repliedAuthorGuildMember) {
                        m.checkNotNullParameter(messageReference, "messageReference");
                        m.checkNotNullParameter(repliedAuthor, "repliedAuthor");
                        return new Replying(messageReference, shouldMention, showMentionToggle, repliedAuthor, repliedAuthorGuildMember);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Replying)) {
                            return false;
                        }
                        Replying replying = (Replying) other;
                        return m.areEqual(this.messageReference, replying.messageReference) && this.shouldMention == replying.shouldMention && this.showMentionToggle == replying.showMentionToggle && m.areEqual(this.repliedAuthor, replying.repliedAuthor) && m.areEqual(this.repliedAuthorGuildMember, replying.repliedAuthorGuildMember);
                    }

                    public final MessageReference getMessageReference() {
                        return this.messageReference;
                    }

                    public final User getRepliedAuthor() {
                        return this.repliedAuthor;
                    }

                    public final GuildMember getRepliedAuthorGuildMember() {
                        return this.repliedAuthorGuildMember;
                    }

                    public final boolean getShouldMention() {
                        return this.shouldMention;
                    }

                    public final boolean getShowMentionToggle() {
                        return this.showMentionToggle;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public int hashCode() {
                        MessageReference messageReference = this.messageReference;
                        int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
                        boolean z2 = this.shouldMention;
                        int i = z2;
                        if (z2 != 0) {
                            i = 1;
                        }
                        int i2 = (iHashCode + i) * 31;
                        boolean z3 = this.showMentionToggle;
                        int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                        User user = this.repliedAuthor;
                        int iHashCode2 = (i3 + (user != null ? user.hashCode() : 0)) * 31;
                        GuildMember guildMember = this.repliedAuthorGuildMember;
                        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
                    }

                    public String toString() {
                        StringBuilder sbU = a.U("Replying(messageReference=");
                        sbU.append(this.messageReference);
                        sbU.append(", shouldMention=");
                        sbU.append(this.shouldMention);
                        sbU.append(", showMentionToggle=");
                        sbU.append(this.showMentionToggle);
                        sbU.append(", repliedAuthor=");
                        sbU.append(this.repliedAuthor);
                        sbU.append(", repliedAuthorGuildMember=");
                        sbU.append(this.repliedAuthorGuildMember);
                        sbU.append(")");
                        return sbU.toString();
                    }
                }

                private PendingReplyState() {
                }

                public /* synthetic */ PendingReplyState(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat.EditingMessage editingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, PendingReplyState pendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z15) {
                super(null);
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
                m.checkNotNullParameter(pendingReplyState, "pendingReplyState");
                m.checkNotNullParameter(threadDraftState, "threadDraftState");
                this.channel = channel;
                this.channelId = j;
                this.me = meUser;
                this.meGuildMember = guildMember;
                this.editingMessage = editingMessage;
                this.ableToSendMessage = z2;
                this.verificationLevelTriggered = guildVerificationLevel;
                this.isLurking = z3;
                this.isSystemDM = z4;
                this.isOnCooldown = z5;
                this.maxFileSizeMB = i;
                this.shouldShowFollow = z6;
                this.pendingReplyState = pendingReplyState;
                this.shouldBadgeChatInput = z7;
                this.isBlocked = z8;
                this.isInputShowing = z9;
                this.isVerificationLevelTriggered = z10;
                this.isEditing = z11;
                this.isReplying = z12;
                this.isCommunicationDisabled = z13;
                this.timeoutLeftMs = j2;
                this.selectedThreadDraft = threadDraft;
                this.shouldShowVerificationGate = z14;
                this.joinRequestStatus = applicationStatus;
                this.threadDraftState = threadDraftState;
                this.showCreateThreadOption = z15;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat.EditingMessage editingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, PendingReplyState pendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean z15, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.channel : channel, (i2 & 2) != 0 ? loaded.channelId : j, (i2 & 4) != 0 ? loaded.me : meUser, (i2 & 8) != 0 ? loaded.meGuildMember : guildMember, (i2 & 16) != 0 ? loaded.editingMessage : editingMessage, (i2 & 32) != 0 ? loaded.ableToSendMessage : z2, (i2 & 64) != 0 ? loaded.verificationLevelTriggered : guildVerificationLevel, (i2 & 128) != 0 ? loaded.isLurking : z3, (i2 & 256) != 0 ? loaded.isSystemDM : z4, (i2 & 512) != 0 ? loaded.isOnCooldown : z5, (i2 & 1024) != 0 ? loaded.maxFileSizeMB : i, (i2 & 2048) != 0 ? loaded.shouldShowFollow : z6, (i2 & 4096) != 0 ? loaded.pendingReplyState : pendingReplyState, (i2 & 8192) != 0 ? loaded.shouldBadgeChatInput : z7, (i2 & 16384) != 0 ? loaded.isBlocked : z8, (i2 & 32768) != 0 ? loaded.isInputShowing : z9, (i2 & 65536) != 0 ? loaded.isVerificationLevelTriggered : z10, (i2 & 131072) != 0 ? loaded.isEditing : z11, (i2 & 262144) != 0 ? loaded.isReplying : z12, (i2 & 524288) != 0 ? loaded.isCommunicationDisabled : z13, (i2 & 1048576) != 0 ? loaded.timeoutLeftMs : j2, (i2 & 2097152) != 0 ? loaded.selectedThreadDraft : threadDraft, (4194304 & i2) != 0 ? loaded.shouldShowVerificationGate : z14, (i2 & 8388608) != 0 ? loaded.joinRequestStatus : applicationStatus, (i2 & 16777216) != 0 ? loaded.threadDraftState : threadDraftState, (i2 & 33554432) != 0 ? loaded.showCreateThreadOption : z15);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            /* renamed from: component11, reason: from getter */
            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getShouldShowFollow() {
                return this.shouldShowFollow;
            }

            /* renamed from: component13, reason: from getter */
            public final PendingReplyState getPendingReplyState() {
                return this.pendingReplyState;
            }

            /* renamed from: component14, reason: from getter */
            public final boolean getShouldBadgeChatInput() {
                return this.shouldBadgeChatInput;
            }

            /* renamed from: component15, reason: from getter */
            public final boolean getIsBlocked() {
                return this.isBlocked;
            }

            /* renamed from: component16, reason: from getter */
            public final boolean getIsInputShowing() {
                return this.isInputShowing;
            }

            /* renamed from: component17, reason: from getter */
            public final boolean getIsVerificationLevelTriggered() {
                return this.isVerificationLevelTriggered;
            }

            /* renamed from: component18, reason: from getter */
            public final boolean getIsEditing() {
                return this.isEditing;
            }

            /* renamed from: component19, reason: from getter */
            public final boolean getIsReplying() {
                return this.isReplying;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component20, reason: from getter */
            public final boolean getIsCommunicationDisabled() {
                return this.isCommunicationDisabled;
            }

            /* renamed from: component21, reason: from getter */
            public final long getTimeoutLeftMs() {
                return this.timeoutLeftMs;
            }

            /* renamed from: component22, reason: from getter */
            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            /* renamed from: component23, reason: from getter */
            public final boolean getShouldShowVerificationGate() {
                return this.shouldShowVerificationGate;
            }

            /* renamed from: component24, reason: from getter */
            public final ApplicationStatus getJoinRequestStatus() {
                return this.joinRequestStatus;
            }

            /* renamed from: component25, reason: from getter */
            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            /* renamed from: component26, reason: from getter */
            public final boolean getShowCreateThreadOption() {
                return this.showCreateThreadOption;
            }

            /* renamed from: component3, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* renamed from: component4, reason: from getter */
            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            /* renamed from: component5, reason: from getter */
            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getAbleToSendMessage() {
                return this.ableToSendMessage;
            }

            /* renamed from: component7, reason: from getter */
            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsSystemDM() {
                return this.isSystemDM;
            }

            public final Loaded copy(Channel channel, long channelId, MeUser me2, GuildMember meGuildMember, StoreChat.EditingMessage editingMessage, boolean ableToSendMessage, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isSystemDM, boolean isOnCooldown, int maxFileSizeMB, boolean shouldShowFollow, PendingReplyState pendingReplyState, boolean shouldBadgeChatInput, boolean isBlocked, boolean isInputShowing, boolean isVerificationLevelTriggered, boolean isEditing, boolean isReplying, boolean isCommunicationDisabled, long timeoutLeftMs, StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft, boolean shouldShowVerificationGate, ApplicationStatus joinRequestStatus, StoreThreadDraft.ThreadDraftState threadDraftState, boolean showCreateThreadOption) {
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
                m.checkNotNullParameter(pendingReplyState, "pendingReplyState");
                m.checkNotNullParameter(threadDraftState, "threadDraftState");
                return new Loaded(channel, channelId, me2, meGuildMember, editingMessage, ableToSendMessage, verificationLevelTriggered, isLurking, isSystemDM, isOnCooldown, maxFileSizeMB, shouldShowFollow, pendingReplyState, shouldBadgeChatInput, isBlocked, isInputShowing, isVerificationLevelTriggered, isEditing, isReplying, isCommunicationDisabled, timeoutLeftMs, selectedThreadDraft, shouldShowVerificationGate, joinRequestStatus, threadDraftState, showCreateThreadOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.channel, loaded.channel) && this.channelId == loaded.channelId && m.areEqual(this.me, loaded.me) && m.areEqual(this.meGuildMember, loaded.meGuildMember) && m.areEqual(this.editingMessage, loaded.editingMessage) && this.ableToSendMessage == loaded.ableToSendMessage && m.areEqual(this.verificationLevelTriggered, loaded.verificationLevelTriggered) && this.isLurking == loaded.isLurking && this.isSystemDM == loaded.isSystemDM && this.isOnCooldown == loaded.isOnCooldown && this.maxFileSizeMB == loaded.maxFileSizeMB && this.shouldShowFollow == loaded.shouldShowFollow && m.areEqual(this.pendingReplyState, loaded.pendingReplyState) && this.shouldBadgeChatInput == loaded.shouldBadgeChatInput && this.isBlocked == loaded.isBlocked && this.isInputShowing == loaded.isInputShowing && this.isVerificationLevelTriggered == loaded.isVerificationLevelTriggered && this.isEditing == loaded.isEditing && this.isReplying == loaded.isReplying && this.isCommunicationDisabled == loaded.isCommunicationDisabled && this.timeoutLeftMs == loaded.timeoutLeftMs && m.areEqual(this.selectedThreadDraft, loaded.selectedThreadDraft) && this.shouldShowVerificationGate == loaded.shouldShowVerificationGate && m.areEqual(this.joinRequestStatus, loaded.joinRequestStatus) && m.areEqual(this.threadDraftState, loaded.threadDraftState) && this.showCreateThreadOption == loaded.showCreateThreadOption;
            }

            public final boolean getAbleToSendMessage() {
                return this.ableToSendMessage;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final StoreChat.EditingMessage getEditingMessage() {
                return this.editingMessage;
            }

            public final ApplicationStatus getJoinRequestStatus() {
                return this.joinRequestStatus;
            }

            public final int getMaxFileSizeMB() {
                return this.maxFileSizeMB;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final GuildMember getMeGuildMember() {
                return this.meGuildMember;
            }

            public final PendingReplyState getPendingReplyState() {
                return this.pendingReplyState;
            }

            public final StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft getSelectedThreadDraft() {
                return this.selectedThreadDraft;
            }

            public final boolean getShouldBadgeChatInput() {
                return this.shouldBadgeChatInput;
            }

            public final boolean getShouldShowFollow() {
                return this.shouldShowFollow;
            }

            public final boolean getShouldShowVerificationGate() {
                return this.shouldShowVerificationGate;
            }

            public final boolean getShowCreateThreadOption() {
                return this.showCreateThreadOption;
            }

            public final StoreThreadDraft.ThreadDraftState getThreadDraftState() {
                return this.threadDraftState;
            }

            public final long getTimeoutLeftMs() {
                return this.timeoutLeftMs;
            }

            public final GuildVerificationLevel getVerificationLevelTriggered() {
                return this.verificationLevelTriggered;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iA = (b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                MeUser meUser = this.me;
                int iHashCode = (iA + (meUser != null ? meUser.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meGuildMember;
                int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                StoreChat.EditingMessage editingMessage = this.editingMessage;
                int iHashCode3 = (iHashCode2 + (editingMessage != null ? editingMessage.hashCode() : 0)) * 31;
                boolean z2 = this.ableToSendMessage;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode3 + i) * 31;
                GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
                int iHashCode4 = (i2 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
                boolean z3 = this.isLurking;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode4 + i3) * 31;
                boolean z4 = this.isSystemDM;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isOnCooldown;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (((i6 + i7) * 31) + this.maxFileSizeMB) * 31;
                boolean z6 = this.shouldShowFollow;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                PendingReplyState pendingReplyState = this.pendingReplyState;
                int iHashCode5 = (i10 + (pendingReplyState != null ? pendingReplyState.hashCode() : 0)) * 31;
                boolean z7 = this.shouldBadgeChatInput;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (iHashCode5 + i11) * 31;
                boolean z8 = this.isBlocked;
                int i13 = z8;
                if (z8 != 0) {
                    i13 = 1;
                }
                int i14 = (i12 + i13) * 31;
                boolean z9 = this.isInputShowing;
                int i15 = z9;
                if (z9 != 0) {
                    i15 = 1;
                }
                int i16 = (i14 + i15) * 31;
                boolean z10 = this.isVerificationLevelTriggered;
                int i17 = z10;
                if (z10 != 0) {
                    i17 = 1;
                }
                int i18 = (i16 + i17) * 31;
                boolean z11 = this.isEditing;
                int i19 = z11;
                if (z11 != 0) {
                    i19 = 1;
                }
                int i20 = (i18 + i19) * 31;
                boolean z12 = this.isReplying;
                int i21 = z12;
                if (z12 != 0) {
                    i21 = 1;
                }
                int i22 = (i20 + i21) * 31;
                boolean z13 = this.isCommunicationDisabled;
                int i23 = z13;
                if (z13 != 0) {
                    i23 = 1;
                }
                int iA2 = (b.a(this.timeoutLeftMs) + ((i22 + i23) * 31)) * 31;
                StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = this.selectedThreadDraft;
                int iHashCode6 = (iA2 + (threadDraft != null ? threadDraft.hashCode() : 0)) * 31;
                boolean z14 = this.shouldShowVerificationGate;
                int i24 = z14;
                if (z14 != 0) {
                    i24 = 1;
                }
                int i25 = (iHashCode6 + i24) * 31;
                ApplicationStatus applicationStatus = this.joinRequestStatus;
                int iHashCode7 = (i25 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
                StoreThreadDraft.ThreadDraftState threadDraftState = this.threadDraftState;
                int iHashCode8 = (iHashCode7 + (threadDraftState != null ? threadDraftState.hashCode() : 0)) * 31;
                boolean z15 = this.showCreateThreadOption;
                return iHashCode8 + (z15 ? 1 : z15 ? 1 : 0);
            }

            public final boolean isBlocked() {
                return this.isBlocked;
            }

            public final boolean isCommunicationDisabled() {
                return this.isCommunicationDisabled;
            }

            public final boolean isEditing() {
                return this.isEditing;
            }

            public final boolean isInputShowing() {
                return this.isInputShowing;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public final boolean isReplying() {
                return this.isReplying;
            }

            public final boolean isSystemDM() {
                return this.isSystemDM;
            }

            public final boolean isVerificationLevelTriggered() {
                return this.isVerificationLevelTriggered;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", meGuildMember=");
                sbU.append(this.meGuildMember);
                sbU.append(", editingMessage=");
                sbU.append(this.editingMessage);
                sbU.append(", ableToSendMessage=");
                sbU.append(this.ableToSendMessage);
                sbU.append(", verificationLevelTriggered=");
                sbU.append(this.verificationLevelTriggered);
                sbU.append(", isLurking=");
                sbU.append(this.isLurking);
                sbU.append(", isSystemDM=");
                sbU.append(this.isSystemDM);
                sbU.append(", isOnCooldown=");
                sbU.append(this.isOnCooldown);
                sbU.append(", maxFileSizeMB=");
                sbU.append(this.maxFileSizeMB);
                sbU.append(", shouldShowFollow=");
                sbU.append(this.shouldShowFollow);
                sbU.append(", pendingReplyState=");
                sbU.append(this.pendingReplyState);
                sbU.append(", shouldBadgeChatInput=");
                sbU.append(this.shouldBadgeChatInput);
                sbU.append(", isBlocked=");
                sbU.append(this.isBlocked);
                sbU.append(", isInputShowing=");
                sbU.append(this.isInputShowing);
                sbU.append(", isVerificationLevelTriggered=");
                sbU.append(this.isVerificationLevelTriggered);
                sbU.append(", isEditing=");
                sbU.append(this.isEditing);
                sbU.append(", isReplying=");
                sbU.append(this.isReplying);
                sbU.append(", isCommunicationDisabled=");
                sbU.append(this.isCommunicationDisabled);
                sbU.append(", timeoutLeftMs=");
                sbU.append(this.timeoutLeftMs);
                sbU.append(", selectedThreadDraft=");
                sbU.append(this.selectedThreadDraft);
                sbU.append(", shouldShowVerificationGate=");
                sbU.append(this.shouldShowVerificationGate);
                sbU.append(", joinRequestStatus=");
                sbU.append(this.joinRequestStatus);
                sbU.append(", threadDraftState=");
                sbU.append(this.threadDraftState);
                sbU.append(", showCreateThreadOption=");
                return a.O(sbU, this.showCreateThreadOption, ")");
            }
        }

        /* compiled from: ChatInputViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildVerificationLevel.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildVerificationLevel.LOW.ordinal()] = 1;
            iArr[GuildVerificationLevel.HIGHEST.ordinal()] = 2;
            iArr[GuildVerificationLevel.NONE.ordinal()] = 3;
            iArr[GuildVerificationLevel.MEDIUM.ordinal()] = 4;
            iArr[GuildVerificationLevel.HIGH.ordinal()] = 5;
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$createAndGotoThread$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Channel, Observable<? extends Channel>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Channel channel) {
            Observable<R> observableG = ChatInputViewModel.access$getStoreChannels$p(ChatInputViewModel.this).observeChannel(channel.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null));
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$createAndGotoThread$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Channel, Unit> {
        public final /* synthetic */ ViewState.Loaded $loadedViewState;
        public final /* synthetic */ Function1 $onThreadCreated;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded, Function1 function1) {
            super(1);
            this.$loadedViewState = loaded;
            this.$onThreadCreated = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel != null) {
                StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$loadedViewState.getChannelId());
                Function1 function1 = this.$onThreadCreated;
                if (function1 != null) {
                    function1.invoke(channel);
                }
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$createAndGotoThread$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ViewState.Loaded $loadedViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, ViewState.Loaded loaded) {
            super(1);
            this.$context = context;
            this.$loadedViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$loadedViewState.getChannelId());
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$observeChatInputViewState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Long, Long> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Long call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Long l) {
            if (ChatInputViewModel.access$getUseTimeoutUpdateInterval$p(ChatInputViewModel.this)) {
                return l;
            }
            return 0L;
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$observeChatInputViewState$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<Long, ViewState, ViewState> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ViewState call(Long l, ViewState viewState) {
            return call2(l, viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState call2(Long l, ViewState viewState) {
            ViewState.Loaded loaded = (ViewState.Loaded) (!(viewState instanceof ViewState.Loaded) ? null : viewState);
            if (loaded == null) {
                return viewState;
            }
            if (ChatInputViewModel.access$getUseTimeoutUpdateInterval$p(ChatInputViewModel.this)) {
                long jAccess$calculateTimeoutLeftMs = ChatInputViewModel.access$calculateTimeoutLeftMs(ChatInputViewModel.this, loaded.getMeGuildMember());
                GuildMember meGuildMember = loaded.getMeGuildMember();
                ViewState.Loaded loadedCopy$default = ViewState.Loaded.copy$default(loaded, null, 0L, null, null, null, false, null, false, false, false, 0, false, null, false, false, false, false, false, false, meGuildMember != null && meGuildMember.isCommunicationDisabled(), jAccess$calculateTimeoutLeftMs, null, false, null, null, false, 65535999, null);
                if (loaded.getMeGuildMember() != null && loaded.isCommunicationDisabled() && !loadedCopy$default.isCommunicationDisabled()) {
                    ChatInputViewModel.access$getStoreGuilds$p(ChatInputViewModel.this).handleGuildMemberCommunicationEnabled(loaded.getMeGuildMember().getGuildId(), loaded.getMeGuildMember().getUserId());
                }
                loaded = loadedCopy$default;
            }
            return loaded != null ? loaded : viewState;
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
        }
    }

    /* compiled from: ChatInputViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Channel, Unit> {
        public final /* synthetic */ Function1 $sendMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$sendMessage = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            m.checkNotNullParameter(channel, "thread");
            this.$sendMessage.invoke(Long.valueOf(channel.getId()));
        }
    }

    public ChatInputViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 32767, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreChat chat = (i & 1) != 0 ? StoreStream.INSTANCE.getChat() : storeChat;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreMessagesLoader messagesLoader = (i & 4) != 0 ? StoreStream.INSTANCE.getMessagesLoader() : storeMessagesLoader;
        StoreLurking lurking = (i & 8) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking;
        StoreStickers stickers = (i & 16) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        StorePendingReplies pendingReplies = (i & 32) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies;
        StoreApplicationInteractions interactions = (i & 64) != 0 ? StoreStream.INSTANCE.getInteractions() : storeApplicationInteractions;
        StoreApplicationCommands applicationCommands = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationCommands() : storeApplicationCommands;
        StoreApplicationCommandFrecency applicationComandFrecency = (i & 256) != 0 ? StoreStream.INSTANCE.getApplicationComandFrecency() : storeApplicationCommandFrecency;
        StoreUserSettings userSettings = (i & 512) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreAnalytics analytics = (i & 1024) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreThreadDraft threadDraft = (i & 2048) != 0 ? StoreStream.INSTANCE.getThreadDraft() : storeThreadDraft;
        StoreGuilds guilds = (i & 4096) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        boolean zIsEnabled = (i & 8192) != 0 ? EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled() : z2;
        if ((i & 16384) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStoreState = Companion.access$observeStoreState(companion, companion2.getChannelsSelected(), companion2.getUsers(), chat, companion2.getUserRelationships(), companion2.getPermissions(), lurking, companion2.getSlowMode(), guilds, pendingReplies, companion2.getGuildJoinRequests(), threadDraft);
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(chat, channels, messagesLoader, lurking, stickers, pendingReplies, interactions, applicationCommands, applicationComandFrecency, userSettings, analytics, threadDraft, guilds, zIsEnabled, observableAccess$observeStoreState);
    }

    public static final /* synthetic */ long access$calculateTimeoutLeftMs(ChatInputViewModel chatInputViewModel, GuildMember guildMember) {
        return chatInputViewModel.calculateTimeoutLeftMs(guildMember);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.eventSubject;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeGuilds;
    }

    public static final /* synthetic */ StoreThreadDraft access$getStoreThreadDraft$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.storeThreadDraft;
    }

    public static final /* synthetic */ boolean access$getUseTimeoutUpdateInterval$p(ChatInputViewModel chatInputViewModel) {
        return chatInputViewModel.useTimeoutUpdateInterval;
    }

    public static final /* synthetic */ void access$handleStoreChatEvent(ChatInputViewModel chatInputViewModel, StoreChat.Event event) {
        chatInputViewModel.handleStoreChatEvent(event);
    }

    public static final /* synthetic */ void access$handleStoreState(ChatInputViewModel chatInputViewModel, StoreState storeState) {
        chatInputViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$setUseTimeoutUpdateInterval$p(ChatInputViewModel chatInputViewModel, boolean z2) {
        chatInputViewModel.useTimeoutUpdateInterval = z2;
    }

    private final long calculateTimeoutLeftMs(GuildMember guildMember) {
        UtcDateTime communicationDisabledUntil;
        if (guildMember == null || (communicationDisabledUntil = guildMember.getCommunicationDisabledUntil()) == null) {
            return 0L;
        }
        return communicationDisabledUntil.getDateTimeMillis() - ClockFactory.get().currentTimeMillis();
    }

    private final void createAndGotoThread(Context context, Long parentMessageId, String location, ViewState.Loaded loadedViewState, Function1<? super Channel, Unit> onThreadCreated) {
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        long channelId = loadedViewState.getChannelId();
        int i = ChannelUtils.i(loadedViewState.getChannel()) ? 10 : loadedViewState.getThreadDraftState().isPrivate() ? 12 : 11;
        String threadName = loadedViewState.getThreadDraftState().getThreadName();
        if (threadName == null) {
            threadName = "";
        }
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(threadUtils.createThread(channelId, parentMessageId, i, threadName, Integer.valueOf(getAutoArchiveDuration()), location), false, 1, null).A(new AnonymousClass1());
        m.checkNotNullExpressionValue(observableA, "ThreadUtils.createThread…utationLatest()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableA, this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(context, loadedViewState), (Function0) null, (Function0) null, new AnonymousClass2(loadedViewState, onThreadCreated), 54, (Object) null);
    }

    public static /* synthetic */ void createAndGotoThread$default(ChatInputViewModel chatInputViewModel, Context context, Long l, String str, ViewState.Loaded loaded, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        chatInputViewModel.createAndGotoThread(context, l, str, loaded, function1);
    }

    private final void createForumPostWithMessage(Context context, long channelId, MessageManager messageManager, MessageContent messageContent, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            ForumPostCreateManager.INSTANCE.createForumPostWithMessage(context, messageManager, channelId, getAutoArchiveDuration(), messageContent.getTextContent(), loaded.getThreadDraftState(), attachmentsRequest, onMessageTooLong, onFilesTooLarge);
        }
    }

    private final int getAutoArchiveDuration() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return 1440;
        }
        Integer autoArchiveDuration = loaded.getThreadDraftState().getAutoArchiveDuration();
        if (autoArchiveDuration == null) {
            autoArchiveDuration = loaded.getChannel().getDefaultAutoArchiveDuration();
        }
        if (autoArchiveDuration != null) {
            return autoArchiveDuration.intValue();
        }
        return 1440;
    }

    private final void handleStoreChatEvent(StoreChat.Event event) {
        if (event instanceof StoreChat.Event.AppendChatText) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.AppendChatText(((StoreChat.Event.AppendChatText) event).getText()));
        } else if (event instanceof StoreChat.Event.ReplaceChatText) {
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(new Event.SetChatText(((StoreChat.Event.ReplaceChatText) event).getText()));
        }
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        boolean z3;
        String string;
        CharSequence content;
        ThreadMetadata threadMetadata;
        if (storeState instanceof StoreState.Loaded) {
            StoreState.Loaded loaded = (StoreState.Loaded) storeState;
            boolean zHasAccessWrite = loaded.getSelectedThreadDraft() == null ? PermissionUtils.INSTANCE.hasAccessWrite(loaded.getChannel(), loaded.getChannelPermissions()) : PermissionUtils.can(Permission.SEND_MESSAGES_IN_THREADS, loaded.getChannelPermissions());
            boolean zIsType = ModelUserRelationship.isType(loaded.getRelationshipType(), 2);
            boolean z4 = (zIsType || !zHasAccessWrite || loaded.isLurking() || (ChannelUtils.H(loaded.getChannel()) && (threadMetadata = loaded.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() && !ThreadUtils.INSTANCE.canUnarchiveThread(loaded.getChannel(), loaded.getChannelPermissions()))) ? false : true;
            boolean z5 = loaded.getChannel().getType() != 15 ? z4 : z4 && (loaded.getSelectedThreadDraft() != null) && !loaded.isForumPostCreateInProgress();
            boolean z6 = loaded.getChannel().getType() == 5 && !z5;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            int maxFileSizeMB = premiumUtils.getMaxFileSizeMB(loaded.getMe());
            Guild guild = loaded.getGuild();
            int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), maxFileSizeMB);
            boolean z7 = loaded.getVerificationLevelTriggered() != GuildVerificationLevel.NONE;
            StoreState.Loaded.PendingReply pendingReply = loaded.getPendingReply();
            ViewState.Loaded.PendingReplyState replying = (pendingReply != null ? pendingReply.getRepliedAuthor() : null) != null ? new ViewState.Loaded.PendingReplyState.Replying(loaded.getPendingReply().getPendingReply().getMessageReference(), loaded.getPendingReply().getPendingReply().getShouldMention(), loaded.getPendingReply().getPendingReply().getShowMentionToggle(), loaded.getPendingReply().getRepliedAuthor(), loaded.getPendingReply().getRepliedAuthorGuildMember()) : ViewState.Loaded.PendingReplyState.Hide.INSTANCE;
            boolean zHasVerificationGate$default = MemberVerificationUtils.hasVerificationGate$default(MemberVerificationUtils.INSTANCE, loaded.getGuild(), null, 2, null);
            boolean z8 = (loaded.getMeGuildMember() == null || loaded.getMeGuildMember().getPending()) ? false : true;
            GuildMember meGuildMember = loaded.getMeGuildMember();
            boolean zIsCommunicationDisabled = meGuildMember != null ? meGuildMember.isCommunicationDisabled() : false;
            boolean z9 = zHasVerificationGate$default && !z8;
            boolean z10 = (ChannelUtils.E(loaded.getChannel()) || loaded.isLurking() || z7 || z6 || z9 || zIsCommunicationDisabled) ? false : true;
            boolean z11 = z5 && loaded.getEditingMessage() != null && loaded.getEditingMessage().getMessage().getChannelId() == loaded.getChannel().getId();
            boolean z12 = replying instanceof ViewState.Loaded.PendingReplyState.Replying;
            boolean zCanCreateThread = ThreadUtils.INSTANCE.canCreateThread(loaded.getChannelPermissions(), loaded.getChannel(), null, loaded.getGuild());
            long jCalculateTimeoutLeftMs = calculateTimeoutLeftMs(loaded.getMeGuildMember());
            Channel channel = loaded.getChannel();
            long id2 = loaded.getChannel().getId();
            MeUser me2 = loaded.getMe();
            GuildMember meGuildMember2 = loaded.getMeGuildMember();
            StoreChat.EditingMessage editingMessage = loaded.getEditingMessage();
            GuildVerificationLevel verificationLevelTriggered = loaded.getVerificationLevelTriggered();
            boolean zIsLurking = loaded.isLurking();
            boolean zE = ChannelUtils.E(loaded.getChannel());
            boolean zIsOnCooldown = loaded.isOnCooldown();
            StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft = loaded.getSelectedThreadDraft();
            GuildJoinRequest guildJoinRequest = loaded.getGuildJoinRequest();
            boolean z13 = zIsCommunicationDisabled;
            ViewState.Loaded loaded2 = new ViewState.Loaded(channel, id2, me2, meGuildMember2, editingMessage, z5, verificationLevelTriggered, zIsLurking, zE, zIsOnCooldown, iMax, z6, replying, false, zIsType, z10, z7, z11, z12, z13, jCalculateTimeoutLeftMs, selectedThreadDraft, z9, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, loaded.getThreadDraftState(), zCanCreateThread);
            ViewState viewState = getViewState();
            if (!(viewState instanceof ViewState.Loaded)) {
                viewState = null;
            }
            ViewState.Loaded loaded3 = (ViewState.Loaded) viewState;
            boolean z14 = !m.areEqual(loaded3 != null ? loaded3.getEditingMessage() : null, loaded2.getEditingMessage());
            ViewState viewState2 = getViewState();
            if (!(viewState2 instanceof ViewState.Loaded)) {
                viewState2 = null;
            }
            ViewState.Loaded loaded4 = (ViewState.Loaded) viewState2;
            if ((loaded4 != null ? loaded4.getSelectedThreadDraft() : null) == null || loaded2.getSelectedThreadDraft() != null) {
                z2 = z13;
                z3 = false;
            } else {
                z2 = z13;
                z3 = true;
            }
            this.useTimeoutUpdateInterval = z2;
            updateViewState(loaded2);
            if (z14) {
                StoreChat.EditingMessage editingMessage2 = loaded2.getEditingMessage();
                if (editingMessage2 == null || (content = editingMessage2.getContent()) == null || (string = content.toString()) == null) {
                    string = "";
                }
                this.eventSubject.k.onNext(new Event.SetChatText(string));
            }
            if (z3) {
                this.eventSubject.k.onNext(Event.ThreadDraftClosed.INSTANCE);
            }
        }
    }

    public static /* synthetic */ void sendCommand$default(ChatInputViewModel chatInputViewModel, Context context, MessageManager messageManager, ApplicationCommandData applicationCommandData, Map map, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        chatInputViewModel.sendCommand(context, messageManager, applicationCommandData, map, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public static /* synthetic */ void sendMessage$default(ChatInputViewModel chatInputViewModel, Context context, MessageManager messageManager, MessageContent messageContent, List list, boolean z2, Function1 function1, int i, Object obj) {
        chatInputViewModel.sendMessage(context, messageManager, messageContent, list, (i & 16) != 0 ? false : z2, function1);
    }

    public final void deleteEditingMessage() {
        this.storeChat.setEditingMessage(null);
    }

    public final void deletePendingReply() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            this.storePendingReplies.onDeletePendingReply(loaded.getChannelId());
        }
    }

    public final boolean handleEmojiAutocompleteUpsellClicked(Autocompletable item) {
        m.checkNotNullParameter(item, "item");
        if (!this.isEmojiAutocompleteUpsellEnabled || !(item instanceof EmojiUpsellPlaceholder)) {
            return false;
        }
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowPremiumUpsell(1, R.string.autocomplete_emoji_upsell_modal_header, R.string.autocomplete_emoji_upsell_modal_blurb_mobile, false, false, 24, null));
        this.storeAnalytics.emojiAutocompleteUpsellModalViewed();
        return true;
    }

    public final void jumpToMessageReference(MessageReference messageReference) {
        m.checkNotNullParameter(messageReference, "messageReference");
        StoreMessagesLoader storeMessagesLoader = this.storeMessagesLoader;
        Long channelId = messageReference.getChannelId();
        m.checkNotNull(channelId);
        long jLongValue = channelId.longValue();
        Long messageId = messageReference.getMessageId();
        m.checkNotNull(messageId);
        storeMessagesLoader.jumpToMessage(jLongValue, messageId.longValue());
    }

    public final void lurkGuild(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            StoreLurking storeLurking = this.storeLurking;
            long guildId = loaded.getChannel().getGuildId();
            Context contextRequireContext = fragment.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
            storeLurking.postJoinGuildAsMember(guildId, contextRequireContext);
        }
    }

    public final Observable<ViewState> observeChatInputViewState() {
        Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableE, "Observable.interval(0L, 1L, TimeUnit.SECONDS)");
        Observable<ViewState> observableJ = Observable.j(ObservableExtensionsKt.ui(observableE).G(new AnonymousClass1()).r(), observeViewState(), new AnonymousClass2());
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…     } ?: viewState\n    }");
        return observableJ;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void onCommandInputsInvalid() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.CommandInputsInvalid.INSTANCE);
    }

    public final void onCommandUsed(ApplicationCommandData applicationCommandData) {
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            this.storeApplicationCommandsFrecency.onCommandUsed(loaded.getChannel().getGuildId() != 0 ? Long.valueOf(loaded.getChannel().getGuildId()) : null, ApplicationCommandDataKt.getCommandId(applicationCommandData));
        }
    }

    public final void sendCommand(Context context, MessageManager messageManager, ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> attachments, boolean autocomplete, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        m.checkNotNullParameter(attachments, "attachments");
        m.checkNotNullParameter(onValidationResult, "onValidationResult");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        AttachmentContext attachmentContext = toAttachmentContext(u.toList(attachments.values()), context);
        ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendCommand$commandResendCompressedHandler$1(this, context, attachmentContext, attachments, messageManager, applicationCommandData, autocomplete);
        if (!applicationCommandData.getValidInputs() && !autocomplete) {
            onCommandInputsInvalid();
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        Long lValueOf = loaded.getChannel().getGuildId() != 0 ? Long.valueOf(loaded.getChannel().getGuildId()) : null;
        if (autocomplete) {
            this.storeApplicationCommands.requestApplicationCommandAutocompleteData(lValueOf, loaded.getChannelId(), applicationCommandData);
            onValidationResult.invoke(Boolean.TRUE);
        } else if (chatInputViewModel$sendCommand$commandResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendCommand$commandResendCompressedHandler$1.invoke();
        } else {
            onCommandUsed(applicationCommandData);
            onValidationResult.invoke(Boolean.valueOf(messageManager.sendCommand(loaded.getChannelId(), lValueOf, applicationCommandData.getApplicationCommand().getVersion(), applicationCommandData, new MessageManager.AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), loaded.getMaxFileSizeMB(), attachmentContext.getAttachments()), ChatInputViewModel$sendCommand$validated$1.INSTANCE, ChatInputViewModel$sendCommand$validated$2.INSTANCE, new ChatInputViewModel$sendCommand$validated$3(this, attachmentContext, chatInputViewModel$sendCommand$commandResendCompressedHandler$1))));
        }
    }

    public final void sendMessage(Context context, MessageManager messageManager, MessageContent messageContent, List<? extends Attachment<?>> attachmentsRaw, boolean compressedImages, Function1<? super Boolean, Unit> onValidationResult) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(messageContent, "messageContent");
        m.checkNotNullParameter(attachmentsRaw, "attachmentsRaw");
        m.checkNotNullParameter(onValidationResult, "onValidationResult");
        Object viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            onValidationResult.invoke(Boolean.FALSE);
            return;
        }
        AttachmentContext attachmentContext = toAttachmentContext(attachmentsRaw, context);
        boolean z2 = true;
        boolean z3 = loaded.getSelectedThreadDraft() != null;
        ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1 = (compressedImages || !attachmentContext.getHasImage()) ? null : new ChatInputViewModel$sendMessage$messageResendCompressedHandler$1(this, context, attachmentContext, messageManager, messageContent, onValidationResult);
        ChatInputViewModel$sendMessage$messageSendResultHandler$1 chatInputViewModel$sendMessage$messageSendResultHandler$1 = new ChatInputViewModel$sendMessage$messageSendResultHandler$1(this, context, loaded, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1, z3);
        ChatInputViewModel$sendMessage$onMessageTooLong$1 chatInputViewModel$sendMessage$onMessageTooLong$1 = new ChatInputViewModel$sendMessage$onMessageTooLong$1(this);
        ChatInputViewModel$sendMessage$onFilesTooLarge$1 chatInputViewModel$sendMessage$onFilesTooLarge$1 = new ChatInputViewModel$sendMessage$onFilesTooLarge$1(this, attachmentContext, chatInputViewModel$sendMessage$messageResendCompressedHandler$1);
        if (chatInputViewModel$sendMessage$messageResendCompressedHandler$1 != null && this.storeUserSettings.getIsAutoImageCompressionEnabled()) {
            chatInputViewModel$sendMessage$messageResendCompressedHandler$1.invoke();
            return;
        }
        MessageManager.AttachmentsRequest attachmentsRequest = new MessageManager.AttachmentsRequest(attachmentContext.getCurrentFileSizeMB(), loaded.getMaxFileSizeMB(), attachmentContext.getAttachments());
        ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1 = new ChatInputViewModel$sendMessage$sendMessage$1(messageManager, messageContent, attachmentsRequest, chatInputViewModel$sendMessage$messageSendResultHandler$1, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1, onValidationResult);
        boolean zQ = ChannelUtils.q(loaded.getChannel());
        boolean zCanAccessRedesignedForumChannels$default = ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, loaded.getChannel().getGuildId(), null, 2, null);
        if (loaded.isEditing() && loaded.getEditingMessage() != null) {
            Message message = loaded.getEditingMessage().getMessage();
            long id2 = message.getId();
            long channelId = message.getChannelId();
            String textContent = messageContent.getTextContent();
            String content = message.getContent();
            onValidationResult.invoke(Boolean.valueOf(messageManager.editMessage(id2, channelId, textContent, chatInputViewModel$sendMessage$onMessageTooLong$1, Integer.valueOf(content != null ? content.length() : 0))));
            return;
        }
        if (z3 && zQ && zCanAccessRedesignedForumChannels$default) {
            createForumPostWithMessage(context, loaded.getChannelId(), messageManager, messageContent, attachmentsRequest, chatInputViewModel$sendMessage$onMessageTooLong$1, chatInputViewModel$sendMessage$onFilesTooLarge$1);
            return;
        }
        if (!z3) {
            chatInputViewModel$sendMessage$sendMessage$1.invoke(Long.valueOf(loaded.getChannelId()));
            return;
        }
        String threadName = loaded.getThreadDraftState().getThreadName();
        if (threadName != null && threadName.length() != 0) {
            z2 = false;
        }
        if (z2) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(loaded.getThreadDraftState(), false, null, null, false, true, 15, null));
            return;
        }
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft = loaded.getSelectedThreadDraft();
        Long starterMessageId = selectedThreadDraft != null ? selectedThreadDraft.getStarterMessageId() : null;
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft selectedThreadDraft2 = loaded.getSelectedThreadDraft();
        createAndGotoThread(context, starterMessageId, selectedThreadDraft2 != null ? selectedThreadDraft2.getThreadStartLocation() : null, loaded, new AnonymousClass1(chatInputViewModel$sendMessage$sendMessage$1));
    }

    public final void sendSticker(Sticker sticker, MessageManager messageManager) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(messageManager, "messageManager");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !loaded.getAbleToSendMessage()) {
            return;
        }
        this.storeStickers.onStickerUsed(sticker);
        MessageManager.sendMessage$default(messageManager, null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
    }

    public final AttachmentContext toAttachmentContext(List<? extends Attachment<?>> list, Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        m.checkNotNullParameter(list, "$this$toAttachmentContext");
        m.checkNotNullParameter(context, "context");
        ArrayList<Attachment> arrayList = new ArrayList(list);
        if (arrayList.isEmpty()) {
            z2 = false;
        } else {
            for (Attachment attachment : arrayList) {
                m.checkNotNullExpressionValue(attachment, "attachment");
                if (AttachmentUtilsKt.isImage(attachment, context.getContentResolver())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (arrayList.isEmpty()) {
            z3 = false;
        } else {
            for (Attachment attachment2 : arrayList) {
                m.checkNotNullExpressionValue(attachment2, "attachment");
                if (AttachmentUtilsKt.isVideo(attachment2, context.getContentResolver())) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if (arrayList.isEmpty()) {
            z4 = false;
        } else {
            for (Attachment attachment3 : arrayList) {
                m.checkNotNullExpressionValue(attachment3, "attachment");
                if (AttachmentUtilsKt.isGif(attachment3, context.getContentResolver())) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Uri uri = ((Attachment) it.next()).getUri();
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            arrayList2.add(Float.valueOf(SendUtilsKt.computeFileSizeMegabytes(uri, contentResolver)));
        }
        float fSumOfFloat = u.sumOfFloat(arrayList2);
        Float fM111maxOrNull = u.m111maxOrNull((Iterable<Float>) arrayList2);
        return new AttachmentContext(arrayList, z2, z3, z4, arrayList2, fSumOfFloat, fM111maxOrNull != null ? fM111maxOrNull.floatValue() : 0.0f);
    }

    public final void togglePendingReplyShouldMention() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            ViewState.Loaded.PendingReplyState pendingReplyState = loaded.getPendingReplyState();
            ViewState.Loaded.PendingReplyState.Replying replying = (ViewState.Loaded.PendingReplyState.Replying) (pendingReplyState instanceof ViewState.Loaded.PendingReplyState.Replying ? pendingReplyState : null);
            if (replying != null) {
                StorePendingReplies storePendingReplies = this.storePendingReplies;
                Long channelId = replying.getMessageReference().getChannelId();
                m.checkNotNull(channelId);
                storePendingReplies.onSetPendingReplyShouldMention(channelId.longValue(), !replying.getShouldMention());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void verifyAccount(Context context) {
        Unit unit;
        m.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            int iOrdinal = loaded.getVerificationLevelTriggered().ordinal();
            if (iOrdinal == 0) {
                unit = Unit.a;
            } else if (iOrdinal == 1) {
                WidgetUserEmailVerify.INSTANCE.launch(context, WidgetUserAccountVerifyBase.Mode.UNFORCED);
                unit = Unit.a;
            } else if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                WidgetUserPhoneManage.INSTANCE.launch(context, WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.GUILD_PHONE_REQUIRED);
                unit = Unit.a;
            }
            KotlinExtensionsKt.getExhaustive(unit);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel(StoreChat storeChat, StoreChannels storeChannels, StoreMessagesLoader storeMessagesLoader, StoreLurking storeLurking, StoreStickers storeStickers, StorePendingReplies storePendingReplies, StoreApplicationInteractions storeApplicationInteractions, StoreApplicationCommands storeApplicationCommands, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreUserSettings storeUserSettings, StoreAnalytics storeAnalytics, StoreThreadDraft storeThreadDraft, StoreGuilds storeGuilds, boolean z2, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        m.checkNotNullParameter(storeChat, "storeChat");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeMessagesLoader, "storeMessagesLoader");
        m.checkNotNullParameter(storeLurking, "storeLurking");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        m.checkNotNullParameter(storeApplicationCommands, "storeApplicationCommands");
        m.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandsFrecency");
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeThreadDraft, "storeThreadDraft");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeChat = storeChat;
        this.storeChannels = storeChannels;
        this.storeMessagesLoader = storeMessagesLoader;
        this.storeLurking = storeLurking;
        this.storeStickers = storeStickers;
        this.storePendingReplies = storePendingReplies;
        this.storeApplicationInteractions = storeApplicationInteractions;
        this.storeApplicationCommands = storeApplicationCommands;
        this.storeApplicationCommandsFrecency = storeApplicationCommandFrecency;
        this.storeUserSettings = storeUserSettings;
        this.storeAnalytics = storeAnalytics;
        this.storeThreadDraft = storeThreadDraft;
        this.storeGuilds = storeGuilds;
        this.isEmojiAutocompleteUpsellEnabled = z2;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeChat.observeEvents(), this, null, 2, null), ChatInputViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
