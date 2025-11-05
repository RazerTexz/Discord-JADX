package b.g.a.c.c0;

import b.g.a.c.c0.e0;
import b.g.a.c.c0.o;
import b.g.a.c.c0.t;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: AnnotatedFieldCollector.java */
/* loaded from: classes3.dex */
public class h extends u {
    public final b.g.a.c.h0.n d;
    public final t.a e;
    public final boolean f;

    /* compiled from: AnnotatedFieldCollector.java */
    public static final class a {
        public final e0 a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f690b;
        public o c = o.a.c;

        public a(e0 e0Var, Field field) {
            this.a = e0Var;
            this.f690b = field;
        }
    }

    public h(b.g.a.c.b bVar, b.g.a.c.h0.n nVar, t.a aVar, boolean z2) {
        super(bVar);
        this.d = nVar;
        this.e = bVar == null ? null : aVar;
        this.f = z2;
    }

    public final Map<String, a> f(e0 e0Var, b.g.a.c.j jVar, Map<String, a> map) {
        t.a aVar;
        Class<?> clsA;
        a aVar2;
        b.g.a.c.j jVarQ = jVar.q();
        if (jVarQ == null) {
            return map;
        }
        Class<?> cls = jVar._class;
        Map<String, a> mapF = f(new e0.a(this.d, jVarQ.j()), jVarQ, map);
        for (Field field : cls.getDeclaredFields()) {
            if (g(field)) {
                if (mapF == null) {
                    mapF = new LinkedHashMap<>();
                }
                a aVar3 = new a(e0Var, field);
                if (this.f) {
                    aVar3.c = b(aVar3.c, field.getDeclaredAnnotations());
                }
                mapF.put(field.getName(), aVar3);
            }
        }
        if (mapF != null && (aVar = this.e) != null && (clsA = aVar.a(cls)) != null) {
            Iterator it = ((ArrayList) b.g.a.c.i0.d.j(clsA, cls, true)).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (g(field2) && (aVar2 = mapF.get(field2.getName())) != null) {
                        aVar2.c = b(aVar2.c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapF;
    }

    public final boolean g(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }
}
