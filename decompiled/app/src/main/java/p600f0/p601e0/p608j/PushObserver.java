package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.Buffer3;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.e0.j.q, reason: use source file name */
/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PushObserver implements PushObserver2 {
    @Override // p600f0.p601e0.p608j.PushObserver2
    /* JADX INFO: renamed from: a */
    public boolean mo10308a(int i, List<Header2> list) {
        Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
        return true;
    }

    @Override // p600f0.p601e0.p608j.PushObserver2
    /* JADX INFO: renamed from: b */
    public boolean mo10309b(int i, List<Header2> list, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(list, "responseHeaders");
        return true;
    }

    @Override // p600f0.p601e0.p608j.PushObserver2
    /* JADX INFO: renamed from: c */
    public void mo10310c(int i, ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
    }

    @Override // p600f0.p601e0.p608j.PushObserver2
    /* JADX INFO: renamed from: d */
    public boolean mo10311d(int i, BufferedSource bufferedSource, int i2, boolean z2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        ((Buffer3) bufferedSource).skip(i2);
        return true;
    }
}
