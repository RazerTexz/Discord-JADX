package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import p007b.p225i.p361c.p401u.p403p.AutoValue_TokenResult;

/* compiled from: TokenResult.java */
@AutoValue
/* renamed from: b.i.c.u.p.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class TokenResult {

    /* compiled from: TokenResult.java */
    @AutoValue.Builder
    /* renamed from: b.i.c.u.p.f$a */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public abstract TokenResult mo6800a();

        @NonNull
        /* renamed from: b */
        public abstract a mo6801b(long j);
    }

    /* compiled from: TokenResult.java */
    /* renamed from: b.i.c.u.p.f$b */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    /* renamed from: a */
    public static a m6813a() {
        AutoValue_TokenResult.b bVar = new AutoValue_TokenResult.b();
        bVar.mo6801b(0L);
        return bVar;
    }

    @Nullable
    /* renamed from: b */
    public abstract b mo6797b();

    @Nullable
    /* renamed from: c */
    public abstract String mo6798c();

    @NonNull
    /* renamed from: d */
    public abstract long mo6799d();
}
