package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4<T, R> implements Func1<Long, Integer> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4(Ref$LongRef ref$LongRef) {
        this.$totalContentLength = ref$LongRef;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Integer call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Long l) {
        WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "totalBytesWritten");
        return Integer.valueOf(WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getPercentage(modelProvider, l.longValue(), this.$totalContentLength.element));
    }
}
