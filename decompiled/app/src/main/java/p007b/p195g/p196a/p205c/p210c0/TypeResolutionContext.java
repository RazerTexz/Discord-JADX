package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Type;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;

/* JADX INFO: renamed from: b.g.a.c.c0.e0, reason: use source file name */
/* JADX INFO: compiled from: TypeResolutionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeResolutionContext {

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$a */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class a implements TypeResolutionContext {

        /* JADX INFO: renamed from: j */
        public final TypeFactory f4702j;

        /* JADX INFO: renamed from: k */
        public final TypeBindings f4703k;

        public a(TypeFactory typeFactory, TypeBindings typeBindings) {
            this.f4702j = typeFactory;
            this.f4703k = typeBindings;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext
        /* JADX INFO: renamed from: a */
        public JavaType mo1831a(Type type) {
            return this.f4702j.m2160b(null, type, this.f4703k);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$b */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class b implements TypeResolutionContext {

        /* JADX INFO: renamed from: j */
        public final TypeFactory f4704j;

        public b(TypeFactory typeFactory) {
            this.f4704j = typeFactory;
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext
        /* JADX INFO: renamed from: a */
        public JavaType mo1831a(Type type) {
            return this.f4704j.m2160b(null, type, TypeFactory.f4926l);
        }
    }

    /* JADX INFO: renamed from: a */
    JavaType mo1831a(Type type);
}
