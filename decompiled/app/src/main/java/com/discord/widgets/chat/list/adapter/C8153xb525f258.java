package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8153xb525f258<T, R> implements Func1<Integer, WidgetChatListAdapterItemUploadProgress.Model.Single> {
    public final /* synthetic */ SendUtils.FileUpload $upload;

    public C8153xb525f258(SendUtils.FileUpload fileUpload) {
        this.$upload = fileUpload;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress.Model.Single call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress.Model.Single call2(Integer num) {
        String name = this.$upload.getName();
        String mimeType = this.$upload.getMimeType();
        long contentLength = this.$upload.getContentLength();
        Intrinsics3.checkNotNullExpressionValue(num, "progressPercent");
        return new WidgetChatListAdapterItemUploadProgress.Model.Single(name, mimeType, contentLength, num.intValue());
    }
}
