package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import d0.t.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;

/* compiled from: StoreMessages.kt */
/* loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1 extends o implements Function1<Emitter<MessageResult>, MessageRequest.Send> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ long $attemptTimestamp;
    public final /* synthetic */ Message $localMessage;
    public final /* synthetic */ Ref$ObjectRef $validAttachments;
    public final /* synthetic */ StoreMessages this$0;

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<MessageResult, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02781 extends o implements Function0<Unit> {
            public final /* synthetic */ boolean $isLastMessage;
            public final /* synthetic */ MessageResult $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02781(boolean z2, MessageResult messageResult) {
                super(0);
                this.$isLastMessage = z2;
                this.$result = messageResult;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.$isLastMessage) {
                    StoreMessages.Companion.access$cancelBackgroundSendingWork(StoreMessages.INSTANCE, StoreMessages.access$getContext$p(StoreMessages$sendMessage$createRequest$1.this.this$0));
                }
                MessageResult messageResult = this.$result;
                if (messageResult instanceof MessageResult.Success) {
                    StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$1.this.this$0).getSlowMode().onMessageSent(((MessageResult.Success) this.$result).getMessage().getChannelId());
                    StoreMessages$sendMessage$createRequest$1.this.this$0.handleMessageCreate(m.listOf(((MessageResult.Success) this.$result).getMessage()));
                    Integer numRetries = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNumRetries();
                    if ((numRetries != null ? numRetries.intValue() : 0) > 0) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$1 = StoreMessages$sendMessage$createRequest$1.this;
                        StoreMessages.access$trackFailedLocalMessageResolved(storeMessages$sendMessage$createRequest$1.this$0, storeMessages$sendMessage$createRequest$1.$localMessage, FailedMessageResolutionType.RESENT);
                    }
                } else if (messageResult instanceof MessageResult.Slowmode) {
                    StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$12 = StoreMessages$sendMessage$createRequest$1.this;
                    StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$12.this$0, storeMessages$sendMessage$createRequest$12.$localMessage);
                    StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$1.this.this$0).getSlowMode().onCooldown(StoreMessages$sendMessage$createRequest$1.this.$localMessage.getChannelId(), ((MessageResult.Slowmode) this.$result).getCooldownMs(), StoreSlowMode.Type.MessageSend.INSTANCE);
                } else if (!(messageResult instanceof MessageResult.RateLimited)) {
                    if (messageResult instanceof MessageResult.UserCancelled) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$13 = StoreMessages$sendMessage$createRequest$1.this;
                        StoreMessages.access$handleLocalMessageDelete(storeMessages$sendMessage$createRequest$13.this$0, storeMessages$sendMessage$createRequest$13.$localMessage);
                    } else if (messageResult instanceof MessageResult.CaptchaRequired) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$14 = StoreMessages$sendMessage$createRequest$1.this;
                        StoreMessages.access$handleSendMessageCaptchaRequired(storeMessages$sendMessage$createRequest$14.this$0, storeMessages$sendMessage$createRequest$14.$localMessage);
                    } else if (messageResult instanceof MessageResult.UnknownFailure) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$15 = StoreMessages$sendMessage$createRequest$1.this;
                        StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$15.this$0, storeMessages$sendMessage$createRequest$15.$localMessage);
                    } else if (messageResult instanceof MessageResult.ValidationError) {
                        StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$16 = StoreMessages$sendMessage$createRequest$1.this;
                        StoreMessages.access$handleSendMessageValidationError(storeMessages$sendMessage$createRequest$16.this$0, storeMessages$sendMessage$createRequest$16.$localMessage, ((MessageResult.ValidationError) messageResult).getMessage());
                    } else if (!(messageResult instanceof MessageResult.NetworkFailure)) {
                        if (messageResult instanceof MessageResult.Timeout) {
                            StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$17 = StoreMessages$sendMessage$createRequest$1.this;
                            StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$17.this$0, storeMessages$sendMessage$createRequest$17.$localMessage);
                        } else if (messageResult instanceof MessageResult.AutoModBlock) {
                            StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$18 = StoreMessages$sendMessage$createRequest$1.this;
                            StoreMessages.handleSendMessageFailureAutoMod$default(storeMessages$sendMessage$createRequest$18.this$0, storeMessages$sendMessage$createRequest$18.$localMessage, null, 2, null);
                        }
                    }
                }
                AnonymousClass1.this.$emitter.onNext(this.$result);
                AnonymousClass1.this.$emitter.onCompleted();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Emitter emitter) {
            super(2);
            this.$emitter = emitter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
            invoke(messageResult, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(MessageResult messageResult, boolean z2) {
            d0.z.d.m.checkNotNullParameter(messageResult, "result");
            StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$1.this.this$0).schedule(new C02781(z2, messageResult));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ String $displayName;
            public final /* synthetic */ String $mimeType;
            public final /* synthetic */ int $numFiles;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, String str, String str2) {
                super(0);
                this.$numFiles = i;
                this.$displayName = str;
                this.$mimeType = str2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$1.this.this$0).getMessageUploads();
                String nonce = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNonce();
                d0.z.d.m.checkNotNull(nonce);
                messageUploads.onPreprocessing(nonce, this.$numFiles, this.$displayName, this.$mimeType);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SendUtils.SendPayload.Preprocessing preprocessing) {
            invoke2(preprocessing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendUtils.SendPayload.Preprocessing preprocessing) {
            d0.z.d.m.checkNotNullParameter(preprocessing, "<name for destructuring parameter 0>");
            StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$1.this.this$0).schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$uploads = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageUploads messageUploads = StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$1.this.this$0).getMessageUploads();
                String nonce = StoreMessages$sendMessage$createRequest$1.this.$localMessage.getNonce();
                d0.z.d.m.checkNotNull(nonce);
                messageUploads.bindUpload(nonce, this.$uploads);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SendUtils.FileUpload> list) {
            invoke2((List<SendUtils.FileUpload>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SendUtils.FileUpload> list) {
            d0.z.d.m.checkNotNullParameter(list, "uploads");
            StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$1.this.this$0).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1(StoreMessages storeMessages, Message message, Ref$ObjectRef ref$ObjectRef, Activity activity, long j) {
        super(1);
        this.this$0 = storeMessages;
        this.$localMessage = message;
        this.$validAttachments = ref$ObjectRef;
        this.$activity = activity;
        this.$attemptTimestamp = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageRequest.Send invoke(Emitter<MessageResult> emitter) {
        return invoke2(emitter);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageRequest.Send invoke2(Emitter<MessageResult> emitter) {
        d0.z.d.m.checkNotNullParameter(emitter, "emitter");
        Message message = this.$localMessage;
        List list = (List) this.$validAttachments.element;
        return new MessageRequest.Send(message, this.$activity, list, new AnonymousClass1(emitter), new AnonymousClass2(), new AnonymousClass3(), this.$attemptTimestamp);
    }
}
