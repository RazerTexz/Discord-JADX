package com.discord.stores;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessagesLoader;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageQueue3;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils3;
import com.discord.utilities.rest.SendUtils5;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.workers.BackgroundMessageSendWorker;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.objectweb.asm.Opcodes;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorMerge;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StoreMessages.kt */
/* loaded from: classes2.dex */
public final class StoreMessages extends Store {
    private static final long BACKGROUND_SENDING_DELAY_MS = 120000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreMessagesHolder holder;
    private final BehaviorSubject<Boolean> initResendFinished;
    private final StoreLocalMessagesHolder localMessagesHolder;
    private final HashMap<Long, MessageQueue> messageQueues;
    private final ExecutorService queueExecutor;
    private final StoreStream stream;

    /* compiled from: StoreMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Operation access$cancelBackgroundSendingWork(Companion companion, Context context) {
            return companion.cancelBackgroundSendingWork(context);
        }

        private final Operation cancelBackgroundSendingWork(Context context) {
            Operation operationCancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork("BACKGROUND_MESSAGE_SENDING");
            Intrinsics3.checkNotNullExpressionValue(operationCancelUniqueWork, "WorkManager.getInstance(…dWorker.UNIQUE_WORK_NAME)");
            return operationCancelUniqueWork;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$deleteMessage$1 */
    public static final class C62241 extends Lambda implements Function1<Void, Unit> {
        public static final C62241 INSTANCE = new C62241();

        public C62241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$deleteMessage$2 */
    public static final class C62252 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62252(Message message, long j, long j2) {
            super(0);
            this.$message = message;
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$message.isLocal()) {
                String nonce = this.$message.getNonce();
                if (nonce != null) {
                    StoreMessages.access$getOrCreateMessageQueue(StoreMessages.this, this.$channelId).cancel(nonce);
                }
                StoreMessages.access$handleLocalMessageDelete(StoreMessages.this, this.$message);
                Integer type = this.$message.getType();
                if (type != null && type.intValue() == -2) {
                    StoreMessages.access$trackFailedLocalMessageResolved(StoreMessages.this, this.$message, StoreMessages2.DELETED);
                }
            } else if (this.$message.isEphemeralMessage()) {
                StoreMessages.this.handleMessageDelete(new ModelMessageDelete(this.$channelId, this.$messageId));
            }
            StoreMessages.access$getStream$p(StoreMessages.this).handleLocalMessageDelete(this.$message);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$editMessage$1 */
    public static final class C62261 extends Lambda implements Function2<MessageQueue4, Boolean, Unit> {
        public final /* synthetic */ MessageAllowedMentions $allowedMentions;
        public final /* synthetic */ long $attemptTimestamp;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $content;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$editMessage$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MessageQueue4 $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MessageQueue4 messageQueue4) {
                super(0);
                this.$result = messageQueue4;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Message messageCreateLocalMessage$default;
                User author;
                if (this.$result instanceof MessageQueue4.AutoModBlock) {
                    C62261 c62261 = C62261.this;
                    Message message = StoreMessages.this.getMessage(c62261.$channelId, c62261.$messageId);
                    if (message == null || (author = message.getAuthor()) == null) {
                        messageCreateLocalMessage$default = null;
                    } else {
                        C62261 c622612 = C62261.this;
                        String str = c622612.$content;
                        long j = c622612.$channelId;
                        List<User> mentions = message.getMentions();
                        List<MessageAttachment> attachments = message.getAttachments();
                        boolean z2 = true ^ (attachments == null || attachments.isEmpty());
                        Application application = message.getApplication();
                        MessageActivity activity = message.getActivity();
                        Clock clockAccess$getClock$p = StoreMessages.access$getClock$p(StoreMessages.this);
                        List listEmptyList = Collections2.emptyList();
                        Long lValueOf = Long.valueOf(C62261.this.$attemptTimestamp);
                        Long initialAttemptTimestamp = message.getInitialAttemptTimestamp();
                        Long lValueOf2 = Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : C62261.this.$attemptTimestamp);
                        Integer numRetries = message.getNumRetries();
                        messageCreateLocalMessage$default = LocalMessageCreators.createLocalMessage$default(str, j, author, mentions, false, z2, application, activity, clockAccess$getClock$p, listEmptyList, lValueOf, lValueOf2, Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), message.getStickers(), message.getMessageReference(), C62261.this.$allowedMentions, null, 65536, null);
                    }
                    if (messageCreateLocalMessage$default != null) {
                        StoreMessages storeMessages = StoreMessages.this;
                        StoreMessages.access$handleSendMessageFailureAutoMod(storeMessages, messageCreateLocalMessage$default, new UtcDateTime(StoreMessages.access$getClock$p(storeMessages).currentTimeMillis()));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62261(long j, long j2, String str, long j3, MessageAllowedMentions messageAllowedMentions) {
            super(2);
            this.$channelId = j;
            this.$messageId = j2;
            this.$content = str;
            this.$attemptTimestamp = j3;
            this.$allowedMentions = messageAllowedMentions;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4, Boolean bool) {
            invoke(messageQueue4, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(MessageQueue4 messageQueue4, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "result");
            StoreMessages.access$getDispatcher$p(StoreMessages.this).schedule(new AnonymousClass1(messageQueue4));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$enqueueRequest$1 */
    public static final class C62271<T> implements Action1<Emitter<MessageQueue4>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Function1 $createRequest;

        public C62271(long j, Function1 function1) {
            this.$channelId = j;
            this.$createRequest = function1;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<MessageQueue4> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<MessageQueue4> emitter) {
            MessageQueue messageQueueAccess$getOrCreateMessageQueue = StoreMessages.access$getOrCreateMessageQueue(StoreMessages.this, this.$channelId);
            Function1 function1 = this.$createRequest;
            Intrinsics3.checkNotNullExpressionValue(emitter, "emitter");
            messageQueueAccess$getOrCreateMessageQueue.enqueue((MessageQueue3) function1.invoke(emitter));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$markMessageFailed$1 */
    public static final class C62281 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62281(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleSendMessageFailure(StoreMessages.this, this.$localMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeIsDetached$1 */
    public static final class C62291<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $channelId;

        public C62291(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$channelId)));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeLocalMessagesForChannel$1 */
    public static final class C62301<T, R> implements Func1<Map<Long, ? extends List<? extends Message>>, List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        public C62301(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, ? extends List<? extends Message>> map) {
            return call2((Map<Long, ? extends List<Message>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(Map<Long, ? extends List<Message>> map) {
            List<Message> list = map.get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeLocalMessagesForChannel$2 */
    public static final class C62312<T1, T2, R> implements Func2<List<? extends Message>, List<? extends Message>, Boolean> {
        public static final C62312 INSTANCE = new C62312();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
            return call2((List<Message>) list, (List<Message>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list, List<Message> list2) {
            return Boolean.valueOf(list == list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeMessagesForChannel$1 */
    public static final class C62321<T1, T2, T3, R> implements Func3<List<? extends Message>, List<? extends Message>, Boolean, List<? extends Message>> {
        public static final C62321 INSTANCE = new C62321();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends Message> list, List<? extends Message> list2, Boolean bool) {
            return call2((List<Message>) list, (List<Message>) list2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(List<Message> list, List<Message> list2, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
            if (bool.booleanValue()) {
                return list;
            }
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            Intrinsics3.checkNotNullExpressionValue(list2, "localMessages");
            return _Collections.plus((Collection) list, (Iterable) list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeMessagesForChannel$2 */
    public static final class C62332<T, R> implements Func1<List<? extends Message>, Message> {
        public final /* synthetic */ long $messageId;

        public C62332(long j) {
            this.$messageId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Message call(List<? extends Message> list) {
            return call2((List<Message>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Message call2(List<Message> list) {
            T next;
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (((Message) next).getId() == this.$messageId) {
                    break;
                }
            }
            return next;
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeSyncedMessagesForChannel$1 */
    public static final class C62341<T, R> implements Func1<Map<Long, List<Message>>, List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        public C62341(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends Message> call(Map<Long, List<Message>> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Message> call2(Map<Long, List<Message>> map) {
            List<Message> list = map.get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$observeSyncedMessagesForChannel$2 */
    public static final class C62352<T1, T2, R> implements Func2<List<? extends Message>, List<? extends Message>, Boolean> {
        public static final C62352 INSTANCE = new C62352();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
            return call2((List<Message>) list, (List<Message>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list, List<Message> list2) {
            return Boolean.valueOf(list == list2);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$1 */
    public static final class C62361 extends Lambda implements Function0<Unit> {
        public C62361() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$getInitResendFinished$p(StoreMessages.this).onNext(Boolean.TRUE);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$resendAllLocalMessages$2 */
    public static final class C62372 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final C62372 INSTANCE = new C62372();

        public C62372() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$resendMessage$1 */
    public static final class C62381 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62381(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageDelete(StoreMessages.this, this.$message);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$resendMessageWithCaptcha$1 */
    public static final class C62391 extends Lambda implements Function1<MessageQueue4, Unit> {
        public static final C62391 INSTANCE = new C62391();

        public C62391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
            invoke2(messageQueue4);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageQueue4 messageQueue4) {
            Intrinsics3.checkNotNullParameter(messageQueue4, "it");
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$1 */
    public static final class C62401 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $invalidAttachmentsMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62401(Message message) {
            super(0);
            this.$invalidAttachmentsMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$invalidAttachmentsMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$2 */
    public static final class C62412<T> implements Action1<Emitter<MessageQueue4>> {
        public static final C62412 INSTANCE = new C62412();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<MessageQueue4> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<MessageQueue4> emitter) {
            emitter.onNext(MessageQueue4.NoValidContent.INSTANCE);
            emitter.onCompleted();
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$3 */
    public static final class C62423 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $localMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62423(Message message) {
            super(0);
            this.$localMessage = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$localMessage);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$4 */
    public static final class C62434 extends Lambda implements Function0<Unit> {
        public C62434() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$5 */
    public static final class C62445 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62445(Message message) {
            super(0);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessages.access$handleLocalMessageCreate(StoreMessages.this, this.$message);
            Context contextAccess$getContext$p = StoreMessages.access$getContext$p(StoreMessages.this);
            Intrinsics3.checkNotNullParameter(contextAccess$getContext$p, "context");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(BackgroundMessageSendWorker.class).setInitialDelay(StoreMessages.BACKGROUND_SENDING_DELAY_MS, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
        }
    }

    public StoreMessages(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.holder = new StoreMessagesHolder();
        this.localMessagesHolder = new StoreLocalMessagesHolder();
        this.queueExecutor = Executors.newSingleThreadExecutor();
        this.messageQueues = new HashMap<>();
        this.initResendFinished = BehaviorSubject.m11130l0(Boolean.FALSE);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreMessages storeMessages) {
        return storeMessages.clock;
    }

    public static final /* synthetic */ Context access$getContext$p(StoreMessages storeMessages) {
        Context context = storeMessages.context;
        if (context == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessages storeMessages) {
        return storeMessages.dispatcher;
    }

    public static final /* synthetic */ BehaviorSubject access$getInitResendFinished$p(StoreMessages storeMessages) {
        return storeMessages.initResendFinished;
    }

    public static final /* synthetic */ MessageQueue access$getOrCreateMessageQueue(StoreMessages storeMessages, long j) {
        return storeMessages.getOrCreateMessageQueue(j);
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessages storeMessages) {
        return storeMessages.stream;
    }

    public static final /* synthetic */ void access$handleLocalMessageCreate(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageCreate(message);
    }

    public static final /* synthetic */ void access$handleLocalMessageDelete(StoreMessages storeMessages, Message message) {
        storeMessages.handleLocalMessageDelete(message);
    }

    public static final /* synthetic */ void access$handleSendMessageCaptchaRequired(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageCaptchaRequired(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailure(StoreMessages storeMessages, Message message) {
        storeMessages.handleSendMessageFailure(message);
    }

    public static final /* synthetic */ void access$handleSendMessageFailureAutoMod(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime) {
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    public static final /* synthetic */ void access$handleSendMessageValidationError(StoreMessages storeMessages, Message message, String str) {
        storeMessages.handleSendMessageValidationError(message, str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreMessages storeMessages, Context context) {
        storeMessages.context = context;
    }

    public static final /* synthetic */ void access$trackFailedLocalMessageResolved(StoreMessages storeMessages, Message message, StoreMessages2 storeMessages2) {
        storeMessages.trackFailedLocalMessageResolved(message, storeMessages2);
    }

    private final Observable<MessageQueue4> enqueueRequest(long channelId, Function1<? super Emitter<MessageQueue4>, ? extends MessageQueue3> createRequest) {
        Observable<MessageQueue4> observableM11098X = Observable.m11080o(new C62271(channelId, createRequest), Emitter.BackpressureMode.ERROR).m11098X(this.dispatcher.getScheduler());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "Observable.create<Messag…eOn(dispatcher.scheduler)");
        return observableM11098X;
    }

    @Store3
    private final MessageQueue getOrCreateMessageQueue(long channelId) {
        MessageQueue messageQueue = this.messageQueues.get(Long.valueOf(channelId));
        if (messageQueue == null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            ExecutorService executorService = this.queueExecutor;
            Intrinsics3.checkNotNullExpressionValue(executorService, "queueExecutor");
            messageQueue = new MessageQueue(contentResolver, executorService, this.clock);
            this.messageQueues.put(Long.valueOf(channelId), messageQueue);
        }
        return messageQueue;
    }

    @Store3
    private final void handleInteractionStateUpdate(InteractionStateUpdate interactionUpdate, boolean isFailed, boolean isLoading) {
        Message message;
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().m8506x27c7fac9().get(interactionUpdate.getNonce());
        if (applicationCommandLocalSendData == null || (message = this.localMessagesHolder.getMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString())) == null) {
            return;
        }
        this.localMessagesHolder.addMessage(LocalMessageCreators.createLocalApplicationCommandMessage(message, interactionUpdate.getId(), isFailed, isLoading, this.clock));
    }

    public static /* synthetic */ void handleInteractionStateUpdate$default(StoreMessages storeMessages, InteractionStateUpdate interactionStateUpdate, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessages.handleInteractionStateUpdate(interactionStateUpdate, z2, z3);
    }

    @Store3
    private final void handleLocalMessageCreate(Message message) {
        this.localMessagesHolder.addMessage(message);
    }

    @Store3
    private final void handleLocalMessageDelete(Message localMessage) {
        this.localMessagesHolder.deleteMessage(localMessage);
    }

    @Store3
    private final void handleSendMessageCaptchaRequired(Message localMessage) {
        this.localMessagesHolder.addMessage(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131073, Opcodes.LAND, null));
    }

    @Store3
    private final void handleSendMessageFailure(Message localMessage) {
        deleteMessage(localMessage);
        String content = localMessage.getContent();
        if (content == null) {
            content = "";
        }
        String str = content;
        long channelId = localMessage.getChannelId();
        User author = localMessage.getAuthor();
        Intrinsics3.checkNotNull(author);
        handleLocalMessageCreate(LocalMessageCreators.createLocalMessage$default(str, channelId, author, localMessage.getMentions(), true, localMessage.getHasLocalUploads(), localMessage.getApplication(), localMessage.getActivity(), this.clock, localMessage.getLocalAttachments(), localMessage.getLastManualAttemptTimestamp(), localMessage.getInitialAttemptTimestamp(), localMessage.getNumRetries(), localMessage.getStickers(), localMessage.getMessageReference(), localMessage.getAllowedMentions(), null, 65536, null));
    }

    @Store3
    private final void handleSendMessageFailureAutoMod(Message localMessage, UtcDateTime editedTimestamp) {
        handleLocalMessageCreate(Message.copy$default(localMessage, 0L, 0L, null, null, null, null, editedTimestamp, null, null, null, null, null, null, null, null, null, null, -8, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -131137, Opcodes.LAND, null));
    }

    public static /* synthetic */ void handleSendMessageFailureAutoMod$default(StoreMessages storeMessages, Message message, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        storeMessages.handleSendMessageFailureAutoMod(message, utcDateTime);
    }

    private final void handleSendMessageValidationError(Message localMessage, String errorMessage) {
        Logger.e$default(AppLog.f14950g, "ValidationError", errorMessage, null, null, 12, null);
        deleteMessage(localMessage);
    }

    @Store3
    private final void markLocalCaptchaRequiredMessagesFailed() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList<Message> arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -6) {
                arrayList.add(obj);
            }
        }
        for (Message message : arrayList) {
            markMessageFailed(message.getChannelId(), message.getNonce());
        }
    }

    private final Observable<List<Message>> observeLocalMessagesForChannel(long channelId) {
        Observable<R> observableM11083G = this.localMessagesHolder.getMessagesPublisher().m11083G(new C62301(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "localMessagesHolder\n    …annelId] ?: emptyList() }");
        Observable<List<Message>> observableM11113s = ObservableExtensionsKt.computationBuffered(observableM11083G).m11113s(C62312.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11113s, "localMessagesHolder\n    …messages1 === messages2 }");
        return observableM11113s;
    }

    private final Observable<List<Message>> observeSyncedMessagesForChannel(long channelId) {
        Observable<R> observableM11083G = this.holder.getMessagesPublisher().m11083G(new C62341(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "holder\n          .messag…annelId] ?: emptyList() }");
        Observable<List<Message>> observableM11113s = ObservableExtensionsKt.computationBuffered(observableM11083G).m11113s(C62352.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11113s, "holder\n          .messag…messages1 === messages2 }");
        return observableM11113s;
    }

    @Store3
    private final void resendAllLocalMessages() {
        List<Message> flattenedMessages = this.localMessagesHolder.getFlattenedMessages();
        ArrayList arrayList = new ArrayList();
        for (Object obj : flattenedMessages) {
            Integer type = ((Message) obj).getType();
            if (type != null && type.intValue() == -1) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(resendMessage$default(this, (Message) it.next(), true, null, 4, null));
        }
        Observable observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(Observable.m11074h0(new OnSubscribeFromIterable(arrayList2)).f27640j, OperatorMerge.a.f27082a));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "Observable\n        .mergeDelayError(observables)");
        ObservableExtensionsKt.appSubscribe$default(observableM11074h0, StoreMessages.class, (Context) null, (Function1) null, (Function1) null, new C62361(), (Function0) null, C62372.INSTANCE, 46, (Object) null);
    }

    public static /* synthetic */ Observable resendMessage$default(StoreMessages storeMessages, Message message, boolean z2, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        return storeMessages.resendMessage(message, z2, captchaPayload);
    }

    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, long j, com.discord.models.user.User user, String str, List list, List list2, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long l, Long l2, Integer num, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        return storeMessages.sendMessage(j, user, str, list, list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : messageReference, (i & 128) != 0 ? null : messageAllowedMentions, (i & 256) != 0 ? null : application, (i & 512) != 0 ? null : activity, (i & 1024) != 0 ? null : messageActivity, (i & 2048) != 0 ? null : l, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : captchaPayload);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void trackFailedLocalMessageResolved(Message localMessage, StoreMessages2 failedMessageResolutionType) {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        Long l;
        boolean z4;
        boolean z5;
        List<LocalAttachment> localAttachments = localMessage.getLocalAttachments();
        if (localAttachments == null) {
            z2 = false;
        } else if (localAttachments.isEmpty()) {
            z5 = false;
            if (!z5) {
                z2 = true;
            }
        } else {
            for (LocalAttachment localAttachment : localAttachments) {
                Context context = this.context;
                if (context == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                if (AttachmentUtils.isImageAttachment(localAttachment, contentResolver)) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
            if (!z5) {
            }
        }
        List<LocalAttachment> localAttachments2 = localMessage.getLocalAttachments();
        if (localAttachments2 == null) {
            z3 = false;
        } else if (localAttachments2.isEmpty()) {
            z4 = false;
            if (!z4) {
                z3 = true;
            }
        } else {
            for (LocalAttachment localAttachment2 : localAttachments2) {
                Context context2 = this.context;
                if (context2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver2 = context2.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                if (AttachmentUtils.isVideoAttachment(localAttachment2, contentResolver2)) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
            if (!z4) {
            }
        }
        List<LocalAttachment> localAttachments3 = localMessage.getLocalAttachments();
        if (localAttachments3 != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments3, 10));
            Iterator<T> it = localAttachments3.iterator();
            while (it.hasNext()) {
                Uri uri = Uri.parse(((LocalAttachment) it.next()).getUriString());
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(localAttachment.uriString)");
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("context");
                }
                ContentResolver contentResolver3 = context3.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver3, "context.contentResolver");
                arrayList.add(Long.valueOf(SendUtils5.computeFileSizeBytes(uri, contentResolver3)));
            }
        } else {
            arrayList = null;
        }
        int iLongValue = (arrayList == null || (l = (Long) _Collections.maxOrNull((Iterable) arrayList)) == null) ? 0 : (int) l.longValue();
        int iSumOfLong = arrayList != null ? (int) _Collections.sumOfLong(arrayList) : 0;
        StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
        List<LocalAttachment> localAttachments4 = localMessage.getLocalAttachments();
        int size = localAttachments4 != null ? localAttachments4.size() : 0;
        Long initialAttemptTimestamp = localMessage.getInitialAttemptTimestamp();
        long jLongValue = initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : 0L;
        Integer numRetries = localMessage.getNumRetries();
        analytics.trackFailedMessageResolved(size, iLongValue, iSumOfLong, z2, z3, failedMessageResolutionType, jLongValue, numRetries != null ? numRetries.intValue() : 0, localMessage.getChannelId());
    }

    public final void cancelMessageSend(long channelId, String requestId) {
        Intrinsics3.checkNotNullParameter(requestId, "requestId");
        getOrCreateMessageQueue(channelId).cancel(requestId);
    }

    @Store3
    public final void deleteLocalMessage(long channelId, String nonce) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        getOrCreateMessageQueue(channelId).cancel(nonce);
        handleLocalMessageDelete(channelId, nonce);
    }

    public final void deleteMessage(Message message) {
        if (message == null) {
            return;
        }
        long id2 = message.getId();
        long channelId = message.getChannelId();
        if (message.isLocal() || message.isEphemeralMessage()) {
            this.dispatcher.schedule(new C62252(message, channelId, id2));
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteMessage(channelId, id2), false, 1, null), (Context) null, "deleteMessage", (Function1) null, C62241.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }
    }

    public final void editMessage(long messageId, long channelId, String content, MessageAllowedMentions allowedMentions) {
        Intrinsics3.checkNotNullParameter(content, "content");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        getOrCreateMessageQueue(channelId).enqueue(new MessageQueue3.Edit(channelId, content, messageId, allowedMentions, jCurrentTimeMillis, new C62261(channelId, messageId, content, jCurrentTimeMillis, allowedMentions)));
    }

    public final Observable<Set<Long>> getAllDetached() {
        Observable<Set<Long>> detachedChannelsSubject = this.holder.getDetachedChannelsSubject();
        Intrinsics3.checkNotNullExpressionValue(detachedChannelsSubject, "holder\n          .detachedChannelsSubject");
        return ObservableExtensionsKt.computationLatest(detachedChannelsSubject);
    }

    @Store3
    public final Message getMessage(long channelId, long messageId) {
        TreeMap<Long, Message> messagesForChannel = this.holder.getMessagesForChannel(Long.valueOf(channelId));
        if (messagesForChannel != null) {
            return messagesForChannel.get(Long.valueOf(messageId));
        }
        return null;
    }

    public final void handleChannelSelected(long channelId) {
        this.holder.setSelectedChannelId(channelId);
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (!connected) {
            this.holder.invalidate();
            return;
        }
        Collection<MessageQueue> collectionValues = this.messageQueues.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "messageQueues.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((MessageQueue) it.next()).handleConnected();
        }
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.holder.setMyUserId(payload.getMe().getId());
    }

    @Store3
    public final void handleInteractionCreate(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, false, true, 2, null);
    }

    @Store3
    public final void handleInteractionFailure(InteractionStateUpdate interactionUpdate) {
        Intrinsics3.checkNotNullParameter(interactionUpdate, "interactionUpdate");
        handleInteractionStateUpdate$default(this, interactionUpdate, true, false, 4, null);
    }

    @Store3
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        Intrinsics3.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.stream.getApplicationInteractions().m8506x27c7fac9().get(interactionModalCreate.getNonce());
        if (applicationCommandLocalSendData != null) {
            this.localMessagesHolder.deleteMessage(applicationCommandLocalSendData.getChannelId(), applicationCommandLocalSendData.getNonceString());
        }
    }

    public final void handleMessageCreate(List<com.discord.api.message.Message> messagesList) {
        Intrinsics3.checkNotNullParameter(messagesList, "messagesList");
        for (com.discord.api.message.Message message : messagesList) {
            String nonce = message.getNonce();
            if (nonce != null) {
                this.localMessagesHolder.deleteMessage(message.getChannelId(), nonce);
            }
        }
        StoreMessagesHolder storeMessagesHolder = this.holder;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(messagesList, 10));
        Iterator<T> it = messagesList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Message((com.discord.api.message.Message) it.next()));
        }
        storeMessagesHolder.addMessages(arrayList);
    }

    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        long channelId = messageDelete.getChannelId();
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        handleMessageDelete(channelId, messageIds);
    }

    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.holder.updateMessages(message);
    }

    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        this.holder.loadMessageChunks(CollectionsJVM.listOf(chunk));
    }

    public final void handlePreLogout() {
        this.localMessagesHolder.clearCache();
    }

    public final void handleReactionUpdate(List<MessageReactionUpdate> updates, boolean add) {
        Intrinsics3.checkNotNullParameter(updates, "updates");
        this.holder.updateReactions(updates, add);
    }

    public final void handleReactionsRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeAllReactions(update);
    }

    public final void handleReactionsRemoveEmoji(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.holder.removeEmojiReactions(update);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.context = context;
        this.holder.init(true);
        StoreLocalMessagesHolder.init$default(this.localMessagesHolder, false, 1, null);
        markLocalCaptchaRequiredMessagesFailed();
        resendAllLocalMessages();
    }

    public final void markMessageFailed(long channelId, String nonce) {
        Message message;
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        this.dispatcher.schedule(new C62281(message));
    }

    public final BehaviorSubject<Boolean> observeInitResendFinished() {
        BehaviorSubject<Boolean> behaviorSubject = this.initResendFinished;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "initResendFinished");
        return behaviorSubject;
    }

    public final Observable<Boolean> observeIsDetached(long channelId) {
        Observable<Boolean> observableM11112r = getAllDetached().m11083G(new C62291(channelId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "allDetached\n          .m…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<List<Message>> observeMessagesForChannel(long channelId) {
        Observable<List<Message>> observableM11075i = Observable.m11075i(observeSyncedMessagesForChannel(channelId), observeLocalMessagesForChannel(channelId), observeIsDetached(channelId), C62321.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…ges + localMessages\n    }");
        return observableM11075i;
    }

    public final Observable<MessageQueue4> resendMessage(Message message, boolean isAutoAttempt, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Integer type;
        Integer type2;
        Integer type3;
        Intrinsics3.checkNotNullParameter(message, "message");
        if ((isAutoAttempt && (((type2 = message.getType()) == null || type2.intValue() != -1) && ((type3 = message.getType()) == null || type3.intValue() != -6))) || (!isAutoAttempt && ((type = message.getType()) == null || type.intValue() != -2))) {
            throw new IllegalArgumentException("Incorrect " + isAutoAttempt + " auto attempt and message type " + message.getType());
        }
        this.dispatcher.schedule(new C62381(message));
        Integer numRetries = message.getNumRetries();
        int iIntValue = numRetries != null ? numRetries.intValue() : 0;
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String content = message.getContent();
        if (content == null) {
            content = "";
        }
        List<User> mentions = message.getMentions();
        if (mentions != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                arrayList.add(new CoreUser((User) it.next()));
            }
        } else {
            arrayList = null;
        }
        List<LocalAttachment> localAttachments = message.getLocalAttachments();
        if (localAttachments != null) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(localAttachments, 10));
            for (LocalAttachment localAttachment : localAttachments) {
                Uri uri = Uri.parse(localAttachment.getUriString());
                long id2 = localAttachment.getId();
                Intrinsics3.checkNotNullExpressionValue(uri, "contentUri");
                arrayList2.add(new Attachment(id2, uri, localAttachment.getDisplayName(), null, false, 16, null));
            }
        } else {
            arrayList2 = null;
        }
        return sendMessage$default(this, channelId, coreUser, content, arrayList, arrayList2, null, message.getMessageReference(), message.getAllowedMentions(), null, null, null, isAutoAttempt ? message.getLastManualAttemptTimestamp() : null, message.getInitialAttemptTimestamp(), Integer.valueOf(iIntValue + 1), captchaPayload, 1824, null);
    }

    public final void resendMessageWithCaptcha(long channelId, String nonce, CaptchaHelper.CaptchaPayload captchaPayload) {
        Message message;
        Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
        if (nonce == null || (message = this.localMessagesHolder.getMessage(channelId, nonce)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(resendMessage(message, true, captchaPayload)), StoreMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C62391.INSTANCE, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.util.List] */
    public final Observable<MessageQueue4> sendMessage(long channelId, com.discord.models.user.User author, String content, List<? extends com.discord.models.user.User> mentions, List<? extends Attachment<?>> attachments, List<? extends BaseSticker> stickers, MessageReference messageReference, MessageAllowedMentions allowedMentions, Application application, Activity activity, MessageActivity messageActivity, Long lastManualAttemptTimestamp, Long initialAttemptTimestamp, Integer numRetries, CaptchaHelper.CaptchaPayload captchaPayload) {
        List listEmptyList;
        ArrayList arrayList;
        String content2 = content;
        Intrinsics3.checkNotNullParameter(author, "author");
        Intrinsics3.checkNotNullParameter(content2, "content");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = attachments;
        if (!(attachments == 0 || attachments.isEmpty())) {
            SendUtils3.Companion companion = SendUtils3.INSTANCE;
            Context context = this.context;
            if (context == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            SendUtils3 sendUtils3FromAttachments = companion.fromAttachments(attachments, content2, context);
            List<Attachment<?>> invalidAttachments = sendUtils3FromAttachments.getInvalidAttachments();
            if (!invalidAttachments.isEmpty()) {
                User userSynthesizeApiUser = UserUtils.INSTANCE.synthesizeApiUser(author);
                Clock clock = this.clock;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(invalidAttachments, 10));
                Iterator<T> it = invalidAttachments.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AttachmentUtils.toLocalAttachment((Attachment) it.next()));
                }
                this.dispatcher.schedule(new C62401(LocalMessageCreators.createInvalidAttachmentsMessage(channelId, userSynthesizeApiUser, clock, arrayList2)));
            }
            ref$ObjectRef.element = sendUtils3FromAttachments.getValidAttachments();
            content2 = sendUtils3FromAttachments.getContent();
            List list = (List) ref$ObjectRef.element;
            if (list == null || list.isEmpty()) {
                if (content2.length() == 0) {
                    Observable<MessageQueue4> observableM11080o = Observable.m11080o(C62412.INSTANCE, Emitter.BackpressureMode.ERROR);
                    Intrinsics3.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit…r.BackpressureMode.ERROR)");
                    return observableM11080o;
                }
            }
        }
        long jLongValue = lastManualAttemptTimestamp != null ? lastManualAttemptTimestamp.longValue() : this.clock.currentTimeMillis();
        User userSynthesizeApiUser2 = UserUtils.INSTANCE.synthesizeApiUser(author);
        if (mentions != null) {
            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(mentions, 10));
            Iterator<T> it2 = mentions.iterator();
            while (it2.hasNext()) {
                listEmptyList.add(UserUtils.INSTANCE.synthesizeApiUser((com.discord.models.user.User) it2.next()));
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        List list2 = listEmptyList;
        List list3 = (List) ref$ObjectRef.element;
        boolean z2 = !(list3 == null || list3.isEmpty());
        Clock clock2 = this.clock;
        List list4 = (List) ref$ObjectRef.element;
        if (list4 != null) {
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
            Iterator it3 = list4.iterator();
            while (it3.hasNext()) {
                arrayList3.add(AttachmentUtils.toLocalAttachment((Attachment) it3.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        Message messageCreateLocalMessage = LocalMessageCreators.createLocalMessage(content2, channelId, userSynthesizeApiUser2, list2, false, z2, application, messageActivity, clock2, arrayList, Long.valueOf(jLongValue), Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : this.clock.currentTimeMillis()), Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), stickers, messageReference, allowedMentions, captchaPayload);
        if (messageActivity == null) {
            this.dispatcher.schedule(new C62423(messageCreateLocalMessage));
        }
        this.dispatcher.schedule(new C62434());
        return enqueueRequest(channelId, new StoreMessages3(this, messageCreateLocalMessage, ref$ObjectRef, activity, jLongValue));
    }

    @Store3
    private final void handleLocalMessageDelete(long channelId, String nonce) {
        this.localMessagesHolder.deleteMessage(channelId, nonce);
    }

    private final void handleMessageDelete(long channelId, List<Long> messageIds) {
        this.holder.deleteMessages(channelId, messageIds);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable sendMessage$default(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return storeMessages.sendMessage(message, applicationCommandLocalSendData, list);
    }

    public final Observable<Message> observeMessagesForChannel(long channelId, long messageId) {
        Observable<Message> observableM11112r = observeMessagesForChannel(channelId).m11083G(new C62332(messageId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeMessagesForChanne…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<MessageQueue4> sendMessage(Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandLocalSendData");
        this.dispatcher.schedule(new C62445(message));
        return enqueueRequest(message.getChannelId(), new StoreMessages4(this, message, applicationCommandLocalSendData, attachments));
    }
}
