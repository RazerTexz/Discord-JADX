package com.discord.utilities.messagesend;

import com.discord.models.message.Message;
import com.discord.utilities.error.Error;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MessageQueue.kt */
/* renamed from: com.discord.utilities.messagesend.MessageResult, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class MessageQueue4 {

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$AutoModBlock */
    public static final class AutoModBlock extends MessageQueue4 {
        private final Error error;
        private final Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoModBlock(Error error, Message message) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
            this.message = message;
        }

        public final Error getError() {
            return this.error;
        }

        public final Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$CaptchaRequired */
    public static final class CaptchaRequired extends MessageQueue4 {
        private final long channelId;
        private final Error error;
        private final String nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptchaRequired(Error error, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
            this.channelId = j;
            this.nonce = str;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Error getError() {
            return this.error;
        }

        public final String getNonce() {
            return this.nonce;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$NetworkFailure */
    public static final class NetworkFailure extends MessageQueue4 {
        public static final NetworkFailure INSTANCE = new NetworkFailure();

        private NetworkFailure() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$NoValidContent */
    public static final class NoValidContent extends MessageQueue4 {
        public static final NoValidContent INSTANCE = new NoValidContent();

        private NoValidContent() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$RateLimited */
    public static final class RateLimited extends MessageQueue4 {
        private final long retryAfterMs;

        public RateLimited(long j) {
            super(null);
            this.retryAfterMs = j;
        }

        public final long getRetryAfterMs() {
            return this.retryAfterMs;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Slowmode */
    public static final class Slowmode extends MessageQueue4 {
        private final long cooldownMs;

        public Slowmode(long j) {
            super(null);
            this.cooldownMs = j;
        }

        public final long getCooldownMs() {
            return this.cooldownMs;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Success */
    public static final class Success extends MessageQueue4 {
        private final com.discord.api.message.Message message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(com.discord.api.message.Message message) {
            super(null);
            Intrinsics3.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$Timeout */
    public static final class Timeout extends MessageQueue4 {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$UnknownFailure */
    public static final class UnknownFailure extends MessageQueue4 {
        private final Error error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownFailure(Error error) {
            super(null);
            Intrinsics3.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Error getError() {
            return this.error;
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$UserCancelled */
    public static final class UserCancelled extends MessageQueue4 {
        public static final UserCancelled INSTANCE = new UserCancelled();

        private UserCancelled() {
            super(null);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageResult$ValidationError */
    public static final class ValidationError extends MessageQueue4 {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidationError(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    private MessageQueue4() {
    }

    public /* synthetic */ MessageQueue4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
