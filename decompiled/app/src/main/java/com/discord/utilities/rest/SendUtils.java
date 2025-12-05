package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.CountingRequestBody;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p492b0.p493a.p494a.Compressor;
import p492b0.p493a.p494a.Compressor2;
import p507d0.Result3;
import p507d0.Tuples;
import p507d0.p578f0.SequenceBuilder2;
import p507d0.p578f0.SequenceBuilder3;
import p507d0.p578f0._Sequences2;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl5;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.boxing;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: SendUtils.kt */
/* loaded from: classes2.dex */
public final class SendUtils {
    public static final SendUtils INSTANCE = new SendUtils();
    public static final int MAX_MESSAGE_CHARACTER_COUNT = 2000;
    public static final int MAX_MESSAGE_CHARACTER_COUNT_PREMIUM = 4000;

    /* compiled from: SendUtils.kt */
    public static final /* data */ class FileUpload {
        public static final long SIZE_UNKNOWN = -1;
        private final Observable<Long> bytesWrittenObservable;
        private final long contentLength;
        private final String mimeType;
        private final String name;
        private final MultipartBody.Part part;

        public FileUpload(String str, long j, MultipartBody.Part part, String str2, Observable<Long> observable) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(str2, "mimeType");
            Intrinsics3.checkNotNullParameter(observable, "bytesWrittenObservable");
            this.name = str;
            this.contentLength = j;
            this.part = part;
            this.mimeType = str2;
            this.bytesWrittenObservable = observable;
        }

        public static /* synthetic */ FileUpload copy$default(FileUpload fileUpload, String str, long j, MultipartBody.Part part, String str2, Observable observable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileUpload.name;
            }
            if ((i & 2) != 0) {
                j = fileUpload.contentLength;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                part = fileUpload.part;
            }
            MultipartBody.Part part2 = part;
            if ((i & 8) != 0) {
                str2 = fileUpload.mimeType;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                observable = fileUpload.bytesWrittenObservable;
            }
            return fileUpload.copy(str, j2, part2, str3, observable);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getContentLength() {
            return this.contentLength;
        }

        /* renamed from: component3, reason: from getter */
        public final MultipartBody.Part getPart() {
            return this.part;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final Observable<Long> component5() {
            return this.bytesWrittenObservable;
        }

        public final FileUpload copy(String name, long contentLength, MultipartBody.Part part, String mimeType, Observable<Long> bytesWrittenObservable) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(part, "part");
            Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics3.checkNotNullParameter(bytesWrittenObservable, "bytesWrittenObservable");
            return new FileUpload(name, contentLength, part, mimeType, bytesWrittenObservable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileUpload)) {
                return false;
            }
            FileUpload fileUpload = (FileUpload) other;
            return Intrinsics3.areEqual(this.name, fileUpload.name) && this.contentLength == fileUpload.contentLength && Intrinsics3.areEqual(this.part, fileUpload.part) && Intrinsics3.areEqual(this.mimeType, fileUpload.mimeType) && Intrinsics3.areEqual(this.bytesWrittenObservable, fileUpload.bytesWrittenObservable);
        }

        public final Observable<Long> getBytesWrittenObservable() {
            return this.bytesWrittenObservable;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getName() {
            return this.name;
        }

        public final MultipartBody.Part getPart() {
            return this.part;
        }

        public int hashCode() {
            String str = this.name;
            int iM3a = (C0002b.m3a(this.contentLength) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            MultipartBody.Part part = this.part;
            int iHashCode = (iM3a + (part != null ? part.hashCode() : 0)) * 31;
            String str2 = this.mimeType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Observable<Long> observable = this.bytesWrittenObservable;
            return iHashCode2 + (observable != null ? observable.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("FileUpload(name=");
            sbM833U.append(this.name);
            sbM833U.append(", contentLength=");
            sbM833U.append(this.contentLength);
            sbM833U.append(", part=");
            sbM833U.append(this.part);
            sbM833U.append(", mimeType=");
            sbM833U.append(this.mimeType);
            sbM833U.append(", bytesWrittenObservable=");
            sbM833U.append(this.bytesWrittenObservable);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: SendUtils.kt */
    public static abstract class SendPayload {

        /* compiled from: SendUtils.kt */
        public static final /* data */ class Preprocessing extends SendPayload {
            private final String mimeType;
            private final String name;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.name = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.name;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String name, String mimeType) {
                return new Preprocessing(numFiles, name, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.name, preprocessing.name) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.name;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Preprocessing(numFiles=");
                sbM833U.append(this.numFiles);
                sbM833U.append(", name=");
                sbM833U.append(this.name);
                sbM833U.append(", mimeType=");
                return outline.m822J(sbM833U, this.mimeType, ")");
            }
        }

        /* compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSend extends SendPayload {
            private final RestAPIParams.Message message;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSend(RestAPIParams.Message message, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.message = message;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSend copy$default(ReadyToSend readyToSend, RestAPIParams.Message message, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    message = readyToSend.message;
                }
                if ((i & 2) != 0) {
                    list = readyToSend.uploads;
                }
                return readyToSend.copy(message, list);
            }

            /* renamed from: component1, reason: from getter */
            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSend copy(RestAPIParams.Message message, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSend(message, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSend)) {
                    return false;
                }
                ReadyToSend readyToSend = (ReadyToSend) other;
                return Intrinsics3.areEqual(this.message, readyToSend.message) && Intrinsics3.areEqual(this.uploads, readyToSend.uploads);
            }

            public final RestAPIParams.Message getMessage() {
                return this.message;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                RestAPIParams.Message message = this.message;
                int iHashCode = (message != null ? message.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ReadyToSend(message=");
                sbM833U.append(this.message);
                sbM833U.append(", uploads=");
                return outline.m824L(sbM833U, this.uploads, ")");
            }
        }

        /* compiled from: SendUtils.kt */
        public static final /* data */ class ReadyToSendCommand extends SendPayload {
            private final ApplicationCommandLocalSendData command;
            private final List<FileUpload> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadyToSendCommand(ApplicationCommandLocalSendData applicationCommandLocalSendData, List<FileUpload> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationCommandLocalSendData, "command");
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.command = applicationCommandLocalSendData;
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReadyToSendCommand copy$default(ReadyToSendCommand readyToSendCommand, ApplicationCommandLocalSendData applicationCommandLocalSendData, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    applicationCommandLocalSendData = readyToSendCommand.command;
                }
                if ((i & 2) != 0) {
                    list = readyToSendCommand.uploads;
                }
                return readyToSendCommand.copy(applicationCommandLocalSendData, list);
            }

            /* renamed from: component1, reason: from getter */
            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> component2() {
                return this.uploads;
            }

            public final ReadyToSendCommand copy(ApplicationCommandLocalSendData command, List<FileUpload> uploads) {
                Intrinsics3.checkNotNullParameter(command, "command");
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new ReadyToSendCommand(command, uploads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReadyToSendCommand)) {
                    return false;
                }
                ReadyToSendCommand readyToSendCommand = (ReadyToSendCommand) other;
                return Intrinsics3.areEqual(this.command, readyToSendCommand.command) && Intrinsics3.areEqual(this.uploads, readyToSendCommand.uploads);
            }

            public final ApplicationCommandLocalSendData getCommand() {
                return this.command;
            }

            public final List<FileUpload> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                ApplicationCommandLocalSendData applicationCommandLocalSendData = this.command;
                int iHashCode = (applicationCommandLocalSendData != null ? applicationCommandLocalSendData.hashCode() : 0) * 31;
                List<FileUpload> list = this.uploads;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ReadyToSendCommand(command=");
                sbM833U.append(this.command);
                sbM833U.append(", uploads=");
                return outline.m824L(sbM833U, this.uploads, ")");
            }
        }

        private SendPayload() {
        }

        public /* synthetic */ SendPayload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SendUtils.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.rest.SendUtils$compressImageAttachments$1", m10085f = "SendUtils.kt", m10086l = {323}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.utilities.rest.SendUtils$compressImageAttachments$1 */
    public static final class C68611 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachments;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Function1 $onCompressed;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68611(List list, Context context, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$attachments = list;
            this.$context = context;
            this.$onCompressed = function1;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C68611(this.$attachments, this.$context, this.$onCompressed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68611) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
        
            r5 = r4;
            r4 = r3;
            r3 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008c -> B:36:0x0093). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00bc -> B:27:0x00c1). Please report as a decompilation issue!!! */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Collection arrayList;
            Iterator it;
            C68611 c68611;
            Collection collection;
            Collection collection2;
            Iterator it2;
            Attachment<Uri> attachmentM9296b;
            Collection collection3;
            Object obj2;
            C68611 c686112;
            Attachment<Uri> attachment;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                List list = this.$attachments;
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                it = list.iterator();
                c68611 = this;
                if (it.hasNext()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (Collection) this.L$3;
                Attachment<Uri> attachment2 = (Attachment) this.L$2;
                it = (Iterator) this.L$1;
                Collection collection4 = (Collection) this.L$0;
                try {
                    Result3.throwOnFailure(obj);
                    collection3 = collection4;
                    it2 = it;
                    attachment = attachment2;
                    collection = arrayList;
                    obj2 = coroutine_suspended;
                    c686112 = this;
                } catch (Exception unused) {
                    c68611 = this;
                    Attachment<Uri> attachment3 = attachment2;
                    collection = arrayList;
                    collection2 = collection4;
                    it2 = it;
                    attachmentM9296b = attachment3;
                    Collection collection5 = collection;
                    Collection collection6 = collection2;
                    arrayList = collection5;
                    arrayList.add(attachmentM9296b);
                    arrayList = collection6;
                    it = it2;
                    if (it.hasNext()) {
                    }
                }
                try {
                } catch (Exception unused2) {
                    c68611 = c686112;
                    coroutine_suspended = obj2;
                    arrayList = collection;
                    attachment2 = attachment;
                    it = it2;
                    collection4 = collection3;
                    Attachment<Uri> attachment32 = attachment2;
                    collection = arrayList;
                    collection2 = collection4;
                    it2 = it;
                    attachmentM9296b = attachment32;
                    Collection collection52 = collection;
                    Collection collection62 = collection2;
                    arrayList = collection52;
                    arrayList.add(attachmentM9296b);
                    arrayList = collection62;
                    it = it2;
                    if (it.hasNext()) {
                    }
                }
                Uri uriFromFile = Uri.fromFile((File) obj);
                Attachment.Companion companion = Attachment.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uriFromFile, "resultUri");
                ContentResolver contentResolver = c686112.$context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                attachmentM9296b = companion.m9296b(uriFromFile, contentResolver);
                c68611 = c686112;
                coroutine_suspended = obj2;
                collection2 = collection3;
                Collection collection522 = collection;
                Collection collection622 = collection2;
                arrayList = collection522;
                arrayList.add(attachmentM9296b);
                arrayList = collection622;
                it = it2;
                if (it.hasNext()) {
                    attachment2 = (Attachment) it.next();
                    if (!AttachmentUtils.isImage(attachment2, c68611.$context.getContentResolver()) || AttachmentUtils.isGif(attachment2, c68611.$context.getContentResolver())) {
                        it2 = it;
                        attachmentM9296b = attachment2;
                        collection622 = arrayList;
                        arrayList.add(attachmentM9296b);
                        arrayList = collection622;
                        it = it2;
                        if (it.hasNext()) {
                            c68611.$onCompressed.invoke((List) arrayList);
                            return Unit.f27425a;
                        }
                    } else {
                        try {
                        } catch (Exception unused3) {
                            collection4 = arrayList;
                            Attachment<Uri> attachment322 = attachment2;
                            collection = arrayList;
                            collection2 = collection4;
                            it2 = it;
                            attachmentM9296b = attachment322;
                            Collection collection5222 = collection;
                            Collection collection6222 = collection2;
                            arrayList = collection5222;
                            arrayList.add(attachmentM9296b);
                            arrayList = collection6222;
                            it = it2;
                            if (it.hasNext()) {
                            }
                        }
                        Context context = c68611.$context;
                        Uri uri = attachment2.getUri();
                        c68611.L$0 = arrayList;
                        c68611.L$1 = it;
                        c68611.L$2 = attachment2;
                        c68611.L$3 = arrayList;
                        c68611.label = 1;
                        Object objM4197C1 = C3404f.m4197C1(Dispatchers.f27867b, new Compressor2(Compressor.f14501j, context, uri, null), c68611);
                        if (objM4197C1 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection3 = arrayList;
                        obj2 = coroutine_suspended;
                        c686112 = c68611;
                        obj = objM4197C1;
                        it2 = it;
                        attachment = attachment2;
                        collection = collection3;
                        Uri uriFromFile2 = Uri.fromFile((File) obj);
                        Attachment.Companion companion2 = Attachment.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(uriFromFile2, "resultUri");
                        ContentResolver contentResolver2 = c686112.$context.getContentResolver();
                        Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                        attachmentM9296b = companion2.m9296b(uriFromFile2, contentResolver2);
                        c68611 = c686112;
                        coroutine_suspended = obj2;
                        collection2 = collection3;
                        Collection collection52222 = collection;
                        Collection collection62222 = collection2;
                        arrayList = collection52222;
                        arrayList.add(attachmentM9296b);
                        arrayList = collection62222;
                        it = it2;
                        if (it.hasNext()) {
                        }
                    }
                }
            }
        }
    }

    /* compiled from: SendUtils.kt */
    /* renamed from: com.discord.utilities.rest.SendUtils$getPart$1 */
    public static final class C68621<T> implements Action1<Emitter<FileUpload>> {
        public final /* synthetic */ ContentResolver $contentResolver;
        public final /* synthetic */ String $name;
        public final /* synthetic */ Attachment $this_getPart;

        /* compiled from: SendUtils.kt */
        /* renamed from: com.discord.utilities.rest.SendUtils$getPart$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function3<RequestBody, String, Bitmap.CompressFormat, FileUpload> {
            public AnonymousClass1() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FileUpload invoke(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                return invoke2(requestBody, str, compressFormat);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final FileUpload invoke2(RequestBody requestBody, String str, Bitmap.CompressFormat compressFormat) {
                Intrinsics3.checkNotNullParameter(requestBody, "requestBody");
                Intrinsics3.checkNotNullParameter(str, "mimeType");
                CountingRequestBody countingRequestBody = new CountingRequestBody(requestBody, 0);
                String sanitizedFileName = AttachmentUtils.getSanitizedFileName(Attachment.INSTANCE.m9295a(C68621.this.$this_getPart), compressFormat);
                return new FileUpload(sanitizedFileName, countingRequestBody.getEstimatedContentLength(), MultipartBody.Part.m10971b(C68621.this.$name, sanitizedFileName, countingRequestBody), str, countingRequestBody.getBytesWrittenObservable());
            }
        }

        public C68621(Attachment attachment, String str, ContentResolver contentResolver) {
            this.$this_getPart = attachment;
            this.$name = str;
            this.$contentResolver = contentResolver;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<FileUpload> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<FileUpload> emitter) {
            emitter.onNext(new AnonymousClass1().invoke2((RequestBody) new AttachmentRequestBody(this.$contentResolver, this.$this_getPart), AttachmentUtils.getMimeType(this.$this_getPart, this.$contentResolver), (Bitmap.CompressFormat) null));
            emitter.onCompleted();
        }
    }

    /* compiled from: SendUtils.kt */
    /* renamed from: com.discord.utilities.rest.SendUtils$getSendCommandPayload$2 */
    public static final class C68632<T, R> implements Func1<List<FileUpload>, SendPayload.ReadyToSendCommand> {
        public final /* synthetic */ ApplicationCommandLocalSendData $attachmentCorrectedMessage;

        public C68632(ApplicationCommandLocalSendData applicationCommandLocalSendData) {
            this.$attachmentCorrectedMessage = applicationCommandLocalSendData;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ SendPayload.ReadyToSendCommand call(List<FileUpload> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SendPayload.ReadyToSendCommand call2(List<FileUpload> list) {
            ApplicationCommandLocalSendData applicationCommandLocalSendData = this.$attachmentCorrectedMessage;
            Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
            return new SendPayload.ReadyToSendCommand(applicationCommandLocalSendData, list);
        }
    }

    /* compiled from: SendUtils.kt */
    /* renamed from: com.discord.utilities.rest.SendUtils$getSendPayload$2 */
    public static final class C68642<T, R> implements Func1<List<FileUpload>, SendPayload.ReadyToSend> {
        public final /* synthetic */ RestAPIParams.Message $sanitizedApiParamMessage;

        public C68642(RestAPIParams.Message message) {
            this.$sanitizedApiParamMessage = message;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ SendPayload.ReadyToSend call(List<FileUpload> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SendPayload.ReadyToSend call2(List<FileUpload> list) {
            RestAPIParams.Message message = this.$sanitizedApiParamMessage;
            Intrinsics3.checkNotNullExpressionValue(list, "attachmentParts");
            return new SendPayload.ReadyToSend(message, list);
        }
    }

    /* compiled from: SendUtils.kt */
    /* renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$1 */
    public static final class C68651 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68651(MessageQueue4.CaptchaRequired captchaRequired) {
            super(2);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            StoreStream.INSTANCE.getMessages().resendMessageWithCaptcha(this.$messageResult.getChannelId(), this.$messageResult.getNonce(), captchaPayload);
        }
    }

    /* compiled from: SendUtils.kt */
    /* renamed from: com.discord.utilities.rest.SendUtils$handleCaptchaRequired$2 */
    public static final class C68662 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MessageQueue4.CaptchaRequired $messageResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68662(MessageQueue4.CaptchaRequired captchaRequired) {
            super(0);
            this.$messageResult = captchaRequired;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getMessages().markMessageFailed(this.$messageResult.getChannelId(), this.$messageResult.getNonce());
        }
    }

    /* compiled from: SendUtils.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.rest.SendUtils$uniqueifyNames$1", m10085f = "SendUtils.kt", m10086l = {204, 206}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.utilities.rest.SendUtils$uniqueifyNames$1 */
    public static final class C68671 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super Attachment<? extends Object>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List $attachmentParts;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68671(List list, Continuation continuation) {
            super(2, continuation);
            this.$attachmentParts = list;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C68671 c68671 = new C68671(this.$attachmentParts, continuation);
            c68671.L$0 = obj;
            return c68671;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceBuilder2<? super Attachment<? extends Object>> sequenceBuilder2, Continuation<? super Unit> continuation) {
            return ((C68671) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceBuilder2 sequenceBuilder2;
            C68671 c68671;
            Map map;
            Iterator it;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SequenceBuilder2 sequenceBuilder22 = (SequenceBuilder2) this.L$0;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                sequenceBuilder2 = sequenceBuilder22;
                c68671 = this;
                map = linkedHashMap;
                it = this.$attachmentParts.iterator();
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                map = (Map) this.L$1;
                sequenceBuilder2 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                c68671 = this;
            }
            while (it.hasNext()) {
                Attachment attachment = (Attachment) it.next();
                Object objBoxInt = map.get(attachment.getDisplayName());
                if (objBoxInt == null) {
                    objBoxInt = boxing.boxInt(0);
                }
                int iIntValue = ((Number) objBoxInt).intValue();
                map.put(attachment.getDisplayName(), boxing.boxInt(iIntValue + 1));
                if (iIntValue == 0) {
                    c68671.L$0 = sequenceBuilder2;
                    c68671.L$1 = map;
                    c68671.L$2 = it;
                    c68671.label = 1;
                    if (sequenceBuilder2.yield(attachment, c68671) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Attachment attachmentRenamedWithDuplicateCount = SendUtils.INSTANCE.renamedWithDuplicateCount(attachment, iIntValue);
                    c68671.L$0 = sequenceBuilder2;
                    c68671.L$1 = map;
                    c68671.L$2 = it;
                    c68671.label = 2;
                    if (sequenceBuilder2.yield(attachmentRenamedWithDuplicateCount, c68671) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.f27425a;
        }
    }

    private SendUtils() {
    }

    private final Observable<FileUpload> getPart(Attachment<?> attachment, ContentResolver contentResolver, String str) {
        return Observable.m11080o(new C68621(attachment, str, contentResolver), Emitter.BackpressureMode.BUFFER);
    }

    private final SendPayload.Preprocessing getPreprocessingFromAttachments(ContentResolver contentResolver, List<? extends Attachment<?>> fileAttachments) {
        if (fileAttachments.size() != 1) {
            return new SendPayload.Preprocessing(fileAttachments.size(), null, null);
        }
        Attachment<?> attachment = (Attachment) _Collections.first((List) fileAttachments);
        return new SendPayload.Preprocessing(1, Attachment.INSTANCE.m9295a(attachment), AttachmentUtils.getMimeType(contentResolver, attachment.getUri(), attachment.getDisplayName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleSendError$default(SendUtils sendUtils, Error error, Context context, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function02 = null;
        }
        sendUtils.handleSendError(error, context, function0, function02);
    }

    private final Tuples2<String, String> splitFileExtension(String str) {
        int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return Tuples.m10073to(str, null);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, iLastIndexOf$default);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iLastIndexOf$default + 1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return Tuples.m10073to(strSubstring, strSubstring2);
    }

    public final void compressImageAttachments(Context context, List<? extends Attachment<?>> attachments, Function1<? super List<? extends Attachment<?>>, Unit> onCompressed) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attachments, "attachments");
        Intrinsics3.checkNotNullParameter(onCompressed, "onCompressed");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.f27919j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        C3404f.m4211H0(coroutineScope2, MainDispatchers.f27700b, null, new C68611(attachments, context, onCompressed, null), 2, null);
    }

    public final Observable<SendPayload> getSendCommandPayload(ContentResolver contentResolver, ApplicationCommandLocalSendData apiParamMessage, List<? extends Attachment<?>> attachments) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(apiParamMessage, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(apiParamMessage, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(attachments);
        ApplicationCommandLocalSendData applicationCommandLocalSendDataCopy$default = ApplicationCommandLocalSendData.copy$default(apiParamMessage, 0L, 0L, null, null, null, null, null, null, StoreApplicationCommandsKt.mapApplicationCommandValues(apiParamMessage.getApplicationCommandsValues(), new SendUtils4(listUniqueifyNames)), null, null, 1791, null);
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSendCommand(applicationCommandLocalSendDataCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(SendPayl…tedMessage, emptyList()))");
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, "files[" + i + ']'));
            i = i2;
        }
        Observable<SendPayload> observableM11079m = Observable.m11079m(scalarSynchronousObservable3, Observable.m11078l(arrayList).m11105f0().m11083G(new C68632(applicationCommandLocalSendDataCopy$default)));
        Intrinsics3.checkNotNullExpressionValue(observableM11079m, "Observable.concat(\n     …)\n              }\n      )");
        return observableM11079m;
    }

    public final Observable<SendPayload> getSendPayload(ContentResolver contentResolver, RestAPIParams.Message apiParamMessage, List<? extends Attachment<?>> attachments) {
        String str;
        List<Attachment<?>> list;
        RestAPIParams.Message messageCopy$default = apiParamMessage;
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(messageCopy$default, "apiParamMessage");
        if (attachments == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(SendPayl…ramMessage, emptyList()))");
            return scalarSynchronousObservable;
        }
        List<Attachment<?>> listExtractLinks = AttachmentUtils.extractLinks(attachments, contentResolver);
        String content = apiParamMessage.getContent();
        if (content == null) {
            content = "";
        }
        String strAppendLinks = AttachmentUtils.appendLinks(content, listExtractLinks);
        if (!Intrinsics3.areEqual(strAppendLinks, apiParamMessage.getContent())) {
            str = "Observable.just(SendPayl…ramMessage, emptyList()))";
            list = listExtractLinks;
            messageCopy$default = RestAPIParams.Message.copy$default(apiParamMessage, strAppendLinks, null, null, null, null, null, null, null, null, 510, null);
        } else {
            str = "Observable.just(SendPayl…ramMessage, emptyList()))";
            list = listExtractLinks;
        }
        List<Attachment<?>> listUniqueifyNames = uniqueifyNames(_Collections.minus((Iterable) attachments, (Iterable) list));
        if (!(!listUniqueifyNames.isEmpty())) {
            ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new SendPayload.ReadyToSend(messageCopy$default, Collections2.emptyList()));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, str);
            return scalarSynchronousObservable2;
        }
        ScalarSynchronousObservable scalarSynchronousObservable3 = new ScalarSynchronousObservable(getPreprocessingFromAttachments(contentResolver, listUniqueifyNames));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUniqueifyNames, 10));
        int i = 0;
        for (Object obj : listUniqueifyNames) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add(INSTANCE.getPart((Attachment) obj, contentResolver, outline.m871q("file", i)));
            i = i2;
        }
        Observable<SendPayload> observableM11079m = Observable.m11079m(scalarSynchronousObservable3, Observable.m11078l(arrayList).m11105f0().m11083G(new C68642(messageCopy$default)));
        Intrinsics3.checkNotNullExpressionValue(observableM11079m, "Observable.concat(\n     …)\n              }\n      )");
        return observableM11079m;
    }

    public final void handleCaptchaRequired(MessageQueue4.CaptchaRequired messageResult) {
        Intrinsics3.checkNotNullParameter(messageResult, "messageResult");
        WidgetCaptchaBottomSheet.INSTANCE.enqueue("Message Captcha", new C68651(messageResult), new C68662(messageResult), CaptchaErrorBody.INSTANCE.createFromError(messageResult.getError()));
    }

    @MainThread
    public final void handleSendError(Error error, Context context, Function0<Unit> filesTooLargeCallback, Function0<Unit> failedDeliveryToRecipientCallback) {
        Intrinsics3.checkNotNullParameter(error, "error");
        Intrinsics3.checkNotNullParameter(context, "context");
        error.setShowErrorToasts(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        if (abortCodeMessageResId != null) {
            AppToast.m169g(context, abortCodeMessageResId.intValue(), 0, null, 12);
        } else if (error.getType() == Error.Type.REQUEST_TOO_LARGE) {
            if (filesTooLargeCallback != null) {
                filesTooLargeCallback.invoke();
            }
        } else if (error.getType() != Error.Type.FORBIDDEN_DISCORD) {
            Error.Response response2 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
            if (response2.isKnownResponse() || error.getType() == Error.Type.NETWORK) {
                error.setShowErrorToasts(true);
            } else {
                AppToast.m169g(context, C5419R.string.network_error_bad_request, 0, null, 12);
            }
        } else if (failedDeliveryToRecipientCallback != null) {
            failedDeliveryToRecipientCallback.invoke();
        }
        error.showToasts(context);
    }

    @VisibleForTesting
    public final <T> Attachment<T> renamedWithDuplicateCount(Attachment<? extends T> attachment, int i) {
        String str;
        Intrinsics3.checkNotNullParameter(attachment, "$this$renamedWithDuplicateCount");
        long id2 = attachment.getId();
        Uri uri = attachment.getUri();
        Tuples2<String, String> tuples2SplitFileExtension = splitFileExtension(attachment.getDisplayName());
        String strComponent1 = tuples2SplitFileExtension.component1();
        String strComponent2 = tuples2SplitFileExtension.component2();
        if (strComponent2 != null) {
            str = strComponent1 + '-' + i + '.' + strComponent2;
        } else {
            str = strComponent1 + '-' + i;
        }
        return new Attachment<>(id2, uri, str, attachment.getData(), false, 16, null);
    }

    @VisibleForTesting
    public final List<Attachment<?>> uniqueifyNames(List<? extends Attachment<?>> attachmentParts) {
        Intrinsics3.checkNotNullParameter(attachmentParts, "attachmentParts");
        return _Sequences2.toList(SequenceBuilder3.sequence(new C68671(attachmentParts, null)));
    }
}
