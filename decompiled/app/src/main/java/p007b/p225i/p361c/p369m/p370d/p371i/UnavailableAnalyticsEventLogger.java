package p007b.p225i.p361c.p369m.p370d.p371i;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* compiled from: UnavailableAnalyticsEventLogger.java */
/* renamed from: b.i.c.m.d.i.f, reason: use source file name */
/* loaded from: classes3.dex */
public class UnavailableAnalyticsEventLogger implements AnalyticsEventLogger {
    @Override // p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger
    /* renamed from: a */
    public void mo6386a(@NonNull String str, @Nullable Bundle bundle) {
        Logger3.f12227a.m6371b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
