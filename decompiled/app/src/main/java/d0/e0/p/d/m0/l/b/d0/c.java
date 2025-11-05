package d0.e0.p.d.m0.l.b.d0;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.l.b.o;
import d0.z.d.m;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
/* loaded from: classes3.dex */
public final class c extends o implements d0.e0.p.d.m0.b.b {
    public static final a v = new a(null);

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final c create(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar, c0 c0Var, InputStream inputStream, boolean z2) throws IOException {
            m.checkNotNullParameter(bVar, "fqName");
            m.checkNotNullParameter(oVar, "storageManager");
            m.checkNotNullParameter(c0Var, "module");
            m.checkNotNullParameter(inputStream, "inputStream");
            try {
                d0.e0.p.d.m0.f.y.a from = d0.e0.p.d.m0.f.y.a.f.readFrom(inputStream);
                if (from == null) {
                    m.throwUninitializedPropertyAccessException("version");
                    throw null;
                }
                if (from.isCompatible()) {
                    d0.e0.p.d.m0.f.m from2 = d0.e0.p.d.m0.f.m.parseFrom(inputStream, d0.e0.p.d.m0.l.b.d0.a.m.getExtensionRegistry());
                    d0.y.b.closeFinally(inputStream, null);
                    m.checkNotNullExpressionValue(from2, "proto");
                    return new c(bVar, oVar, c0Var, from2, from, z2, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + d0.e0.p.d.m0.f.y.a.g + ", actual " + from + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    d0.y.b.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    public c(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar, c0 c0Var, d0.e0.p.d.m0.f.m mVar, d0.e0.p.d.m0.f.y.a aVar, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        super(bVar, oVar, c0Var, mVar, aVar, null);
    }
}
