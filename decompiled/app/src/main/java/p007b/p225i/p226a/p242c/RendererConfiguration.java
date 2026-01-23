package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.h2, reason: use source file name */
/* JADX INFO: compiled from: RendererConfiguration.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RendererConfiguration {

    /* JADX INFO: renamed from: a */
    public static final RendererConfiguration f7117a = new RendererConfiguration(false);

    /* JADX INFO: renamed from: b */
    public final boolean f7118b;

    public RendererConfiguration(boolean z2) {
        this.f7118b = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && RendererConfiguration.class == obj.getClass() && this.f7118b == ((RendererConfiguration) obj).f7118b;
    }

    public int hashCode() {
        return !this.f7118b ? 1 : 0;
    }
}
