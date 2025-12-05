package p007b.p109f.p110a;

import java.io.File;
import java.util.Objects;

/* compiled from: FileBinaryResource.java */
/* renamed from: b.f.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class FileBinaryResource {

    /* renamed from: a */
    public final File f3016a;

    public FileBinaryResource(File file) {
        Objects.requireNonNull(file);
        this.f3016a = file;
    }

    /* renamed from: a */
    public long m928a() {
        return this.f3016a.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return this.f3016a.equals(((FileBinaryResource) obj).f3016a);
    }

    public int hashCode() {
        return this.f3016a.hashCode();
    }
}
