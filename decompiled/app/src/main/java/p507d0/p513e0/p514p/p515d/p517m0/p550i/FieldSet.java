package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.FieldSet.a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Internal;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyField;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.WireFormat;

/* compiled from: FieldSet.java */
/* renamed from: d0.e0.p.d.m0.i.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class FieldSet<FieldDescriptorType extends a<FieldDescriptorType>> {

    /* renamed from: a */
    public static final FieldSet f24121a = new FieldSet(true);

    /* renamed from: b */
    public final SmallSortedMap2<FieldDescriptorType, Object> f24122b;

    /* renamed from: c */
    public boolean f24123c;

    /* renamed from: d */
    public boolean f24124d = false;

    /* compiled from: FieldSet.java */
    /* renamed from: d0.e0.p.d.m0.i.f$a */
    public interface a<T extends a<T>> extends Comparable<T> {
        WireFormat.c getLiteJavaType();

        WireFormat.b getLiteType();

        int getNumber();

        MessageLite.a internalMergeFrom(MessageLite.a aVar, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    public FieldSet() {
        int i = SmallSortedMap2.f24167j;
        this.f24122b = new SmallSortedMap(16);
    }

    /* renamed from: b */
    public static int m9838b(WireFormat.b bVar, Object obj) {
        switch (bVar.ordinal()) {
            case 0:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 1:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 2:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 6:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 7:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 8:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof ByteString3 ? CodedOutputStream.computeBytesSizeNoTag((ByteString3) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return obj instanceof Internal.a ? CodedOutputStream.computeEnumSizeNoTag(((Internal.a) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: c */
    public static int m9839c(WireFormat.b bVar, boolean z2) {
        if (z2) {
            return 2;
        }
        return bVar.getWireType();
    }

    public static int computeFieldSize(a<?> aVar, Object obj) {
        int iComputeTagSize;
        int iM9838b;
        WireFormat.b liteType = aVar.getLiteType();
        int number = aVar.getNumber();
        if (aVar.isRepeated()) {
            int iM9838b2 = 0;
            if (!aVar.isPacked()) {
                for (Object obj2 : (List) obj) {
                    int iComputeTagSize2 = CodedOutputStream.computeTagSize(number);
                    if (liteType == WireFormat.b.f24200s) {
                        iComputeTagSize2 *= 2;
                    }
                    iM9838b2 += m9838b(liteType, obj2) + iComputeTagSize2;
                }
                return iM9838b2;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iM9838b2 += m9838b(liteType, it.next());
            }
            iComputeTagSize = CodedOutputStream.computeTagSize(number) + iM9838b2;
            iM9838b = CodedOutputStream.computeRawVarint32Size(iM9838b2);
        } else {
            iComputeTagSize = CodedOutputStream.computeTagSize(number);
            if (liteType == WireFormat.b.f24200s) {
                iComputeTagSize *= 2;
            }
            iM9838b = m9838b(liteType, obj);
        }
        return iM9838b + iComputeTagSize;
    }

    public static <T extends a<T>> FieldSet<T> emptySet() {
        return f24121a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m9840f(WireFormat.b bVar, Object obj) {
        Objects.requireNonNull(obj);
        boolean z2 = true;
        boolean z3 = false;
        switch (bVar.getJavaType()) {
            case INT:
                z3 = obj instanceof Integer;
                break;
            case LONG:
                z3 = obj instanceof Long;
                break;
            case FLOAT:
                z3 = obj instanceof Float;
                break;
            case DOUBLE:
                z3 = obj instanceof Double;
                break;
            case BOOLEAN:
                z3 = obj instanceof Boolean;
                break;
            case STRING:
                z3 = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof ByteString3) && !(obj instanceof byte[])) {
                    z2 = false;
                }
                z3 = z2;
                break;
            case ENUM:
                if (!(obj instanceof Integer) && !(obj instanceof Internal.a)) {
                }
                z3 = z2;
                break;
            case MESSAGE:
                if (!(obj instanceof MessageLite) && !(obj instanceof LazyField)) {
                }
                z3 = z2;
                break;
        }
        if (!z3) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* renamed from: g */
    public static void m9841g(CodedOutputStream codedOutputStream, WireFormat.b bVar, int i, Object obj) throws IOException {
        if (bVar == WireFormat.b.f24200s) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i, m9839c(bVar, false));
            m9842h(codedOutputStream, bVar, obj);
        }
    }

    /* renamed from: h */
    public static void m9842h(CodedOutputStream codedOutputStream, WireFormat.b bVar, Object obj) throws IOException {
        switch (bVar.ordinal()) {
            case 0:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 1:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 2:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 3:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 5:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 6:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 7:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 8:
                codedOutputStream.writeStringNoTag((String) obj);
                break;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString3)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString3) obj);
                }
                break;
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof Internal.a)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                } else {
                    codedOutputStream.writeEnumNoTag(((Internal.a) obj).getNumber());
                }
                break;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
        }
    }

    public static <T extends a<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.b bVar, boolean z2) throws IOException {
        switch (bVar.ordinal()) {
            case 0:
                return Double.valueOf(codedInputStream.readDouble());
            case 1:
                return Float.valueOf(codedInputStream.readFloat());
            case 2:
                return Long.valueOf(codedInputStream.readInt64());
            case 3:
                return Long.valueOf(codedInputStream.readUInt64());
            case 4:
                return Integer.valueOf(codedInputStream.readInt32());
            case 5:
                return Long.valueOf(codedInputStream.readFixed64());
            case 6:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 7:
                return Boolean.valueOf(codedInputStream.readBool());
            case 8:
                return z2 ? codedInputStream.readStringRequireUtf8() : codedInputStream.readString();
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return codedInputStream.readBytes();
            case 12:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 15:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 16:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 17:
                return Long.valueOf(codedInputStream.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void writeField(a<?> aVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.b liteType = aVar.getLiteType();
        int number = aVar.getNumber();
        if (!aVar.isRepeated()) {
            if (obj instanceof LazyField) {
                m9841g(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
                return;
            } else {
                m9841g(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!aVar.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                m9841g(codedOutputStream, liteType, number, it.next());
            }
            return;
        }
        codedOutputStream.writeTag(number, 2);
        int iM9838b = 0;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iM9838b += m9838b(liteType, it2.next());
        }
        codedOutputStream.writeRawVarint32(iM9838b);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            m9842h(codedOutputStream, liteType, it3.next());
        }
    }

    /* renamed from: a */
    public final Object m9843a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List arrayList;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        m9840f(fielddescriptortype.getLiteType(), obj);
        Object field = getField(fielddescriptortype);
        if (field == null) {
            arrayList = new ArrayList();
            this.f24122b.put(fielddescriptortype, arrayList);
        } else {
            arrayList = (List) field;
        }
        arrayList.add(obj);
    }

    /* renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m11468clone() throws CloneNotSupportedException {
        return clone();
    }

    /* renamed from: d */
    public final boolean m9844d(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.c.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((MessageLite) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof MessageLite)) {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((MessageLite) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: e */
    public final void m9845e(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(m9843a(it.next()));
            }
            this.f24122b.put(key, field);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.c.MESSAGE) {
            this.f24122b.put(key, m9843a(value));
            return;
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.f24122b.put(key, m9843a(value));
        } else {
            this.f24122b.put(key, key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        }
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f24122b.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field != null) {
            return ((List) field).get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        int iComputeFieldSize = 0;
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.f24122b.getArrayEntryAt(i);
            iComputeFieldSize += computeFieldSize((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iComputeFieldSize += computeFieldSize((a) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f24122b.get(fielddescriptortype) != null;
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            if (!m9844d(this.f24122b.getArrayEntryAt(i))) {
                return false;
            }
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!m9844d((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.f24124d ? new LazyField.c(this.f24122b.entrySet().iterator()) : this.f24122b.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.f24123c) {
            return;
        }
        this.f24122b.makeImmutable();
        this.f24123c = true;
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.f24122b.getNumArrayEntries(); i++) {
            m9845e(fieldSet.f24122b.getArrayEntryAt(i));
        }
        Iterator it = fieldSet.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            m9845e((Map.Entry) it.next());
        }
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            m9840f(fielddescriptortype.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m9840f(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.f24124d = true;
        }
        this.f24122b.put(fielddescriptortype, obj);
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> fieldSetNewFieldSet = newFieldSet();
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.f24122b.getArrayEntryAt(i);
            fieldSetNewFieldSet.setField((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            fieldSetNewFieldSet.setField((a) entry.getKey(), entry.getValue());
        }
        fieldSetNewFieldSet.f24124d = this.f24124d;
        return fieldSetNewFieldSet;
    }

    public FieldSet(boolean z2) {
        int i = SmallSortedMap2.f24167j;
        this.f24122b = new SmallSortedMap(0);
        makeImmutable();
    }
}
