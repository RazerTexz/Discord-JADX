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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.q */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11692q extends GeneratedMessageLite.d<C11692q> implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11692q f23903j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11692q> f23904k = new a();
    private int abbreviatedTypeId_;
    private C11692q abbreviatedType_;
    private List<b> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private C11692q flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private C11692q outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final ByteString3 unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11692q> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11692q parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11692q(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: j */
        public static final b f23905j;

        /* JADX INFO: renamed from: k */
        public static Parser2<b> f23906k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c projection_;
        private int typeId_;
        private C11692q type_;
        private final ByteString3 unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$a */
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

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C13323b extends GeneratedMessageLite.b<b, C13323b> implements MessageLiteOrBuilder {

            /* JADX INFO: renamed from: k */
            public int f23907k;

            /* JADX INFO: renamed from: l */
            public c f23908l = c.INV;

            /* JADX INFO: renamed from: m */
            public C11692q f23909m = C11692q.getDefaultInstance();

            /* JADX INFO: renamed from: n */
            public int f23910n;

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23907k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                b.m9757a(bVar, this.f23908l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                b.m9758b(bVar, this.f23909m);
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                b.m9759c(bVar, this.f23910n);
                b.m9760d(bVar, i2);
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

            public C13323b mergeType(C11692q c11692q) {
                if ((this.f23907k & 2) != 2 || this.f23909m == C11692q.getDefaultInstance()) {
                    this.f23909m = c11692q;
                } else {
                    this.f23909m = C11692q.newBuilder(this.f23909m).mergeFrom(c11692q).buildPartial();
                }
                this.f23907k |= 2;
                return this;
            }

            public C13323b setProjection(c cVar) {
                Objects.requireNonNull(cVar);
                this.f23907k |= 1;
                this.f23908l = cVar;
                return this;
            }

            public C13323b setTypeId(int i) {
                this.f23907k |= 4;
                this.f23910n = i;
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
            public C13323b clone() {
                return new C13323b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C13323b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasProjection()) {
                    setProjection(bVar.getProjection());
                }
                if (bVar.hasType()) {
                    mergeType(bVar.getType());
                }
                if (bVar.hasTypeId()) {
                    setTypeId(bVar.getTypeId());
                }
                setUnknownFields(getUnknownFields().concat(b.m9761e(bVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C13323b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23906k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$c */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum c implements Internal.a {
            IN(0),
            OUT(1),
            INV(2),
            STAR(3);

            private final int value;

            c(int i) {
                this.value = i;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
            public final int getNumber() {
                return this.value;
            }

            public static c valueOf(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i == 2) {
                    return INV;
                }
                if (i != 3) {
                    return null;
                }
                return STAR;
            }
        }

        static {
            b bVar = new b();
            f23905j = bVar;
            bVar.projection_ = c.INV;
            bVar.type_ = C11692q.getDefaultInstance();
            bVar.typeId_ = 0;
        }

        public b(GeneratedMessageLite.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ c m9757a(b bVar, c cVar) {
            bVar.projection_ = cVar;
            return cVar;
        }

        /* JADX INFO: renamed from: b */
        public static /* synthetic */ C11692q m9758b(b bVar, C11692q c11692q) {
            bVar.type_ = c11692q;
            return c11692q;
        }

        /* JADX INFO: renamed from: c */
        public static /* synthetic */ int m9759c(b bVar, int i) {
            bVar.typeId_ = i;
            return i;
        }

        /* JADX INFO: renamed from: d */
        public static /* synthetic */ int m9760d(b bVar, int i) {
            bVar.bitField0_ = i;
            return i;
        }

        /* JADX INFO: renamed from: e */
        public static /* synthetic */ ByteString3 m9761e(b bVar) {
            return bVar.unknownFields;
        }

        public static b getDefaultInstance() {
            return f23905j;
        }

        public static C13323b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public c getProjection() {
            return this.projection_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(3, this.typeId_);
            }
            int size = this.unknownFields.size() + iComputeEnumSize;
            this.memoizedSerializedSize = size;
            return size;
        }

        public C11692q getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasProjection() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 4) == 4;
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
            if (!hasType() || getType().isInitialized()) {
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
                codedOutputStream.writeEnum(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.typeId_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C13323b newBuilder() {
            return new C13323b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13323b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13323b toBuilder() {
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
            this.projection_ = c.INV;
            this.type_ = C11692q.getDefaultInstance();
            boolean z2 = false;
            this.typeId_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    int i = codedInputStream.readEnum();
                                    c cVarValueOf = c.valueOf(i);
                                    if (cVarValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.projection_ = cVarValueOf;
                                    }
                                } else if (tag == 18) {
                                    c builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                    C11692q c11692q = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                    this.type_ = c11692q;
                                    if (builder != null) {
                                        builder.mergeFrom(c11692q);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (tag != 24) {
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = codedInputStream.readInt32();
                                }
                            }
                            z2 = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends GeneratedMessageLite.c<C11692q, c> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: A */
        public int f23916A;

        /* JADX INFO: renamed from: m */
        public int f23917m;

        /* JADX INFO: renamed from: o */
        public boolean f23919o;

        /* JADX INFO: renamed from: p */
        public int f23920p;

        /* JADX INFO: renamed from: r */
        public int f23922r;

        /* JADX INFO: renamed from: s */
        public int f23923s;

        /* JADX INFO: renamed from: t */
        public int f23924t;

        /* JADX INFO: renamed from: u */
        public int f23925u;

        /* JADX INFO: renamed from: v */
        public int f23926v;

        /* JADX INFO: renamed from: x */
        public int f23928x;

        /* JADX INFO: renamed from: z */
        public int f23930z;

        /* JADX INFO: renamed from: n */
        public List<b> f23918n = Collections.emptyList();

        /* JADX INFO: renamed from: q */
        public C11692q f23921q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: w */
        public C11692q f23927w = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: y */
        public C11692q f23929y = C11692q.getDefaultInstance();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11692q buildPartial() {
            C11692q c11692q = new C11692q(this, null);
            int i = this.f23917m;
            if ((i & 1) == 1) {
                this.f23918n = Collections.unmodifiableList(this.f23918n);
                this.f23917m &= -2;
            }
            C11692q.m9740i(c11692q, this.f23918n);
            int i2 = (i & 2) != 2 ? 0 : 1;
            C11692q.m9741j(c11692q, this.f23919o);
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            C11692q.m9742k(c11692q, this.f23920p);
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            C11692q.m9743l(c11692q, this.f23921q);
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            C11692q.m9744m(c11692q, this.f23922r);
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            C11692q.m9745n(c11692q, this.f23923s);
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            C11692q.m9746o(c11692q, this.f23924t);
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            C11692q.m9747p(c11692q, this.f23925u);
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            C11692q.m9748q(c11692q, this.f23926v);
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            C11692q.m9749r(c11692q, this.f23927w);
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            C11692q.m9750s(c11692q, this.f23928x);
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            C11692q.m9751t(c11692q, this.f23929y);
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            C11692q.m9752u(c11692q, this.f23930z);
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            C11692q.m9753v(c11692q, this.f23916A);
            C11692q.m9754w(c11692q, i2);
            return c11692q;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        public c mergeAbbreviatedType(C11692q c11692q) {
            if ((this.f23917m & 2048) != 2048 || this.f23929y == C11692q.getDefaultInstance()) {
                this.f23929y = c11692q;
            } else {
                this.f23929y = C11692q.newBuilder(this.f23929y).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 2048;
            return this;
        }

        public c mergeFlexibleUpperBound(C11692q c11692q) {
            if ((this.f23917m & 8) != 8 || this.f23921q == C11692q.getDefaultInstance()) {
                this.f23921q = c11692q;
            } else {
                this.f23921q = C11692q.newBuilder(this.f23921q).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 8;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public c mergeOuterType(C11692q c11692q) {
            if ((this.f23917m & 512) != 512 || this.f23927w == C11692q.getDefaultInstance()) {
                this.f23927w = c11692q;
            } else {
                this.f23927w = C11692q.newBuilder(this.f23927w).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 512;
            return this;
        }

        public c setAbbreviatedTypeId(int i) {
            this.f23917m |= 4096;
            this.f23930z = i;
            return this;
        }

        public c setClassName(int i) {
            this.f23917m |= 32;
            this.f23923s = i;
            return this;
        }

        public c setFlags(int i) {
            this.f23917m |= 8192;
            this.f23916A = i;
            return this;
        }

        public c setFlexibleTypeCapabilitiesId(int i) {
            this.f23917m |= 4;
            this.f23920p = i;
            return this;
        }

        public c setFlexibleUpperBoundId(int i) {
            this.f23917m |= 16;
            this.f23922r = i;
            return this;
        }

        public c setNullable(boolean z2) {
            this.f23917m |= 2;
            this.f23919o = z2;
            return this;
        }

        public c setOuterTypeId(int i) {
            this.f23917m |= 1024;
            this.f23928x = i;
            return this;
        }

        public c setTypeAliasName(int i) {
            this.f23917m |= 256;
            this.f23926v = i;
            return this;
        }

        public c setTypeParameter(int i) {
            this.f23917m |= 64;
            this.f23924t = i;
            return this;
        }

        public c setTypeParameterName(int i) {
            this.f23917m |= 128;
            this.f23925u = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11692q build() {
            C11692q c11692qBuildPartial = buildPartial();
            if (c11692qBuildPartial.isInitialized()) {
                return c11692qBuildPartial;
            }
            throw new UninitializedMessageException(c11692qBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11692q) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public c clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public c mergeFrom(C11692q c11692q) {
            if (c11692q == C11692q.getDefaultInstance()) {
                return this;
            }
            if (!C11692q.m9739h(c11692q).isEmpty()) {
                if (this.f23918n.isEmpty()) {
                    this.f23918n = C11692q.m9739h(c11692q);
                    this.f23917m &= -2;
                } else {
                    if ((this.f23917m & 1) != 1) {
                        this.f23918n = new ArrayList(this.f23918n);
                        this.f23917m |= 1;
                    }
                    this.f23918n.addAll(C11692q.m9739h(c11692q));
                }
            }
            if (c11692q.hasNullable()) {
                setNullable(c11692q.getNullable());
            }
            if (c11692q.hasFlexibleTypeCapabilitiesId()) {
                setFlexibleTypeCapabilitiesId(c11692q.getFlexibleTypeCapabilitiesId());
            }
            if (c11692q.hasFlexibleUpperBound()) {
                mergeFlexibleUpperBound(c11692q.getFlexibleUpperBound());
            }
            if (c11692q.hasFlexibleUpperBoundId()) {
                setFlexibleUpperBoundId(c11692q.getFlexibleUpperBoundId());
            }
            if (c11692q.hasClassName()) {
                setClassName(c11692q.getClassName());
            }
            if (c11692q.hasTypeParameter()) {
                setTypeParameter(c11692q.getTypeParameter());
            }
            if (c11692q.hasTypeParameterName()) {
                setTypeParameterName(c11692q.getTypeParameterName());
            }
            if (c11692q.hasTypeAliasName()) {
                setTypeAliasName(c11692q.getTypeAliasName());
            }
            if (c11692q.hasOuterType()) {
                mergeOuterType(c11692q.getOuterType());
            }
            if (c11692q.hasOuterTypeId()) {
                setOuterTypeId(c11692q.getOuterTypeId());
            }
            if (c11692q.hasAbbreviatedType()) {
                mergeAbbreviatedType(c11692q.getAbbreviatedType());
            }
            if (c11692q.hasAbbreviatedTypeId()) {
                setAbbreviatedTypeId(c11692q.getAbbreviatedTypeId());
            }
            if (c11692q.hasFlags()) {
                setFlags(c11692q.getFlags());
            }
            m9846b(c11692q);
            setUnknownFields(getUnknownFields().concat(C11692q.m9755x(c11692q)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11692q c11692q = null;
            try {
                try {
                    C11692q partialFrom = C11692q.f23904k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11692q c11692q2 = (C11692q) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11692q = c11692q2;
                        if (c11692q != null) {
                            mergeFrom(c11692q);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11692q != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11692q c11692q = new C11692q();
        f23903j = c11692q;
        c11692q.m9756y();
    }

    public C11692q(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11692q getDefaultInstance() {
        return f23903j;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ List m9739h(C11692q c11692q) {
        return c11692q.argument_;
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ List m9740i(C11692q c11692q, List list) {
        c11692q.argument_ = list;
        return list;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ boolean m9741j(C11692q c11692q, boolean z2) {
        c11692q.nullable_ = z2;
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ int m9742k(C11692q c11692q, int i) {
        c11692q.flexibleTypeCapabilitiesId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ C11692q m9743l(C11692q c11692q, C11692q c11692q2) {
        c11692q.flexibleUpperBound_ = c11692q2;
        return c11692q2;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m9744m(C11692q c11692q, int i) {
        c11692q.flexibleUpperBoundId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ int m9745n(C11692q c11692q, int i) {
        c11692q.className_ = i;
        return i;
    }

    public static c newBuilder(C11692q c11692q) {
        return newBuilder().mergeFrom(c11692q);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ int m9746o(C11692q c11692q, int i) {
        c11692q.typeParameter_ = i;
        return i;
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ int m9747p(C11692q c11692q, int i) {
        c11692q.typeParameterName_ = i;
        return i;
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ int m9748q(C11692q c11692q, int i) {
        c11692q.typeAliasName_ = i;
        return i;
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ C11692q m9749r(C11692q c11692q, C11692q c11692q2) {
        c11692q.outerType_ = c11692q2;
        return c11692q2;
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ int m9750s(C11692q c11692q, int i) {
        c11692q.outerTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ C11692q m9751t(C11692q c11692q, C11692q c11692q2) {
        c11692q.abbreviatedType_ = c11692q2;
        return c11692q2;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ int m9752u(C11692q c11692q, int i) {
        c11692q.abbreviatedTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: v */
    public static /* synthetic */ int m9753v(C11692q c11692q, int i) {
        c11692q.flags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ int m9754w(C11692q c11692q, int i) {
        c11692q.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ ByteString3 m9755x(C11692q c11692q) {
        return c11692q.unknownFields;
    }

    public C11692q getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
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

    public int getClassName() {
        return this.className_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public C11692q getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public C11692q getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeBoolSize(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        }
        int size = this.unknownFields.size() + m9849c() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    public boolean hasAbbreviatedType() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasAbbreviatedTypeId() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean hasClassName() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 4096) == 4096;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasFlexibleUpperBound() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlexibleUpperBoundId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasNullable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasOuterType() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOuterTypeId() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasTypeAliasName() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean hasTypeParameter() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTypeParameterName() {
        return (this.bitField0_ & 64) == 64;
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
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasOuterType() && !getOuterType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (m9848b()) {
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
        GeneratedMessageLite.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBool(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeInt32(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeMessage(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* JADX INFO: renamed from: y */
    public final void m9756y() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public static c newBuilder() {
        return new c();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11692q getDefaultInstanceForType() {
        return f23903j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public c toBuilder() {
        return newBuilder(this);
    }

    public C11692q() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11692q(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9756y();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    switch (tag) {
                        case 0:
                            z2 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 18:
                            if (!(z3 & true)) {
                                this.argument_ = new ArrayList();
                                z3 |= true;
                            }
                            this.argument_.add(codedInputStream.readMessage(b.f23906k, extensionRegistryLite));
                            break;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = codedInputStream.readBool();
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            break;
                        case 42:
                            builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                            C11692q c11692q = (C11692q) codedInputStream.readMessage(f23904k, extensionRegistryLite);
                            this.flexibleUpperBound_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.flexibleUpperBound_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 48:
                            this.bitField0_ |= 16;
                            this.className_ = codedInputStream.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = codedInputStream.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = codedInputStream.readInt32();
                            break;
                        case 82:
                            builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                            C11692q c11692q2 = (C11692q) codedInputStream.readMessage(f23904k, extensionRegistryLite);
                            this.outerType_ = c11692q2;
                            if (builder != null) {
                                builder.mergeFrom(c11692q2);
                                this.outerType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            break;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = codedInputStream.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = codedInputStream.readInt32();
                            break;
                        case 106:
                            builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                            C11692q c11692q3 = (C11692q) codedInputStream.readMessage(f23904k, extensionRegistryLite);
                            this.abbreviatedType_ = c11692q3;
                            if (builder != null) {
                                builder.mergeFrom(c11692q3);
                                this.abbreviatedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            break;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (!m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
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
                if (z3 & true) {
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
                m9850d();
                throw th;
            }
        }
        if (z3 & true) {
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
        m9850d();
    }
}
