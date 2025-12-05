package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p408d.ExclusionStrategy;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p409p.Since2;
import p007b.p225i.p408d.p409p.Until;

/* loaded from: classes3.dex */
public final class Excluder implements TypeAdapterFactory2, Cloneable {

    /* renamed from: j */
    public static final Excluder f21483j = new Excluder();

    /* renamed from: k */
    public double f21484k = -1.0d;

    /* renamed from: l */
    public int f21485l = Opcodes.L2I;

    /* renamed from: m */
    public boolean f21486m = true;

    /* renamed from: n */
    public List<ExclusionStrategy> f21487n = Collections.emptyList();

    /* renamed from: o */
    public List<ExclusionStrategy> f21488o = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.gson.internal.Excluder$1 */
    public class C111001<T> extends TypeAdapter<T> {

        /* renamed from: a */
        public TypeAdapter<T> f21489a;

        /* renamed from: b */
        public final /* synthetic */ boolean f21490b;

        /* renamed from: c */
        public final /* synthetic */ boolean f21491c;

        /* renamed from: d */
        public final /* synthetic */ Gson f21492d;

        /* renamed from: e */
        public final /* synthetic */ TypeToken f21493e;

        public C111001(boolean z2, boolean z3, Gson gson, TypeToken typeToken) {
            this.f21490b = z2;
            this.f21491c = z3;
            this.f21492d = gson;
            this.f21493e = typeToken;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (this.f21490b) {
                jsonReader.mo6879U();
                return null;
            }
            TypeAdapter<T> typeAdapterM9206j = this.f21489a;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21492d.m9206j(Excluder.this, this.f21493e);
                this.f21489a = typeAdapterM9206j;
            }
            return typeAdapterM9206j.read(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (this.f21491c) {
                jsonWriter.mo6905s();
                return;
            }
            TypeAdapter<T> typeAdapterM9206j = this.f21489a;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21492d.m9206j(Excluder.this, this.f21493e);
                this.f21489a = typeAdapterM9206j;
            }
            typeAdapterM9206j.write(jsonWriter, t);
        }
    }

    /* renamed from: b */
    public final boolean m9217b(Class<?> cls) {
        if (this.f21484k == -1.0d || m9221i((Since2) cls.getAnnotation(Since2.class), (Until) cls.getAnnotation(Until.class))) {
            return (!this.f21486m && m9220h(cls)) || m9219g(cls);
        }
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zM9217b = m9217b(rawType);
        boolean z2 = zM9217b || m9218f(rawType, true);
        boolean z3 = zM9217b || m9218f(rawType, false);
        if (z2 || z3) {
            return new C111001(z3, z2, gson, typeToken);
        }
        return null;
    }

    /* renamed from: f */
    public final boolean m9218f(Class<?> cls, boolean z2) {
        Iterator<ExclusionStrategy> it = (z2 ? this.f21487n : this.f21488o).iterator();
        while (it.hasNext()) {
            if (it.next().m6847b(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public final boolean m9219g(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: h */
    public final boolean m9220h(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public final boolean m9221i(Since2 since2, Until until) {
        if (since2 == null || since2.value() <= this.f21484k) {
            return until == null || (until.value() > this.f21484k ? 1 : (until.value() == this.f21484k ? 0 : -1)) > 0;
        }
        return false;
    }

    /* renamed from: j */
    public Excluder m9222j(int... iArr) {
        try {
            Excluder excluder = (Excluder) super.clone();
            excluder.f21485l = 0;
            for (int i : iArr) {
                excluder.f21485l = i | excluder.f21485l;
            }
            return excluder;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
