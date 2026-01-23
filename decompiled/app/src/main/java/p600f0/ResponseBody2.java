package p600f0;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.b0, reason: use source file name */
/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResponseBody2 extends ResponseBody {

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ BufferedSource f25366l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ MediaType f25367m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ long f25368n;

    public ResponseBody2(BufferedSource bufferedSource, MediaType mediaType, long j) {
        this.f25366l = bufferedSource;
        this.f25367m = mediaType;
        this.f25368n = j;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: a */
    public long mo10103a() {
        return this.f25368n;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: b */
    public MediaType mo10104b() {
        return this.f25367m;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: c */
    public BufferedSource mo10105c() {
        return this.f25366l;
    }
}
