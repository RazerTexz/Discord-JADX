package b.i.c.u.p;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: InstallationResponse.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class d {

    /* compiled from: InstallationResponse.java */
    public enum a {
        OK,
        BAD_CONFIG
    }

    @Nullable
    public abstract f a();

    @Nullable
    public abstract String b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract a d();

    @Nullable
    public abstract String e();
}
