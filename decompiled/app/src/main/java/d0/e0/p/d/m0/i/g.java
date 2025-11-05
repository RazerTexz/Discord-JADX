package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.a;
import d0.e0.p.d.m0.i.f;
import d0.e0.p.d.m0.i.h;
import d0.e0.p.d.m0.i.n;
import d0.e0.p.d.m0.i.w;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* compiled from: GeneratedMessageLite.java */
/* loaded from: classes3.dex */
public abstract class g extends d0.e0.p.d.m0.i.a implements Serializable {

    /* compiled from: GeneratedMessageLite.java */
    public static abstract class b<MessageType extends g, BuilderType extends b> extends a.AbstractC0556a<BuilderType> {
        public d0.e0.p.d.m0.i.c j = d0.e0.p.d.m0.i.c.j;

        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
            return clone();
        }

        public final d0.e0.p.d.m0.i.c getUnknownFields() {
            return this.j;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(d0.e0.p.d.m0.i.c cVar) {
            this.j = cVar;
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements o {
        public d0.e0.p.d.m0.i.f<e> k = d0.e0.p.d.m0.i.f.emptySet();
        public boolean l;

        public final void b(MessageType messagetype) {
            if (!this.l) {
                this.k = this.k.clone();
                this.l = true;
            }
            this.k.mergeFrom(d.a(messagetype));
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    public static final class e implements f.a<e> {
        public final h.b<?> j;
        public final int k;
        public final w.b l;
        public final boolean m;
        public final boolean n;

        public e(h.b<?> bVar, int i, w.b bVar2, boolean z2, boolean z3) {
            this.j = bVar;
            this.k = i;
            this.l = bVar2;
            this.m = z2;
            this.n = z3;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((e) obj);
        }

        public h.b<?> getEnumType() {
            return this.j;
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public w.c getLiteJavaType() {
            return this.l.getJavaType();
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public w.b getLiteType() {
            return this.l;
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public int getNumber() {
            return this.k;
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public n.a internalMergeFrom(n.a aVar, n nVar) {
            return ((b) aVar).mergeFrom((g) nVar);
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public boolean isPacked() {
            return this.n;
        }

        @Override // d0.e0.p.d.m0.i.f.a
        public boolean isRepeated() {
            return this.m;
        }

        public int compareTo(e eVar) {
            return this.k - eVar.k;
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    public static class f<ContainingType extends n, Type> {
        public final ContainingType a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f3431b;
        public final n c;
        public final e d;
        public final Method e;

        public f(ContainingType containingtype, Type type, n nVar, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.getLiteType() == w.b.t && nVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = containingtype;
            this.f3431b = type;
            this.c = nVar;
            this.d = eVar;
            if (!h.a.class.isAssignableFrom(cls)) {
                this.e = null;
                return;
            }
            try {
                this.e = cls.getMethod("valueOf", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                b.d.b.a.a.s0(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                sb.append("\".");
                throw new RuntimeException(sb.toString(), e);
            }
        }

        public Object a(Object obj) {
            if (this.d.getLiteJavaType() != w.c.ENUM) {
                return obj;
            }
            try {
                return this.e.invoke(null, (Integer) obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }

        public Object b(Object obj) {
            return this.d.getLiteJavaType() == w.c.ENUM ? Integer.valueOf(((h.a) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.a;
        }

        public n getMessageDefaultInstance() {
            return this.c;
        }

        public int getNumber() {
            return this.d.getNumber();
        }
    }

    public g() {
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, n nVar, h.b<?> bVar, int i, w.b bVar2, boolean z2, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), nVar, new e(bVar, i, bVar2, true, z2), cls);
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, n nVar, h.b<?> bVar, int i, w.b bVar2, Class cls) {
        return new f<>(containingtype, type, nVar, new e(bVar, i, bVar2, false, false), cls);
    }

    /* compiled from: GeneratedMessageLite.java */
    public static abstract class d<MessageType extends d<MessageType>> extends g implements o {
        private final d0.e0.p.d.m0.i.f<e> extensions;

        /* compiled from: GeneratedMessageLite.java */
        public class a {
            public final Iterator<Map.Entry<e, Object>> a;

            /* renamed from: b, reason: collision with root package name */
            public Map.Entry<e, Object> f3430b;
            public final boolean c;

            public a(boolean z2, a aVar) {
                Iterator<Map.Entry<e, Object>> it = d.a(d.this).iterator();
                this.a = it;
                if (it.hasNext()) {
                    this.f3430b = it.next();
                }
                this.c = z2;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f3430b;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    e key = this.f3430b.getKey();
                    if (this.c && key.getLiteJavaType() == w.c.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (n) this.f3430b.getValue());
                    } else {
                        d0.e0.p.d.m0.i.f.writeField(key, this.f3430b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.f3430b = this.a.next();
                    } else {
                        this.f3430b = null;
                    }
                }
            }
        }

        public d() {
            this.extensions = d0.e0.p.d.m0.i.f.newFieldSet();
        }

        public static /* synthetic */ d0.e0.p.d.m0.i.f a(d dVar) {
            return dVar.extensions;
        }

        public boolean b() {
            return this.extensions.isInitialized();
        }

        public int c() {
            return this.extensions.getSerializedSize();
        }

        public void d() {
            this.extensions.makeImmutable();
        }

        public d<MessageType>.a e() {
            return new a(false, null);
        }

        public boolean f(d0.e0.p.d.m0.i.d dVar, CodedOutputStream codedOutputStream, d0.e0.p.d.m0.i.e eVar, int i) throws IOException {
            boolean z2;
            boolean z3;
            Object objBuild;
            n nVar;
            d0.e0.p.d.m0.i.f<e> fVar = this.extensions;
            int i2 = i & 7;
            f fVarFindLiteExtensionByNumber = eVar.findLiteExtensionByNumber(getDefaultInstanceForType(), w.getTagFieldNumber(i));
            if (fVarFindLiteExtensionByNumber == null) {
                z2 = true;
                z3 = false;
            } else if (i2 == d0.e0.p.d.m0.i.f.c(fVarFindLiteExtensionByNumber.d.getLiteType(), false)) {
                z2 = false;
                z3 = false;
            } else {
                e eVar2 = fVarFindLiteExtensionByNumber.d;
                if (eVar2.m && eVar2.l.isPackable() && i2 == d0.e0.p.d.m0.i.f.c(fVarFindLiteExtensionByNumber.d.getLiteType(), true)) {
                    z2 = false;
                    z3 = true;
                }
                z2 = true;
                z3 = false;
            }
            if (z2) {
                return dVar.skipField(i, codedOutputStream);
            }
            if (z3) {
                int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                if (fVarFindLiteExtensionByNumber.d.getLiteType() == w.b.w) {
                    while (dVar.getBytesUntilLimit() > 0) {
                        h.a aVarFindValueByNumber = fVarFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(dVar.readEnum());
                        if (aVarFindValueByNumber == null) {
                            return true;
                        }
                        fVar.addRepeatedField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(aVarFindValueByNumber));
                    }
                } else {
                    while (dVar.getBytesUntilLimit() > 0) {
                        fVar.addRepeatedField(fVarFindLiteExtensionByNumber.d, d0.e0.p.d.m0.i.f.readPrimitiveField(dVar, fVarFindLiteExtensionByNumber.d.getLiteType(), false));
                    }
                }
                dVar.popLimit(iPushLimit);
                return true;
            }
            int iOrdinal = fVarFindLiteExtensionByNumber.d.getLiteJavaType().ordinal();
            if (iOrdinal == 7) {
                int i3 = dVar.readEnum();
                h.a aVarFindValueByNumber2 = fVarFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(i3);
                if (aVarFindValueByNumber2 == null) {
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeUInt32NoTag(i3);
                    return true;
                }
                objBuild = aVarFindValueByNumber2;
            } else if (iOrdinal != 8) {
                objBuild = d0.e0.p.d.m0.i.f.readPrimitiveField(dVar, fVarFindLiteExtensionByNumber.d.getLiteType(), false);
            } else {
                n.a aVarNewBuilderForType = null;
                if (!fVarFindLiteExtensionByNumber.d.isRepeated() && (nVar = (n) fVar.getField(fVarFindLiteExtensionByNumber.d)) != null) {
                    aVarNewBuilderForType = nVar.toBuilder();
                }
                if (aVarNewBuilderForType == null) {
                    aVarNewBuilderForType = fVarFindLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                }
                if (fVarFindLiteExtensionByNumber.d.getLiteType() == w.b.f3434s) {
                    dVar.readGroup(fVarFindLiteExtensionByNumber.getNumber(), aVarNewBuilderForType, eVar);
                } else {
                    dVar.readMessage(aVarNewBuilderForType, eVar);
                }
                objBuild = aVarNewBuilderForType.build();
            }
            if (fVarFindLiteExtensionByNumber.d.isRepeated()) {
                fVar.addRepeatedField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(objBuild));
                return true;
            }
            fVar.setField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(objBuild));
            return true;
        }

        public final void g(f<MessageType, ?> fVar) {
            if (fVar.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [Type, java.util.ArrayList] */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            g(fVar);
            Type type = (Type) this.extensions.getField(fVar.d);
            if (type == null) {
                return fVar.f3431b;
            }
            if (!fVar.d.isRepeated()) {
                return (Type) fVar.a(type);
            }
            if (fVar.d.getLiteJavaType() != w.c.ENUM) {
                return type;
            }
            ?? r1 = (Type) new ArrayList();
            Iterator it = ((List) type).iterator();
            while (it.hasNext()) {
                r1.add(fVar.a(it.next()));
            }
            return r1;
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            g(fVar);
            return this.extensions.getRepeatedFieldCount(fVar.d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            g(fVar);
            return this.extensions.hasField(fVar.d);
        }

        public d(c<MessageType, ?> cVar) {
            cVar.k.makeImmutable();
            cVar.l = false;
            this.extensions = cVar.k;
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i) {
            g(fVar);
            return (Type) fVar.a(this.extensions.getRepeatedField(fVar.d, i));
        }
    }

    public g(b bVar) {
    }
}
