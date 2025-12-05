package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
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
import p507d0.p513e0.p514p.p515d.p517m0.p550i.WireFormat;

/* compiled from: JvmProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.a0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmProtoBuf {

    /* renamed from: a */
    public static final GeneratedMessageLite.f<C11679d, c> f23651a;

    /* renamed from: b */
    public static final GeneratedMessageLite.f<C11684i, c> f23652b;

    /* renamed from: c */
    public static final GeneratedMessageLite.f<C11684i, Integer> f23653c;

    /* renamed from: d */
    public static final GeneratedMessageLite.f<C11689n, d> f23654d;

    /* renamed from: e */
    public static final GeneratedMessageLite.f<C11689n, Integer> f23655e;

    /* renamed from: f */
    public static final GeneratedMessageLite.f<C11692q, List<C11677b>> f23656f;

    /* renamed from: g */
    public static final GeneratedMessageLite.f<C11692q, Boolean> f23657g;

    /* renamed from: h */
    public static final GeneratedMessageLite.f<C11694s, List<C11677b>> f23658h;

    /* renamed from: i */
    public static final GeneratedMessageLite.f<C11678c, Integer> f23659i;

    /* renamed from: j */
    public static final GeneratedMessageLite.f<C11678c, List<C11689n>> f23660j;

    /* renamed from: k */
    public static final GeneratedMessageLite.f<C11678c, Integer> f23661k;

    /* renamed from: l */
    public static final GeneratedMessageLite.f<C11678c, Integer> f23662l;

    /* renamed from: m */
    public static final GeneratedMessageLite.f<C11687l, Integer> f23663m;

    /* renamed from: n */
    public static final GeneratedMessageLite.f<C11687l, List<C11689n>> f23664n;

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$b */
    public static final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* renamed from: j */
        public static final b f23665j;

        /* renamed from: k */
        public static Parser2<b> f23666k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$b$a */
        public static class a extends AbstractParser<b> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new b(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$b$b, reason: collision with other inner class name */
        public static final class C13317b extends GeneratedMessageLite.b<b, C13317b> implements MessageLiteOrBuilder {

            /* renamed from: k */
            public int f23667k;

            /* renamed from: l */
            public int f23668l;

            /* renamed from: m */
            public int f23669m;

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23667k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                b.m9551a(bVar, this.f23668l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                b.m9552b(bVar, this.f23669m);
                b.m9553c(bVar, i2);
                return bVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            /* renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C13317b setDesc(int i) {
                this.f23667k |= 2;
                this.f23669m = i;
                return this;
            }

            public C13317b setName(int i) {
                this.f23667k |= 1;
                this.f23668l = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((b) generatedMessageLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public C13317b clone() {
                return new C13317b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C13317b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasName()) {
                    setName(bVar.getName());
                }
                if (bVar.hasDesc()) {
                    setDesc(bVar.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(b.m9554d(bVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C13317b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23666k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        b bVar2 = (b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                mergeFrom(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            b bVar = new b();
            f23665j = bVar;
            bVar.name_ = 0;
            bVar.desc_ = 0;
        }

        public b(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* renamed from: a */
        public static /* synthetic */ int m9551a(b bVar, int i) {
            bVar.name_ = i;
            return i;
        }

        /* renamed from: b */
        public static /* synthetic */ int m9552b(b bVar, int i) {
            bVar.desc_ = i;
            return i;
        }

        /* renamed from: c */
        public static /* synthetic */ int m9553c(b bVar, int i) {
            bVar.bitField0_ = i;
            return i;
        }

        /* renamed from: d */
        public static /* synthetic */ ByteString3 m9554d(b bVar) {
            return bVar.unknownFields;
        }

        public static b getDefaultInstance() {
            return f23665j;
        }

        public static C13317b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public int getDesc() {
            return this.desc_;
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
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C13317b newBuilder() {
            return new C13317b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13317b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public C13317b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.f24100j;
        }

        public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$c */
    public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* renamed from: j */
        public static final c f23670j;

        /* renamed from: k */
        public static Parser2<c> f23671k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$c$a */
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

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$c$b */
        public static final class b extends GeneratedMessageLite.b<c, b> implements MessageLiteOrBuilder {

            /* renamed from: k */
            public int f23672k;

            /* renamed from: l */
            public int f23673l;

            /* renamed from: m */
            public int f23674m;

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public c buildPartial() {
                c cVar = new c(this, null);
                int i = this.f23672k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c.m9555a(cVar, this.f23673l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c.m9556b(cVar, this.f23674m);
                c.m9557c(cVar, i2);
                return cVar;
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

            public b setDesc(int i) {
                this.f23672k |= 2;
                this.f23674m = i;
                return this;
            }

            public b setName(int i) {
                this.f23672k |= 1;
                this.f23673l = i;
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
                if (cVar.hasName()) {
                    setName(cVar.getName());
                }
                if (cVar.hasDesc()) {
                    setDesc(cVar.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(c.m9558d(cVar)));
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
                        c partialFrom = c.f23671k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

        static {
            c cVar = new c();
            f23670j = cVar;
            cVar.name_ = 0;
            cVar.desc_ = 0;
        }

        public c(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* renamed from: a */
        public static /* synthetic */ int m9555a(c cVar, int i) {
            cVar.name_ = i;
            return i;
        }

        /* renamed from: b */
        public static /* synthetic */ int m9556b(c cVar, int i) {
            cVar.desc_ = i;
            return i;
        }

        /* renamed from: c */
        public static /* synthetic */ int m9557c(c cVar, int i) {
            cVar.bitField0_ = i;
            return i;
        }

        /* renamed from: d */
        public static /* synthetic */ ByteString3 m9558d(c cVar) {
            return cVar.unknownFields;
        }

        public static c getDefaultInstance() {
            return f23670j;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().mergeFrom(cVar);
        }

        public int getDesc() {
            return this.desc_;
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
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
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

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$d */
    public static final class d extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* renamed from: j */
        public static final d f23675j;

        /* renamed from: k */
        public static Parser2<d> f23676k = new a();
        private int bitField0_;
        private b field_;
        private c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c setter_;
        private c syntheticMethod_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$d$a */
        public static class a extends AbstractParser<d> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public d parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new d(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$d$b */
        public static final class b extends GeneratedMessageLite.b<d, b> implements MessageLiteOrBuilder {

            /* renamed from: k */
            public int f23677k;

            /* renamed from: l */
            public b f23678l = b.getDefaultInstance();

            /* renamed from: m */
            public c f23679m = c.getDefaultInstance();

            /* renamed from: n */
            public c f23680n = c.getDefaultInstance();

            /* renamed from: o */
            public c f23681o = c.getDefaultInstance();

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public d buildPartial() {
                d dVar = new d(this, null);
                int i = this.f23677k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                d.m9559a(dVar, this.f23678l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                d.m9560b(dVar, this.f23679m);
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                d.m9561c(dVar, this.f23680n);
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                d.m9562d(dVar, this.f23681o);
                d.m9563e(dVar, i2);
                return dVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            /* renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
                return clone();
            }

            public b mergeField(b bVar) {
                if ((this.f23677k & 1) != 1 || this.f23678l == b.getDefaultInstance()) {
                    this.f23678l = bVar;
                } else {
                    this.f23678l = b.newBuilder(this.f23678l).mergeFrom(bVar).buildPartial();
                }
                this.f23677k |= 1;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeGetter(c cVar) {
                if ((this.f23677k & 4) != 4 || this.f23680n == c.getDefaultInstance()) {
                    this.f23680n = cVar;
                } else {
                    this.f23680n = c.newBuilder(this.f23680n).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 4;
                return this;
            }

            public b mergeSetter(c cVar) {
                if ((this.f23677k & 8) != 8 || this.f23681o == c.getDefaultInstance()) {
                    this.f23681o = cVar;
                } else {
                    this.f23681o = c.newBuilder(this.f23681o).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 8;
                return this;
            }

            public b mergeSyntheticMethod(c cVar) {
                if ((this.f23677k & 2) != 2 || this.f23679m == c.getDefaultInstance()) {
                    this.f23679m = cVar;
                } else {
                    this.f23679m = c.newBuilder(this.f23679m).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 2;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public d build() {
                d dVarBuildPartial = buildPartial();
                if (dVarBuildPartial.isInitialized()) {
                    return dVarBuildPartial;
                }
                throw new UninitializedMessageException(dVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((d) generatedMessageLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public b clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeFrom(d dVar) {
                if (dVar == d.getDefaultInstance()) {
                    return this;
                }
                if (dVar.hasField()) {
                    mergeField(dVar.getField());
                }
                if (dVar.hasSyntheticMethod()) {
                    mergeSyntheticMethod(dVar.getSyntheticMethod());
                }
                if (dVar.hasGetter()) {
                    mergeGetter(dVar.getGetter());
                }
                if (dVar.hasSetter()) {
                    mergeSetter(dVar.getSetter());
                }
                setUnknownFields(getUnknownFields().concat(d.m9564f(dVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d partialFrom = d.f23676k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        d dVar2 = (d) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            dVar = dVar2;
                            if (dVar != null) {
                                mergeFrom(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dVar != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            d dVar = new d();
            f23675j = dVar;
            dVar.m9565g();
        }

        public d(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* renamed from: a */
        public static /* synthetic */ b m9559a(d dVar, b bVar) {
            dVar.field_ = bVar;
            return bVar;
        }

        /* renamed from: b */
        public static /* synthetic */ c m9560b(d dVar, c cVar) {
            dVar.syntheticMethod_ = cVar;
            return cVar;
        }

        /* renamed from: c */
        public static /* synthetic */ c m9561c(d dVar, c cVar) {
            dVar.getter_ = cVar;
            return cVar;
        }

        /* renamed from: d */
        public static /* synthetic */ c m9562d(d dVar, c cVar) {
            dVar.setter_ = cVar;
            return cVar;
        }

        /* renamed from: e */
        public static /* synthetic */ int m9563e(d dVar, int i) {
            dVar.bitField0_ = i;
            return i;
        }

        /* renamed from: f */
        public static /* synthetic */ ByteString3 m9564f(d dVar) {
            return dVar.unknownFields;
        }

        public static d getDefaultInstance() {
            return f23675j;
        }

        public static b newBuilder(d dVar) {
            return newBuilder().mergeFrom(dVar);
        }

        /* renamed from: g */
        public final void m9565g() {
            this.field_ = b.getDefaultInstance();
            this.syntheticMethod_ = c.getDefaultInstance();
            this.getter_ = c.getDefaultInstance();
            this.setter_ = c.getDefaultInstance();
        }

        public b getField() {
            return this.field_;
        }

        public c getGetter() {
            return this.getter_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            int size = this.unknownFields.size() + iComputeMessageSize;
            this.memoizedSerializedSize = size;
            return size;
        }

        public c getSetter() {
            return this.setter_;
        }

        public c getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
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

        public d() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.f24100j;
        }

        public d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m9565g();
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                b.C13317b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                b bVar = (b) codedInputStream.readMessage(b.f23666k, extensionRegistryLite);
                                this.field_ = bVar;
                                if (builder != null) {
                                    builder.mergeFrom(bVar);
                                    this.field_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                c.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                c cVar = (c) codedInputStream.readMessage(c.f23671k, extensionRegistryLite);
                                this.syntheticMethod_ = cVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(cVar);
                                    this.syntheticMethod_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                c.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                c cVar2 = (c) codedInputStream.readMessage(c.f23671k, extensionRegistryLite);
                                this.getter_ = cVar2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(cVar2);
                                    this.getter_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                c cVar3 = (c) codedInputStream.readMessage(c.f23671k, extensionRegistryLite);
                                this.setter_ = cVar3;
                                if (builder4 != null) {
                                    builder4.mergeFrom(cVar3);
                                    this.setter_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$e */
    public static final class e extends GeneratedMessageLite implements MessageLiteOrBuilder {

        /* renamed from: j */
        public static final e f23682j;

        /* renamed from: k */
        public static Parser2<e> f23683k = new a();
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> record_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$a */
        public static class a extends AbstractParser<e> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
            public e parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new e(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$b */
        public static final class b extends GeneratedMessageLite.b<e, b> implements MessageLiteOrBuilder {

            /* renamed from: k */
            public int f23684k;

            /* renamed from: l */
            public List<c> f23685l = Collections.emptyList();

            /* renamed from: m */
            public List<Integer> f23686m = Collections.emptyList();

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public e buildPartial() {
                e eVar = new e(this, null);
                if ((this.f23684k & 1) == 1) {
                    this.f23685l = Collections.unmodifiableList(this.f23685l);
                    this.f23684k &= -2;
                }
                e.m9567b(eVar, this.f23685l);
                if ((this.f23684k & 2) == 2) {
                    this.f23686m = Collections.unmodifiableList(this.f23686m);
                    this.f23684k &= -3;
                }
                e.m9569d(eVar, this.f23686m);
                return eVar;
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
            public e build() {
                e eVarBuildPartial = buildPartial();
                if (eVarBuildPartial.isInitialized()) {
                    return eVarBuildPartial;
                }
                throw new UninitializedMessageException(eVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((e) generatedMessageLite);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
            public b clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeFrom(e eVar) {
                if (eVar == e.getDefaultInstance()) {
                    return this;
                }
                if (!e.m9566a(eVar).isEmpty()) {
                    if (this.f23685l.isEmpty()) {
                        this.f23685l = e.m9566a(eVar);
                        this.f23684k &= -2;
                    } else {
                        if ((this.f23684k & 1) != 1) {
                            this.f23685l = new ArrayList(this.f23685l);
                            this.f23684k |= 1;
                        }
                        this.f23685l.addAll(e.m9566a(eVar));
                    }
                }
                if (!e.m9568c(eVar).isEmpty()) {
                    if (this.f23686m.isEmpty()) {
                        this.f23686m = e.m9568c(eVar);
                        this.f23684k &= -3;
                    } else {
                        if ((this.f23684k & 2) != 2) {
                            this.f23686m = new ArrayList(this.f23686m);
                            this.f23684k |= 2;
                        }
                        this.f23686m.addAll(e.m9568c(eVar));
                    }
                }
                setUnknownFields(getUnknownFields().concat(e.m9570e(eVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                e eVar = null;
                try {
                    try {
                        e partialFrom = e.f23683k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        e eVar2 = (e) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            eVar = eVar2;
                            if (eVar != null) {
                                mergeFrom(eVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (eVar != null) {
                    }
                    throw th;
                }
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c */
        public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {

            /* renamed from: j */
            public static final c f23687j;

            /* renamed from: k */
            public static Parser2<c> f23688k = new a();
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private EnumC13318c operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString3 unknownFields;

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$a */
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

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$b */
            public static final class b extends GeneratedMessageLite.b<c, b> implements MessageLiteOrBuilder {

                /* renamed from: k */
                public int f23689k;

                /* renamed from: m */
                public int f23691m;

                /* renamed from: l */
                public int f23690l = 1;

                /* renamed from: n */
                public Object f23692n = "";

                /* renamed from: o */
                public EnumC13318c f23693o = EnumC13318c.NONE;

                /* renamed from: p */
                public List<Integer> f23694p = Collections.emptyList();

                /* renamed from: q */
                public List<Integer> f23695q = Collections.emptyList();

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f23689k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    c.m9573c(cVar, this.f23690l);
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    c.m9574d(cVar, this.f23691m);
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    c.m9576f(cVar, this.f23692n);
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    c.m9577g(cVar, this.f23693o);
                    if ((this.f23689k & 16) == 16) {
                        this.f23694p = Collections.unmodifiableList(this.f23694p);
                        this.f23689k &= -17;
                    }
                    c.m9579i(cVar, this.f23694p);
                    if ((this.f23689k & 32) == 32) {
                        this.f23695q = Collections.unmodifiableList(this.f23695q);
                        this.f23689k &= -33;
                    }
                    c.m9581k(cVar, this.f23695q);
                    c.m9571a(cVar, i2);
                    return cVar;
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

                public b setOperation(EnumC13318c enumC13318c) {
                    Objects.requireNonNull(enumC13318c);
                    this.f23689k |= 8;
                    this.f23693o = enumC13318c;
                    return this;
                }

                public b setPredefinedIndex(int i) {
                    this.f23689k |= 2;
                    this.f23691m = i;
                    return this;
                }

                public b setRange(int i) {
                    this.f23689k |= 1;
                    this.f23690l = i;
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
                    if (cVar.hasRange()) {
                        setRange(cVar.getRange());
                    }
                    if (cVar.hasPredefinedIndex()) {
                        setPredefinedIndex(cVar.getPredefinedIndex());
                    }
                    if (cVar.hasString()) {
                        this.f23689k |= 4;
                        this.f23692n = c.m9575e(cVar);
                    }
                    if (cVar.hasOperation()) {
                        setOperation(cVar.getOperation());
                    }
                    if (!c.m9578h(cVar).isEmpty()) {
                        if (this.f23694p.isEmpty()) {
                            this.f23694p = c.m9578h(cVar);
                            this.f23689k &= -17;
                        } else {
                            if ((this.f23689k & 16) != 16) {
                                this.f23694p = new ArrayList(this.f23694p);
                                this.f23689k |= 16;
                            }
                            this.f23694p.addAll(c.m9578h(cVar));
                        }
                    }
                    if (!c.m9580j(cVar).isEmpty()) {
                        if (this.f23695q.isEmpty()) {
                            this.f23695q = c.m9580j(cVar);
                            this.f23689k &= -33;
                        } else {
                            if ((this.f23689k & 32) != 32) {
                                this.f23695q = new ArrayList(this.f23695q);
                                this.f23689k |= 32;
                            }
                            this.f23695q.addAll(c.m9580j(cVar));
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(c.m9572b(cVar)));
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
                            c partialFrom = c.f23688k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$c, reason: collision with other inner class name */
            public enum EnumC13318c implements Internal.a {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);

                private final int value;

                EnumC13318c(int i) {
                    this.value = i;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC13318c valueOf(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                c cVar = new c();
                f23687j = cVar;
                cVar.m9582l();
            }

            public c(GeneratedMessageLite.b bVar, a aVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            /* renamed from: a */
            public static /* synthetic */ int m9571a(c cVar, int i) {
                cVar.bitField0_ = i;
                return i;
            }

            /* renamed from: b */
            public static /* synthetic */ ByteString3 m9572b(c cVar) {
                return cVar.unknownFields;
            }

            /* renamed from: c */
            public static /* synthetic */ int m9573c(c cVar, int i) {
                cVar.range_ = i;
                return i;
            }

            /* renamed from: d */
            public static /* synthetic */ int m9574d(c cVar, int i) {
                cVar.predefinedIndex_ = i;
                return i;
            }

            /* renamed from: e */
            public static /* synthetic */ Object m9575e(c cVar) {
                return cVar.string_;
            }

            /* renamed from: f */
            public static /* synthetic */ Object m9576f(c cVar, Object obj) {
                cVar.string_ = obj;
                return obj;
            }

            /* renamed from: g */
            public static /* synthetic */ EnumC13318c m9577g(c cVar, EnumC13318c enumC13318c) {
                cVar.operation_ = enumC13318c;
                return enumC13318c;
            }

            public static c getDefaultInstance() {
                return f23687j;
            }

            /* renamed from: h */
            public static /* synthetic */ List m9578h(c cVar) {
                return cVar.substringIndex_;
            }

            /* renamed from: i */
            public static /* synthetic */ List m9579i(c cVar, List list) {
                cVar.substringIndex_ = list;
                return list;
            }

            /* renamed from: j */
            public static /* synthetic */ List m9580j(c cVar) {
                return cVar.replaceChar_;
            }

            /* renamed from: k */
            public static /* synthetic */ List m9581k(c cVar, List list) {
                cVar.replaceChar_ = list;
                return list;
            }

            public static b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public EnumC13318c getOperation() {
                return this.operation_;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int iComputeInt32SizeNoTag = 0;
                for (int i2 = 0; i2 < this.substringIndex_.size(); i2++) {
                    iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i2).intValue());
                }
                int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
                if (!getSubstringIndexList().isEmpty()) {
                    iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
                }
                this.substringIndexMemoizedSerializedSize = iComputeInt32SizeNoTag;
                int iComputeInt32SizeNoTag3 = 0;
                for (int i3 = 0; i3 < this.replaceChar_.size(); i3++) {
                    iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i3).intValue());
                }
                int iComputeBytesSize = iComputeInt32SizeNoTag2 + iComputeInt32SizeNoTag3;
                if (!getReplaceCharList().isEmpty()) {
                    iComputeBytesSize = iComputeBytesSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
                }
                this.replaceCharMemoizedSerializedSize = iComputeInt32SizeNoTag3;
                if ((this.bitField0_ & 4) == 4) {
                    iComputeBytesSize += CodedOutputStream.computeBytesSize(6, getStringBytes());
                }
                int size = this.unknownFields.size() + iComputeBytesSize;
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString3 byteString3 = (ByteString3) obj;
                String stringUtf8 = byteString3.toStringUtf8();
                if (byteString3.isValidUtf8()) {
                    this.string_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString3 getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (ByteString3) obj;
                }
                ByteString3 byteString3CopyFromUtf8 = ByteString3.copyFromUtf8((String) obj);
                this.string_ = byteString3CopyFromUtf8;
                return byteString3CopyFromUtf8;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
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
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            /* renamed from: l */
            public final void m9582l() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = EnumC13318c.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
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
                    codedOutputStream.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (int i = 0; i < this.substringIndex_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.replaceChar_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i2).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeBytes(6, getStringBytes());
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
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString3.f24100j;
            }

            public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m9582l();
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
                                    this.range_ = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    int i2 = codedInputStream.readEnum();
                                    EnumC13318c enumC13318cValueOf = EnumC13318c.valueOf(i2);
                                    if (enumC13318cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = enumC13318cValueOf;
                                    }
                                } else if (tag == 32) {
                                    if ((i & 16) != 16) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (tag == 34) {
                                    int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 16) != 16 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(iPushLimit);
                                } else if (tag == 40) {
                                    if ((i & 32) != 32) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (tag == 42) {
                                    int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(iPushLimit2);
                                } else if (tag != 50) {
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    ByteString3 bytes = codedInputStream.readBytes();
                                    this.bitField0_ |= 4;
                                    this.string_ = bytes;
                                }
                            }
                            z2 = true;
                        } catch (Throwable th) {
                            if ((i & 16) == 16) {
                                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                            }
                            if ((i & 32) == 32) {
                                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
                if ((i & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
            e eVar = new e();
            f23682j = eVar;
            eVar.record_ = Collections.emptyList();
            eVar.localName_ = Collections.emptyList();
        }

        public e(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        /* renamed from: a */
        public static /* synthetic */ List m9566a(e eVar) {
            return eVar.record_;
        }

        /* renamed from: b */
        public static /* synthetic */ List m9567b(e eVar, List list) {
            eVar.record_ = list;
            return list;
        }

        /* renamed from: c */
        public static /* synthetic */ List m9568c(e eVar) {
            return eVar.localName_;
        }

        /* renamed from: d */
        public static /* synthetic */ List m9569d(e eVar, List list) {
            eVar.localName_ = list;
            return list;
        }

        /* renamed from: e */
        public static /* synthetic */ ByteString3 m9570e(e eVar) {
            return eVar.unknownFields;
        }

        public static e getDefaultInstance() {
            return f23682j;
        }

        public static b newBuilder(e eVar) {
            return newBuilder().mergeFrom(eVar);
        }

        public static e parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (e) ((AbstractParser) f23683k).m11466parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        public List<c> getRecordList() {
            return this.record_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.record_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.record_.get(i2));
            }
            int iComputeInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < this.localName_.size(); i3++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i3).intValue());
            }
            int iComputeInt32SizeNoTag2 = iComputeMessageSize + iComputeInt32SizeNoTag;
            if (!getLocalNameList().isEmpty()) {
                iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
            }
            this.localNameMemoizedSerializedSize = iComputeInt32SizeNoTag;
            int size = this.unknownFields.size() + iComputeInt32SizeNoTag2;
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
            for (int i = 0; i < this.record_.size(); i++) {
                codedOutputStream.writeMessage(1, this.record_.get(i));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localName_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
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

        public e() {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.f24100j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            int i = 0;
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if ((i & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i |= 1;
                                }
                                this.record_.add(codedInputStream.readMessage(c.f23688k, extensionRegistryLite));
                            } else if (tag == 40) {
                                if ((i & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (tag != 42) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 2) != 2 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(iPushLimit);
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
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
            if ((i & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
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
        C11679d defaultInstance = C11679d.getDefaultInstance();
        c defaultInstance2 = c.getDefaultInstance();
        c defaultInstance3 = c.getDefaultInstance();
        WireFormat.b bVar = WireFormat.b.f24201t;
        f23651a = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, bVar, c.class);
        f23652b = GeneratedMessageLite.newSingularGeneratedExtension(C11684i.getDefaultInstance(), c.getDefaultInstance(), c.getDefaultInstance(), null, 100, bVar, c.class);
        C11684i defaultInstance4 = C11684i.getDefaultInstance();
        WireFormat.b bVar2 = WireFormat.b.f24195n;
        f23653c = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, bVar2, Integer.class);
        f23654d = GeneratedMessageLite.newSingularGeneratedExtension(C11689n.getDefaultInstance(), d.getDefaultInstance(), d.getDefaultInstance(), null, 100, bVar, d.class);
        f23655e = GeneratedMessageLite.newSingularGeneratedExtension(C11689n.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23656f = GeneratedMessageLite.newRepeatedGeneratedExtension(C11692q.getDefaultInstance(), C11677b.getDefaultInstance(), null, 100, bVar, false, C11677b.class);
        f23657g = GeneratedMessageLite.newSingularGeneratedExtension(C11692q.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.b.f24198q, Boolean.class);
        f23658h = GeneratedMessageLite.newRepeatedGeneratedExtension(C11694s.getDefaultInstance(), C11677b.getDefaultInstance(), null, 100, bVar, false, C11677b.class);
        f23659i = GeneratedMessageLite.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23660j = GeneratedMessageLite.newRepeatedGeneratedExtension(C11678c.getDefaultInstance(), C11689n.getDefaultInstance(), null, 102, bVar, false, C11689n.class);
        f23661k = GeneratedMessageLite.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 103, bVar2, Integer.class);
        f23662l = GeneratedMessageLite.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 104, bVar2, Integer.class);
        f23663m = GeneratedMessageLite.newSingularGeneratedExtension(C11687l.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23664n = GeneratedMessageLite.newRepeatedGeneratedExtension(C11687l.getDefaultInstance(), C11689n.getDefaultInstance(), null, 102, bVar, false, C11689n.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(f23651a);
        extensionRegistryLite.add(f23652b);
        extensionRegistryLite.add(f23653c);
        extensionRegistryLite.add(f23654d);
        extensionRegistryLite.add(f23655e);
        extensionRegistryLite.add(f23656f);
        extensionRegistryLite.add(f23657g);
        extensionRegistryLite.add(f23658h);
        extensionRegistryLite.add(f23659i);
        extensionRegistryLite.add(f23660j);
        extensionRegistryLite.add(f23661k);
        extensionRegistryLite.add(f23662l);
        extensionRegistryLite.add(f23663m);
        extensionRegistryLite.add(f23664n);
    }
}
