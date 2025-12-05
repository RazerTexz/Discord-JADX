package p600f0.p601e0.p606h;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import p600f0.p601e0.p605g.RealConnection4;
import p615g0.Sink;
import p615g0.Source2;

/* compiled from: ExchangeCodec.kt */
/* renamed from: f0.e0.h.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExchangeCodec {
    /* renamed from: a */
    void mo10213a() throws IOException;

    /* renamed from: b */
    void mo10214b(Request request) throws IOException;

    /* renamed from: c */
    Source2 mo10215c(Response response) throws IOException;

    void cancel();

    /* renamed from: d */
    Response.C12937a mo10216d(boolean z2) throws IOException;

    /* renamed from: e */
    RealConnection4 mo10217e();

    /* renamed from: f */
    void mo10218f() throws IOException;

    /* renamed from: g */
    long mo10219g(Response response) throws IOException;

    /* renamed from: h */
    Sink mo10220h(Request request, long j) throws IOException;
}
