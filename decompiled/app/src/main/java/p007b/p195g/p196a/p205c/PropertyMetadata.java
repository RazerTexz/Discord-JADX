package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.Nulls;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;

/* JADX INFO: renamed from: b.g.a.c.s, reason: use source file name */
/* JADX INFO: compiled from: PropertyMetadata.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyMetadata implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final PropertyMetadata f5025j = new PropertyMetadata(Boolean.TRUE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: k */
    public static final PropertyMetadata f5026k = new PropertyMetadata(Boolean.FALSE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: l */
    public static final PropertyMetadata f5027l = new PropertyMetadata(null, null, null, null, null, null, null);
    private static final long serialVersionUID = -1;
    public Nulls _contentNulls;
    public final String _defaultValue;
    public final String _description;
    public final Integer _index;
    public final Boolean _required;
    public Nulls _valueNulls;

    /* JADX INFO: renamed from: m */
    public final transient a f5028m;

    /* JADX INFO: renamed from: b.g.a.c.s$a */
    /* JADX INFO: compiled from: PropertyMetadata.java */
    public static final class a {
        public a(AnnotatedMember annotatedMember, boolean z2) {
        }
    }

    public PropertyMetadata(Boolean bool, String str, Integer num, String str2, a aVar, Nulls nulls, Nulls nulls2) {
        this._required = bool;
        this._description = str;
        this._index = num;
        this._defaultValue = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f5028m = aVar;
        this._valueNulls = nulls;
        this._contentNulls = nulls2;
    }

    /* JADX INFO: renamed from: a */
    public PropertyMetadata m2226a(a aVar) {
        return new PropertyMetadata(this._required, this._description, this._index, this._defaultValue, aVar, this._valueNulls, this._contentNulls);
    }

    public Object readResolve() {
        if (this._description != null || this._index != null || this._defaultValue != null || this.f5028m != null || this._valueNulls != null || this._contentNulls != null) {
            return this;
        }
        Boolean bool = this._required;
        return bool == null ? f5027l : bool.booleanValue() ? f5025j : f5026k;
    }
}
