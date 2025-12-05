package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.protoTypeTableUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JvmProtoBufUtil.kt */
/* renamed from: d0.e0.p.d.m0.f.a0.b.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmProtoBufUtil {

    /* renamed from: a */
    public static final JvmProtoBufUtil f23720a = new JvmProtoBufUtil();

    /* renamed from: b */
    public static final ExtensionRegistryLite f23721b;

    static {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        Intrinsics3.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        f23721b = extensionRegistryLiteNewInstance;
    }

    public static /* synthetic */ JvmMemberSignature.a getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, C11689n c11689n, NameResolver nameResolver, TypeTable typeTable, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(c11689n, nameResolver, typeTable, z2);
    }

    public static final boolean isMovedFromInterfaceCompanion(C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        Flags2.b is_moved_from_interface_companion = JvmFlags.f23704a.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = c11689n.getExtension(JvmProtoBuf.f23655e);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics3.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    public static final Tuples2<JvmNameResolver, C11678c> readClassDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics3.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readClassDataFrom(bArrDecodeBytes, strArr2);
    }

    public static final Tuples2<JvmNameResolver, C11684i> readFunctionDataFrom(String[] strArr, String[] strArr2) throws IOException {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr2), C11684i.parseFrom(byteArrayInputStream, f23721b));
    }

    public static final Tuples2<JvmNameResolver, C11687l> readPackageDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics3.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(bArrDecodeBytes, strArr2);
    }

    /* renamed from: a */
    public final String m9586a(C11692q c11692q, NameResolver nameResolver) {
        if (!c11692q.hasClassName()) {
            return null;
        }
        ClassMapperLite classMapperLite = ClassMapperLite.f23700a;
        return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(c11692q.getClassName()));
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return f23721b;
    }

    public final JvmMemberSignature.b getJvmConstructorSignature(C11679d c11679d, NameResolver nameResolver, TypeTable typeTable) {
        String strJoinToString$default;
        Intrinsics3.checkNotNullParameter(c11679d, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<C11679d, JvmProtoBuf.c> fVar = JvmProtoBuf.f23651a;
        Intrinsics3.checkNotNullExpressionValue(fVar, "constructorSignature");
        JvmProtoBuf.c cVar = (JvmProtoBuf.c) ProtoBufUtil.getExtensionOrNull(c11679d, fVar);
        String string = (cVar == null || !cVar.hasName()) ? "<init>" : nameResolver.getString(cVar.getName());
        if (cVar == null || !cVar.hasDesc()) {
            List<C11696u> valueParameterList = c11679d.getValueParameterList();
            Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterList, 10));
            for (C11696u c11696u : valueParameterList) {
                Intrinsics3.checkNotNullExpressionValue(c11696u, "it");
                String strM9586a = m9586a(protoTypeTableUtil.type(c11696u, typeTable), nameResolver);
                if (strM9586a == null) {
                    return null;
                }
                arrayList.add(strM9586a);
            }
            strJoinToString$default = _Collections.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strJoinToString$default = nameResolver.getString(cVar.getDesc());
        }
        return new JvmMemberSignature.b(string, strJoinToString$default);
    }

    public final JvmMemberSignature.a getJvmFieldSignature(C11689n c11689n, NameResolver nameResolver, TypeTable typeTable, boolean z2) {
        String strM9586a;
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<C11689n, JvmProtoBuf.d> fVar = JvmProtoBuf.f23654d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(c11689n, fVar);
        if (dVar == null) {
            return null;
        }
        JvmProtoBuf.b field = dVar.hasField() ? dVar.getField() : null;
        if (field == null && z2) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? c11689n.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strM9586a = m9586a(protoTypeTableUtil.returnType(c11689n, typeTable), nameResolver);
            if (strM9586a == null) {
                return null;
            }
        } else {
            strM9586a = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.a(nameResolver.getString(name), strM9586a);
    }

    public final JvmMemberSignature.b getJvmMethodSignature(C11684i c11684i, NameResolver nameResolver, TypeTable typeTable) {
        String strStringPlus;
        Intrinsics3.checkNotNullParameter(c11684i, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<C11684i, JvmProtoBuf.c> fVar = JvmProtoBuf.f23652b;
        Intrinsics3.checkNotNullExpressionValue(fVar, "methodSignature");
        JvmProtoBuf.c cVar = (JvmProtoBuf.c) ProtoBufUtil.getExtensionOrNull(c11684i, fVar);
        int name = (cVar == null || !cVar.hasName()) ? c11684i.getName() : cVar.getName();
        if (cVar == null || !cVar.hasDesc()) {
            List listListOfNotNull = Collections2.listOfNotNull(protoTypeTableUtil.receiverType(c11684i, typeTable));
            List<C11696u> valueParameterList = c11684i.getValueParameterList();
            Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterList, 10));
            for (C11696u c11696u : valueParameterList) {
                Intrinsics3.checkNotNullExpressionValue(c11696u, "it");
                arrayList.add(protoTypeTableUtil.type(c11696u, typeTable));
            }
            List listPlus = _Collections.plus((Collection) listListOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                String strM9586a = m9586a((C11692q) it.next(), nameResolver);
                if (strM9586a == null) {
                    return null;
                }
                arrayList2.add(strM9586a);
            }
            String strM9586a2 = m9586a(protoTypeTableUtil.returnType(c11684i, typeTable), nameResolver);
            if (strM9586a2 == null) {
                return null;
            }
            strStringPlus = Intrinsics3.stringPlus(_Collections.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56, null), strM9586a2);
        } else {
            strStringPlus = nameResolver.getString(cVar.getDesc());
        }
        return new JvmMemberSignature.b(nameResolver.getString(name), strStringPlus);
    }

    public static final Tuples2<JvmNameResolver, C11678c> readClassDataFrom(byte[] bArr, String[] strArr) throws IOException {
        Intrinsics3.checkNotNullParameter(bArr, "bytes");
        Intrinsics3.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr), C11678c.parseFrom(byteArrayInputStream, f23721b));
    }

    public static final Tuples2<JvmNameResolver, C11687l> readPackageDataFrom(byte[] bArr, String[] strArr) throws IOException {
        Intrinsics3.checkNotNullParameter(bArr, "bytes");
        Intrinsics3.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr), C11687l.parseFrom(byteArrayInputStream, f23721b));
    }
}
