package com.discord.utilities.messagesend;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.Clock;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DEFAULT_MESSAGE_TIMEOUT_MS = 3600000;

    @Deprecated
    private static final long DEFAULT_NETWORK_INITIAL_FAILURE_RETRY_MS = 5000;

    @Deprecated
    private static final long DEFAULT_RETRY_MS = 100;
    private final Clock clock;
    private final ContentResolver contentResolver;
    private final ExecutorService executorService;
    private InflightRequest inFlightRequest;
    private boolean isDraining;
    private final Backoff networkBackoff;
    private final ArrayDeque<MessageQueue3> queue;
    private Subscription retrySubscription;

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class DrainListener {
        private AtomicBoolean isCompleted;
        private final Function1<MessageQueue4, Unit> onCompleted;

        /* JADX WARN: Multi-variable type inference failed */
        public DrainListener(Function1<? super MessageQueue4, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "onCompleted");
            this.onCompleted = function1;
            this.isCompleted = new AtomicBoolean(false);
        }

        public final synchronized void complete(MessageQueue4 result) {
            Intrinsics3.checkNotNullParameter(result, "result");
            if (!this.isCompleted.getAndSet(true)) {
                this.onCompleted.invoke(result);
            }
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class InflightRequest {
        private final MessageQueue3 baseRequest;
        private final DrainListener drainListener;
        private final Subscription networkSubscription;

        public InflightRequest(MessageQueue3 messageQueue3, Subscription subscription, DrainListener drainListener) {
            Intrinsics3.checkNotNullParameter(messageQueue3, "baseRequest");
            Intrinsics3.checkNotNullParameter(subscription, "networkSubscription");
            Intrinsics3.checkNotNullParameter(drainListener, "drainListener");
            this.baseRequest = messageQueue3;
            this.networkSubscription = subscription;
            this.drainListener = drainListener;
        }

        public final MessageQueue3 getBaseRequest() {
            return this.baseRequest;
        }

        public final DrainListener getDrainListener() {
            return this.drainListener;
        }

        public final Subscription getNetworkSubscription() {
            return this.networkSubscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$cancel$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class RunnableC67951 implements Runnable {
        public final /* synthetic */ String $requestId;

        public RunnableC67951(String str) {
            this.$requestId = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object next;
            InflightRequest inflightRequestAccess$getInFlightRequest$p = MessageQueue.access$getInFlightRequest$p(MessageQueue.this);
            if (inflightRequestAccess$getInFlightRequest$p != null && Intrinsics3.areEqual(inflightRequestAccess$getInFlightRequest$p.getBaseRequest().getRequestId(), this.$requestId)) {
                inflightRequestAccess$getInFlightRequest$p.getNetworkSubscription().unsubscribe();
                inflightRequestAccess$getInFlightRequest$p.getDrainListener().complete(MessageQueue4.UserCancelled.INSTANCE);
                return;
            }
            Iterator it = MessageQueue.access$getQueue$p(MessageQueue.this).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics3.areEqual(((MessageQueue3) next).getRequestId(), this.$requestId)) {
                        break;
                    }
                }
            }
            MessageQueue3 messageQueue3 = (MessageQueue3) next;
            if (messageQueue3 != null) {
                MessageQueue.access$getQueue$p(MessageQueue.this).remove(messageQueue3);
                messageQueue3.getOnCompleted().invoke(MessageQueue4.UserCancelled.INSTANCE, Boolean.valueOf(MessageQueue.access$getQueue$p(MessageQueue.this).isEmpty()));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$2 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C67962 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67962(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            MessageQueue.access$handleSuccess(MessageQueue.this, message, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$3 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C67973 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67973(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doEdit$4 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C67984 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Edit $editRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67984(MessageQueue3.Edit edit, DrainListener drainListener) {
            super(1);
            this.$editRequest = edit;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$editRequest, subscription, this.$drainListener));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C67991<T> implements Action1<SendUtils.SendPayload> {
        public final /* synthetic */ MessageQueue3.Send $request;

        public C67991(MessageQueue3.Send send) {
            this.$request = send;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(SendUtils.SendPayload sendPayload) {
            call2(sendPayload);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(SendUtils.SendPayload sendPayload) {
            if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                this.$request.getOnPreprocessing().invoke(sendPayload);
            } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSend) {
                SendUtils.SendPayload.ReadyToSend readyToSend = (SendUtils.SendPayload.ReadyToSend) sendPayload;
                if (!readyToSend.getUploads().isEmpty()) {
                    this.$request.getOnProgress().invoke(readyToSend.getUploads());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$2 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68002<T, R> implements Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Message>> {
        public final /* synthetic */ com.discord.models.message.Message $message;

        public C68002(com.discord.models.message.Message message) {
            this.$message = message;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Message> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
            return call2(readyToSend);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Message> call2(SendUtils.SendPayload.ReadyToSend readyToSend) {
            List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            if (!(!arrayList.isEmpty())) {
                return RestAPI.INSTANCE.getApi().sendMessage(this.$message.getChannelId(), readyToSend.getMessage());
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long channelId = this.$message.getChannelId();
            PayloadJSON<RestAPIParams.Message> payloadJSON = new PayloadJSON<>(readyToSend.getMessage());
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.sendMessage(channelId, payloadJSON, (MultipartBody.Part[]) array);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$3 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68013 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68013(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            MessageQueue messageQueue = MessageQueue.this;
            Intrinsics3.checkNotNullExpressionValue(message, "resultMessage");
            MessageQueue.access$handleSuccess(messageQueue, message, this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$4 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68024 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ com.discord.models.message.Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68024(DrainListener drainListener, com.discord.models.message.Message message) {
            super(1);
            this.$drainListener = drainListener;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.access$handleError(MessageQueue.this, error, this.$drainListener, this.$message);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSend$5 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68035 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.Send $request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68035(MessageQueue3.Send send, DrainListener drainListener) {
            super(1);
            this.$request = send;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$request, subscription, this.$drainListener));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68041<T> implements Action1<SendUtils.SendPayload> {
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        public C68041(MessageQueue3.SendApplicationCommand sendApplicationCommand) {
            this.$sendApplicationCommandRequest = sendApplicationCommand;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(SendUtils.SendPayload sendPayload) {
            call2(sendPayload);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(SendUtils.SendPayload sendPayload) {
            if (sendPayload instanceof SendUtils.SendPayload.Preprocessing) {
                this.$sendApplicationCommandRequest.getOnPreprocessing().invoke(sendPayload);
            } else if (sendPayload instanceof SendUtils.SendPayload.ReadyToSendCommand) {
                SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand = (SendUtils.SendPayload.ReadyToSendCommand) sendPayload;
                if (!readyToSendCommand.getUploads().isEmpty()) {
                    this.$sendApplicationCommandRequest.getOnProgress().invoke(readyToSendCommand.getUploads());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$2 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68052<T, R> implements Func1<SendUtils.SendPayload.ReadyToSendCommand, Observable<? extends Void>> {
        public static final C68052 INSTANCE = new C68052();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand) {
            return call2(readyToSendCommand);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(SendUtils.SendPayload.ReadyToSendCommand readyToSendCommand) {
            List<SendUtils.FileUpload> uploads = readyToSendCommand.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            if (!(!arrayList.isEmpty())) {
                return RestAPI.INSTANCE.getApi().sendApplicationCommand(readyToSendCommand.getCommand().toRestApiParam());
            }
            PayloadJSON<RestAPIParams.ApplicationCommand> payloadJSON = new PayloadJSON<>(readyToSendCommand.getCommand().toRestApiParam());
            RestAPI api = RestAPI.INSTANCE.getApi();
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.sendApplicationCommand(payloadJSON, (MultipartBody.Part[]) array);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$3 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68063 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68063(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            MessageQueue.access$handleSuccess(MessageQueue.this, this.$sendApplicationCommandRequest.getMessage(), this.$drainListener);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$4 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68074 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ DrainListener $drainListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68074(DrainListener drainListener) {
            super(1);
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MessageQueue.handleError$default(MessageQueue.this, error, this.$drainListener, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$doSendApplicationCommand$5 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class C68085 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ DrainListener $drainListener;
        public final /* synthetic */ MessageQueue3.SendApplicationCommand $sendApplicationCommandRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68085(MessageQueue3.SendApplicationCommand sendApplicationCommand, DrainListener drainListener) {
            super(1);
            this.$sendApplicationCommandRequest = sendApplicationCommand;
            this.$drainListener = drainListener;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            MessageQueue.access$setInFlightRequest$p(MessageQueue.this, new InflightRequest(this.$sendApplicationCommandRequest, subscription, this.$drainListener));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$enqueue$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class RunnableC68091 implements Runnable {
        public final /* synthetic */ MessageQueue3 $request;

        public RunnableC68091(MessageQueue3 messageQueue3) {
            this.$request = messageQueue3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$getQueue$p(MessageQueue.this).add(this.$request);
            MessageQueue.access$processNextRequest(MessageQueue.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.messagesend.MessageQueue$handleConnected$1 */
    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class RunnableC68101 implements Runnable {
        public RunnableC68101() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MessageQueue.access$getNetworkBackoff$p(MessageQueue.this).getIsPending()) {
                MessageQueue.access$getNetworkBackoff$p(MessageQueue.this).cancel();
                MessageQueue.access$processNextRequest(MessageQueue.this);
            }
        }
    }

    public MessageQueue(ContentResolver contentResolver, ExecutorService executorService, Clock clock) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(executorService, "executorService");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.contentResolver = contentResolver;
        this.executorService = executorService;
        this.clock = clock;
        this.queue = new ArrayDeque<>();
        this.networkBackoff = new Backoff(5000L, DEFAULT_MESSAGE_TIMEOUT_MS, 0, false, null, 28, null);
    }

    public static final /* synthetic */ ExecutorService access$getExecutorService$p(MessageQueue messageQueue) {
        return messageQueue.executorService;
    }

    public static final /* synthetic */ InflightRequest access$getInFlightRequest$p(MessageQueue messageQueue) {
        return messageQueue.inFlightRequest;
    }

    public static final /* synthetic */ Backoff access$getNetworkBackoff$p(MessageQueue messageQueue) {
        return messageQueue.networkBackoff;
    }

    public static final /* synthetic */ ArrayDeque access$getQueue$p(MessageQueue messageQueue) {
        return messageQueue.queue;
    }

    public static final /* synthetic */ Subscription access$getRetrySubscription$p(MessageQueue messageQueue) {
        return messageQueue.retrySubscription;
    }

    public static final /* synthetic */ void access$handleError(MessageQueue messageQueue, Error error, DrainListener drainListener, com.discord.models.message.Message message) {
        messageQueue.handleError(error, drainListener, message);
    }

    public static final /* synthetic */ void access$handleSuccess(MessageQueue messageQueue, Message message, DrainListener drainListener) {
        messageQueue.handleSuccess(message, drainListener);
    }

    public static final /* synthetic */ void access$onDrainingCompleted(MessageQueue messageQueue) {
        messageQueue.onDrainingCompleted();
    }

    public static final /* synthetic */ void access$processNextRequest(MessageQueue messageQueue) {
        messageQueue.processNextRequest();
    }

    public static final /* synthetic */ void access$setInFlightRequest$p(MessageQueue messageQueue, InflightRequest inflightRequest) {
        messageQueue.inFlightRequest = inflightRequest;
    }

    public static final /* synthetic */ void access$setRetrySubscription$p(MessageQueue messageQueue, Subscription subscription) {
        messageQueue.retrySubscription = subscription;
    }

    private final void doEdit(MessageQueue3.Edit editRequest, DrainListener drainListener) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long channelId = editRequest.getChannelId();
        long messageId = editRequest.getMessageId();
        String content = editRequest.getContent();
        MessageAllowedMentions allowedMentions = editRequest.getAllowedMentions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(api.editMessage(channelId, messageId, new RestAPIParams.Message(content, null, null, null, null, null, allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null, null, null, 444, null)), false), MessageQueue.class, (Context) null, new C67984(editRequest, drainListener), new C67973(drainListener), (Function0) null, (Function0) null, new C67962(drainListener), 50, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doSend(MessageQueue3.Send request, DrainListener drainListener) {
        RestAPIParams.Message.Activity activity;
        RestAPIParams.Message.MessageReference messageReference;
        ArrayList arrayList;
        ArrayList arrayList2;
        String sessionId;
        MessageQueue4.ValidationError validationErrorValidateMessage = request.validateMessage();
        if (validationErrorValidateMessage != null) {
            drainListener.complete(validationErrorValidateMessage);
            return;
        }
        com.discord.models.message.Message message = request.getMessage();
        boolean z2 = message.getNonce() != null;
        MessageActivity activity2 = message.getActivity();
        if (activity2 != null) {
            Activity activity3 = request.getActivity();
            activity = (activity3 == null || (sessionId = activity3.getSessionId()) == null) ? null : new RestAPIParams.Message.Activity(activity2.getType(), activity2.getPartyId(), sessionId);
        } else {
            activity = null;
        }
        MessageReference messageReference2 = message.getMessageReference();
        if (messageReference2 != null) {
            Long guildId = messageReference2.getGuildId();
            Long channelId = messageReference2.getChannelId();
            Intrinsics3.checkNotNull(channelId);
            messageReference = new RestAPIParams.Message.MessageReference(guildId, channelId.longValue(), messageReference2.getMessageId());
        } else {
            messageReference = null;
        }
        MessageAllowedMentions allowedMentions = message.getAllowedMentions();
        RestAPIParams.Message.AllowedMentions allowedMentionsCreate = allowedMentions != null ? RestAPIParams.Message.AllowedMentions.INSTANCE.create(allowedMentions) : null;
        String content = message.getContent();
        String nonce = message.getNonce();
        Application application = message.getApplication();
        Long lValueOf = application != null ? Long.valueOf(application.getId()) : null;
        List<StickerPartial> stickerItems = message.getStickerItems();
        if (stickerItems != null) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickerItems, 10));
            Iterator<T> it = stickerItems.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((StickerPartial) it.next()).getId()));
            }
        } else {
            List<Sticker> stickers = message.getStickers();
            if (stickers == null) {
                arrayList = null;
                CaptchaHelper.CaptchaPayload captchaPayload = message.getCaptchaPayload();
                String captchaKey = captchaPayload == null ? captchaPayload.getCaptchaKey() : null;
                CaptchaHelper.CaptchaPayload captchaPayload2 = message.getCaptchaPayload();
                Observable<SendUtils.SendPayload> observableM11115u = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null), request.getAttachments()).m11115u(new C67991(request));
                Intrinsics3.checkNotNullExpressionValue(observableM11115u, "SendUtils\n        .getSe…  }\n          }\n        }");
                Observable<R> observableM11083G = observableM11115u.m11118y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).m11083G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
                Observable observableM11082A = observableM11083G.m11100Z(1).m11082A(new C68002(message));
                Intrinsics3.checkNotNullExpressionValue(observableM11082A, "SendUtils\n        .getSe…ge)\n          }\n        }");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableM11082A, z2), MessageQueue.class, (Context) null, new C68035(request, drainListener), new C68024(drainListener, message), (Function0) null, (Function0) null, new C68013(drainListener), 50, (Object) null);
            }
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(stickers, 10));
            Iterator<T> it2 = stickers.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((Sticker) it2.next()).getId()));
            }
        }
        arrayList = arrayList2;
        CaptchaHelper.CaptchaPayload captchaPayload3 = message.getCaptchaPayload();
        if (captchaPayload3 == null) {
        }
        CaptchaHelper.CaptchaPayload captchaPayload22 = message.getCaptchaPayload();
        Observable<SendUtils.SendPayload> observableM11115u2 = SendUtils.INSTANCE.getSendPayload(this.contentResolver, new RestAPIParams.Message(content, nonce, lValueOf, activity, arrayList, messageReference, allowedMentionsCreate, captchaKey, captchaPayload22 != null ? captchaPayload22.getCaptchaRqtoken() : null), request.getAttachments()).m11115u(new C67991(request));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u2, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableM11083G2 = observableM11115u2.m11118y(MessageQueue$doSend$$inlined$filterIs$1.INSTANCE).m11083G(MessageQueue$doSend$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G2, "filter { it is T }.map { it as T }");
        Observable observableM11082A2 = observableM11083G2.m11100Z(1).m11082A(new C68002(message));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A2, "SendUtils\n        .getSe…ge)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(observableM11082A2, z2), MessageQueue.class, (Context) null, new C68035(request, drainListener), new C68024(drainListener, message), (Function0) null, (Function0) null, new C68013(drainListener), 50, (Object) null);
    }

    private final void doSendApplicationCommand(MessageQueue3.SendApplicationCommand sendApplicationCommandRequest, DrainListener drainListener) {
        Observable<SendUtils.SendPayload> observableM11115u = SendUtils.INSTANCE.getSendCommandPayload(this.contentResolver, sendApplicationCommandRequest.getApplicationCommandSendData(), sendApplicationCommandRequest.getAttachments()).m11115u(new C68041(sendApplicationCommandRequest));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "SendUtils\n        .getSe…  }\n          }\n        }");
        Observable<R> observableM11083G = observableM11115u.m11118y(MessageQueue$doSendApplicationCommand$$inlined$filterIs$1.INSTANCE).m11083G(MessageQueue$doSendApplicationCommand$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        Observable observableM11082A = observableM11083G.m11119z().m11082A(C68052.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "SendUtils\n        .getSe…())\n          }\n        }");
        Observable observableRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(observableM11082A, false);
        C68063 c68063 = new C68063(sendApplicationCommandRequest, drainListener);
        ObservableExtensionsKt.appSubscribe$default(observableRestSubscribeOn, MessageQueue.class, (Context) null, new C68085(sendApplicationCommandRequest, drainListener), new C68074(drainListener), (Function0) null, (Function0) null, c68063, 50, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleError(Error error, DrainListener onDrainListener, com.discord.models.message.Message clientMessage) {
        MessageQueue4 unknownFailure;
        MessageQueue4 autoModBlock;
        Long l;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() == 20016) {
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            Long retryAfterMs = response2.getRetryAfterMs();
            l = retryAfterMs != null ? retryAfterMs : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.Slowmode(l.longValue());
        } else if (error.getType() == Error.Type.RATE_LIMITED) {
            Error.Response response3 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs2 = response3.getRetryAfterMs();
            l = retryAfterMs2 != null ? retryAfterMs2 : 100L;
            Intrinsics3.checkNotNullExpressionValue(l, "error.response.retryAfterMs ?: DEFAULT_RETRY_MS");
            unknownFailure = new MessageQueue4.RateLimited(l.longValue());
        } else if (error.getType() == Error.Type.NETWORK) {
            unknownFailure = MessageQueue4.NetworkFailure.INSTANCE;
        } else if (error.getType() == Error.Type.DISCORD_BAD_REQUEST) {
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "error.response");
            if (!response4.getMessages().containsKey(CaptchaHelper.CAPTCHA_KEY) || clientMessage == null) {
                Error.Response response5 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response5, "error.response");
                if (response5.getCode() == 200000) {
                    autoModBlock = new MessageQueue4.AutoModBlock(error, clientMessage);
                } else {
                    unknownFailure = new MessageQueue4.UnknownFailure(error);
                }
            } else {
                autoModBlock = new MessageQueue4.CaptchaRequired(error, clientMessage.getChannelId(), clientMessage.getNonce());
            }
            unknownFailure = autoModBlock;
        }
        onDrainListener.complete(unknownFailure);
    }

    public static /* synthetic */ void handleError$default(MessageQueue messageQueue, Error error, DrainListener drainListener, com.discord.models.message.Message message, int i, Object obj) {
        if ((i & 4) != 0) {
            message = null;
        }
        messageQueue.handleError(error, drainListener, message);
    }

    private final void handleSuccess(Message message, DrainListener drainListener) {
        drainListener.complete(new MessageQueue4.Success(message));
    }

    private final void onDrainingCompleted() {
        this.isDraining = false;
        this.inFlightRequest = null;
    }

    private final void processNextRequest() {
        MessageQueue3 messageQueue3Remove;
        if (this.queue.isEmpty() || this.retrySubscription != null || this.networkBackoff.getIsPending() || this.isDraining || (messageQueue3Remove = this.queue.remove()) == null) {
            return;
        }
        if (this.clock.currentTimeMillis() - messageQueue3Remove.getAttemptTimestamp() > DEFAULT_MESSAGE_TIMEOUT_MS) {
            messageQueue3Remove.getOnCompleted().invoke(MessageQueue4.Timeout.INSTANCE, Boolean.valueOf(this.queue.isEmpty()));
            this.networkBackoff.succeed();
            processNextRequest();
            return;
        }
        this.isDraining = true;
        DrainListener drainListener = new DrainListener(new MessageQueue2(this, messageQueue3Remove));
        if (messageQueue3Remove instanceof MessageQueue3.Send) {
            doSend((MessageQueue3.Send) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.Edit) {
            doEdit((MessageQueue3.Edit) messageQueue3Remove, drainListener);
        } else if (messageQueue3Remove instanceof MessageQueue3.SendApplicationCommand) {
            doSendApplicationCommand((MessageQueue3.SendApplicationCommand) messageQueue3Remove, drainListener);
        }
    }

    public final void cancel(String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        this.executorService.submit(new RunnableC67951(requestId));
    }

    public final void enqueue(MessageQueue3 request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        this.executorService.submit(new RunnableC68091(request));
    }

    public final void handleConnected() {
        this.executorService.submit(new RunnableC68101());
    }
}
