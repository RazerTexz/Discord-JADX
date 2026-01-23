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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.o */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11690o extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11690o f23885j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11690o> f23886k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<c> qualifiedName_;
    private final ByteString3 unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11690o> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11690o parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11690o(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<C11690o, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: k */
        public int f23887k;

        /* JADX INFO: renamed from: l */
        public List<c> f23888l = Collections.emptyList();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11690o buildPartial() {
            C11690o c11690o = new C11690o(this, null);
            if ((this.f23887k & 1) == 1) {
                this.f23888l = Collections.unmodifiableList(this.f23888l);
                this.f23887k &= -2;
            }
            C11690o.m9729b(c11690o, this.f23888l);
            return c11690o;
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11690o build() {
            C11690o c11690oBuildPartial = buildPartial();
            if (c11690oBuildPartial.isInitialized()) {
                return c11690oBuildPartial;
            }
            throw new UninitializedMessageException(c11690oBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11690o) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11690o c11690o) {
            if (c11690o == C11690o.getDefaultInstance()) {
                return this;
            }
            if (!C11690o.m9728a(c11690o).isEmpty()) {
                if (this.f23888l.isEmpty()) {
                    this.f23888l = C11690o.m9728a(c11690o);
                    this.f23887k &= -2;
                } else {
                    if ((this.f23887k & 1) != 1) {
                        this.f23888l = new ArrayList(this.f23888l);
                        this.f23887k |= 1;
                    }
                    this.f23888l.addAll(C11690o.m9728a(c11690o));
                }
            }
            setUnknownFields(getUnknownFields().concat(C11690o.m9730c(c11690o)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11690o c11690o = null;
            try {
                try {
                    C11690o partialFrom = C11690o.f23886k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11690o c11690o2 = (C11690o) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11690o = c11690o2;
                        if (c11690o != null) {
                            mergeFrom(c11690o);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11690o != null) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: j */
        public static final c f23889j;

        /* JADX INFO: renamed from: k */
        public static Parser2<c> f23890k = new a();
        private int bitField0_;
        private EnumC13322c kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final ByteString3 unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$a */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractParser<c> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$b */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class b extends GeneratedMessageLite.b<c, b> implements MessageLiteOrBuilder {

            /* JADX INFO: renamed from: k */
            public int f23891k;

            /* JADX INFO: renamed from: m */
            public int f23893m;

            /* JADX INFO: renamed from: l */
            public int f23892l = -1;

            /* JADX INFO: renamed from: n */
            public EnumC13322c f23894n = EnumC13322c.PACKAGE;

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public c buildPartial() {
                c cVar = new c(this, null);
                int i = this.f23891k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c.m9735e(cVar, this.f23892l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c.m9731a(cVar, this.f23893m);
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                c.m9732b(cVar, this.f23894n);
                c.m9733c(cVar, i2);
                return cVar;
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

            public b setKind(EnumC13322c enumC13322c) {
                Objects.requireNonNull(enumC13322c);
                this.f23891k |= 4;
                this.f23894n = enumC13322c;
                return this;
            }

            public b setParentQualifiedName(int i) {
                this.f23891k |= 1;
                this.f23892l = i;
                return this;
            }

            public b setShortName(int i) {
                this.f23891k |= 2;
                this.f23893m = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public c build() {
                c cVarBuildPartial = buildPartial();
                if (cVarBuildPartial.isInitialized()) {
                    return cVarBuildPartial;
                }
                throw new UninitializedMessageException(cVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((c) generatedMessageLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public b clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeFrom(c cVar) {
                if (cVar == c.getDefaultInstance()) {
                    return this;
                }
                if (cVar.hasParentQualifiedName()) {
                    setParentQualifiedName(cVar.getParentQualifiedName());
                }
                if (cVar.hasShortName()) {
                    setShortName(cVar.getShortName());
                }
                if (cVar.hasKind()) {
                    setKind(cVar.getKind());
                }
                setUnknownFields(getUnknownFields().concat(c.m9734d(cVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c partialFrom = c.f23890k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        c cVar2 = (c) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                mergeFrom(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum EnumC13322c implements Internal.a {
            CLASS(0),
            PACKAGE(1),
            LOCAL(2);

            private final int value;

            EnumC13322c(int i) {
                this.value = i;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
            public final int getNumber() {
                return this.value;
            }

            public static EnumC13322c valueOf(int i) {
                if (i == 0) {
                    return CLASS;
                }
                if (i == 1) {
                    return PACKAGE;
                }
                if (i != 2) {
                    return null;
                }
                return LOCAL;
            }
        }

        static {
            c cVar = new c();
            f23889j = cVar;
            cVar.parentQualifiedName_ = -1;
            cVar.shortName_ = 0;
            cVar.kind_ = EnumC13322c.PACKAGE;
        }

        public c(GeneratedMessageLite.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ int m9731a(c cVar, int i) {
            cVar.shortName_ = i;
            return i;
        }

        /* JADX INFO: renamed from: b */
        public static /* synthetic */ EnumC13322c m9732b(c cVar, EnumC13322c enumC13322c) {
            cVar.kind_ = enumC13322c;
            return enumC13322c;
        }

        /* JADX INFO: renamed from: c */
        public static /* synthetic */ int m9733c(c cVar, int i) {
            cVar.bitField0_ = i;
            return i;
        }

        /* JADX INFO: renamed from: d */
        public static /* synthetic */ ByteString3 m9734d(c cVar) {
            return cVar.unknownFields;
        }

        /* JADX INFO: renamed from: e */
        public static /* synthetic */ int m9735e(c cVar, int i) {
            cVar.parentQualifiedName_ = i;
            return i;
        }

        public static c getDefaultInstance() {
            return f23889j;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().mergeFrom(cVar);
        }

        public EnumC13322c getKind() {
            return this.kind_;
        }

        public int getParentQualifiedName() {
            return this.parentQualifiedName_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getShortName() {
            return this.shortName_;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasParentQualifiedName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasShortName() {
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
            if (hasShortName()) {
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
                codedOutputStream.writeInt32(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.kind_.getNumber());
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

        public c() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.f24100j;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.parentQualifiedName_ = -1;
            boolean z2 = false;
            this.shortName_ = 0;
            this.kind_ = EnumC13322c.PACKAGE;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = codedInputStream.readInt32();
                                } else if (tag != 24) {
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    int i = codedInputStream.readEnum();
                                    EnumC13322c enumC13322cValueOf = EnumC13322c.valueOf(i);
                                    if (enumC13322cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = enumC13322cValueOf;
                                    }
                                }
                            }
                            z2 = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
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

    static {
        C11690o c11690o = new C11690o();
        f23885j = c11690o;
        c11690o.qualifiedName_ = Collections.emptyList();
    }

    public C11690o(GeneratedMessageLite.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ List m9728a(C11690o c11690o) {
        return c11690o.qualifiedName_;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m9729b(C11690o c11690o, List list) {
        c11690o.qualifiedName_ = list;
        return list;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ ByteString3 m9730c(C11690o c11690o) {
        return c11690o.unknownFields;
    }

    public static C11690o getDefaultInstance() {
        return f23885j;
    }

    public static b newBuilder(C11690o c11690o) {
        return newBuilder().mergeFrom(c11690o);
    }

    public c getQualifiedName(int i) {
        return this.qualifiedName_.get(i);
    }

    public int getQualifiedNameCount() {
        return this.qualifiedName_.size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.qualifiedName_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
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
        for (int i = 0; i < getQualifiedNameCount(); i++) {
            if (!getQualifiedName(i).isInitialized()) {
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
        for (int i = 0; i < this.qualifiedName_.size(); i++) {
            codedOutputStream.writeMessage(1, this.qualifiedName_.get(i));
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

    public C11690o() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11690o(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.qualifiedName_ = Collections.emptyList();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag != 10) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if (!(z3 & true)) {
                                this.qualifiedName_ = new ArrayList();
                                z3 |= true;
                            }
                            this.qualifiedName_.add(codedInputStream.readMessage(c.f23890k, extensionRegistryLite));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
