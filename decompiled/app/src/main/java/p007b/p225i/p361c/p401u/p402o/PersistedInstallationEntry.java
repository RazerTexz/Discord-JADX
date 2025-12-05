package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallation;

/* compiled from: PersistedInstallationEntry.java */
@AutoValue
/* renamed from: b.i.c.u.o.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class PersistedInstallationEntry {

    /* renamed from: a */
    public static final /* synthetic */ int f12977a = 0;

    /* compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    /* renamed from: b.i.c.u.o.d$a */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public abstract PersistedInstallationEntry mo6782a();

        @NonNull
        /* renamed from: b */
        public abstract a mo6783b(@NonNull PersistedInstallation.a aVar);
    }

    static {
        Long l = 0L;
        String strM883w = l == null ? " expiresInSecs" : "";
        if (l == null) {
            strM883w = outline.m883w(strM883w, " tokenCreationEpochInSecs");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }
        l.longValue();
        l.longValue();
    }

    @Nullable
    /* renamed from: a */
    public abstract String mo6774a();

    /* renamed from: b */
    public abstract long mo6775b();

    @Nullable
    /* renamed from: c */
    public abstract String mo6776c();

    @Nullable
    /* renamed from: d */
    public abstract String mo6777d();

    @Nullable
    /* renamed from: e */
    public abstract String mo6778e();

    @NonNull
    /* renamed from: f */
    public abstract PersistedInstallation.a mo6779f();

    /* renamed from: g */
    public abstract long mo6780g();

    /* renamed from: h */
    public boolean m6789h() {
        return mo6779f() == PersistedInstallation.a.REGISTER_ERROR;
    }

    /* renamed from: i */
    public boolean m6790i() {
        PersistedInstallation.a aVar = ((AutoValue_PersistedInstallationEntry) this).f12953c;
        return aVar == PersistedInstallation.a.NOT_GENERATED || aVar == PersistedInstallation.a.ATTEMPT_MIGRATION;
    }

    /* renamed from: j */
    public boolean m6791j() {
        return mo6779f() == PersistedInstallation.a.REGISTERED;
    }

    @NonNull
    /* renamed from: k */
    public abstract a mo6781k();
}
