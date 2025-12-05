package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rest.SendUtils;
import java.util.Objects;
import p637j0.p641k.Func1;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class MessageQueue$doSendApplicationCommand$$inlined$filterIs$2<T, R> implements Func1<Object, T> {
    public static final MessageQueue$doSendApplicationCommand$$inlined$filterIs$2 INSTANCE = new MessageQueue$doSendApplicationCommand$$inlined$filterIs$2();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSendCommand");
        return (T) ((SendUtils.SendPayload.ReadyToSendCommand) obj);
    }
}
