package b.g.a.c.z;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* compiled from: ContextAttributes.java */
/* loaded from: classes3.dex */
public abstract class i {

    /* compiled from: ContextAttributes.java */
    public static class a extends i implements Serializable {
        public static final a j = new a(Collections.emptyMap());
        public static final Object k = new Object();
        private static final long serialVersionUID = 1;
        public final Map<?, ?> _shared;
        public transient Map<Object, Object> l;

        public a(Map<?, ?> map) {
            this._shared = map;
            this.l = null;
        }

        public a(Map<?, ?> map, Map<Object, Object> map2) {
            this._shared = map;
            this.l = map2;
        }
    }
}
