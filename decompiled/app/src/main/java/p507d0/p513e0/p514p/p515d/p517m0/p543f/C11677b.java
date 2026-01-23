package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.CodedInputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.b */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11677b extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11677b f23722j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11677b> f23723k = new a();
    private List<b> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString3 unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11677b> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11677b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11677b(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: j */
        public static final b f23724j;

        /* JADX INFO: renamed from: k */
        public static Parser2<b> f23725k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final ByteString3 unknownFields;
        private c value_;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$a */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractParser<b> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new b(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C13319b extends GeneratedMessageLite.b<b, C13319b> implements MessageLiteOrBuilder {

            /* JADX INFO: renamed from: k */
            public int f23726k;

            /* JADX INFO: renamed from: l */
            public int f23727l;

            /* JADX INFO: renamed from: m */
            public c f23728m = c.getDefaultInstance();

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23726k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                b.m9592a(bVar, this.f23727l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                b.m9593b(bVar, this.f23728m);
                b.m9594c(bVar, i2);
                return bVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C13319b mergeValue(c cVar) {
                if ((this.f23726k & 2) != 2 || this.f23728m == c.getDefaultInstance()) {
                    this.f23728m = cVar;
                } else {
                    this.f23728m = c.newBuilder(this.f23728m).mergeFrom(cVar).buildPartial();
                }
                this.f23726k |= 2;
                return this;
            }

            public C13319b setNameId(int i) {
                this.f23726k |= 1;
                this.f23727l = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((b) generatedMessageLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public C13319b clone() {
                return new C13319b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C13319b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasNameId()) {
                    setNameId(bVar.getNameId());
                }
                if (bVar.hasValue()) {
                    mergeValue(bVar.getValue());
                }
                setUnknownFields(getUnknownFields().concat(b.m9595d(bVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C13319b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23725k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {

            /* JADX INFO: renamed from: j */
            public static final c f23729j;

            /* JADX INFO: renamed from: k */
            public static Parser2<c> f23730k = new a();
            private C11677b annotation_;
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
            private EnumC13321c type_;
            private final ByteString3 unknownFields;

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$a */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public static class a extends AbstractParser<c> {
                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
                public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return parsePartialFrom(codedInputStream, extensionRegistryLite);
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
                public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new c(codedInputStream, extensionRegistryLite, null);
                }
            }

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public static final class C13320b extends GeneratedMessageLite.b<c, C13320b> implements MessageLiteOrBuilder {

                /* JADX INFO: renamed from: k */
                public int f23731k;

                /* JADX INFO: renamed from: m */
                public long f23733m;

                /* JADX INFO: renamed from: n */
                public float f23734n;

                /* JADX INFO: renamed from: o */
                public double f23735o;

                /* JADX INFO: renamed from: p */
                public int f23736p;

                /* JADX INFO: renamed from: q */
                public int f23737q;

                /* JADX INFO: renamed from: r */
                public int f23738r;

                /* JADX INFO: renamed from: u */
                public int f23741u;

                /* JADX INFO: renamed from: v */
                public int f23742v;

                /* JADX INFO: renamed from: l */
                public EnumC13321c f23732l = EnumC13321c.BYTE;

                /* JADX INFO: renamed from: s */
                public C11677b f23739s = C11677b.getDefaultInstance();

                /* JADX INFO: renamed from: t */
                public List<c> f23740t = Collections.emptyList();

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f23731k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    c.m9596a(cVar, this.f23732l);
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    c.m9597b(cVar, this.f23733m);
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    c.m9598c(cVar, this.f23734n);
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    c.m9599d(cVar, this.f23735o);
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    c.m9600e(cVar, this.f23736p);
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    c.m9601f(cVar, this.f23737q);
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    c.m9602g(cVar, this.f23738r);
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    c.m9603h(cVar, this.f23739s);
                    if ((this.f23731k & 256) == 256) {
                        this.f23740t = Collections.unmodifiableList(this.f23740t);
                        this.f23731k &= -257;
                    }
                    c.m9605j(cVar, this.f23740t);
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    c.m9606k(cVar, this.f23741u);
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    c.m9607l(cVar, this.f23742v);
                    c.m9608m(cVar, i2);
                    return cVar;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
                    return clone();
                }

                public C13320b mergeAnnotation(C11677b c11677b) {
                    if ((this.f23731k & 128) != 128 || this.f23739s == C11677b.getDefaultInstance()) {
                        this.f23739s = c11677b;
                    } else {
                        this.f23739s = C11677b.newBuilder(this.f23739s).mergeFrom(c11677b).buildPartial();
                    }
                    this.f23731k |= 128;
                    return this;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return mergeFrom(codedInputStream, extensionRegistryLite);
                }

                public C13320b setArrayDimensionCount(int i) {
                    this.f23731k |= 512;
                    this.f23741u = i;
                    return this;
                }

                public C13320b setClassId(int i) {
                    this.f23731k |= 32;
                    this.f23737q = i;
                    return this;
                }

                public C13320b setDoubleValue(double d) {
                    this.f23731k |= 8;
                    this.f23735o = d;
                    return this;
                }

                public C13320b setEnumValueId(int i) {
                    this.f23731k |= 64;
                    this.f23738r = i;
                    return this;
                }

                public C13320b setFlags(int i) {
                    this.f23731k |= 1024;
                    this.f23742v = i;
                    return this;
                }

                public C13320b setFloatValue(float f) {
                    this.f23731k |= 4;
                    this.f23734n = f;
                    return this;
                }

                public C13320b setIntValue(long j) {
                    this.f23731k |= 2;
                    this.f23733m = j;
                    return this;
                }

                public C13320b setStringValue(int i) {
                    this.f23731k |= 16;
                    this.f23736p = i;
                    return this;
                }

                public C13320b setType(EnumC13321c enumC13321c) {
                    Objects.requireNonNull(enumC13321c);
                    this.f23731k |= 1;
                    this.f23732l = enumC13321c;
                    return this;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                public c build() {
                    c cVarBuildPartial = buildPartial();
                    if (cVarBuildPartial.isInitialized()) {
                        return cVarBuildPartial;
                    }
                    throw new UninitializedMessageException(cVarBuildPartial);
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
                public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                    return clone();
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
                public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                    return mergeFrom((c) generatedMessageLite);
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
                public C13320b clone() {
                    return new C13320b().mergeFrom(buildPartial());
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return mergeFrom(codedInputStream, extensionRegistryLite);
                }

                public C13320b mergeFrom(c cVar) {
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
                    if (!c.m9604i(cVar).isEmpty()) {
                        if (this.f23740t.isEmpty()) {
                            this.f23740t = c.m9604i(cVar);
                            this.f23731k &= -257;
                        } else {
                            if ((this.f23731k & 256) != 256) {
                                this.f23740t = new ArrayList(this.f23740t);
                                this.f23731k |= 256;
                            }
                            this.f23740t.addAll(c.m9604i(cVar));
                        }
                    }
                    if (cVar.hasArrayDimensionCount()) {
                        setArrayDimensionCount(cVar.getArrayDimensionCount());
                    }
                    if (cVar.hasFlags()) {
                        setFlags(cVar.getFlags());
                    }
                    setUnknownFields(getUnknownFields().concat(c.m9609n(cVar)));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C13320b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c partialFrom = c.f23730k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public enum EnumC13321c implements Internal.a {
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

                EnumC13321c(int i) {
                    this.value = i;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC13321c valueOf(int i) {
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
                f23729j = cVar;
                cVar.m9610o();
            }

            public c(GeneratedMessageLite.b bVar, C11666a c11666a) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            /* JADX INFO: renamed from: a */
            public static /* synthetic */ EnumC13321c m9596a(c cVar, EnumC13321c enumC13321c) {
                cVar.type_ = enumC13321c;
                return enumC13321c;
            }

            /* JADX INFO: renamed from: b */
            public static /* synthetic */ long m9597b(c cVar, long j) {
                cVar.intValue_ = j;
                return j;
            }

            /* JADX INFO: renamed from: c */
            public static /* synthetic */ float m9598c(c cVar, float f) {
                cVar.floatValue_ = f;
                return f;
            }

            /* JADX INFO: renamed from: d */
            public static /* synthetic */ double m9599d(c cVar, double d) {
                cVar.doubleValue_ = d;
                return d;
            }

            /* JADX INFO: renamed from: e */
            public static /* synthetic */ int m9600e(c cVar, int i) {
                cVar.stringValue_ = i;
                return i;
            }

            /* JADX INFO: renamed from: f */
            public static /* synthetic */ int m9601f(c cVar, int i) {
                cVar.classId_ = i;
                return i;
            }

            /* JADX INFO: renamed from: g */
            public static /* synthetic */ int m9602g(c cVar, int i) {
                cVar.enumValueId_ = i;
                return i;
            }

            public static c getDefaultInstance() {
                return f23729j;
            }

            /* JADX INFO: renamed from: h */
            public static /* synthetic */ C11677b m9603h(c cVar, C11677b c11677b) {
                cVar.annotation_ = c11677b;
                return c11677b;
            }

            /* JADX INFO: renamed from: i */
            public static /* synthetic */ List m9604i(c cVar) {
                return cVar.arrayElement_;
            }

            /* JADX INFO: renamed from: j */
            public static /* synthetic */ List m9605j(c cVar, List list) {
                cVar.arrayElement_ = list;
                return list;
            }

            /* JADX INFO: renamed from: k */
            public static /* synthetic */ int m9606k(c cVar, int i) {
                cVar.arrayDimensionCount_ = i;
                return i;
            }

            /* JADX INFO: renamed from: l */
            public static /* synthetic */ int m9607l(c cVar, int i) {
                cVar.flags_ = i;
                return i;
            }

            /* JADX INFO: renamed from: m */
            public static /* synthetic */ int m9608m(c cVar, int i) {
                cVar.bitField0_ = i;
                return i;
            }

            /* JADX INFO: renamed from: n */
            public static /* synthetic */ ByteString3 m9609n(c cVar) {
                return cVar.unknownFields;
            }

            public static C13320b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public C11677b getAnnotation() {
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

            public EnumC13321c getType() {
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.a newBuilderForType() {
                return newBuilderForType();
            }

            /* JADX INFO: renamed from: o */
            public final void m9610o() {
                this.type_ = EnumC13321c.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = C11677b.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
                return toBuilder();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

            public static C13320b newBuilder() {
                return new C13320b();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
            public C13320b newBuilderForType() {
                return newBuilder();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
            public C13320b toBuilder() {
                return newBuilder(this);
            }

            public c() {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString3.f24100j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m9610o();
                ByteString3.b bVarNewOutput = ByteString3.newOutput();
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
                boolean z2 = false;
                int i = 0;
                while (!z2) {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    z2 = true;
                                    break;
                                case 8:
                                    int i2 = codedInputStream.readEnum();
                                    EnumC13321c enumC13321cValueOf = EnumC13321c.valueOf(i2);
                                    if (enumC13321cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.type_ = enumC13321cValueOf;
                                    }
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = codedInputStream.readSInt64();
                                    break;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = codedInputStream.readFloat();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = codedInputStream.readInt32();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = codedInputStream.readInt32();
                                    break;
                                case 66:
                                    c builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    C11677b c11677b = (C11677b) codedInputStream.readMessage(C11677b.f23723k, extensionRegistryLite);
                                    this.annotation_ = c11677b;
                                    if (builder != null) {
                                        builder.mergeFrom(c11677b);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    if ((i & 256) != 256) {
                                        this.arrayElement_ = new ArrayList();
                                        i |= 256;
                                    }
                                    this.arrayElement_.add(codedInputStream.readMessage(f23730k, extensionRegistryLite));
                                    break;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.flags_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.arrayDimensionCount_ = codedInputStream.readInt32();
                                    break;
                                default:
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
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
            b bVar = new b();
            f23724j = bVar;
            bVar.nameId_ = 0;
            bVar.value_ = c.getDefaultInstance();
        }

        public b(GeneratedMessageLite.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ int m9592a(b bVar, int i) {
            bVar.nameId_ = i;
            return i;
        }

        /* JADX INFO: renamed from: b */
        public static /* synthetic */ c m9593b(b bVar, c cVar) {
            bVar.value_ = cVar;
            return cVar;
        }

        /* JADX INFO: renamed from: c */
        public static /* synthetic */ int m9594c(b bVar, int i) {
            bVar.bitField0_ = i;
            return i;
        }

        /* JADX INFO: renamed from: d */
        public static /* synthetic */ ByteString3 m9595d(b bVar) {
            return bVar.unknownFields;
        }

        public static b getDefaultInstance() {
            return f23724j;
        }

        public static C13319b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.a newBuilderForType() {
            return newBuilderForType();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
            return toBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

        public static C13319b newBuilder() {
            return new C13319b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13319b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13319b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.f24100j;
        }

        public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.nameId_ = 0;
            this.value_ = c.getDefaultInstance();
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = codedInputStream.readInt32();
                            } else if (tag != 18) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.C13320b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                c cVar = (c) codedInputStream.readMessage(c.f23730k, extensionRegistryLite);
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

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends GeneratedMessageLite.b<C11677b, c> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: k */
        public int f23757k;

        /* JADX INFO: renamed from: l */
        public int f23758l;

        /* JADX INFO: renamed from: m */
        public List<b> f23759m = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11677b buildPartial() {
            C11677b c11677b = new C11677b(this, null);
            int i = (this.f23757k & 1) != 1 ? 0 : 1;
            C11677b.m9587a(c11677b, this.f23758l);
            if ((this.f23757k & 2) == 2) {
                this.f23759m = Collections.unmodifiableList(this.f23759m);
                this.f23757k &= -3;
            }
            C11677b.m9589c(c11677b, this.f23759m);
            C11677b.m9590d(c11677b, i);
            return c11677b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public c setId(int i) {
            this.f23757k |= 1;
            this.f23758l = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11677b build() {
            C11677b c11677bBuildPartial = buildPartial();
            if (c11677bBuildPartial.isInitialized()) {
                return c11677bBuildPartial;
            }
            throw new UninitializedMessageException(c11677bBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11677b) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public c clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public c mergeFrom(C11677b c11677b) {
            if (c11677b == C11677b.getDefaultInstance()) {
                return this;
            }
            if (c11677b.hasId()) {
                setId(c11677b.getId());
            }
            if (!C11677b.m9588b(c11677b).isEmpty()) {
                if (this.f23759m.isEmpty()) {
                    this.f23759m = C11677b.m9588b(c11677b);
                    this.f23757k &= -3;
                } else {
                    if ((this.f23757k & 2) != 2) {
                        this.f23759m = new ArrayList(this.f23759m);
                        this.f23757k |= 2;
                    }
                    this.f23759m.addAll(C11677b.m9588b(c11677b));
                }
            }
            setUnknownFields(getUnknownFields().concat(C11677b.m9591e(c11677b)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11677b c11677b = null;
            try {
                try {
                    C11677b partialFrom = C11677b.f23723k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11677b c11677b2 = (C11677b) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11677b = c11677b2;
                        if (c11677b != null) {
                            mergeFrom(c11677b);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11677b != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11677b c11677b = new C11677b();
        f23722j = c11677b;
        c11677b.id_ = 0;
        c11677b.argument_ = Collections.emptyList();
    }

    public C11677b(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m9587a(C11677b c11677b, int i) {
        c11677b.id_ = i;
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m9588b(C11677b c11677b) {
        return c11677b.argument_;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ List m9589c(C11677b c11677b, List list) {
        c11677b.argument_ = list;
        return list;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ int m9590d(C11677b c11677b, int i) {
        c11677b.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ ByteString3 m9591e(C11677b c11677b) {
        return c11677b.unknownFields;
    }

    public static C11677b getDefaultInstance() {
        return f23722j;
    }

    public static c newBuilder(C11677b c11677b) {
        return newBuilder().mergeFrom(c11677b);
    }

    public b getArgument(int i) {
        return this.argument_.get(i);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<b> getArgumentList() {
        return this.argument_;
    }

    public int getId() {
        return this.id_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public c toBuilder() {
        return newBuilder(this);
    }

    public C11677b() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11677b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = codedInputStream.readInt32();
                            } else if (tag != 18) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                if ((i & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    i |= 2;
                                }
                                this.argument_.add(codedInputStream.readMessage(b.f23725k, extensionRegistryLite));
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
