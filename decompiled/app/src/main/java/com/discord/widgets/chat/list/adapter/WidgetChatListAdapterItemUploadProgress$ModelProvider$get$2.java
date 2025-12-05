package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageUploads;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p580t._Collections;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2<T, R> implements Func1<StoreMessageUploads.MessageUploadState, Observable<? extends WidgetChatListAdapterItemUploadProgress.Model>> {
    public final /* synthetic */ long $throttleIntervalMs;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(long j) {
        this.$throttleIntervalMs = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemUploadProgress.Model> call(StoreMessageUploads.MessageUploadState messageUploadState) {
        return call2(messageUploadState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemUploadProgress.Model> call2(StoreMessageUploads.MessageUploadState messageUploadState) {
        if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.None) {
            return new ScalarSynchronousObservable(WidgetChatListAdapterItemUploadProgress.Model.None.INSTANCE);
        }
        if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.Preprocessing) {
            StoreMessageUploads.MessageUploadState.Preprocessing preprocessing = (StoreMessageUploads.MessageUploadState.Preprocessing) messageUploadState;
            return new ScalarSynchronousObservable(new WidgetChatListAdapterItemUploadProgress.Model.Preprocessing(preprocessing.getNumFiles(), preprocessing.getDisplayName(), preprocessing.getMimeType()));
        }
        if (!(messageUploadState instanceof StoreMessageUploads.MessageUploadState.Uploading)) {
            throw new NoWhenBranchMatchedException();
        }
        List<SendUtils.FileUpload> uploads = ((StoreMessageUploads.MessageUploadState.Uploading) messageUploadState).getUploads();
        return uploads.size() == 1 ? WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getSingleUploadObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, (SendUtils.FileUpload) _Collections.first((List) uploads), this.$throttleIntervalMs) : uploads.size() <= 3 ? WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getFewUploadsObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs) : WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getManyUploadsObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs);
    }
}
