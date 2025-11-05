package b.i.a.b.j;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.i.a.b.j.b;
import com.google.auto.value.AutoValue;

/* compiled from: TransportContext.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class i {

    /* compiled from: TransportContext.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract i a();

        public abstract a b(String str);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public abstract a c(b.i.a.b.d dVar);
    }

    public static a a() {
        b.C0087b c0087b = new b.C0087b();
        c0087b.c(b.i.a.b.d.DEFAULT);
        return c0087b;
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract b.i.a.b.d d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
