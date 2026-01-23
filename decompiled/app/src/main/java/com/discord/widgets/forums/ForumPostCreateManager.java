package com.discord.widgets.forums;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.NonceGenerator;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.MessageManager;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.MultipartBody;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager {
    public static final ForumPostCreateManager INSTANCE = new ForumPostCreateManager();
    private static final BehaviorSubject<Boolean> isCreateInProgressBehaviorSubject = BehaviorSubject.m11130l0(Boolean.FALSE);

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$1 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83221<T, R> implements Func1<Channel, Observable<? extends Channel>> {
        public static final C83221 INSTANCE = new C83221();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
            return call2(channel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Channel channel) {
            Observable<R> observableM11083G = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$2 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83232 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83232(long j) {
            super(1);
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$forumChannelId);
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$3 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83243 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83243(Context context, long j) {
            super(1);
            this.$context = context;
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$forumChannelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$4 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83254 extends Lambda implements Function0<Unit> {
        public static final C83254 INSTANCE = new C83254();

        public C83254() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ForumPostCreateManager.access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager.INSTANCE).onNext(Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$observeIsForumPostCreateInProgress$1 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83261<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
        public static final C83261 INSTANCE = new C83261();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
            return call2(bool, bool2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(Boolean bool, Boolean bool2) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(bool, "canAccess");
            if (bool.booleanValue()) {
                Intrinsics3.checkNotNullExpressionValue(bool2, "isCreateInProgress");
                z2 = bool2.booleanValue();
            }
            return Boolean.valueOf(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$1 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83291<T, R> implements Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Channel>> {
        public final /* synthetic */ List $appliedTags;
        public final /* synthetic */ int $autoArchiveDuration;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $name;
        public final /* synthetic */ List $stickerIds;

        public C83291(long j, String str, List list, List list2, int i) {
            this.$channelId = j;
            this.$name = str;
            this.$appliedTags = list;
            this.$stickerIds = list2;
            this.$autoArchiveDuration = i;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
            return call2(readyToSend);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(SendUtils.SendPayload.ReadyToSend readyToSend) {
            List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long j = this.$channelId;
            String str = this.$name;
            String content = readyToSend.getMessage().getContent();
            if (content == null) {
                content = "";
            }
            String str2 = content;
            List<Long> list = this.$appliedTags;
            List<Long> list2 = this.$stickerIds;
            Integer numValueOf = Integer.valueOf(this.$autoArchiveDuration);
            Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return api.createThreadWithMessage(j, str, str2, list, list2, 11, numValueOf, (MultipartBody.Part[]) array);
        }
    }

    private ForumPostCreateManager() {
    }

    public static final /* synthetic */ BehaviorSubject access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager forumPostCreateManager) {
        return isCreateInProgressBehaviorSubject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createForumPostWithMessage$default(ForumPostCreateManager forumPostCreateManager, Context context, MessageManager messageManager, long j, int i, String str, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function22, int i2, Object obj) {
        forumPostCreateManager.createForumPostWithMessage(context, messageManager, j, i, str, threadDraftState, (i2 & 64) != 0 ? null : attachmentsRequest, (i2 & 128) != 0 ? null : function2, (i2 & 256) != 0 ? null : function22);
    }

    private final Observable<Channel> sendCreateForumPostWithMessageRequest(Context context, long channelId, String name, String content, List<? extends Attachment<?>> attachments, int autoArchiveDuration, List<Long> appliedTags, List<Long> stickerIds) {
        RestAPIParams.Message message = new RestAPIParams.Message(content, String.valueOf(NonceGenerator.Companion.computeNonce$default(NonceGenerator.INSTANCE, null, 1, null)), null, null, stickerIds, null, null, null, null);
        SendUtils sendUtils = SendUtils.INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Observable<R> observableM11083G = sendUtils.getSendPayload(contentResolver, message, attachments).m11118y(C8327xb95285bf.INSTANCE).m11083G(C8328xb95285c0.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        Observable<Channel> observableM11082A = observableM11083G.m11100Z(1).m11082A(new C83291(channelId, name, appliedTags, stickerIds, autoArchiveDuration));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "SendUtils\n        .getSe…(),\n          )\n        }");
        return observableM11082A;
    }

    public final void createForumPostWithMessage(Context context, MessageManager messageManager, long forumChannelId, int autoArchiveDuration, String content, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(content, "content");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
        BehaviorSubject<Boolean> behaviorSubject = isCreateInProgressBehaviorSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "isCreateInProgressBehaviorSubject");
        Boolean boolM11132n0 = behaviorSubject.m11132n0();
        Intrinsics3.checkNotNullExpressionValue(boolM11132n0, "isCreateInProgressBehaviorSubject.value");
        if (boolM11132n0.booleanValue()) {
            return;
        }
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, null, false, true, 15, null));
        } else if (messageManager.isValidForumPostFirstMessage(content, attachmentsRequest, onMessageTooLong, onFilesTooLarge)) {
            behaviorSubject.onNext(Boolean.TRUE);
            Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(sendCreateForumPostWithMessageRequest(context, forumChannelId, threadName, content, attachmentsRequest != null ? attachmentsRequest.getAttachments() : null, autoArchiveDuration, Collections2.emptyList(), Collections2.emptyList()), false, 1, null).m11082A(C83221.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11082A, "sendCreateForumPostWithM…utationLatest()\n        }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11082A), ForumPostCreateManager.class, (Context) null, (Function1) null, new C83243(context, forumChannelId), (Function0) null, C83254.INSTANCE, new C83232(forumChannelId), 22, (Object) null);
        }
    }

    public final Observable<Boolean> observeIsForumPostCreateInProgress(long guildId) {
        Observable<Boolean> observableM11076j = Observable.m11076j(ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), isCreateInProgressBehaviorSubject, C83261.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…s && isCreateInProgress }");
        return observableM11076j;
    }
}
