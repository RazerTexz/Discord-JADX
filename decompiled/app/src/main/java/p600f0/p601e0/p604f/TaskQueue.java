package p600f0.p601e0.p604f;

import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
/* renamed from: f0.e0.f.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class TaskQueue extends Task2 {

    /* renamed from: e */
    public final /* synthetic */ Function0 f25413e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue(Function0 function0, String str, boolean z2, String str2, boolean z3) {
        super(str2, z3);
        this.f25413e = function0;
    }

    @Override // p600f0.p601e0.p604f.Task2
    /* renamed from: a */
    public long mo10150a() {
        this.f25413e.invoke();
        return -1L;
    }
}
