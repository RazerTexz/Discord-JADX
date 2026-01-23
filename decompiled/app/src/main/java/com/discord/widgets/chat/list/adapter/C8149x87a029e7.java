package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Objects;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.FuncN;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8149x87a029e7<R> implements FuncN<Long> {
    public static final C8149x87a029e7 INSTANCE = new C8149x87a029e7();

    @Override // p658rx.functions.FuncN
    public /* bridge */ /* synthetic */ Long call(Object[] objArr) {
        return call(objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p658rx.functions.FuncN
    public final Long call(Object[] objArr) {
        Intrinsics3.checkNotNullExpressionValue(objArr, "bytesWrittenPerUpload");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
            arrayList.add(Long.valueOf(((Long) obj).longValue()));
        }
        return Long.valueOf(_Collections.sumOfLong(arrayList));
    }
}
