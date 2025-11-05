package b.g.a.c;

import b.g.a.a.h0;
import java.io.Serializable;

/* compiled from: PropertyMetadata.java */
/* loaded from: classes3.dex */
public class s implements Serializable {
    public static final s j = new s(Boolean.TRUE, null, null, null, null, null, null);
    public static final s k = new s(Boolean.FALSE, null, null, null, null, null, null);
    public static final s l = new s(null, null, null, null, null, null, null);
    private static final long serialVersionUID = -1;
    public h0 _contentNulls;
    public final String _defaultValue;
    public final String _description;
    public final Integer _index;
    public final Boolean _required;
    public h0 _valueNulls;
    public final transient a m;

    /* compiled from: PropertyMetadata.java */
    public static final class a {
        public a(b.g.a.c.c0.i iVar, boolean z2) {
        }
    }

    public s(Boolean bool, String str, Integer num, String str2, a aVar, h0 h0Var, h0 h0Var2) {
        this._required = bool;
        this._description = str;
        this._index = num;
        this._defaultValue = (str2 == null || str2.isEmpty()) ? null : str2;
        this.m = aVar;
        this._valueNulls = h0Var;
        this._contentNulls = h0Var2;
    }

    public s a(a aVar) {
        return new s(this._required, this._description, this._index, this._defaultValue, aVar, this._valueNulls, this._contentNulls);
    }

    public Object readResolve() {
        if (this._description != null || this._index != null || this._defaultValue != null || this.m != null || this._valueNulls != null || this._contentNulls != null) {
            return this;
        }
        Boolean bool = this._required;
        return bool == null ? l : bool.booleanValue() ? j : k;
    }
}
