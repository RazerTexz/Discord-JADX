package com.discord.utilities.messagesend;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageQueue.kt */
/* renamed from: com.discord.utilities.messagesend.MessageRequest, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class MessageQueue3 {
    private final long attemptTimestamp;
    private final Function2<MessageQueue4, Boolean, Unit> onCompleted;
    private final String requestId;

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$Edit */
    public static final class Edit extends MessageQueue3 {
        private final MessageAllowedMentions allowedMentions;
        private final long channelId;
        private final String content;
        private final long messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edit(long j, String str, long j2, MessageAllowedMentions messageAllowedMentions, long j3, Function2<? super MessageQueue4, ? super Boolean, Unit> function2) {
            super(String.valueOf(j2), function2, j3, null);
            Intrinsics3.checkNotNullParameter(str, "content");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            this.channelId = j;
            this.content = str;
            this.messageId = j2;
            this.allowedMentions = messageAllowedMentions;
        }

        public final MessageAllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getContent() {
            return this.content;
        }

        public final long getMessageId() {
            return this.messageId;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$Send */
    public static final class Send extends MessageQueue3 {
        private final Activity activity;
        private final List<Attachment<?>> attachments;
        private final Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public Send(Message message, Activity activity, List<? extends Attachment<?>> list, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function12, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            Intrinsics3.checkNotNullParameter(function1, "onPreprocessing");
            Intrinsics3.checkNotNullParameter(function12, "onProgress");
            String nonce = message.getNonce();
            Intrinsics3.checkNotNull(nonce);
            super(nonce, function2, j, null);
            this.message = message;
            this.activity = activity;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function12;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }

        public final MessageQueue4.ValidationError validateMessage() {
            if (this.message.getActivity() != null) {
                List<Attachment<?>> list = this.attachments;
                if (!(list == null || list.isEmpty())) {
                    return new MessageQueue4.ValidationError("Cannot send attachments with activity action");
                }
            }
            return null;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageRequest$SendApplicationCommand */
    public static final class SendApplicationCommand extends MessageQueue3 {
        private final ApplicationCommandLocalSendData applicationCommandSendData;
        private final List<Attachment<?>> attachments;
        private final com.discord.api.message.Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public SendApplicationCommand(com.discord.api.message.Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> list, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function12, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandSendData");
            Intrinsics3.checkNotNullParameter(function1, "onPreprocessing");
            Intrinsics3.checkNotNullParameter(function12, "onProgress");
            Intrinsics3.checkNotNullParameter(function2, "onCompleted");
            String nonce = message.getNonce();
            super(nonce == null ? String.valueOf(applicationCommandLocalSendData.getNonce()) : nonce, function2, j, null);
            this.message = message;
            this.applicationCommandSendData = applicationCommandLocalSendData;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function12;
        }

        public final ApplicationCommandLocalSendData getApplicationCommandSendData() {
            return this.applicationCommandSendData;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageQueue3(String str, Function2<? super MessageQueue4, ? super Boolean, Unit> function2, long j) {
        this.requestId = str;
        this.onCompleted = function2;
        this.attemptTimestamp = j;
    }

    public final long getAttemptTimestamp() {
        return this.attemptTimestamp;
    }

    public final Function2<MessageQueue4, Boolean, Unit> getOnCompleted() {
        return this.onCompleted;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ MessageQueue3(String str, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function2, j);
    }
}
