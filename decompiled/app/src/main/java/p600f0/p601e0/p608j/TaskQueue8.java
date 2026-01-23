package p600f0.p601e0.p608j;

import p600f0.p601e0.p604f.Task2;

/* JADX INFO: renamed from: f0.e0.j.k, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue8 extends Task2 {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Http2Connection f25691e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue8(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection) {
        super(str2, z3);
        this.f25691e = http2Connection;
    }

    @Override // p600f0.p601e0.p604f.Task2
    /* JADX INFO: renamed from: a */
    public long mo10150a() {
        this.f25691e.m10265q(false, 2, 0);
        return -1L;
    }
}
