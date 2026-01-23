package com.discord.utilities.p501rx;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;
import p658rx.Subscription;

/* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$1, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtils2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Subscription $subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineUtils2(Subscription subscription) {
        super(1);
        this.$subscription = subscription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$subscription.unsubscribe();
    }
}
