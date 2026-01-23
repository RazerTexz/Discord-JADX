package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.r */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11693r extends GeneratedMessageLite.d<C11693r> implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11693r f23931j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11693r> f23932k = new a();
    private List<C11677b> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private C11692q expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<C11694s> typeParameter_;
    private int underlyingTypeId_;
    private C11692q underlyingType_;
    private final ByteString3 unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.r$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11693r> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11693r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11693r(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.r$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<C11693r, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: m */
        public int f23933m;

        /* JADX INFO: renamed from: o */
        public int f23935o;

        /* JADX INFO: renamed from: r */
        public int f23938r;

        /* JADX INFO: renamed from: t */
        public int f23940t;

        /* JADX INFO: renamed from: n */
        public int f23934n = 6;

        /* JADX INFO: renamed from: p */
        public List<C11694s> f23936p = Collections.emptyList();

        /* JADX INFO: renamed from: q */
        public C11692q f23937q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: s */
        public C11692q f23939s = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: u */
        public List<C11677b> f23941u = Collections.emptyList();

        /* JADX INFO: renamed from: v */
        public List<Integer> f23942v = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11693r buildPartial() {
            C11693r c11693r = new C11693r(this, null);
            int i = this.f23933m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11693r.m9762h(c11693r, this.f23934n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11693r.m9763i(c11693r, this.f23935o);
            if ((this.f23933m & 4) == 4) {
                this.f23936p = Collections.unmodifiableList(this.f23936p);
                this.f23933m &= -5;
            }
            C11693r.m9765k(c11693r, this.f23936p);
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            C11693r.m9766l(c11693r, this.f23937q);
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            C11693r.m9767m(c11693r, this.f23938r);
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            C11693r.m9768n(c11693r, this.f23939s);
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            C11693r.m9769o(c11693r, this.f23940t);
            if ((this.f23933m & 128) == 128) {
                this.f23941u = Collections.unmodifiableList(this.f23941u);
                this.f23933m &= -129;
            }
            C11693r.m9771q(c11693r, this.f23941u);
            if ((this.f23933m & 256) == 256) {
                this.f23942v = Collections.unmodifiableList(this.f23942v);
                this.f23933m &= -257;
            }
            C11693r.m9773s(c11693r, this.f23942v);
            C11693r.m9774t(c11693r, i2);
            return c11693r;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        public b mergeExpandedType(C11692q c11692q) {
            if ((this.f23933m & 32) != 32 || this.f23939s == C11692q.getDefaultInstance()) {
                this.f23939s = c11692q;
            } else {
                this.f23939s = C11692q.newBuilder(this.f23939s).mergeFrom(c11692q).buildPartial();
            }
            this.f23933m |= 32;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeUnderlyingType(C11692q c11692q) {
            if ((this.f23933m & 8) != 8 || this.f23937q == C11692q.getDefaultInstance()) {
                this.f23937q = c11692q;
            } else {
                this.f23937q = C11692q.newBuilder(this.f23937q).mergeFrom(c11692q).buildPartial();
            }
            this.f23933m |= 8;
            return this;
        }

        public b setExpandedTypeId(int i) {
            this.f23933m |= 64;
            this.f23940t = i;
            return this;
        }

        public b setFlags(int i) {
            this.f23933m |= 1;
            this.f23934n = i;
            return this;
        }

        public b setName(int i) {
            this.f23933m |= 2;
            this.f23935o = i;
            return this;
        }

        public b setUnderlyingTypeId(int i) {
            this.f23933m |= 16;
            this.f23938r = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11693r build() {
            C11693r c11693rBuildPartial = buildPartial();
            if (c11693rBuildPartial.isInitialized()) {
                return c11693rBuildPartial;
            }
            throw new UninitializedMessageException(c11693rBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11693r) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11693r c11693r) {
            if (c11693r == C11693r.getDefaultInstance()) {
                return this;
            }
            if (c11693r.hasFlags()) {
                setFlags(c11693r.getFlags());
            }
            if (c11693r.hasName()) {
                setName(c11693r.getName());
            }
            if (!C11693r.m9764j(c11693r).isEmpty()) {
                if (this.f23936p.isEmpty()) {
                    this.f23936p = C11693r.m9764j(c11693r);
                    this.f23933m &= -5;
                } else {
                    if ((this.f23933m & 4) != 4) {
                        this.f23936p = new ArrayList(this.f23936p);
                        this.f23933m |= 4;
                    }
                    this.f23936p.addAll(C11693r.m9764j(c11693r));
                }
            }
            if (c11693r.hasUnderlyingType()) {
                mergeUnderlyingType(c11693r.getUnderlyingType());
            }
            if (c11693r.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(c11693r.getUnderlyingTypeId());
            }
            if (c11693r.hasExpandedType()) {
                mergeExpandedType(c11693r.getExpandedType());
            }
            if (c11693r.hasExpandedTypeId()) {
                setExpandedTypeId(c11693r.getExpandedTypeId());
            }
            if (!C11693r.m9770p(c11693r).isEmpty()) {
                if (this.f23941u.isEmpty()) {
                    this.f23941u = C11693r.m9770p(c11693r);
                    this.f23933m &= -129;
                } else {
                    if ((this.f23933m & 128) != 128) {
                        this.f23941u = new ArrayList(this.f23941u);
                        this.f23933m |= 128;
                    }
                    this.f23941u.addAll(C11693r.m9770p(c11693r));
                }
            }
            if (!C11693r.m9772r(c11693r).isEmpty()) {
                if (this.f23942v.isEmpty()) {
                    this.f23942v = C11693r.m9772r(c11693r);
                    this.f23933m &= -257;
                } else {
                    if ((this.f23933m & 256) != 256) {
                        this.f23942v = new ArrayList(this.f23942v);
                        this.f23933m |= 256;
                    }
                    this.f23942v.addAll(C11693r.m9772r(c11693r));
                }
            }
            m9846b(c11693r);
            setUnknownFields(getUnknownFields().concat(C11693r.m9775u(c11693r)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11693r c11693r = null;
            try {
                try {
                    C11693r partialFrom = C11693r.f23932k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11693r c11693r2 = (C11693r) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11693r = c11693r2;
                        if (c11693r != null) {
                            mergeFrom(c11693r);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11693r != null) {
                }
                throw th;
            }
        }
    }

    static {
        C11693r c11693r = new C11693r();
        f23931j = c11693r;
        c11693r.m9776v();
    }

    public C11693r(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11693r getDefaultInstance() {
        return f23931j;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ int m9762h(C11693r c11693r, int i) {
        c11693r.flags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ int m9763i(C11693r c11693r, int i) {
        c11693r.name_ = i;
        return i;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ List m9764j(C11693r c11693r) {
        return c11693r.typeParameter_;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ List m9765k(C11693r c11693r, List list) {
        c11693r.typeParameter_ = list;
        return list;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ C11692q m9766l(C11693r c11693r, C11692q c11692q) {
        c11693r.underlyingType_ = c11692q;
        return c11692q;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ int m9767m(C11693r c11693r, int i) {
        c11693r.underlyingTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ C11692q m9768n(C11693r c11693r, C11692q c11692q) {
        c11693r.expandedType_ = c11692q;
        return c11692q;
    }

    public static b newBuilder(C11693r c11693r) {
        return newBuilder().mergeFrom(c11693r);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ int m9769o(C11693r c11693r, int i) {
        c11693r.expandedTypeId_ = i;
        return i;
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ List m9770p(C11693r c11693r) {
        return c11693r.annotation_;
    }

    public static C11693r parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (C11693r) ((AbstractParser) f23932k).m11466parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ List m9771q(C11693r c11693r, List list) {
        c11693r.annotation_ = list;
        return list;
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ List m9772r(C11693r c11693r) {
        return c11693r.versionRequirement_;
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ List m9773s(C11693r c11693r, List list) {
        c11693r.versionRequirement_ = list;
        return list;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ int m9774t(C11693r c11693r, int i) {
        c11693r.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ ByteString3 m9775u(C11693r c11693r) {
        return c11693r.unknownFields;
    }

    public C11677b getAnnotation(int i) {
        return this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<C11677b> getAnnotationList() {
        return this.annotation_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public C11692q getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
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
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = this.unknownFields.size() + m9849c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
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

    public C11692q getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasUnderlyingTypeId() {
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
            if (!getAnnotation(i2).isInitialized()) {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    /* JADX INFO: renamed from: v */
    public final void m9776v() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = C11692q.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = C11692q.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
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
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.writeMessage(8, this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11693r getDefaultInstanceForType() {
        return f23931j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11693r() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    public C11693r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        C11692q.c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9776v();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (true) {
            ?? M9852f = 4;
            if (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        switch (tag) {
                            case 0:
                                z2 = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
                                break;
                            case 26:
                                if ((i & 4) != 4) {
                                    this.typeParameter_ = new ArrayList();
                                    i |= 4;
                                }
                                this.typeParameter_.add(codedInputStream.readMessage(C11694s.f23944k, extensionRegistryLite));
                                break;
                            case 34:
                                builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                C11692q c11692q = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                this.underlyingType_ = c11692q;
                                if (builder != null) {
                                    builder.mergeFrom(c11692q);
                                    this.underlyingType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                                break;
                            case 40:
                                this.bitField0_ |= 8;
                                this.underlyingTypeId_ = codedInputStream.readInt32();
                                break;
                            case 50:
                                builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                C11692q c11692q2 = (C11692q) codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite);
                                this.expandedType_ = c11692q2;
                                if (builder != null) {
                                    builder.mergeFrom(c11692q2);
                                    this.expandedType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                                break;
                            case 56:
                                this.bitField0_ |= 32;
                                this.expandedTypeId_ = codedInputStream.readInt32();
                                break;
                            case 66:
                                if ((i & 128) != 128) {
                                    this.annotation_ = new ArrayList();
                                    i |= 128;
                                }
                                this.annotation_.add(codedInputStream.readMessage(C11677b.f23723k, extensionRegistryLite));
                                break;
                            case 248:
                                if ((i & 256) != 256) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 256;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                break;
                            case 250:
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 256) != 256 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 256;
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
                        if ((i & 4) == M9852f) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i & 128) == 128) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i & 256) == 256) {
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
                if ((i & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((i & 256) == 256) {
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
