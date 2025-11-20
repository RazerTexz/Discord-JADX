package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a;
import d0.e0.p.d.m0.i.c;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.h;
import d0.e0.p.d.m0.i.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class b extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final b j;
    public static d0.e0.p.d.m0.i.p<b> k = new a();
    private List<C0546b> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final d0.e0.p.d.m0.i.c unknownFields;

    /* compiled from: ProtoBuf.java */
    public static class a extends d0.e0.p.d.m0.i.b<b> {
        @Override // d0.e0.p.d.m0.i.p
        public /* bridge */ /* synthetic */ Object parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
            return parsePartialFrom(dVar, eVar);
        }

        @Override // d0.e0.p.d.m0.i.p
        public b parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
            return new b(dVar, eVar, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.b$b, reason: collision with other inner class name */
    public static final class C0546b extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
        public static final C0546b j;
        public static d0.e0.p.d.m0.i.p<C0546b> k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final d0.e0.p.d.m0.i.c unknownFields;
        private c value_;

        /* compiled from: ProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.b$b$a */
        public static class a extends d0.e0.p.d.m0.i.b<C0546b> {
            @Override // d0.e0.p.d.m0.i.p
            public /* bridge */ /* synthetic */ Object parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
                return parsePartialFrom(dVar, eVar);
            }

            @Override // d0.e0.p.d.m0.i.p
            public C0546b parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
                return new C0546b(dVar, eVar, null);
            }
        }

        /* compiled from: ProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.b$b$b, reason: collision with other inner class name */
        public static final class C0547b extends g.b<C0546b, C0547b> implements d0.e0.p.d.m0.i.o {
            public int k;
            public int l;
            public c m = c.getDefaultInstance();

            @Override // d0.e0.p.d.m0.i.n.a
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
                return build();
            }

            public C0546b buildPartial() {
                C0546b c0546b = new C0546b(this, null);
                int i = this.k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                C0546b.a(c0546b, this.l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                C0546b.b(c0546b, this.m);
                C0546b.c(c0546b, i2);
                return c0546b;
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

            public C0547b mergeValue(c cVar) {
                if ((this.k & 2) != 2 || this.m == c.getDefaultInstance()) {
                    this.m = cVar;
                } else {
                    this.m = c.newBuilder(this.m).mergeFrom(cVar).buildPartial();
                }
                this.k |= 2;
                return this;
            }

            public C0547b setNameId(int i) {
                this.k |= 1;
                this.l = i;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.n.a
            public C0546b build() {
                C0546b c0546bBuildPartial = buildPartial();
                if (c0546bBuildPartial.isInitialized()) {
                    return c0546bBuildPartial;
                }
                throw new UninitializedMessageException(c0546bBuildPartial);
            }

            @Override // d0.e0.p.d.m0.i.g.b
            public /* bridge */ /* synthetic */ g.b clone() {
                return clone();
            }

            @Override // d0.e0.p.d.m0.i.g.b
            public /* bridge */ /* synthetic */ g.b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
                return mergeFrom((C0546b) gVar);
            }

            @Override // d0.e0.p.d.m0.i.g.b
            public C0547b clone() {
                return new C0547b().mergeFrom(buildPartial());
            }

            @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
            public /* bridge */ /* synthetic */ n.a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
                return mergeFrom(dVar, eVar);
            }

            public C0547b mergeFrom(C0546b c0546b) {
                if (c0546b == C0546b.getDefaultInstance()) {
                    return this;
                }
                if (c0546b.hasNameId()) {
                    setNameId(c0546b.getNameId());
                }
                if (c0546b.hasValue()) {
                    mergeValue(c0546b.getValue());
                }
                setUnknownFields(getUnknownFields().concat(C0546b.d(c0546b)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0547b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
                C0546b c0546b = null;
                try {
                    try {
                        C0546b partialFrom = C0546b.k.parsePartialFrom(dVar, eVar);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        C0546b c0546b2 = (C0546b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            c0546b = c0546b2;
                            if (c0546b != null) {
                                mergeFrom(c0546b);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0546b != null) {
                    }
                    throw th;
                }
            }
        }

        /* compiled from: ProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.b$b$c */
        public static final class c extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
            public static final c j;
            public static d0.e0.p.d.m0.i.p<c> k = new a();
            private b annotation_;
            private int arrayDimensionCount_;
            private List<c> arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private EnumC0549c type_;
            private final d0.e0.p.d.m0.i.c unknownFields;

            /* compiled from: ProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.b$b$c$a */
            public static class a extends d0.e0.p.d.m0.i.b<c> {
                @Override // d0.e0.p.d.m0.i.p
                public /* bridge */ /* synthetic */ Object parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
                    return parsePartialFrom(dVar, eVar);
                }

                @Override // d0.e0.p.d.m0.i.p
                public c parsePartialFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws InvalidProtocolBufferException {
                    return new c(dVar, eVar, null);
                }
            }

            /* compiled from: ProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.b$b$c$b, reason: collision with other inner class name */
            public static final class C0548b extends g.b<c, C0548b> implements d0.e0.p.d.m0.i.o {
                public int k;
                public long m;
                public float n;
                public double o;
                public int p;
                public int q;
                public int r;
                public int u;
                public int v;
                public EnumC0549c l = EnumC0549c.BYTE;

                /* renamed from: s, reason: collision with root package name */
                public b f3391s = b.getDefaultInstance();
                public List<c> t = Collections.emptyList();

                @Override // d0.e0.p.d.m0.i.n.a
                public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
                    return build();
                }

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    c.a(cVar, this.l);
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    c.b(cVar, this.m);
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    c.c(cVar, this.n);
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    c.d(cVar, this.o);
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    c.e(cVar, this.p);
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    c.f(cVar, this.q);
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    c.g(cVar, this.r);
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    c.h(cVar, this.f3391s);
                    if ((this.k & 256) == 256) {
                        this.t = Collections.unmodifiableList(this.t);
                        this.k &= -257;
                    }
                    c.j(cVar, this.t);
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    c.k(cVar, this.u);
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    c.l(cVar, this.v);
                    c.m(cVar, i2);
                    return cVar;
                }

                @Override // d0.e0.p.d.m0.i.g.b
                /* renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
                    return clone();
                }

                public C0548b mergeAnnotation(b bVar) {
                    if ((this.k & 128) != 128 || this.f3391s == b.getDefaultInstance()) {
                        this.f3391s = bVar;
                    } else {
                        this.f3391s = b.newBuilder(this.f3391s).mergeFrom(bVar).buildPartial();
                    }
                    this.k |= 128;
                    return this;
                }

                @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
                public /* bridge */ /* synthetic */ a.AbstractC0556a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
                    return mergeFrom(dVar, eVar);
                }

                public C0548b setArrayDimensionCount(int i) {
                    this.k |= 512;
                    this.u = i;
                    return this;
                }

                public C0548b setClassId(int i) {
                    this.k |= 32;
                    this.q = i;
                    return this;
                }

                public C0548b setDoubleValue(double d) {
                    this.k |= 8;
                    this.o = d;
                    return this;
                }

                public C0548b setEnumValueId(int i) {
                    this.k |= 64;
                    this.r = i;
                    return this;
                }

                public C0548b setFlags(int i) {
                    this.k |= 1024;
                    this.v = i;
                    return this;
                }

                public C0548b setFloatValue(float f) {
                    this.k |= 4;
                    this.n = f;
                    return this;
                }

                public C0548b setIntValue(long j) {
                    this.k |= 2;
                    this.m = j;
                    return this;
                }

                public C0548b setStringValue(int i) {
                    this.k |= 16;
                    this.p = i;
                    return this;
                }

                public C0548b setType(EnumC0549c enumC0549c) {
                    Objects.requireNonNull(enumC0549c);
                    this.k |= 1;
                    this.l = enumC0549c;
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
                public C0548b clone() {
                    return new C0548b().mergeFrom(buildPartial());
                }

                @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
                public /* bridge */ /* synthetic */ n.a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
                    return mergeFrom(dVar, eVar);
                }

                public C0548b mergeFrom(c cVar) {
                    if (cVar == c.getDefaultInstance()) {
                        return this;
                    }
                    if (cVar.hasType()) {
                        setType(cVar.getType());
                    }
                    if (cVar.hasIntValue()) {
                        setIntValue(cVar.getIntValue());
                    }
                    if (cVar.hasFloatValue()) {
                        setFloatValue(cVar.getFloatValue());
                    }
                    if (cVar.hasDoubleValue()) {
                        setDoubleValue(cVar.getDoubleValue());
                    }
                    if (cVar.hasStringValue()) {
                        setStringValue(cVar.getStringValue());
                    }
                    if (cVar.hasClassId()) {
                        setClassId(cVar.getClassId());
                    }
                    if (cVar.hasEnumValueId()) {
                        setEnumValueId(cVar.getEnumValueId());
                    }
                    if (cVar.hasAnnotation()) {
                        mergeAnnotation(cVar.getAnnotation());
                    }
                    if (!c.i(cVar).isEmpty()) {
                        if (this.t.isEmpty()) {
                            this.t = c.i(cVar);
                            this.k &= -257;
                        } else {
                            if ((this.k & 256) != 256) {
                                this.t = new ArrayList(this.t);
                                this.k |= 256;
                            }
                            this.t.addAll(c.i(cVar));
                        }
                    }
                    if (cVar.hasArrayDimensionCount()) {
                        setArrayDimensionCount(cVar.getArrayDimensionCount());
                    }
                    if (cVar.hasFlags()) {
                        setFlags(cVar.getFlags());
                    }
                    setUnknownFields(getUnknownFields().concat(c.n(cVar)));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C0548b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
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
            /* renamed from: d0.e0.p.d.m0.f.b$b$c$c, reason: collision with other inner class name */
            public enum EnumC0549c implements h.a {
                BYTE(0),
                CHAR(1),
                SHORT(2),
                INT(3),
                LONG(4),
                FLOAT(5),
                DOUBLE(6),
                BOOLEAN(7),
                STRING(8),
                CLASS(9),
                ENUM(10),
                ANNOTATION(11),
                ARRAY(12);

                private final int value;

                EnumC0549c(int i) {
                    this.value = i;
                }

                @Override // d0.e0.p.d.m0.i.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC0549c valueOf(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            static {
                c cVar = new c();
                j = cVar;
                cVar.o();
            }

            public c(g.b bVar, d0.e0.p.d.m0.f.a aVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            public static /* synthetic */ EnumC0549c a(c cVar, EnumC0549c enumC0549c) {
                cVar.type_ = enumC0549c;
                return enumC0549c;
            }

            public static /* synthetic */ long b(c cVar, long j2) {
                cVar.intValue_ = j2;
                return j2;
            }

            public static /* synthetic */ float c(c cVar, float f) {
                cVar.floatValue_ = f;
                return f;
            }

            public static /* synthetic */ double d(c cVar, double d) {
                cVar.doubleValue_ = d;
                return d;
            }

            public static /* synthetic */ int e(c cVar, int i) {
                cVar.stringValue_ = i;
                return i;
            }

            public static /* synthetic */ int f(c cVar, int i) {
                cVar.classId_ = i;
                return i;
            }

            public static /* synthetic */ int g(c cVar, int i) {
                cVar.enumValueId_ = i;
                return i;
            }

            public static c getDefaultInstance() {
                return j;
            }

            public static /* synthetic */ b h(c cVar, b bVar) {
                cVar.annotation_ = bVar;
                return bVar;
            }

            public static /* synthetic */ List i(c cVar) {
                return cVar.arrayElement_;
            }

            public static /* synthetic */ List j(c cVar, List list) {
                cVar.arrayElement_ = list;
                return list;
            }

            public static /* synthetic */ int k(c cVar, int i) {
                cVar.arrayDimensionCount_ = i;
                return i;
            }

            public static /* synthetic */ int l(c cVar, int i) {
                cVar.flags_ = i;
                return i;
            }

            public static /* synthetic */ int m(c cVar, int i) {
                cVar.bitField0_ = i;
                return i;
            }

            public static /* synthetic */ d0.e0.p.d.m0.i.c n(c cVar) {
                return cVar.unknownFields;
            }

            public static C0548b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public b getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public c getArrayElement(int i) {
                return this.arrayElement_.get(i);
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public List<c> getArrayElementList() {
                return this.arrayElement_;
            }

            public int getClassId() {
                return this.classId_;
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public int getEnumValueId() {
                return this.enumValueId_;
            }

            public int getFlags() {
                return this.flags_;
            }

            public float getFloatValue() {
                return this.floatValue_;
            }

            public long getIntValue() {
                return this.intValue_;
            }

            @Override // d0.e0.p.d.m0.i.n
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    iComputeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    iComputeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                }
                for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                    iComputeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
                }
                if ((this.bitField0_ & 512) == 512) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                }
                int size = this.unknownFields.size() + iComputeEnumSize;
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public EnumC0549c getType() {
                return this.type_;
            }

            public boolean hasAnnotation() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean hasArrayDimensionCount() {
                return (this.bitField0_ & 256) == 256;
            }

            public boolean hasClassId() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasDoubleValue() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasEnumValueId() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasFlags() {
                return (this.bitField0_ & 512) == 512;
            }

            public boolean hasFloatValue() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasIntValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasStringValue() {
                return (this.bitField0_ & 16) == 16;
            }

            public boolean hasType() {
                return (this.bitField0_ & 1) == 1;
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
                if (hasAnnotation() && !getAnnotation().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i = 0; i < getArrayElementCount(); i++) {
                    if (!getArrayElement(i).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // d0.e0.p.d.m0.i.n
            public /* bridge */ /* synthetic */ n.a newBuilderForType() {
                return newBuilderForType();
            }

            public final void o() {
                this.type_ = EnumC0549c.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = b.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            @Override // d0.e0.p.d.m0.i.n
            public /* bridge */ /* synthetic */ n.a toBuilder() {
                return toBuilder();
            }

            @Override // d0.e0.p.d.m0.i.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.type_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeSInt64(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeFloat(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeDouble(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.annotation_);
                }
                for (int i = 0; i < this.arrayElement_.size(); i++) {
                    codedOutputStream.writeMessage(9, this.arrayElement_.get(i));
                }
                if ((this.bitField0_ & 512) == 512) {
                    codedOutputStream.writeInt32(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static C0548b newBuilder() {
                return new C0548b();
            }

            @Override // d0.e0.p.d.m0.i.n
            public C0548b newBuilderForType() {
                return newBuilder();
            }

            @Override // d0.e0.p.d.m0.i.n
            public C0548b toBuilder() {
                return newBuilder(this);
            }

            public c() {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = d0.e0.p.d.m0.i.c.j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public c(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                o();
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
                                    break;
                                case 8:
                                    int i2 = dVar.readEnum();
                                    EnumC0549c enumC0549cValueOf = EnumC0549c.valueOf(i2);
                                    if (enumC0549cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.type_ = enumC0549cValueOf;
                                    }
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = dVar.readSInt64();
                                    break;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = dVar.readFloat();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = dVar.readDouble();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = dVar.readInt32();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = dVar.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = dVar.readInt32();
                                    break;
                                case 66:
                                    c builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    b bVar = (b) dVar.readMessage(b.k, eVar);
                                    this.annotation_ = bVar;
                                    if (builder != null) {
                                        builder.mergeFrom(bVar);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    if ((i & 256) != 256) {
                                        this.arrayElement_ = new ArrayList();
                                        i |= 256;
                                    }
                                    this.arrayElement_.add(dVar.readMessage(k, eVar));
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.flags_ = dVar.readInt32();
                                    break;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.arrayDimensionCount_ = dVar.readInt32();
                                    break;
                                default:
                                    if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                        z2 = true;
                                    }
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if ((i & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        }
                        try {
                            codedOutputStreamNewInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = bVarNewOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = bVarNewOutput.toByteString();
                        throw th;
                    }
                }
                if ((i & 256) == 256) {
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = bVarNewOutput.toByteString();
            }
        }

        static {
            C0546b c0546b = new C0546b();
            j = c0546b;
            c0546b.nameId_ = 0;
            c0546b.value_ = c.getDefaultInstance();
        }

        public C0546b(g.b bVar, d0.e0.p.d.m0.f.a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static /* synthetic */ int a(C0546b c0546b, int i) {
            c0546b.nameId_ = i;
            return i;
        }

        public static /* synthetic */ c b(C0546b c0546b, c cVar) {
            c0546b.value_ = cVar;
            return cVar;
        }

        public static /* synthetic */ int c(C0546b c0546b, int i) {
            c0546b.bitField0_ = i;
            return i;
        }

        public static /* synthetic */ d0.e0.p.d.m0.i.c d(C0546b c0546b) {
            return c0546b.unknownFields;
        }

        public static C0546b getDefaultInstance() {
            return j;
        }

        public static C0547b newBuilder(C0546b c0546b) {
            return newBuilder().mergeFrom(c0546b);
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // d0.e0.p.d.m0.i.n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public c getValue() {
            return this.value_;
        }

        public boolean hasNameId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
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
            if (!hasNameId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (getValue().isInitialized()) {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C0547b newBuilder() {
            return new C0547b();
        }

        @Override // d0.e0.p.d.m0.i.n
        public C0547b newBuilderForType() {
            return newBuilder();
        }

        @Override // d0.e0.p.d.m0.i.n
        public C0547b toBuilder() {
            return newBuilder(this);
        }

        public C0546b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d0.e0.p.d.m0.i.c.j;
        }

        public C0546b(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.nameId_ = 0;
            this.value_ = c.getDefaultInstance();
            c.b bVarNewOutput = d0.e0.p.d.m0.i.c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = dVar.readInt32();
                            } else if (tag != 18) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.C0548b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                c cVar = (c) dVar.readMessage(c.k, eVar);
                                this.value_ = cVar;
                                if (builder != null) {
                                    builder.mergeFrom(cVar);
                                    this.value_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = bVarNewOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th;
                }
            }
            try {
                codedOutputStreamNewInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = bVarNewOutput.toByteString();
                throw th3;
            }
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class c extends g.b<b, c> implements d0.e0.p.d.m0.i.o {
        public int k;
        public int l;
        public List<C0546b> m = Collections.emptyList();

        @Override // d0.e0.p.d.m0.i.n.a
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
            return build();
        }

        public b buildPartial() {
            b bVar = new b(this, null);
            int i = (this.k & 1) != 1 ? 0 : 1;
            b.a(bVar, this.l);
            if ((this.k & 2) == 2) {
                this.m = Collections.unmodifiableList(this.m);
                this.k &= -3;
            }
            b.c(bVar, this.m);
            b.d(bVar, i);
            return bVar;
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

        public c setId(int i) {
            this.k |= 1;
            this.l = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.n.a
        public b build() {
            b bVarBuildPartial = buildPartial();
            if (bVarBuildPartial.isInitialized()) {
                return bVarBuildPartial;
            }
            throw new UninitializedMessageException(bVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public /* bridge */ /* synthetic */ g.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public /* bridge */ /* synthetic */ g.b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
            return mergeFrom((b) gVar);
        }

        @Override // d0.e0.p.d.m0.i.g.b
        public c clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
        public /* bridge */ /* synthetic */ n.a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
            return mergeFrom(dVar, eVar);
        }

        public c mergeFrom(b bVar) {
            if (bVar == b.getDefaultInstance()) {
                return this;
            }
            if (bVar.hasId()) {
                setId(bVar.getId());
            }
            if (!b.b(bVar).isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = b.b(bVar);
                    this.k &= -3;
                } else {
                    if ((this.k & 2) != 2) {
                        this.m = new ArrayList(this.m);
                        this.k |= 2;
                    }
                    this.m.addAll(b.b(bVar));
                }
            }
            setUnknownFields(getUnknownFields().concat(b.e(bVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.a.AbstractC0556a, d0.e0.p.d.m0.i.n.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
            b bVar = null;
            try {
                try {
                    b partialFrom = b.k.parsePartialFrom(dVar, eVar);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    b bVar2 = (b) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (bVar != null) {
                            mergeFrom(bVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        b bVar = new b();
        j = bVar;
        bVar.id_ = 0;
        bVar.argument_ = Collections.emptyList();
    }

    public b(g.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static /* synthetic */ int a(b bVar, int i) {
        bVar.id_ = i;
        return i;
    }

    public static /* synthetic */ List b(b bVar) {
        return bVar.argument_;
    }

    public static /* synthetic */ List c(b bVar, List list) {
        bVar.argument_ = list;
        return list;
    }

    public static /* synthetic */ int d(b bVar, int i) {
        bVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c e(b bVar) {
        return bVar.unknownFields;
    }

    public static b getDefaultInstance() {
        return j;
    }

    public static c newBuilder(b bVar) {
        return newBuilder().mergeFrom(bVar);
    }

    public C0546b getArgument(int i) {
        return this.argument_.get(i);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<C0546b> getArgumentList() {
        return this.argument_;
    }

    public int getId() {
        return this.id_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.id_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static c newBuilder() {
        return new c();
    }

    @Override // d0.e0.p.d.m0.i.n
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public c toBuilder() {
        return newBuilder(this);
    }

    public b() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
        c.b bVarNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = dVar.readInt32();
                            } else if (tag != 18) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                if ((i & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    i |= 2;
                                }
                                this.argument_.add(dVar.readMessage(C0546b.k, eVar));
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                throw th;
            }
        }
        if ((i & 2) == 2) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
    }
}
