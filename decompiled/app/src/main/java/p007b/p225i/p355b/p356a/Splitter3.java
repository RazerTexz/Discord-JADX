package p007b.p225i.p355b.p356a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p355b.p356a.CharMatcher;

/* JADX INFO: renamed from: b.i.b.a.k, reason: use source file name */
/* JADX INFO: compiled from: Splitter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Splitter3 {

    /* JADX INFO: renamed from: a */
    public final CharMatcher f11958a;

    /* JADX INFO: renamed from: b */
    public final b f11959b;

    /* JADX INFO: renamed from: c */
    public final int f11960c;

    /* JADX INFO: renamed from: b.i.b.a.k$a */
    /* JADX INFO: compiled from: Splitter.java */
    public static abstract class a extends AbstractIterator<String> {

        /* JADX INFO: renamed from: l */
        public final CharSequence f11961l;

        /* JADX INFO: renamed from: m */
        public final CharMatcher f11962m;

        /* JADX INFO: renamed from: p */
        public int f11965p;

        /* JADX INFO: renamed from: o */
        public int f11964o = 0;

        /* JADX INFO: renamed from: n */
        public final boolean f11963n = false;

        public a(Splitter3 splitter3, CharSequence charSequence) {
            this.f11962m = splitter3.f11958a;
            this.f11965p = splitter3.f11960c;
            this.f11961l = charSequence;
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.k$b */
    /* JADX INFO: compiled from: Splitter.java */
    public interface b {
    }

    public Splitter3(b bVar) {
        CharMatcher.d dVar = CharMatcher.d.f11942b;
        this.f11959b = bVar;
        this.f11958a = dVar;
        this.f11960c = Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: a */
    public List<String> m6215a(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Splitter2 splitter2 = (Splitter2) this.f11959b;
        Objects.requireNonNull(splitter2);
        Splitter splitter = new Splitter(splitter2, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (splitter.hasNext()) {
            arrayList.add(splitter.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
