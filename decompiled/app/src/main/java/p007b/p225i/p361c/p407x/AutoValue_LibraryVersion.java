package p007b.p225i.p361c.p407x;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.c.x.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {

    /* JADX INFO: renamed from: a */
    public final String f13079a;

    /* JADX INFO: renamed from: b */
    public final String f13080b;

    public AutoValue_LibraryVersion(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f13079a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f13080b = str2;
    }

    @Override // p007b.p225i.p361c.p407x.LibraryVersion
    /* JADX INFO: renamed from: a */
    public String mo6843a() {
        return this.f13079a;
    }

    @Override // p007b.p225i.p361c.p407x.LibraryVersion
    /* JADX INFO: renamed from: b */
    public String mo6844b() {
        return this.f13080b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.f13079a.equals(libraryVersion.mo6843a()) && this.f13080b.equals(libraryVersion.mo6844b());
    }

    public int hashCode() {
        return ((this.f13079a.hashCode() ^ 1000003) * 1000003) ^ this.f13080b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("LibraryVersion{libraryName=");
        sbM833U.append(this.f13079a);
        sbM833U.append(", version=");
        return outline.m822J(sbM833U, this.f13080b, "}");
    }
}
