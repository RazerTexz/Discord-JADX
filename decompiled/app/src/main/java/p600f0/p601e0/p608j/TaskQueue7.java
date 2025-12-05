package p600f0.p601e0.p608j;

import p600f0.p601e0.p604f.Task2;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.j.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue7 extends Task2 {

    /* renamed from: e */
    public final /* synthetic */ Http2Connection f25688e;

    /* renamed from: f */
    public final /* synthetic */ int f25689f;

    /* renamed from: g */
    public final /* synthetic */ ErrorCode2 f25690g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue7(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, ErrorCode2 errorCode2) {
        super(str2, z3);
        this.f25688e = http2Connection;
        this.f25689f = i;
        this.f25690g = errorCode2;
    }

    @Override // p600f0.p601e0.p604f.Task2
    /* renamed from: a */
    public long mo10150a() {
        this.f25688e.f25641w.mo10310c(this.f25689f, this.f25690g);
        synchronized (this.f25688e) {
            this.f25688e.f25629M.remove(Integer.valueOf(this.f25689f));
        }
        return -1L;
    }
}
