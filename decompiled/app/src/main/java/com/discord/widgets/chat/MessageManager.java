package com.discord.widgets.chat;

import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.d.b.a.a;
import com.discord.api.message.MessageReference;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.t.k;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: MessageManager.kt */
/* loaded from: classes2.dex */
public final class MessageManager {
    private final Context context;
    private final Function1<MessageSendResult, Unit> defaultMessageResultHandler;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuilds storeGuilds;
    private final StoreMessageReplies storeMessageReplies;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreSlowMode storeSlowMode;
    private final StoreUser storeUser;

    /* compiled from: MessageManager.kt */
    public static abstract class AttachmentValidationResult {

        /* compiled from: MessageManager.kt */
        public static final class EmptyAttachments extends AttachmentValidationResult {
            public static final EmptyAttachments INSTANCE = new EmptyAttachments();

            private EmptyAttachments() {
                super(null);
            }
        }

        /* compiled from: MessageManager.kt */
        public static final /* data */ class FilesTooLarge extends AttachmentValidationResult {
            private final AttachmentsRequest attachmentsRequest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesTooLarge(AttachmentsRequest attachmentsRequest) {
                super(null);
                m.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                this.attachmentsRequest = attachmentsRequest;
            }

            public static /* synthetic */ FilesTooLarge copy$default(FilesTooLarge filesTooLarge, AttachmentsRequest attachmentsRequest, int i, Object obj) {
                if ((i & 1) != 0) {
                    attachmentsRequest = filesTooLarge.attachmentsRequest;
                }
                return filesTooLarge.copy(attachmentsRequest);
            }

            /* renamed from: component1, reason: from getter */
            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public final FilesTooLarge copy(AttachmentsRequest attachmentsRequest) {
                m.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                return new FilesTooLarge(attachmentsRequest);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FilesTooLarge) && m.areEqual(this.attachmentsRequest, ((FilesTooLarge) other).attachmentsRequest);
                }
                return true;
            }

            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public int hashCode() {
                AttachmentsRequest attachmentsRequest = this.attachmentsRequest;
                if (attachmentsRequest != null) {
                    return attachmentsRequest.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("FilesTooLarge(attachmentsRequest=");
                sbU.append(this.attachmentsRequest);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: MessageManager.kt */
        public static final class Success extends AttachmentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private AttachmentValidationResult() {
        }

        public /* synthetic */ AttachmentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageManager.kt */
    public static final class AttachmentsRequest {
        private final List<Attachment<?>> attachments;
        private final float currentFileSizeMB;
        private final int maxFileSizeMB;

        /* JADX WARN: Multi-variable type inference failed */
        public AttachmentsRequest(float f, int i, List<? extends Attachment<?>> list) {
            this.currentFileSizeMB = f;
            this.maxFileSizeMB = i;
            this.attachments = list;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        public final int getMaxFileSizeMB() {
            return this.maxFileSizeMB;
        }

        public /* synthetic */ AttachmentsRequest(float f, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, i, (i2 & 4) != 0 ? null : list);
        }
    }

    /* compiled from: MessageManager.kt */
    public static abstract class ContentValidationResult {

        /* compiled from: MessageManager.kt */
        public static final class EmptyContent extends ContentValidationResult {
            public static final EmptyContent INSTANCE = new EmptyContent();

            private EmptyContent() {
                super(null);
            }
        }

        /* compiled from: MessageManager.kt */
        public static final /* data */ class MessageTooLong extends ContentValidationResult {
            private final int maxMessageLength;

            public MessageTooLong(int i) {
                super(null);
                this.maxMessageLength = i;
            }

            public static /* synthetic */ MessageTooLong copy$default(MessageTooLong messageTooLong, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = messageTooLong.maxMessageLength;
                }
                return messageTooLong.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public final MessageTooLong copy(int maxMessageLength) {
                return new MessageTooLong(maxMessageLength);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MessageTooLong) && this.maxMessageLength == ((MessageTooLong) other).maxMessageLength;
                }
                return true;
            }

            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public int hashCode() {
                return this.maxMessageLength;
            }

            public String toString() {
                return a.B(a.U("MessageTooLong(maxMessageLength="), this.maxMessageLength, ")");
            }
        }

        /* compiled from: MessageManager.kt */
        public static final class Success extends ContentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private ContentValidationResult() {
        }

        public /* synthetic */ ContentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MessageManager.kt */
    public static final /* data */ class MessageSendResult {
        private final Guild guild;
        private final MessageResult messageResult;

        public MessageSendResult(MessageResult messageResult, Guild guild) {
            m.checkNotNullParameter(messageResult, "messageResult");
            this.messageResult = messageResult;
            this.guild = guild;
        }

        public static /* synthetic */ MessageSendResult copy$default(MessageSendResult messageSendResult, MessageResult messageResult, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                messageResult = messageSendResult.messageResult;
            }
            if ((i & 2) != 0) {
                guild = messageSendResult.guild;
            }
            return messageSendResult.copy(messageResult, guild);
        }

        /* renamed from: component1, reason: from getter */
        public final MessageResult getMessageResult() {
            return this.messageResult;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageSendResult copy(MessageResult messageResult, Guild guild) {
            m.checkNotNullParameter(messageResult, "messageResult");
            return new MessageSendResult(messageResult, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageSendResult)) {
                return false;
            }
            MessageSendResult messageSendResult = (MessageSendResult) other;
            return m.areEqual(this.messageResult, messageSendResult.messageResult) && m.areEqual(this.guild, messageSendResult.guild);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageResult getMessageResult() {
            return this.messageResult;
        }

        public int hashCode() {
            MessageResult messageResult = this.messageResult;
            int iHashCode = (messageResult != null ? messageResult.hashCode() : 0) * 31;
            Guild guild = this.guild;
            return iHashCode + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("MessageSendResult(messageResult=");
            sbU.append(this.messageResult);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MessageManager.kt */
    /* renamed from: com.discord.widgets.chat.MessageManager$sendCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: MessageManager.kt */
    /* renamed from: com.discord.widgets.chat.MessageManager$sendCommand$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
        }
    }

    /* compiled from: MessageManager.kt */
    /* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<MessageResult, Guild, MessageSendResult> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ MessageSendResult call(MessageResult messageResult, Guild guild) {
            return call2(messageResult, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final MessageSendResult call2(MessageResult messageResult, Guild guild) {
            m.checkNotNullExpressionValue(messageResult, "messageResult");
            return new MessageSendResult(messageResult, guild);
        }
    }

    /* compiled from: MessageManager.kt */
    /* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<MessageSendResult, Unit> {
        public final /* synthetic */ Function1 $messageSendResultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$messageSendResultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageSendResult messageSendResult) {
            invoke2(messageSendResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageSendResult messageSendResult) {
            Function1 function1 = this.$messageSendResultHandler;
            m.checkNotNullExpressionValue(messageSendResult, "messageSendResult");
            function1.invoke(messageSendResult);
        }
    }

    public MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeSlowMode, "storeSlowMode");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeMessageReplies, "storeMessageReplies");
        this.context = context;
        this.storeMessages = storeMessages;
        this.storeApplicationInteractions = storeApplicationInteractions;
        this.storeUser = storeUser;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeSlowMode = storeSlowMode;
        this.storeGuilds = storeGuilds;
        this.storePendingReplies = storePendingReplies;
        this.storeMessageReplies = storeMessageReplies;
        this.defaultMessageResultHandler = new MessageManager$defaultMessageResultHandler$1(this);
    }

    public static final /* synthetic */ Context access$getContext$p(MessageManager messageManager) {
        return messageManager.context;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(MessageManager messageManager) {
        return messageManager.storeMessages;
    }

    public static final /* synthetic */ StorePendingReplies access$getStorePendingReplies$p(MessageManager messageManager) {
        return messageManager.storePendingReplies;
    }

    public static /* synthetic */ boolean editMessage$default(MessageManager messageManager, long j, long j2, String str, Function2 function2, Integer num, int i, Object obj) {
        return messageManager.editMessage(j, j2, str, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : num);
    }

    private final MessageAllowedMentions getAllowedMentionsForMessageEdit(long channelId, long messageId) {
        Integer type;
        MessageReference messageReference;
        Long messageId2;
        Message message = this.storeMessages.getMessage(channelId, messageId);
        if (message != null && (type = message.getType()) != null && type.intValue() == 19 && (messageReference = message.getMessageReference()) != null && (messageId2 = messageReference.getMessageId()) != null) {
            StoreMessageReplies.MessageState messageState = this.storeMessageReplies.getAllMessageReferences().get(Long.valueOf(messageId2.longValue()));
            if (messageState == null || !(messageState instanceof StoreMessageReplies.MessageState.Loaded)) {
                return null;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                boolean z2 = false;
                if (!mentions.isEmpty()) {
                    Iterator<T> it = mentions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        long id2 = ((User) it.next()).getId();
                        User author = ((StoreMessageReplies.MessageState.Loaded) messageState).getMessage().getAuthor();
                        if (author != null && id2 == author.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return null;
                }
            }
            return new MessageAllowedMentions(k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6);
        }
        return null;
    }

    public static /* synthetic */ boolean isValidForumPostFirstMessage$default(MessageManager messageManager, String str, AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            attachmentsRequest = null;
        }
        return messageManager.isValidForumPostFirstMessage(str, attachmentsRequest, function2, function22);
    }

    public static /* synthetic */ boolean sendCommand$default(MessageManager messageManager, long j, Long l, String str, ApplicationCommandData applicationCommandData, AttachmentsRequest attachmentsRequest, Function0 function0, Function1 function1, Function2 function2, int i, Object obj) {
        return messageManager.sendCommand(j, l, str, applicationCommandData, (i & 16) != 0 ? null : attachmentsRequest, function0, function1, (i & 128) != 0 ? null : function2);
    }

    public static /* synthetic */ boolean sendMessage$default(MessageManager messageManager, String str, List list, AttachmentsRequest attachmentsRequest, Long l, List list2, boolean z2, Function2 function2, Function2 function22, Function1 function1, int i, Object obj) {
        return messageManager.sendMessage((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : attachmentsRequest, (i & 8) != 0 ? null : l, (i & 16) != 0 ? n.emptyList() : list2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : function2, (i & 128) == 0 ? function22 : null, (i & 256) != 0 ? messageManager.defaultMessageResultHandler : function1);
    }

    private final AttachmentValidationResult validateAttachments(AttachmentsRequest attachmentsRequest) {
        if (attachmentsRequest == null) {
            return AttachmentValidationResult.EmptyAttachments.INSTANCE;
        }
        List<Attachment<?>> attachments = attachmentsRequest.getAttachments();
        return (attachments == null || attachments.isEmpty()) ? AttachmentValidationResult.EmptyAttachments.INSTANCE : attachmentsRequest.getCurrentFileSizeMB() >= ((float) attachmentsRequest.getMaxFileSizeMB()) ? new AttachmentValidationResult.FilesTooLarge(attachmentsRequest) : AttachmentValidationResult.Success.INSTANCE;
    }

    private final ContentValidationResult validateMessageContent(String content, List<? extends BaseSticker> stickers, MeUser meUser, boolean isEditing, Integer previousMessageLength) {
        boolean z2 = true;
        int i = (UserUtils.INSTANCE.isPremiumTier2(meUser) || (isEditing && previousMessageLength != null && previousMessageLength.intValue() > 2000)) ? SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 2000;
        if (content.length() == 0) {
            if (stickers != null && !stickers.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                return ContentValidationResult.EmptyContent.INSTANCE;
            }
        }
        return content.length() > i ? new ContentValidationResult.MessageTooLong(i) : ContentValidationResult.Success.INSTANCE;
    }

    public static /* synthetic */ ContentValidationResult validateMessageContent$default(MessageManager messageManager, String str, List list, MeUser meUser, boolean z2, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
        }
        return messageManager.validateMessageContent(str, list, meUser, z2, num);
    }

    public final boolean editMessage(long messageId, long channelId, String content, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Integer previousMessageLength) {
        m.checkNotNullParameter(content, "content");
        ContentValidationResult contentValidationResultValidateMessageContent = validateMessageContent(content, n.emptyList(), this.storeUser.getMeSnapshot(), true, previousMessageLength);
        if (contentValidationResultValidateMessageContent instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent).getMaxMessageLength()));
            }
            return false;
        }
        if (m.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.EmptyContent.INSTANCE)) {
            return false;
        }
        m.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.Success.INSTANCE);
        this.storeMessages.editMessage(messageId, channelId, content, getAllowedMentionsForMessageEdit(channelId, messageId));
        return true;
    }

    public final boolean isValidForumPostFirstMessage(String content, AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        m.checkNotNullParameter(content, "content");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, n.emptyList(), meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            return true;
        }
        if (onFilesTooLarge != null) {
            onFilesTooLarge.invoke(Integer.valueOf(((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest().getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        }
        return false;
    }

    public final boolean sendCommand(long channelId, Long guildId, String version, ApplicationCommandData data, AttachmentsRequest attachmentRequest, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFail, "onFail");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            this.storeApplicationInteractions.sendApplicationCommand(channelId, guildId, version, data, attachmentRequest != null ? attachmentRequest.getAttachments() : null, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
            return true;
        }
        AttachmentsRequest attachmentsRequest = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
        if (onFilesTooLarge == null) {
            return false;
        }
        onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        return false;
    }

    public final boolean sendMessage(String content, List<? extends com.discord.models.user.User> mentions, AttachmentsRequest attachmentsRequest, Long channelId, List<? extends BaseSticker> stickers, boolean consumePendingReply, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge, Function1<? super MessageSendResult, Unit> messageSendResultHandler) {
        ShortcutManager shortcutManager;
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(messageSendResultHandler, "messageSendResultHandler");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, stickers, meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge) {
            AttachmentsRequest attachmentsRequest2 = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
            if (onFilesTooLarge != null) {
                onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest2.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
            }
            return false;
        }
        List<Attachment<?>> attachments = attachmentsRequest != null ? attachmentsRequest.getAttachments() : null;
        long jLongValue = channelId != null ? channelId.longValue() : this.storeChannelsSelected.getId();
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.context);
            m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(dynamicShortcuts, 10));
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                arrayList.add(shortcutInfoCompat.getId());
            }
            if (u.toSet(arrayList).contains(String.valueOf(jLongValue)) && (shortcutManager = (ShortcutManager) this.context.getSystemService(ShortcutManager.class)) != null) {
                shortcutManager.reportShortcutUsed(String.valueOf(jLongValue));
            }
        }
        StorePendingReplies.PendingReply pendingReply = consumePendingReply ? this.storePendingReplies.getPendingReply(jLongValue) : null;
        Observable observableZ = Observable.j(this.storeSlowMode.observeCooldownSecs(channelId, StoreSlowMode.Type.MessageSend.INSTANCE).Z(1).Y(new MessageManager$sendMessage$messageResultObservable$1(this, pendingReply, jLongValue, meSnapshot, content, mentions, attachments, stickers, (pendingReply == null || pendingReply.getShouldMention()) ? null : new MessageAllowedMentions(k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6))), this.storeGuilds.observeFromChannelId(jLongValue), AnonymousClass1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…d)\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableZ, false, 1, null)), MessageManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(messageSendResultHandler), 62, (Object) null);
        return true;
    }

    public /* synthetic */ MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages, (i & 4) != 0 ? StoreStream.INSTANCE.getInteractions() : storeApplicationInteractions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getSlowMode() : storeSlowMode, (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies, (i & 256) != 0 ? StoreStream.INSTANCE.getRepliedMessages() : storeMessageReplies);
    }
}
