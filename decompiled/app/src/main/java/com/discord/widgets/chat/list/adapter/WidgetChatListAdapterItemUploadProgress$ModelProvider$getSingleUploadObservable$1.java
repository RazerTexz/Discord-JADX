package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1<T, R> implements Func1<Long, Integer> {
    public final /* synthetic */ SendUtils.FileUpload $upload;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1(SendUtils.FileUpload fileUpload) {
        this.$upload = fileUpload;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "bytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getPercentage(modelProvider, l.longValue(), this.$upload.getContentLength()));
    }
}
