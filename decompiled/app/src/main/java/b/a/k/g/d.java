package b.a.k.g;

import d0.g;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: FormattingParserProvider.kt */
/* loaded from: classes.dex */
public final class d extends b.a.k.g.b {
    public static final Lazy a = g.lazy(a.j);

    /* renamed from: b, reason: collision with root package name */
    public static final d f247b = null;
    public final ThreadLocal<b.a.k.g.a> c = new b();

    /* compiled from: FormattingParserProvider.kt */
    public static final class a extends o implements Function0<d> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public d invoke() {
            return new d();
        }
    }

    /* compiled from: FormattingParserProvider.kt */
    public static final class b extends ThreadLocal<b.a.k.g.a> {
        @Override // java.lang.ThreadLocal
        public b.a.k.g.a initialValue() {
            return new b.a.k.g.a();
        }
    }

    @Override // b.a.k.g.b
    public b.a.k.g.a a() {
        b.a.k.g.a aVar = this.c.get();
        m.checkNotNull(aVar);
        return aVar;
    }
}
