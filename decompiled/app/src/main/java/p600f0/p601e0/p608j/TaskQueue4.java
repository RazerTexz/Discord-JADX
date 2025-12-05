package p600f0.p601e0.p608j;

import java.io.IOException;
import p600f0.p601e0.p604f.Task2;
import p615g0.Buffer3;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.j.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue4 extends Task2 {

    /* renamed from: e */
    public final /* synthetic */ Http2Connection f25676e;

    /* renamed from: f */
    public final /* synthetic */ int f25677f;

    /* renamed from: g */
    public final /* synthetic */ Buffer3 f25678g;

    /* renamed from: h */
    public final /* synthetic */ int f25679h;

    /* renamed from: i */
    public final /* synthetic */ boolean f25680i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue4(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, Buffer3 buffer3, int i2, boolean z4) {
        super(str2, z3);
        this.f25676e = http2Connection;
        this.f25677f = i;
        this.f25678g = buffer3;
        this.f25679h = i2;
        this.f25680i = z4;
    }

    @Override // p600f0.p601e0.p604f.Task2
    /* renamed from: a */
    public long mo10150a() {
        try {
            boolean zMo10311d = this.f25676e.f25641w.mo10311d(this.f25677f, this.f25678g, this.f25679h, this.f25680i);
            if (zMo10311d) {
                this.f25676e.f25627K.m10304n(this.f25677f, ErrorCode2.CANCEL);
            }
            if (!zMo10311d && !this.f25680i) {
                return -1L;
            }
            synchronized (this.f25676e) {
                this.f25676e.f25629M.remove(Integer.valueOf(this.f25677f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
