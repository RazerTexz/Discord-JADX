package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$1, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtils3<T> implements Action1<T> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtils3(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // p658rx.functions.Action1
    public final void call(T t) {
        CancellableContinuation cancellableContinuation = this.$cont;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(t));
    }
}
