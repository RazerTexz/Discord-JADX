package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$2, reason: use source file name */
/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel7<T, R> implements Func1<List<? extends String>, List<? extends CharSequence>> {
    public static final ChatTypingModel7 INSTANCE = new ChatTypingModel7();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<CharSequence> call2(List<String> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "names");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FormatUtils.m220l(outline.m886y("!!", (String) it.next(), "!!"), new Object[0], null, 2));
        }
        return _Collections.take(arrayList, 4);
    }
}
