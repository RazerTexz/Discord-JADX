package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlinx.coroutines.CancellableContinuation;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$2, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtils4<T> implements Action1<Throwable> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtils4(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        this.$cont.mo10906k(th);
    }
}
