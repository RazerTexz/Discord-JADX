package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$2<T, R> implements Func1<List<? extends Message>, List<? extends com.discord.models.message.Message>> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$2 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends com.discord.models.message.Message> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<com.discord.models.message.Message> call2(List<Message> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "messages");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.discord.models.message.Message((Message) it.next()));
        }
        return arrayList;
    }
}
