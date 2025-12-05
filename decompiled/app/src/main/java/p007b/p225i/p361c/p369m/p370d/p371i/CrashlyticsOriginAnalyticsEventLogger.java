package p007b.p225i.p361c.p369m.p370d.p371i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;

/* compiled from: CrashlyticsOriginAnalyticsEventLogger.java */
/* renamed from: b.i.c.m.d.i.e, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {

    /* renamed from: a */
    @NonNull
    public final InterfaceC4549a f12251a;

    public CrashlyticsOriginAnalyticsEventLogger(@NonNull InterfaceC4549a interfaceC4549a) {
        this.f12251a = interfaceC4549a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger
    /* renamed from: a */
    public void mo6386a(@NonNull String str, @Nullable Bundle bundle) {
        this.f12251a.mo6338a("clx", str, bundle);
    }
}
