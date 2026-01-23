package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.c */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11678c extends GeneratedMessageLite.d<C11678c> implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: j */
    public static final C11678c f23760j;

    /* JADX INFO: renamed from: k */
    public static Parser2<C11678c> f23761k = new a();
    private int bitField0_;
    private int companionObjectName_;
    private List<C11679d> constructor_;
    private List<C11682g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<C11684i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<C11689n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<C11692q> supertype_;
    private List<C11693r> typeAlias_;
    private List<C11694s> typeParameter_;
    private C11695t typeTable_;
    private final ByteString3 unknownFields;
    private C11698w versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<C11678c> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2
        public C11678c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new C11678c(codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<C11678c, b> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: m */
        public int f23765m;

        /* JADX INFO: renamed from: o */
        public int f23767o;

        /* JADX INFO: renamed from: p */
        public int f23768p;

        /* JADX INFO: renamed from: n */
        public int f23766n = 6;

        /* JADX INFO: renamed from: q */
        public List<C11694s> f23769q = Collections.emptyList();

        /* JADX INFO: renamed from: r */
        public List<C11692q> f23770r = Collections.emptyList();

        /* JADX INFO: renamed from: s */
        public List<Integer> f23771s = Collections.emptyList();

        /* JADX INFO: renamed from: t */
        public List<Integer> f23772t = Collections.emptyList();

        /* JADX INFO: renamed from: u */
        public List<C11679d> f23773u = Collections.emptyList();

        /* JADX INFO: renamed from: v */
        public List<C11684i> f23774v = Collections.emptyList();

        /* JADX INFO: renamed from: w */
        public List<C11689n> f23775w = Collections.emptyList();

        /* JADX INFO: renamed from: x */
        public List<C11693r> f23776x = Collections.emptyList();

        /* JADX INFO: renamed from: y */
        public List<C11682g> f23777y = Collections.emptyList();

        /* JADX INFO: renamed from: z */
        public List<Integer> f23778z = Collections.emptyList();

        /* JADX INFO: renamed from: A */
        public C11695t f23762A = C11695t.getDefaultInstance();

        /* JADX INFO: renamed from: B */
        public List<Integer> f23763B = Collections.emptyList();

        /* JADX INFO: renamed from: C */
        public C11698w f23764C = C11698w.getDefaultInstance();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public C11678c buildPartial() {
            C11678c c11678c = new C11678c(this, (C11666a) null);
            int i = this.f23765m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            C11678c.m9631r(c11678c, this.f23766n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            C11678c.m9632s(c11678c, this.f23767o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            C11678c.m9633t(c11678c, this.f23768p);
            if ((this.f23765m & 8) == 8) {
                this.f23769q = Collections.unmodifiableList(this.f23769q);
                this.f23765m &= -9;
            }
            C11678c.m9635v(c11678c, this.f23769q);
            if ((this.f23765m & 16) == 16) {
                this.f23770r = Collections.unmodifiableList(this.f23770r);
                this.f23765m &= -17;
            }
            C11678c.m9637x(c11678c, this.f23770r);
            if ((this.f23765m & 32) == 32) {
                this.f23771s = Collections.unmodifiableList(this.f23771s);
                this.f23765m &= -33;
            }
            C11678c.m9639z(c11678c, this.f23771s);
            if ((this.f23765m & 64) == 64) {
                this.f23772t = Collections.unmodifiableList(this.f23772t);
                this.f23765m &= -65;
            }
            C11678c.m9612B(c11678c, this.f23772t);
            if ((this.f23765m & 128) == 128) {
                this.f23773u = Collections.unmodifiableList(this.f23773u);
                this.f23765m &= -129;
            }
            C11678c.m9614D(c11678c, this.f23773u);
            if ((this.f23765m & 256) == 256) {
                this.f23774v = Collections.unmodifiableList(this.f23774v);
                this.f23765m &= -257;
            }
            C11678c.m9616F(c11678c, this.f23774v);
            if ((this.f23765m & 512) == 512) {
                this.f23775w = Collections.unmodifiableList(this.f23775w);
                this.f23765m &= -513;
            }
            C11678c.m9618H(c11678c, this.f23775w);
            if ((this.f23765m & 1024) == 1024) {
                this.f23776x = Collections.unmodifiableList(this.f23776x);
                this.f23765m &= -1025;
            }
            C11678c.m9620J(c11678c, this.f23776x);
            if ((this.f23765m & 2048) == 2048) {
                this.f23777y = Collections.unmodifiableList(this.f23777y);
                this.f23765m &= -2049;
            }
            C11678c.m9622i(c11678c, this.f23777y);
            if ((this.f23765m & 4096) == 4096) {
                this.f23778z = Collections.unmodifiableList(this.f23778z);
                this.f23765m &= -4097;
            }
            C11678c.m9624k(c11678c, this.f23778z);
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            C11678c.m9625l(c11678c, this.f23762A);
            if ((this.f23765m & 16384) == 16384) {
                this.f23763B = Collections.unmodifiableList(this.f23763B);
                this.f23765m &= -16385;
            }
            C11678c.m9627n(c11678c, this.f23763B);
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            C11678c.m9628o(c11678c, this.f23764C);
            C11678c.m9629p(c11678c, i2);
            return c11678c;
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

        public b mergeTypeTable(C11695t c11695t) {
            if ((this.f23765m & 8192) != 8192 || this.f23762A == C11695t.getDefaultInstance()) {
                this.f23762A = c11695t;
            } else {
                this.f23762A = C11695t.newBuilder(this.f23762A).mergeFrom(c11695t).buildPartial();
            }
            this.f23765m |= 8192;
            return this;
        }

        public b mergeVersionRequirementTable(C11698w c11698w) {
            if ((this.f23765m & 32768) != 32768 || this.f23764C == C11698w.getDefaultInstance()) {
                this.f23764C = c11698w;
            } else {
                this.f23764C = C11698w.newBuilder(this.f23764C).mergeFrom(c11698w).buildPartial();
            }
            this.f23765m |= 32768;
            return this;
        }

        public b setCompanionObjectName(int i) {
            this.f23765m |= 4;
            this.f23768p = i;
            return this;
        }

        public b setFlags(int i) {
            this.f23765m |= 1;
            this.f23766n = i;
            return this;
        }

        public b setFqName(int i) {
            this.f23765m |= 2;
            this.f23767o = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public C11678c build() {
            C11678c c11678cBuildPartial = buildPartial();
            if (c11678cBuildPartial.isInitialized()) {
                return c11678cBuildPartial;
            }
            throw new UninitializedMessageException(c11678cBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((C11678c) generatedMessageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(C11678c c11678c) {
            if (c11678c == C11678c.getDefaultInstance()) {
                return this;
            }
            if (c11678c.hasFlags()) {
                setFlags(c11678c.getFlags());
            }
            if (c11678c.hasFqName()) {
                setFqName(c11678c.getFqName());
            }
            if (c11678c.hasCompanionObjectName()) {
                setCompanionObjectName(c11678c.getCompanionObjectName());
            }
            if (!C11678c.m9634u(c11678c).isEmpty()) {
                if (this.f23769q.isEmpty()) {
                    this.f23769q = C11678c.m9634u(c11678c);
                    this.f23765m &= -9;
                } else {
                    if ((this.f23765m & 8) != 8) {
                        this.f23769q = new ArrayList(this.f23769q);
                        this.f23765m |= 8;
                    }
                    this.f23769q.addAll(C11678c.m9634u(c11678c));
                }
            }
            if (!C11678c.m9636w(c11678c).isEmpty()) {
                if (this.f23770r.isEmpty()) {
                    this.f23770r = C11678c.m9636w(c11678c);
                    this.f23765m &= -17;
                } else {
                    if ((this.f23765m & 16) != 16) {
                        this.f23770r = new ArrayList(this.f23770r);
                        this.f23765m |= 16;
                    }
                    this.f23770r.addAll(C11678c.m9636w(c11678c));
                }
            }
            if (!C11678c.m9638y(c11678c).isEmpty()) {
                if (this.f23771s.isEmpty()) {
                    this.f23771s = C11678c.m9638y(c11678c);
                    this.f23765m &= -33;
                } else {
                    if ((this.f23765m & 32) != 32) {
                        this.f23771s = new ArrayList(this.f23771s);
                        this.f23765m |= 32;
                    }
                    this.f23771s.addAll(C11678c.m9638y(c11678c));
                }
            }
            if (!C11678c.m9611A(c11678c).isEmpty()) {
                if (this.f23772t.isEmpty()) {
                    this.f23772t = C11678c.m9611A(c11678c);
                    this.f23765m &= -65;
                } else {
                    if ((this.f23765m & 64) != 64) {
                        this.f23772t = new ArrayList(this.f23772t);
                        this.f23765m |= 64;
                    }
                    this.f23772t.addAll(C11678c.m9611A(c11678c));
                }
            }
            if (!C11678c.m9613C(c11678c).isEmpty()) {
                if (this.f23773u.isEmpty()) {
                    this.f23773u = C11678c.m9613C(c11678c);
                    this.f23765m &= -129;
                } else {
                    if ((this.f23765m & 128) != 128) {
                        this.f23773u = new ArrayList(this.f23773u);
                        this.f23765m |= 128;
                    }
                    this.f23773u.addAll(C11678c.m9613C(c11678c));
                }
            }
            if (!C11678c.m9615E(c11678c).isEmpty()) {
                if (this.f23774v.isEmpty()) {
                    this.f23774v = C11678c.m9615E(c11678c);
                    this.f23765m &= -257;
                } else {
                    if ((this.f23765m & 256) != 256) {
                        this.f23774v = new ArrayList(this.f23774v);
                        this.f23765m |= 256;
                    }
                    this.f23774v.addAll(C11678c.m9615E(c11678c));
                }
            }
            if (!C11678c.m9617G(c11678c).isEmpty()) {
                if (this.f23775w.isEmpty()) {
                    this.f23775w = C11678c.m9617G(c11678c);
                    this.f23765m &= -513;
                } else {
                    if ((this.f23765m & 512) != 512) {
                        this.f23775w = new ArrayList(this.f23775w);
                        this.f23765m |= 512;
                    }
                    this.f23775w.addAll(C11678c.m9617G(c11678c));
                }
            }
            if (!C11678c.m9619I(c11678c).isEmpty()) {
                if (this.f23776x.isEmpty()) {
                    this.f23776x = C11678c.m9619I(c11678c);
                    this.f23765m &= -1025;
                } else {
                    if ((this.f23765m & 1024) != 1024) {
                        this.f23776x = new ArrayList(this.f23776x);
                        this.f23765m |= 1024;
                    }
                    this.f23776x.addAll(C11678c.m9619I(c11678c));
                }
            }
            if (!C11678c.m9621h(c11678c).isEmpty()) {
                if (this.f23777y.isEmpty()) {
                    this.f23777y = C11678c.m9621h(c11678c);
                    this.f23765m &= -2049;
                } else {
                    if ((this.f23765m & 2048) != 2048) {
                        this.f23777y = new ArrayList(this.f23777y);
                        this.f23765m |= 2048;
                    }
                    this.f23777y.addAll(C11678c.m9621h(c11678c));
                }
            }
            if (!C11678c.m9623j(c11678c).isEmpty()) {
                if (this.f23778z.isEmpty()) {
                    this.f23778z = C11678c.m9623j(c11678c);
                    this.f23765m &= -4097;
                } else {
                    if ((this.f23765m & 4096) != 4096) {
                        this.f23778z = new ArrayList(this.f23778z);
                        this.f23765m |= 4096;
                    }
                    this.f23778z.addAll(C11678c.m9623j(c11678c));
                }
            }
            if (c11678c.hasTypeTable()) {
                mergeTypeTable(c11678c.getTypeTable());
            }
            if (!C11678c.m9626m(c11678c).isEmpty()) {
                if (this.f23763B.isEmpty()) {
                    this.f23763B = C11678c.m9626m(c11678c);
                    this.f23765m &= -16385;
                } else {
                    if ((this.f23765m & 16384) != 16384) {
                        this.f23763B = new ArrayList(this.f23763B);
                        this.f23765m |= 16384;
                    }
                    this.f23763B.addAll(C11678c.m9626m(c11678c));
                }
            }
            if (c11678c.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(c11678c.getVersionRequirementTable());
            }
            m9846b(c11678c);
            setUnknownFields(getUnknownFields().concat(C11678c.m9630q(c11678c)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            C11678c c11678c = null;
            try {
                try {
                    C11678c partialFrom = C11678c.f23761k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11678c c11678c2 = (C11678c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11678c = c11678c2;
                        if (c11678c != null) {
                            mergeFrom(c11678c);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11678c != null) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        CLASS(0),
        INTERFACE(1),
        ENUM_CLASS(2),
        ENUM_ENTRY(3),
        ANNOTATION_CLASS(4),
        OBJECT(5),
        COMPANION_OBJECT(6);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        C11678c c11678c = new C11678c();
        f23760j = c11678c;
        c11678c.m9640K();
    }

    public C11678c(GeneratedMessageLite.c cVar, C11666a c11666a) {
        super(cVar);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    /* JADX INFO: renamed from: A */
    public static /* synthetic */ List m9611A(C11678c c11678c) {
        return c11678c.nestedClassName_;
    }

    /* JADX INFO: renamed from: B */
    public static /* synthetic */ List m9612B(C11678c c11678c, List list) {
        c11678c.nestedClassName_ = list;
        return list;
    }

    /* JADX INFO: renamed from: C */
    public static /* synthetic */ List m9613C(C11678c c11678c) {
        return c11678c.constructor_;
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ List m9614D(C11678c c11678c, List list) {
        c11678c.constructor_ = list;
        return list;
    }

    /* JADX INFO: renamed from: E */
    public static /* synthetic */ List m9615E(C11678c c11678c) {
        return c11678c.function_;
    }

    /* JADX INFO: renamed from: F */
    public static /* synthetic */ List m9616F(C11678c c11678c, List list) {
        c11678c.function_ = list;
        return list;
    }

    /* JADX INFO: renamed from: G */
    public static /* synthetic */ List m9617G(C11678c c11678c) {
        return c11678c.property_;
    }

    /* JADX INFO: renamed from: H */
    public static /* synthetic */ List m9618H(C11678c c11678c, List list) {
        c11678c.property_ = list;
        return list;
    }

    /* JADX INFO: renamed from: I */
    public static /* synthetic */ List m9619I(C11678c c11678c) {
        return c11678c.typeAlias_;
    }

    /* JADX INFO: renamed from: J */
    public static /* synthetic */ List m9620J(C11678c c11678c, List list) {
        c11678c.typeAlias_ = list;
        return list;
    }

    public static C11678c getDefaultInstance() {
        return f23760j;
    }

    /* JADX INFO: renamed from: h */
    public static /* synthetic */ List m9621h(C11678c c11678c) {
        return c11678c.enumEntry_;
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ List m9622i(C11678c c11678c, List list) {
        c11678c.enumEntry_ = list;
        return list;
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ List m9623j(C11678c c11678c) {
        return c11678c.sealedSubclassFqName_;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ List m9624k(C11678c c11678c, List list) {
        c11678c.sealedSubclassFqName_ = list;
        return list;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ C11695t m9625l(C11678c c11678c, C11695t c11695t) {
        c11678c.typeTable_ = c11695t;
        return c11695t;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ List m9626m(C11678c c11678c) {
        return c11678c.versionRequirement_;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ List m9627n(C11678c c11678c, List list) {
        c11678c.versionRequirement_ = list;
        return list;
    }

    public static b newBuilder(C11678c c11678c) {
        return newBuilder().mergeFrom(c11678c);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ C11698w m9628o(C11678c c11678c, C11698w c11698w) {
        c11678c.versionRequirementTable_ = c11698w;
        return c11698w;
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ int m9629p(C11678c c11678c, int i) {
        c11678c.bitField0_ = i;
        return i;
    }

    public static C11678c parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (C11678c) ((AbstractParser) f23761k).m11467parseFrom(inputStream, extensionRegistryLite);
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ ByteString3 m9630q(C11678c c11678c) {
        return c11678c.unknownFields;
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ int m9631r(C11678c c11678c, int i) {
        c11678c.flags_ = i;
        return i;
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ int m9632s(C11678c c11678c, int i) {
        c11678c.fqName_ = i;
        return i;
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ int m9633t(C11678c c11678c, int i) {
        c11678c.companionObjectName_ = i;
        return i;
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ List m9634u(C11678c c11678c) {
        return c11678c.typeParameter_;
    }

    /* JADX INFO: renamed from: v */
    public static /* synthetic */ List m9635v(C11678c c11678c, List list) {
        c11678c.typeParameter_ = list;
        return list;
    }

    /* JADX INFO: renamed from: w */
    public static /* synthetic */ List m9636w(C11678c c11678c) {
        return c11678c.supertype_;
    }

    /* JADX INFO: renamed from: x */
    public static /* synthetic */ List m9637x(C11678c c11678c, List list) {
        c11678c.supertype_ = list;
        return list;
    }

    /* JADX INFO: renamed from: y */
    public static /* synthetic */ List m9638y(C11678c c11678c) {
        return c11678c.supertypeId_;
    }

    /* JADX INFO: renamed from: z */
    public static /* synthetic */ List m9639z(C11678c c11678c, List list) {
        c11678c.supertypeId_ = list;
        return list;
    }

    /* JADX INFO: renamed from: K */
    public final void m9640K() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = C11695t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = C11698w.getDefaultInstance();
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public C11679d getConstructor(int i) {
        return this.constructor_.get(i);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<C11679d> getConstructorList() {
        return this.constructor_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public C11682g getEnumEntry(int i) {
        return this.enumEntry_.get(i);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<C11682g> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public C11684i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<C11684i> getFunctionList() {
        return this.function_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    public C11689n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<C11689n> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        int iComputeInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.supertypeId_.size(); i2++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i2).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getSupertypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.supertypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i3));
        }
        for (int i4 = 0; i4 < this.supertype_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i4));
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i5 = 0; i5 < this.nestedClassName_.size(); i5++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i5).intValue());
        }
        int iComputeMessageSize2 = iComputeMessageSize + iComputeInt32SizeNoTag2;
        if (!getNestedClassNameList().isEmpty()) {
            iComputeMessageSize2 = iComputeMessageSize2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag2);
        }
        this.nestedClassNameMemoizedSerializedSize = iComputeInt32SizeNoTag2;
        for (int i6 = 0; i6 < this.constructor_.size(); i6++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i6));
        }
        for (int i7 = 0; i7 < this.function_.size(); i7++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(9, this.function_.get(i7));
        }
        for (int i8 = 0; i8 < this.property_.size(); i8++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(10, this.property_.get(i8));
        }
        for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i9));
        }
        for (int i10 = 0; i10 < this.enumEntry_.size(); i10++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i10));
        }
        int iComputeInt32SizeNoTag3 = 0;
        for (int i11 = 0; i11 < this.sealedSubclassFqName_.size(); i11++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i11).intValue());
        }
        int iComputeMessageSize3 = iComputeMessageSize2 + iComputeInt32SizeNoTag3;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            iComputeMessageSize3 = iComputeMessageSize3 + 2 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = iComputeInt32SizeNoTag3;
        if ((this.bitField0_ & 8) == 8) {
            iComputeMessageSize3 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag4 = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            iComputeInt32SizeNoTag4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i12).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize3 + iComputeInt32SizeNoTag4;
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size2 = this.unknownFields.size() + m9849c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public C11692q getSupertype(int i) {
        return this.supertype_.get(i);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<C11692q> getSupertypeList() {
        return this.supertype_;
    }

    public C11693r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<C11693r> getTypeAliasList() {
        return this.typeAlias_;
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

    public C11695t getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public C11698w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 16) == 16;
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
        if (!hasFqName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
            if (!getSupertype(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getConstructorCount(); i3++) {
            if (!getConstructor(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getFunctionCount(); i4++) {
            if (!getFunction(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getPropertyCount(); i5++) {
            if (!getProperty(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
            if (!getTypeAlias(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
            if (!getEnumEntry(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i3));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.writeMessage(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarM9851e.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLiteOrBuilder
    public C11678c getDefaultInstanceForType() {
        return f23760j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11678c() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11678c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9640K();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
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
                            if ((i & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = codedInputStream.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = codedInputStream.readInt32();
                            break;
                        case 42:
                            if ((i & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i |= 8;
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(C11694s.f23944k, extensionRegistryLite));
                            break;
                        case 50:
                            if ((i & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i |= 16;
                            }
                            this.supertype_.add(codedInputStream.readMessage(C11692q.f23904k, extensionRegistryLite));
                            break;
                        case 56:
                            if ((i & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 58:
                            int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 64) != 64 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit2);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.constructor_ = new ArrayList();
                                i |= 128;
                            }
                            this.constructor_.add(codedInputStream.readMessage(C11679d.f23788k, extensionRegistryLite));
                            break;
                        case 74:
                            if ((i & 256) != 256) {
                                this.function_ = new ArrayList();
                                i |= 256;
                            }
                            this.function_.add(codedInputStream.readMessage(C11684i.f23831k, extensionRegistryLite));
                            break;
                        case 82:
                            if ((i & 512) != 512) {
                                this.property_ = new ArrayList();
                                i |= 512;
                            }
                            this.property_.add(codedInputStream.readMessage(C11689n.f23871k, extensionRegistryLite));
                            break;
                        case 90:
                            if ((i & 1024) != 1024) {
                                this.typeAlias_ = new ArrayList();
                                i |= 1024;
                            }
                            this.typeAlias_.add(codedInputStream.readMessage(C11693r.f23932k, extensionRegistryLite));
                            break;
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.enumEntry_ = new ArrayList();
                                i |= 2048;
                            }
                            this.enumEntry_.add(codedInputStream.readMessage(C11682g.f23813k, extensionRegistryLite));
                            break;
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 130:
                            int iPushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 4096) != 4096 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit3);
                            break;
                        case 242:
                            C11695t.b builder = (this.bitField0_ & 8) == 8 ? this.typeTable_.toBuilder() : null;
                            C11695t c11695t = (C11695t) codedInputStream.readMessage(C11695t.f23957k, extensionRegistryLite);
                            this.typeTable_ = c11695t;
                            if (builder != 0) {
                                builder.mergeFrom(c11695t);
                                this.typeTable_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 248:
                            if ((i & 16384) != 16384) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 250:
                            int iPushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 16384) != 16384 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit4);
                            break;
                        case 258:
                            C11698w.b builder2 = (this.bitField0_ & 16) == 16 ? this.versionRequirementTable_.toBuilder() : null;
                            C11698w c11698w = (C11698w) codedInputStream.readMessage(C11698w.f23988k, extensionRegistryLite);
                            this.versionRequirementTable_ = c11698w;
                            if (builder2 != 0) {
                                builder2.mergeFrom(c11698w);
                                this.versionRequirementTable_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        default:
                            if (!m9852f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                z2 = true;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((i & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((i & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((i & 128) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((i & 256) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 512) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 1024) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((i & 2048) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((i & 4096) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                }
                if ((i & 16384) == 16384) {
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
        }
        if ((i & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if ((i & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if ((i & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if ((i & 128) == 128) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if ((i & 256) == 256) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 512) == 512) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 1024) == 1024) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if ((i & 2048) == 2048) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if ((i & 4096) == 4096) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if ((i & 16384) == 16384) {
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
    }
}
