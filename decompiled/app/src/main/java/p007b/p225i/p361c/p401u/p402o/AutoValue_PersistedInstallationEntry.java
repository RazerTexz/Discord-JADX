package p007b.p225i.p361c.p401u.p402o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallation;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;

/* compiled from: AutoValue_PersistedInstallationEntry.java */
/* renamed from: b.i.c.u.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* renamed from: b */
    public final String f12952b;

    /* renamed from: c */
    public final PersistedInstallation.a f12953c;

    /* renamed from: d */
    public final String f12954d;

    /* renamed from: e */
    public final String f12955e;

    /* renamed from: f */
    public final long f12956f;

    /* renamed from: g */
    public final long f12957g;

    /* renamed from: h */
    public final String f12958h;

    /* compiled from: AutoValue_PersistedInstallationEntry.java */
    /* renamed from: b.i.c.u.o.a$b */
    public static final class b extends PersistedInstallationEntry.a {

        /* renamed from: a */
        public String f12959a;

        /* renamed from: b */
        public PersistedInstallation.a f12960b;

        /* renamed from: c */
        public String f12961c;

        /* renamed from: d */
        public String f12962d;

        /* renamed from: e */
        public Long f12963e;

        /* renamed from: f */
        public Long f12964f;

        /* renamed from: g */
        public String f12965g;

        public b() {
        }

        @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry.a
        /* renamed from: a */
        public PersistedInstallationEntry mo6782a() {
            String strM883w = this.f12960b == null ? " registrationStatus" : "";
            if (this.f12963e == null) {
                strM883w = outline.m883w(strM883w, " expiresInSecs");
            }
            if (this.f12964f == null) {
                strM883w = outline.m883w(strM883w, " tokenCreationEpochInSecs");
            }
            if (strM883w.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.f12959a, this.f12960b, this.f12961c, this.f12962d, this.f12963e.longValue(), this.f12964f.longValue(), this.f12965g, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry.a
        /* renamed from: b */
        public PersistedInstallationEntry.a mo6783b(PersistedInstallation.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f12960b = aVar;
            return this;
        }

        /* renamed from: c */
        public PersistedInstallationEntry.a m6784c(long j) {
            this.f12963e = Long.valueOf(j);
            return this;
        }

        /* renamed from: d */
        public PersistedInstallationEntry.a m6785d(long j) {
            this.f12964f = Long.valueOf(j);
            return this;
        }

        public b(PersistedInstallationEntry persistedInstallationEntry, a aVar) {
            AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
            this.f12959a = autoValue_PersistedInstallationEntry.f12952b;
            this.f12960b = autoValue_PersistedInstallationEntry.f12953c;
            this.f12961c = autoValue_PersistedInstallationEntry.f12954d;
            this.f12962d = autoValue_PersistedInstallationEntry.f12955e;
            this.f12963e = Long.valueOf(autoValue_PersistedInstallationEntry.f12956f);
            this.f12964f = Long.valueOf(autoValue_PersistedInstallationEntry.f12957g);
            this.f12965g = autoValue_PersistedInstallationEntry.f12958h;
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.a aVar, String str2, String str3, long j, long j2, String str4, a aVar2) {
        this.f12952b = str;
        this.f12953c = aVar;
        this.f12954d = str2;
        this.f12955e = str3;
        this.f12956f = j;
        this.f12957g = j2;
        this.f12958h = str4;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    @Nullable
    /* renamed from: a */
    public String mo6774a() {
        return this.f12954d;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    /* renamed from: b */
    public long mo6775b() {
        return this.f12956f;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    @Nullable
    /* renamed from: c */
    public String mo6776c() {
        return this.f12952b;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    @Nullable
    /* renamed from: d */
    public String mo6777d() {
        return this.f12958h;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    @Nullable
    /* renamed from: e */
    public String mo6778e() {
        return this.f12955e;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f12952b;
        if (str3 != null ? str3.equals(persistedInstallationEntry.mo6776c()) : persistedInstallationEntry.mo6776c() == null) {
            if (this.f12953c.equals(persistedInstallationEntry.mo6779f()) && ((str = this.f12954d) != null ? str.equals(persistedInstallationEntry.mo6774a()) : persistedInstallationEntry.mo6774a() == null) && ((str2 = this.f12955e) != null ? str2.equals(persistedInstallationEntry.mo6778e()) : persistedInstallationEntry.mo6778e() == null) && this.f12956f == persistedInstallationEntry.mo6775b() && this.f12957g == persistedInstallationEntry.mo6780g()) {
                String str4 = this.f12958h;
                if (str4 == null) {
                    if (persistedInstallationEntry.mo6777d() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.mo6777d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    @NonNull
    /* renamed from: f */
    public PersistedInstallation.a mo6779f() {
        return this.f12953c;
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    /* renamed from: g */
    public long mo6780g() {
        return this.f12957g;
    }

    public int hashCode() {
        String str = this.f12952b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f12953c.hashCode()) * 1000003;
        String str2 = this.f12954d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12955e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f12956f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f12957g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f12958h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry
    /* renamed from: k */
    public PersistedInstallationEntry.a mo6781k() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("PersistedInstallationEntry{firebaseInstallationId=");
        sbM833U.append(this.f12952b);
        sbM833U.append(", registrationStatus=");
        sbM833U.append(this.f12953c);
        sbM833U.append(", authToken=");
        sbM833U.append(this.f12954d);
        sbM833U.append(", refreshToken=");
        sbM833U.append(this.f12955e);
        sbM833U.append(", expiresInSecs=");
        sbM833U.append(this.f12956f);
        sbM833U.append(", tokenCreationEpochInSecs=");
        sbM833U.append(this.f12957g);
        sbM833U.append(", fisError=");
        return outline.m822J(sbM833U, this.f12958h, "}");
    }
}
