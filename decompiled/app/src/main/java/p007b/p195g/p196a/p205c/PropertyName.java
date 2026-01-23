package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p204t.InternCache;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.t, reason: use source file name */
/* JADX INFO: compiled from: PropertyName.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyName implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final PropertyName f5029j = new PropertyName("", null);

    /* JADX INFO: renamed from: k */
    public static final PropertyName f5030k = new PropertyName(new String(""), null);
    private static final long serialVersionUID = 1;
    public SerializableString _encodedSimple;
    public final String _namespace;
    public final String _simpleName;

    public PropertyName(String str) {
        Annotation[] annotationArr = ClassUtil.f4944a;
        this._simpleName = str;
        this._namespace = null;
    }

    /* JADX INFO: renamed from: a */
    public static PropertyName m2227a(String str) {
        return (str == null || str.isEmpty()) ? f5029j : new PropertyName(InternCache.f4602j.m1733a(str), null);
    }

    /* JADX INFO: renamed from: b */
    public static PropertyName m2228b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? f5029j : new PropertyName(InternCache.f4602j.m1733a(str), str2);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2229c() {
        return !this._simpleName.isEmpty();
    }

    /* JADX INFO: renamed from: d */
    public boolean m2230d() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PropertyName.class) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = this._simpleName;
        if (str == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!str.equals(propertyName._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        return str2 == null ? propertyName._namespace == null : str2.equals(propertyName._namespace);
    }

    public int hashCode() {
        String str = this._namespace;
        return str == null ? this._simpleName.hashCode() : str.hashCode() ^ this._simpleName.hashCode();
    }

    public Object readResolve() {
        String str;
        return (this._namespace == null && ((str = this._simpleName) == null || "".equals(str))) ? f5029j : this;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        StringBuilder sbM833U = outline.m833U("{");
        sbM833U.append(this._namespace);
        sbM833U.append("}");
        sbM833U.append(this._simpleName);
        return sbM833U.toString();
    }

    public PropertyName(String str, String str2) {
        Annotation[] annotationArr = ClassUtil.f4944a;
        this._simpleName = str == null ? "" : str;
        this._namespace = str2;
    }
}
