package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import java.util.List;
import kotlin.jvm.internal.Ref$LongRef;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8151x87a029e9<T, R> implements Func1<Integer, WidgetChatListAdapterItemUploadProgress.Model.Many> {
    public final /* synthetic */ Ref$LongRef $totalContentLength;
    public final /* synthetic */ List $uploads;

    public C8151x87a029e9(List list, Ref$LongRef ref$LongRef) {
        this.$uploads = list;
        this.$totalContentLength = ref$LongRef;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress.Model.Many call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemUploadProgress.Model.Many call2(Integer num) {
        int size = this.$uploads.size();
        long j = this.$totalContentLength.element;
        Intrinsics3.checkNotNullExpressionValue(num, "overallProgressPercent");
        return new WidgetChatListAdapterItemUploadProgress.Model.Many(size, j, num.intValue());
    }
}
