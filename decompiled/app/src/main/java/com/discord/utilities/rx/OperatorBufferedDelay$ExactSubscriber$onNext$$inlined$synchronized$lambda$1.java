package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rx.OperatorBufferedDelay;
import rx.functions.Action0;

/* compiled from: OperatorBufferedDelay.kt */
/* loaded from: classes2.dex */
public final class OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1 implements Action0 {
    public final /* synthetic */ Object $t$inlined;
    public final /* synthetic */ OperatorBufferedDelay.ExactSubscriber this$0;

    public OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1(OperatorBufferedDelay.ExactSubscriber exactSubscriber, Object obj) {
        this.this$0 = exactSubscriber;
        this.$t$inlined = obj;
    }

    @Override // rx.functions.Action0
    public final void call() {
        OperatorBufferedDelay.ExactSubscriber.tryEmit$default(this.this$0, null, 1, null);
    }
}
