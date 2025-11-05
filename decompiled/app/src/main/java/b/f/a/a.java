package b.f.a;

import java.io.File;
import java.util.Objects;

/* compiled from: FileBinaryResource.java */
/* loaded from: classes.dex */
public class a {
    public final File a;

    public a(File file) {
        Objects.requireNonNull(file);
        this.a = file;
    }

    public long a() {
        return this.a.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return this.a.equals(((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
