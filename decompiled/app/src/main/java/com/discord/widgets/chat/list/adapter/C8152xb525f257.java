package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8152xb525f257<T, R> implements Func1<Long, Integer> {
    public final /* synthetic */ SendUtils.FileUpload $upload;

    public C8152xb525f257(SendUtils.FileUpload fileUpload) {
        this.$upload = fileUpload;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "bytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getPercentage(modelProvider, l.longValue(), this.$upload.getContentLength()));
    }
}
