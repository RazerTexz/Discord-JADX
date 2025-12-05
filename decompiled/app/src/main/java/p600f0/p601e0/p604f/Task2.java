package p600f0.p601e0.p604f;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Task.kt */
/* renamed from: f0.e0.f.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Task2 {

    /* renamed from: a */
    public TaskQueue2 f25409a;

    /* renamed from: b */
    public long f25410b;

    /* renamed from: c */
    public final String f25411c;

    /* renamed from: d */
    public final boolean f25412d;

    public Task2(String str, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f25411c = str;
        this.f25412d = z2;
        this.f25410b = -1L;
    }

    /* renamed from: a */
    public abstract long mo10150a();

    public String toString() {
        return this.f25411c;
    }

    public /* synthetic */ Task2(String str, boolean z2, int i) {
        this(str, (i & 2) != 0 ? true : z2);
    }
}
