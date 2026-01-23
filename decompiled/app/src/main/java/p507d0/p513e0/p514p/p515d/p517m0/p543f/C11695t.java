package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.CodedInputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.t */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11695t extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11695t f23956j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11695t> f23957k = new a();
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11692q> type_;
    private final ByteString3 unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.t$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11695t> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11695t parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11695t(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.t$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<C11695t, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: k */
        public int f23958k;

        /* JADX INFO: renamed from: l */
        public List<C11692q> f23959l = Collections.emptyList();

        /* JADX INFO: renamed from: m */
        public int f23960m = -1;

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11695t buildPartial() {
            C11695t c11695t = new C11695t(this, null);
            int i = this.f23958k;
            if ((i & 1) == 1) {
                this.f23959l = Collections.unmodifiableList(this.f23959l);
                this.f23958k &= -2;
            }
            C11695t.m9789b(c11695t, this.f23959l);
            int i2 = (i & 2) != 2 ? 0 : 1;
            C11695t.m9790c(c11695t, this.f23960m);
            C11695t.m9791d(c11695t, i2);
            return c11695t;
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

        public b setFirstNullable(int i) {
            this.f23958k |= 2;
            this.f23960m = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11695t build() {
            C11695t c11695tBuildPartial = buildPartial();
            if (c11695tBuildPartial.isInitialized()) {
                return c11695tBuildPartial;
            }
            throw new UninitializedMessageException(c11695tBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11695t) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11695t c11695t) {
            if (c11695t == C11695t.getDefaultInstance()) {
                return this;
            }
            if (!C11695t.m9788a(c11695t).isEmpty()) {
                if (this.f23959l.isEmpty()) {
                    this.f23959l = C11695t.m9788a(c11695t);
                    this.f23958k &= -2;
                } else {
                    if ((this.f23958k & 1) != 1) {
                        this.f23959l = new ArrayList(this.f23959l);
                        this.f23958k |= 1;
                    }
                    this.f23959l.addAll(C11695t.m9788a(c11695t));
                }
            }
            if (c11695t.hasFirstNullable()) {
                setFirstNullable(c11695t.getFirstNullable());
            }
            setUnknownFields(getUnknownFields().concat(C11695t.m9792e(c11695t)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11695t c11695t = null;
            try {
                try {
                    C11695t partialFrom = C11695t.f23957k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11695t c11695t2 = (C11695t) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11695t = c11695t2;
                        if (c11695t != null) {
                            mergeFrom(c11695t);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11695t != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11695t c11695t = new C11695t();
        f23956j = c11695t;
        c11695t.type_ = Collections.emptyList();
        c11695t.firstNullable_ = -1;
    }

    public C11695t(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ List m9788a(C11695t c11695t) {
        return c11695t.type_;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m9789b(C11695t c11695t, List list) {
        c11695t.type_ = list;
        return list;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ int m9790c(C11695t c11695t, int i) {
        c11695t.firstNullable_ = i;
        return i;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ int m9791d(C11695t c11695t, int i) {
        c11695t.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ ByteString3 m9792e(C11695t c11695t) {
        return c11695t.unknownFields;
    }

    public static C11695t getDefaultInstance() {
        return f23956j;
    }

    public static b newBuilder(C11695t c11695t) {
        return newBuilder().mergeFrom(c11695t);
    }

    public int getFirstNullable() {
        return this.firstNullable_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = 0;
        for (int i2 = 0; i2 < this.type_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(1, this.type_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11692q getType(int i) {
        return this.type_.get(i);
    }

    public int getTypeCount() {
        return this.type_.size();
    }

    public List<C11692q> getTypeList() {
        return this.type_;
    }

    public boolean hasFirstNullable() {
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
        for (int i = 0; i < getTypeCount(); i++) {
            if (!getType(i).isInitialized()) {
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
        for (int i = 0; i < this.type_.size(); i++) {
            codedOutputStream.writeMessage(1, this.type_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(2, this.firstNullable_);
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

    public C11695t() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11695t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!(z3 & true)) {
                                    this.type_ = new ArrayList();
                                    z3 |= true;
                                }
                                this.type_.add(codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite));
                            } else if (tag != 16) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = codedInputStream.readInt32();
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
                if (z3 & true) {
                    this.type_ = Collections.unmodifiableList(this.type_);
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
        if (z3 & true) {
            this.type_ = Collections.unmodifiableList(this.type_);
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
