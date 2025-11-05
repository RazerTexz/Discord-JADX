package b.i.b.a;

import b.i.b.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Splitter.java */
/* loaded from: classes3.dex */
public final class k {
    public final b.i.b.a.b a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1645b;
    public final int c;

    /* compiled from: Splitter.java */
    public static abstract class a extends b.i.b.a.a<String> {
        public final CharSequence l;
        public final b.i.b.a.b m;
        public int p;
        public int o = 0;
        public final boolean n = false;

        public a(k kVar, CharSequence charSequence) {
            this.m = kVar.a;
            this.p = kVar.c;
            this.l = charSequence;
        }
    }

    /* compiled from: Splitter.java */
    public interface b {
    }

    public k(b bVar) {
        b.d dVar = b.d.f1641b;
        this.f1645b = bVar;
        this.a = dVar;
        this.c = Integer.MAX_VALUE;
    }

    public List<String> a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        j jVar = (j) this.f1645b;
        Objects.requireNonNull(jVar);
        i iVar = new i(jVar, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (iVar.hasNext()) {
            arrayList.add(iVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
