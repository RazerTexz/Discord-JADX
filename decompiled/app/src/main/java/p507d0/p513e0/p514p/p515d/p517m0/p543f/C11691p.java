package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.CodedInputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringArrayList;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringList;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ProtocolStringList;

/* compiled from: ProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.p */
/* loaded from: classes3.dex */
public final class C11691p extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* renamed from: j */
    public static final C11691p f23899j;

    /* renamed from: k */
    public static Parser2<C11691p> f23900k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private LazyStringList string_;
    private final ByteString3 unknownFields;

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.p$a */
    public static class a extends AbstractParser<C11691p> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11691p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11691p(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.p$b */
    public static final class b extends GeneratedMessageLite.b<C11691p, b> implements MessageLiteOrBuilder {

        /* renamed from: k */
        public int f23901k;

        /* renamed from: l */
        public LazyStringList f23902l = LazyStringArrayList.f24147j;

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11691p buildPartial() {
            C11691p c11691p = new C11691p(this, null);
            if ((this.f23901k & 1) == 1) {
                this.f23902l = this.f23902l.getUnmodifiableView();
                this.f23901k &= -2;
            }
            C11691p.m9737b(c11691p, this.f23902l);
            return c11691p;
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11691p build() {
            C11691p c11691pBuildPartial = buildPartial();
            if (c11691pBuildPartial.isInitialized()) {
                return c11691pBuildPartial;
            }
            throw new UninitializedMessageException(c11691pBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11691p) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11691p c11691p) {
            if (c11691p == C11691p.getDefaultInstance()) {
                return this;
            }
            if (!C11691p.m9736a(c11691p).isEmpty()) {
                if (this.f23902l.isEmpty()) {
                    this.f23902l = C11691p.m9736a(c11691p);
                    this.f23901k &= -2;
                } else {
                    if ((this.f23901k & 1) != 1) {
                        this.f23902l = new LazyStringArrayList(this.f23902l);
                        this.f23901k |= 1;
                    }
                    this.f23902l.addAll(C11691p.m9736a(c11691p));
                }
            }
            setUnknownFields(getUnknownFields().concat(C11691p.m9738c(c11691p)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11691p c11691p = null;
            try {
                try {
                    C11691p partialFrom = C11691p.f23900k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11691p c11691p2 = (C11691p) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11691p = c11691p2;
                        if (c11691p != null) {
                            mergeFrom(c11691p);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11691p != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11691p c11691p = new C11691p();
        f23899j = c11691p;
        c11691p.string_ = LazyStringArrayList.f24147j;
    }

    public C11691p(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* renamed from: a */
    public static /* synthetic */ LazyStringList m9736a(C11691p c11691p) {
        return c11691p.string_;
    }

    /* renamed from: b */
    public static /* synthetic */ LazyStringList m9737b(C11691p c11691p, LazyStringList lazyStringList) {
        c11691p.string_ = lazyStringList;
        return lazyStringList;
    }

    /* renamed from: c */
    public static /* synthetic */ ByteString3 m9738c(C11691p c11691p) {
        return c11691p.unknownFields;
    }

    public static C11691p getDefaultInstance() {
        return f23899j;
    }

    public static b newBuilder(C11691p c11691p) {
        return newBuilder().mergeFrom(c11691p);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeBytesSizeNoTag = 0;
        for (int i2 = 0; i2 < this.string_.size(); i2++) {
            iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i2));
        }
        int size = this.unknownFields.size() + (getStringList().size() * 1) + 0 + iComputeBytesSizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString(int i) {
        return this.string_.get(i);
    }

    public ProtocolStringList getStringList() {
        return this.string_;
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
        for (int i = 0; i < this.string_.size(); i++) {
            codedOutputStream.writeBytes(1, this.string_.getByteString(i));
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

    public C11691p() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    public C11691p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.string_ = LazyStringArrayList.f24147j;
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
                            if (tag != 10) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                ByteString3 bytes = codedInputStream.readBytes();
                                if (!(z3 & true)) {
                                    this.string_ = new LazyStringArrayList();
                                    z3 |= true;
                                }
                                this.string_.add(bytes);
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
                    this.string_ = this.string_.getUnmodifiableView();
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
            this.string_ = this.string_.getUnmodifiableView();
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
