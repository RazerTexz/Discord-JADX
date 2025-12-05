package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.CodedInputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;

/* compiled from: ProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.u */
/* loaded from: classes3.dex */
public final class C11696u extends GeneratedMessageLite.d<C11696u> implements MessageLiteOrBuilder {

    /* renamed from: j */
    public static final C11696u f23961j;

    /* renamed from: k */
    public static Parser2<C11696u> f23962k = new a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private C11692q type_;
    private final ByteString3 unknownFields;
    private int varargElementTypeId_;
    private C11692q varargElementType_;

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.u$a */
    public static class a extends AbstractParser<C11696u> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11696u parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11696u(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.u$b */
    public static final class b extends GeneratedMessageLite.c<C11696u, b> implements MessageLiteOrBuilder {

        /* renamed from: m */
        public int f23963m;

        /* renamed from: n */
        public int f23964n;

        /* renamed from: o */
        public int f23965o;

        /* renamed from: q */
        public int f23967q;

        /* renamed from: s */
        public int f23969s;

        /* renamed from: p */
        public C11692q f23966p = C11692q.getDefaultInstance();

        /* renamed from: r */
        public C11692q f23968r = C11692q.getDefaultInstance();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11696u buildPartial() {
            C11696u c11696u = new C11696u(this, null);
            int i = this.f23963m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11696u.m9793h(c11696u, this.f23964n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11696u.m9794i(c11696u, this.f23965o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11696u.m9795j(c11696u, this.f23966p);
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            C11696u.m9796k(c11696u, this.f23967q);
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            C11696u.m9797l(c11696u, this.f23968r);
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            C11696u.m9798m(c11696u, this.f23969s);
            C11696u.m9799n(c11696u, i2);
            return c11696u;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeType(C11692q c11692q) {
            if ((this.f23963m & 4) != 4 || this.f23966p == C11692q.getDefaultInstance()) {
                this.f23966p = c11692q;
            } else {
                this.f23966p = C11692q.newBuilder(this.f23966p).mergeFrom(c11692q).buildPartial();
            }
            this.f23963m |= 4;
            return this;
        }

        public b mergeVarargElementType(C11692q c11692q) {
            if ((this.f23963m & 16) != 16 || this.f23968r == C11692q.getDefaultInstance()) {
                this.f23968r = c11692q;
            } else {
                this.f23968r = C11692q.newBuilder(this.f23968r).mergeFrom(c11692q).buildPartial();
            }
            this.f23963m |= 16;
            return this;
        }

        public b setFlags(int i) {
            this.f23963m |= 1;
            this.f23964n = i;
            return this;
        }

        public b setName(int i) {
            this.f23963m |= 2;
            this.f23965o = i;
            return this;
        }

        public b setTypeId(int i) {
            this.f23963m |= 8;
            this.f23967q = i;
            return this;
        }

        public b setVarargElementTypeId(int i) {
            this.f23963m |= 32;
            this.f23969s = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11696u build() {
            C11696u c11696uBuildPartial = buildPartial();
            if (c11696uBuildPartial.isInitialized()) {
                return c11696uBuildPartial;
            }
            throw new UninitializedMessageException(c11696uBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11696u) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11696u c11696u) {
            if (c11696u == C11696u.getDefaultInstance()) {
                return this;
            }
            if (c11696u.hasFlags()) {
                setFlags(c11696u.getFlags());
            }
            if (c11696u.hasName()) {
                setName(c11696u.getName());
            }
            if (c11696u.hasType()) {
                mergeType(c11696u.getType());
            }
            if (c11696u.hasTypeId()) {
                setTypeId(c11696u.getTypeId());
            }
            if (c11696u.hasVarargElementType()) {
                mergeVarargElementType(c11696u.getVarargElementType());
            }
            if (c11696u.hasVarargElementTypeId()) {
                setVarargElementTypeId(c11696u.getVarargElementTypeId());
            }
            m9846b(c11696u);
            setUnknownFields(getUnknownFields().concat(C11696u.m9800o(c11696u)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11696u c11696u = null;
            try {
                try {
                    C11696u partialFrom = C11696u.f23962k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11696u c11696u2 = (C11696u) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11696u = c11696u2;
                        if (c11696u != null) {
                            mergeFrom(c11696u);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11696u != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11696u c11696u = new C11696u();
        f23961j = c11696u;
        c11696u.m9801p();
    }

    public C11696u(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11696u getDefaultInstance() {
        return f23961j;
    }

    /* renamed from: h */
    public static /* synthetic */ int m9793h(C11696u c11696u, int i) {
        c11696u.flags_ = i;
        return i;
    }

    /* renamed from: i */
    public static /* synthetic */ int m9794i(C11696u c11696u, int i) {
        c11696u.name_ = i;
        return i;
    }

    /* renamed from: j */
    public static /* synthetic */ C11692q m9795j(C11696u c11696u, C11692q c11692q) {
        c11696u.type_ = c11692q;
        return c11692q;
    }

    /* renamed from: k */
    public static /* synthetic */ int m9796k(C11696u c11696u, int i) {
        c11696u.typeId_ = i;
        return i;
    }

    /* renamed from: l */
    public static /* synthetic */ C11692q m9797l(C11696u c11696u, C11692q c11692q) {
        c11696u.varargElementType_ = c11692q;
        return c11692q;
    }

    /* renamed from: m */
    public static /* synthetic */ int m9798m(C11696u c11696u, int i) {
        c11696u.varargElementTypeId_ = i;
        return i;
    }

    /* renamed from: n */
    public static /* synthetic */ int m9799n(C11696u c11696u, int i) {
        c11696u.bitField0_ = i;
        return i;
    }

    public static b newBuilder(C11696u c11696u) {
        return newBuilder().mergeFrom(c11696u);
    }

    /* renamed from: o */
    public static /* synthetic */ ByteString3 m9800o(C11696u c11696u) {
        return c11696u.unknownFields;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        }
        int size = this.unknownFields.size() + m9849c() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11692q getType() {
        return this.type_;
    }

    public int getTypeId() {
        return this.typeId_;
    }

    public C11692q getVarargElementType() {
        return this.varargElementType_;
    }

    public int getVarargElementTypeId() {
        return this.varargElementTypeId_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVarargElementType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVarargElementTypeId() {
        return (this.bitField0_ & 32) == 32;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasType() && !getType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
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

    /* renamed from: p */
    public final void m9801p() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = C11692q.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = C11692q.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.varargElementTypeId_);
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11696u getDefaultInstanceForType() {
        return f23961j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11696u() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    public C11696u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        C11692q.c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9801p();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (tag == 26) {
                                    builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                    C11692q c11692q = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                    this.type_ = c11692q;
                                    if (builder != null) {
                                        builder.mergeFrom(c11692q);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (tag == 34) {
                                    builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                    C11692q c11692q2 = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                    this.varargElementType_ = c11692q2;
                                    if (builder != null) {
                                        builder.mergeFrom(c11692q2);
                                        this.varargElementType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                } else if (tag == 40) {
                                    this.bitField0_ |= 8;
                                    this.typeId_ = codedInputStream.readInt32();
                                } else if (tag != 48) {
                                    if (!m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 32;
                                    this.varargElementTypeId_ = codedInputStream.readInt32();
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
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
                m9850d();
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
        m9850d();
    }
}
