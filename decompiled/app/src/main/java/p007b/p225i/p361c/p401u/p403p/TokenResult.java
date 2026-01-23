package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import p007b.p225i.p361c.p401u.p403p.AutoValue_TokenResult;

/* JADX INFO: renamed from: b.i.c.u.p.f, reason: use source file name */
/* JADX INFO: compiled from: TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class TokenResult {

    /* JADX INFO: renamed from: b.i.c.u.p.f$a */
    /* JADX INFO: compiled from: TokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        /* JADX INFO: renamed from: a */
        public abstract TokenResult mo6800a();

        @NonNull
        /* JADX INFO: renamed from: b */
        public abstract a mo6801b(long j);
    }

    /* JADX INFO: renamed from: b.i.c.u.p.f$b */
    /* JADX INFO: compiled from: TokenResult.java */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static a m6813a() {
        AutoValue_TokenResult.b bVar = new AutoValue_TokenResult.b();
        bVar.mo6801b(0L);
        return bVar;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract b mo6797b();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract String mo6798c();

    @NonNull
    /* JADX INFO: renamed from: d */
    public abstract long mo6799d();
}
