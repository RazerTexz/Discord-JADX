package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* compiled from: ContextAttributes.java */
/* renamed from: b.g.a.c.z.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ContextAttributes {

    /* compiled from: ContextAttributes.java */
    /* renamed from: b.g.a.c.z.i$a */
    public static class a extends ContextAttributes implements Serializable {

        /* renamed from: j */
        public static final a f5087j = new a(Collections.emptyMap());

        /* renamed from: k */
        public static final Object f5088k = new Object();
        private static final long serialVersionUID = 1;
        public final Map<?, ?> _shared;

        /* renamed from: l */
        public transient Map<Object, Object> f5089l;

        public a(Map<?, ?> map) {
            this._shared = map;
            this.f5089l = null;
        }

        public a(Map<?, ?> map, Map<Object, Object> map2) {
            this._shared = map;
            this.f5089l = map2;
        }
    }
}
