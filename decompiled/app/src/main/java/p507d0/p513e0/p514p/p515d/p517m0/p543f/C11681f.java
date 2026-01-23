package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11683h;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.f */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11681f extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11681f f23797j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11681f> f23798k = new a();
    private int bitField0_;
    private C11683h conclusionOfConditionalEffect_;
    private List<C11683h> effectConstructorArgument_;
    private c effectType_;
    private d kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString3 unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11681f> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11681f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11681f(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<C11681f, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: k */
        public int f23799k;

        /* JADX INFO: renamed from: l */
        public c f23800l = c.RETURNS_CONSTANT;

        /* JADX INFO: renamed from: m */
        public List<C11683h> f23801m = Collections.emptyList();

        /* JADX INFO: renamed from: n */
        public C11683h f23802n = C11683h.getDefaultInstance();

        /* JADX INFO: renamed from: o */
        public d f23803o = d.AT_MOST_ONCE;

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11681f buildPartial() {
            C11681f c11681f = new C11681f(this, null);
            int i = this.f23799k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11681f.m9651a(c11681f, this.f23800l);
            if ((this.f23799k & 2) == 2) {
                this.f23801m = Collections.unmodifiableList(this.f23801m);
                this.f23799k &= -3;
            }
            C11681f.m9653c(c11681f, this.f23801m);
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            C11681f.m9654d(c11681f, this.f23802n);
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            C11681f.m9655e(c11681f, this.f23803o);
            C11681f.m9656f(c11681f, i2);
            return c11681f;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        public b mergeConclusionOfConditionalEffect(C11683h c11683h) {
            if ((this.f23799k & 4) != 4 || this.f23802n == C11683h.getDefaultInstance()) {
                this.f23802n = c11683h;
            } else {
                this.f23802n = C11683h.newBuilder(this.f23802n).mergeFrom(c11683h).buildPartial();
            }
            this.f23799k |= 4;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b setEffectType(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23799k |= 1;
            this.f23800l = cVar;
            return this;
        }

        public b setKind(d dVar) {
            Objects.requireNonNull(dVar);
            this.f23799k |= 8;
            this.f23803o = dVar;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11681f build() {
            C11681f c11681fBuildPartial = buildPartial();
            if (c11681fBuildPartial.isInitialized()) {
                return c11681fBuildPartial;
            }
            throw new UninitializedMessageException(c11681fBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11681f) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11681f c11681f) {
            if (c11681f == C11681f.getDefaultInstance()) {
                return this;
            }
            if (c11681f.hasEffectType()) {
                setEffectType(c11681f.getEffectType());
            }
            if (!C11681f.m9652b(c11681f).isEmpty()) {
                if (this.f23801m.isEmpty()) {
                    this.f23801m = C11681f.m9652b(c11681f);
                    this.f23799k &= -3;
                } else {
                    if ((this.f23799k & 2) != 2) {
                        this.f23801m = new ArrayList(this.f23801m);
                        this.f23799k |= 2;
                    }
                    this.f23801m.addAll(C11681f.m9652b(c11681f));
                }
            }
            if (c11681f.hasConclusionOfConditionalEffect()) {
                mergeConclusionOfConditionalEffect(c11681f.getConclusionOfConditionalEffect());
            }
            if (c11681f.hasKind()) {
                setKind(c11681f.getKind());
            }
            setUnknownFields(getUnknownFields().concat(C11681f.m9657g(c11681f)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11681f c11681f = null;
            try {
                try {
                    C11681f partialFrom = C11681f.f23798k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11681f c11681f2 = (C11681f) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11681f = c11681f2;
                        if (c11681f != null) {
                            mergeFrom(c11681f);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11681f != null) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        RETURNS_CONSTANT(0),
        CALLS(1),
        RETURNS_NOT_NULL(2);

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
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$d */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements Internal.a {
        AT_MOST_ONCE(0),
        EXACTLY_ONCE(1),
        AT_LEAST_ONCE(2);

        private final int value;

        d(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
        public final int getNumber() {
            return this.value;
        }

        public static d valueOf(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    static {
        C11681f c11681f = new C11681f();
        f23797j = c11681f;
        c11681f.m9658h();
    }

    public C11681f(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ c m9651a(C11681f c11681f, c cVar) {
        c11681f.effectType_ = cVar;
        return cVar;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m9652b(C11681f c11681f) {
        return c11681f.effectConstructorArgument_;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ List m9653c(C11681f c11681f, List list) {
        c11681f.effectConstructorArgument_ = list;
        return list;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ C11683h m9654d(C11681f c11681f, C11683h c11683h) {
        c11681f.conclusionOfConditionalEffect_ = c11683h;
        return c11683h;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ d m9655e(C11681f c11681f, d dVar) {
        c11681f.kind_ = dVar;
        return dVar;
    }

    /* JADX INFO: renamed from: f */
    public static /* synthetic */ int m9656f(C11681f c11681f, int i) {
        c11681f.bitField0_ = i;
        return i;
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ ByteString3 m9657g(C11681f c11681f) {
        return c11681f.unknownFields;
    }

    public static C11681f getDefaultInstance() {
        return f23797j;
    }

    public static b newBuilder(C11681f c11681f) {
        return newBuilder().mergeFrom(c11681f);
    }

    public C11683h getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    public C11683h getEffectConstructorArgument(int i) {
        return this.effectConstructorArgument_.get(i);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public c getEffectType() {
        return this.effectType_;
    }

    public d getKind() {
        return this.kind_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0 : 0;
        for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        }
        int size = this.unknownFields.size() + iComputeEnumSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    /* JADX INFO: renamed from: h */
    public final void m9658h() {
        this.effectType_ = c.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = C11683h.getDefaultInstance();
        this.kind_ = d.AT_MOST_ONCE;
    }

    public boolean hasConclusionOfConditionalEffect() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasEffectType() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasKind() {
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
        for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
            if (!getEffectConstructorArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
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
            codedOutputStream.writeEnum(1, this.effectType_.getNumber());
        }
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.kind_.getNumber());
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

    public C11681f() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11681f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9658h();
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
                            int i2 = codedInputStream.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = cVarValueOf;
                            }
                        } else if (tag == 18) {
                            if ((i & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                i |= 2;
                            }
                            this.effectConstructorArgument_.add(codedInputStream.readMessage(C11683h.f23817k, extensionRegistryLite));
                        } else if (tag == 26) {
                            C11683h.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            C11683h c11683h = (C11683h) codedInputStream.readMessage(C11683h.f23817k, extensionRegistryLite);
                            this.conclusionOfConditionalEffect_ = c11683h;
                            if (builder != null) {
                                builder.mergeFrom(c11683h);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (tag != 32) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            int i3 = codedInputStream.readEnum();
                            d dVarValueOf = d.valueOf(i3);
                            if (dVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i3);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = dVarValueOf;
                            }
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 2) == 2) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
