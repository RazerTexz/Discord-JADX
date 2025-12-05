package p630i0;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.KotlinNullPointerException;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Request;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p592z.p594d.Intrinsics3;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KotlinExtensions.kt */
/* renamed from: i0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinExtensions3<T> implements Callback3<T> {

    /* renamed from: a */
    public final /* synthetic */ CancellableContinuation f26549a;

    public KotlinExtensions3(CancellableContinuation cancellableContinuation) {
        this.f26549a = cancellableContinuation;
    }

    @Override // p630i0.Callback3
    /* renamed from: a */
    public void mo10708a(Call3<T> call3, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.f26549a;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(th)));
    }

    @Override // p630i0.Callback3
    /* renamed from: b */
    public void mo10709b(Call3<T> call3, Response<T> response) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (!response.m11057a()) {
            CancellableContinuation cancellableContinuation = this.f26549a;
            HttpException httpException = new HttpException(response);
            Result2.a aVar = Result2.f25169j;
            cancellableContinuation.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(httpException)));
            return;
        }
        T t = response.f27632b;
        if (t != null) {
            CancellableContinuation cancellableContinuation2 = this.f26549a;
            Result2.a aVar2 = Result2.f25169j;
            cancellableContinuation2.resumeWith(Result2.m11474constructorimpl(t));
            return;
        }
        Request requestMo10699c = call3.mo10699c();
        Objects.requireNonNull(requestMo10699c);
        Intrinsics3.checkParameterIsNotNull(Invocation.class, "type");
        Object objCast = Invocation.class.cast(requestMo10699c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.get(Invocation.class));
        if (objCast == null) {
            Intrinsics3.throwNpe();
        }
        Intrinsics3.checkExpressionValueIsNotNull(objCast, "call.request().tag(Invocation::class.java)!!");
        Method method = ((Invocation) objCast).f26547a;
        StringBuilder sb = new StringBuilder();
        sb.append("Response from ");
        Intrinsics3.checkExpressionValueIsNotNull(method, "method");
        Class<?> declaringClass = method.getDeclaringClass();
        Intrinsics3.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
        sb.append(declaringClass.getName());
        sb.append('.');
        sb.append(method.getName());
        sb.append(" was null but response body type was declared as non-null");
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
        CancellableContinuation cancellableContinuation3 = this.f26549a;
        Result2.a aVar3 = Result2.f25169j;
        cancellableContinuation3.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(kotlinNullPointerException)));
    }
}
