package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rest.SendUtils;
import j0.k.Func1;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class MessageQueue$doSendApplicationCommand$$inlined$filterIs$1<T, R> implements Func1<Object, Boolean> {
    public static final MessageQueue$doSendApplicationCommand$$inlined$filterIs$1 INSTANCE = new MessageQueue$doSendApplicationCommand$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSendCommand);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
