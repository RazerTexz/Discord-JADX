package p630i0;

import androidx.core.app.NotificationCompat;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p592z.p594d.Intrinsics3;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KotlinExtensions.kt */
/* renamed from: i0.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinExtensions5<T> implements Callback3<T> {

    /* renamed from: a */
    public final /* synthetic */ CancellableContinuation f26550a;

    public KotlinExtensions5(CancellableContinuation cancellableContinuation) {
        this.f26550a = cancellableContinuation;
    }

    @Override // p630i0.Callback3
    /* renamed from: a */
    public void mo10708a(Call3<T> call3, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.f26550a;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(th)));
    }

    @Override // p630i0.Callback3
    /* renamed from: b */
    public void mo10709b(Call3<T> call3, Response<T> response) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(response, "response");
        CancellableContinuation cancellableContinuation = this.f26550a;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(response));
    }
}
