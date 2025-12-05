package p007b.p225i.p226a.p228b.p231j;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;

/* compiled from: TransportContext.java */
@AutoValue
/* renamed from: b.i.a.b.j.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class TransportContext {

    /* compiled from: TransportContext.java */
    @AutoValue.Builder
    /* renamed from: b.i.a.b.j.i$a */
    public static abstract class a {
        /* renamed from: a */
        public abstract TransportContext mo2351a();

        /* renamed from: b */
        public abstract a mo2352b(String str);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* renamed from: c */
        public abstract a mo2353c(Priority3 priority3);
    }

    /* renamed from: a */
    public static a m2358a() {
        AutoValue_TransportContext.b bVar = new AutoValue_TransportContext.b();
        bVar.mo2353c(Priority3.DEFAULT);
        return bVar;
    }

    /* renamed from: b */
    public abstract String mo2348b();

    @Nullable
    /* renamed from: c */
    public abstract byte[] mo2349c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: d */
    public abstract Priority3 mo2350d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = mo2348b();
        objArr[1] = mo2350d();
        objArr[2] = mo2349c() == null ? "" : Base64.encodeToString(mo2349c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
