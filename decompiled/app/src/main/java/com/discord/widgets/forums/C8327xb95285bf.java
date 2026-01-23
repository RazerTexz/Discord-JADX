package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rest.SendUtils;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$1 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8327xb95285bf<T, R> implements Func1<Object, Boolean> {
    public static final C8327xb95285bf INSTANCE = new C8327xb95285bf();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSend);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
