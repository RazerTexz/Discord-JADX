package p615g0;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ForwardingTimeout.kt */
/* renamed from: g0.k, reason: use source file name */
/* loaded from: classes3.dex */
public class ForwardingTimeout extends Timeout2 {

    /* renamed from: e */
    public Timeout2 f26094e;

    public ForwardingTimeout(Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(timeout2, "delegate");
        this.f26094e = timeout2;
    }

    @Override // p615g0.Timeout2
    /* renamed from: a */
    public Timeout2 mo10478a() {
        return this.f26094e.mo10478a();
    }

    @Override // p615g0.Timeout2
    /* renamed from: b */
    public Timeout2 mo10479b() {
        return this.f26094e.mo10479b();
    }

    @Override // p615g0.Timeout2
    /* renamed from: c */
    public long mo10480c() {
        return this.f26094e.mo10480c();
    }

    @Override // p615g0.Timeout2
    /* renamed from: d */
    public Timeout2 mo10481d(long j) {
        return this.f26094e.mo10481d(j);
    }

    @Override // p615g0.Timeout2
    /* renamed from: e */
    public boolean mo10482e() {
        return this.f26094e.mo10482e();
    }

    @Override // p615g0.Timeout2
    /* renamed from: f */
    public void mo10483f() throws IOException {
        this.f26094e.mo10483f();
    }

    @Override // p615g0.Timeout2
    /* renamed from: g */
    public Timeout2 mo10484g(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        return this.f26094e.mo10484g(j, timeUnit);
    }

    @Override // p615g0.Timeout2
    /* renamed from: h */
    public long mo10485h() {
        return this.f26094e.mo10485h();
    }
}
