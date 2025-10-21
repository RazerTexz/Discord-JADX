package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.Result2;
import kotlinx.coroutines.CancellableContinuation;
import rx.functions.Action1;

/* compiled from: RxCoroutineUtils.kt */
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils3<T> implements Action1<T> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtils3(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // rx.functions.Action1
    public final void call(T t) {
        CancellableContinuation cancellableContinuation = this.$cont;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(t));
    }
}
