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

/* compiled from: ProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.s */
/* loaded from: classes3.dex */
public final class C11694s extends GeneratedMessageLite.d<C11694s> implements MessageLiteOrBuilder {

    /* renamed from: j */
    public static final C11694s f23943j;

    /* renamed from: k */
    public static Parser2<C11694s> f23944k = new a();
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final ByteString3 unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<C11692q> upperBound_;
    private c variance_;

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.s$a */
    public static class a extends AbstractParser<C11694s> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11694s parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11694s(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.s$b */
    public static final class b extends GeneratedMessageLite.c<C11694s, b> implements MessageLiteOrBuilder {

        /* renamed from: m */
        public int f23945m;

        /* renamed from: n */
        public int f23946n;

        /* renamed from: o */
        public int f23947o;

        /* renamed from: p */
        public boolean f23948p;

        /* renamed from: q */
        public c f23949q = c.INV;

        /* renamed from: r */
        public List<C11692q> f23950r = Collections.emptyList();

        /* renamed from: s */
        public List<Integer> f23951s = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11694s buildPartial() {
            C11694s c11694s = new C11694s(this, null);
            int i = this.f23945m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11694s.m9777h(c11694s, this.f23946n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11694s.m9778i(c11694s, this.f23947o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11694s.m9779j(c11694s, this.f23948p);
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            C11694s.m9780k(c11694s, this.f23949q);
            if ((this.f23945m & 16) == 16) {
                this.f23950r = Collections.unmodifiableList(this.f23950r);
                this.f23945m &= -17;
            }
            C11694s.m9782m(c11694s, this.f23950r);
            if ((this.f23945m & 32) == 32) {
                this.f23951s = Collections.unmodifiableList(this.f23951s);
                this.f23945m &= -33;
            }
            C11694s.m9784o(c11694s, this.f23951s);
            C11694s.m9785p(c11694s, i2);
            return c11694s;
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

        public b setId(int i) {
            this.f23945m |= 1;
            this.f23946n = i;
            return this;
        }

        public b setName(int i) {
            this.f23945m |= 2;
            this.f23947o = i;
            return this;
        }

        public b setReified(boolean z2) {
            this.f23945m |= 4;
            this.f23948p = z2;
            return this;
        }

        public b setVariance(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23945m |= 8;
            this.f23949q = cVar;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11694s build() {
            C11694s c11694sBuildPartial = buildPartial();
            if (c11694sBuildPartial.isInitialized()) {
                return c11694sBuildPartial;
            }
            throw new UninitializedMessageException(c11694sBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11694s) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11694s c11694s) {
            if (c11694s == C11694s.getDefaultInstance()) {
                return this;
            }
            if (c11694s.hasId()) {
                setId(c11694s.getId());
            }
            if (c11694s.hasName()) {
                setName(c11694s.getName());
            }
            if (c11694s.hasReified()) {
                setReified(c11694s.getReified());
            }
            if (c11694s.hasVariance()) {
                setVariance(c11694s.getVariance());
            }
            if (!C11694s.m9781l(c11694s).isEmpty()) {
                if (this.f23950r.isEmpty()) {
                    this.f23950r = C11694s.m9781l(c11694s);
                    this.f23945m &= -17;
                } else {
                    if ((this.f23945m & 16) != 16) {
                        this.f23950r = new ArrayList(this.f23950r);
                        this.f23945m |= 16;
                    }
                    this.f23950r.addAll(C11694s.m9781l(c11694s));
                }
            }
            if (!C11694s.m9783n(c11694s).isEmpty()) {
                if (this.f23951s.isEmpty()) {
                    this.f23951s = C11694s.m9783n(c11694s);
                    this.f23945m &= -33;
                } else {
                    if ((this.f23945m & 32) != 32) {
                        this.f23951s = new ArrayList(this.f23951s);
                        this.f23945m |= 32;
                    }
                    this.f23951s.addAll(C11694s.m9783n(c11694s));
                }
            }
            m9846b(c11694s);
            setUnknownFields(getUnknownFields().concat(C11694s.m9786q(c11694s)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11694s c11694s = null;
            try {
                try {
                    C11694s partialFrom = C11694s.f23944k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11694s c11694s2 = (C11694s) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11694s = c11694s2;
                        if (c11694s != null) {
                            mergeFrom(c11694s);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11694s != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.s$c */
    public enum c implements Internal.a {
        IN(0),
        OUT(1),
        INV(2);

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
            if (i != 2) {
                return null;
            }
            return INV;
        }
    }

    static {
        C11694s c11694s = new C11694s();
        f23943j = c11694s;
        c11694s.m9787r();
    }

    public C11694s(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11694s getDefaultInstance() {
        return f23943j;
    }

    /* renamed from: h */
    public static /* synthetic */ int m9777h(C11694s c11694s, int i) {
        c11694s.id_ = i;
        return i;
    }

    /* renamed from: i */
    public static /* synthetic */ int m9778i(C11694s c11694s, int i) {
        c11694s.name_ = i;
        return i;
    }

    /* renamed from: j */
    public static /* synthetic */ boolean m9779j(C11694s c11694s, boolean z2) {
        c11694s.reified_ = z2;
        return z2;
    }

    /* renamed from: k */
    public static /* synthetic */ c m9780k(C11694s c11694s, c cVar) {
        c11694s.variance_ = cVar;
        return cVar;
    }

    /* renamed from: l */
    public static /* synthetic */ List m9781l(C11694s c11694s) {
        return c11694s.upperBound_;
    }

    /* renamed from: m */
    public static /* synthetic */ List m9782m(C11694s c11694s, List list) {
        c11694s.upperBound_ = list;
        return list;
    }

    /* renamed from: n */
    public static /* synthetic */ List m9783n(C11694s c11694s) {
        return c11694s.upperBoundId_;
    }

    public static b newBuilder(C11694s c11694s) {
        return newBuilder().mergeFrom(c11694s);
    }

    /* renamed from: o */
    public static /* synthetic */ List m9784o(C11694s c11694s, List list) {
        c11694s.upperBoundId_ = list;
        return list;
    }

    /* renamed from: p */
    public static /* synthetic */ int m9785p(C11694s c11694s, int i) {
        c11694s.bitField0_ = i;
        return i;
    }

    /* renamed from: q */
    public static /* synthetic */ ByteString3 m9786q(C11694s c11694s) {
        return c11694s.unknownFields;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    public boolean getReified() {
        return this.reified_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeBoolSize(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        }
        for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.upperBoundId_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i3).intValue());
        }
        int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getUpperBoundIdList().isEmpty()) {
            iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.upperBoundIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        int size = this.unknownFields.size() + m9849c() + iComputeInt32SizeNoTag2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11692q getUpperBound(int i) {
        return this.upperBound_.get(i);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<C11692q> getUpperBoundList() {
        return this.upperBound_;
    }

    public c getVariance() {
        return this.variance_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReified() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasVariance() {
        return (this.bitField0_ & 8) == 8;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getUpperBoundCount(); i++) {
            if (!getUpperBound(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
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

    /* renamed from: r */
    public final void m9787r() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = c.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
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
            codedOutputStream.writeInt32(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBool(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(4, this.variance_.getNumber());
        }
        for (int i = 0; i < this.upperBound_.size(); i++) {
            codedOutputStream.writeMessage(5, this.upperBound_.get(i));
        }
        if (getUpperBoundIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(50);
            codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
            codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i2).intValue());
        }
        aVarM9851e.writeUntil(1000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11694s getDefaultInstanceForType() {
        return f23943j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11694s() {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11694s(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9787r();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
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
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.reified_ = codedInputStream.readBool();
                            } else if (tag == 32) {
                                int i2 = codedInputStream.readEnum();
                                c cVarValueOf = c.valueOf(i2);
                                if (cVarValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i2);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.variance_ = cVarValueOf;
                                }
                            } else if (tag == 42) {
                                if ((i & 16) != 16) {
                                    this.upperBound_ = new ArrayList();
                                    i |= 16;
                                }
                                this.upperBound_.add(codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite));
                            } else if (tag == 48) {
                                if ((i & 32) != 32) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (tag != 50) {
                                if (!m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(iPushLimit);
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
                if ((i & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((i & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
        if ((i & 16) == 16) {
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if ((i & 32) == 32) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
