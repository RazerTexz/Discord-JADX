package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Emitter;

/* compiled from: StoreMessages.kt */
/* loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$2 extends o implements Function1<Emitter<MessageResult>, MessageRequest.SendApplicationCommand> {
    public final /* synthetic */ ApplicationCommandLocalSendData $applicationCommandLocalSendData;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<MessageResult, Boolean, Unit> {
        public final /* synthetic */ Emitter $emitter;

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02791 extends o implements Function0<Unit> {
            public C02791() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessages.Companion.access$cancelBackgroundSendingWork(StoreMessages.INSTANCE, StoreMessages.access$getContext$p(StoreMessages$sendMessage$createRequest$2.this.this$0));
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
            m.checkNotNullParameter(messageResult, "messageResult");
            this.$emitter.onNext(messageResult);
            this.$emitter.onCompleted();
            if (z2) {
                StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$2.this.this$0).schedule(new C02791());
            }
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<SendUtils.SendPayload.Preprocessing, Unit> {

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$2$1, reason: invalid class name */
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
                StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$2.this.this$0).getMessageUploads().onPreprocessing(StoreMessages$sendMessage$createRequest$2.this.$applicationCommandLocalSendData.getNonceString(), this.$numFiles, this.$displayName, this.$mimeType);
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
            m.checkNotNullParameter(preprocessing, "<name for destructuring parameter 0>");
            StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$2.this.this$0).schedule(new AnonymousClass1(preprocessing.getNumFiles(), preprocessing.getName(), preprocessing.getMimeType()));
        }
    }

    /* compiled from: StoreMessages.kt */
    /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<List<? extends SendUtils.FileUpload>, Unit> {

        /* compiled from: StoreMessages.kt */
        /* renamed from: com.discord.stores.StoreMessages$sendMessage$createRequest$2$3$1, reason: invalid class name */
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
                StoreMessages.access$getStream$p(StoreMessages$sendMessage$createRequest$2.this.this$0).getMessageUploads().bindUpload(StoreMessages$sendMessage$createRequest$2.this.$applicationCommandLocalSendData.getNonceString(), this.$uploads);
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
            m.checkNotNullParameter(list, "uploads");
            StoreMessages.access$getDispatcher$p(StoreMessages$sendMessage$createRequest$2.this.this$0).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$2(StoreMessages storeMessages, Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list) {
        super(1);
        this.this$0 = storeMessages;
        this.$message = message;
        this.$applicationCommandLocalSendData = applicationCommandLocalSendData;
        this.$attachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MessageRequest.SendApplicationCommand invoke(Emitter<MessageResult> emitter) {
        return invoke2(emitter);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MessageRequest.SendApplicationCommand invoke2(Emitter<MessageResult> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        com.discord.api.message.Message messageSynthesizeApiMessage = this.$message.synthesizeApiMessage();
        ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$applicationCommandLocalSendData;
        UtcDateTime timestamp = this.$message.getTimestamp();
        return new MessageRequest.SendApplicationCommand(messageSynthesizeApiMessage, applicationCommandLocalSendData, this.$attachments, new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass1(emitter), timestamp != null ? timestamp.getDateTimeMillis() : 0L);
    }
}
