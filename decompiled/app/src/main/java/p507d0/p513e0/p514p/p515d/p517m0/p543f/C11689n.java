package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ByteString3;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.CodedInputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.n */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11689n extends GeneratedMessageLite.d<C11689n> implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11689n f23870j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11689n> f23871k = new a();
    private int bitField0_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private C11692q receiverType_;
    private int returnTypeId_;
    private C11692q returnType_;
    private int setterFlags_;
    private C11696u setterValueParameter_;
    private List<C11694s> typeParameter_;
    private final ByteString3 unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.n$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11689n> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11689n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11689n(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.n$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<C11689n, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: m */
        public int f23872m;

        /* JADX INFO: renamed from: p */
        public int f23875p;

        /* JADX INFO: renamed from: r */
        public int f23877r;

        /* JADX INFO: renamed from: u */
        public int f23880u;

        /* JADX INFO: renamed from: w */
        public int f23882w;

        /* JADX INFO: renamed from: x */
        public int f23883x;

        /* JADX INFO: renamed from: n */
        public int f23873n = 518;

        /* JADX INFO: renamed from: o */
        public int f23874o = 2054;

        /* JADX INFO: renamed from: q */
        public C11692q f23876q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: s */
        public List<C11694s> f23878s = Collections.emptyList();

        /* JADX INFO: renamed from: t */
        public C11692q f23879t = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: v */
        public C11696u f23881v = C11696u.getDefaultInstance();

        /* JADX INFO: renamed from: y */
        public List<Integer> f23884y = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11689n buildPartial() {
            C11689n c11689n = new C11689n(this, null);
            int i = this.f23872m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11689n.m9711h(c11689n, this.f23873n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11689n.m9712i(c11689n, this.f23874o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11689n.m9713j(c11689n, this.f23875p);
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            C11689n.m9714k(c11689n, this.f23876q);
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            C11689n.m9715l(c11689n, this.f23877r);
            if ((this.f23872m & 32) == 32) {
                this.f23878s = Collections.unmodifiableList(this.f23878s);
                this.f23872m &= -33;
            }
            C11689n.m9717n(c11689n, this.f23878s);
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            C11689n.m9718o(c11689n, this.f23879t);
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            C11689n.m9719p(c11689n, this.f23880u);
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            C11689n.m9720q(c11689n, this.f23881v);
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            C11689n.m9721r(c11689n, this.f23882w);
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            C11689n.m9722s(c11689n, this.f23883x);
            if ((this.f23872m & 2048) == 2048) {
                this.f23884y = Collections.unmodifiableList(this.f23884y);
                this.f23872m &= -2049;
            }
            C11689n.m9724u(c11689n, this.f23884y);
            C11689n.m9725v(c11689n, i2);
            return c11689n;
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

        public b mergeReceiverType(C11692q c11692q) {
            if ((this.f23872m & 64) != 64 || this.f23879t == C11692q.getDefaultInstance()) {
                this.f23879t = c11692q;
            } else {
                this.f23879t = C11692q.newBuilder(this.f23879t).mergeFrom(c11692q).buildPartial();
            }
            this.f23872m |= 64;
            return this;
        }

        public b mergeReturnType(C11692q c11692q) {
            if ((this.f23872m & 8) != 8 || this.f23876q == C11692q.getDefaultInstance()) {
                this.f23876q = c11692q;
            } else {
                this.f23876q = C11692q.newBuilder(this.f23876q).mergeFrom(c11692q).buildPartial();
            }
            this.f23872m |= 8;
            return this;
        }

        public b mergeSetterValueParameter(C11696u c11696u) {
            if ((this.f23872m & 256) != 256 || this.f23881v == C11696u.getDefaultInstance()) {
                this.f23881v = c11696u;
            } else {
                this.f23881v = C11696u.newBuilder(this.f23881v).mergeFrom(c11696u).buildPartial();
            }
            this.f23872m |= 256;
            return this;
        }

        public b setFlags(int i) {
            this.f23872m |= 1;
            this.f23873n = i;
            return this;
        }

        public b setGetterFlags(int i) {
            this.f23872m |= 512;
            this.f23882w = i;
            return this;
        }

        public b setName(int i) {
            this.f23872m |= 4;
            this.f23875p = i;
            return this;
        }

        public b setOldFlags(int i) {
            this.f23872m |= 2;
            this.f23874o = i;
            return this;
        }

        public b setReceiverTypeId(int i) {
            this.f23872m |= 128;
            this.f23880u = i;
            return this;
        }

        public b setReturnTypeId(int i) {
            this.f23872m |= 16;
            this.f23877r = i;
            return this;
        }

        public b setSetterFlags(int i) {
            this.f23872m |= 1024;
            this.f23883x = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11689n build() {
            C11689n c11689nBuildPartial = buildPartial();
            if (c11689nBuildPartial.isInitialized()) {
                return c11689nBuildPartial;
            }
            throw new UninitializedMessageException(c11689nBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11689n) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11689n c11689n) {
            if (c11689n == C11689n.getDefaultInstance()) {
                return this;
            }
            if (c11689n.hasFlags()) {
                setFlags(c11689n.getFlags());
            }
            if (c11689n.hasOldFlags()) {
                setOldFlags(c11689n.getOldFlags());
            }
            if (c11689n.hasName()) {
                setName(c11689n.getName());
            }
            if (c11689n.hasReturnType()) {
                mergeReturnType(c11689n.getReturnType());
            }
            if (c11689n.hasReturnTypeId()) {
                setReturnTypeId(c11689n.getReturnTypeId());
            }
            if (!C11689n.m9716m(c11689n).isEmpty()) {
                if (this.f23878s.isEmpty()) {
                    this.f23878s = C11689n.m9716m(c11689n);
                    this.f23872m &= -33;
                } else {
                    if ((this.f23872m & 32) != 32) {
                        this.f23878s = new ArrayList(this.f23878s);
                        this.f23872m |= 32;
                    }
                    this.f23878s.addAll(C11689n.m9716m(c11689n));
                }
            }
            if (c11689n.hasReceiverType()) {
                mergeReceiverType(c11689n.getReceiverType());
            }
            if (c11689n.hasReceiverTypeId()) {
                setReceiverTypeId(c11689n.getReceiverTypeId());
            }
            if (c11689n.hasSetterValueParameter()) {
                mergeSetterValueParameter(c11689n.getSetterValueParameter());
            }
            if (c11689n.hasGetterFlags()) {
                setGetterFlags(c11689n.getGetterFlags());
            }
            if (c11689n.hasSetterFlags()) {
                setSetterFlags(c11689n.getSetterFlags());
            }
            if (!C11689n.m9723t(c11689n).isEmpty()) {
                if (this.f23884y.isEmpty()) {
                    this.f23884y = C11689n.m9723t(c11689n);
                    this.f23872m &= -2049;
                } else {
                    if ((this.f23872m & 2048) != 2048) {
                        this.f23884y = new ArrayList(this.f23884y);
                        this.f23872m |= 2048;
                    }
                    this.f23884y.addAll(C11689n.m9723t(c11689n));
                }
            }
            m9846b(c11689n);
            setUnknownFields(getUnknownFields().concat(C11689n.m9726w(c11689n)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11689n c11689n = null;
            try {
                try {
                    C11689n partialFrom = C11689n.f23871k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11689n c11689n2 = (C11689n) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11689n = c11689n2;
                        if (c11689n != null) {
                            mergeFrom(c11689n);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11689n != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11689n c11689n = new C11689n();
        f23870j = c11689n;
        c11689n.m9727x();
    }

    public C11689n(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11689n getDefaultInstance() {
        return f23870j;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ int m9711h(C11689n c11689n, int i) {
        c11689n.flags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ int m9712i(C11689n c11689n, int i) {
        c11689n.oldFlags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ int m9713j(C11689n c11689n, int i) {
        c11689n.name_ = i;
        return i;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ C11692q m9714k(C11689n c11689n, C11692q c11692q) {
        c11689n.returnType_ = c11692q;
        return c11692q;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ int m9715l(C11689n c11689n, int i) {
        c11689n.returnTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ List m9716m(C11689n c11689n) {
        return c11689n.typeParameter_;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ List m9717n(C11689n c11689n, List list) {
        c11689n.typeParameter_ = list;
        return list;
    }

    public static b newBuilder(C11689n c11689n) {
        return newBuilder().mergeFrom(c11689n);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ C11692q m9718o(C11689n c11689n, C11692q c11692q) {
        c11689n.receiverType_ = c11692q;
        return c11692q;
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ int m9719p(C11689n c11689n, int i) {
        c11689n.receiverTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ C11696u m9720q(C11689n c11689n, C11696u c11696u) {
        c11689n.setterValueParameter_ = c11696u;
        return c11696u;
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ int m9721r(C11689n c11689n, int i) {
        c11689n.getterFlags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ int m9722s(C11689n c11689n, int i) {
        c11689n.setterFlags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ List m9723t(C11689n c11689n) {
        return c11689n.versionRequirement_;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ List m9724u(C11689n c11689n, List list) {
        c11689n.versionRequirement_ = list;
        return list;
    }

    /* JADX INFO: renamed from: v */
    public static /* synthetic */ int m9725v(C11689n c11689n, int i) {
        c11689n.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ ByteString3 m9726w(C11689n c11689n) {
        return c11689n.unknownFields;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    public C11692q getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public C11692q getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0 : 0;
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3).intValue());
        }
        int size = this.unknownFields.size() + m9849c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public C11696u getSetterValueParameter() {
        return this.setterValueParameter_;
    }

    public C11694s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<C11694s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSetterValueParameter() {
        return (this.bitField0_ & 128) == 128;
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
        if (hasReturnType() && !getReturnType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasReceiverType() && !getReceiverType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
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
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
        }
        aVarM9851e.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* JADX INFO: renamed from: x */
    public final void m9727x() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = C11692q.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = C11692q.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.setterValueParameter_ = C11696u.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11689n getDefaultInstanceForType() {
        return f23870j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11689n() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    public C11689n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9727x();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (true) {
            ?? M9852f = 32;
            if (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        switch (tag) {
                            case 0:
                                z2 = true;
                                break;
                            case 8:
                                this.bitField0_ |= 2;
                                this.oldFlags_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 4;
                                this.name_ = codedInputStream.readInt32();
                                break;
                            case 26:
                                C11692q.c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                C11692q c11692q = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                this.returnType_ = c11692q;
                                if (builder != null) {
                                    builder.mergeFrom(c11692q);
                                    this.returnType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                                break;
                            case 34:
                                if ((i & 32) != 32) {
                                    this.typeParameter_ = new ArrayList();
                                    i |= 32;
                                }
                                this.typeParameter_.add(codedInputStream.readMessage(C11694s.f23944k, extensionRegistryLite));
                                break;
                            case 42:
                                C11692q.c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                C11692q c11692q2 = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                this.receiverType_ = c11692q2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(c11692q2);
                                    this.receiverType_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 32;
                                break;
                            case 50:
                                C11696u.b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                C11696u c11696u = (C11696u) codedInputStream.readMessage(C11696u.f23962k, extensionRegistryLite);
                                this.setterValueParameter_ = c11696u;
                                if (builder3 != null) {
                                    builder3.mergeFrom(c11696u);
                                    this.setterValueParameter_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 128;
                                break;
                            case 56:
                                this.bitField0_ |= 256;
                                this.getterFlags_ = codedInputStream.readInt32();
                                break;
                            case 64:
                                this.bitField0_ |= 512;
                                this.setterFlags_ = codedInputStream.readInt32();
                                break;
                            case 72:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = codedInputStream.readInt32();
                                break;
                            case 80:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = codedInputStream.readInt32();
                                break;
                            case 88:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                                break;
                            case 248:
                                if ((i & 2048) != 2048) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 2048;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                break;
                            case 250:
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 2048) != 2048 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 2048;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(iPushLimit);
                                break;
                            default:
                                M9852f = m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag);
                                if (M9852f == 0) {
                                    z2 = true;
                                }
                                break;
                        }
                    } catch (Throwable th) {
                        if ((i & 32) == M9852f) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i & 2048) == 2048) {
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
                        m9850d();
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } else {
                if ((i & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 2048) == 2048) {
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
                m9850d();
                return;
            }
        }
    }
}
