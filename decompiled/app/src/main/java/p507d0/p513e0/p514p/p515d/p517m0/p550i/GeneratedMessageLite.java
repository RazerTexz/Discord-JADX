package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.WireFormat;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.g, reason: use source file name */
/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$b */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends AbstractMessageLite.a<BuilderType> {

        /* JADX INFO: renamed from: j */
        public ByteString3 f24125j = ByteString3.f24100j;

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11465clone() throws CloneNotSupportedException {
            return clone();
        }

        public final ByteString3 getUnknownFields() {
            return this.f24125j;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString3 byteString3) {
            this.f24125j = byteString3;
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$c */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements MessageLiteOrBuilder {

        /* JADX INFO: renamed from: k */
        public FieldSet<e> f24126k = FieldSet.emptySet();

        /* JADX INFO: renamed from: l */
        public boolean f24127l;

        /* JADX INFO: renamed from: b */
        public final void m9846b(MessageType messagetype) {
            if (!this.f24127l) {
                this.f24126k = this.f24126k.clone();
                this.f24127l = true;
            }
            this.f24126k.mergeFrom(d.m9847a(messagetype));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$e */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class e implements FieldSet.a<e> {

        /* JADX INFO: renamed from: j */
        public final Internal.b<?> f24132j;

        /* JADX INFO: renamed from: k */
        public final int f24133k;

        /* JADX INFO: renamed from: l */
        public final WireFormat.b f24134l;

        /* JADX INFO: renamed from: m */
        public final boolean f24135m;

        /* JADX INFO: renamed from: n */
        public final boolean f24136n;

        public e(Internal.b<?> bVar, int i, WireFormat.b bVar2, boolean z2, boolean z3) {
            this.f24132j = bVar;
            this.f24133k = i;
            this.f24134l = bVar2;
            this.f24135m = z2;
            this.f24136n = z3;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((e) obj);
        }

        public Internal.b<?> getEnumType() {
            return this.f24132j;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public WireFormat.c getLiteJavaType() {
            return this.f24134l.getJavaType();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public WireFormat.b getLiteType() {
            return this.f24134l;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public int getNumber() {
            return this.f24133k;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public MessageLite.a internalMergeFrom(MessageLite.a aVar, MessageLite messageLite) {
            return ((b) aVar).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public boolean isPacked() {
            return this.f24136n;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a
        public boolean isRepeated() {
            return this.f24135m;
        }

        public int compareTo(e eVar) {
            return this.f24133k - eVar.f24133k;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$f */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class f<ContainingType extends MessageLite, Type> {

        /* JADX INFO: renamed from: a */
        public final ContainingType f24137a;

        /* JADX INFO: renamed from: b */
        public final Type f24138b;

        /* JADX INFO: renamed from: c */
        public final MessageLite f24139c;

        /* JADX INFO: renamed from: d */
        public final e f24140d;

        /* JADX INFO: renamed from: e */
        public final Method f24141e;

        public f(ContainingType containingtype, Type type, MessageLite messageLite, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.getLiteType() == WireFormat.b.f24201t && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f24137a = containingtype;
            this.f24138b = type;
            this.f24139c = messageLite;
            this.f24140d = eVar;
            if (!Internal.a.class.isAssignableFrom(cls)) {
                this.f24141e = null;
                return;
            }
            try {
                this.f24141e = cls.getMethod("valueOf", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                outline.m876s0(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                sb.append("\".");
                throw new RuntimeException(sb.toString(), e);
            }
        }

        /* JADX INFO: renamed from: a */
        public Object m9854a(Object obj) {
            if (this.f24140d.getLiteJavaType() != WireFormat.c.ENUM) {
                return obj;
            }
            try {
                return this.f24141e.invoke(null, (Integer) obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }

        /* JADX INFO: renamed from: b */
        public Object m9855b(Object obj) {
            return this.f24140d.getLiteJavaType() == WireFormat.c.ENUM ? Integer.valueOf(((Internal.a) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f24137a;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.f24139c;
        }

        public int getNumber() {
            return this.f24140d.getNumber();
        }
    }

    public GeneratedMessageLite() {
    }

    public static <ContainingType extends MessageLite, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.b<?> bVar, int i, WireFormat.b bVar2, boolean z2, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), messageLite, new e(bVar, i, bVar2, true, z2), cls);
    }

    public static <ContainingType extends MessageLite, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.b<?> bVar, int i, WireFormat.b bVar2, Class cls) {
        return new f<>(containingtype, type, messageLite, new e(bVar, i, bVar2, false, false), cls);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class d<MessageType extends d<MessageType>> extends GeneratedMessageLite implements MessageLiteOrBuilder {
        private final FieldSet<e> extensions;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d$a */
        /* JADX INFO: compiled from: GeneratedMessageLite.java */
        public class a {

            /* JADX INFO: renamed from: a */
            public final Iterator<Map.Entry<e, Object>> f24128a;

            /* JADX INFO: renamed from: b */
            public Map.Entry<e, Object> f24129b;

            /* JADX INFO: renamed from: c */
            public final boolean f24130c;

            public a(boolean z2, a aVar) {
                Iterator<Map.Entry<e, Object>> it = d.m9847a(d.this).iterator();
                this.f24128a = it;
                if (it.hasNext()) {
                    this.f24129b = it.next();
                }
                this.f24130c = z2;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f24129b;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    e key = this.f24129b.getKey();
                    if (this.f24130c && key.getLiteJavaType() == WireFormat.c.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.f24129b.getValue());
                    } else {
                        FieldSet.writeField(key, this.f24129b.getValue(), codedOutputStream);
                    }
                    if (this.f24128a.hasNext()) {
                        this.f24129b = this.f24128a.next();
                    } else {
                        this.f24129b = null;
                    }
                }
            }
        }

        public d() {
            this.extensions = FieldSet.newFieldSet();
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ FieldSet m9847a(d dVar) {
            return dVar.extensions;
        }

        /* JADX INFO: renamed from: b */
        public boolean m9848b() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: renamed from: c */
        public int m9849c() {
            return this.extensions.getSerializedSize();
        }

        /* JADX INFO: renamed from: d */
        public void m9850d() {
            this.extensions.makeImmutable();
        }

        /* JADX INFO: renamed from: e */
        public d<MessageType>.a m9851e() {
            return new a(false, null);
        }

        /* JADX INFO: renamed from: f */
        public boolean m9852f(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            boolean z2;
            boolean z3;
            Object objBuild;
            MessageLite messageLite;
            FieldSet<e> fieldSet = this.extensions;
            int i2 = i & 7;
            f fVarFindLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(getDefaultInstanceForType(), WireFormat.getTagFieldNumber(i));
            if (fVarFindLiteExtensionByNumber == null) {
                z2 = true;
                z3 = false;
            } else if (i2 == FieldSet.m9839c(fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false)) {
                z2 = false;
                z3 = false;
            } else {
                e eVar = fVarFindLiteExtensionByNumber.f24140d;
                if (eVar.f24135m && eVar.f24134l.isPackable() && i2 == FieldSet.m9839c(fVarFindLiteExtensionByNumber.f24140d.getLiteType(), true)) {
                    z2 = false;
                    z3 = true;
                }
                z2 = true;
                z3 = false;
            }
            if (z2) {
                return codedInputStream.skipField(i, codedOutputStream);
            }
            if (z3) {
                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                if (fVarFindLiteExtensionByNumber.f24140d.getLiteType() == WireFormat.b.f24204w) {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Internal.a aVarFindValueByNumber = fVarFindLiteExtensionByNumber.f24140d.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (aVarFindValueByNumber == null) {
                            return true;
                        }
                        fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(aVarFindValueByNumber));
                    }
                } else {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, FieldSet.readPrimitiveField(codedInputStream, fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false));
                    }
                }
                codedInputStream.popLimit(iPushLimit);
                return true;
            }
            int iOrdinal = fVarFindLiteExtensionByNumber.f24140d.getLiteJavaType().ordinal();
            if (iOrdinal == 7) {
                int i3 = codedInputStream.readEnum();
                Internal.a aVarFindValueByNumber2 = fVarFindLiteExtensionByNumber.f24140d.getEnumType().findValueByNumber(i3);
                if (aVarFindValueByNumber2 == null) {
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeUInt32NoTag(i3);
                    return true;
                }
                objBuild = aVarFindValueByNumber2;
            } else if (iOrdinal != 8) {
                objBuild = FieldSet.readPrimitiveField(codedInputStream, fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false);
            } else {
                MessageLite.a aVarNewBuilderForType = null;
                if (!fVarFindLiteExtensionByNumber.f24140d.isRepeated() && (messageLite = (MessageLite) fieldSet.getField(fVarFindLiteExtensionByNumber.f24140d)) != null) {
                    aVarNewBuilderForType = messageLite.toBuilder();
                }
                if (aVarNewBuilderForType == null) {
                    aVarNewBuilderForType = fVarFindLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                }
                if (fVarFindLiteExtensionByNumber.f24140d.getLiteType() == WireFormat.b.f24200s) {
                    codedInputStream.readGroup(fVarFindLiteExtensionByNumber.getNumber(), aVarNewBuilderForType, extensionRegistryLite);
                } else {
                    codedInputStream.readMessage(aVarNewBuilderForType, extensionRegistryLite);
                }
                objBuild = aVarNewBuilderForType.build();
            }
            if (fVarFindLiteExtensionByNumber.f24140d.isRepeated()) {
                fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(objBuild));
                return true;
            }
            fieldSet.setField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(objBuild));
            return true;
        }

        /* JADX INFO: renamed from: g */
        public final void m9853g(f<MessageType, ?> fVar) {
            if (fVar.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [Type, java.util.ArrayList] */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            m9853g(fVar);
            Type type = (Type) this.extensions.getField(fVar.f24140d);
            if (type == null) {
                return fVar.f24138b;
            }
            if (!fVar.f24140d.isRepeated()) {
                return (Type) fVar.m9854a(type);
            }
            if (fVar.f24140d.getLiteJavaType() != WireFormat.c.ENUM) {
                return type;
            }
            ?? r1 = (Type) new ArrayList();
            Iterator it = ((List) type).iterator();
            while (it.hasNext()) {
                r1.add(fVar.m9854a(it.next()));
            }
            return r1;
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            m9853g(fVar);
            return this.extensions.getRepeatedFieldCount(fVar.f24140d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            m9853g(fVar);
            return this.extensions.hasField(fVar.f24140d);
        }

        public d(c<MessageType, ?> cVar) {
            cVar.f24126k.makeImmutable();
            cVar.f24127l = false;
            this.extensions = cVar.f24126k;
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i) {
            m9853g(fVar);
            return (Type) fVar.m9854a(this.extensions.getRepeatedField(fVar.f24140d, i));
        }
    }

    public GeneratedMessageLite(b bVar) {
    }
}
