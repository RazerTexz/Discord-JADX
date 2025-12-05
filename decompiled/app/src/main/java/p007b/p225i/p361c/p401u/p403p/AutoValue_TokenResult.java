package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p401u.p403p.TokenResult;

/* compiled from: AutoValue_TokenResult.java */
/* renamed from: b.i.c.u.p.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_TokenResult extends TokenResult {

    /* renamed from: a */
    public final String f12983a;

    /* renamed from: b */
    public final long f12984b;

    /* renamed from: c */
    public final TokenResult.b f12985c;

    /* compiled from: AutoValue_TokenResult.java */
    /* renamed from: b.i.c.u.p.b$b */
    public static final class b extends TokenResult.a {

        /* renamed from: a */
        public String f12986a;

        /* renamed from: b */
        public Long f12987b;

        /* renamed from: c */
        public TokenResult.b f12988c;

        @Override // p007b.p225i.p361c.p401u.p403p.TokenResult.a
        /* renamed from: a */
        public TokenResult mo6800a() {
            String str = this.f12987b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.f12986a, this.f12987b.longValue(), this.f12988c, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", str));
        }

        @Override // p007b.p225i.p361c.p401u.p403p.TokenResult.a
        /* renamed from: b */
        public TokenResult.a mo6801b(long j) {
            this.f12987b = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_TokenResult(String str, long j, TokenResult.b bVar, a aVar) {
        this.f12983a = str;
        this.f12984b = j;
        this.f12985c = bVar;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.TokenResult
    @Nullable
    /* renamed from: b */
    public TokenResult.b mo6797b() {
        return this.f12985c;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.TokenResult
    @Nullable
    /* renamed from: c */
    public String mo6798c() {
        return this.f12983a;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.TokenResult
    @NonNull
    /* renamed from: d */
    public long mo6799d() {
        return this.f12984b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f12983a;
        if (str != null ? str.equals(tokenResult.mo6798c()) : tokenResult.mo6798c() == null) {
            if (this.f12984b == tokenResult.mo6799d()) {
                TokenResult.b bVar = this.f12985c;
                if (bVar == null) {
                    if (tokenResult.mo6797b() == null) {
                        return true;
                    }
                } else if (bVar.equals(tokenResult.mo6797b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12983a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f12984b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.b bVar = this.f12985c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TokenResult{token=");
        sbM833U.append(this.f12983a);
        sbM833U.append(", tokenExpirationTimestamp=");
        sbM833U.append(this.f12984b);
        sbM833U.append(", responseCode=");
        sbM833U.append(this.f12985c);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
