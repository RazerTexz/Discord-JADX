package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import java.util.ArrayList;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.FuncN;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8148x872da3c9<R> implements FuncN<WidgetChatListAdapterItemUploadProgress.Model.Few> {
    public static final C8148x872da3c9 INSTANCE = new C8148x872da3c9();

    @Override // p658rx.functions.FuncN
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemUploadProgress.Model.Few call(Object[] objArr) {
        return call(objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p658rx.functions.FuncN
    public final WidgetChatListAdapterItemUploadProgress.Model.Few call(Object[] objArr) {
        Intrinsics3.checkNotNullExpressionValue(objArr, "singles");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress.Model.Single");
            arrayList.add((WidgetChatListAdapterItemUploadProgress.Model.Single) obj);
        }
        return new WidgetChatListAdapterItemUploadProgress.Model.Few(arrayList);
    }
}
