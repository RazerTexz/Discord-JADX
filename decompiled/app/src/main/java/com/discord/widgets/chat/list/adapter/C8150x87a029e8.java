package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import kotlin.jvm.internal.Ref$LongRef;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4 */
/* loaded from: classes2.dex */
public final class C8150x87a029e8<T, R> implements Func1<Long, Integer> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;

    public C8150x87a029e8(Ref$LongRef ref$LongRef) {
        this.$totalContentLength = ref$LongRef;
    }

    @Override // p637j0.p641k.Func1
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
