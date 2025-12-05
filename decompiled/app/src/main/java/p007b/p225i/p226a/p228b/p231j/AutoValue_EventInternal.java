package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.EventInternal;

/* compiled from: AutoValue_EventInternal.java */
/* renamed from: b.i.a.b.j.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a */
    public final String f5246a;

    /* renamed from: b */
    public final Integer f5247b;

    /* renamed from: c */
    public final EncodedPayload f5248c;

    /* renamed from: d */
    public final long f5249d;

    /* renamed from: e */
    public final long f5250e;

    /* renamed from: f */
    public final Map<String, String> f5251f;

    /* compiled from: AutoValue_EventInternal.java */
    /* renamed from: b.i.a.b.j.a$b */
    public static final class b extends EventInternal.a {

        /* renamed from: a */
        public String f5252a;

        /* renamed from: b */
        public Integer f5253b;

        /* renamed from: c */
        public EncodedPayload f5254c;

        /* renamed from: d */
        public Long f5255d;

        /* renamed from: e */
        public Long f5256e;

        /* renamed from: f */
        public Map<String, String> f5257f;

        @Override // p007b.p225i.p226a.p228b.p231j.EventInternal.a
        /* renamed from: b */
        public EventInternal mo2342b() {
            String strM883w = this.f5252a == null ? " transportName" : "";
            if (this.f5254c == null) {
                strM883w = outline.m883w(strM883w, " encodedPayload");
            }
            if (this.f5255d == null) {
                strM883w = outline.m883w(strM883w, " eventMillis");
            }
            if (this.f5256e == null) {
                strM883w = outline.m883w(strM883w, " uptimeMillis");
            }
            if (this.f5257f == null) {
                strM883w = outline.m883w(strM883w, " autoMetadata");
            }
            if (strM883w.isEmpty()) {
                return new AutoValue_EventInternal(this.f5252a, this.f5253b, this.f5254c, this.f5255d.longValue(), this.f5256e.longValue(), this.f5257f, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.EventInternal.a
        /* renamed from: c */
        public Map<String, String> mo2343c() {
            Map<String, String> map = this.f5257f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* renamed from: d */
        public EventInternal.a m2344d(EncodedPayload encodedPayload) {
            Objects.requireNonNull(encodedPayload, "Null encodedPayload");
            this.f5254c = encodedPayload;
            return this;
        }

        /* renamed from: e */
        public EventInternal.a m2345e(long j) {
            this.f5255d = Long.valueOf(j);
            return this;
        }

        /* renamed from: f */
        public EventInternal.a m2346f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f5252a = str;
            return this;
        }

        /* renamed from: g */
        public EventInternal.a m2347g(long j) {
            this.f5256e = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, Map map, a aVar) {
        this.f5246a = str;
        this.f5247b = num;
        this.f5248c = encodedPayload;
        this.f5249d = j;
        this.f5250e = j2;
        this.f5251f = map;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    /* renamed from: b */
    public Map<String, String> mo2336b() {
        return this.f5251f;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    @Nullable
    /* renamed from: c */
    public Integer mo2337c() {
        return this.f5247b;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    /* renamed from: d */
    public EncodedPayload mo2338d() {
        return this.f5248c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    /* renamed from: e */
    public long mo2339e() {
        return this.f5249d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        return this.f5246a.equals(eventInternal.mo2340g()) && ((num = this.f5247b) != null ? num.equals(eventInternal.mo2337c()) : eventInternal.mo2337c() == null) && this.f5248c.equals(eventInternal.mo2338d()) && this.f5249d == eventInternal.mo2339e() && this.f5250e == eventInternal.mo2341h() && this.f5251f.equals(eventInternal.mo2336b());
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    /* renamed from: g */
    public String mo2340g() {
        return this.f5246a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.EventInternal
    /* renamed from: h */
    public long mo2341h() {
        return this.f5250e;
    }

    public int hashCode() {
        int iHashCode = (this.f5246a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f5247b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f5248c.hashCode()) * 1000003;
        long j = this.f5249d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f5250e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f5251f.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EventInternal{transportName=");
        sbM833U.append(this.f5246a);
        sbM833U.append(", code=");
        sbM833U.append(this.f5247b);
        sbM833U.append(", encodedPayload=");
        sbM833U.append(this.f5248c);
        sbM833U.append(", eventMillis=");
        sbM833U.append(this.f5249d);
        sbM833U.append(", uptimeMillis=");
        sbM833U.append(this.f5250e);
        sbM833U.append(", autoMetadata=");
        return outline.m825M(sbM833U, this.f5251f, "}");
    }
}
