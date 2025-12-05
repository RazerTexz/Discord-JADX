package p007b.p008a.p048r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.samsung.SamsungConnect3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.Result3;
import p507d0.p579g0.Strings4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.OkHttpClient;
import p600f0.p601e0.p605g.RealCall;

/* compiled from: SamsungConnect.kt */
@DebugMetadata(m10084c = "com.discord.samsung.SamsungConnect$getSamsungAuthorizeCallback$2", m10085f = "SamsungConnect.kt", m10086l = {}, m10087m = "invokeSuspend")
/* renamed from: b.a.r.a, reason: use source file name */
/* loaded from: classes.dex */
public final class SamsungConnect extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ OkHttpClient $okHttpClient;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect(String str, OkHttpClient okHttpClient, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$okHttpClient = okHttpClient;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new SamsungConnect(this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        Continuation<? super Uri> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new SamsungConnect(this.$url, this.$okHttpClient, continuation2).invokeSuspend(Unit.f27425a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r4 == false) goto L26;
     */
    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String queryParameter;
        String query;
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10980c(ShareTarget.METHOD_GET, null);
        c12935a.m10983f(this.$url);
        Response responseExecute = ((RealCall) this.$okHttpClient.mo10114b(c12935a.m10978a())).execute();
        String strM10989a = Response.m10989a(responseExecute, "Location", null, 2);
        Uri uri = strM10989a != null ? Uri.parse(strM10989a) : null;
        boolean z2 = false;
        if (!((uri == null || (query = uri.getQuery()) == null) ? false : Strings4.contains$default((CharSequence) query, (CharSequence) "error", false, 2, (Object) null))) {
            if (!responseExecute.m10990b()) {
                int i = responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i != 307 && i != 308) {
                    switch (i) {
                    }
                }
                z2 = true;
            }
            return uri;
        }
        if (uri == null || (queryParameter = uri.getQueryParameter("error")) == null) {
            queryParameter = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "location?.getQueryParameter(\"error\") ?: \"unknown\"");
        throw new SamsungConnect3(queryParameter, uri != null ? uri.getQueryParameter("error_description") : null);
    }
}
