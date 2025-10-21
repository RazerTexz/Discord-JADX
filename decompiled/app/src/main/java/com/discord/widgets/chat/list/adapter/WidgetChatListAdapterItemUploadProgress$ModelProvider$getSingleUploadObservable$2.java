package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2<T, R> implements Func1<Integer, WidgetChatListAdapterItemUploadProgress.Model.Single> {
    public final /* synthetic */ SendUtils.FileUpload $upload;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2(SendUtils.FileUpload fileUpload) {
        this.$upload = fileUpload;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress.Model.Single call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress.Model.Single call2(Integer num) {
        String name = this.$upload.getName();
        String mimeType = this.$upload.getMimeType();
        long contentLength = this.$upload.getContentLength();
        Intrinsics3.checkNotNullExpressionValue(num, "progressPercent");
        return new WidgetChatListAdapterItemUploadProgress.Model.Single(name, mimeType, contentLength, num.intValue());
    }
}
