package b.i.c.u.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.u.o.c;
import com.google.auto.value.AutoValue;

/* compiled from: PersistedInstallationEntry.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class d {
    public static final /* synthetic */ int a = 0;

    /* compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract d a();

        @NonNull
        public abstract a b(@NonNull c.a aVar);
    }

    static {
        Long l = 0L;
        String strW = l == null ? " expiresInSecs" : "";
        if (l == null) {
            strW = b.d.b.a.a.w(strW, " tokenCreationEpochInSecs");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        l.longValue();
        l.longValue();
    }

    @Nullable
    public abstract String a();

    public abstract long b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    @NonNull
    public abstract c.a f();

    public abstract long g();

    public boolean h() {
        return f() == c.a.REGISTER_ERROR;
    }

    public boolean i() {
        c.a aVar = ((b.i.c.u.o.a) this).c;
        return aVar == c.a.NOT_GENERATED || aVar == c.a.ATTEMPT_MIGRATION;
    }

    public boolean j() {
        return f() == c.a.REGISTERED;
    }

    @NonNull
    public abstract a k();
}
