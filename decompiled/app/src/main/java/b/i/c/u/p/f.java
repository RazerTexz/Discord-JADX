package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.u.p.b;
import com.google.auto.value.AutoValue;

/* compiled from: TokenResult.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class f {

    /* compiled from: TokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract f a();

        @NonNull
        public abstract a b(long j);
    }

    /* compiled from: TokenResult.java */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static a a() {
        b.C0154b c0154b = new b.C0154b();
        c0154b.b(0L);
        return c0154b;
    }

    @Nullable
    public abstract b b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
