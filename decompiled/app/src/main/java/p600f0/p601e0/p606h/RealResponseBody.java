package p600f0.p601e0.p606h;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.e0.h.h, reason: use source file name */
/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: l */
    public final String f25540l;

    /* JADX INFO: renamed from: m */
    public final long f25541m;

    /* JADX INFO: renamed from: n */
    public final BufferedSource f25542n;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        this.f25540l = str;
        this.f25541m = j;
        this.f25542n = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: a */
    public long mo10103a() {
        return this.f25541m;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: b */
    public MediaType mo10104b() {
        String str = this.f25540l;
        if (str == null) {
            return null;
        }
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.m10968b(str);
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: c */
    public BufferedSource mo10105c() {
        return this.f25542n;
    }
}
