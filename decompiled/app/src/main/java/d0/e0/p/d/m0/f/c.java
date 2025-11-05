package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.i.a;
import d0.e0.p.d.m0.i.c;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.h;
import d0.e0.p.d.m0.i.n;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class c extends g.d<c> implements d0.e0.p.d.m0.i.o {
    public static final c j;
    public static d0.e0.p.d.m0.i.p<c> k = new a();
    private int bitField0_;
    private int companionObjectName_;
    private List<d> constructor_;
    private List<g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<q> supertype_;
    private List<r> typeAlias_;
    private List<s> typeParameter_;
    private t typeTable_;
    private final d0.e0.p.d.m0.i.c unknownFields;
    private w versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* compiled from: ProtoBuf.java */
    public static class a extends d0.e0.p.d.m0.i.b<c> {
        @Override // d0.e0.p.d.m0.i.p
        public /* bridge */ /* synthetic */ Object parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
            return parsePartialFrom(dVar, eVar);
        }

        @Override // d0.e0.p.d.m0.i.p
        public c parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
            return new c(dVar, eVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends g.c<c, b> implements d0.e0.p.d.m0.i.o {
        public int m;
        public int o;
        public int p;
        public int n = 6;
        public List<s> q = Collections.emptyList();
        public List<q> r = Collections.emptyList();

        /* renamed from: s, reason: collision with root package name */
        public List<Integer> f3393s = Collections.emptyList();
        public List<Integer> t = Collections.emptyList();
        public List<d> u = Collections.emptyList();
        public List<i> v = Collections.emptyList();
        public List<n> w = Collections.emptyList();

        /* renamed from: x, reason: collision with root package name */
        public List<r> f3394x = Collections.emptyList();

        /* renamed from: y, reason: collision with root package name */
        public List<g> f3395y = Collections.emptyList();

        /* renamed from: z, reason: collision with root package name */
        public List<Integer> f3396z = Collections.emptyList();
        public t A = t.getDefaultInstance();
        public List<Integer> B = Collections.emptyList();
        public w C = w.getDefaultInstance();

        @Override // d0.e0.p.d.m0.i.n.a
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
            return build();
        }

        public c buildPartial() {
            c cVar = new c(this, (d0.e0.p.d.m0.f.a) null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c.r(cVar, this.n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c.s(cVar, this.o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c.t(cVar, this.p);
            if ((this.m & 8) == 8) {
                this.q = Collections.unmodifiableList(this.q);
                this.m &= -9;
            }
            c.v(cVar, this.q);
            if ((this.m & 16) == 16) {
                this.r = Collections.unmodifiableList(this.r);
                this.m &= -17;
            }
            c.x(cVar, this.r);
            if ((this.m & 32) == 32) {
                this.f3393s = Collections.unmodifiableList(this.f3393s);
                this.m &= -33;
            }
            c.z(cVar, this.f3393s);
            if ((this.m & 64) == 64) {
                this.t = Collections.unmodifiableList(this.t);
                this.m &= -65;
            }
            c.B(cVar, this.t);
            if ((this.m & 128) == 128) {
                this.u = Collections.unmodifiableList(this.u);
                this.m &= -129;
            }
            c.D(cVar, this.u);
            if ((this.m & 256) == 256) {
                this.v = Collections.unmodifiableList(this.v);
                this.m &= -257;
            }
            c.F(cVar, this.v);
            if ((this.m & 512) == 512) {
                this.w = Collections.unmodifiableList(this.w);
                this.m &= -513;
            }
            c.H(cVar, this.w);
            if ((this.m & 1024) == 1024) {
                this.f3394x = Collections.unmodifiableList(this.f3394x);
                this.m &= -1025;
            }
            c.J(cVar, this.f3394x);
            if ((this.m & 2048) == 2048) {
                this.f3395y = Collections.unmodifiableList(this.f3395y);
                this.m &= -2049;
            }
            c.i(cVar, this.f3395y);
            if ((this.m & 4096) == 4096) {
                this.f3396z = Collections.unmodifiableList(this.f3396z);
                this.m &= -4097;
            }
            c.k(cVar, this.f3396z);
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            c.l(cVar, this.A);
            if ((this.m & 16384) == 16384) {
                this.B = Collections.unmodifiableList(this.B);
                this.m &= -16385;
            }
            c.n(cVar, this.B);
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            c.o(cVar, this.C);
            c.p(cVar, i2);
            return cVar;
        }

        @Override // d0.e0.p.d.m0.i.g.b
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
        public /* bridge */ /* synthetic */ a.AbstractC0556a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
            return mergeFrom(dVar, eVar);
        }

        public b mergeTypeTable(t tVar) {
            if ((this.m & 8192) != 8192 || this.A == t.getDefaultInstance()) {
                this.A = tVar;
            } else {
                this.A = t.newBuilder(this.A).mergeFrom(tVar).buildPartial();
            }
            this.m |= 8192;
            return this;
        }

        public b mergeVersionRequirementTable(w wVar) {
            if ((this.m & 32768) != 32768 || this.C == w.getDefaultInstance()) {
                this.C = wVar;
            } else {
                this.C = w.newBuilder(this.C).mergeFrom(wVar).buildPartial();
            }
            this.m |= 32768;
            return this;
        }

        public b setCompanionObjectName(int i) {
            this.m |= 4;
            this.p = i;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
            return this;
        }

        public b setFqName(int i) {
            this.m |= 2;
            this.o = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.n.a
        public c build() {
            c cVarBuildPartial = buildPartial();
            if (cVarBuildPartial.isInitialized()) {
                return cVarBuildPartial;
            }
            throw new UninitializedMessageException(cVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public /* bridge */ /* synthetic */ g.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public /* bridge */ /* synthetic */ g.b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
            return mergeFrom((c) gVar);
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
        public /* bridge */ /* synthetic */ n.a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
            return mergeFrom(dVar, eVar);
        }

        public b mergeFrom(c cVar) {
            if (cVar == c.getDefaultInstance()) {
                return this;
            }
            if (cVar.hasFlags()) {
                setFlags(cVar.getFlags());
            }
            if (cVar.hasFqName()) {
                setFqName(cVar.getFqName());
            }
            if (cVar.hasCompanionObjectName()) {
                setCompanionObjectName(cVar.getCompanionObjectName());
            }
            if (!c.u(cVar).isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = c.u(cVar);
                    this.m &= -9;
                } else {
                    if ((this.m & 8) != 8) {
                        this.q = new ArrayList(this.q);
                        this.m |= 8;
                    }
                    this.q.addAll(c.u(cVar));
                }
            }
            if (!c.w(cVar).isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = c.w(cVar);
                    this.m &= -17;
                } else {
                    if ((this.m & 16) != 16) {
                        this.r = new ArrayList(this.r);
                        this.m |= 16;
                    }
                    this.r.addAll(c.w(cVar));
                }
            }
            if (!c.y(cVar).isEmpty()) {
                if (this.f3393s.isEmpty()) {
                    this.f3393s = c.y(cVar);
                    this.m &= -33;
                } else {
                    if ((this.m & 32) != 32) {
                        this.f3393s = new ArrayList(this.f3393s);
                        this.m |= 32;
                    }
                    this.f3393s.addAll(c.y(cVar));
                }
            }
            if (!c.A(cVar).isEmpty()) {
                if (this.t.isEmpty()) {
                    this.t = c.A(cVar);
                    this.m &= -65;
                } else {
                    if ((this.m & 64) != 64) {
                        this.t = new ArrayList(this.t);
                        this.m |= 64;
                    }
                    this.t.addAll(c.A(cVar));
                }
            }
            if (!c.C(cVar).isEmpty()) {
                if (this.u.isEmpty()) {
                    this.u = c.C(cVar);
                    this.m &= -129;
                } else {
                    if ((this.m & 128) != 128) {
                        this.u = new ArrayList(this.u);
                        this.m |= 128;
                    }
                    this.u.addAll(c.C(cVar));
                }
            }
            if (!c.E(cVar).isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = c.E(cVar);
                    this.m &= -257;
                } else {
                    if ((this.m & 256) != 256) {
                        this.v = new ArrayList(this.v);
                        this.m |= 256;
                    }
                    this.v.addAll(c.E(cVar));
                }
            }
            if (!c.G(cVar).isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = c.G(cVar);
                    this.m &= -513;
                } else {
                    if ((this.m & 512) != 512) {
                        this.w = new ArrayList(this.w);
                        this.m |= 512;
                    }
                    this.w.addAll(c.G(cVar));
                }
            }
            if (!c.I(cVar).isEmpty()) {
                if (this.f3394x.isEmpty()) {
                    this.f3394x = c.I(cVar);
                    this.m &= -1025;
                } else {
                    if ((this.m & 1024) != 1024) {
                        this.f3394x = new ArrayList(this.f3394x);
                        this.m |= 1024;
                    }
                    this.f3394x.addAll(c.I(cVar));
                }
            }
            if (!c.h(cVar).isEmpty()) {
                if (this.f3395y.isEmpty()) {
                    this.f3395y = c.h(cVar);
                    this.m &= -2049;
                } else {
                    if ((this.m & 2048) != 2048) {
                        this.f3395y = new ArrayList(this.f3395y);
                        this.m |= 2048;
                    }
                    this.f3395y.addAll(c.h(cVar));
                }
            }
            if (!c.j(cVar).isEmpty()) {
                if (this.f3396z.isEmpty()) {
                    this.f3396z = c.j(cVar);
                    this.m &= -4097;
                } else {
                    if ((this.m & 4096) != 4096) {
                        this.f3396z = new ArrayList(this.f3396z);
                        this.m |= 4096;
                    }
                    this.f3396z.addAll(c.j(cVar));
                }
            }
            if (cVar.hasTypeTable()) {
                mergeTypeTable(cVar.getTypeTable());
            }
            if (!c.m(cVar).isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = c.m(cVar);
                    this.m &= -16385;
                } else {
                    if ((this.m & 16384) != 16384) {
                        this.B = new ArrayList(this.B);
                        this.m |= 16384;
                    }
                    this.B.addAll(c.m(cVar));
                }
            }
            if (cVar.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(cVar.getVersionRequirementTable());
            }
            b(cVar);
            setUnknownFields(getUnknownFields().concat(c.q(cVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
            c cVar = null;
            try {
                try {
                    c partialFrom = c.k.parsePartialFrom(dVar, eVar);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    c cVar2 = (c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cVar = cVar2;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cVar != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.c$c, reason: collision with other inner class name */
    public enum EnumC0550c implements h.a {
        CLASS(0),
        INTERFACE(1),
        ENUM_CLASS(2),
        ENUM_ENTRY(3),
        ANNOTATION_CLASS(4),
        OBJECT(5),
        COMPANION_OBJECT(6);

        private final int value;

        EnumC0550c(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.h.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        c cVar = new c();
        j = cVar;
        cVar.K();
    }

    public c(g.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static /* synthetic */ List A(c cVar) {
        return cVar.nestedClassName_;
    }

    public static /* synthetic */ List B(c cVar, List list) {
        cVar.nestedClassName_ = list;
        return list;
    }

    public static /* synthetic */ List C(c cVar) {
        return cVar.constructor_;
    }

    public static /* synthetic */ List D(c cVar, List list) {
        cVar.constructor_ = list;
        return list;
    }

    public static /* synthetic */ List E(c cVar) {
        return cVar.function_;
    }

    public static /* synthetic */ List F(c cVar, List list) {
        cVar.function_ = list;
        return list;
    }

    public static /* synthetic */ List G(c cVar) {
        return cVar.property_;
    }

    public static /* synthetic */ List H(c cVar, List list) {
        cVar.property_ = list;
        return list;
    }

    public static /* synthetic */ List I(c cVar) {
        return cVar.typeAlias_;
    }

    public static /* synthetic */ List J(c cVar, List list) {
        cVar.typeAlias_ = list;
        return list;
    }

    public static c getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ List h(c cVar) {
        return cVar.enumEntry_;
    }

    public static /* synthetic */ List i(c cVar, List list) {
        cVar.enumEntry_ = list;
        return list;
    }

    public static /* synthetic */ List j(c cVar) {
        return cVar.sealedSubclassFqName_;
    }

    public static /* synthetic */ List k(c cVar, List list) {
        cVar.sealedSubclassFqName_ = list;
        return list;
    }

    public static /* synthetic */ t l(c cVar, t tVar) {
        cVar.typeTable_ = tVar;
        return tVar;
    }

    public static /* synthetic */ List m(c cVar) {
        return cVar.versionRequirement_;
    }

    public static /* synthetic */ List n(c cVar, List list) {
        cVar.versionRequirement_ = list;
        return list;
    }

    public static b newBuilder(c cVar) {
        return newBuilder().mergeFrom(cVar);
    }

    public static /* synthetic */ w o(c cVar, w wVar) {
        cVar.versionRequirementTable_ = wVar;
        return wVar;
    }

    public static /* synthetic */ int p(c cVar, int i) {
        cVar.bitField0_ = i;
        return i;
    }

    public static c parseFrom(InputStream inputStream, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return (c) ((d0.e0.p.d.m0.i.b) k).m90parseFrom(inputStream, eVar);
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c q(c cVar) {
        return cVar.unknownFields;
    }

    public static /* synthetic */ int r(c cVar, int i) {
        cVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int s(c cVar, int i) {
        cVar.fqName_ = i;
        return i;
    }

    public static /* synthetic */ int t(c cVar, int i) {
        cVar.companionObjectName_ = i;
        return i;
    }

    public static /* synthetic */ List u(c cVar) {
        return cVar.typeParameter_;
    }

    public static /* synthetic */ List v(c cVar, List list) {
        cVar.typeParameter_ = list;
        return list;
    }

    public static /* synthetic */ List w(c cVar) {
        return cVar.supertype_;
    }

    public static /* synthetic */ List x(c cVar, List list) {
        cVar.supertype_ = list;
        return list;
    }

    public static /* synthetic */ List y(c cVar) {
        return cVar.supertypeId_;
    }

    public static /* synthetic */ List z(c cVar, List list) {
        cVar.supertypeId_ = list;
        return list;
    }

    public final void K() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = w.getDefaultInstance();
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public d getConstructor(int i) {
        return this.constructor_.get(i);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<d> getConstructorList() {
        return this.constructor_;
    }

    @Override // d0.e0.p.d.m0.i.o
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public g getEnumEntry(int i) {
        return this.enumEntry_.get(i);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<g> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<i> getFunctionList() {
        return this.function_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    public n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<n> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        int iComputeInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.supertypeId_.size(); i2++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i2).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getSupertypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.supertypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i3));
        }
        for (int i4 = 0; i4 < this.supertype_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i4));
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i5 = 0; i5 < this.nestedClassName_.size(); i5++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i5).intValue());
        }
        int iComputeMessageSize2 = iComputeMessageSize + iComputeInt32SizeNoTag2;
        if (!getNestedClassNameList().isEmpty()) {
            iComputeMessageSize2 = iComputeMessageSize2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag2);
        }
        this.nestedClassNameMemoizedSerializedSize = iComputeInt32SizeNoTag2;
        for (int i6 = 0; i6 < this.constructor_.size(); i6++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i6));
        }
        for (int i7 = 0; i7 < this.function_.size(); i7++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(9, this.function_.get(i7));
        }
        for (int i8 = 0; i8 < this.property_.size(); i8++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(10, this.property_.get(i8));
        }
        for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i9));
        }
        for (int i10 = 0; i10 < this.enumEntry_.size(); i10++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i10));
        }
        int iComputeInt32SizeNoTag3 = 0;
        for (int i11 = 0; i11 < this.sealedSubclassFqName_.size(); i11++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i11).intValue());
        }
        int iComputeMessageSize3 = iComputeMessageSize2 + iComputeInt32SizeNoTag3;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            iComputeMessageSize3 = iComputeMessageSize3 + 2 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = iComputeInt32SizeNoTag3;
        if ((this.bitField0_ & 8) == 8) {
            iComputeMessageSize3 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag4 = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            iComputeInt32SizeNoTag4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i12).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize3 + iComputeInt32SizeNoTag4;
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size2 = this.unknownFields.size() + c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public q getSupertype(int i) {
        return this.supertype_.get(i);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<q> getSupertypeList() {
        return this.supertype_;
    }

    public r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<r> getTypeAliasList() {
        return this.typeAlias_;
    }

    public s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public t getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 16) == 16;
    }

    @Override // d0.e0.p.d.m0.i.o
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!hasFqName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
            if (!getSupertype(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getConstructorCount(); i3++) {
            if (!getConstructor(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getFunctionCount(); i4++) {
            if (!getFunction(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getPropertyCount(); i5++) {
            if (!getProperty(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
            if (!getTypeAlias(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
            if (!getEnumEntry(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n.a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n.a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        g.d<MessageType>.a aVarE = e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i3));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.writeMessage(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarE.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.o
    public c getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public b toBuilder() {
        return newBuilder(this);
    }

    public c() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        K();
        c.b bVarNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    switch (tag) {
                        case 0:
                            z2 = true;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = dVar.readInt32();
                        case 16:
                            if ((i & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(dVar.readInt32()));
                        case 18:
                            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 32) != 32 && dVar.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = dVar.readInt32();
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = dVar.readInt32();
                        case 42:
                            if ((i & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i |= 8;
                            }
                            this.typeParameter_.add(dVar.readMessage(s.k, eVar));
                        case 50:
                            if ((i & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i |= 16;
                            }
                            this.supertype_.add(dVar.readMessage(q.k, eVar));
                        case 56:
                            if ((i & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(dVar.readInt32()));
                        case 58:
                            int iPushLimit2 = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 64) != 64 && dVar.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit2);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.constructor_ = new ArrayList();
                                i |= 128;
                            }
                            this.constructor_.add(dVar.readMessage(d.k, eVar));
                        case 74:
                            if ((i & 256) != 256) {
                                this.function_ = new ArrayList();
                                i |= 256;
                            }
                            this.function_.add(dVar.readMessage(i.k, eVar));
                        case 82:
                            if ((i & 512) != 512) {
                                this.property_ = new ArrayList();
                                i |= 512;
                            }
                            this.property_.add(dVar.readMessage(n.k, eVar));
                        case 90:
                            if ((i & 1024) != 1024) {
                                this.typeAlias_ = new ArrayList();
                                i |= 1024;
                            }
                            this.typeAlias_.add(dVar.readMessage(r.k, eVar));
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.enumEntry_ = new ArrayList();
                                i |= 2048;
                            }
                            this.enumEntry_.add(dVar.readMessage(g.k, eVar));
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(dVar.readInt32()));
                        case 130:
                            int iPushLimit3 = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 4096) != 4096 && dVar.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit3);
                            break;
                        case 242:
                            t.b builder = (this.bitField0_ & 8) == 8 ? this.typeTable_.toBuilder() : null;
                            t tVar = (t) dVar.readMessage(t.k, eVar);
                            this.typeTable_ = tVar;
                            if (builder != null) {
                                builder.mergeFrom(tVar);
                                this.typeTable_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        case 248:
                            if ((i & 16384) != 16384) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                        case 250:
                            int iPushLimit4 = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 16384) != 16384 && dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit4);
                            break;
                        case 258:
                            w.b builder2 = (this.bitField0_ & 16) == 16 ? this.versionRequirementTable_.toBuilder() : null;
                            w wVar = (w) dVar.readMessage(w.k, eVar);
                            this.versionRequirementTable_ = wVar;
                            if (builder2 != null) {
                                builder2.mergeFrom(wVar);
                                this.versionRequirementTable_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 16;
                        default:
                            if (!f(dVar, codedOutputStreamNewInstance, eVar, tag)) {
                                z2 = true;
                            }
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((i & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((i & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((i & 128) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((i & 256) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 512) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 1024) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((i & 2048) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((i & 4096) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                }
                if ((i & 16384) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                d();
                throw th;
            }
        }
        if ((i & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if ((i & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if ((i & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if ((i & 128) == 128) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if ((i & 256) == 256) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 512) == 512) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 1024) == 1024) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if ((i & 2048) == 2048) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if ((i & 4096) == 4096) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if ((i & 16384) == 16384) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        d();
    }
}
