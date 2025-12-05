package p600f0.p601e0.p608j;

import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p600f0.p601e0.p604f.Task2;
import p600f0.p601e0.p608j.Http2Connection;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.j.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue3 extends Task2 {

    /* renamed from: e */
    public final /* synthetic */ Http2Connection.d f25674e;

    /* renamed from: f */
    public final /* synthetic */ Ref$ObjectRef f25675f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue3(String str, boolean z2, String str2, boolean z3, Http2Connection.d dVar, boolean z4, Ref$ObjectRef ref$ObjectRef, Settings3 settings3, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
        super(str2, z3);
        this.f25674e = dVar;
        this.f25675f = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p600f0.p601e0.p604f.Task2
    /* renamed from: a */
    public long mo10150a() {
        Http2Connection http2Connection = this.f25674e.f25658k;
        http2Connection.f25631m.mo10192a(http2Connection, (Settings3) this.f25675f.element);
        return -1L;
    }
}
