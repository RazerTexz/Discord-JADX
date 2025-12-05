package p007b.p195g.p196a.p205c.p212e0;

import java.io.Serializable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: NamedType.java */
/* renamed from: b.g.a.c.e0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class NamedType implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _class;
    public final int _hashCode;
    public String _name;

    public NamedType(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this._name = (str == null || str.isEmpty()) ? null : str;
    }

    /* renamed from: a */
    public boolean m1944a() {
        return this._name != null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != NamedType.class) {
            return false;
        }
        NamedType namedType = (NamedType) obj;
        return this._class == namedType._class && Objects.equals(this._name, namedType._name);
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[NamedType, class ");
        outline.m860k0(this._class, sbM833U, ", name: ");
        return outline.m822J(sbM833U, this._name == null ? "null" : outline.m822J(outline.m833U("'"), this._name, "'"), "]");
    }
}
