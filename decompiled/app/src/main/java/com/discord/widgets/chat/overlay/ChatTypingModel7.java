package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel7<T, R> implements Func1<List<? extends String>, List<? extends CharSequence>> {
    public static final ChatTypingModel7 INSTANCE = new ChatTypingModel7();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<CharSequence> call2(List<String> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "names");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FormatUtils.l(outline.y("!!", (String) it.next(), "!!"), new Object[0], null, 2));
        }
        return _Collections.take(arrayList, 4);
    }
}
