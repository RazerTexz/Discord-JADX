package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Visibility.kt */
/* renamed from: d0.e0.p.d.m0.c.f1, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Visibility2 {

    /* renamed from: a */
    public final String f22712a;

    /* renamed from: b */
    public final boolean f22713b;

    public Visibility2(String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f22712a = str;
        this.f22713b = z2;
    }

    public Integer compareTo(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        return Visibilities.f22694a.compareLocal$compiler_common(this, visibility2);
    }

    public String getInternalDisplayName() {
        return this.f22712a;
    }

    public final boolean isPublicAPI() {
        return this.f22713b;
    }

    public Visibility2 normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
