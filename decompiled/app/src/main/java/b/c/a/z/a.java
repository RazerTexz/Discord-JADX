package b.c.a.z;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    a(String str) {
        this.extension = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
