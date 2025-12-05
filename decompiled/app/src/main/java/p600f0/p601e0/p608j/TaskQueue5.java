package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p600f0.p601e0.p604f.Task2;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.j.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue5 extends Task2 {

    /* renamed from: e */
    public final /* synthetic */ Http2Connection f25681e;

    /* renamed from: f */
    public final /* synthetic */ int f25682f;

    /* renamed from: g */
    public final /* synthetic */ List f25683g;

    /* renamed from: h */
    public final /* synthetic */ boolean f25684h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue5(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, List list, boolean z4) {
        super(str2, z3);
        this.f25681e = http2Connection;
        this.f25682f = i;
        this.f25683g = list;
        this.f25684h = z4;
    }

    @Override // p600f0.p601e0.p604f.Task2
    /* renamed from: a */
    public long mo10150a() {
        boolean zMo10309b = this.f25681e.f25641w.mo10309b(this.f25682f, this.f25683g, this.f25684h);
        if (zMo10309b) {
            try {
                this.f25681e.f25627K.m10304n(this.f25682f, ErrorCode2.CANCEL);
            } catch (IOException unused) {
                return -1L;
            }
        }
        if (!zMo10309b && !this.f25684h) {
            return -1L;
        }
        synchronized (this.f25681e) {
            this.f25681e.f25629M.remove(Integer.valueOf(this.f25682f));
        }
        return -1L;
    }
}
