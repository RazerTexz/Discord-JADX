package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
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
/* renamed from: d0.e0.p.d.m0.f.m */
/* loaded from: classes3.dex */
public final class C11688m extends GeneratedMessageLite.d<C11688m> implements MessageLiteOrBuilder {

    /* renamed from: j */
    public static final C11688m f23863j;

    /* renamed from: k */
    public static Parser2<C11688m> f23864k = new a();
    private int bitField0_;
    private List<C11678c> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private C11687l package_;
    private C11690o qualifiedNames_;
    private C11691p strings_;
    private final ByteString3 unknownFields;

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.m$a */
    public static class a extends AbstractParser<C11688m> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11688m parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11688m(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.m$b */
    public static final class b extends GeneratedMessageLite.c<C11688m, b> implements MessageLiteOrBuilder {

        /* renamed from: m */
        public int f23865m;

        /* renamed from: n */
        public C11691p f23866n = C11691p.getDefaultInstance();

        /* renamed from: o */
        public C11690o f23867o = C11690o.getDefaultInstance();

        /* renamed from: p */
        public C11687l f23868p = C11687l.getDefaultInstance();

        /* renamed from: q */
        public List<C11678c> f23869q = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11688m buildPartial() {
            C11688m c11688m = new C11688m(this, null);
            int i = this.f23865m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11688m.m9703h(c11688m, this.f23866n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11688m.m9704i(c11688m, this.f23867o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11688m.m9705j(c11688m, this.f23868p);
            if ((this.f23865m & 8) == 8) {
                this.f23869q = Collections.unmodifiableList(this.f23869q);
                this.f23865m &= -9;
            }
            C11688m.m9707l(c11688m, this.f23869q);
            C11688m.m9708m(c11688m, i2);
            return c11688m;
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

        public b mergePackage(C11687l c11687l) {
            if ((this.f23865m & 4) != 4 || this.f23868p == C11687l.getDefaultInstance()) {
                this.f23868p = c11687l;
            } else {
                this.f23868p = C11687l.newBuilder(this.f23868p).mergeFrom(c11687l).buildPartial();
            }
            this.f23865m |= 4;
            return this;
        }

        public b mergeQualifiedNames(C11690o c11690o) {
            if ((this.f23865m & 2) != 2 || this.f23867o == C11690o.getDefaultInstance()) {
                this.f23867o = c11690o;
            } else {
                this.f23867o = C11690o.newBuilder(this.f23867o).mergeFrom(c11690o).buildPartial();
            }
            this.f23865m |= 2;
            return this;
        }

        public b mergeStrings(C11691p c11691p) {
            if ((this.f23865m & 1) != 1 || this.f23866n == C11691p.getDefaultInstance()) {
                this.f23866n = c11691p;
            } else {
                this.f23866n = C11691p.newBuilder(this.f23866n).mergeFrom(c11691p).buildPartial();
            }
            this.f23865m |= 1;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11688m build() {
            C11688m c11688mBuildPartial = buildPartial();
            if (c11688mBuildPartial.isInitialized()) {
                return c11688mBuildPartial;
            }
            throw new UninitializedMessageException(c11688mBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11688m) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11688m c11688m) {
            if (c11688m == C11688m.getDefaultInstance()) {
                return this;
            }
            if (c11688m.hasStrings()) {
                mergeStrings(c11688m.getStrings());
            }
            if (c11688m.hasQualifiedNames()) {
                mergeQualifiedNames(c11688m.getQualifiedNames());
            }
            if (c11688m.hasPackage()) {
                mergePackage(c11688m.getPackage());
            }
            if (!C11688m.m9706k(c11688m).isEmpty()) {
                if (this.f23869q.isEmpty()) {
                    this.f23869q = C11688m.m9706k(c11688m);
                    this.f23865m &= -9;
                } else {
                    if ((this.f23865m & 8) != 8) {
                        this.f23869q = new ArrayList(this.f23869q);
                        this.f23865m |= 8;
                    }
                    this.f23869q.addAll(C11688m.m9706k(c11688m));
                }
            }
            m9846b(c11688m);
            setUnknownFields(getUnknownFields().concat(C11688m.m9709n(c11688m)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11688m c11688m = null;
            try {
                try {
                    C11688m partialFrom = C11688m.f23864k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11688m c11688m2 = (C11688m) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11688m = c11688m2;
                        if (c11688m != null) {
                            mergeFrom(c11688m);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11688m != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11688m c11688m = new C11688m();
        f23863j = c11688m;
        c11688m.m9710o();
    }

    public C11688m(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11688m getDefaultInstance() {
        return f23863j;
    }

    /* renamed from: h */
    public static /* synthetic */ C11691p m9703h(C11688m c11688m, C11691p c11691p) {
        c11688m.strings_ = c11691p;
        return c11691p;
    }

    /* renamed from: i */
    public static /* synthetic */ C11690o m9704i(C11688m c11688m, C11690o c11690o) {
        c11688m.qualifiedNames_ = c11690o;
        return c11690o;
    }

    /* renamed from: j */
    public static /* synthetic */ C11687l m9705j(C11688m c11688m, C11687l c11687l) {
        c11688m.package_ = c11687l;
        return c11687l;
    }

    /* renamed from: k */
    public static /* synthetic */ List m9706k(C11688m c11688m) {
        return c11688m.class__;
    }

    /* renamed from: l */
    public static /* synthetic */ List m9707l(C11688m c11688m, List list) {
        c11688m.class__ = list;
        return list;
    }

    /* renamed from: m */
    public static /* synthetic */ int m9708m(C11688m c11688m, int i) {
        c11688m.bitField0_ = i;
        return i;
    }

    /* renamed from: n */
    public static /* synthetic */ ByteString3 m9709n(C11688m c11688m) {
        return c11688m.unknownFields;
    }

    public static b newBuilder(C11688m c11688m) {
        return newBuilder().mergeFrom(c11688m);
    }

    public static C11688m parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (C11688m) ((AbstractParser) f23864k).m11467parseFrom(inputStream, extensionRegistryLite);
    }

    public C11678c getClass_(int i) {
        return this.class__.get(i);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<C11678c> getClass_List() {
        return this.class__;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public C11687l getPackage() {
        return this.package_;
    }

    public C11690o getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
        }
        for (int i2 = 0; i2 < this.class__.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
        }
        int size = this.unknownFields.size() + m9849c() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11691p getStrings() {
        return this.strings_;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasQualifiedNames() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStrings() {
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
        if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasPackage() && !getPackage().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getClass_Count(); i++) {
            if (!getClass_(i).isInitialized()) {
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

    /* renamed from: o */
    public final void m9710o() {
        this.strings_ = C11691p.getDefaultInstance();
        this.qualifiedNames_ = C11690o.getDefaultInstance();
        this.package_ = C11687l.getDefaultInstance();
        this.class__ = Collections.emptyList();
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
            codedOutputStream.writeMessage(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.package_);
        }
        for (int i = 0; i < this.class__.size(); i++) {
            codedOutputStream.writeMessage(4, this.class__.get(i));
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11688m getDefaultInstanceForType() {
        return f23863j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11688m() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11688m(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9710o();
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
                            if (tag == 10) {
                                C11691p.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                C11691p c11691p = (C11691p) codedInputStream.readMessage(C11691p.f23900k, extensionRegistryLite);
                                this.strings_ = c11691p;
                                if (builder != null) {
                                    builder.mergeFrom(c11691p);
                                    this.strings_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                C11690o.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                C11690o c11690o = (C11690o) codedInputStream.readMessage(C11690o.f23886k, extensionRegistryLite);
                                this.qualifiedNames_ = c11690o;
                                if (builder2 != null) {
                                    builder2.mergeFrom(c11690o);
                                    this.qualifiedNames_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                C11687l.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                C11687l c11687l = (C11687l) codedInputStream.readMessage(C11687l.f23856k, extensionRegistryLite);
                                this.package_ = c11687l;
                                if (builder3 != null) {
                                    builder3.mergeFrom(c11687l);
                                    this.package_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                if ((i & 8) != 8) {
                                    this.class__ = new ArrayList();
                                    i |= 8;
                                }
                                this.class__.add(codedInputStream.readMessage(C11678c.f23761k, extensionRegistryLite));
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
                if ((i & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
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
        if ((i & 8) == 8) {
            this.class__ = Collections.unmodifiableList(this.class__);
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
