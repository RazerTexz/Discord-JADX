package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.e0.j.r, reason: use source file name */
/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PushObserver2 {

    /* JADX INFO: renamed from: a */
    public static final PushObserver2 f25751a = new PushObserver();

    /* JADX INFO: renamed from: a */
    boolean mo10308a(int i, List<Header2> list);

    /* JADX INFO: renamed from: b */
    boolean mo10309b(int i, List<Header2> list, boolean z2);

    /* JADX INFO: renamed from: c */
    void mo10310c(int i, ErrorCode2 errorCode2);

    /* JADX INFO: renamed from: d */
    boolean mo10311d(int i, BufferedSource bufferedSource, int i2, boolean z2) throws IOException;
}
