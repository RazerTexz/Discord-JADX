package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;

/* compiled from: ProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.h */
/* loaded from: classes3.dex */
public final class C11683h extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* renamed from: j */
    public static final C11683h f23816j;

    /* renamed from: k */
    public static Parser2<C11683h> f23817k = new a();
    private List<C11683h> andArgument_;
    private int bitField0_;
    private c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private C11692q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11683h> orArgument_;
    private final ByteString3 unknownFields;
    private int valueParameterReference_;

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.h$a */
    public static class a extends AbstractParser<C11683h> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11683h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11683h(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.h$b */
    public static final class b extends GeneratedMessageLite.b<C11683h, b> implements MessageLiteOrBuilder {

        /* renamed from: k */
        public int f23818k;

        /* renamed from: l */
        public int f23819l;

        /* renamed from: m */
        public int f23820m;

        /* renamed from: p */
        public int f23823p;

        /* renamed from: n */
        public c f23821n = c.TRUE;

        /* renamed from: o */
        public C11692q f23822o = C11692q.getDefaultInstance();

        /* renamed from: q */
        public List<C11683h> f23824q = Collections.emptyList();

        /* renamed from: r */
        public List<C11683h> f23825r = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11683h buildPartial() {
            C11683h c11683h = new C11683h(this, null);
            int i = this.f23818k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11683h.m9662a(c11683h, this.f23819l);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11683h.m9663b(c11683h, this.f23820m);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11683h.m9664c(c11683h, this.f23821n);
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            C11683h.m9665d(c11683h, this.f23822o);
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            C11683h.m9666e(c11683h, this.f23823p);
            if ((this.f23818k & 32) == 32) {
                this.f23824q = Collections.unmodifiableList(this.f23824q);
                this.f23818k &= -33;
            }
            C11683h.m9668g(c11683h, this.f23824q);
            if ((this.f23818k & 64) == 64) {
                this.f23825r = Collections.unmodifiableList(this.f23825r);
                this.f23818k &= -65;
            }
            C11683h.m9670i(c11683h, this.f23825r);
            C11683h.m9671j(c11683h, i2);
            return c11683h;
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

        public b mergeIsInstanceType(C11692q c11692q) {
            if ((this.f23818k & 8) != 8 || this.f23822o == C11692q.getDefaultInstance()) {
                this.f23822o = c11692q;
            } else {
                this.f23822o = C11692q.newBuilder(this.f23822o).mergeFrom(c11692q).buildPartial();
            }
            this.f23818k |= 8;
            return this;
        }

        public b setConstantValue(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23818k |= 4;
            this.f23821n = cVar;
            return this;
        }

        public b setFlags(int i) {
            this.f23818k |= 1;
            this.f23819l = i;
            return this;
        }

        public b setIsInstanceTypeId(int i) {
            this.f23818k |= 16;
            this.f23823p = i;
            return this;
        }

        public b setValueParameterReference(int i) {
            this.f23818k |= 2;
            this.f23820m = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11683h build() {
            C11683h c11683hBuildPartial = buildPartial();
            if (c11683hBuildPartial.isInitialized()) {
                return c11683hBuildPartial;
            }
            throw new UninitializedMessageException(c11683hBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11683h) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11683h c11683h) {
            if (c11683h == C11683h.getDefaultInstance()) {
                return this;
            }
            if (c11683h.hasFlags()) {
                setFlags(c11683h.getFlags());
            }
            if (c11683h.hasValueParameterReference()) {
                setValueParameterReference(c11683h.getValueParameterReference());
            }
            if (c11683h.hasConstantValue()) {
                setConstantValue(c11683h.getConstantValue());
            }
            if (c11683h.hasIsInstanceType()) {
                mergeIsInstanceType(c11683h.getIsInstanceType());
            }
            if (c11683h.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(c11683h.getIsInstanceTypeId());
            }
            if (!C11683h.m9667f(c11683h).isEmpty()) {
                if (this.f23824q.isEmpty()) {
                    this.f23824q = C11683h.m9667f(c11683h);
                    this.f23818k &= -33;
                } else {
                    if ((this.f23818k & 32) != 32) {
                        this.f23824q = new ArrayList(this.f23824q);
                        this.f23818k |= 32;
                    }
                    this.f23824q.addAll(C11683h.m9667f(c11683h));
                }
            }
            if (!C11683h.m9669h(c11683h).isEmpty()) {
                if (this.f23825r.isEmpty()) {
                    this.f23825r = C11683h.m9669h(c11683h);
                    this.f23818k &= -65;
                } else {
                    if ((this.f23818k & 64) != 64) {
                        this.f23825r = new ArrayList(this.f23825r);
                        this.f23818k |= 64;
                    }
                    this.f23825r.addAll(C11683h.m9669h(c11683h));
                }
            }
            setUnknownFields(getUnknownFields().concat(C11683h.m9672k(c11683h)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11683h c11683h = null;
            try {
                try {
                    C11683h partialFrom = C11683h.f23817k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11683h c11683h2 = (C11683h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11683h = c11683h2;
                        if (c11683h != null) {
                            mergeFrom(c11683h);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11683h != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.h$c */
    public enum c implements Internal.a {
        TRUE(0),
        FALSE(1),
        NULL(2);

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
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        C11683h c11683h = new C11683h();
        f23816j = c11683h;
        c11683h.m9673l();
    }

    public C11683h(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* renamed from: a */
    public static /* synthetic */ int m9662a(C11683h c11683h, int i) {
        c11683h.flags_ = i;
        return i;
    }

    /* renamed from: b */
    public static /* synthetic */ int m9663b(C11683h c11683h, int i) {
        c11683h.valueParameterReference_ = i;
        return i;
    }

    /* renamed from: c */
    public static /* synthetic */ c m9664c(C11683h c11683h, c cVar) {
        c11683h.constantValue_ = cVar;
        return cVar;
    }

    /* renamed from: d */
    public static /* synthetic */ C11692q m9665d(C11683h c11683h, C11692q c11692q) {
        c11683h.isInstanceType_ = c11692q;
        return c11692q;
    }

    /* renamed from: e */
    public static /* synthetic */ int m9666e(C11683h c11683h, int i) {
        c11683h.isInstanceTypeId_ = i;
        return i;
    }

    /* renamed from: f */
    public static /* synthetic */ List m9667f(C11683h c11683h) {
        return c11683h.andArgument_;
    }

    /* renamed from: g */
    public static /* synthetic */ List m9668g(C11683h c11683h, List list) {
        c11683h.andArgument_ = list;
        return list;
    }

    public static C11683h getDefaultInstance() {
        return f23816j;
    }

    /* renamed from: h */
    public static /* synthetic */ List m9669h(C11683h c11683h) {
        return c11683h.orArgument_;
    }

    /* renamed from: i */
    public static /* synthetic */ List m9670i(C11683h c11683h, List list) {
        c11683h.orArgument_ = list;
        return list;
    }

    /* renamed from: j */
    public static /* synthetic */ int m9671j(C11683h c11683h, int i) {
        c11683h.bitField0_ = i;
        return i;
    }

    /* renamed from: k */
    public static /* synthetic */ ByteString3 m9672k(C11683h c11683h) {
        return c11683h.unknownFields;
    }

    public static b newBuilder(C11683h c11683h) {
        return newBuilder().mergeFrom(c11683h);
    }

    public C11683h getAndArgument(int i) {
        return this.andArgument_.get(i);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public c getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public C11692q getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public C11683h getOrArgument(int i) {
        return this.orArgument_.get(i);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
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
        if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getAndArgumentCount(); i++) {
            if (!getAndArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
            if (!getOrArgument(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    /* renamed from: l */
    public final void m9673l() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = c.TRUE;
        this.isInstanceType_ = C11692q.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
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
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11683h() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11683h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9673l();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (tag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (tag == 24) {
                            int i2 = codedInputStream.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = cVarValueOf;
                            }
                        } else if (tag == 34) {
                            C11692q.c builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            C11692q c11692q = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                            this.isInstanceType_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (tag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (tag == 50) {
                            if ((i & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i |= 32;
                            }
                            this.andArgument_.add(codedInputStream.readMessage(f23817k, extensionRegistryLite));
                        } else if (tag != 58) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if ((i & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i |= 64;
                            }
                            this.orArgument_.add(codedInputStream.readMessage(f23817k, extensionRegistryLite));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if ((i & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
        if ((i & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
